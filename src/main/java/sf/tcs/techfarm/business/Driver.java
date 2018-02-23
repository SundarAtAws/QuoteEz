package sf.tcs.techfarm.business;

public class Driver {
	private String driverLicenseNumber;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String licenseDate;
	private String licenseState;
	private String Gender;
	private Integer SSN;
	private String maritalStatus;
	private String address;
	private Double genderRate;
	private Double maritalStatusRate;
	private Integer dateOfBirthYear;
	private Double ageRate;
	private Double customerRatingIndex;
	private Character driverRatingGroup;
	private Integer creditScore;
	private Double creditScoreFactor;
	private Double previousLossRate;
	private Double driverRatingFactor;

	public Driver() {
		
	}
	
	public Driver(String driverLicenseNumber, String firstName, String lastName, String dateOfBirth, String licenseDate,
			String licenseState, String gender, Integer sSN, String maritalStatus, String address, Double genderRate,
			Double maritalStatusRate, Integer dateOfBirthYear, Double ageRate, Double customerRatingIndex,
			Character driverRatingGroup, Integer creditScore, Double creditScoreFactor, Double previousLossRate,
			Double driverRatingFactor) {
		super();
		this.driverLicenseNumber = driverLicenseNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.licenseDate = licenseDate;
		this.licenseState = licenseState;
		Gender = gender;
		SSN = sSN;
		this.maritalStatus = maritalStatus;
		this.address = address;
		this.genderRate = genderRate;
		this.maritalStatusRate = maritalStatusRate;
		this.dateOfBirthYear = dateOfBirthYear;
		this.ageRate = ageRate;
		this.customerRatingIndex = customerRatingIndex;
		this.driverRatingGroup = driverRatingGroup;
		this.creditScore = creditScore;
		this.creditScoreFactor = creditScoreFactor;
		this.previousLossRate = previousLossRate;
		this.driverRatingFactor = driverRatingFactor;
	}
	public String getDriverLicenseNumber() {
		return driverLicenseNumber;
	}
	public void setDriverLicenseNumber(String driverLicenseNumber) {
		this.driverLicenseNumber = driverLicenseNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getLicenseDate() {
		return licenseDate;
	}
	public void setLicenseDate(String licenseDate) {
		this.licenseDate = licenseDate;
	}
	public String getLicenseState() {
		return licenseState;
	}
	public void setLicenseState(String licenseState) {
		this.licenseState = licenseState;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public Integer getSSN() {
		return SSN;
	}
	public void setSSN(Integer sSN) {
		SSN = sSN;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getGenderRate() {
		return genderRate;
	}
	public void setGenderRate(Double genderRate) {
		this.genderRate = genderRate;
	}
	public Double getMaritalStatusRate() {
		return maritalStatusRate;
	}
	public void setMaritalStatusRate(Double maritalStatusRate) {
		this.maritalStatusRate = maritalStatusRate;
	}
	public Integer getDateOfBirthYear() {
		return dateOfBirthYear;
	}
	public void setDateOfBirthYear(Integer dateOfBirthYear) {
		this.dateOfBirthYear = dateOfBirthYear;
	}
	public Double getAgeRate() {
		return ageRate;
	}
	public void setAgeRate(Double ageRate) {
		this.ageRate = ageRate;
	}
	public Double getCustomerRatingIndex() {
		return customerRatingIndex;
	}
	public void setCustomerRatingIndex(Double customerRatingIndex) {
		this.customerRatingIndex = customerRatingIndex;
	}
	public Character getDriverRatingGroup() {
		return driverRatingGroup;
	}
	public void setDriverRatingGroup(Character driverRatingGroup) {
		this.driverRatingGroup = driverRatingGroup;
	}
	public Integer getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(Integer creditScore) {
		this.creditScore = creditScore;
	}
	public Double getCreditScoreFactor() {
		return creditScoreFactor;
	}
	public void setCreditScoreFactor(Double creditScoreFactor) {
		this.creditScoreFactor = creditScoreFactor;
	}
	public Double getPreviousLossRate() {
		return previousLossRate;
	}
	public void setPreviousLossRate(Double previousLossRate) {
		this.previousLossRate = previousLossRate;
	}
	public Double getDriverRatingFactor() {
		return driverRatingFactor;
	}
	public void setDriverRatingFactor(Double driverRatingFactor) {
		this.driverRatingFactor = driverRatingFactor;
	}

	@Override
	public String toString() {
		return "Driver [driverLicenseNumber=" + driverLicenseNumber + ", firstName=" + firstName + ", lastName="
				+ lastName + ", dateOfBirth=" + dateOfBirth + ", licenseDate=" + licenseDate + ", licenseState="
				+ licenseState + ", Gender=" + Gender + ", SSN=" + SSN + ", maritalStatus=" + maritalStatus
				+ ", address=" + address + ", genderRate=" + genderRate + ", maritalStatusRate=" + maritalStatusRate
				+ ", dateOfBirthYear=" + dateOfBirthYear + ", ageRate=" + ageRate + ", customerRatingIndex="
				+ customerRatingIndex + ", driverRatingGroup=" + driverRatingGroup + ", creditScore=" + creditScore
				+ ", creditScoreFactor=" + creditScoreFactor + ", previousLossRate=" + previousLossRate
				+ ", driverRatingFactor=" + driverRatingFactor + "]";
	}
	
	

}
