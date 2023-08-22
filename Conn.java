package electricity.billing.system;//this class is used for connection of project with mysql database

import java.sql.*;
public class Conn {
	
		
	
	Connection c;
	Statement s;
	Conn() {
		//Class.forName("com.mysql.cj.jdbs.Driver");
	
		try {
		c=	DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs","root","aman@123");//establish connection
		System.out.println("connected succesfully");
		s=c.createStatement();
		} catch (SQLException e) {
		System.out.println("error while connecting");
		e.printStackTrace();
		}
	
	
	}
}

