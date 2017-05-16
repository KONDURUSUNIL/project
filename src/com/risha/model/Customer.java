package com.risha.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cust_tab")
public class Customer implements Comparable<Customer> {
	
	@Id
	@Column(name="c_id",length=5)
	private Integer custId;
	
	@Column(name="c_name",length=10)
	private String custName;
	
	@Column(name="c_type",length=10)
	private String custType;
	
	@Column(name="c_email",length=10)
	private String custEmail;
	
	@Column(name="c_addr",length=10)
	private String custAddr;
	
	@Column(name="c_mob",length=10)
	private Double custMob;

	public Customer() {
	
	}

	public Customer(Integer custId) {
	
		this.custId = custId;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustAddr() {
		return custAddr;
	}

	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}

	public Double getCustMob() {
		return custMob;
	}

	public void setCustMob(Double custMob) {
		this.custMob = custMob;
	}

	@Override
	public int compareTo(Customer o) {
		
		return this.custId-o.custId;
	}
	
}
