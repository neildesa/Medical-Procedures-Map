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
		 ArrayList<ArrayList<String>> hospitalListTest = new ArrayList<ArrayList<String>>();
		
		  String procedureName = "001 - HEART TRANSPLANT OR IMPLANT OF HEART ASSIST SYSTEM W MCC";
		/*
		 * hospitalListTest = findHospitalByProcedure(procedureName, 600000, 800000);
		 * System.out.println("size: " + hospitalListTest.size());
		 */
		 
		  //findHospitalByProcedure(procedureName);
		  
		/* returnListOfProcedures(); */
	}
	
	
	public static ArrayList<ArrayList<String>> findHospitalByProcedure(String procedure) throws ClassNotFoundException
	{		
		// structure for code taken from: https://dev.mysql.com/doc/connector-j/5.1/en/connector-j-usagenotes-connect-drivermanager.html
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, psw);
			
			// Do something with the Connection
			Statement statement = conn.createStatement();
			System.out.println("procedure: " + procedure);
			String sql = "call 19agileteam3db.callLongitudeAndLatitude('" + procedure + "');";
			ResultSet rs = statement.executeQuery(sql);
					
			ArrayList<ArrayList<String>> hospitalList = new ArrayList<ArrayList<String>>();
			while (rs.next()) 
			{   //Retrieve by column name 
				
				// store and add each hospital and address 
				ArrayList<String> hospitalListRowToAdd = new ArrayList<String>();
				String hospital = rs.getString("Provider_Name");
				hospitalListRowToAdd.add(hospital);
				String address = rs.getString("Provider_Street_Address");
				hospitalListRowToAdd.add(address);
				
				// store, convert to string, and add each hospital longitude & latitude 
				Double x = rs.getDouble("longitude");
				String longitude = Double.toString(x);
				hospitalListRowToAdd.add(longitude);
				
				Double y = rs.getDouble("latitude");
				String latitude = Double.toString(y);
				hospitalListRowToAdd.add(latitude);
				
				// add facility (hospital) of procedure and associated info to hospitalList
				hospitalList.add(hospitalListRowToAdd);
				
			}
			
			
			/*
			 * System.out.println("hospitalList size: " + hospitalList.size()); for (int i =
			 * 0; i < hospitalList.size(); i++) { System.out.println(hospitalList.get(i)); }
			 */
			 
			 
			// set return list if procedure successfully ran
			return hospitalList;
		} 
		catch (SQLException ex) 
		{
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    
		    // set return list to null if errors occur
		    return null;
		}
		
	
	}
	
	public static ArrayList<ArrayList<String>> findHospitalByProcedure(String procedure, int lowerBound, int upperBound) throws ClassNotFoundException
	{		
		// structure for code taken from: https://dev.mysql.com/doc/connector-j/5.1/en/connector-j-usagenotes-connect-drivermanager.html
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, psw);
			
			// Do something with the Connection
			Statement statement = conn.createStatement();
			System.out.println("Procedure : " + procedure);
			System.out.println("Cost      : " + lowerBound + " - " + upperBound);
			String sql = "call 19agileteam3db.SearchByCost('" + procedure + "', "+ lowerBound +", "+ upperBound +");";
			ResultSet rs = statement.executeQuery(sql);
					
			ArrayList<ArrayList<String>> hospitalList = new ArrayList<ArrayList<String>>();
			while (rs.next()) 
			{   //Retrieve by column name 
				
				// store and add each hospital and address
				ArrayList<String> hospitalListRowToAdd = new ArrayList<String>();
				String hospital = rs.getString("Provider_Name");
				hospitalListRowToAdd.add(hospital);
				String address = rs.getString("Provider_Street_Address");
				hospitalListRowToAdd.add(address);
				
				// add cost of procedure (as a double converted to string)
				double cost = rs.getDouble("AverageTotalPayments");
				String procedureCost = Double.toString(cost);
				hospitalListRowToAdd.add(procedureCost);
				
				
				
				// add facility (hospital) of procedure and associated info to hospitalList
				hospitalList.add(hospitalListRowToAdd);
				
			}
			
			/*
			 * System.out.println("hospitalList size: " + hospitalList.size()); for (int i =
			 * 0; i < hospitalList.size(); i++) { System.out.println(hospitalList.get(i)); }
			 */
			 
			// set return list if procedure successfully ran
			return hospitalList;
		} 
		catch (SQLException ex) 
		{
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    
		    // set return list to null if errors occur
		    return null;
		}
		
	}
	
	public static ArrayList<String> returnListOfProcedures() throws ClassNotFoundException 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, psw);
			
			ArrayList<String> procedureList = new ArrayList<String>();
			
			Statement statement = conn.createStatement();
			String sql = "call 19agileteam3db.returnSortedProcedures();";
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next())
			{
				String procedure = rs.getString("DRG_Definition");
				procedureList.add(procedure);
			}
			
			/* call this locally to print out the entire array list for testing
			 * for (int i = 0; i < procedureList.size() ; i++) {
			 * System.out.println(procedureList.get(i) + ", "); }
			 */
			
			return procedureList;

		} 
		catch (SQLException ex) 
		{
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    
		    return null;
		}
	}
}
