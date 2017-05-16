package com.risha.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risha.dao.ICustomerDao;
import com.risha.model.Customer;
import com.risha.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private ICustomerDao dao;

	@Override
	public int saveCustomer(Customer cust) {
		
		return dao.saveCustomer(cust);
	}

	@Override
	public void updateCustomer(Customer cust) {
		dao.updateCustomer(cust);

	}

	
	

	@Override
	public Customer getCustomerById(int custId) {
		
		return dao.getCustomerById(custId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		List<Customer> list = dao.getAllCustomers();
		if (list!=null && !list.isEmpty() ) {
			Collections.sort(list);
		}
		return list;
	}

	@Override
	public void deleteCustomer(int custId) {
		dao.deleteCustomer(custId);
		
	}

	

}
