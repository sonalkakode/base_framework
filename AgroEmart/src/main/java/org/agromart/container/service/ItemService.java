package org.agromart.container.service;

import java.util.List;

import org.agromart.container.api.schema.ItemListType;
import org.agromart.container.api.schema.ItemType;
import org.agromart.model.Item;

public interface ItemService {
	
	public ItemListType findAllItems();
//	public List<Item> findAllItemsDocs();
	
	public ItemType findItemById(String id);
	
	public String findBidPriceById(String id);

}
