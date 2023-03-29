package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCconn {
	public static void main(String[] args) throws SQLException {
		//Create an object of Driver
		Driver drf = new Driver();
		
		//register the driver
		DriverManager.registerDriver(drf);
		
		//get the connection to database
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "root");
		
		//issue create statement
		Statement st=con.createStatement();
		
		//execute query
		ResultSet result=st.executeQuery("select * from candidatedetails;");
		
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getInt(2)+" "+result.getString(3));
		}
		
		//close the database
		con.close();
		System.out.println("database closed");
	}
}
