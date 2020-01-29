package JavaDatabaseCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JavaFunctionsForJsp {
	public static String url = "jdbc:mysql://silva.computing.dundee.ac.uk:3306";
	public static String user = "19agileteam3";
	public static String psw = "9047.at3.7409";
	public static String DriverName = "com.mysql.jdbc.Driver";
	
	public static Connection conn = null;
	
	public static void main(String[] args) throws Exception
	{
		String procedureName = "001 - HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC";
		findHospitalByProcedure(procedureName);
	}
	
	public static String returnMessage()
	{
		return "Hi there";
	}
	
	public static ArrayList<ArrayList<String>> findHospitalByProcedure(String procedure) throws ClassNotFoundException
	{
		ArrayList<ArrayList<String>> hospitalListToReturn = new ArrayList<ArrayList<String>>();
		
		// structure for code taken from: https://dev.mysql.com/doc/connector-j/5.1/en/connector-j-usagenotes-connect-drivermanager.html
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, psw);
			
			// Do something with the Connection
			Statement statement = conn.createStatement();
			String sql = "call 19agileteam3db.searchHospitalByProcedure('" + procedure + "')";
			ResultSet rs = statement.executeQuery(sql);
					
			ArrayList<ArrayList<String>> hospitalList = new ArrayList<ArrayList<String>>();
			while (rs.next()) 
			{   //Retrieve by column name 
				
				// store and add each hospital and address into hospitalList
				ArrayList<String> hospitalListRowToAdd = new ArrayList<String>();
				String hospital = rs.getString("Hospital");
				hospitalListRowToAdd.add(hospital);
				String address = rs.getString("Address");
				hospitalListRowToAdd.add(address);
				
				hospitalList.add(hospitalListRowToAdd);
				
			}
			/*
			 * System.out.println("hospitalList size: " + hospitalList.size()); for (int i =
			 * 0; i < hospitalList.size(); i++) { System.out.println(hospitalList.get(i)); }
			 */
			 
			// set return list if procedure successfully ran
			hospitalListToReturn = hospitalList;
		} 
		catch (SQLException ex) 
		{
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    
		    // set return list to null if errors occur
		    hospitalListToReturn = null;
		}
		
		return hospitalListToReturn;
	}
}
