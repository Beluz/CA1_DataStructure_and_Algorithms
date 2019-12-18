/*
 * STUDENT NAME: MARIABELUZ SUAREZ AMADOR
 * STUDENT NUMBER: 2017367
 * BCS IT YEAR 3, GROUP B
 * MODULE: DATA STRUCTURES AND ALGORITHMS
 * ASSIGNMENT: VISITOR LIST IMMIGRATION DEPARTMENT
 * DATE: DECEMBER 2019
 */

package VLID_Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import VLID_Model.Add_New_User_Model;
import VLID_Model.Search_User_Model;
import VLID_View.Add_New_User_View;
import DoublyLinkedList.DoublyLinkedList;
import DoublyLinkedList.Priority;
import VLID_View.Menu_View;
import VLID_View.Remove_User_View;
import VLID_View.Search_User_View;
import VLID_View.Update_User_View;

//CLASS Menu_Controller will show to users the main menu with different options to use
public class Menu_Controller implements ActionListener {

	
	//GLOBAL VARIABLES
	Menu_View menuView;  //variable type of Menu_View
	Add_New_User_View addNewUserView; //variable type of Add_New_User_View class
	Add_New_User_Model addNewUserModel; //variable type of Add_New_User_Model class
	Update_User_View updateUserView; // Variable type of Update_User_View
	Search_User_View searchUserView; // Variable type of Search_User_View
	Remove_User_View removeUserView; // Variable type of Remove_User_View
	Search_User_Model searchUserModel; // Variable type of Search_User_Model
    public String Window=""; //variable to know which window is currently used.

    //variables to pass the data to be used by this controller
    public String ID="";
    public String FirstName="";
	public String LastName="";
	public String DateArrival="";
	public String Passport="";
	public String Possition="";
	public String PriorityLevel="";
	public int PLastHighLevel;  //store the position of the last element of high level
	public int PLastMediumLevel; //store the position of the last element of medium level
	public int PLowL; //store the position of the last element of low level
	public int PosPrevNode;
	public int PosNextNode;
	
	public int[][] users = new int[100][4]; //array to store all the users in the database and populate the list
	public String QueryType; //variable to identify when the select is about all registers in database or just one
	
	
	public Menu_Controller() {
		
		menuView = new Menu_View(this); //instantiate a new class Menu_View
		addNewUserView = new Add_New_User_View(this);  //instantiate a new class Add_New_User_View
		addNewUserModel = new Add_New_User_Model(this);  //instantiate a new class Add_New_User_Model
		updateUserView = new Update_User_View(this);  //instantiate a new class Update_User_View
		searchUserView = new Search_User_View(this);  //instantiate a new class Search_User_View
		removeUserView = new Remove_User_View(this);  //instantiate a new class Remove_User_View
		searchUserModel = new Search_User_Model(this);
		
		menuView.setVisible(true);  //set visible only the Main Menu
		addNewUserView.setVisible(false);  // hide the window to add new users
		//addNewUserModel.setVisible(false);  // hide the window to add new users
		updateUserView.setVisible(false);  //hide the window to update users' information
		searchUserView.setVisible(false); //hide the window search user
		removeUserView.setVisible(false); //hide the window remove user
		searchUserModel.setVisible(false); //hide the window remove user
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		//when the user choose the submenu Add the open the window
		if(e.getActionCommand().equals("Add")) { 
			menuView.setVisible(false);
			addNewUserView.setVisible(true);  //show add user window
			updateUserView.setVisible(false);
			searchUserView.setVisible(false);
			removeUserView.setVisible(false);
			
			Window="Login";
			//Loginmodel.db(); //call the connection to validate insert new user to db
			
		}else if(e.getActionCommand().equals("Save User")) { 
			
			DoublyLinkedList DLL = new DoublyLinkedList(); //instantiate the linkedlist
			//populate the list with database tuples
			QueryType ="ALL";
			addNewUserModel.db_ID(); 
			// go traverse the array to add each element into the list
			// in this loop we will detect which is the next position empty on the list
			// we also will identify where is the last element of high level priority of the list
			// and which position is the first position 
			for(int x=0;x<=users.length-1;x++) {
				if(users[x][0] > 0) { //if the array position is not null, which means there is a value stored then added it to the list
					DLL.addToEnd(users[x][0]);
					//if is high level but and not medium 
					if(users[x][1] == Priority.HIGH.getPriority() && users[x][1] < Priority.MEDIUM.getPriority()) {
						PLastHighLevel = x+1; //indicate where is the last high level position
					}else if(users[x][1] == Priority.MEDIUM.getPriority() && users[x][1] < Priority.LOW.getPriority()) {
						PLastMediumLevel = x+1; //indicate which is the last medium level on the list
					}
				}else {
					Possition = String.valueOf(x+1);  //this variable store the next position empty on the array to use when we will add
					PosPrevNode = users[x][2]; //indicate which is the previous node, pointing to previous node position
					PosNextNode = users[x][3]; //indicate which is the next node, pointing to next node position
					break;
				}
			}

			System.out.println("high" + PLastHighLevel);
			System.out.println("Medium" + PLastMediumLevel);
			
			FirstName = addNewUserView.tFirstName.getText();
			LastName = addNewUserView.tLastName.getText();
			DateArrival = addNewUserView.txtDate.getText();
			Passport = addNewUserView.tPassport.getText(); 
			PriorityLevel = String.valueOf(addNewUserView.cPriorityLevel.getSelectedIndex() +1); //this gets the index high level(1), medium leve(2), low level(3)
			QueryType = "INSERT";
			addNewUserModel.db(); //save the user into database
			QueryType ="ONE";
			addNewUserModel.db_ID(); //select the ID of the user that was already save into the database
			int element = Integer.parseInt(ID); //convert the string data to integer in order to add this element to the DoublyLinkedlist
			int p = Priority.HIGH.getPriority();
			
			//Adding the person to the queue according to their Priority Level
			if(Integer.parseInt(PriorityLevel) == p) {
				DLL.addBetween(element);
			}else if(PriorityLevel.equals(String.valueOf(Priority.MEDIUM.getPriority()))){
				
			}else if(PriorityLevel.equals(String.valueOf(Priority.LOW.getPriority()))){
				//call the method to add a new user to the End of the list
				DLL.addToEnd(element);
				QueryType = "UPDATE"; //set the variable to Update to indicate that it only will execute an update
				addNewUserModel.db(); //update the position in database which was assigned to the element in the queue
			}
			DLL.showListFrontToEnd(); //shows the list from the front to the end
			
		}else if(e.getActionCommand().equals("Update")) { 
			menuView.setVisible(false);
			addNewUserView.setVisible(false);
			updateUserView.setVisible(true);  //show the Update user window
			searchUserView.setVisible(false);
			removeUserView.setVisible(false);
		}else if(e.getActionCommand().equals("Search")) { 
			Window="Search";
			
			menuView.setVisible(false);
			addNewUserView.setVisible(false);
			updateUserView.setVisible(false); 
			searchUserView.setVisible(true); //show the Search user window
			removeUserView.setVisible(false);
			
		}else if(e.getActionCommand().equals("Remove")) { 
			menuView.setVisible(false);
			addNewUserView.setVisible(false);
			updateUserView.setVisible(false); 
			searchUserView.setVisible(false); 
			removeUserView.setVisible(true); //show the Search user window
		}else if(e.getActionCommand().equals("Search_User")) { 
			ID = searchUserView.tID.getText().trim();
			searchUserModel.db();
			searchUserView.tFirstName.setText(FirstName);
			searchUserView.tLastName.setText(LastName);
			searchUserView.tPossition.setText(Possition);
			searchUserView.tPriorityLevel.setText(PriorityLevel);
		}
		
	}
	
	
}
