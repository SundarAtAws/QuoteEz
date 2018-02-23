package sf.tcs.techfarm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sf.tcs.techfarm.business.Driver;
import sf.tcs.techfarm.business.HouseHold;
import sf.tcs.techfarm.business.Quote;
import sf.tcs.techfarm.business.Vehicle;
import sf.tcs.techfarm.service.DMVService;

@RestController
public class DMVController {
	
	@Autowired
	private DMVService dmvService;

	@RequestMapping(value="/dmv/driverRatingService",method=RequestMethod.POST)
	public Driver driverRatingService(@RequestBody Driver driver) {
		dmvService.getDriverDetails(driver);
		return driver;
	}
	
	
	@RequestMapping(value="/dmv/houseHoldService",method=RequestMethod.POST)
	public HouseHold houseHoldRatingService(@RequestBody HouseHold houseHold) {
		dmvService.getHouseHoldDrivers(houseHold); 
		return houseHold;
	}
	
	@RequestMapping(value="/dmv/vehicleRatingService",method=RequestMethod.POST)
	public Vehicle vehicleRatingService(@RequestBody Vehicle vehicle) {
		System.out.println("in vehicle rating controller");
		dmvService.getVehicleDetails(vehicle); 
		return vehicle;
	}
	
	@RequestMapping(value="/dmv/getParallelRating",method=RequestMethod.POST)
	public Quote parallelRatingService(@RequestBody Quote quote) {
		Driver driver = quote.getDrivers().get(0);
		HouseHold hh = new HouseHold();
		
		dmvService.getDriverDetails(driver);
		hh.setHouseHoldAddress(driver.getAddress());
		
		dmvService.getHouseHoldDrivers(hh);
		
		quote.setDrivers(hh.getDrivers());
		for(Vehicle vehicle: quote.getVehicles()) {
			dmvService.getVehicleDetails(vehicle);
			quote.getVehicles().add(vehicle);
		}
		
		
		dmvService.getQuote(quote);
		return quote;
	}
	
	
	@RequestMapping(value="/dmv/getQuote")
	public Quote quoteService() {
		Quote quote = new Quote();
		/*------ testing purpose ----------------------*/
		HouseHold hh = new HouseHold();
		hh.setHouseHoldAddress("2570 24th STREET, SACRAMENTO, CA 95818");
		dmvService.getHouseHoldDrivers(hh);
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVIN("7J3ZZ56T783450000");
		dmvService.getVehicleDetails(vehicle);
		
		quote.setDrivers(hh.getDrivers());
		
		quote.getVehicles().add(vehicle);
		
		dmvService.getQuote(quote);
		
		return quote;
	}
	
	
	@RequestMapping(value="/dmv/getDriverJSON")
	public Driver getDriverJSON() {
		return new Driver();
	}

	@RequestMapping(value="/dmv/getHouseHoldJSON")
	public HouseHold getHouseHoldJSON() {
		return new HouseHold();
	}
	
	@RequestMapping(value="/dmv/getVehicleJSON")
	public Vehicle getVehicleJSON() {
		return new Vehicle();
	}
	
	@RequestMapping(value="/dmv/getQuoteJSON")
	public Quote getQuoteJSON() {
		return new Quote();
	}
	

	
}
