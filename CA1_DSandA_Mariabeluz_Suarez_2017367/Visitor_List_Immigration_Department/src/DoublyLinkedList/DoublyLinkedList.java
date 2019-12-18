/*
 * STUDENT NAME: MARIABELUZ SUAREZ AMADOR
 * STUDENT NUMBER: 2017367
 * BCS IT YEAR 3, GROUP B
 * MODULE: DATA STRUCTURES AND ALGORITHMS
 * ASSIGNMENT: VISITOR LIST IMMIGRATION DEPARTMENT
 * DATE: DECEMBER 2019
 */

package DoublyLinkedList;

import javax.swing.JOptionPane;

//THIS CLASS REPRESENT A NODE IN A DOUBLY LINKED LIST
public class DoublyLinkedList <E> {

	/*
	 * This class was build based and following the logic from a tutorial on Youtube: 
	 * https://www.youtube.com/watch?v=8oCjWIJJI9c&list=WL&index=42&t=0s
	 */
	
	
	// Front node of the list
    private Node<E> front, End, middleNode;
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
	public int size() {
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
	public void addBetween(int newData) {
        if (isEmpty()) //if is empty
            front = End = new Node<E>(newData);
        else {
        	while(front !=null) {
        		if(front.getData() == newData) {
        			System.out.println("data " + newData);
        		}
        		front = front.getNextNode();
        	}
        	//middleNode = new Node(middleNode, newData, nextNode);
        	//middleNode.previousNode.nextNode = middleNode;
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
	
	
	////////////////////////////////////////////////////////////
	
	
} //END OF THE CLASS
