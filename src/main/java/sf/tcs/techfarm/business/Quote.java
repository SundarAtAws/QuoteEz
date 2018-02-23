package sf.tcs.techfarm.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

public class Quote {
	private List <Driver> drivers;
	private List<Vehicle> vehicles;
	private List <InsurerRating> insurerRating;
	
	public Quote() {
		insurerRating = new ArrayList<>();
	}
	
	public Quote(List<Driver> drivers, List<Vehicle> vehicles, List<InsurerRating> insurerRating) {
		super();
		this.drivers = drivers;
		this.vehicles = vehicles;
		this.insurerRating = insurerRating;
	}

	public List<Driver> getDrivers() {
		if(CollectionUtils.isEmpty(drivers)) {
			return new ArrayList<Driver>();
		}
		return drivers;
	}

	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}

	public List<Vehicle> getVehicles() {
		if(CollectionUtils.isEmpty(vehicles)) {
			return new ArrayList<Vehicle>();
		}
		return vehicles;
	}

	public void setVehicle(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public List<InsurerRating> getInsurerRating() {
		if(CollectionUtils.isEmpty(insurerRating)) {
			return new ArrayList<InsurerRating>();
		}
		return insurerRating;
	}

	public void setInsurerRating(List<InsurerRating> insurerRating) {
		this.insurerRating = insurerRating;
	}
	
	public void addInsurer(InsurerRating insurer) {
		insurerRating.add(insurer);
	}
	
}
