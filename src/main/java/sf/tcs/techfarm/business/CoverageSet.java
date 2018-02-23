package sf.tcs.techfarm.business;

public class CoverageSet {
	private String coverageRange;
	private Double liabilityBIPD;
	private Double collision;
	private Double comprehensive;
	
	public CoverageSet() {
		
	}
	
	public CoverageSet(String coverageRange, Double liabilityBIPD, Double collision, Double comprehensive) {
		super();
		this.coverageRange = coverageRange;
		this.liabilityBIPD = liabilityBIPD;
		this.collision = collision;
		this.comprehensive = comprehensive;
	}

	public String getCoverageRange() {
		return coverageRange;
	}

	public void setCoverageRange(String coverageRange) {
		this.coverageRange = coverageRange;
	}

	public Double getLiabilityBIPD() {
		return liabilityBIPD;
	}

	public void setLiabilityBIPD(Double liabilityBIPD) {
		this.liabilityBIPD = liabilityBIPD;
	}

	public Double getCollision() {
		return collision;
	}

	public void setCollision(Double collision) {
		this.collision = collision;
	}

	public Double getComprehensive() {
		return comprehensive;
	}

	public void setComprehensive(Double comprehensive) {
		this.comprehensive = comprehensive;
	}
	
	
	
}
