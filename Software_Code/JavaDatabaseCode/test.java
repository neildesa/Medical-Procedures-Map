package Test;


import org.junit.Test;
import jdbc.dao.HospitalDao;

public class test {
	
	public static void main(String[] args) {
		
	}

	@Test
	public void displayHospitalData() {
		HospitalDao hos= new HospitalDao();
		hos.displayDataOrderById();
	}
	
}
