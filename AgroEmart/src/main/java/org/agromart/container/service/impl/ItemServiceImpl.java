package org.agromart.container.service.impl;

import java.util.List;

import org.agromart.container.api.schema.ItemListType;
import org.agromart.container.api.schema.ItemType;
import org.agromart.container.service.ItemService;
import org.agromart.dao.ItemDAO;
import org.agromart.mapper.ItemMapper;
import org.agromart.model.Item;
import org.apache.log4j.Logger;

import com.google.gson.Gson;

public class ItemServiceImpl implements ItemService{
	private static Logger logger = Logger.getLogger(ItemServiceImpl.class);

	ItemDAO itemDao = new ItemDAO();

	@Override
	public ItemListType findAllItems() {
		logger.debug("Item service Impl");
		List<Item> items = itemDao.findAll();
		ItemListType itemList = new ItemListType();
		ItemMapper mapper = new ItemMapper();
		for (Item item : items) {
			ItemType itemType = mapper.getItemType(item);
			itemList.getItems().add(itemType);
		}
		logger.debug("Item service Impl:"+new Gson().toJson(itemList));
		logger.debug("Item service Impl-E");

		return itemList;
	}
	
	/*@Override
	public List<Item> findAllItemsDocs() {
		logger.debug("Item service Impl");
		
		return itemDao.findAllDocs();
		
	

	}*/

	@Override
	public ItemType findItemById(String id) {
		Item item = itemDao.findById(id);
		ItemMapper mapper = new ItemMapper();
		ItemType itemType =mapper.getItemType(item);
		return itemType;
	}

	@Override
	public String findBidPriceById(String id) {
		Item item = itemDao.findById(id);
		ItemMapper mapper = new ItemMapper();
		ItemType itemType =mapper.getItemType(item);
		return itemType.getBidPrice();
	}

}
