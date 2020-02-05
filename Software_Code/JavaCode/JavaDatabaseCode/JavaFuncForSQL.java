package JavaDatabaseCode;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import java.util.ArrayList;



public class JavaFuncForSQL {

//	public String orderByCost(){
//		return "procedurestable.AverageCoveredCharges";
//	}
//	public String orderByID() {
//		return "Provider_Id";
//	}
//	public String orderByRating(){
//		return "";
//	}
	
	
	
	// get List of data which searched by procedure definition and cost range(average covered charges) 
	// arguments are procedures DRG definition, minimum cost and maximum cost
	// order by cost

	public List<MixData> GetSearchByCost(String DRGdefinition,double minCost, double maxCost, int rating){

		
		Connection conn = null;
		Statement st =null;
		ResultSet res=null;
		try{
			conn = JDBCUtil.getconn();
			String sql="use 19agileteam3db";
			st = conn.createStatement();
			st.execute(sql);
			
			sql="call SearchByCost('"+DRGdefinition+"',"+minCost+","+maxCost+","+rating+")";

			
			res = st.executeQuery(sql);
			List<MixData> hosList = new ArrayList<MixData>();
			
			while(res.next()) {
				MixData mix = new MixData();
				mix.setProviderId(res.getInt("Provider_Id"));
				mix.setProviderName(res.getString("Provider_Name"));
				mix.setProviderStreetAddress(res.getString("Provider_Street_Address"));
				mix.setProviderCity(res.getString("Provider_City"));
				mix.setProviderZipCode(res.getString("Provider_Zip_Code"));
				mix.setAvgCoveredCharges(res.getDouble("AverageCoveredCharges"));
				mix.setAvgTotalPayments(res.getDouble("AverageTotalPayments"));
				mix.setAvgMedicarePayments(res.getDouble("AverageMedicarePayments"));
				mix.setCustomerRating(res.getInt("CustomerRating"));
				mix.setLatitude(res.getDouble("Latitude"));
				mix.setLongitude(res.getDouble("Longitude"));
				hosList.add(mix);
			}	
			return hosList;
			
		}catch(Exception E) {
			E.printStackTrace();
		}finally{
			JDBCUtil.close(conn, st, res);
		}
		return null;
	}
	
	// get List of data which searched by procedure definition and cost range(average covered charges) and customer rating
	// arguments are procedures DRG definition, minimum cost and maximum cost 
	// order by customer rating
	public List<MixData> GetSearchByCostWithRating(String DRGdefinition,double minCost, double maxCost,int rating){
		
		Connection conn = null;
		Statement st =null;
		ResultSet res=null;
		try{
			conn = JDBCUtil.getconn();
			String sql="use 19agileteam3db";
			st = conn.createStatement();
			st.execute(sql);
			
			sql="call SearchByCostWithRating('"+DRGdefinition+"',"+minCost+","+maxCost+","+rating+")";
			
			res = st.executeQuery(sql);
			List<MixData> hosList = new ArrayList<MixData>();
			
			while(res.next()) {
				MixData mix = new MixData();
				mix.setProviderId(res.getInt("Provider_Id"));
				mix.setProviderName(res.getString("Provider_Name"));
				mix.setProviderStreetAddress(res.getString("Provider_Street_Address"));
				mix.setProviderCity(res.getString("Provider_City"));
				mix.setProviderZipCode(res.getString("Provider_Zip_Code"));
				mix.setAvgCoveredCharges(res.getDouble("AverageCoveredCharges"));
				mix.setAvgTotalPayments(res.getDouble("AverageTotalPayments"));
				mix.setAvgMedicarePayments(res.getDouble("AverageMedicarePayments"));
				mix.setCustomerRating(res.getInt("CustomerRating"));
				mix.setLatitude(res.getDouble("Latitude"));
				mix.setLongitude(res.getDouble("Longitude"));
				hosList.add(mix);
			}	
			return hosList;
			
		}catch(Exception E) {
			E.printStackTrace();
		}finally{
			JDBCUtil.close(conn, st, res);
		}
		return null;
	}


	// get List of data which searched by procedure definition
	// arguments are procedures DRG definition
	// order by cost
	public List<MixData> GetSearchByProcedure(String procedure){
		Connection conn = null;
		Statement st =null;
		ResultSet res=null;
		try{
			conn = JDBCUtil.getconn();
			String sql="use 19agileteam3db";
			st = conn.createStatement();
			st.execute(sql);
			
			sql="call SearchByProcedure('"+procedure+"')";
			
			res = st.executeQuery(sql);
			
			List<MixData> hosList = new ArrayList<MixData>();
			
			while(res.next()) {
				MixData mix = new MixData();
				mix.setProviderId(res.getInt("Provider_Id"));
				mix.setProviderName(res.getString("Provider_Name"));
				mix.setProviderStreetAddress(res.getString("Provider_Street_Address"));
				mix.setProviderCity(res.getString("Provider_City"));
				mix.setProviderZipCode(res.getString("Provider_Zip_Code"));
				mix.setAvgCoveredCharges(res.getDouble("AverageCoveredCharges"));
				mix.setAvgTotalPayments(res.getDouble("AverageTotalPayments"));
				mix.setAvgMedicarePayments(res.getDouble("AverageMedicarePayments"));
				mix.setCustomerRating(res.getInt("CustomerRating"));
				mix.setLatitude(res.getDouble("Latitude"));
				mix.setLongitude(res.getDouble("Longitude"));
				hosList.add(mix);
			}	
			return hosList;
			
		}catch(Exception E) {
			E.printStackTrace();
		}finally{
			JDBCUtil.close(conn, st, res);
		}
		return null;
	}
	
	
	
	// get List of data which searched by procedure definition and minimum rating
	// arguments are procedures DRG definition and minimum rating
	// order by rating 
	public List<MixData> GetSearchByProcedureWithRating(String procedure, int rating) {
		Connection conn = null;
		Statement st =null;
		ResultSet res=null;
		try{
			conn = JDBCUtil.getconn();
			String sql="use 19agileteam3db";
			st = conn.createStatement();
			st.execute(sql);
			
			sql="call SearchByProcedureWithRating('"+procedure+"',"+rating+")";
			
			res = st.executeQuery(sql);
			
			List<MixData> hosList = new ArrayList<MixData>();
			
			while(res.next()) {
				MixData mix = new MixData();
				mix.setProviderId(res.getInt("Provider_Id"));
				mix.setProviderName(res.getString("Provider_Name"));
				mix.setProviderStreetAddress(res.getString("Provider_Street_Address"));
				mix.setProviderCity(res.getString("Provider_City"));
				mix.setProviderZipCode(res.getString("Provider_Zip_Code"));
				mix.setAvgCoveredCharges(res.getDouble("AverageCoveredCharges"));
				mix.setAvgTotalPayments(res.getDouble("AverageTotalPayments"));
				mix.setAvgMedicarePayments(res.getDouble("AverageMedicarePayments"));
				mix.setCustomerRating(res.getInt("CustomerRating"));
				mix.setLatitude(res.getDouble("GeoLatitude"));
				mix.setLongitude(res.getDouble("GeoLongitude"));
				hosList.add(mix);
			}	
			return hosList;
			
		}catch(Exception E) {
			E.printStackTrace();
		}finally{
			JDBCUtil.close(conn, st, res);
		}
		return null;
	}
		
	
	public List<MixData> ReturnsortedProcedures(){
		Connection conn = null;
		Statement st =null;
		ResultSet res=null;
		try{
			conn = JDBCUtil.getconn();
			String sql="use 19agileteam3db";
			st = conn.createStatement();
			st.execute(sql);
			
			sql="call returnSortedProcedures";
			
			res = st.executeQuery(sql);
			
			List<MixData> proList = new ArrayList<MixData>();
			
			while(res.next()) {
				MixData mix = new MixData();
				mix.setIdDefiniton(res.getInt("idDefinitionsTable"));
				mix.setDrgDefinition(res.getString("DRG_Definition"));
				proList.add(mix);
			}	
			return proList;
			
		}catch(Exception E) {
			E.printStackTrace();
		}finally{
			JDBCUtil.close(conn, st, res);
		}
		return null;
	}
	
	public List<MixData> GetSortByRating(String DRGdefinition,int Rating)
	{
		
		//Connection clause, called later
		Connection conn = null;
		Statement state =null;
		ResultSet result=null;
		try{
			//Try Connection to the database, use the schema provided
			conn = JDBCUtil.getconn();
			String sql="use 19agileteam3db";
			state = conn.createStatement();
			state.execute(sql);
		
			//Calls the specific method with its parametres
			sql="call SearchByCost('"+DRGdefinition+"',"+Rating+")";
		
			//Calls the valued Results
			result = state.executeQuery(sql);
			List<MixData> list = new ArrayList<MixData>();
		
			//While the data has another entry, call to here
			while(result.next()) 
			{
				//All of the Calls are performed here, they function as set values, then apply that to the list
				HospitalData hospital = new HospitalData();
				ProcedureData procedure = new ProcedureData();
				GEOlocation geoloc = new GEOlocation();
				MixData mix = new MixData();
				hospital.setProviderName(result.getString("Provider_Name"));
				hospital.setProviderStreetAddress(result.getString("Provider_Street_Address"));
				geoloc.setLatitude(result.getDouble("Latitude"));
				geoloc.setLongitude(result.getDouble("Longitude"));
				procedure.setAvgCoveredCharges(result.getDouble("AverageCoveredCharges"));
				procedure.setAvgTotalPayments(result.getDouble("AverageTotalPayments"));
				procedure.setAvgMedicarePayments(result.getDouble("AverageMedicarePayments"));
				
				mix.setProviderName(hospital.getProviderName());
				mix.setLatitude(geoloc.getLatitude());
				mix.setLongitude(geoloc.getLongitude());
				mix.setAvgCoveredCharges(procedure.getAvgCoveredCharges());
				mix.setAvgTotalPayments(procedure.getAvgTotalPayments());
				mix.setAvgMedicarePayments(procedure.getAvgMedicarePayments());
				list.add(mix);
			}	
			return list;
			
		}
		//Finishes the Catch Statement
		catch(Exception E) 
		{
			E.printStackTrace();
		}
		finally
		{
			JDBCUtil.close(conn, state, result);
		}
		return null;
	}
	
	
	
	public void AddReview(int ID, int rating) {
		Connection conn = null;
		Statement st =null;
		ResultSet res=null;
		try{
			conn = JDBCUtil.getconn();
			String sql="use 19agileteam3db";
			st = conn.createStatement();
			st.execute(sql);
			
			sql="call AddReview("+ID+","+rating+")";
			st.execute(sql);
			
			
		}catch(Exception E) {
			E.printStackTrace();
		}finally{
			JDBCUtil.close(conn, st, res);
		}
	}
	
}












