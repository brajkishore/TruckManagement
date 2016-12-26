/**
 * 
 */
package com.models;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author braj.kishore
 *
 */
public class Trip {
	
	public Trip(Long truckId,Date startTime,Date expectedEndTime,Location startLoc,Location endLoc){
		
		this.setTruckId(truckId);
		this.startTime=startTime;
		this.expectedEndTime=expectedEndTime;
		this.startLoc=startLoc;
		this.endLoc=endLoc;		
	}
	
	
	public Trip(){
		
	}
	private long uuid;
	private long truckId;
	private Date startTime,expectedEndTime;
	private Location startLoc,endLoc;
	private TripState currentState;
	private BigDecimal cost;
	
	
	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the expectedEndTime
	 */
	public Date getExpectedEndTime() {
		return expectedEndTime;
	}
	/**
	 * @param expectedEndTime the expectedEndTime to set
	 */
	public void setExpectedEndTime(Date expectedEndTime) {
		this.expectedEndTime = expectedEndTime;
	}
	/**
	 * @return the startLoc
	 */
	public Location getStartLoc() {
		return startLoc;
	}
	/**
	 * @param startLoc the startLoc to set
	 */
	public void setStartLoc(Location startLoc) {
		this.startLoc = startLoc;
	}
	/**
	 * @return the endLoc
	 */
	public Location getEndLoc() {
		return endLoc;
	}
	/**
	 * @param endLoc the endLoc to set
	 */
	public void setEndLoc(Location endLoc) {
		this.endLoc = endLoc;
	}
	/**
	 * @return the currentState
	 */
	public TripState getCurrentState() {
		return currentState;
	}
	/**
	 * @param currentState the currentState to set
	 */
	public void setCurrentState(TripState currentState) {
		this.currentState = currentState;
	}
	/**
	 * @return the cost
	 */
	public BigDecimal getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public long getUuid() {
		return uuid;
	}
	public void setUuid(long uuid) {
		this.uuid = uuid;
	}
	public long getTruckId() {
		return truckId;
	}
	public void setTruckId(long truckId) {
		this.truckId = truckId;
	}
	
	
	
	
}
