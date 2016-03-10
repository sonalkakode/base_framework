package org.agromart.model;

import java.io.Serializable;


public class BiddingHistory implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1948178346020679578L;

	private int id;
	
	private int farmerId;
	
	private int vendorId;
	
	private int itemId;
	
	private String units;
	
	private int quantity;
	
	private long bidPrice;
	
	private String bidDateTime;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public long getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(long bidPrice) {
		this.bidPrice = bidPrice;
	}

	public int getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(int farmerId) {
		this.farmerId = farmerId;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getBidDateTime() {
		return bidDateTime;
	}

	public void setBidDateTime(String bidDateTime) {
		this.bidDateTime = bidDateTime;
	}
	
}
