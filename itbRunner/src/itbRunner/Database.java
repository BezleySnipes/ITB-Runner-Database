package itbRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;




public class Database {
	
	public String dbAddress = "jdbc:mysql://localhost:3306/competition?autoReconnect=true&useSSL=false" ;
	public String user = "root";
	public String password = "root";
	public Connection myConn;
	public Statement myState;

	
	public Connection getConnection() {
		try {
		myConn = DriverManager.getConnection(dbAddress,user,password);
		} catch (Exception a) {
		// TODO: handle exception
		JOptionPane.showMessageDialog(null, "Connection to the database failed, check your connection settings.");;}
		return myConn;
	}
	
	public void insert(String runnerName, int runnerAge, String runnerCat) {
		try {
			getConnection();
			Statement myState = myConn.createStatement();
			myState.execute("INSERT INTO runner (runnerName, runnerAge, runningCategory) VALUES ('"+runnerName + "'," + runnerAge + ",'" + runnerCat+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
