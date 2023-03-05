package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.hc.core5.http.ConnectionClosedException;

public class MySqlSelectCommand {
	public static void main(String[] args) throws SQLException
	{
    //Steps to follow
	 /*
	  * Create Connection
	  * Create statement/query
	  * Execute query
	  * Store the result into the data set(This is for GET command)
	  * Close the connection
	  */
		 //1) Create Connection
		Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		//2) Create statement/query
		Statement stmt=connect.createStatement();
		String select="select * from employee";
		//3) Execute query & 4)save the results into the ResultSet
		ResultSet rs=stmt.executeQuery(select);
		while(rs.next())
		{
			int eid=rs.getInt("employe_id");
			String ename=rs.getString("employe_name");
			String eno=rs.getString("employe_no");
			String esallery=rs.getString("employe_sallery");
			System.out.println(eid+"   "+ename+"   "+eno+"    "+esallery);
		}
		
		//4) Close the connection
		connect.close();
		System.out.println("Query executed:");
	
	}
}
