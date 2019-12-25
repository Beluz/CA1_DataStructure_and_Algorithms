/*
 * STUDENT NAME: MARIABELUZ SUAREZ AMADOR
 * STUDENT NUMBER: 2017367
 * BCS IT YEAR 3, GROUP B
 * MODULE: DATA STRUCTURES AND ALGORITHMS
 * ASSIGNMENT: VISITOR LIST IMMIGRATION DEPARTMENT
 * DATE: DECEMBER 2019
 */

/*
 * INITIALLY IN THIS PROGRAM I THOUGTH TO IMPLEMENT THE METHODS OF THE DOUBLY LINKED LIST AND AT THE SAME TIME WORKING WITH DATABASE
 * BUT I HAVE TO UPDATE TO MANY TUPLES IN THE TABLE, WHICH WAS NOT EFFICIENT
 * AFTER I CHANGED THE CODE TO BIULD THE LIST AND ORDERED JUST WITH THE METHODS AND AFTER INSERT OR UPDATE INFORMATION ON THE LIST WHICH SHOULD BE THE BEST WAY TO WORK WITH
 * THAT REPRESENTS TOO MANY CHANGES IN MY CODE BUT I REALIZED THAT I WAS WORKING IN A WRONG WAY SO I CHANGED
 * THIS TOPIC WAS A BIT HARD FOR ME AND TAKES ME TIME TO DO IT, UNFORTUNATLY I COULD NOT FINISH IT BUT I THINK NOW I HAVE THE IDEA ABOUT HOW TO WORK WITH THEM.
 * THIS PROGRAM JUST ADDING USERS, SEARCH AND UPDATE THEIR INFO. 
 */
package VLID_Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import VLID_Model.Add_New_User_Model;
import VLID_Model.Search_User_Model;
import VLID_Model.Update_User_Model;
import VLID_View.Add_New_User_View;
import DoublyLinkedList.DoublyLinkedList;
import DoublyLinkedList.Priority;
import VLID_View.Menu_View;
import VLID_View.Remove_User_View;
import VLID_View.Search_User_View;
import VLID_View.Update_User_View;

//CLASS Menu_Controller will show to users the main menu with different options to use
public class Menu_Controller extends JFrame implements ActionListener {

	
	//GLOBAL VARIABLES
	Menu_View menuView;  //variable type of Menu_View
	Add_New_User_View addNewUserView; //variable type of Add_New_User_View class
	Add_New_User_Model addNewUserModel; //variable type of Add_New_User_Model class
	Update_User_View updateUserView; // Variable type of Update_User_View
	Update_User_Model updateUserModel;
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
	public int Possition;
	public String PriorityLevel="";
	public int PLastHighLevel;  //store the position of the last element of high level
	public int PLastMediumLevel; //store the position of the last element of medium level
	public int PLowL; //store the position of the last element of low level
	public int PosPrevNode;
	public int PosNextNode;
	
	public int[][] users = new int[100][4]; //array to store all the users in the database and populate the list
	public String QueryType; //variable to identify when the select is about all registers in database or just one
	
	public DoublyLinkedList DLL = new DoublyLinkedList(); //instantiate the linkedlist
	
	
	public Menu_Controller(){
		
		menuView = new Menu_View(this); //instantiate a new class Menu_View
		addNewUserView = new Add_New_User_View(this);  //instantiate a new class Add_New_User_View
		addNewUserModel = new Add_New_User_Model(this);  //instantiate a new class Add_New_User_Model
		updateUserView = new Update_User_View(this);  //instantiate a new class Update_User_View
		updateUserModel = new Update_User_Model(this);
		searchUserView = new Search_User_View(this);  //instantiate a new class Search_User_View
		removeUserView = new Remove_User_View(this);  //instantiate a new class Remove_User_View
		searchUserModel = new Search_User_Model(this);
		
		menuView.setVisible(true);  //set visible only the Main Menu
		addNewUserView.setVisible(false);  // hide the window to add new users
		updateUserModel.setVisible(false);  // hide the window to add new users
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
			
			FirstName = addNewUserView.tFirstName.getText();
			LastName = addNewUserView.tLastName.getText();
			DateArrival = addNewUserView.txtDate.getText();
			Passport = addNewUserView.tPassport.getText(); 
			PriorityLevel = String.valueOf(addNewUserView.cPriorityLevel.getSelectedIndex() +1); //this gets the index high level(1), medium leve(2), low level(3)
			
			//populate the list with database tuples
			QueryType ="ALL";
			addNewUserModel.db_ID(); 
			
			//Count the number of users on the array
			//also found the first node and add it to the list. Store the nextnode in a variable
			int countUsers=0;
			for(int y=0;y<=users.length-1;y++ ) {
				if(users[y][0] > 0) {
					countUsers++;
					if(users[y][2] == 0) {
						PosNextNode = users[y][3];
						DLL.addToEnd(users[y][0]); //add the first node to the list
						QueryType = "INSERT";
						addNewUserModel.db(); //save the user into database
						QueryType ="ONE";
						addNewUserModel.db_ID(); //select the ID of the user that was already save into the database
					}
				}else {
					if(countUsers<1) {
						QueryType = "INSERT BEGIN";
						addNewUserModel.db(); //save the user into database
						QueryType ="ONE";
						addNewUserModel.db_ID(); 
						DLL.addToFront(Integer.valueOf(ID));
						break;
					}else {
						//DLL.addToEnd(users[y][0]); //add the first node to the list
						break;
					}
					
				}
			}
			
			// found every node and added to the list, store nextnode according to its position and search again till all are founded
			int findNext=1, y=1;
			while(findNext < countUsers) {  //go traverse until find all the elements of the list
				if(users[y][0] == PosNextNode && users[y+1][0]!=0) { //if is the nextnode we are looking for
					PosPrevNode = users[y][2]; //store the previous node of the current node
					PosNextNode = users[y][3]; //store next node of the current node
					DLL.addToEnd(users[y][0]); //add the next node to add on the list
					
					findNext = findNext+1;
					System.out.println("users "+ countUsers + "founded "+ findNext + " and " + users[y][0]);
				}else if(users[y][0] == PosNextNode && findNext<countUsers) { //if is the nextnode we are looking for
					PosPrevNode = users[y][2]; //store the previous node of the current node
					PosNextNode = users[y][3]; //store next node of the current node
					DLL.addToEnd(users[y][0]); //add the next node to add on the list
					
					findNext = findNext+1;
					System.out.println("users "+ countUsers + "founded "+y+ "and " + users[y][0]);
				}
				y++;
				if(y==countUsers) {
					y=1;
				}
				
			}

			// go traverse the array to build and add each element into the list
			// in this loop we will detect which is the next position empty on the list
			// we also will identify where is the last element of high level priority of the list
			// and which position is the first position 
			int countHigh=0, countMedium=0;
    		for(int x=0;x<=countUsers;x++) {
				if(users[x][0] > 0) { //if the array position is not null, which means there is a value stored then added it to the list			
					//if is high level but and not medium 
					if(users[x][1] == Priority.HIGH.getPriority() && users[x][1] < Priority.MEDIUM.getPriority()) {
						PLastHighLevel = users[x][0]; //indicate where is the last high level position
						countHigh++;
					}else if(users[x][1] == Priority.MEDIUM.getPriority() && users[x][1] < Priority.LOW.getPriority()) {
						PLastMediumLevel = users[x][0]; //indicate which is the last medium level on the list
						countMedium++;
					}
				}else {
					Possition = x+1;  //this variable store the next position empty on the array to use when we will add
					//PosPrevNode = users[x][2]; //indicate which is the previous node, pointing to previous node position
					//PosNextNode = users[x][3]; //indicate which is the next node, pointing to next node position
					break;
				}
			}

			System.out.println("high" + PLastHighLevel);
			System.out.println("Medium" + PLastMediumLevel);
			
			int element = Integer.parseInt(ID); //convert the string data to integer in order to add this element to the DoublyLinkedlist
			int p = Priority.HIGH.getPriority();
			int m = Priority.MEDIUM.getPriority();
			int l = Priority.LOW.getPriority();
			
			//Adding the person to the queue according to their Priority Level
			if(Integer.parseInt(PriorityLevel) == p) {
				if(countHigh == countUsers) {
					if(countUsers > 0) {
						DLL.addToEnd(element);  // add element to the list
						addNewUserModel.db();  // insert the element in database
					}
					
					QueryType = "UPDATE_MIDDLE";  //indicate that it next query will be an update
					Possition = PLastHighLevel+1;  //this code is not important anymore because i am not using it.
					DLL.searchNode(element);  //call a method to search the element we already add into the list
					addNewUserModel.db(); //update position, previous node and next node values
					QueryType = "UPDATE_MIDDLE_PREV"; //indicate that next query will be an update when an element was added somewhere in the middle of the list
					addNewUserModel.db();  //update the previous node position in database
					JOptionPane.showMessageDialog(this, "User have been added successfully!" );
				}else {
					//next code does the same as the code above but instead of adding the element at the end of the list
					// this add the element somewhere in the middke of  the list
					DLL.addBetween(element, PLastHighLevel);
					QueryType = "UPDATE_MIDDLE";
					Possition = PLastHighLevel+1;
					DLL.searchNode(element);
					addNewUserModel.db(); //update position, previous node and next node values
					QueryType = "UPDATE_MIDDLE_PREV";
					addNewUserModel.db();
					QueryType = "UPDATE_MIDDLE_NEXT";
					addNewUserModel.db();
					JOptionPane.showMessageDialog(this, "User have been added successfully!" );
				}
				DLL.showListFrontToEnd(); //show the list from the front to the end
			}else if(Integer.parseInt(PriorityLevel) == m){
				if(countMedium + countHigh == countUsers) {
					System.out.println("es el ultimo medium");
					DLL.addToEnd(element);
					QueryType = "UPDATE_MIDDLE";
					Possition = PLastMediumLevel+1;
					DLL.searchNode(element);
					addNewUserModel.db(); //update position, previous node and next node values
					QueryType = "UPDATE_MIDDLE_PREV";
					addNewUserModel.db();
					JOptionPane.showMessageDialog(this, "User have been added successfully!" );
				}else {
					DLL.addBetween(element, PLastMediumLevel);
					QueryType = "UPDATE_MIDDLE";
					Possition = PLastMediumLevel+1;
					DLL.searchNode(element);
					addNewUserModel.db(); //update position, previous node and next node values
					QueryType = "UPDATE_MIDDLE_PREV";
					addNewUserModel.db();
					QueryType = "UPDATE_MIDDLE_NEXT";
					addNewUserModel.db();
					JOptionPane.showMessageDialog(this, "User have been added successfully!" );
				}			
				DLL.showListFrontToEnd(); //show the list from the front to the end
			}else if(Integer.parseInt(PriorityLevel) == l){
				//call the method to add a new user to the End of the list
				DLL.addToEnd(element);
				Possition = PLastHighLevel+1;
				QueryType = "UPDATE"; //set the variable to Update to indicate that it only will execute an update
				PosPrevNode = users[countUsers-1][0];  //take the position of the las element acording to select on database
				addNewUserModel.db(); //update the position, previous node and next node in database which was assigned to the element in the queue
				QueryType = "UPDATE_LOW"; //now execute update 
				addNewUserModel.db();  //update nextnode of the previous node after adding the new one in database
				JOptionPane.showMessageDialog(this, "User have been added successfully!" );
				DLL.showListFrontToEnd(); //show the list from the front to the end
			}
			
			
		}else if(e.getActionCommand().equals("Update")) { 
			menuView.setVisible(false);
			addNewUserView.setVisible(false);
			updateUserView.setVisible(true);  //show the Update user window
			searchUserView.setVisible(false);
			removeUserView.setVisible(false);
			
		}else if(e.getActionCommand().equals("Save Changes")) { 
			menuView.setVisible(false);
			addNewUserView.setVisible(false);
			updateUserView.setVisible(true);  //show the Update user window
			searchUserView.setVisible(false);
			removeUserView.setVisible(false);
			
			ID = updateUserView.tID.getText().trim();
			
			FirstName = updateUserView.tFirstName.getText();
			LastName = updateUserView.tLastName.getText();
			DateArrival = updateUserView.txtDate.getText();
			Passport = updateUserView.tPassport.getText(); 
			updateUserModel.db(); 
			JOptionPane.showMessageDialog(this, "User have been updated successfully!" );
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
			searchUserView.tPossition.setText(String.valueOf(Possition));
			searchUserView.tPriorityLevel.setText(PriorityLevel);
		}
		
	}
	
	
}
