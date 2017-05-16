package com.risha.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.risha.dao.IVendorDao;
import com.risha.model.Vendor;

@Repository
public class VendorDaoImpl implements IVendorDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
 	
	@Override
	public int saveVendor(Vendor vendor) {
		
		return (Integer) hibernateTemplate.save(vendor);
	
	}
	
	@Override
	public List<Vendor> getAllVendors() {
		
		return hibernateTemplate.loadAll(Vendor.class);
	}
	
	@Override
	public void deleteVendor(int id) {
			Vendor v =new Vendor();
			v.setId(id);
			hibernateTemplate.delete(v);
		
	}
	
	@Override
	public Vendor getVendorById(int id) {
		
		return hibernateTemplate.get(Vendor.class, id);
	}

	@Override
	public void updateVendor(Vendor vendor) {
	
		hibernateTemplate.update(vendor);
	}

}
