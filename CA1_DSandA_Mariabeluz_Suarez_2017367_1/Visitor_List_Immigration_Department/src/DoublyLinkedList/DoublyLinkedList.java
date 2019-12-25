/*
 * STUDENT NAME: MARIABELUZ SUAREZ AMADOR
 * STUDENT NUMBER: 2017367
 * BCS IT YEAR 3, GROUP B
 * MODULE: DATA STRUCTURES AND ALGORITHMS
 * ASSIGNMENT: VISITOR LIST IMMIGRATION DEPARTMENT
 * DATE: DECEMBER 2019
 */

package DoublyLinkedList;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

//THIS CLASS REPRESENT A NODE IN A DOUBLY LINKED LIST
public class DoublyLinkedList <E> extends JFrame {

	/*
	 * This class was build based and following the logic from a tutorial on Youtube: 
	 * https://www.youtube.com/watch?v=8oCjWIJJI9c&list=WL&index=42&t=0s
	 */
	
	
	// Front node of the list
    private Node<E> front, End, middleNode;
    public int PreviousNode, NextNode, positionNode, dataNode;
    
    // size of the list
    private int size;

	//Constructor DoublyLinkedList
    public DoublyLinkedList() {
        front = End = null; //initiate End and Front to null
        size = 0;//modificationCount = 0;
        
    }
    
	
    //Return true if is 0, otherwise return false
    //Method to know if the list is empty
	public boolean isEmpty() {
	    return size == 0;
	}
	
	//Return the variable size
	public int sizes() {
		return size;
	}

	    
	
	//METHOD ADD A NEW NODE TO THE FRONT OF THE LIST
	//This method can have two different options
	//when the list is empty, then initiate a new node and store it in Front variable
	// When the list is not-empty, then put the actual node into a temporal variable and put the new node at the front
	
	public void addToFront(int newData) {
        if (isEmpty()) //if is empty
            front = End = new Node<E>(newData);
        else { //if is not empty
        	//previous point to null, next point to front
            front = new Node(null, newData, front);
            front.nextNode.previousNode = front;
        }
        size++;
    }
	
//	public void addToFront(int newData) {
//        if (isEmpty()) //if is empty
//            front = new Node<E>(newData);
//        else { //if is not empty
//            Node<E> temporal = front;
//            front = new Node<E>(null, newData, temporal);
//            front.nextNode.previousNode = front;
//        }
//        size++;
//    }
	
	// THIS METHOD ADD A NEW NODE AT THE END OF THE LIST
	// when the list is empty, then initiate a new node and store it in Front variable
	// When the list is not-empty then traverse to the end of the list and put the last node of the list to point to the new node
	public void addToEnd(int newData) {
        if (isEmpty()) //if is empty
            front = End = new Node<E>(newData);
        else {
        	End = new Node(End, newData, null);
        	End.previousNode.nextNode = End;
        }
        size++;
    }
	
	//////////////////////// Method to add a node between nodes
	// this method will insert a node somewhere in the middle of the list
	public void addBetween(int newData, int dataLastHigh) {
		// if the list is empty then create a new node
        if (isEmpty()) //if is empty
            front = new Node<E>(newData);
        else { //if not then go traverse the list until find null
        	while(front !=null) {
        		//  ask if the data in the current node is equals to the data we are looking for
        		if(front.getData() == dataLastHigh) {
        			//create a new node called middlenode and point its nextside to the next node on the list
        			// now the middlenode.netx is pointing to the nextnode on the list and middlenode.previous is pointing to the current node in the list
        			System.out.println("data last high node" + dataLastHigh);
        			middleNode = new Node(front, newData, front.getNextNode());
        			//middlenode in its previousnode(which id the current node).nextnode which means nextnode of the previous node is pointing to the new node(middlenode) 
                	middleNode.previousNode.nextNode = middleNode;
                	//set variables to previous and next
                	PreviousNode = front.getData();
                	
                	if(front.getNextNode() == null) {
        				NextNode = 0;
        			}else {
        				NextNode = middleNode.getNextNode().getData();
        			}
                	//show the list
                	showListFrontToEnd();
        		}
        		front = front.getNextNode();
        	}
        }
        size++;
    }
	
	
	
	// METHOD TO SHOW THE LIST FROM FRONT TO END
	public void showListFrontToEnd() {
		if(!isEmpty()) {
			String datos = "<==>";
			Node aux = front;
			while(aux!=null){
				datos = datos + "[" + aux.data + "]<==>";
				aux = aux.nextNode;
			}
			JOptionPane.showMessageDialog(null, datos, "mostrando", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	// METHOD TO SHOW THE LIST FROM END TO FRONT
	public void showListEndToFront() {
		if(!isEmpty()) {
			String datos = "<==>";
			Node aux = End;
			while(aux!=null){
				datos = datos + "[" + aux.data + "]<==>";
				aux = aux.previousNode;
			}
			JOptionPane.showMessageDialog(null, datos, "mostrando", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	//METHOD TO SEARCH A NODE
	public void searchNode(int data) {
		if (isEmpty()) //if is empty
			JOptionPane.showMessageDialog(this, "The List is empty" );
        else {
        	Node temp = front;
        	while(temp != null) {
        		if(temp.getData() == data) {
        			if (size==1) {
        				PreviousNode=0;
        			}else {
        				PreviousNode = temp.getPreviousNode().getData();	
        			}
        			
        			if(temp.getNextNode() == null) {
        				NextNode = 0;
        			}else {
        				NextNode = temp.getNextNode().getData();
        			}
        			
        			JOptionPane.showMessageDialog(this, "The element is in position: "+ size );
        			//positionNode = size;
        		}
        		temp = temp.getNextNode();
        	}
        }
        size++;
	}
	
	////////////////////////////////////////////////////////////
	
	
} //END OF THE CLASS
