package org.agromart.mapper;

import org.agromart.container.api.schema.ItemType;
import org.agromart.model.Item;

import com.mongodb.BasicDBObject;

public class ItemMapper {
	
	public ItemType getItemType(Item item){
		ItemType itemType = new ItemType();
		itemType.setItemId(item.getId());
		itemType.setType(item.getType());
		itemType.setName(item.getName());
		itemType.setDescription(item.getDescription());
		itemType.setBasePrice(String.valueOf(item.getBasePrice()));
		itemType.setBidPrice(String.valueOf(item.getBidPrice()));
		itemType.setUnits(item.getUnits());
		itemType.setQuantity(item.getQuantity());
		itemType.setAuctionEndDateTime(String.valueOf(item.getAuctionEndTime()));
		itemType.setAuctionStartDateTime(String.valueOf(item.getAuctionStartTime()));
		itemType.setMaxExpectedPrice(String.valueOf(item.getMaxExpectedPrice()));
		itemType.setCreatedDate(String.valueOf(item.getCreatedDate()));
		itemType.setModifiedDate(String.valueOf(item.getModifiedDate()));
		itemType.setSold(item.isSold());
		itemType.setSellByDate(String.valueOf(item.getSellByDate()));
		itemType.setImgLink(String.valueOf(item.getImgLink()));
		return itemType;
	}

	/*public Item toItem(BasicDBObject object){
		Item item = new Item();
		item.setId(object.getString("id"));
		item.setType(object.getString("type"));
		item.setName(object.getString("name"));
		item.setDescription(object.getString("description"));
		item.setBasePrice(object.getLong("base_price"));
		item.setBidPrice(object.getLong("bid_price"));
		item.setUnits(object.getString("units"));
		item.setQuantity(object.getInt("quantity"));
		item.setAuctionEndTime(object.getString("auction_slot.end_date_time"));
		item.setAuctionStartTime(object.getString("auction_slot.start_date_time"));
		item.setMaxExpectedPrice(object.getLong("max_expected_price"));
		item.setCreatedDate(object.getString("created_date"));
		item.setModifiedDate(object.getString("modified_date"));
		item.setSold(object.getBoolean("is_sold"));
		item.setSellByDate(object.getString("sell_by_date"));
		item.setImgLink(object.getString("image"));
		return item;
	}*/
}
