package itbRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Database {

	//Variable block
	public String dbAddress = "jdbc:mysql://localhost:3306/competition?autoReconnect=true&useSSL=false";
	public String user = "root";
	public String password = "root";
	public Connection myConn;
	public Statement myState;

	// Create and return a valid connection to the user
	public Connection getConnection() {
		try {
			myConn = DriverManager.getConnection(dbAddress, user, password);
		} catch (Exception a) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Connection to the database failed, check your connection settings.","ITB Runner Database",0);
		}
		return myConn;
	}
	
	//Add runner method
	public void insert(String runnerName, int runnerAge, String runnerCat) {
		try {
			getConnection();
			Statement myState = myConn.createStatement();
			myState.execute("INSERT INTO runner (runnerName, runnerAge, runningCategory) VALUES ('" + runnerName + "',"+ runnerAge + ",'" + runnerCat + "')");
			JOptionPane.showMessageDialog(null, "Success!!!", "ITB Runner Database",1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Failed to insert a new runner, please try again.","ITB Runner Database",2);
		}

	}
	
	//Remove runner method
	public void remove(int runnerId) {
		try {
			getConnection();
			Statement myState = myConn.createStatement();
			myState.execute("DELETE FROM runner WHERE runnerID = '" + runnerId + "'");
			JOptionPane.showMessageDialog(null, "Success!!!", "ITB Runner Database",1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Failed to remove that runner from the database, please try again!","ITB Runner Database",2);
		}
	}
	
	//Update runner method
	public void update(int runnerId,String runnerCat) {
		try {
			getConnection();
			Statement myState = myConn.createStatement();
			myState.execute("UPDATE runner SET runningCategory = '"+runnerCat+"' WHERE runnerID = '"+runnerId+"'");
			JOptionPane.showMessageDialog(null, "Success!!!", "ITB Runner Database",1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Failed to update the database, please try again!","ITB Runner Database",2);
		}
	}

	//Getters and Setters area
	public String getDbAddress() {
		return dbAddress;
	}

	public void setDbAddress(String dbAddress) {
		this.dbAddress = dbAddress;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
