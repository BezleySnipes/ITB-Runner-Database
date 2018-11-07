package itbRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class RunnerQueries {

	//Variable block
	public String dbAddress = "jdbc:mysql://localhost:3306/competition?autoReconnect=true&useSSL=false";
	public String user = "root";
	public String password = "root";
	private Connection myConn;
	private PreparedStatement mySta;
	private ResultSet myRs = null;

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
			mySta = myConn.prepareStatement("INSERT INTO runner (runnerName, runnerAge, runningCategory) VALUES (?,?,?)");
			mySta.setString(1, runnerName);
			mySta.setInt(2, runnerAge);
			mySta.setString(3, runnerCat);
			mySta.executeUpdate();
			JOptionPane.showMessageDialog(null, "Success!!!", "ITB Runner Database",1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Failed to insert a new runner, please try again.","ITB Runner Database",2);
		}

	}
	
	//Remove runner method
	public void remove(String runnerName) {
		try {
			getConnection();
			mySta = myConn.prepareStatement("DELETE FROM runner WHERE runnerName = ?");
			mySta.setString(1, runnerName);
			mySta.executeUpdate();
			JOptionPane.showMessageDialog(null, "Success!!!", "ITB Runner Database",1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Failed to remove that runner from the database, please try again!","ITB Runner Database",2);
		}
	}
	
	//Update runner method
	public void update(String runnerName,String runnerCat) {
		try {
			getConnection();
			mySta = myConn.prepareStatement("UPDATE runner SET runningCategory = ? WHERE runnerName = ?");
			mySta.setString(1, runnerCat);
			mySta.setString(2, runnerName);
			mySta.executeUpdate();
			JOptionPane.showMessageDialog(null, "Success!!!", "ITB Runner Database",1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Failed to update the database, please try again!","ITB Runner Database",2);
		}
	}
	
	//ShowAll runners method
	public void showAll() {
		try {
			getConnection();
			mySta = myConn.prepareStatement("SELECT runnerName,runnerAge,runningCategory FROM runner");
			myRs = mySta.executeQuery();
			JOptionPane.showMessageDialog(null, "Success!!!", "ITB Runner Database",1);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Failed to showAll","ITB Runner Database",2);
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
