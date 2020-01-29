package jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import jdbc.domain.HospitalData;

public class HospitalDao {
	public void displayDataOrderById(){
		Connection conn = null;
		Statement st =null;
		ResultSet res=null;
		try{
			conn = JDBCUtil.getconn();
		    //创建SQL语句
			String sql="use 19agileteam3db";
			st = conn.createStatement();
			st.execute(sql);
			
			sql="select * from hospitals order by Provider_Id";
			
			//4.执行SQL
			res = st.executeQuery(sql);
			
			while(res.next()) {
				HospitalData hos = new HospitalData();
				hos.setProviderId(res.getInt("Provider_Id"));
				hos.setProviderName(res.getString("Provider_Name"));
				hos.setProviderStreetAddress(res.getString("Provider_Street_Address"));
				hos.setProviderCity(res.getString("Provider_City"));
				hos.setProviderState(res.getString("Provider_State"));
				hos.setProviderZipCode(res.getString("Provider_Zip_Code"));
				hos.setHrrDescription(res.getString("Hospital Referral Region (HRR) Description"));
				System.out.print(hos.toString());
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
