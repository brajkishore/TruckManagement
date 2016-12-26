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
import com.services.TripManagerService;
import com.services.TruckManagerServcie;


/**
 * @author braj.kishore
 *
 */
@RestController
public class TripManagerController {

	
	@Resource(name="tripManagerService")
	TripManagerService tripManagerService;
	
	@RequestMapping(value="/trips",
			method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<?> getAllTruckOwners(){
	
			List<Trip> oweners=tripManagerService.getAllTrips();
			if(oweners==null ||oweners.isEmpty())
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No owners");
			
			return ResponseEntity.ok().body(oweners);
	}
	
	@RequestMapping(value="/trips",
			method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<?> createTrip(@RequestBody Trip trip){
	
			trip=tripManagerService.createTrip(trip);
			if(trip==null)
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Issue at server");
			
			return ResponseEntity.ok().body(trip);
	}
	
	
}

	
