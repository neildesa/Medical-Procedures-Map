package JavaDatabaseCodeTests;



import java.util.List;

import org.junit.Test;

import JavaDatabaseCode.JavaFuncForSQL;
import JavaDatabaseCode.MixData;



public class Test_JavaFuncForSQL {
	
	
	
	@Test
	public void testGetSearchByCost(){
		JavaFuncForSQL func = new JavaFuncForSQL();
		boolean success=true;
		double min=1000;
		double max=13000;
		List<MixData> list = func.GetSearchByCost("038 - EXTRACRANIAL PROCEDURES W CC", min, max);
		for(MixData obj:list) {
			System.out.println(obj.getProviderId());
			System.out.println(obj.getProviderName());
			System.out.println(obj.getProviderStreetAddress());
			System.out.println(obj.getProviderCity());
			System.out.println(obj.getProviderZipCode());
			System.out.println(obj.getAvgCoveredCharges());
			System.out.println(obj.getAvgTotalPayments());
			System.out.println(obj.getAvgMedicarePayments());
			System.out.println(obj.getLatitude());
			System.out.println(obj.getLongitude());
			System.out.println("");
			if(obj.getAvgCoveredCharges()<min||obj.getAvgCoveredCharges()>max) {
				success=false;
				break;
			}
		}
		if(success) {
			System.out.println("function getSearchByCost successfully done");
		}

	}

	@Test
	public void testGetSearchByCostWithRating() {
		JavaFuncForSQL func = new JavaFuncForSQL();
		boolean success=true;
		double min=1000;
		double max=13000;
		int rating =3;
		List<MixData> list = func.GetSearchByCostWithRating("038 - EXTRACRANIAL PROCEDURES W CC", min, max, rating);
		for(MixData obj:list) {
			System.out.println(obj.getProviderId());
			System.out.println(obj.getProviderName());
			System.out.println(obj.getProviderStreetAddress());
			System.out.println(obj.getProviderCity());
			System.out.println(obj.getProviderZipCode());
			System.out.println(obj.getAvgCoveredCharges());
			System.out.println(obj.getAvgTotalPayments());
			System.out.println(obj.getAvgMedicarePayments());
			System.out.println(obj.getCustomerRating());
			System.out.println(obj.getLatitude());
			System.out.println(obj.getLongitude());
			System.out.println("");
			if(obj.getAvgCoveredCharges()<min||obj.getAvgCoveredCharges()>max) {
				success=false;
				break;
			}
		}
		if(success) {
			System.out.println("function getSearchByCost successfully done");
		}
	}
	
	@Test
	public void testGetSearchByProcedure() {
		JavaFuncForSQL hos = new JavaFuncForSQL();
		List<MixData> list = hos.GetSearchByProcedure("038 - EXTRACRANIAL PROCEDURES W CC");
		for(MixData obj:list) {
			System.out.println(obj.getProviderId());
			System.out.println(obj.getProviderName());
			System.out.println(obj.getProviderStreetAddress());
			System.out.println(obj.getProviderCity());
			System.out.println(obj.getProviderZipCode());
			System.out.println(obj.getAvgCoveredCharges());
			System.out.println(obj.getAvgTotalPayments());
			System.out.println(obj.getAvgMedicarePayments());
			//System.out.println(obj.getCustomerRating());
			System.out.println(obj.getLatitude());
			System.out.println(obj.getLongitude());
			System.out.println("");
		}
		System.out.println("function getSearchByProcedur finished");
	}
		
	@Test
	public void testGetSearchByProcedureWithRating() {
		JavaFuncForSQL hos = new JavaFuncForSQL();
		List<MixData> list = hos.GetSearchByProcedureWithRating("038 - EXTRACRANIAL PROCEDURES W CC",3);
		for(MixData obj:list) {
			System.out.println(obj.getProviderId());
			System.out.println(obj.getProviderName());
			System.out.println(obj.getProviderStreetAddress());
			System.out.println(obj.getProviderCity());
			System.out.println(obj.getProviderZipCode());
			System.out.println(obj.getAvgCoveredCharges());
			System.out.println(obj.getAvgTotalPayments());
			System.out.println(obj.getAvgMedicarePayments());
			System.out.println(obj.getCustomerRating());
			System.out.println(obj.getLatitude());
			System.out.println(obj.getLongitude());
			System.out.println("");
		}
		System.out.println("function getSearchByProcedurWithRating finished");
	}
		
	
	
	@Test
	public void testCallLocationBasedOnZipCode() {
		JavaFuncForSQL hos = new JavaFuncForSQL();
		List<MixData> list = hos.CallLocationBasedOnZipCode("36301", "027 - CRANIOTOMY & ENDOVASCULAR INTRACRANIAL PROCEDURES W/O CC/MCC");
		for(MixData obj:list) {
			System.out.println(obj.getProviderId());
			System.out.println(obj.getProviderName());
			System.out.println(obj.getProviderZipCode());
			System.out.println(obj.getDrgDefinition());
			System.out.println(obj.getAvgCoveredCharges());
			System.out.println(obj.getAvgTotalPayments());
			System.out.println(obj.getAvgMedicarePayments());
			System.out.println("");
		}
		System.out.println("function callLocationBasedOnZipCode finished");
	}
	
	
	@Test
	public void testReturnsortedProcedures() {
		JavaFuncForSQL func = new JavaFuncForSQL();
		List<MixData> list = func.ReturnsortedProcedures();
		for(MixData obj:list) {		
			System.out.println("ID: "+obj.getIdDefiniton());
			System.out.println(obj.getDrgDefinition());
			System.out.println("");
	
		}
		System.out.println("function testReturnsortedProcedures finished");
	}
	
	@Test
	public void testAddReview() {
		JavaFuncForSQL func = new JavaFuncForSQL();
		func.AddReview(392933,3 );
	}
}
