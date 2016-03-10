package org.agromart.container.api;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.agromart.container.api.schema.ItemListType;
import org.agromart.container.api.schema.ItemType;
import org.agromart.container.service.ItemService;
import org.agromart.container.service.impl.ItemServiceImpl;
import org.apache.log4j.Logger;

import com.google.gson.Gson;

@Path("/items")
public class ItemsResource {
	private static Logger logger = Logger.getLogger(ItemsResource.class);

	ItemService itemService = new ItemServiceImpl();
	@GET
	@Path("/test")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response testMethod() {
		logger.info("testMethod");
		/*ItemListType itemList=itemService.findAllItems();
		String result=new Gson().toJson(itemList);
		logger.debug(" testMethod :"+result);*/
		
		return Response.status(Response.Status.OK).entity("TEST").build();
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ItemListType findAll() {
		logger.info("Items:findAll");
		ItemListType itemList=itemService.findAllItems();
		logger.debug("Item List :"+new Gson().toJson(itemList));
		return itemList;
	}
	
	@PUT
	@Path("{id}/price")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response updateBidPrice(@PathParam("id") String id,String input) {
		logger.info("updateBidPrice");
		
		
		return Response.status(Response.Status.OK).entity("(Test Response)Bid price updated for id:"+id).build();
	}
	
	@GET @Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ItemType findById(@PathParam("id") String id) {
		logger.info("Items:findById");
		return itemService.findItemById(id);
	}
	
	@GET @Path("{id}/price")
	@Produces({ MediaType.TEXT_PLAIN })
	public String findBidPriceById(@PathParam("id") String id) {
		logger.info("Items:findBidPriceById");
		return itemService.findBidPriceById(id);
	}
}
