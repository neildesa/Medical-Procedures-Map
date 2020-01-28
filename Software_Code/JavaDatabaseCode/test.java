package Test;


import org.junit.Test;
import jdbc.dao.MedicalDataDao;


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
