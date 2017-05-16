package com.risha.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risha.dao.IVendorDao;
import com.risha.model.Vendor;
import com.risha.service.IVendorService;

@Service
public class VendorServiceImpl implements IVendorService {
	
	@Autowired
	private IVendorDao dao;

	@Override
	public int saveVendor(Vendor vendor) {
	
		return dao.saveVendor(vendor);
		
	}
	
	@Override
	public List<Vendor> getAllVendors() {
		
		return dao.getAllVendors();
	}
	
	@Override
	public void deleteVendor(int id) {
		dao.deleteVendor(id);
		
	}

	@Override
	public Vendor getVendorById(int id) {
		
		return dao.getVendorById(id);
	}

	@Override
	public void updateVendor(Vendor vendor) {
		dao.updateVendor(vendor);
		
	}
	
}
