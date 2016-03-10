package org.agromart.container.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.agromart.container.api.schema.ItemListType;
import org.agromart.container.service.FarmerService;
import org.agromart.container.service.impl.FarmerServiceImpl;

@Path("/farmers")
public class FarmerResource {
	
	FarmerService farmerService = new FarmerServiceImpl();
	
	@GET @Path("{farmerId}/items")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ItemListType findItemsByFarmerId(@PathParam("farmerId") String farmerId) {
		System.out.println("findItemsByFarmerId");
		return farmerService.getItemsByFarmerId(farmerId);
	}

}
