package sf.tcs.techfarm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sf.tcs.techfarm.business.Driver;
import sf.tcs.techfarm.business.HouseHold;
import sf.tcs.techfarm.business.Quote;
import sf.tcs.techfarm.business.Vehicle;
import sf.tcs.techfarm.service.DMVService;

@Controller
public class QuoteController {


	@Autowired
	private DMVService dmvService;
	
	@RequestMapping(value = { "/quote" }, method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Quote quoteRequest(@RequestBody String[] driverNamesAr, HttpServletRequest request) {
		Quote quote = new Quote();
		Object object = request.getSession().getAttribute("householdDrivers");
		Object vehicleObject = request.getSession().getAttribute("VehicleList");
		quote.setVehicle(buildVehicles(vehicleObject));
		quote.setDrivers(buildDrivers(driverNamesAr, object));
		// call Quote service
		dmvService.getQuote(quote);
		System.out.println(" Quote Controller");
		return quote;
	}

	private List<Driver> buildDrivers(String[] driverNamesAr, Object object) {
		List<Driver> driversList = new ArrayList<Driver>();
		if(null != driverNamesAr && null!= object) {
			for(String driverName: driverNamesAr) {
				if(!StringUtils.isEmpty(driverName)){
					HouseHold household = (HouseHold)object;
				for(Driver driver :household.getDrivers()) {
					if(driver.getFirstName().equalsIgnoreCase(driverName)) {
						driversList.add(driver);
						
					}
				}
				}
			}
		}
		return driversList;
	}

	private List<Vehicle> buildVehicles(Object vehicleObject) {
		if(null != vehicleObject) {
			return (List<Vehicle>)vehicleObject;
		}
		return null;
	}

}