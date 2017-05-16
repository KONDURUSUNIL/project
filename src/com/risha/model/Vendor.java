package com.risha.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Ven_Tab")
public class Vendor {

	@Id
	@Column(name="ven_id",length=5)
	private Integer id;
	
	@Column(name="ven_name",length=10)
	private String name;
	
	@Column(name="ven_email",length=10)
	private String email;

	@Column(name="ven_addr",length=10)
	private String addr;
	
	@Column(name="ven_gen",length=10)
	private String gen;
	
	@ManyToOne
	@JoinColumn(name="loc_FK")
	private Location loc;
	
	
	

	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getGen() {
		return gen;
	}

	public void setGen(String gen) {
		this.gen = gen;
	}

	public Vendor() {
	
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", email=" + email
				+ ", addr=" + addr + ", gen=" + gen + ", loc=" + loc + "]";
	}

	
	
}
