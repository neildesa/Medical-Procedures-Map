package JavaDatabaseCodeTests;



import java.util.List;

import org.junit.Test;

import JavaDatabaseCode.HospitalDao;
import JavaDatabaseCode.MixData;



public class test {
	
	

	//@Test
	//public void testSearchByCost() {
	//	HospitalDao hos = new HospitalDao();
	//	hos.SearchByCost("038 - EXTRACRANIAL PROCEDURES W CC", 1000, 11000);
	//}
	
	//@Test
	//public void testSearchByProcedure() {
	//	HospitalDao hos = new HospitalDao();
	//	hos.SearchByProcedure("057 - DEGENERATIVE NERVOUS SYSTEM DISORDERS W/O MCC");
	//}
	
	@Test
	public void testGetSearchByCost(){
		HospitalDao hos = new HospitalDao();
		List<MixData> list = hos.GetSearchByCost("038 - EXTRACRANIAL PROCEDURES W CC", 1000.0, 13000.0);
		for(MixData obj:list) {
			System.out.println(obj.getProviderId());
			System.out.println(obj.getProviderName());
			System.out.println(obj.getProviderStreetAddress());
			System.out.println(obj.getProviderCity());
			System.out.println(obj.getProviderZipCode());
			System.out.println(obj.getAvgCoveredCharges());
			System.out.println(obj.getAvgTotalPayments());
			System.out.println(obj.getAvgMedicarePayments());
			System.out.println("");
		}
		System.out.println("Test Get data search by cost finished");
	}
	
	
	@Test
	public void testGetSearchByProcedure() {
		HospitalDao hos = new HospitalDao();
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
			System.out.println("");
		}
		System.out.println("Test Get data search by procudure finished");
	}
	
	
	@Test
	public void testCallLocationBasedOnIpv4() {
		HospitalDao hos = new HospitalDao();
		List<MixData> list = hos.CallLocationBasedOnIpv4("18933760", "038 - EXTRACRANIAL PROCEDURES W CC");
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
		System.out.println("Test call location based on ip finished");
	}
	
	@Test
	public void testCallLocationBasedOnZipCode() {
		HospitalDao hos = new HospitalDao();
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
		System.out.println("Test call location based on Zip Code finished");
	}
	
}
