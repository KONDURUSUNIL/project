package com.risha.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risha.dao.ILocationDao;
import com.risha.model.Location;
import com.risha.service.ILocationService;

@Service
public class LocationServiceImpl implements ILocationService {

	@Autowired
	private ILocationDao dao;

	@Override
	public int saveLocation(Location loc) {
		
		return dao.saveLocation(loc);
	}

	@Override
	public void updateLocation(Location loc) {
		dao.updateLocation(loc);
		
	}

	@Override
	public void deleteLocation(int locId) {
			dao.deleteLocation(locId);
		
	}

	@Override
	public Location getLocationById(int locId) {
		
		return dao.getLocationById(locId);
	}

	@Override
	public List<Location> getAllLocations() {
			List<Location> loclist = dao.getAllLocations();
			if (loclist!=null && !loclist.isEmpty()) {
			Collections.sort(loclist);	
			}
		return loclist;
	}

	@Override
	public Location getLocationByName(String locName) {
		
		return dao.getLocationByName(locName);
	}

	@Override
	public List<Object[]> getLocationWiseCount() {
		
		return dao.getLocationWiseCount();
	}
	
}
