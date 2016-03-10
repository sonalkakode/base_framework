package org.agromart.model;

import java.io.Serializable;


public class Item implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5518187087651632433L;

	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String type;
	
	private String name;
	
	private String description;
	
	private String units;
	
	private int quantity;
	
	private long basePrice;
	
	private long bidPrice;
	
	private String sellByDate;
	
	private boolean isSold;
	
	private String createdDate;
	
	private String modifiedDate;
	
	private String imgLink;
	
	private long maxExpectedPrice;
	
	private String auctionStartTime;
	
	private String auctionEndTime;

	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(long basePrice) {
		this.basePrice = basePrice;
	}

	public long getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(long bidPrice) {
		this.bidPrice = bidPrice;
	}

	public String getSellByDate() {
		return sellByDate;
	}

	public void setSellByDate(String sellByDate) {
		this.sellByDate = sellByDate;
	}

	public boolean isSold() {
		return isSold;
	}

	public void setSold(boolean isSold) {
		this.isSold = isSold;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getImgLink() {
		return imgLink;
	}

	public void setImgLink(String imgLink) {
		this.imgLink = imgLink;
	}

	public long getMaxExpectedPrice() {
		return maxExpectedPrice;
	}

	public void setMaxExpectedPrice(long maxExpectedPrice) {
		this.maxExpectedPrice = maxExpectedPrice;
	}

	public String getAuctionStartTime() {
		return auctionStartTime;
	}

	public void setAuctionStartTime(String auctionStartTime) {
		this.auctionStartTime = auctionStartTime;
	}

	public String getAuctionEndTime() {
		return auctionEndTime;
	}

	public void setAuctionEndTime(String auctionEndTime) {
		this.auctionEndTime = auctionEndTime;
	}
	
}
