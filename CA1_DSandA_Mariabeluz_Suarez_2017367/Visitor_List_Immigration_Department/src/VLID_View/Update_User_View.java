/*
 * STUDENT NAME: MARIABELUZ SUAREZ AMADOR
 * STUDENT NUMBER: 2017367
 * BCS IT YEAR 3, GROUP B
 * MODULE: DATA STRUCTURES AND ALGORITHMS
 * ASSIGNMENT: VISITOR LIST IMMIGRATION DEPARTMENT
 * DATE: DECEMBER 2019
 */

package VLID_View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import VLID_Controller.Menu_Controller;

//CLASS TO UPDATE USER'S INFO, THIS CLASS EXTENDS JFRAME TOOLS
public class Update_User_View extends JFrame {

	//GLOBAL VARIABLES
		Menu_Controller controller;
		JPanel PID;
		JPanel PFirstName;
		JPanel PSecondName;
		JPanel PDateArrival;
		JPanel PPassport;
		JPanel PPriorityLevel;
		JPanel PSave;
		
		
		//constructor
		public Update_User_View(Menu_Controller mcontroller) {
			
			this.controller = mcontroller;
			setupUpdateUser(); // instantiate the setup
			creatingElementsUpdateUser(); //call the method to create our elements of the view
			
		}//end Add_New_User method
		
		
		//SETTING UP JFRAME
		private void setupUpdateUser() {
			this.setVisible(true);
			this.setSize(600, 400);
			this.setTitle("Update Users' Information");
				
		}
			
		
		//CREATING ELEMENTS OF THE VIEW
		private void creatingElementsUpdateUser() {
			//USING A GRID LAYOUT MANAGER
			GridLayout frameManager = new GridLayout(0, 1);
			this.setLayout(frameManager);
			
			PID = new JPanel();
			PFirstName = new JPanel();
			PSecondName = new JPanel();
			PDateArrival = new JPanel();
			PPassport = new JPanel();
			PPriorityLevel = new JPanel();
			PSave = new JPanel();
			
			JTextField tID;
			JLabel lID;
			JTextField tFirstName;
			JLabel lFirstName;
			JTextField tLastName;
			JLabel lLastName;
			JLabel lDate;
			JTextField txtDate;
			JTextField tPassport;
			JLabel lPassport;
			JLabel lPriorityLevel;
			JButton bSaveUser;
			
			lID = new JLabel("Introduce User's ID: ");
			tID = new JTextField(30);
			tID.setText("");
			lFirstName = new JLabel("First Name: ");
			tFirstName = new JTextField(30);//instantiation of a Textfield
			tFirstName.setText("");
			
			lLastName = new JLabel("Last Name: ");
			tLastName = new JTextField(30);//instantiation of a Textfield
			tLastName.setText("");
			
			lDate = new JLabel("Date of Arrival: ");
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			////////// this block of code was taken from website: https://blog.eduonix.com/java-programming-2/how-to-use-date-picker-component-in-java/

			//create text field
			txtDate = new JTextField();
			//set bounds of text field
			txtDate.setBounds(101, 107, 86, 20);
			
			//set columns
			txtDate.setColumns(10);
			
			//create button and there object
			JButton btnNewButton = new JButton("Date");
			//perform action listener
			btnNewButton.addActionListener(new ActionListener() 
			{	
				//performed action
				public void actionPerformed(ActionEvent arg0) 
				{
					//create frame new object  f
					JFrame f = new JFrame();
					//set text which is collected by date picker i.e. set date 
					txtDate.setText(new DatePicker(f).setPickedDate());
				}
			});
			//set button bound
			btnNewButton.setBounds(223, 106, 27, 23);
			
		   /////////////////////////////////////////////////////////////////////////////////////////////////////////////
	       //////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			lPassport = new JLabel("Passport: ");
			tPassport = new JTextField(30);//instantiation of a Textfield
			
			lPriorityLevel = new JLabel("Priority Level: ");
			JComboBox cPriorityLevel = new JComboBox();
			cPriorityLevel.addItem("High Level");
			cPriorityLevel.addItem("Medium Level");
			cPriorityLevel.addItem("Low Level");
			
			bSaveUser = new JButton("Save Changes"); // create and instantiate a button
			
			//adding the elements to the panel
			PID.add(lID);
			PID.add(tID);
			PFirstName.add(lFirstName);
			PFirstName.add(tFirstName);
			PSecondName.add(lLastName);
			PSecondName.add(tLastName);
			PDateArrival.add(lDate);
			//add text field to contentPane
			PDateArrival.add(txtDate);
			//add button in contentPane
			PDateArrival.add(btnNewButton);
					
			PPassport.add(lPassport);
			PPassport.add(tPassport);
			PPriorityLevel.add(cPriorityLevel);
			PSave.add(bSaveUser);
			
			this.add(PID);
			this.add(PFirstName);
			this.add(PSecondName);
			this.add(PDateArrival);
			this.add(PPassport);
		    this.add(PPriorityLevel);
			this.add(PSave);
			
			//once we add all the elements we repaint, otherwise the program wont show the elements
			// everytime we add any element we have to repaint
			this.validate();
			this.repaint();
			
					
		}
		
		
		
		
}// END CLASS
