package JavaDatabaseCode;

public class ProcedureData {
	int procedureId;
	String drgDefinition;
	int providerId;
	int totalDischarges;
	double avgCoveredCharges;
	double avgTotalPayments;
	double avgMedicarePayments;
	int customerRating;
	int numberOfReview;
	
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
	public int getCustomerRating() {
		return customerRating;
	}
	public void setCustomerRating(int customerRating) {
		this.customerRating = customerRating;
	}
	public int getNumberOfReview() {
		return numberOfReview;
	}
	public void setNumberOfReview(int numberOfReview) {
		this.numberOfReview = numberOfReview;
	}
		@Override
	public String toString() {
		return "ProceduresData [procedureId=" + procedureId + ", drgDefinition=" + drgDefinition + ", providerId="
				+ providerId + ", totalDischarges=" + totalDischarges + ", avgCoveredCharges=" + avgCoveredCharges
				+ ", avgTotalPayments=" + avgTotalPayments + ", avgMedicarePayments=" + avgMedicarePayments + "]";
	}
	
}
