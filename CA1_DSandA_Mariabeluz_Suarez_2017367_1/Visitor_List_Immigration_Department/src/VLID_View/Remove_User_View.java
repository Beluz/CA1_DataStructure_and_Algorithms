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

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import VLID_Controller.Menu_Controller;

//CLASS TO REMOVE USERS FROM THE QUEVE
public class Remove_User_View extends JFrame{

	//GLOBAL VARIABLES
	Menu_Controller controller;
	JPanel PID;
	JPanel PFirstName;
	JPanel PSecondName;
	JPanel PPriorityLevel;
	JPanel PPossitionQueve;
	JPanel PRemove;
	
	
	//constructor
	public Remove_User_View(Menu_Controller mcontroller) {
		
		this.controller = mcontroller;
		setupRemoveUser(); // instantiate the setup
		creatingElementsRemoveUser(); //call the method to create our elements of the view
	}//end Add_New_User method
	
	
	//SETTING UP JFRAME
	private void setupRemoveUser() {
		this.setVisible(true);
		this.setSize(600, 400);
		this.setTitle("Remove User");		
	}
		
	
	//CREATING ELEMENTS OF THE VIEW
	private void creatingElementsRemoveUser() {
		//USING A GRID LAYOUT MANAGER
		GridLayout frameManager = new GridLayout(0, 1);
		this.setLayout(frameManager);
		
		PID = new JPanel();
		PFirstName = new JPanel();
		PSecondName = new JPanel();
		PPossitionQueve = new JPanel();
		PPriorityLevel = new JPanel();
		PRemove = new JPanel();
		
		JLabel lID;
		JFormattedTextField tID = new JFormattedTextField ();
		
		tID.setValue(new Integer(0));
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
		
		JTextField tFirstName;
		JLabel lFirstName;
		JTextField tLastName;
		JLabel lLastName;
		JTextField tPriorityLevel;
		JLabel lPriorityLevel;
		JTextField tPossition;
		JLabel lPossition;
		JButton bSearchUser;
		JButton bRemoveUser;
		
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
	
		bSearchUser = new JButton("Search"); // create and instantiate a button Search
		bRemoveUser = new JButton("Remove"); // create and instantiate a button Remove

		
		//adding the elements to the panel
		PID.add(lID);
		PID.add(tID);
		PID.add(bSearchUser);
		PFirstName.add(lFirstName);
		PFirstName.add(tFirstName);
		PSecondName.add(lLastName);
		PSecondName.add(tLastName);
		PPossitionQueve.add(lPriorityLevel);
		PPossitionQueve.add(tPriorityLevel);
		PPriorityLevel.add(lPriorityLevel);
		PPriorityLevel.add(tPriorityLevel);
		PRemove.add(bRemoveUser);
		
		this.add(PID);
		//this.add(tID);
		this.add(PFirstName);
		this.add(PSecondName);
		this.add(PPossitionQueve);
	    this.add(PPriorityLevel);
	    this.add(PRemove);
		
		//once we add all the elements we repaint, otherwise the program wont show the elements
		// everytime we add any element we have to repaint
		this.validate();
		this.repaint();
		
				
	}
	
			

	
}//end class

