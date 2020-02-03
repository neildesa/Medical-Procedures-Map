package JavaDatabaseCodeTests;
import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import JavaDatabaseCode.*;


public class TestIsEmpty {
	
	@Test
	public void testGetSearchByCostIsEmpty(){
		JavaFuncForSQL func = new JavaFuncForSQL();
		List<MixData> list = func.GetSearchByCost("038 - EXTRACRANIAL PROCEDURES W CC", 1000, 13000);
		boolean isEmpty = list.isEmpty();
		assertFalse("data search by cost is empty",isEmpty);		
	}
	
	@Test
	public void testGetSearchByProcedureIsEmpty() {
		JavaFuncForSQL hos = new JavaFuncForSQL();
		List<MixData> list = hos.GetSearchByProcedure("038 - EXTRACRANIAL PROCEDURES W CC");
		boolean isEmpty = list.isEmpty();
		assertFalse("data search by cost is empty",isEmpty);
	}
	
	@Test
	public void testCallLocationBasedOnZipCode() {
		JavaFuncForSQL hos = new JavaFuncForSQL();
		List<MixData> list = hos.CallLocationBasedOnZipCode("36301", "027 - CRANIOTOMY & ENDOVASCULAR INTRACRANIAL PROCEDURES W/O CC/MCC");
		boolean isEmpty = list.isEmpty();
		assertFalse("data search by cost is empty",isEmpty);
	}
	
	@Test
	public void testReturnsortedProcedures() {
		JavaFuncForSQL func = new JavaFuncForSQL();
		List<MixData> list = func.ReturnsortedProcedures();
		boolean isEmpty = list.isEmpty();
		assertFalse("data search by cost is empty",isEmpty);
	}

	
}
