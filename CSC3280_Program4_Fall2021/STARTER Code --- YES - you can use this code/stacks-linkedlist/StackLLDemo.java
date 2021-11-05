// StackLLDemo.java
// Author: Dr. Jonathan Cazalas
// 6/12/2013
// Program to test the stack (linked-list version)

package stacklldemo;

import java.util.Scanner;

public class StackLLDemo {

	public static void main(String[] args) {
		// Make Scanner
		Scanner input = new Scanner(System.in);
		
		// Other variables
		int choice; // user choice
		int value;  // value to insert, delete, or search for
		
		// Make a new Linked List called myList
        StackLL myStack = new StackLL();
		
		// Do/while loop showing menu, getting user choice, and performing actions
		do {
			// Show menu and get user choice
			showMenu();
			choice = input.nextInt();
			
			// PUSH new node into stack
			if (choice == 1) {
				System.out.print(">    What value do you want to push: ");
				value = input.nextInt();
				
				// Invoke push method with "value" as the parameter
				myStack.push(value);
				System.out.println(">    " + value + " was successfully pushed into the stack.");
				System.out.println();
			}
			
			// POP node from stack
			else if (choice == 2) {				
				// First, check to see if stack is empty.
				// IF it is, then we clearly cannot POP
				if (myStack.isEmpty()) {
					System.out.println(">    Error: cannot pop stack (stack is empty).");
				}
				// ELSE, POP the stack. The pop() method returns a reference to the popped node.
				// You can do whatever you want with this reference. Here, we simply print the Data value,
				// indicating that it has been popped from the stack.
				else {
					StackNode temp = myStack.pop();
					System.out.println(">    " + temp.getData() + " has been popped from the stack.");
				}
				System.out.println();
			}
			
			// PEEK (look at) the top value of the stack...but do not actually pop it off
			else if (choice == 3) {
				// First, check to see if stack is empty.
				// IF it is, then we clearly cannot PEEK
				if (myStack.isEmpty()) {
					System.out.println(">    Error: cannot peek at stack (stack is empty).");
				}
				// ELSE, we invoke the peek() method, which returns an int value, representing
				// the value at the top of the stack. If you prefer, you could have the peek() method
				// return a reference to the actual top node. This gives you more flexibility to print
				// a variety of data members, modify the node, etc.
				else {
					System.out.println(">    " + myStack.peek() + " is the value at the top of the stack.");
				}
				System.out.println();
			}
			
			// Search for an item in the stack
			else if (choice == 4) {
				System.out.print(">    What value do you want to search for: ");
				value = input.nextInt();
				if (myStack.search(value))
					System.out.println(">    " + value + " was found in the stack.");
				else
					System.out.println(">    " + value + " was not found in the stack.");
				System.out.println();
			}
			
			// Print all nodes in stack
			else if (choice == 5) {
				if (myStack.isEmpty()) {
					System.out.println(">    Error: cannot print nodes (the stack is empty)");
					System.out.println();
				}
				else {
					System.out.println(">    Printing All Nodes:");
					System.out.print(">    ");
					myStack.PrintStack();
					System.out.println();
					System.out.println();
				}
			}

			// Quit
			else if (choice == 6) {
				System.out.println(">    Goodbye!");
				System.out.println();
			}
			else {
				System.out.println(">    Wrong selection. Try again.");
				System.out.println();
			}
			
		} while (choice != 6);
	}
	
	public static void showMenu() {
		System.out.println("|-----------------------------------------------|");
		System.out.println("|------     Stack - Linked List (Menu)    ------|");
		System.out.println("|-----------------------------------------------|");
		System.out.println("|   1. Push an item into the stack              |");
		System.out.println("|   2. Pop (and print) an item from the stack   |");
		System.out.println("|   3. Peek (look at) the top item in the stack |");
		System.out.println("|   4. Search for an item in the stack          |");
		System.out.println("|   5. Print all nodes in the stack             |");
		System.out.println("|   6. Quit                                     |");
		System.out.println("|-----------------------------------------------|");
		System.out.println();
		System.out.print("> Please enter your choice: ");
	}
}
