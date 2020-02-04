package JavaDatabaseCodeTests;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

import org.junit.Test;

import JavaDatabaseCode.JavaFunctionsForJsp;

public class Test_JavaFunctionsForJsp {
	
	@Test
	public void testFindHospitalByProcedureViaDistanceIsNotEmpty() throws ClassNotFoundException 
	{
		String procedureName = "001 - HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC";
		ArrayList<ArrayList<String>> listOfHospitals = JavaFunctionsForJsp.findHospitalByProcedure(procedureName);
		boolean isEmpty = listOfHospitals.isEmpty();
		assertFalse("The list is empty", isEmpty);
	}
}
