package jdbcdemo;
import java.sql.*;
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//1. getting a connection to db
			Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","student","student");
			//2. create a statement obj
			//3.execute SQL query
			//4.process result
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
