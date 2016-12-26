/**
 * 
 */
package com.models;

/**
 * @author braj.kishore
 *
 */
public class Truck {

	private Long uuid;
	private int capacity;
	private Location currentTruckLoc;
	private Trip currentTrip;
	private TripState currentTruckState;
	private String regNum;
	private Long truckOwnerId;
	
	
	public Truck(String regNum)
	{
		this.regNum=regNum;
		this.uuid=System.currentTimeMillis();
	}
	
	public Truck()
	{
		
	}


	/**
	 * @return the uuid
	 */
	public Long getUuid() {
		return uuid;
	}


	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}


	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}


	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	/**
	 * @return the currentTruckLoc
	 */
	public Location getCurrentTruckLoc() {
		return currentTruckLoc;
	}


	/**
	 * @param currentTruckLoc the currentTruckLoc to set
	 */
	public void setCurrentTruckLoc(Location currentTruckLoc) {
		this.currentTruckLoc = currentTruckLoc;
	}


	/**
	 * @return the currentTrip
	 */
	public Trip getCurrentTrip() {
		return currentTrip;
	}


	/**
	 * @param currentTrip the currentTrip to set
	 */
	public void setCurrentTrip(Trip currentTrip) {
		this.currentTrip = currentTrip;
	}


	/**
	 * @return the currentTruckState
	 */
	public TripState getCurrentTruckState() {
		return currentTruckState;
	}


	/**
	 * @param currentTruckState the currentTruckState to set
	 */
	public void setCurrentTruckState(TripState currentTruckState) {
		this.currentTruckState = currentTruckState;
	}


	/**
	 * @return the regNum
	 */
	public String getRegNum() {
		return regNum;
	}


	/**
	 * @param regNum the regNum to set
	 */
	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Truck)) {
			return false;
		}
		Truck other = (Truck) obj;
		if (uuid == null) {
			if (other.uuid != null) {
				return false;
			}
		} else if (!uuid.equals(other.uuid)) {
			return false;
		}
		return true;
	}


	public Long getTruckOwnerId() {
		return truckOwnerId;
	}


	public void setTruckOwnerId(Long truckOwnerId) {
		this.truckOwnerId = truckOwnerId;
	}
	
	
	
	

	
}
