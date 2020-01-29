package Test;



import org.junit.Test;

import jdbc.dao.HospitalDao;

public class test {
	
	

	@Test
	public void testSearchByCost() {
		HospitalDao hos = new HospitalDao();
		hos.SearchByCost("038 - EXTRACRANIAL PROCEDURES W CC", 1000, 11000);
	}
	
	public void testSearchByProcedure() {
		HospitalDao hos = new HospitalDao();
		hos.SearchByProcedure("057 - DEGENERATIVE NERVOUS SYSTEM DISORDERS W/O MCC");
	}
	
}
