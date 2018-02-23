package sf.tcs.techfarm.business;

import java.util.ArrayList;
import java.util.List;

public class VinNumber {

	private List<String> vinNumberList;
	private List<String> driverLicenseNumList;
	private String text;
	
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
