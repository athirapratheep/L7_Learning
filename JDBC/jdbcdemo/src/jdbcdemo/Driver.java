package jdbcdemo;

import java.io.Reader;
import java.sql.*;
import java.util.*;


public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// 1. getting a connection to db
			
//			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutorial", "root", "root");
			
			// 2. create a statement obj
			
//			Statement myStmt = myConn.createStatement();
			
			// 3.execute SQL query
//			String sql = "delete from employee where emp_id=160";
			
			
//			PreparedStatement myStmt=myConn.prepareStatement("select * from employee where salary > ?");
//			myStmt.setInt(1, 100000);
//			ResultSet myRs = myStmt.executeQuery();
//			display(myRs);
			
			
//			int rowsAffected=myStmt.executeUpdate(sql);
//			System.out.println("Rows Affected:" + rowsAffected);
//			System.out.println("change complete");
			
//			CallableStatement myStmt=myConn.prepareCall("{call insert_employee(?,?,?,?,?,?,?,?)}");
//			myStmt.setInt(1, 140);
//			myStmt.setString(2, "mary");
//			myStmt.setString(3, "doll");
//			myStmt.setString(4, "1975-09-03");
//			myStmt.setString(5, "M");
//			myStmt.setInt(6, 340000);
//			myStmt.setInt(7, 100);
//			myStmt.setInt(8,2);
//			myStmt.execute();
//			
//			CallableStatement NewStmt = myConn.prepareCall("{call modify_sal(?)}");
//			NewStmt.setInt(1, 12000);
//			NewStmt.registerOutParameter(1, Types.INTEGER);
//			NewStmt.execute();
//			
//			CallableStatement newStmt = myConn.prepareCall("{call get_count_branch(?,?)}");
//			newStmt.setInt(1, 2);
//			newStmt.registerOutParameter(2, Types.INTEGER);
//			newStmt.execute();
//			int count=newStmt.getInt(2);
//			System.out.println("The count is: "+ count);
			
//			CallableStatement newStmt = myConn.prepareCall("{call get_employees_name(?)}");
//			newStmt.setString(1, "F");
//			newStmt.execute();
//			ResultSet myRs = newStmt.getResultSet();
//			display(myRs);
//			boolean ok=askUserIfOKToSave();
			
//			DatabaseMetaData databaseMetaData = myConn.getMetaData();
//			System.out.println("Product name: "+databaseMetaData.getDatabaseProductName());
//			System.out.println("JDBC Driver name: "+databaseMetaData.getDriverName());
			
//			System.out.println("\nTables: ");
//			ResultSet myRs=databaseMetaData.getTables(null,null,"employee",null);
//			while(myRs.next()) {
//				System.out.println(myRs.getString("TABLE_NAME"));
//			}
//			ResultSet myRes=databaseMetaData.getColumns(null, null, "employee", null);
//			Statement myStmt = myConn.createStatement();
//			myRs=myStmt.executeQuery("select * from employee");
//			ResultSetMetaData myRsMetaData=myRs.getMetaData();
//			int columnCount=myRsMetaData.getColumnCount();
//			System.out.println("\ncolumn count is: "+columnCount);
//			for(int column=1;column<columnCount;column++) {
//				System.out.println("column name and type : "+myRsMetaData.getColumnName(column)+" "+myRsMetaData.getColumnType(column));
//			}
//			System.out.println("\nCOLUMNS: ");
//			while(myRes.next()) {
//				System.out.println(myRes.getString("COLUMN_NAME"));
//
//			}
			
		Properties props=new Properties();
		props.load(new FileInputStream("demo.properties"));
		String theDburl=props.getProperty("dburl");
		String theUser=props.getProperty("user");
		String thePassword=props.getProperty("password");
		Connection myConn=DriverManager.getConnection(theDburl,theUser,thePassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void display(ResultSet myRs) {
		// TODO Auto-generated method stub
		try {
			while(myRs.next()) {
				int id=myRs.getInt("emp_id");
				String name=myRs.getNString("first_name");
				int salary=myRs.getInt("salary");
				
				System.out.println("ID:"+id+" name:"+name+" salary:"+salary);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
