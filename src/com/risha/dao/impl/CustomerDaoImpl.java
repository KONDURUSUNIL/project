package com.risha.dao.impl;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.risha.dao.ICustomerDao;
import com.risha.model.Customer;


@Repository
public class CustomerDaoImpl implements ICustomerDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public int saveCustomer(Customer cust) {
		
		return (Integer) hibernateTemplate.save(cust);
	}

	@Override
	public void updateCustomer(Customer cust) {
		hibernateTemplate.update(cust);

	}


	@Override
	public Customer getCustomerById(int custId) {
		
		return hibernateTemplate.get(Customer.class, custId);
	}

	@Override
	public List<Customer> getAllCustomers() {
			
		return  hibernateTemplate.loadAll(Customer.class);
	}

	@Override
	public void deleteCustomer(int custId) {
		hibernateTemplate.delete(new Customer(custId));
		
	}

}
