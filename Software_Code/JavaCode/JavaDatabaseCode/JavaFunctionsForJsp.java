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
	
	
	/**
	 * Order of ArrayList indices
	 * .get(0) hospital name
	 * .get(1) hospital address
	 * .get(2) longitude
	 * .get(3) latitude
	 * .get(4) cost
	 * .get(5) rating
	 * 
	 * @param procedure  
	 * @param lowerBound
	 * @param upperBound
	 * @param starRating
	 * @param sort
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<ArrayList<String>> findHospitalByProcedure(String procedure, int lowerBound, int upperBound, int starRating, int sort) throws ClassNotFoundException
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
			
			String sql ="";

			if (sort == 1)
				sql = "call 19agileteam3db.SearchByCost('" + procedure + "', "+ lowerBound +", "+ upperBound +", "+starRating+");";
			else if (sort == 2)
				sql = "call 19agileteam3db.SearchByCost('" + procedure + "', "+ lowerBound +", "+ upperBound +", "+starRating+");";
			else if (sort == 3)
				sql = "call 19agileteam3db.SearchByCostWithRating('" + procedure + "', "+ lowerBound +", "+ upperBound +", "+starRating+");";
			
			ResultSet rs = statement.executeQuery(sql);
					
			ArrayList<ArrayList<String>> hospitalList = new ArrayList<ArrayList<String>>();
			while (rs.next()) 
			{   //Retrieve by column name 
				
				// store and add each hospital and address into hospitalList
				ArrayList<String> hospitalListRowToAdd = new ArrayList<String>();
				String hospital = rs.getString("Provider_Name");
				hospitalListRowToAdd.add(hospital);
				String address = rs.getString("Provider_Street_Address");
				hospitalListRowToAdd.add(address);
				
				// retrieve, convert from Double to String, and add longitude and latitude 
				Double x = rs.getDouble("longitude");
				Double y = rs.getDouble("latitude");
				String longitude = Double.toString(x);
				String latitude = Double.toString(y);
				hospitalListRowToAdd.add(longitude);
				hospitalListRowToAdd.add(latitude);
				
				// retrieve, convert from Double to String, and add cost
				Double cost = rs.getDouble("AverageTotalPayments");
				String procedureCost = Double.toString(cost);
				hospitalListRowToAdd.add(procedureCost);
				
				// retrieve, convert from integer to String, and add rating
				int rating = rs.getInt("CustomerRating");
				String procedureRating = Integer.toString(rating);
				hospitalListRowToAdd.add(procedureRating);
				
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
