/**
 * 
 */
package com.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.models.AppHolder;
import com.models.Trip;
import com.models.Truck;
import com.models.TruckOwner;

/**
 * @author braj.kishore
 *
 */

@Service("truckManagerServcie")
public class TruckManagerServcie {

	
	@Resource(name="appHolder")
	AppHolder appHolder;
	
	
	
	public List<TruckOwner> getAllOwners() {
		// TODO Auto-generated method stub
		
		if(appHolder.getOwners().size()>0)
		{
			List<TruckOwner> owners=new ArrayList<TruckOwner>();
			for(TruckOwner owner:appHolder.getOwners().values())
				owners.add(owner);
				
			return owners;
		}
		return null;
	}

	public TruckOwner createOwner(TruckOwner truckOwner) {
		// TODO Auto-generated method stub
		
		if(truckOwner.getUuid()==0L)
			truckOwner.setUuid(System.currentTimeMillis());
		
		appHolder.getOwners().put(truckOwner.getUuid(), truckOwner);
		System.out.println("::appHolder.getOwners() "+appHolder.getOwners());
		return truckOwner;
	}

	public TruckOwner getOwner(long ownerId) {
		// TODO Auto-generated method stub
		System.out.println("::appHolder.getOwners() "+appHolder.getOwners());
		
		if(appHolder.getOwners().size()>0)
		{
			
			return appHolder.getOwners().get(ownerId);
		}
		return null;
	}

	public List<Truck> getTrucks(long ownerId) {
		// TODO Auto-generated method stub
		
		TruckOwner owner=appHolder.getOwners().get(ownerId);
		if(owner!=null && owner.getTotalTrucks()!=null&& owner.getTotalTrucks().size()>0)
		{
			
			return new ArrayList<Truck>(owner.getTotalTrucks().values());
		}
		
		return null;
	}

	public Truck getTruck(long ownerId, long truckId) {
		// TODO Auto-generated method stub
		
		TruckOwner owner=appHolder.getOwners().get(ownerId);
		if(owner!=null && owner.getTotalTrucks()!=null&& owner.getTotalTrucks().size()>0)
		{
			for(Truck truck:owner.getTotalTrucks().values())
				if(truck.getUuid()==truckId)
					return truck;
		}
		
		return null;
	}

	public List<Trip> getTruckTrips(long ownerId, long truckId) {
		// TODO Auto-generated method stub
		TruckOwner owner=appHolder.getOwners().get(ownerId);
		if(owner!=null && owner.getFinishedTrips()!=null&& owner.getFinishedTrips().size()>0)
		{
			List<Trip> trips=new ArrayList<Trip>();
			for(Trip trip:owner.getFinishedTrips())
				if(trip.getTruckId()==truckId)
					trips.add(trip);
			
			return trips;
		}
		return null;
	}

	public Truck getCreateTruck(long ownerId,Truck truck) {
		// TODO Auto-generated method stub
		TruckOwner owner=appHolder.getOwners().get(ownerId);
		if(owner!=null)
		{
			if(owner.getTotalTrucks()==null)
				owner.setTotalTrucks(new HashMap<Long,Truck>());
		
			if(truck.getUuid()==null)
				truck.setUuid(System.currentTimeMillis());
			
			truck.setTruckOwnerId(ownerId);
			owner.getTotalTrucks().put(truck.getUuid(), truck);
			return truck;
		}
		return null;
	}
}
