package jdbc.domain;

public class MixData {
	int procedureId;
	String drgDefinition;
	int providerId;
	int totalDischarges;
	double avgCoveredCharges;
	double avgTotalPayments;
	double avgMedicarePayments;

	String providerName;
	String providerStreetAddress;
	String providerCity;
	String providerState;
	String providerZipCode;
	String hrrDescription;
	
	double latitude;
	double longitude;
	int timeZone;
	int dayLightSaving;
	
	public int getProcedureId() {
		return procedureId;
	}
	public void setProcedureId(int procedureId) {
		this.procedureId = procedureId;
	}
	public String getDrgDefinition() {
		return drgDefinition;
	}
	public void setDrgDefinition(String drgDefinition) {
		this.drgDefinition = drgDefinition;
	}
	public int getProviderId() {
		return providerId;
	}
	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}
	public int getTotalDischarges() {
		return totalDischarges;
	}
	public void setTotalDischarges(int totalDischarges) {
		this.totalDischarges = totalDischarges;
	}
	public double getAvgCoveredCharges() {
		return avgCoveredCharges;
	}
	public void setAvgCoveredCharges(double avgCoveredCharges) {
		this.avgCoveredCharges = avgCoveredCharges;
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
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getProviderStreetAddress() {
		return providerStreetAddress;
	}
	public void setProviderStreetAddress(String providerStreetAddress) {
		this.providerStreetAddress = providerStreetAddress;
	}
	public String getProviderCity() {
		return providerCity;
	}
	public void setProviderCity(String providerCity) {
		this.providerCity = providerCity;
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
	public String getHrrDescription() {
		return hrrDescription;
	}
	public void setHrrDescription(String hrrDescription) {
		this.hrrDescription = hrrDescription;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public int getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(int timeZone) {
		this.timeZone = timeZone;
	}
	public int getDayLightSaving() {
		return dayLightSaving;
	}
	public void setDayLightSaving(int dayLightSaving) {
		this.dayLightSaving = dayLightSaving;
	}
	
	
}
