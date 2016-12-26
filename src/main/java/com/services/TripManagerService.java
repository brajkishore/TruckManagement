/**
 * 
 */
package com.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.models.AppHolder;
import com.models.Trip;
import com.models.TripState;
import com.models.Truck;
import com.models.TruckOwner;

/**
 * @author braj.kishore
 *
 */

@Service("tripManagerService")
public class TripManagerService {

	
	@Resource(name="appHolder")
	AppHolder appHolder;
	
	
	public List<Trip> getAllTrips() {
		// TODO Auto-generated method stub
		
		if(appHolder.getTrips().size()>0)
		{
			List<Trip> trips=new ArrayList<Trip>();
			for(Trip trip:appHolder.getTrips().values())
				trips.add(trip);
				
			return trips;
		}
		return null;
	}

	
	private Truck getTruck(long truckId)
	{
		if(appHolder.getOwners()!=null){
		
		for(TruckOwner owner:appHolder.getOwners().values())
			if(owner.getAvailableTrucks()!=null && owner.getTotalTrucks().containsKey(truckId) )
				return owner.getTotalTrucks().get(truckId);
		}
		
		return null;
	}
	
	private TruckOwner getOwner(long ownerId)
	{
		if(appHolder.getOwners()!=null){
		
		for(TruckOwner owner:appHolder.getOwners().values())
			if(owner.getUuid()==ownerId )
				return owner;
		}
		
		return null;
	}
	
	
	
	public Trip createTrip(Trip trip) {
		// TODO Auto-generated method stub
		
		Truck truck=getTruck(trip.getTruckId());
		
		if(truck!=null ){
			
			TruckOwner owner=getOwner(truck.getTruckOwnerId());
			if(!owner.getAvailableTrucks().contains(truck))
			{
				if(trip.getUuid()==0L)
					trip.setUuid(System.currentTimeMillis());
				
				truck.setCurrentTruckState(TripState.NOT_STARTED);
				truck.setCurrentTrip(trip);
				owner.getAvailableTrucks().remove(truck);
				owner.getTripingTrucks().add(truck);
				
				appHolder.getTrips().put(trip.getUuid(),trip);
			}
		
		return trip;
	}
return null;		
}

	
	
}
