package org.agromart.dao;

import java.util.ArrayList;
import java.util.List;

import org.agromart.container.service.impl.ItemServiceImpl;
import org.agromart.helper.DbConnectionHelper;
import org.agromart.mapper.ItemMapper;
import org.agromart.model.Item;
import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class ItemDAO {
	private static Logger logger = Logger.getLogger(ItemDAO.class);

	/*FarmerDAO farmerDAO = new FarmerDAO();*/
	/*public static void main(String args[]){
		ItemDAO iDao=new ItemDAO();
		iDao.findAll();
	}*/
	/*public List<Item> findAllDocs() {
		logger.debug("ItemDAO");
		
		DbConnectionHelper dbInstance=DbConnectionHelper.getInstance();
		DBCursor curs=dbInstance.getDocuments("farmer");
		
		List<Item> itemList = new ArrayList<Item>();
		while(curs.hasNext()) {
			  DBObject o = curs.next();

			  // shows the whole result document
			//  System.out.println(o.toString());
			  BasicDBList items = (BasicDBList) o.get("items");

			  // shows the lights array -- this is actually a collection of DBObjects
			 // System.out.println(items.toString());

			  // optional: break it into a native java array
			  BasicDBObject[] itemArray = items.toArray(new BasicDBObject[0]);
			  

			  for(BasicDBObject dbObj : itemArray) {
			    // shows each item from the lights array
				  ItemMapper itemMapper= new ItemMapper();
				  Item item = itemMapper.toItem(dbObj);
				  
				  itemList.add(item);
				  
			    System.out.println(dbObj);
			  }
		
		
}
		
        return itemList;
    }*/
	
	
	public List<Item> findAll() {
		logger.debug("ItemDAO");
		
		
		List<Item> items = new ArrayList<Item>();
		Item item = new Item();
		item.setId(1002);
		item.setType("Vegetable");
		item.setName("Onion");
		item.setBasePrice(new Long(600));
		item.setBidPrice(new Long(0));
		item.setQuantity(10);
		item.setUnits("Kilograms");
		item.setImgLink("https://www.ricoh.com/r_dc/caplio/r7/img/sample_04.jpg");
		item.setDescription("harvested on 1st March");
		item.setAuctionStartTime("2016-03-03 10:00:00");
		item.setAuctionEndTime("2016-03-03 11:00:00");
		item.setCreatedDate("2016-03-03 00:00:00");
		item.setModifiedDate("2016-03-03 00:00:00");
		item.setMaxExpectedPrice(new Long(900));
		item.setSellByDate("2016-03-06 00:00:00");
		item.setSold(false);
		items.add(item);
		item = new Item();
		item.setId(1001);
		item.setType("Vegetable");
		item.setName("Potato");
		item.setBasePrice(new Long(500));
		item.setBidPrice(new Long(0));
		item.setQuantity(10);
		item.setUnits("Tonnes");
		item.setImgLink("https://www.ricoh.com/r_dc/caplio/r7/img/sample_04.jpg");
		item.setDescription("harvested on 2nd March");
		item.setAuctionStartTime("2016-03-03 10:00:00");
		item.setAuctionEndTime("2016-03-03 11:00:00");
		item.setCreatedDate("2016-03-03 00:00:00");
		item.setModifiedDate("2016-03-03 00:00:00");
		item.setMaxExpectedPrice(new Long(700));
		item.setSellByDate("2016-03-06 00:00:00");
		item.setSold(false);
		items.add(item);
        return items;
    }
	
	public Item findById(String id) {
		List<Item> items = findAll();
		for (Item item : items) {
			if(item.getId() == Integer.valueOf(id)){
				return item;
			}
		}
        return null;
    }
	

}
