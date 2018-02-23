package sf.tcs.techfarm.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;
 
public class HouseHold {
	
	private String houseHoldAddress;
	private List <Driver> drivers;
	
	public HouseHold() {
 
	}
	
	public HouseHold(String houseHoldAddress) {
	 	setHouseHoldAddress(houseHoldAddress);
	}
	
	public String getHouseHoldAddress() {
		return houseHoldAddress;
	}
	public void setHouseHoldAddress(String houseHoldAddress) {
		this.houseHoldAddress = houseHoldAddress;
	}

	public List <Driver> getDrivers() {
		if(CollectionUtils.isEmpty(drivers)) {
			return new ArrayList<Driver>();
		}
		return drivers;
	}

	public void setDrivers(List <Driver> drivers) {
		this.drivers = drivers;
	}
	
}
