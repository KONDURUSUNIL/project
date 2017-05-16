package com.risha.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.risha.model.Location;
import com.risha.service.ILocationService;

@Component
public class LocationValidator {

	
	@Autowired
	private ILocationService service;


	public String doValidateLocName(String locName){
		
		String str = null;
		
		Location locationByName = service.getLocationByName(locName);
		if(locationByName!=null){
			str = "Location Name '"+locName+"' already exist in database"; 
		}
		return str;
	}


}
