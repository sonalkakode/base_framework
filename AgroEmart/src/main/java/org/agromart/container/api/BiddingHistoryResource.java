package org.agromart.container.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.agromart.container.api.schema.BiddingHistoryListType;

@Path("/biddingHistory")
public class BiddingHistoryResource {
	
	@GET @Path("/items/{itemId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public BiddingHistoryListType findByItemId(@PathParam("itemId") String itemId) {
		System.out.println("BiddingHistory:findByItemId");
		return null;
	}

}
