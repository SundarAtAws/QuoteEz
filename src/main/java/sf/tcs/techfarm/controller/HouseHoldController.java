package sf.tcs.techfarm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sf.tcs.techfarm.business.Driver;
import sf.tcs.techfarm.business.HouseHold;
import sf.tcs.techfarm.business.Vehicle;
import sf.tcs.techfarm.business.VinNumber;
import sf.tcs.techfarm.service.DMVService;

@Controller
public class HouseHoldController {

	@Autowired
	private DMVService dmvService;

	@RequestMapping(value = { "/household" }, method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody VinNumber retrieveHouseHold(HttpServletRequest request) throws Exception, IOException {
		VinNumber vinNumber = new VinNumber();
		vinNumber.setText("Household Driver");
		System.out.printf("Inside household controller");
		if(null!= request.getSession().getAttribute("vinDescList")) {
			List<String>	vinDescText = (ArrayList<String>) request.getSession().getAttribute("vinDescList");
			List<Vehicle> vehicleList = new ArrayList<Vehicle>();
			Vehicle vehicle = null;
			for(String vin:vinDescText)	{
				vehicle = new Vehicle();
				vehicle.setVIN(vin);
				//call to vin service
				dmvService.getVehicleDetails(vehicle);
				System.out.printf("Vehicle Details"+ vehicle.getMake());
				vehicleList.add(vehicle);
				System.out.printf("vin number- "+ vin);
			}
			request.getSession().setAttribute("VehicleList",vehicleList);
		}

		if(null!= request.getSession().getAttribute("dlDescList")) {
			List<String> dlDescText = (ArrayList<String>) request.getSession().getAttribute("dlDescList");
			List<Driver> driverList = new ArrayList<Driver>();
			Driver driver = null;
			HouseHold household = new HouseHold();
			for(String driverLicenseNum : dlDescText)	{
				driver = new Driver();
				driver.setDriverLicenseNumber(driverLicenseNum.trim());
				// call to DL service
				dmvService.getDriverDetails(driver);
				household.setHouseHoldAddress(driver.getAddress());
				// call to Household drivers service
				dmvService.getHouseHoldDrivers(household);
				buildDriversName(household,vinNumber);
				driverList.add(driver);
				System.out.printf("Driver Details "+ driver.getAddress());
				System.out.printf("driverLicenseNumber- "+ driverLicenseNum);
			}
			request.getSession().setAttribute("householdDrivers", household);
		}
		return vinNumber;
	}

	private void buildDriversName(HouseHold household, VinNumber vinNumber ) {
		for(Driver driver: household.getDrivers()) {
			vinNumber.getDriverLicenseNumList().add(driver.getFirstName());
		}
		
	}
}
