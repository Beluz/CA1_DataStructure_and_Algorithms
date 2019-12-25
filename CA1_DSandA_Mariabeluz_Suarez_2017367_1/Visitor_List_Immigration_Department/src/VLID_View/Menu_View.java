/*
 * STUDENT NAME: MARIABELUZ SUAREZ AMADOR
 * STUDENT NUMBER: 2017367
 * BCS IT YEAR 3, GROUP B
 * MODULE: DATA STRUCTURES AND ALGORITHMS
 * ASSIGNMENT: VISITOR LIST IMMIGRATION DEPARTMENT
 * DATE: DECEMBER 2019
 */

package VLID_View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import VLID_Controller.Menu_Controller;

//CLASS Menu_View has the GUI elements of the main menu
public class Menu_View extends JFrame{

	//GLOBAL VARIABLES
	Menu_Controller controller;
	Add_New_User_View addUserView; //variable type of Add_New_User_View class
	Update_User_View updateUserView; // Variable type of Update_User_View
	Search_User_View searchUserView; // Variable type of Search_User_View
	Remove_User_View removeUserView; // Variable type of Remove_User_View
	
	public JLabel lWelcome;
	
	
	//CONSTRUCTOR
	public Menu_View (Menu_Controller mcontroller) {
		
		this.controller = mcontroller; //pass the controller from outside to this internal variable to be used
			
		setup(); // instantiate the setup
		creatingElements(); //call the method to create our elements of the view
	}//end Menu_View method
	
	//SETTING UP JFRAME
	private void setup() {
		this.setVisible(true);
		this.setSize(700, 500);
		this.setTitle("Welcome to Visitor List Immigration Department");	
	}//end setup method
	
	
	//CREATING ALL ELEMENTS OF THE MENU 
	private void creatingElements() {
		
		//create a panel
		JPanel PMenu = new JPanel();
		lWelcome = new JLabel("Welcome!" );
		
		//adding the elements to the panel
		PMenu.add(lWelcome);
	
		//create a Menu bar
		JMenuBar menuBar = new JMenuBar();
		
		//create Menus and MenuItems
		JMenu UserMenu = new JMenu("User");
		ImageIcon iconAdd = new ImageIcon("src/icons/addUser.gif");
	    JMenuItem AddUser = new JMenuItem("Add new User", iconAdd);
	    ImageIcon iconUpdate = new ImageIcon("src/icons/update_user.gif");
	    JMenuItem UpdateUser = new JMenuItem("Update Info User", iconUpdate);
	    ImageIcon iconSearch = new ImageIcon("src/icons/search_user.gif");
	    JMenuItem SearchUser = new JMenuItem("Search User", iconSearch);
	    
	    JMenu OperationsMenu = new JMenu("Operations in the queve");
	    ImageIcon iconRemove = new ImageIcon("src/icons/remove_user.gif");
	    JMenuItem RemoveUser = new JMenuItem("Remove User", iconRemove);
	    ImageIcon iconCutOff = new ImageIcon("src/icons/cut_list.gif");
	    JMenuItem CutList = new JMenuItem("Cut the queve", iconCutOff);
	    
	  //Actionlistener to the submenu that correspond
	    AddUser.addActionListener(controller); 
	    AddUser.setActionCommand("Add");
	    UpdateUser.addActionListener(controller); 
	    UpdateUser.setActionCommand("Update");
	    SearchUser.addActionListener(controller); 
	    SearchUser.setActionCommand("Search");
	    RemoveUser.addActionListener(controller); 
	    RemoveUser.setActionCommand("Remove");
		
	    //add items to the Menus
	    UserMenu.add(AddUser);
	    UserMenu.add(UpdateUser);
	    UserMenu.add(SearchUser);
	    OperationsMenu.add(RemoveUser);
	    OperationsMenu.add(CutList);
	    //add menus to menu bar
	    menuBar.add(UserMenu);
	    menuBar.add(OperationsMenu);
	    setJMenuBar(menuBar);
	    
		this.validate();
		this.repaint();
		
	}
	
	
	
  
	
	
	
//	private class MenuItemAction extends AbstractAction {
//
//        public MenuItemAction(String text, ImageIcon icon, Integer mnemonic) {
//            super(text);
//
//            putValue(SMALL_ICON, icon);
//            putValue(MNEMONIC_KEY, mnemonic);
//        }
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//
//            System.out.println(e.getActionCommand());
//        }
//
//    }

		
			
}
