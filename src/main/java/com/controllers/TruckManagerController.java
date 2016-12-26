/**
 * 
 */
package com.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.models.Trip;
import com.models.Truck;
import com.models.TruckOwner;
import com.services.TruckManagerServcie;


/**
 * @author braj.kishore
 *
 */
@RestController
public class TruckManagerController {

	
	@Resource(name="truckManagerServcie")
	TruckManagerServcie truckManagerServcie;
	
	@RequestMapping("/")
	public String welcome(){
		return "Welcome to truckmanagement services.";
	}
	@RequestMapping(value="/truckoweners",
			method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<?> getAllTruckOwners(){
	
			List<TruckOwner> oweners=truckManagerServcie.getAllOwners();
			if(oweners==null ||oweners.isEmpty())
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No owners");
			
			return ResponseEntity.ok().body(oweners);
	}
	
	@RequestMapping(value="/truckowners",
			method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<?> createOwener(@RequestBody TruckOwner truckOwner){
	
		TruckOwner owner=truckManagerServcie.createOwner(truckOwner);
			if(owner==null)
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Issue at server");
			
			return ResponseEntity.ok().body(owner);
	}
	
	@RequestMapping(value="/truckowners/{id}",
			method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<?> getOwner(@PathVariable("id") long ownerId ){
	
		TruckOwner owner=truckManagerServcie.getOwner(ownerId);
			if(owner==null)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid ownerId");
			
			return ResponseEntity.ok().body(owner);
	}
	
	
	@RequestMapping(value="/truckowners/{id}/trucks",
			method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<?> getTrucks(@PathVariable("id") long ownerId ){
	
		List<Truck> trucks=truckManagerServcie.getTrucks(ownerId);
			if(trucks==null)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No truck");
			
			return ResponseEntity.ok().body(trucks);
	}
	
	@RequestMapping(value="/truckowners/{id}/trucks",
			method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<?> createTruck(@PathVariable("id") long ownerId,@RequestBody Truck truck ){
	
		if(truck==null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No truck object");
		
		 truck=truckManagerServcie.getCreateTruck(ownerId,truck);
			if(truck==null)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No truck");
			
			return ResponseEntity.ok().body(truck);
	}
	
	
	@RequestMapping(value="/truckowners/{id}/trucks/{truckId}",
			method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<?> getTruck(@PathVariable("id") long ownerId,@PathVariable("truckId") long truckId ){
	
		Truck truck=truckManagerServcie.getTruck(ownerId,truckId);
			if(truck==null)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No truck");
			
			return ResponseEntity.ok().body(truck);
	}
	
	@RequestMapping(value="/truckowners/{id}/trucks/{truckId}/trips",
			method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<?> getTruckTrips(@PathVariable("id") long ownerId,
			@PathVariable("truckId") long truckId){
	
		
		
			List<Trip> trips=truckManagerServcie.getTruckTrips(ownerId,truckId);
			if(trips==null)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No truck");
			
			return ResponseEntity.ok().body(trips);
		
	}
	
}

	
