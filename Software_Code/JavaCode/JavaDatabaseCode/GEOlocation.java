package jdbc.domain;

public class GEOlocation {
	int zipCode;
	String city;
	String state;
	double latitude;
	double longitude;
	int timeZone;
	int dayLightSaving;
	
	
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	@Override
	public String toString() {
		return "GEOlocation [zipCode=" + zipCode + ", city=" + city + ", state=" + state + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", timeZone=" + timeZone + ", dayLightSaving=" + dayLightSaving + "]";
	}
	
	
}
