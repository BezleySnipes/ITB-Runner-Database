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
	
	connect myCon = new connect();
	
	//no-args constructor
	public runner(){
		runnerName = "Not Running";
		runnerAge = 00;
		runnerCat = "Null";
	}
	
	// custom constructor
	public runner(String rName, int rAge, String rCat){
		runnerName = rName;
		runnerCat = rCat;
		runnerAge = rAge;
	}
	
	
public void remove(int runnerID) {
	try {
		// get a connection to database
		Connection myConn = DriverManager.getConnection(myCon.dbAddress,myCon.user,myCon.password);

		// create statement
		Statement myState = myConn.createStatement();
		
		// execute sql query
		myState.execute("DELETE FROM runner WHERE runnerID = '"+runnerID+"'");
		
		
	} catch (Exception r) {
//		
//		
//		
//		
//		
//		
		}
}
	
public void add(String runnerName, int runnerAge, String runnerCat) {
//	try {
//		// get a connection to database
//		Connection myConn = DriverManager.getConnection(dbAddress,user,password);
//
//		// create statement
//		Statement myState = myConn.createStatement();
//		// execute sql query
//		myState.execute("INSERT INTO runner (runnerName, runnerAge, runningCategory) VALUES ('"+runnerName + "'," + runnerAge + ",'" + runnerCat+"')");
//		
//		
//	} catch (Exception a) {
//		// TODO: handle exception
//		a.printStackTrace();
//	}
	addRunner newRunner = new addRunner(runnerName,runnerAge,runnerCat);
}
}