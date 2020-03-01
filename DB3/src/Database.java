import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


// TODO: put the connection in the connectName string for use with DriverManager.getConnection()
// Implement main() function
// Implement html interface
// Implement exception handling

public class Database {
	private static Connection connect = null;
	private static Statement statement = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;
	private static String connectName = "";

	public static void main(String args[]) {

		

		

		
	}

	
	void Initialize() {
		String initialize = "CREATE SCHEMA IF NOT EXISTS DATA"
	+ "CREATE TABLE IF NOT EXISTS USERS ("
				+ "USER VARCHAR(20) "
				+ "PASSWORD VARCHAR(20) "
				+ "FIRSTNAME VARCHAR(20)"
				+ "LASTNAME VARCHAR(20)"
				+ "EMAIL VARCHAR(40)"
				+ "PRIMARY KEY (USER))";
		try {

			connect = DriverManager.getConnection(connectName);

			statement = connect.createStatement();

			statement.executeUpdate(initialize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void registration() { // TODO: Implement a method to get the following strings from the user
		String username = "";
		String password = "";
		String firstName = "";
		String lastName = "";
		String email = "";
		
		String registration = "INSERT INTO USERS" + " (USER, PASSWORD, FIRSTNAME, LASTNAME, EMAIL)"
				+ " VALUES (?, ?, ?, ?, ?)";
		try {

			connect = DriverManager.getConnection(connectName);

			preparedStatement = connect
					.prepareStatement(registration);
				    preparedStatement.setString(1, "Shiyong Lu");
				    preparedStatement.setString(2, "123 Main Street, Troy, MI 48083");
				    preparedStatement.setString(3, "Senior");
				    preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void login() {// TODO: Implement most of this function
		String username = "";
		String password = "";
		
		String login = "SELECT FROM USERS WHERE" + " (USER = \"" + username + "\" AND PASSWORD = \"" + password + "\")";
		
		try {

			connect = DriverManager.getConnection(connectName);

			preparedStatement = connect
					.prepareStatement(login);
				    preparedStatement.setString(1, username);
				    preparedStatement.setString(2, password);
				    preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
