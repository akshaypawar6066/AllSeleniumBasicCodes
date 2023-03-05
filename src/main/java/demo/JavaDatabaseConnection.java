package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.hc.core5.http.ConnectionClosedException;

public class JavaDatabaseConnection {
	public static void main(String[] args) throws SQLException
	{
    //Steps to follow
	 /*
	  * Create Connection
	  * Create statement/query
	  * Execute query
	  * Close the connection
	  */
		 //1) Create Connection
		Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		//2) Create statement/query
		Statement stmt=connect.createStatement();
		String insert="INSERT INTO EMPLOYEE VALUES (106,'Anna','976889','6566k')";
		String delete="DELETE FROM EMPLOYEE WHERE EMPLOYE_ID=103";
		String update="update employee set employe_id=103 where employe_name='Shivaji'";
		//3) Execute query
		stmt.execute(insert);
		//4) Close the connection
		connect.close();
		System.out.println("Query Executed:");
	
	}
}
