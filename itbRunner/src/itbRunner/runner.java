package itbRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class runner {
	private String runnerName;
	private String runnerCat;
	private int runnerAge;
	
	//no-args constructor
	public runner(){
		runnerName = "Not Running";
		runnerCat = "Null";
		runnerAge = 00;
	}
	
	// custom constructor
	public runner(String rName, String rCat, int rAge){
		runnerName = rName;
		runnerCat = rCat;
		runnerAge = rAge;
	}
	
	
	
	
	public void add(String runnerName,String runnerCat, int runnerAge) {
	try {

		// get a connection to database
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ITB", "root", "root");

		// create statement
		Statement myState = myConn.createStatement();
		
		// execute sql query
		myState.execute("INSERT INTO dept VALUES ("+runnerAge + ",'" + runnerName + "','" + runnerCat+"')");
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	}

}