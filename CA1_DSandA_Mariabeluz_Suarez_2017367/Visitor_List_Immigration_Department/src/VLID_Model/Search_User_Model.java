/*
 * STUDENT NAME: MARIABELUZ SUAREZ AMADOR
 * STUDENT NUMBER: 2017367
 * BCS IT YEAR 3, GROUP B
 * MODULE: DATA STRUCTURES AND ALGORITHMS
 * ASSIGNMENT: VISITOR LIST IMMIGRATION DEPARTMENT
 * DATE: DECEMBER 2019
 */

package VLID_Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;

import VLID_Controller.Menu_Controller;
import VLID_View.Menu_View;
import VLID_View.Search_User_View;

public class Search_User_Model extends JFrame{

	Menu_Controller controller; //global variable type class Menu Controller
	
	
	public Search_User_Model(Menu_Controller mlcontroller) {
		this.controller = mlcontroller; //Getting the controller from outside which is Menu controller or main controller
		
	}
	
	///CONNECTION TO DB FOR LOGIN CLASS
		public void db() {
			try{
				// Load the database driver
				//if you use MAC laptop use the next line com.mysql.cj.jdbc.Driver"
				Class.forName("com.mysql.jdbc.Driver").newInstance() ;
				
				String dbServer = "jdbc:mysql://127.0.0.1:3306/vlid?verifyServerCertificate=false&useSSL=true";
				String user = "root";
				String password = "admin";
				String query="";
				
			
					query = "SELECT idUsers, firstName, LastName, Priority_Level, Possition FROM USERS WHERE idUsers='"+ controller.ID +"'";					
			
				//object from my driver i get the connection
				//.getConnection is a static method
				// Get a connection to the database
				Connection conn = DriverManager.getConnection(dbServer, user, password) ;

				// Get a statement from the connection
				//statement is to say what do i want to do (queries)
				Statement stmt = conn.createStatement() ;

				//if (controller.Window =="Login") {
					// Execute the query
					//resultset is a set of values because we usually get a group of values after execute a query from statement
					ResultSet rs = stmt.executeQuery(query) ;
					// Loop through the result set
					int i=0; //variable to loop the results
					while(rs.next()) {
						//assign results to each textfield
							controller.ID=rs.getString("idUsers");
							controller.FirstName=rs.getString("firstName");
							controller.LastName=rs.getString("LastName");
							controller.Possition=rs.getString("Possition"); 
							controller.PriorityLevel=rs.getString("Priority_Level");
							i++;	

					}
					rs.close() ;
				
				// Close the result set, statement and the connection
				
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
		
		
		
	
} //end class
