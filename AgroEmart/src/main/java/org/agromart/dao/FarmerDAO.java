package org.agromart.dao;

import java.util.ArrayList;
import java.util.List;

import org.agromart.model.Farmer;

public class FarmerDAO {
	
	ItemDAO itemDAO = new ItemDAO();
	
	public Farmer findById(int id){
		List<Farmer> farmers = findAll();
		for (Farmer farmer : farmers) {
			if(farmer.getId() ==  id){
				return farmer;
			}
		}
		return null;
	}
	
	public List<Farmer> findAll(){
		List<Farmer> farmers = new ArrayList<Farmer>();
		Farmer farmer = new Farmer();
		farmer.setId(1);
		farmer.setName("Dhondu");
		farmer.setLocation("Pernem");
		farmer.setContactNo("993242477");
		farmer.setItems(itemDAO.findAll());
		farmers.add(farmer);
		return farmers;
	}

}
