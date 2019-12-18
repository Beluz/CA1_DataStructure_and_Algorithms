/*
 * STUDENT NAME: MARIABELUZ SUAREZ AMADOR
 * STUDENT NUMBER: 2017367
 * BCS IT YEAR 3, GROUP B
 * MODULE: DATA STRUCTURES AND ALGORITHMS
 * ASSIGNMENT: VISITOR LIST IMMIGRATION DEPARTMENT
 * DATE: DECEMBER 2019
 */

package DoublyLinkedList;

public enum Priority {

	HIGH(1),
	MEDIUM(2),
	LOW(3);
	
	private int Priority_Level;
	//Add a constructor of the enum
	Priority(int p){ Priority_Level=p; }
	
    // Add a method to return the value of each priority level
    public int getPriority(){return Priority_Level;}
    
}
