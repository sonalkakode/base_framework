package org.agromart.container.api;


import java.io.FileReader;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



import org.agromart.util.Util;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.sun.jersey.api.client.ClientResponse;



@Path("/analytics/dilemmas")
public class AnalyticsResource {
	private static Logger logger = Logger.getLogger(AnalyticsResource.class);

	// If running locally complete the variables below with the information in VCAP_SERVICES
	private String baseURL = "https://gateway.watsonplatform.net/tradeoff-analytics/api";

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response callTradeoffApi(String inputJson){
		if(null!=inputJson && inputJson.equals("")){
			return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input json").build();
		}
		String url=baseURL+"/v1/dilemmas";
		//Object obj = parser.parse(new FileReader("c:\\test.json"));
		
	//	JSONObject jsonObject = (JSONObject) obj;
		ClientResponse response=Util.postRequest(url, inputJson);
/*		String rawJson=response.getEntity(String.class);
		rawJson=;*/
		String responseJson=response.getEntity(String.class);
		
		return Response.status(response.getStatus()).entity(responseJson).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response testApi(){
		logger.debug("TEST LOG MESSAGE");
		return Response.status(200).entity("TEST OK").build();
	}
	
}
