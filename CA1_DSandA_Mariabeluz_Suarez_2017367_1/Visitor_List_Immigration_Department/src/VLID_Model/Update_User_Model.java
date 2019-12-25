package VLID_Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;

import VLID_Controller.Menu_Controller;

public class Update_User_Model extends JFrame {

	Menu_Controller controller; //global variable type class Menu_Controller
	
	public Update_User_Model(Menu_Controller mlcontroller) {
		this.controller = mlcontroller; //Getting the controller from outside which is Menu controller or main controller
		
	}
	
	public void db() {
		try{
			// Load the database driver
			//if you use MAC laptop use the next line com.mysql.cj.jdbc.Driver"
			Class.forName("com.mysql.jdbc.Driver").newInstance() ;
			
			String dbServer = "jdbc:mysql://127.0.0.1:3306/vlid?verifyServerCertificate=false&useSSL=true";
			String user = "root";
			String password = "admin";
			String query="";
			
			query = "UPDATE `vlid`.`users` SET `firstName`='"+controller.FirstName+"', `LastName`='"+controller.LastName+"', `Date_Arrival`='"+controller.DateArrival+"', `Passport`='"+controller.Passport+"'  WHERE (`idUsers` = '"+controller.ID+"')";
			

			//object from my driver i get the connection
			//.getConnection is a static method
			// Get a connection to the database
			Connection conn = DriverManager.getConnection(dbServer, user, password) ;

			// Get a statement from the connection
			//statement is to say what do i want to do (queries)
			Statement stmt = conn.createStatement() ;

			stmt.executeUpdate(query) ;
    		
    		
			stmt.close() ;
			conn.close() ;
		}
		catch( SQLException se ){
			System.out.println( "SQL Exception:" ) ;

			// Loop through the SQL Exceptions
			while( se != null ){
				System.out.println( "State  : " + se.getSQLState()  ) ;
				System.out.println( "Message: " + se.getMessage()   ) ;
				System.out.println( "Error  : " + se.getErrorCode() ) ;

				se = se.getNextException() ;
			}
		}
		catch( Exception e ){
			System.out.println( e ) ;
		}
		
		
		
	}//end method db
	
}
