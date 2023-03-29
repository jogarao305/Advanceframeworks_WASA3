package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCQueryupdate {
	
	public static void main(String[] args) throws SQLException {
		//create an object of driver
		Connection con = null;
	try {
		Driver drf = new Driver();
	//step:1 register the driver or database
	DriverManager.registerDriver(drf);
	
	//step:2 get the connection
	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "root");
	
	//step:3 create a statement
	Statement state = con.createStatement();
	
	//step:4 execute a query
	String query = "insert into candidatedetails values('pradeep',305,'hyd');";
	
	int result = state.executeUpdate(query);
	
	if(result>=1)
	{
		System.out.println("data added");
	}
	ResultSet res = state.executeQuery("select * from candidatedetails");
	while(res.next())
	{
		System.out.println(res.getString(1)+" "+res.getInt(2)+" "+res.getString(3));
	 }
	}
	catch(Exception e) {
		
	}
	//step:5 close the database
	finally {
	con.close();
	System.out.println("db closed");
	     }	
	}
}