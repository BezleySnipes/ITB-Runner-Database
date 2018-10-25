package itbRunner;

import java.sql.*;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			// get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ITB", "root", "root");

			// create statement
			Statement myState = myConn.createStatement();

			ResultSet myRs = myState.executeQuery("select ename,sal from emp where sal between 1500 and 3000");
			// process the result set
			while (myRs.next()) {
				System.out.println(myRs.getString("ENAME") + " , " + myRs.getString("SAL"));
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
