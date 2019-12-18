/*
 * STUDENT NAME: MARIABELUZ SUAREZ AMADOR
 * STUDENT NUMBER: 2017367
 * BCS IT YEAR 3, GROUP B
 * MODULE: DATA STRUCTURES AND ALGORITHMS
 * ASSIGNMENT: VISITOR LIST IMMIGRATION DEPARTMENT
 * DATE: DECEMBER 2019
 */

package DoublyLinkedList;

//CLASS TO CREATE NODES
public class Node <E>{
    
    // the data of the node
	public int data; 
	// This is a pointer to next node
    public Node nextNode; 
    // This is a pointer to previous node
    public Node previousNode;
    
    //Constructor without parameters, like when is the first one on the queue
    public Node(int newData){
    	this.previousNode = null; //previous node is null
        this.data = newData;  //actual data
        this.nextNode = null; //next node is null
    }
    
  //Constructor with parameters this is when there is already more nodes in the queue
    public Node(Node previousNode, int data, Node nextNode){ 
        this.previousNode = previousNode;
    	this.data = data;
        this.nextNode = nextNode;
        
    }

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	public Node getPreviousNode() {
		return previousNode;
	}

	public void setPreviousNode(Node previousNode) {
		this.previousNode = previousNode;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
    
    

}
