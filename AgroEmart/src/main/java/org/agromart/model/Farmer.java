package org.agromart.model;

import java.io.Serializable;
import java.util.List;

public class Farmer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1475140041297708880L;

	private int id;
	
	private String name;
	
	private String location;
	
	private String contactNo;
	
	private List<Item> items;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}
