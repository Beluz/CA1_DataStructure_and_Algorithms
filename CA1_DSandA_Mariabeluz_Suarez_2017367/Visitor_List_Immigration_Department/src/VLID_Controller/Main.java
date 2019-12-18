/*
 * STUDENT NAME: MARIABELUZ SUAREZ AMADOR
 * STUDENT NUMBER: 2017367
 * BCS IT YEAR 3, GROUP B
 * MODULE: DATA STRUCTURES AND ALGORITHMS
 * ASSIGNMENT: VISITOR LIST IMMIGRATION DEPARTMENT
 * DATE: DECEMBER 2019
 */


package VLID_Controller;

import javax.swing.JOptionPane;

import DoublyLinkedList.DoublyLinkedList;

//Package Controller will contain Main class.

public class Main {

	public static void main(String[] args) {
		
	    // Call the Main menu which contains the option to show to the users.
		new Menu_Controller();

//		DoublyLinkedList lista = new DoublyLinkedList();
//		int option=0;
//		int elemento;
//		
//		do {
//			try {
//				
//				option = Integer.parseInt(JOptionPane.showInputDialog(null, "1.agregar un nodo al inicio\n"
//								+ "2.agregar un nodo al final\n" + "3.mostrar lista inicio al fin\n"
//								+ "4.mostrar lista fin a inicio\n" + "5.salir", JOptionPane.INFORMATION_MESSAGE));
//				
//				switch (option) {
//				case 1:
//					elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "ingresa el elemento\n"
//							+ "agregar un nodo al inicio", JOptionPane.INFORMATION_MESSAGE));
//					lista.addToFront(elemento);
//					break;
//				case 2:
//					elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "ingresa el elemento\n"
//							+ "agregar un nodo al final", JOptionPane.INFORMATION_MESSAGE));
//					lista.addToEnd(elemento);
//					break;
//				case 3:
//					if(!lista.isEmpty()) {
//						lista.showListFrontToEnd();
//					}else {
//						JOptionPane.showMessageDialog(null, "no hay nodos", "lista vacia", JOptionPane.INFORMATION_MESSAGE);
//					}
//					break;
//				case 4:
//					if(!lista.isEmpty()) {
//						lista.showListEndToFront();
//					}else {
//						JOptionPane.showMessageDialog(null, "no hay nodos", "lista vacia", JOptionPane.INFORMATION_MESSAGE);
//					}
//					break;
//				case 5:
//					break;
//				}
//				
//			}catch(NumberFormatException n) {
//				JOptionPane.showMessageDialog(null, "error");
//			}
//		}while(option !=5);
		
	}

}
