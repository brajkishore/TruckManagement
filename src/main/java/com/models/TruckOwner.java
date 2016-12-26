/**
 * 
 */
package com.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author braj.kishore
 *
 */
public class TruckOwner {

	private long uuid;
	private String name;
	private List<Truck> availableTrucks=new ArrayList<>();
	private List<Truck> tripingTrucks=new ArrayList<>();
	private List<Trip> finishedTrips=new ArrayList<>();
	private Map<Long,Truck> totalTrucks=new HashMap<Long,Truck>();
	
	public TruckOwner(String name){
		this.name=name;
		this.uuid=System.currentTimeMillis();
	}
	
	public TruckOwner(){
		
	}
	
	
	/**
	 * @return the uuid
	 */
	public long getUuid() {
		return uuid;
	}
	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(long uuid) {
		this.uuid = uuid;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the availableTrucks
	 */
	public List<Truck> getAvailableTrucks() {
		return availableTrucks;
	}
	/**
	 * @param availableTrucks the availableTrucks to set
	 */
	public void setAvailableTrucks(List<Truck> availableTrucks) {
		this.availableTrucks = availableTrucks;
	}
	/**
	 * @return the tripingTrucks
	 */
	public List<Truck> getTripingTrucks() {
		return tripingTrucks;
	}
	/**
	 * @param tripingTrucks the tripingTrucks to set
	 */
	public void setTripingTrucks(List<Truck> tripingTrucks) {
		this.tripingTrucks = tripingTrucks;
	}
	/**
	 * @return the finishedTrips
	 */
	public List<Trip> getFinishedTrips() {
		return finishedTrips;
	}
	/**
	 * @param finishedTrips the finishedTrips to set
	 */
	public void setFinishedTrips(List<Trip> finishedTrips) {
		this.finishedTrips = finishedTrips;
	}


	public Map<Long,Truck> getTotalTrucks() {
		return totalTrucks;
	}


	public void setTotalTrucks(Map<Long,Truck> totalTrucks) {
		this.totalTrucks = totalTrucks;
	}


	
}
