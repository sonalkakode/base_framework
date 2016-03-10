package org.agromart.model;

import java.io.Serializable;

public class Vendor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8498258684194841296L;

	private int id;
	
	private String name;
	
	private String contactNo;
	

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

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

}
