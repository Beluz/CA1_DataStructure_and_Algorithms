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
import javax.swing.JOptionPane;

import VLID_Controller.Menu_Controller;

public class Add_New_User_Model extends JFrame {

Menu_Controller controller; //global variable type class Menu_Controller
	
	
	public Add_New_User_Model(Menu_Controller mlcontroller) {
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
				
				if(controller.QueryType =="INSERT") {
					query = "INSERT INTO `vlid`.`users` (`firstName`, `LastName`, `Date_Arrival`, `Passport`, `Priority_Level`) VALUES ('"+controller.FirstName+"', '"+controller.LastName+"', '"+controller.DateArrival+"', '"+controller.Passport+"', '"+controller.PriorityLevel+"')";
				}else if(controller.QueryType=="UPDATE"){
					query = "UPDATE `vlid`.`users` SET `Possition` = '"+controller.Possition+"' WHERE (`idUsers` = '"+controller.ID+"')";

				}
				

				//object from my driver i get the connection
				//.getConnection is a static method
				// Get a connection to the database
				Connection conn = DriverManager.getConnection(dbServer, user, password) ;

				// Get a statement from the connection
				//statement is to say what do i want to do (queries)
				Statement stmt = conn.createStatement() ;

				stmt.executeUpdate(query) ;
	    		JOptionPane.showMessageDialog(this, "User have been added successfully!" );
	    		
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
		
		
		
		
		///CONNECTION TO DB TO SELECT THE ID OF THE PERSON
				public void db_ID() {
					try{
						// Load the database driver
						//if you use MAC laptop use the next line com.mysql.cj.jdbc.Driver"
						Class.forName("com.mysql.jdbc.Driver").newInstance() ;
						
						String dbServer = "jdbc:mysql://127.0.0.1:3306/vlid?verifyServerCertificate=false&useSSL=true";
						String user = "root";
						String password = "admin";
						String query="";
						
						if(controller.QueryType =="ALL") {
							query = "SELECT idUsers, Priority_Level, Possition FROM USERS";
						}else if(controller.QueryType=="ONE"){
							query = "SELECT idUsers FROM USERS WHERE PASSPORT='"+controller.Passport+"'";
						}

						//object from my driver i get the connection
						//.getConnection is a static method
						// Get a connection to the database
						Connection conn = DriverManager.getConnection(dbServer, user, password) ;

						// Get a statement from the connection
						//statement is to say what do i want to do (queries)
						Statement stmt = conn.createStatement() ;

						// Execute the query
						//resultset is a set of values because we usually get a group of values after execute a query from statement
						ResultSet rs = stmt.executeQuery(query) ;
						// Loop through the result set
						int i=0; //variable to loop the results
						while(rs.next()) {
							//assign results to each textfield
							if(controller.QueryType=="ALL") {
								controller.users[i][0]=Integer.parseInt(rs.getString("idUsers"));
								controller.users[i][1]=Integer.parseInt(rs.getString("Priority_Level"));
							}else if(controller.QueryType=="ONE"){
								controller.ID=rs.getString("idUsers");
							}
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
					
				}//end method dbID
		
}
