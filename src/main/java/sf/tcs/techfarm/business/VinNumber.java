package sf.tcs.techfarm.business;

import java.util.ArrayList;
import java.util.List;

public class VinNumber {

	private List<String> vinNumberList;
	private List<String> driverLicenseNumList;
	private String text;
	private String address;
	private String primaryDriver;
	private String vehicleModel;
	
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPrimaryDriver() {
		return primaryDriver;
	}
	public void setPrimaryDriver(String primaryDriver) {
		this.primaryDriver = primaryDriver;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public List<String> getVinNumberList() {
		if(null == vinNumberList) {
			vinNumberList = new ArrayList<String>();
		}
		return vinNumberList;
	}
	public void setVinNumberList(List<String> vinNumberList) {
		this.vinNumberList = vinNumberList;
	}
	public List<String> getDriverLicenseNumList() {
		if(null == driverLicenseNumList) {
			driverLicenseNumList = new ArrayList<String>();
		}
		return driverLicenseNumList;
	}
	public void setDriverLicenseNumList(List<String> driverLicenseNumList) {
		this.driverLicenseNumList = driverLicenseNumList;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	

}
