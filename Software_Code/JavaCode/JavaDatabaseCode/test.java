package JavaDatabaseCode;



import org.junit.jupiter.api.Test;

import JavaDatabaseCode.MedicalDataDao;


public class test {
	
	
	@Test
	public void DisplayAll() {
		MedicalDataDao med = new MedicalDataDao();
		med.DisplayAll();
	}
	
	
	@Test
	public void DisplayOrderByCost() {
		MedicalDataDao med = new MedicalDataDao();
		med.DisplayOrderByCost();
	}
	
	
	
	
}
