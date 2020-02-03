package JavaDatabaseCodeTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import JavaDatabaseCode.JavaFunctionsForJsp;

public class JavaFunctionsForJspTests {
	
	/**
	 * testFindHosptialByProcedureByDistanceIsNotEmpty() is used to test that findHospitalByProcedure(String procedureName)
	 * is not empty. Note that there are two functions with this name; this is the one that only required procedureName
	 * as a parameter.
	 * 
	 * @throws ClassNotFoundException
	 */
	@Test
	public void testFindHopsitalByProcedureByDistanceIsNotEmpty() throws ClassNotFoundException {
		ArrayList<ArrayList<String>> listOfHospitals = new ArrayList<ArrayList<String>>();
		String procedureName = "056 - DEGENERATIVE NERVOUS SYSTEM DISORDERS W MCC";
		
		listOfHospitals = JavaFunctionsForJsp.findHospitalByProcedure(procedureName);
		boolean isEmpty = listOfHospitals.isEmpty();
		
		assertFalse("List is empty", isEmpty);
	}
	
	/**
	 * testFindHopsitalByProcedureByDistanceRowsAreEqualSize() is used to test that findHospitalByProcedure(String procedureName)
	 * has rows of equal size (i.e. the database is not sending it rows that are of different sizes, and the java function isn't 
	 * creating ArrayList<String>s that are of different sizes.
	 * 
	 * Note that there are two functions with this name; this is the one that only requires procedureName
	 * as a parameter.
	 * 
	 * @throws ClassNotFoundException
	 */
	public void testFindHopsitalByProcedureByDistanceRowsAreEqualSize() throws ClassNotFoundException {
		ArrayList<ArrayList<String>> listOfHospitals = new ArrayList<ArrayList<String>>();
		String procedureName = "056 - DEGENERATIVE NERVOUS SYSTEM DISORDERS W MCC";
		
		boolean sizeOfEachRowIsEqual = true;
		for (int i = 0; i < listOfHospitals.size() - 1; i++) {
			// check if current row size is equal to next row size for each row in listOfHospitals
			boolean adjacentRowsAreEqual = ( listOfHospitals.get(i).size() == listOfHospitals.get(i+1).size() );
			if (adjacentRowsAreEqual == false)
				sizeOfEachRowIsEqual = false;
		}
		assertTrue("Each row in table are not of equal size", sizeOfEachRowIsEqual);
	}

	


}
