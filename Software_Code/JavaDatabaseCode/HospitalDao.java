package jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import jdbc.domain.HospitalData;
import jdbc.domain.ProcedureData;

public class HospitalDao {

	
	public void SearchByCost(String DRGdefinition,double minCost, double maxCost){
		
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
			
			while(res.next()) {
				HospitalData hos = new HospitalData();
				ProcedureData pro = new ProcedureData();
				hos.setProviderId(res.getInt("Provider_Id"));
				hos.setProviderStreetAddress(res.getString("Provider_Street_Address"));
				hos.setProviderCity(res.getString("Provider_City"));
				hos.setProviderZipCode(res.getString("Provider_Zip_Code"));
				pro.setAvgCoveredCharges(res.getDouble("AverageCoveredCharges"));
				pro.setAvgTotalPayments(res.getDouble("AverageTotalPayments"));
				pro.setAvgMedicarePayments(res.getDouble("AverageMedicarePayments"));
				System.out.print("Provider Name:"+hos.getProviderName()
								+"\nProvider Street Address:"+hos.getProviderStreetAddress()
								+"\nProvider City:"+hos.getProviderCity()
								+"\nProvider Zip_Code:"+hos.getProviderCity()
								+"\nProvider Zip Code:"+hos.getProviderZipCode()
								+"\nAverage Covered Charges:"+pro.getAvgCoveredCharges()
								+"\nAverage Total Payments:"+pro.getAvgTotalPayments()
								+"\nAverage Medicare Payments:"+pro.getAvgMedicarePayments());
				System.out.println("");
				System.out.println("");
				
			}	
			
		}catch(Exception E) {
			E.printStackTrace();
		}finally{
			JDBCUtil.close(conn, st, res);
		}
	}
	
	
	
	
	public void SearchByProcedure(String procedure){
		
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
			
			while(res.next()) {
				HospitalData hos = new HospitalData();
				ProcedureData pro = new ProcedureData();
				hos.setProviderId(res.getInt("Provider_Id"));
				hos.setProviderStreetAddress(res.getString("Provider_Street_Address"));
				hos.setProviderCity(res.getString("Provider_City"));
				hos.setProviderZipCode(res.getString("Provider_Zip_Code"));
				pro.setAvgCoveredCharges(res.getDouble("AverageCoveredCharges"));
				pro.setAvgTotalPayments(res.getDouble("AverageTotalPayments"));
				pro.setAvgMedicarePayments(res.getDouble("AverageMedicarePayments"));
				System.out.print("Provider Name:"+hos.getProviderName()
								+"\nProvider Street Address:"+hos.getProviderStreetAddress()
								+"\nProvider City:"+hos.getProviderCity()
								+"\nProvider Zip_Code:"+hos.getProviderCity()
								+"\nProvider Zip Code:"+hos.getProviderZipCode()
								+"\nAverage Covered Charges:"+pro.getAvgCoveredCharges()
								+"\nAverage Total Payments:"+pro.getAvgTotalPayments()
								+"\nAverage Medicare Payments:"+pro.getAvgMedicarePayments());
				System.out.println("");
				System.out.println("");
		
			}	
			
		}catch(Exception E) {
			E.printStackTrace();
		}finally{
			JDBCUtil.close(conn, st, res);
		}
	}
	
	
	
	
}
