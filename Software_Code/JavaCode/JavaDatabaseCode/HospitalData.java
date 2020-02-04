package JavaDatabaseCode;

public class HospitalData {
	int providerId;
	String providerName;
	String providerStreetAddress;
	String providerCity;
	String providerState;
	String providerZipCode;
	String hrrDescription;
	double latitude;
	double longitude;
	
	
	public int getProviderId() {
		return providerId;
	}
	public void setProviderId(int providerId) {
		this.providerId = providerId;
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
	@Override
	
	public String toString() {
		return "HospitalData [providerId=" + providerId + ", providerName=" + providerName + ", providerStreetAddress="
				+ providerStreetAddress + ", providerCity=" + providerCity + ", providerState=" + providerState
				+ ", providerZipCode=" + providerZipCode + ", hrrDescription=" + hrrDescription + "]";
	}
	
	
}
