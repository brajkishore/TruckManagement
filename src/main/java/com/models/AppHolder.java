/**
 * 
 */
package com.models;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Component;

/**
 * @author braj.kishore
 *
 */


@Component("appHolder")
public class AppHolder {

	private ConcurrentMap<Long,TruckOwner> owners=new ConcurrentHashMap<>();
	private ConcurrentMap<Long,Trip> trips=new ConcurrentHashMap<>();

	/**
	 * @return the owners
	 */
	public ConcurrentMap<Long, TruckOwner> getOwners() {
		
		System.out.println("owners::"+owners);
		return owners;
	}

	/**
	 * @param owners the owners to set
	 */
	public void setOwners(ConcurrentMap<Long, TruckOwner> owners) {
		this.owners = owners;
		
		System.out.println("owners::"+owners);
	}

	public ConcurrentMap<Long,Trip> getTrips() {
		return trips;
	}

	public void setTrips(ConcurrentMap<Long,Trip> trips) {
		this.trips = trips;
	}
	
	
	
	
	
	
	
}
