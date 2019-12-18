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

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import VLID_Controller.Menu_Controller;

//CLASS that contains the view, the elements to add new users to the system therefore to the queue
public class Add_New_User_View extends JFrame {

	//GLOBAL VARIABLES
	Menu_Controller controller;
	JPanel PFirstName;
	JPanel PSecondName;
	JPanel PDateArrival;
	JPanel PPassport;
	JPanel PPriorityLevel;
	JPanel PSave;
	JPanel PList;
	JButton bSaveUser; 
	public JTextField tFirstName;
	public JLabel lFirstName;
	public JTextField tLastName;
	public JLabel lLastName;
	public JLabel lDate;
	public JTextField txtDate;
	public JTextField tPassport;
	public JLabel lPassport;
	public JLabel lPriorityLevel;
	public JComboBox cPriorityLevel;
	public JLabel lList;
	
	//constructor
	public Add_New_User_View(Menu_Controller mcontroller) {
		
		this.controller = mcontroller;
		setupAddUser(); // instantiate the setup
		creatingElementsAddUser(); //call the method to create our elements of the view
		
		
		bSaveUser.addActionListener(controller);
		bSaveUser.setActionCommand("Save User");
	}//end Add_New_User method
	
	
	//SETTING UP JFRAME
	private void setupAddUser() {
		this.setVisible(true);
		this.setSize(600, 400);
		this.setTitle("Add New User");
			
	}
		
	
	//CREATING ELEMENTS OF THE VIEW
	private void creatingElementsAddUser() {
		//USING A GRID LAYOUT MANAGER
		GridLayout frameManager = new GridLayout(0, 1);
		this.setLayout(frameManager);
		
		PFirstName = new JPanel();
		PSecondName = new JPanel();
		PDateArrival = new JPanel();
		PPassport = new JPanel();
		PPriorityLevel = new JPanel();
		PSave = new JPanel();
		PList = new JPanel();
		
		
		
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
		cPriorityLevel = new JComboBox();
		cPriorityLevel.addItem("High Level");
		cPriorityLevel.addItem("Medium Level");
		cPriorityLevel.addItem("Low Level");
		
		bSaveUser = new JButton("Add User"); // create and instantiate a button
		
		lList = new JLabel("");
				
		//adding the elements to the panel
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
		PList.add(lList);
		
		this.add(PFirstName);
		this.add(PSecondName);
		this.add(PDateArrival);
		this.add(PPassport);
	    this.add(PPriorityLevel);
		this.add(PSave);
		this.add(PList);
		
		//once we add all the elements we repaint, otherwise the program wont show the elements
		// everytime we add any element we have to repaint
		this.validate();
		this.repaint();
		
				
	}
	
		
	
	
		
} //end CLASS Add_New_User
