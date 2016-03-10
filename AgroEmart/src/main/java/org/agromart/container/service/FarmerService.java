package org.agromart.container.service;

import org.agromart.container.api.schema.ItemListType;

public interface FarmerService {
	
	public ItemListType getItemsByFarmerId(String farmerId);

}
