package org.agromart.container.service.impl;

import java.util.List;

import org.agromart.container.api.schema.ItemListType;
import org.agromart.container.api.schema.ItemType;
import org.agromart.container.service.FarmerService;
import org.agromart.dao.FarmerDAO;
import org.agromart.mapper.ItemMapper;
import org.agromart.model.Farmer;
import org.agromart.model.Item;

public class FarmerServiceImpl implements FarmerService{
	
	FarmerDAO farmerDao = new FarmerDAO();

	@Override
	public ItemListType getItemsByFarmerId(String farmerId) {
		Farmer farmer = farmerDao.findById(Integer.valueOf(farmerId));
		List<Item> items = farmer.getItems();
		ItemListType itemList = new ItemListType();
		ItemMapper mapper = new ItemMapper();
		for (Item item : items) {
			ItemType itemType = mapper.getItemType(item);
			itemList.getItems().add(itemType);
		}
		
		return itemList;
	}

}
