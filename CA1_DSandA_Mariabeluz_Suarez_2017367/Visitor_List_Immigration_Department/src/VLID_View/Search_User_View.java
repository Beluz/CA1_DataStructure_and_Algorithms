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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import VLID_Controller.Menu_Controller;

//THIS CLASS IS TO SEARCH ANY USER GIVEN HIS ID NUMBER. ALSO EXTENDS JFRAME TOOL 
public class Search_User_View extends JFrame{

	//GLOBAL VARIABLES
	Menu_Controller controller;
	JPanel PID;
	JPanel PFirstName;
	JPanel PSecondName;
	JPanel PPriorityLevel;
	JPanel PPossitionQueve;
	public JFormattedTextField tID = new JFormattedTextField ();
	public JTextField tFirstName;
	JLabel lFirstName;
	public JTextField tLastName;
	JLabel lLastName;
	public JTextField tPriorityLevel;
	JLabel lPriorityLevel;
	public JTextField tPossition;
	JLabel lPossition;
	public JButton bSearchUser;
	
	//constructor
	public Search_User_View(Menu_Controller mcontroller) {
		
		this.controller = mcontroller;
		setupSearchUser(); // instantiate the setup
		creatingElementsSearchUser(); //call the method to create our elements of the view
		
		bSearchUser.addActionListener(controller);
		bSearchUser.setActionCommand("Search_User");
		tID.addActionListener(controller);
		tID.setActionCommand("Search_User");
		
	}//end Add_New_User method
	
	
	//SETTING UP JFRAME
	private void setupSearchUser() {
		this.setVisible(true);
		this.setSize(600, 400);
		this.setTitle("Search User");		
	}
		
	
	//CREATING ELEMENTS OF THE VIEW
	private void creatingElementsSearchUser() {
		//USING A GRID LAYOUT MANAGER
		GridLayout frameManager = new GridLayout(0, 1);
		this.setLayout(frameManager);
		
		PID = new JPanel();
		PFirstName = new JPanel();
		PSecondName = new JPanel();
		PPossitionQueve = new JPanel();
		PPriorityLevel = new JPanel();
		
		JLabel lID;
		
		//tID.setValue(new Integer(0));
		////////////////////////////////////////////////////////////////////////////
		////   http://www.forosdelweb.com/f45/jtextfield-solo-numerico-575289/
		//tID.setValue(Integer.class);
		tID.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar();
			if (!(Character.isDigit(c) ||
			(c == KeyEvent.VK_BACK_SPACE) ||
			(c == KeyEvent.VK_DELETE))) {
			getToolkit().beep();
			e.consume();
			}
			}
		});
		///////////////////////////////////////////////////////////////////////////
		
		
		
		lID = new JLabel("Introduce User's ID: ");
		tID.setText("                         ");
		lFirstName = new JLabel("First Name: ");
		tFirstName = new JTextField(30);//instantiation of a Textfield
		tFirstName.setEnabled(false);
		tFirstName.setText("");
		
		lLastName = new JLabel("Last Name: ");
		tLastName = new JTextField(30);//instantiation of a Textfield
		tLastName.setEnabled(false);
		tLastName.setText("");
		
		lPossition = new JLabel("Possition: ");
		tPossition = new JTextField(30);//instantiation of a Textfield
		tPossition.setEnabled(false);
		
		lPriorityLevel = new JLabel("Priority Level: ");
		tPriorityLevel = new JTextField(30);//instantiation of a Textfield
		tPriorityLevel.setText("");
		tPriorityLevel.setEnabled(false);
	
		bSearchUser = new JButton("Search"); // create and instantiate a button

		
		//adding the elements to the panel
		PID.add(lID);
		PID.add(tID);
		PID.add(bSearchUser);
		PFirstName.add(lFirstName);
		PFirstName.add(tFirstName);
		PSecondName.add(lLastName);
		PSecondName.add(tLastName);
		PPossitionQueve.add(lPossition);
		PPossitionQueve.add(tPossition);
		PPriorityLevel.add(lPriorityLevel);
		PPriorityLevel.add(tPriorityLevel);
		
		this.add(PID);
		//this.add(tID);
		this.add(PFirstName);
		this.add(PSecondName);
		this.add(PPossitionQueve);
	    this.add(PPriorityLevel);
		
		//once we add all the elements we repaint, otherwise the program wont show the elements
		// everytime we add any element we have to repaint
		this.validate();
		this.repaint();
		
				
	}
	
			

	
}//end class
