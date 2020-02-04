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
		double min = 1000;
		double max = 10000;
		int rating = 3;
		List<MixData> list = func.GetSearchByCost("038 - EXTRACRANIAL PROCEDURES W CC", min, max, rating);
		boolean isEmpty = list.isEmpty();
		assertFalse("data search by cost is empty",isEmpty);		
	}
	@Test
	public void testGetSearchByCost_costIsOutOfRange() {
		JavaFuncForSQL func = new JavaFuncForSQL();
		double min = 1000;
		double max = 10000;
		int rating = 3;
		List<MixData> list = func.GetSearchByCost("038 - EXTRACRANIAL PROCEDURES W CC", min, max,rating);
		boolean isOutOfRange = false;
		for(MixData obj: list) {
			if(obj.getAvgCoveredCharges()<min||obj.getAvgCoveredCharges()>max) {
				isOutOfRange = true;
			}
		}
		assertFalse("cost is out of range",isOutOfRange);
	}
	@Test
	public void testGetSearchByCost_ratingIsOutOfRange() {
		JavaFuncForSQL func = new JavaFuncForSQL();
		double min = 1000;
		double max = 10000;
		int rating = 3;
		List<MixData> list = func.GetSearchByCost("038 - EXTRACRANIAL PROCEDURES W CC", min, max,rating);
		boolean isOutOfRange = false;
		for(MixData obj: list) {
			if(obj.getCustomerRating()<rating||obj.getCustomerRating()>5) {
				isOutOfRange = true;
			}
		}
		assertFalse("cost is out of range",isOutOfRange);
	}
	
	
	
	
	//Tests for procedure getSearchByCostWithRating 
	@Test
	public void testGetSearchByCostWithRatingIsEmpty(){
		JavaFuncForSQL func = new JavaFuncForSQL();
		double min = 1000;
		double max = 10000;
		int rating = 3;
		List<MixData> list = func.GetSearchByCostWithRating("038 - EXTRACRANIAL PROCEDURES W CC", min, max,rating);
		boolean isEmpty = list.isEmpty();
		assertFalse("data search by cost is empty",isEmpty);		
	}
	@Test
	public void testGetSearchByCostWithRating_costIsOutOfRange(){
		JavaFuncForSQL func = new JavaFuncForSQL();
		double min = 1000;
		double max = 10000;
		int rating = 3;
		List<MixData> list = func.GetSearchByCostWithRating("038 - EXTRACRANIAL PROCEDURES W CC", min, max, rating);
		boolean isOutOfRange = false;
		for(MixData obj: list) {
			if(obj.getAvgCoveredCharges()<min||obj.getAvgCoveredCharges()>max) {
				isOutOfRange = true;
			}
		}
		assertFalse("cost is out of range",isOutOfRange);		
	}
	@Test
	public void testGetSearchByCostWithRating_ratingIsOutOfRange() {
		JavaFuncForSQL func = new JavaFuncForSQL();
		double min = 1000;
		double max = 10000;
		int rating = 3;
		List<MixData> list = func.GetSearchByCostWithRating("038 - EXTRACRANIAL PROCEDURES W CC", min, max,rating);
		boolean isOutOfRange = false;
		for(MixData obj: list) {
			if(obj.getCustomerRating()<rating||obj.getCustomerRating()>5) {
				isOutOfRange = true;
			}
		}
		assertFalse("cost is out of range",isOutOfRange);
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
	@Test
	public void testGetSearchByProcedureWithRating_ratingIsOutOfRange() {
		JavaFuncForSQL func = new JavaFuncForSQL();
		int rating = 3;
		List<MixData> list = func.GetSearchByProcedureWithRating("038 - EXTRACRANIAL PROCEDURES W CC", rating);
		boolean isOutOfRange = false;
		for(MixData obj: list) {
			if(obj.getCustomerRating()<rating||obj.getCustomerRating()>5) {
				isOutOfRange = true;
			}
		}
		assertFalse("cost is out of range",isOutOfRange);
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
