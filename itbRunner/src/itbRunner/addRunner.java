package itbRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class addRunner {
	
	public addRunner(String runnerName, int runnerAge, String runnerCat) {
	
	connect myCon = new connect();
	
	try {
		// get a connection to database
		Connection myConn = DriverManager.getConnection(myCon.dbAddress,myCon.user,myCon.password);

		// create statement
		Statement myState = myConn.createStatement();
		// execute sql query
		myState.execute("INSERT INTO runner (runnerName, runnerAge, runningCategory) VALUES ('"+runnerName + "'," + runnerAge + ",'" + runnerCat+"')");
		
		
	} catch (Exception a) {
		// TODO: handle exception
		a.printStackTrace();
	}
	
	}
}