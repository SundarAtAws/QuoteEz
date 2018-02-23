package sf.tcs.techfarm.business;

import java.util.ArrayList;

public class InsurerRating {
	private String insuranceName;
	private Double basePremium;
	private ArrayList<CoverageSet> coverages;
	
	public InsurerRating() {
		
	}

	
	public InsurerRating(String insuranceName,Double basePremium, ArrayList<CoverageSet> coverages) {
		super();
		this.insuranceName = insuranceName;
		this.basePremium = basePremium;
		this.coverages = coverages;
	}


	public String getInsuranceName() {
		return insuranceName;
	}


	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}


	public Double getBasePremium() {
		return basePremium;
	}

	public void setBasePremium(Double basePremium) {
		this.basePremium = basePremium;
	}

	public ArrayList<CoverageSet> getCoverages() {
		return coverages;
	}

	public void setCoverages(ArrayList<CoverageSet> coverages) {
		this.coverages = coverages;
	}

	
	 
	
}
