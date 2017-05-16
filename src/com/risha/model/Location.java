package com.risha.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loc_tab")
public class Location  implements Comparable<Location>{

	@ Id
	@Column(name="l_id",length=10)
	private Integer locId;
	
	@Column(name="l_name",length=10)
	private String locName;
	
	@Column(name="l_loctype",length=10)
	private String locType;
	
	@Column(name="l_locsup",length=10)
	private String locSup;
	
	@Column(name="l_locadv",length=10)
	private String locAdv;
	
	@Column(name="l_locsta",length=10)
	private String locSta;
	
	@Column(name="l_loccou",length=10)
	private String locCou;
	
	@Column(name="l_locpin",length=10)
	private Double locPin;
	
	public Double getLocPin() {
		return locPin;
	}


	public void setLocPin(Double locPin) {
		this.locPin = locPin;
	}


	public String getLocCou() {
		return locCou;
	}


	public void setLocCou(String locCou) {
		this.locCou = locCou;
	}


	public String getLocSta() {
		return locSta;
	}


	public void setLocSta(String locSta) {
		this.locSta = locSta;
	}


	public String getLocAdv() {
		return locAdv;
	}


	public void setLocAdv(String locAdv) {
		this.locAdv = locAdv;
	}


	public Location() {
		
	}
	

	public Location(Integer locId) {
		super();
		this.locId = locId;
	}


	public Integer getLocId() {
		return locId;
	}

	public void setLocId(Integer locId) {
		this.locId = locId;
	}

	public String getLocName() {
		return locName;
	}

	public void setLocName(String locName) {
		this.locName = locName;
	}

	public String getLocType() {
		return locType;
	}

	public void setLocType(String locType) {
		this.locType = locType;
	}

	
	
	
	public String getLocSup() {
		return locSup;
	}


	public void setLocSup(String locSup) {
		this.locSup = locSup;
	}


	
	


	@Override
	public String toString() {
		return "Location [locId=" + locId + ", locName=" + locName
				+ ", locType=" + locType + ", locSup=" + locSup + ", locAdv="
				+ locAdv + ", locSta=" + locSta + ", locCou=" + locCou
				+ ", locPin=" + locPin + "]";
	}


	@Override
	public int compareTo(Location o) {
		
		return this.locId-o.locId;
	}
	
}
