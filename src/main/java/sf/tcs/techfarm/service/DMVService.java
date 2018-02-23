package sf.tcs.techfarm.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.springframework.stereotype.Service;

import sf.tcs.techfarm.business.CoverageSet;
import sf.tcs.techfarm.business.Driver;
import sf.tcs.techfarm.business.HouseHold;
import sf.tcs.techfarm.business.InsurerRating;
import sf.tcs.techfarm.business.Quote;
import sf.tcs.techfarm.business.Vehicle;
  
@Service
public class DMVService {

	private List<Driver> driverDB;
	
	private List<Vehicle> vehicleDB;
	
	private void initializeDriverDB() {
		driverDB = new ArrayList<Driver>();
		 	
		String fileName = "files/driverData.json";
		ClassLoader classLoader = getClass().getClassLoader();
		File jsonInputFile = new File(classLoader.getResource(fileName).getFile());
		
		InputStream is;
	        try {
	            is = new FileInputStream(jsonInputFile);
	           
	            // Create JsonReader from Json.
	            JsonReader reader = Json.createReader(is);
	            
	            // Get the JsonObject structure from JsonReader.
	            JsonArray driverArray = reader.readArray();
	            
	            for(JsonObject driver: driverArray.getValuesAs(JsonObject.class)) {
	            	
	            	Driver driverObj = new Driver();
	            	 
	            	driverObj.setDriverLicenseNumber(driver.getString("Driver License Number").trim());
	            	driverObj.setFirstName(driver.getString("First Name").trim());
	            	driverObj.setLastName(driver.getString("Last Name").trim());
	            	driverObj.setDateOfBirth(driver.getString("Date Of Birth").trim());
	            	driverObj.setLicenseDate(driver.getString("License Date").trim());
	            	driverObj.setLicenseState(driver.getString("License state").trim());
	            	driverObj.setGender(driver.getString("Gender").trim());
	            	driverObj.setSSN(driver.getInt("SSN"));
	            	driverObj.setMaritalStatus(driver.getString("Marital Status").trim());
	            	driverObj.setAddress(driver.getString("Address").trim());
	            	driverObj.setCreditScore(driver.getInt("Credit Score"));
	            	driverObj.setPreviousLossRate(new Double(driver.get("Previous Loss rate").toString()));
	            	
	            	double genderRate = driverObj.getGender().equalsIgnoreCase("Male")?0.03:0.02;
	            	double maritalStatusRate = driverObj.getMaritalStatus().equalsIgnoreCase("Single")?0.02:0.01;
	            	String dob = driverObj.getDateOfBirth();
	            	int year = Integer.parseInt(dob.substring(dob.length()-4));
	            	double ageFactor = 0.0;
	            	
	            	if(year>1990)
	            		ageFactor = 0.2;
	            	else if(year>1980)
	            		ageFactor = 0.1;
	            	else
	            		ageFactor = 0.3;
	            	
	            	double CRI = genderRate + maritalStatusRate + ageFactor;
	            	char drivingGroup = ' ';
	            	
	            	if(CRI>0.3)
	            		drivingGroup = 'C';
	            	else if(CRI>0.2)
	            		drivingGroup = 'B';
	            	else
	            		drivingGroup = 'A';
	            	
	            	double creditScoreFactor=0.0;
	            	int creditScore = driverObj.getCreditScore();
	            	
	            	if(creditScore>=750)
	            		creditScoreFactor = 0.01;
	            	else if(creditScore>=700)
	            		creditScoreFactor = 0.02;
	            	else if(creditScore>=650)
	            		creditScoreFactor = 0.05;
	            	else if(creditScore>=550)
	            		creditScoreFactor = 0.07;
	            	else
	            		creditScoreFactor = 0.2;
	            	
	            	double driverRatingFactor= CRI + driverObj.getPreviousLossRate() + creditScoreFactor;
	            	
	            	driverObj.setGenderRate(new Double(genderRate));
	            	driverObj.setMaritalStatusRate(new Double(maritalStatusRate));
	            	driverObj.setDateOfBirthYear(new Integer(year));
	            	driverObj.setAgeRate(new Double(ageFactor));
	            	driverObj.setCustomerRatingIndex(new Double(CRI));
	            	driverObj.setDriverRatingGroup(drivingGroup);
	            	driverObj.setCreditScoreFactor(creditScoreFactor);
	            	driverObj.setDriverRatingFactor(driverRatingFactor);

	            	driverDB.add(driverObj);
	            	 
	            }
	            reader.close();
	            
	           
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		
	       
 	}
	
	private void initializeVehicleDB() {
		vehicleDB = new ArrayList<Vehicle>();
		 	
		String fileName = "files/vehicleData.json";
		ClassLoader classLoader = getClass().getClassLoader();
		File jsonInputFile = new File(classLoader.getResource(fileName).getFile());
	/*	ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		File jsonInputFile = new File(classLoader.getResource(fileName).getFile());*/
		
		InputStream is;
	        try {
	            is = new FileInputStream(jsonInputFile);
	           
	            // Create JsonReader from Json.
	            JsonReader reader = Json.createReader(is);
	            
	            // Get the JsonObject structure from JsonReader.
	            JsonArray vehicleArray = reader.readArray();
	            
	            for(JsonObject vehicle: vehicleArray.getValuesAs(JsonObject.class)) {
	            	
	            	Vehicle vehicleOb = new Vehicle();
	            	 
	            	
	            	vehicleOb.setCarRegNo(vehicle.getString("Car Reg No").trim());
	            	vehicleOb.setVIN(vehicle.getString("VIN Number").trim());
	            	vehicleOb.setMake(vehicle.getString("Make").trim());
	            	vehicleOb.setModel(vehicle.getString("Model").trim());
	            	vehicleOb.setBodyStyle(vehicle.getString("Body Style").trim());
	            	vehicleOb.setLRI(vehicle.getString("LRI").charAt(0));
	            	vehicleOb.setCDI(vehicle.getString("CDI").charAt(0));
	            	vehicleOb.setDTI(vehicle.getString("DTI").charAt(0));
	            	vehicleOb.setVSD(vehicle.getString("VSD").charAt(0));
	            	vehicleOb.setVehicleValue(Double.parseDouble(vehicle.get("Vehicle Value").toString().trim()));
	            	 
	            	vehicleDB.add(vehicleOb);
	            	 
	            }
	            reader.close();
	            
	           
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		
	       
 	}
	
	public void getDriverDetails(Driver driver) {
		initializeDriverDB();
	 	for(Driver driverOb:driverDB) {
	 		if(driverOb.getDriverLicenseNumber().equals(driver.getDriverLicenseNumber())) {
	 			loadDriverDeails(driverOb,driver);
	 		}
	 	}

	}

	public void getHouseHoldDrivers(HouseHold houseHold) {
	 	ArrayList<Driver> driversList = new ArrayList<Driver>();
	 	
		initializeDriverDB();
	 	
		for(Driver driver:driverDB) {
	 		if(driver.getAddress().equalsIgnoreCase(houseHold.getHouseHoldAddress())) {
	 			driversList.add(driver);
	 		}
	 	}
		
		if(!driversList.isEmpty()) {
			houseHold.setDrivers(driversList);
		}

	}
	private void loadDriverDeails(Driver driverOb, Driver driver) {


		driver.setDriverLicenseNumber(driverOb.getDriverLicenseNumber());
		driver.setFirstName(driverOb.getFirstName());
		driver.setLastName(driverOb.getLastName());
		driver.setDateOfBirth(driverOb.getDateOfBirth());
		driver.setLicenseDate(driverOb.getLicenseDate());
		driver.setLicenseState(driverOb.getLicenseState());
		driver.setGender(driverOb.getGender());
		driver.setSSN(driverOb.getSSN());
		driver.setMaritalStatus(driverOb.getMaritalStatus());
		driver.setAddress(driverOb.getAddress());
		driver.setGenderRate(driverOb.getGenderRate());
		driver.setMaritalStatusRate(driverOb.getMaritalStatusRate());
		driver.setDateOfBirthYear(driverOb.getDateOfBirthYear());
		driver.setAgeRate(driverOb.getAgeRate());
		driver.setCustomerRatingIndex(driverOb.getCustomerRatingIndex());
		driver.setDriverRatingGroup(driverOb.getDriverRatingGroup());
		driver.setCreditScore(driverOb.getCreditScore());
		driver.setCreditScoreFactor(driverOb.getCreditScoreFactor());
		driver.setPreviousLossRate(driverOb.getPreviousLossRate());
		driver.setDriverRatingFactor(driverOb.getDriverRatingFactor());

	}

	
	public void getVehicleDetails(Vehicle vehicle) {
		boolean found = false;
		initializeVehicleDB();
	 	for(Vehicle vehicleOb:vehicleDB) {

	 		if(!found) {
	 			if(vehicleOb.getCarRegNo()!=null) {
	 				System.out.println("car num is not null");
	 				if(vehicle.getCarRegNo()!=null) {
	 					System.out.println("input car num is not null");
		 				if(vehicleOb.getCarRegNo().equalsIgnoreCase(vehicle.getCarRegNo().trim())) {
		 					loadVehicleDetails(vehicleOb,vehicle);
		 		 			found = true;
		 		 		
		 				}
	 				}
	 			}
	 			else
	 			;
	 			
	 			if(vehicleOb.getVIN()!=null) {
	 				System.out.println("vin is not null");
	 				if(vehicle.getVIN()!=null) {
	 					System.out.println("input vin is not null");
		 				if(vehicleOb.getVIN().equalsIgnoreCase(vehicle.getVIN().trim())) {
		 					loadVehicleDetails(vehicleOb,vehicle);
		 		 			found = true;
		 		 		
		 				}
	 				}
	 			}
	 			else
	 			;
	 			
	 			 
	 		}
	 		 
	 	}
	 	if(!found) {
	 		vehicle.setCarRegNo(null);
	 		vehicle.setVIN(null);
	 	}
	}
	
	private void loadVehicleDetails(Vehicle vehicleOb, Vehicle vehicle) {
		vehicle.setCarRegNo(vehicleOb.getCarRegNo());
		vehicle.setVIN(vehicleOb.getVIN());
		vehicle.setMake(vehicleOb.getMake());
		vehicle.setModel(vehicleOb.getModel());
		vehicle.setBodyStyle(vehicleOb.getBodyStyle());
		vehicle.setLRI(vehicleOb.getLRI());
		vehicle.setCDI(vehicleOb.getCDI());
		vehicle.setDTI(vehicleOb.getDTI());
		vehicle.setVSD(vehicleOb.getVSD());
		vehicle.setVehicleValue(vehicleOb.getVehicleValue());
		 
	}

	
	public void getQuote(Quote quote) {
		List<Driver> houseHoldDrivers = quote.getDrivers();
		
		double driversRatingFactor = 0.0;
	
		for(Driver driver: houseHoldDrivers) {
			driversRatingFactor += driver.getDriverRatingFactor();
		}
		
		insurerOneService(quote,driversRatingFactor);
		insurerTwoService(quote,driversRatingFactor);
		insurerThreeService(quote,driversRatingFactor);
		
	}
	
	private void insurerOneService(Quote quote,double driverRatingFactor) {
		InsurerRating insurer = new InsurerRating();
		ArrayList<CoverageSet> coverages = new ArrayList<CoverageSet>();
		
		int INSURER_ONE = 1;
		double vehicleRatingFactor = 0.0;
		double vehiclePremiumRate = 0.0;
		double basePremium = 0.0;
		
		insurer.setInsuranceName("InsurerOne");
		for(Vehicle vehicle: quote.getVehicles()) {
			
		
		vehicleRatingFactor = getRateValue(vehicle.getCDI(),INSURER_ONE) +
				getRateValue(vehicle.getDTI(), INSURER_ONE) +
				getRateValue(vehicle.getLRI(), INSURER_ONE) +
				getRateValue(vehicle.getVSD(), INSURER_ONE);
		
		vehiclePremiumRate = vehicle.getVehicleValue() * vehicleRatingFactor;
		}
		basePremium = vehiclePremiumRate * driverRatingFactor;
		
		
		coverages.add(new CoverageSet("25$",-200.00,-142.857142857143,-160.00));
		coverages.add(new CoverageSet("50$",-180.00,-128.571428571429,-144.00));
		coverages.add(new CoverageSet("75$",-160.00,-114.285714285714,-128.00));
		coverages.add(new CoverageSet("100$",-150.00,-107.142857142857,-120.00));
		coverages.add(new CoverageSet("200$",-130.00,-92.8571428571429,-104.00));
		coverages.add(new CoverageSet("250$",1.00,1.00,1.00));
		coverages.add(new CoverageSet("500$",100.00,71.4285714285714,80.00));
		coverages.add(new CoverageSet("400$",125.00,89.2857142857143,100.00));
		coverages.add(new CoverageSet("750$",140.00,100.00,112.00));
		coverages.add(new CoverageSet("1000$",160.00,114.285714285714,128.00));
		coverages.add(new CoverageSet("2000$",180.00,128.571428571429,144.00));
		
		insurer.setBasePremium(basePremium);
		insurer.setCoverages(coverages);
		
		quote.addInsurer(insurer);
		
	}
	
	private void insurerTwoService(Quote quote,double driverRatingFactor) {
		InsurerRating insurer = new InsurerRating();
		ArrayList<CoverageSet> coverages = new ArrayList<CoverageSet>();
		int INSURER_TWO = 2;
		double vehicleRatingFactor = 0.0;
		double vehiclePremiumRate = 0.0;
		double basePremium = 0.0;
		insurer.setInsuranceName("InsurerTwo");
		for(Vehicle vehicle: quote.getVehicles()) {		
		vehicleRatingFactor = getRateValue(vehicle.getCDI(),INSURER_TWO) +
				getRateValue(vehicle.getDTI(), INSURER_TWO) +
				getRateValue(vehicle.getLRI(), INSURER_TWO) +
				getRateValue(vehicle.getVSD(), INSURER_TWO);
		
		vehiclePremiumRate = vehicle.getVehicleValue() * vehicleRatingFactor;
		}
		basePremium = vehiclePremiumRate * driverRatingFactor;
		
		coverages.add(new CoverageSet("25$"   ,-190.00,-135.714285714286,-152.00));
		coverages.add(new CoverageSet("50$"  ,-170.00,-121.428571428571,-136.00));
		coverages.add(new CoverageSet("75$"  ,-165.00,-117.857142857143,-132.00));	
		coverages.add(new CoverageSet("100$" ,-150.00,-107.142857142857,-120.00));	
		coverages.add(new CoverageSet("200$" ,-145.00,-103.571428571429,-116.00));		
		coverages.add(new CoverageSet("250$" ,-10.00,-7.14285714285714,-8.00));	
		coverages.add(new CoverageSet("500$"  ,1.00,1.00,1.00));	
		coverages.add(new CoverageSet("400$" ,95.00,67.8571428571429,76.00));	
		coverages.add(new CoverageSet("750$" ,125.00,89.2857142857143,100.00));	
		coverages.add(new CoverageSet("1000$",145.00,103.571428571429,116.00));	
		coverages.add(new CoverageSet("2000$",185.00,132.142857142857,148.00));	
		coverages.add(new CoverageSet("3000$",195.00,139.285714285714,156.00));

		insurer.setBasePremium(basePremium);
		insurer.setCoverages(coverages);
		
		quote.addInsurer(insurer);
		
	}
	
	private void insurerThreeService(Quote quote,double driverRatingFactor) {
		InsurerRating insurer = new InsurerRating();
		ArrayList<CoverageSet> coverages = new ArrayList<CoverageSet>();
		int INSURER_THREE = 3;
		double vehicleRatingFactor = 0.0;
		double vehiclePremiumRate = 0.0;
		double basePremium = 0.0;
		insurer.setInsuranceName("InsurerThree");
		for(Vehicle vehicle: quote.getVehicles()) {		
		vehicleRatingFactor = getRateValue(vehicle.getCDI(),INSURER_THREE) +
				getRateValue(vehicle.getDTI(), INSURER_THREE) +
				getRateValue(vehicle.getLRI(), INSURER_THREE) +
				getRateValue(vehicle.getVSD(), INSURER_THREE);
		
		vehiclePremiumRate = vehicle.getVehicleValue() * vehicleRatingFactor;
		}
		basePremium = vehiclePremiumRate * driverRatingFactor;
		
		
		coverages.add(new CoverageSet("25$",-225.00,-160.714285714286,-180.00));	
		coverages.add(new CoverageSet("50$",-190.00,-135.714285714286,-152.00));	
		coverages.add(new CoverageSet("75$",-140.00,-100.00,-112.00));	
		coverages.add(new CoverageSet("100$",-130.00,-92.8571428571429,-104.00));	
		coverages.add(new CoverageSet("200$",-120.00,-85.7142857142857,-96.00));
		coverages.add(new CoverageSet("250$",-110.00,-78.5714285714286,-88.00));	
		coverages.add(new CoverageSet("500$",1.00,1.00,1.00));	
		coverages.add(new CoverageSet("400$",55.00,39.2857142857143,44.00));
		coverages.add(new CoverageSet("750$",100.00,71.4285714285714,80.00));	
		coverages.add(new CoverageSet("1000$",140.00,100.00,112.00));	
		coverages.add(new CoverageSet("2000$",160.00,114.285714285714,128.00));	
		coverages.add(new CoverageSet("3000$",180.00,128.571428571429,144.00));

		insurer.setBasePremium(basePremium);
		insurer.setCoverages(coverages);
		
		quote.addInsurer(insurer);
		
	}
	
	private double getRateValue(char ch,int insurer) {
		switch(insurer) {
		case 1:
			switch(ch) {
				case 'A':
					return 0.001;
				case 'B':
					return 0.002;
				case 'C':
					return 0.003;
				case 'D': 
					return 0.02;
				case 'E':
					return 0.04;
				default:
					return 0.0;
			}
			
		case 2:
			switch(ch) {
				case 'A':
					return 0.0013;
				case 'B':
					return 0.0021;
				case 'C':
					return 0.003;
				case 'D': 
					return 0.021;
				case 'E':
					return 0.041;
				default:
					return 0.0;
			}
			
		case 3:
			switch(ch) {
				case 'A':
					return 0.001;
				case 'B':
					return 0.00205;
				case 'C':
					return 0.0031;
				case 'D': 
					return 0.02;
				case 'E':
					return 0.0406;
				default:
					return 0.0;
			}
			
		default:
			return 0.0;
		}
	}
}
