package jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MedicalDataDao {

	public void DisplayAll() {
		Connection conn = null;
		Statement st =null;
		ResultSet res=null;
		try{
			conn = JDBCUtil.getconn();
		    //创建SQL语句
			String sql="use agileschema";
			st = conn.createStatement();
			st.execute(sql);
			
			sql="select * from MedicalData";
			
			//4.执行SQL
			res = st.executeQuery(sql);
			
			while(res.next()) {
				int medID = res.getInt("MedID");
				String definition =res.getString("DRGDefinition");
				int providerID = res.getInt("ProviderId");
				String providerName = res.getString("ProviderName");
				String providerStreetAddr = res.getString("ProviderStreetAddress");
				String providerCityAddr = res.getString("ProviderCity"); 
				String providerState = res.getString("ProviderState");
				String providerZipCode = res.getString("ProviderZipCode"); 
				String hospitalHRRDescription = res.getString("HospitalReferralRegion(HRR)Description");
				int totalDischarges = res.getInt("TotalDischarges");
				double avgCoveredCharge = res.getDouble("AverageCoveredCharges");
				double avgTotalPayments = res.getDouble("AverageTotalPayments");
				double avgMedicarePayments = res.getDouble("AverageMedicarePayments");
				
				System.out.println("MedID: "+medID+"\nDRG Definitio: "+definition+"\nProvider Id: "+providerID
						+"\nProvider Name: "+providerName+"\nProvider Street Address: "+providerStreetAddr
						+"\nProvider City: "+providerCityAddr+"\nProvider State: "+providerState
						+"\nProvider Zip Code: "+providerZipCode+"\nHospital Referral Region (HRR) Description: "+hospitalHRRDescription
						+"\nTotal Discharges: "+totalDischarges+"\nAverage Covered Charges: "+avgCoveredCharge
						+"\nAverage Total Payments: "+avgTotalPayments+"\nAverage Medicare Payments: "+avgMedicarePayments);
				System.out.println("");
				System.out.println("");
				System.out.println("");
			}	
		}catch(Exception E) {
			E.printStackTrace();
		}finally{
			JDBCUtil.close(conn, st, res);
		}
	}


	public void DisplayOrderByCost(){
		Connection conn = null;
		Statement st =null;
		ResultSet res=null;
		try{
			conn = JDBCUtil.getconn();
		    //创建SQL语句
			String sql="use agileschema";
			st = conn.createStatement();
			st.execute(sql);
			
			sql="call CostProcedure()";
			
			//4.执行SQL
			res = st.executeQuery(sql);
			
			while(res.next()) {
				int medID = res.getInt("MedID");
				String definition =res.getString("DRGDefinition");
				int providerID = res.getInt("ProviderId");
				String providerName = res.getString("ProviderName");
				String providerStreetAddr = res.getString("ProviderStreetAddress");
				String providerCityAddr = res.getString("ProviderCity"); 
				String providerState = res.getString("ProviderState");
				String providerZipCode = res.getString("ProviderZipCode"); 
				String hospitalHRRDescription = res.getString("HospitalReferralRegion(HRR)Description");
				int totalDischarges = res.getInt("TotalDischarges");
				double avgCoveredCharge = res.getDouble("AverageCoveredCharges");
				double avgTotalPayments = res.getDouble("AverageTotalPayments");
				double avgMedicarePayments = res.getDouble("AverageMedicarePayments");
				
				System.out.println("MedID: "+medID+"\nDRG Definitio: "+definition+"\nProvider Id: "+providerID
						+"\nProvider Name: "+providerName+"\nProvider Street Address: "+providerStreetAddr
						+"\nProvider City: "+providerCityAddr+"\nProvider State: "+providerState
						+"\nProvider Zip Code: "+providerZipCode+"\nHospital Referral Region (HRR) Description: "+hospitalHRRDescription
						+"\nTotal Discharges: "+totalDischarges+"\nAverage Covered Charges: "+avgCoveredCharge
						+"\nAverage Total Payments: "+avgTotalPayments+"\nAverage Medicare Payments: "+avgMedicarePayments);
				System.out.println("");
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
