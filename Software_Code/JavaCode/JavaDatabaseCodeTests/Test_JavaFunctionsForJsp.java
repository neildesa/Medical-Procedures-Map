package JavaDatabaseCodeTests;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

import org.junit.Test;

import JavaDatabaseCode.JavaFunctionsForJsp;

public class Test_JavaFunctionsForJsp {
	
	/**
	 * Test class for checking that Java call to SQL procedure "SearchByProcedure(String ProcedureName)"
	 * doesn't return an empty table.
	 * 
	 * @throws ClassNotFoundException
	 */
	@Test
	public void testFindHospitalByProcedureViaDistanceIsNotEmpty() throws ClassNotFoundException 
	{
		String procedureName = "001 - HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC";
		ArrayList<ArrayList<String>> listOfHospitals = JavaFunctionsForJsp.findHospitalByProcedure(procedureName);
		
		// begin test
		boolean isEmpty = listOfHospitals.isEmpty();
		assertFalse("The list is empty", isEmpty);
	}
	
	/**
	 * Test class for checking that Java call to SQL procedure "SearchByProcedure(String ProcedureName)"
	 * doesn't return a table with any null or empty string entries.
	 * 
	 * @throws ClassNotFoundException
	 */
	@Test
	public void testFindHospitalByProcedureViaDistanceEntriesNotNull() throws ClassNotFoundException
	{
		String procedureName = "001 - HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC";
		ArrayList<ArrayList<String>> listOfHospitals = JavaFunctionsForJsp.findHospitalByProcedure(procedureName);
		
		// begin test
		boolean thereIsANullEntry = false;
		String errorMessage = "";
		for (int i = 0; i < listOfHospitals.size(); i++) {
			for (int j = 0; j < listOfHospitals.get(i).size(); j++) {
				if (listOfHospitals.get(i).get(j) == "" || listOfHospitals.get(i).get(j) == null)
				{
					thereIsANullEntry = true;
					errorMessage += "null entry at i and j: " + i + ", " + j + "/n";
				}
			}
		}
		
		assertFalse(errorMessage, thereIsANullEntry);
	}
	
	/**
	 * Test class for checking that Java call to SQL procedure "SearchByProcedure(String ProcedureName)"
	 * does
	 * 
	 * @throws ClassNotFoundException
	 */
	@Test
	public void testFindHospitalByrocedureViaDistanceRowsAreEqualLength() throws ClassNotFoundException
	{
		String procedureName = "001 - HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC";
		ArrayList<ArrayList<String>> listOfHospitals = JavaFunctionsForJsp.findHospitalByProcedure(procedureName);
		
		// being test
		boolean rowsAreNotEqual = false;
		String errorMessage = "";
		for (int i = 0; i < listOfHospitals.size() - 1; i++) 
		{
			if (listOfHospitals.get(i).size() != listOfHospitals.get(i+1).size()) {
				rowsAreNotEqual = true;
				errorMessage += "Rows are not equal at indices i and i+1: " + i + ", " + (i+1) + "/n";
			}
				
		}
		
		assertFalse(errorMessage, rowsAreNotEqual);
	}
}
