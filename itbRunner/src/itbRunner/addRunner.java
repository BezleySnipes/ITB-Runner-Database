package itbRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class addRunner {
	
	public addRunner(String runnerName, int runnerAge, String runnerCat) {
	
	Database myDb = new Database();
	
	try {
		// get a connection to database
		Connection myConn = myDb.getConnection();

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
