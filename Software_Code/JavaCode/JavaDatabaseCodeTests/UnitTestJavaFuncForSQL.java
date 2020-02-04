package JavaDatabaseCodeTests;
import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import JavaDatabaseCode.*;


public class UnitTestJavaFuncForSQL {
	
	
	
	
	//Tests for procedure getSearchByCost 
	@Test
	public void testGetSearchByCostIsEmpty(){
		JavaFuncForSQL func = new JavaFuncForSQL();
		List<MixData> list = func.GetSearchByCost("038 - EXTRACRANIAL PROCEDURES W CC", 1000, 13000);
		boolean isEmpty = list.isEmpty();
		assertFalse("data search by cost is empty",isEmpty);		
	}
	
	
	
	
	
	
	//Tests for procedure getSearchByCostWithRating 
	@Test
	public void testGetSearchByCostWithRatingIsEmpty(){
		JavaFuncForSQL func = new JavaFuncForSQL();
		List<MixData> list = func.GetSearchByCostWithRating("038 - EXTRACRANIAL PROCEDURES W CC", 1000, 13000,3);
		boolean isEmpty = list.isEmpty();
		assertFalse("data search by cost is empty",isEmpty);		
	}
	
	
	
	
	
	//Test for procedure getSearchByProcedure
	@Test
	public void testGetSearchByProcedureIsEmpty() {
		JavaFuncForSQL hos = new JavaFuncForSQL();
		List<MixData> list = hos.GetSearchByProcedure("038 - EXTRACRANIAL PROCEDURES W CC");
		boolean isEmpty = list.isEmpty();
		assertFalse("data search by cost is empty",isEmpty);
	}
	
	
	
	
	//Test for procedure getSearchByProcedureWithRating
	@Test
	public void testGetSearchByProcedureWithRatingIsEmpty() {
		JavaFuncForSQL hos = new JavaFuncForSQL();
		List<MixData> list = hos.GetSearchByProcedure("038 - EXTRACRANIAL PROCEDURES W CC");
		boolean isEmpty = list.isEmpty();
		assertFalse("data search by cost is empty",isEmpty);
	}
	
	
	
	
	//Test for procedure callLoCationBaseOnZipCode
	@Test
	public void testCallLocationBasedOnZipCodeIsEmpty() {
		JavaFuncForSQL hos = new JavaFuncForSQL();
		List<MixData> list = hos.CallLocationBasedOnZipCode("36301", "027 - CRANIOTOMY & ENDOVASCULAR INTRACRANIAL PROCEDURES W/O CC/MCC");
		boolean isEmpty = list.isEmpty();
		assertFalse("data search by cost is empty",isEmpty);
	}
	
	
	
	
	
	
	//Test for procedure returnsortedProcedures
	@Test
	public void testReturnsortedProceduresIsEmpty() {
		JavaFuncForSQL func = new JavaFuncForSQL();
		List<MixData> list = func.ReturnsortedProcedures();
		boolean isEmpty = list.isEmpty();
		assertFalse("data search by cost is empty",isEmpty);
	}


	
	
}
