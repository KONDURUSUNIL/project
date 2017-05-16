package com.risha.dao;

import java.util.List;

import com.risha.model.Vendor;

public interface IVendorDao{
	
	public int saveVendor(Vendor vendor);
	
	public List<Vendor>  getAllVendors();
	
	public void deleteVendor(int id);
	
	public Vendor getVendorById(int id);
	
	public void updateVendor(Vendor vendor);

}
