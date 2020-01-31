package JavaDatabaseCode;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import java.util.ArrayList;



public class HospitalDao {

//	public String orderByCost(){
//		return "procedurestable.AverageCoveredCharges";
//	}
//	public String orderByID() {
//		return "Provider_Id";
//	}
//	public String orderByRating(){
//		return "";
//	}
	
	
	
	
	
	public List<MixData> GetSearchByCost(String DRGdefinition,double minCost, double maxCost){
		
		Connection conn = null;
		Statement st =null;
		ResultSet res=null;
		try{
			conn = JDBCUtil.getconn();
			String sql="use 19agileteam3db";
			st = conn.createStatement();
			st.execute(sql);
			
			sql="call SearchByCost('"+DRGdefinition+"',"+minCost+","+maxCost+")";
			
			res = st.executeQuery(sql);
			List<MixData> list = new ArrayList<MixData>();
			
			while(res.next()) {
				HospitalData hos = new HospitalData();
				ProcedureData pro = new ProcedureData();
				MixData mix = new MixData();
				hos.setProviderId(res.getInt("Provider_Id"));
				hos.setProviderName(res.getString("Provider_Name"));
				hos.setProviderStreetAddress(res.getString("Provider_Street_Address"));
				hos.setProviderCity(res.getString("Provider_City"));
				hos.setProviderZipCode(res.getString("Provider_Zip_Code"));
				pro.setAvgCoveredCharges(res.getDouble("AverageCoveredCharges"));
				pro.setAvgTotalPayments(res.getDouble("AverageTotalPayments"));
				pro.setAvgMedicarePayments(res.getDouble("AverageMedicarePayments"));
				
				mix.setProviderId(hos.getProviderId());
				mix.setProviderName(hos.getProviderName());
				mix.setProviderStreetAddress(hos.getProviderStreetAddress());
				mix.setProviderCity(hos.getProviderCity());
				mix.setProviderZipCode(hos.getProviderZipCode());
				mix.setAvgCoveredCharges(pro.getAvgCoveredCharges());
				mix.setAvgTotalPayments(pro.getAvgTotalPayments());
				mix.setAvgMedicarePayments(pro.getAvgMedicarePayments());
				
				list.add(mix);
			}	
			return list;
			
		}catch(Exception E) {
			E.printStackTrace();
		}finally{
			JDBCUtil.close(conn, st, res);
		}
		return null;
	}
	
	


	




	
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
				HospitalData hos = new HospitalData();
				ProcedureData pro = new ProcedureData();
				MixData mix = new MixData();
				hos.setProviderId(res.getInt("Provider_Id"));
				hos.setProviderName(res.getString("Provider_Name"));
				hos.setProviderStreetAddress(res.getString("Provider_Street_Address"));
				hos.setProviderCity(res.getString("Provider_City"));
				hos.setProviderZipCode(res.getString("Provider_Zip_Code"));
				pro.setAvgCoveredCharges(res.getDouble("AverageCoveredCharges"));
				pro.setAvgTotalPayments(res.getDouble("AverageTotalPayments"));
				pro.setAvgMedicarePayments(res.getDouble("AverageMedicarePayments"));
				
				mix.setProviderId(hos.getProviderId());
				mix.setProviderName(hos.getProviderName());
				mix.setProviderStreetAddress(hos.getProviderStreetAddress());
				mix.setProviderCity(hos.getProviderCity());
				mix.setProviderZipCode(hos.getProviderZipCode());
				mix.setAvgCoveredCharges(pro.getAvgCoveredCharges());
				mix.setAvgTotalPayments(pro.getAvgTotalPayments());
				mix.setAvgMedicarePayments(pro.getAvgMedicarePayments());
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
	
	
	
	
	
	
	
	
	public List<MixData> CallLocationBasedOnIpv4(String ip,String procedure){
		Connection conn = null;
		Statement st =null;
		ResultSet res=null;
		try{
			conn = JDBCUtil.getconn();
			String sql="use 19agileteam3db";
			st = conn.createStatement();
			st.execute(sql);
			
			sql="call locationbasedonIpv4('"+ip+"','"+procedure+"')";
			
			res = st.executeQuery(sql);
			
			List<MixData> hosList = new ArrayList<MixData>();
			
			while(res.next()) {
				HospitalData hos = new HospitalData();
				ProcedureData pro = new ProcedureData();
				MixData mix = new MixData();
				hos.setProviderId(res.getInt("Provider_Id"));
				hos.setProviderName(res.getString("Provider_Name"));
				hos.setProviderZipCode(res.getString("Provider_Zip_Code"));
				pro.setDrgDefinition(res.getString("DRGDefinition"));
				pro.setAvgCoveredCharges(res.getDouble("AverageCoveredCharges"));
				pro.setAvgTotalPayments(res.getDouble("AverageTotalPayments"));
				pro.setAvgMedicarePayments(res.getDouble("AverageMedicarePayments"));
				
				mix.setProviderId(hos.getProviderId());
				mix.setProviderName(hos.getProviderName());
				mix.setProviderZipCode(hos.getProviderZipCode());
				mix.setDrgDefinition(pro.getDrgDefinition());
				mix.setAvgCoveredCharges(pro.getAvgCoveredCharges());
				mix.setAvgTotalPayments(pro.getAvgTotalPayments());
				mix.setAvgMedicarePayments(pro.getAvgMedicarePayments());
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
	
	
	
	
	public List<MixData> CallLocationBasedOnZipCode(String zipCode,String procedure){
		Connection conn = null;
		Statement st =null;
		ResultSet res=null;
		try{
			conn = JDBCUtil.getconn();
			String sql="use 19agileteam3db";
			st = conn.createStatement();
			st.execute(sql);
			
			sql="call locationbasedonzipcode('"+zipCode+"','"+procedure+"')";
			
			res = st.executeQuery(sql);
			
			List<MixData> hosList = new ArrayList<MixData>();
			
			while(res.next()) {
				HospitalData hos = new HospitalData();
				ProcedureData pro = new ProcedureData();
				MixData mix = new MixData();
				hos.setProviderId(res.getInt("Provider_Id"));
				hos.setProviderName(res.getString("Provider_Name"));
				hos.setProviderZipCode(res.getString("Provider_Zip_Code"));
				pro.setDrgDefinition(res.getString("DRGDefinition"));
				pro.setAvgCoveredCharges(res.getDouble("AverageCoveredCharges"));
				pro.setAvgTotalPayments(res.getDouble("AverageTotalPayments"));
				pro.setAvgMedicarePayments(res.getDouble("AverageMedicarePayments"));
				
				mix.setProviderId(hos.getProviderId());
				mix.setProviderName(hos.getProviderName());
				mix.setProviderZipCode(hos.getProviderZipCode());
				mix.setDrgDefinition(pro.getDrgDefinition());
				mix.setAvgCoveredCharges(pro.getAvgCoveredCharges());
				mix.setAvgTotalPayments(pro.getAvgTotalPayments());
				mix.setAvgMedicarePayments(pro.getAvgMedicarePayments());
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
	
	
	
	
}












