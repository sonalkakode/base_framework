package org.agromart.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.client.urlconnection.HttpURLConnectionFactory;
import com.sun.jersey.client.urlconnection.URLConnectionClientHandler;
import com.sun.jersey.core.util.Base64;

public class Util {
	private static String username = "d63ce53e-48cf-4db4-8ac9-0559fb378844";
	private static String password = "9WXTbzxC2kZy";
	
	public static Client getClient() {
		ClientConfig clientConfig = new DefaultClientConfig();

		Client client = new Client(new URLConnectionClientHandler(
				new HttpURLConnectionFactory() {
					Proxy p = null;

					public HttpURLConnection getHttpURLConnection(URL url)
							throws IOException {
						if (p == null) {
							p = new Proxy(Proxy.Type.HTTP,
									new InetSocketAddress(
											"goaproxy.persistent.co.in", 80));
						}
						return (HttpURLConnection) url.openConnection(p);
					}
				}), clientConfig);
		return client;
	}

	public static ClientResponse getRequest(String url) {

		WebResource resource = getClient().resource(url);
		

		resource.accept(MediaType.APPLICATION_JSON);
		return resource.get(ClientResponse.class);
	}

	public static ClientResponse postRequest(String url, String body) {

		WebResource resource = getClient().resource(url);
		String authString = getAuthHeaderValue(username, password);
		ClientResponse reponse = resource.accept(MediaType.APPLICATION_JSON)
				.type(MediaType.APPLICATION_JSON)
				.header("Authorization", "Basic " + authString)
				.post(ClientResponse.class, body);
		return reponse;
	}

	public static ClientResponse putRequest(String url, String body) {

		WebResource resource = getClient().resource(url);
		ClientResponse reponse = resource.accept(MediaType.APPLICATION_JSON)
				.type(MediaType.APPLICATION_JSON)
				.put(ClientResponse.class, body);
		return reponse;
	}

	
	public static String getAuthHeaderValue(String user,String pass) {

		  String auth = new String(Base64.encode((user+":"+pass).getBytes()));
		  
		  return auth;
		}
	public static JsonObject getJsonObject(ClientResponse response) {

		String jsonObj = response.getEntity(String.class);
		JsonElement jelement = new JsonParser().parse(jsonObj);
		JsonObject jsonObject = jelement.getAsJsonObject();
		return jsonObject;
	}

	public static Map<String, String> getMapFromJson(JsonObject jsonObject,
			String elementName) {

		JsonElement element = jsonObject.get(elementName);
		if (null != element) {
			@SuppressWarnings("unchecked")
			Map<String, String> maps = new Gson().fromJson(element.toString(),
					Map.class);
			return maps;
		} else {
			return null;
		}
	}

	public static String getJsonStringElement(String jsonString,
			String elementName) {
		JsonElement jelement = new JsonParser().parse(jsonString);
		JsonObject jsonObject = jelement.getAsJsonObject();
		JsonElement element = jsonObject.get(elementName);
		if (null != element) {
			return element.getAsString();
		} else {
			return null;
		}
	}

}
