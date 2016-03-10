package org.agromart.util;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.sun.jersey.core.util.Base64;



/**
 * The Class HttpConnectionUtil.
 */
public class HttpConnectionUtil {
	
	/** The Constant CONTENT_TYPE. */
	public static final String CONTENT_TYPE = "Content-Type";
	
	/** The Constant ACCEPT. */
	public static final String ACCEPT = "Accept";
	
	/** The Constant AUTH_HEADER. */
	public static final String AUTH_HEADER = "Authorization";
	
	/** The status code. */
	protected int statusCode = -1;
	
	/** The response. */
	protected String response = null;
	
	/** The request data. */
	private String requestData = null;
	
	/** The encoded credentials. */
	private String encodedCredentials = null;
	
	/** The proxy host. */
	private String proxyHost = null;
	
	/** The proxy port. */
	private int proxyPort = 0;
	
	/** The headers. */
	protected Map<String, String> requestHeaders = new HashMap<String, String>();

	/** The response headers. */
	private Map<String, String> responseHeaders = new HashMap<String, String>();

	/** The proxy type. */
	private Type proxyType = Type.HTTP;

	
	/**
	 * Instantiates a new method handler.
	 */
	public HttpConnectionUtil() {
		requestHeaders.put(CONTENT_TYPE, "application/xml");		
		requestHeaders.put(ACCEPT, "application/xml");		
	}
	
	/**
	 * Reset request headers.
	 */
	public void resetRequestHeaders() {
		requestHeaders.clear();		
	}


	/**
	 * Adds the request.
	 *
	 * @param request the request
	 */
	public void addRequest(String request) {
		this.requestData = request;
	}
	
	/**
	 * Adds the auth header.
	 *
	 * @param username the username
	 * @param password the password
	 */
	public void addAuthHeader(String username, String password) {		
		String authString = username + ":" + password;
		if(authString != null) {
			byte[] authEncBytes = Base64.encode(authString.getBytes());
			String authStringEnc = new String(authEncBytes);	
			this.encodedCredentials = authStringEnc;
		}
	}
	
	
	/**
	 * Adds the proxy.
	 *
	 * @param host the host
	 * @param port the port
	 */
	public void addProxy(String host, int port) {
		this.proxyHost = host;
		this.proxyPort = port;		
	}
	
	/**
	 * Adds the request header.
	 *
	 * @param header the header
	 * @param value the value
	 */
	public void addRequestHeader(String header, String value){
		requestHeaders.put(header, value);
	}

	/* (non-Javadoc)
	 * @see com.ibm.gts.common.http.HTTPHandler#setContentType(java.lang.String)
	 */
	/**
	 * Sets the content type.
	 *
	 * @param contentType the new content type
	 */
	public void setContentType(String contentType) {
		requestHeaders.put(CONTENT_TYPE, contentType);		
	}

	/**
	 * Sets the accept.
	 *
	 * @param accept the new accept
	 */
	public void setAccept(String accept) {
		requestHeaders.put(ACCEPT, accept);		
	}
	
	/**
	 * Sets the integration Group
	 * @param intrGrp
	 */
	public void setIntegrationGroup(String intrGrp) {
		requestHeaders.put("integrationGroupUUID", intrGrp);
	}
	
	/**
	 * Gets the response.
	 *
	 * @return the response
	 */
	public String getResponse() {		
		return response;
	}

	/**
	 * Gets the status code.
	 *
	 * @return the status code
	 */
	public int getStatusCode() {		
		return statusCode;
	}
	
	/**
	 * Gets the response headers.
	 *
	 * @return the response headers
	 */
	public Map<String, String> getResponseHeaders() {
		return responseHeaders ;
	}
	
	/**
	 * Gets the basic auth header.
	 *
	 * @return the basic auth header
	 */
	public String getBasicAuthHeader() {
		return encodedCredentials;
	}
	
	/**
	 * Execute post.
	 *
	 * @param connectUrl the connect url
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void executePOST(String connectUrl) throws IOException {
		execute(connectUrl, "POST");
	}
	
	/**
	 * Execute get.
	 *
	 * @param connectUrl the connect url
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void executeGET(String connectUrl) throws IOException {
		execute(connectUrl, "GET");
	}

	/**
	 * Execute.
	 *
	 * @param connectUrl the connect url
	 * @param method the method
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void execute(String connectUrl, String method) throws IOException {
		System.out.println("system url:"+connectUrl);
		HttpURLConnection urlConnection = null;
		InputStream is = null;
		try {
			URL url = new URL(connectUrl);
			
			if(proxyHost != null) {
				Proxy proxy = new Proxy(proxyType, new InetSocketAddress(proxyHost, proxyPort));
				urlConnection = (HttpURLConnection) url.openConnection(proxy);
			} else {
				urlConnection = (HttpURLConnection) url.openConnection();
			}
			

			urlConnection.setRequestMethod(method);						
			
			//add request headers if any
			if(requestHeaders != null && requestHeaders.size() > 0) {
				for (Entry<String, String> headerEntry : requestHeaders.entrySet()) {
					urlConnection.setRequestProperty(headerEntry.getKey(), headerEntry.getValue());
				}
			}
			
			String basicAuth = getBasicAuthHeader();
			if(basicAuth != null && basicAuth.trim().length() > 0) {
				urlConnection.setRequestProperty("Authorization", "Basic " + basicAuth);
			}	
			
			// sent the data if exists
			// on bluemix if null request is passed then 411 is returned (PUT method)
			System.out.println("Request:"+requestData);
			if (requestData == null && !"GET".equalsIgnoreCase(method)){
				requestData = "";
			}
			if (requestData != null) {
				urlConnection.setRequestProperty("Content-Length", String.valueOf(requestData.length()));
				urlConnection.setDoOutput(true);
				DataOutputStream wr = new DataOutputStream(
						urlConnection.getOutputStream());
				wr.write(requestData.getBytes());
				wr.flush();
				wr.close();
			}
			
			statusCode = urlConnection.getResponseCode();	
			System.out.println("status code:"+statusCode);
			Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
			Set<Entry<String,List<String>>> entrySet = headerFields.entrySet();
			
			for (Entry<String, List<String>> headerEntry : entrySet) {
				if (headerEntry != null && headerEntry.getKey() != null && headerEntry.getValue().size() > 0) {
					String key = headerEntry.getKey();
					List<String> value = headerEntry.getValue();
					responseHeaders.put(key.toLowerCase(), value.get(value.size() - 1));
				}
			}
				
			if (statusCode != 200) {
				is = urlConnection.getErrorStream();
			} else {
				is = urlConnection.getInputStream();
			}
			if(is!=null){
				InputStreamReader isr = new InputStreamReader(is);
				int numCharsRead;
				char[] charArray = new char[1024];
				StringBuffer sb = new StringBuffer();
				while ((numCharsRead = isr.read(charArray)) > 0) {
					sb.append(charArray, 0, numCharsRead);
				}
				isr.close();
				response = sb.toString();
			}					
		
		} finally {
			if(is != null) {
				is.close();
				is = null;
			}
			if(urlConnection != null) {
				urlConnection.disconnect();
				urlConnection = null;
			}
		}		
	}
	
	/**
	 * Gets the request charset.
	 *
	 * @return the request charset
	 *//*
	private Charset getRequestCharset() {
		Charset returnCharset = StandardCharsets.UTF_8;
		if (requestHeaders.containsKey(CONTENT_TYPE)) {
			String contentType = requestHeaders.get(CONTENT_TYPE);
			Matcher matcher = charsetpattern.matcher(contentType);
			boolean find = matcher.find();
			if (find) {
				String charset = contentType.substring(matcher.start(1), matcher.end(1));
				if (Charset.availableCharsets().keySet().contains(charset) && Charset.isSupported(charset)) {
					returnCharset = Charset.forName(charset);
				}
			}
		} 
		return returnCharset;
	}*/
}
