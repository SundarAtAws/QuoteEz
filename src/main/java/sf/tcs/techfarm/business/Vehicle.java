package sf.tcs.techfarm.business;

public class Vehicle {
	
	private String carRegNo;
	private String VIN;
	private String make;
	private String model;
	private String bodyStyle;
	private Character LRI;
	private Character CDI;
	private Character DTI;
	private Character VSD;
	private Double vehicleValue;
	
	public Vehicle() {
		
	}
	
	public Vehicle(String carRegNo, String vIN, String make, String model, String bodyStyle, Character lRI,
			Character cDI, Character dTI, Character vSD, Double vehicleValue) {
		super();
		this.carRegNo = carRegNo;
		VIN = vIN;
		this.make = make;
		this.model = model;
		this.bodyStyle = bodyStyle;
		LRI = lRI;
		CDI = cDI;
		DTI = dTI;
		VSD = vSD;
		this.vehicleValue = vehicleValue;
	}


	public String getCarRegNo() {
		return carRegNo;
	}

	public void setCarRegNo(String carRegNo) {
		this.carRegNo = carRegNo;
	}

	public String getVIN() {
		return VIN;
	}

	public void setVIN(String vIN) {
		VIN = vIN;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBodyStyle() {
		return bodyStyle;
	}

	public void setBodyStyle(String bodyStyle) {
		this.bodyStyle = bodyStyle;
	}

	public Character getLRI() {
		return LRI;
	}

	public void setLRI(Character lRI) {
		LRI = lRI;
	}

	public Character getCDI() {
		return CDI;
	}

	public void setCDI(Character cDI) {
		CDI = cDI;
	}

	public Character getDTI() {
		return DTI;
	}

	public void setDTI(Character dTI) {
		DTI = dTI;
	}

	public Character getVSD() {
		return VSD;
	}

	public void setVSD(Character vSD) {
		VSD = vSD;
	}

	public Double getVehicleValue() {
		return vehicleValue;
	}

	public void setVehicleValue(Double vehicleValue) {
		this.vehicleValue = vehicleValue;
	}
	
}
