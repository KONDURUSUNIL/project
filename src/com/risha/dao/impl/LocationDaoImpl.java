package com.risha.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.risha.dao.ILocationDao;
import com.risha.model.Location;

@Repository
public class LocationDaoImpl implements ILocationDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public int saveLocation(Location loc) {
		
		return (Integer) hibernateTemplate.save(loc);
	}

	@Override
	public void updateLocation(Location loc) {
		hibernateTemplate.update(loc);
		
	}

	@Override
	public void deleteLocation(int locId) {
		
		hibernateTemplate.delete(new Location(locId));
		
	}

	@Override
	public Location getLocationById(int locId) {
		
		return hibernateTemplate.get(Location.class, locId);
	}

	@Override
	public List<Location> getAllLocations() {
		
		return hibernateTemplate.loadAll(Location.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Location getLocationByName(String locName) {
		
		Location loc = null;
		
		String hql = "from "+Location.class.getName()+" where locName=?";
		List<Location>  locList= hibernateTemplate.find(hql,locName);
		if (locList!=null &&  locList.size()>0){
			loc=locList.get(0);
		}
		return loc;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getLocationWiseCount() {
		
		String hql="select locType,count(locType) from "+Location.class.getName()
				+" group by locType";
		List<Object[]> data=hibernateTemplate.find(hql);
		return data;
	}

	

	
}
