package jdbc.domain;

//don't use yet, will be changed or removed
//don't use yet, will be changed or removed
//don't use yet, will be changed or removed
//don't use yet, will be changed or removed
//don't use yet, will be changed or removed

//Corresponds to a MedicalData
public class MedicalData {

	int medID;
	String definition;
	int providerID;
	String providerName;
	String providerStreetAddr;
	String providerCityAddr;
	String providerState;
	String providerZipCode;
	String hospitalHRRDescription;
	int totalDischarges;
	double avgCoveredCharge;
	double avgTotalPayments;
	double avgMedicarePayments;
	
	
	public int getMedID() {
		return medID;
	}
	public void setMedID(int medID) {
		this.medID = medID;
	}
	public String getDefinition() {
		return definition;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	public int getProviderID() {
		return providerID;
	}
	public void setProviderID(int providerID) {
		this.providerID = providerID;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getProviderStreetAddr() {
		return providerStreetAddr;
	}
	public void setProviderStreetAddr(String providerStreetAddr) {
		this.providerStreetAddr = providerStreetAddr;
	}
	public String getProviderCityAddr() {
		return providerCityAddr;
	}
	public void setProviderCityAddr(String providerCityAddr) {
		this.providerCityAddr = providerCityAddr;
	}
	public String getProviderState() {
		return providerState;
	}
	public void setProviderState(String providerState) {
		this.providerState = providerState;
	}
	public String getProviderZipCode() {
		return providerZipCode;
	}
	public void setProviderZipCode(String providerZipCode) {
		this.providerZipCode = providerZipCode;
	}
	public String getHospitalHRRDescription() {
		return hospitalHRRDescription;
	}
	public void setHospitalHRRDescription(String hospitalHRRDescription) {
		this.hospitalHRRDescription = hospitalHRRDescription;
	}
	public int getTotalDischarges() {
		return totalDischarges;
	}
	public void setTotalDischarges(int totalDischarges) {
		this.totalDischarges = totalDischarges;
	}
	public double getAvgCoveredCharge() {
		return avgCoveredCharge;
	}
	public void setAvgCoveredCharge(double avgCoveredCharge) {
		this.avgCoveredCharge = avgCoveredCharge;
	}
	public double getAvgTotalPayments() {
		return avgTotalPayments;
	}
	public void setAvgTotalPayments(double avgTotalPayments) {
		this.avgTotalPayments = avgTotalPayments;
	}
	public double getAvgMedicarePayments() {
		return avgMedicarePayments;
	}
	public void setAvgMedicarePayments(double avgMedicarePayments) {
		this.avgMedicarePayments = avgMedicarePayments;
	}
	
	
	
}
