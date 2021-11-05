// QueueLLDemo.java
// Author: Dr. Jonathan Cazalas
// 6/12/2013
// Program to test the queue (linked-list version)

package queuelldemo;

import java.util.Scanner;

public class QueueLLDemo {

	public static void main(String[] args) {
		// Make Scanner
		Scanner input = new Scanner(System.in);
		
		// Other variables
		int choice; // user choice
		int value;  // value to enqueue, dequeue, or search for
		
		// Make a new Linked List called myList
        QueueLL myQueue = new QueueLL();
		
		// Do/while loop showing menu, getting user choice, and performing actions
		do {
			// Show menu and get user choice
			showMenu();
			choice = input.nextInt();
			
			// ENQUEUE new node into queue
			if (choice == 1) {
				System.out.print(">    What value do you want to enqueue: ");
				value = input.nextInt();
				
				// Invoke push method with "value" as the parameter
				myQueue.enqueue(value);
				System.out.println(">    " + value + " was successfully enqueued into the queue.");
				System.out.println();
			}
			
			// DEQUEUE node from queue
			else if (choice == 2) {				
				// First, check to see if queue is empty.
				// IF it is, then we clearly cannot POP
				if (myQueue.isEmpty()) {
					System.out.println(">    Error: cannot perform dequeue (queue is empty).");
				}
				// ELSE, DEQUEUE the queue. The dequeue() method returns a reference to the dequeued node.
				// You can do whatever you want with this reference. Here, we simply print the Data value,
				// indicating that it has been dequeued from the stack.
				else {
					QueueNode temp = myQueue.dequeue();
					System.out.println(">    " + temp.getData() + " has been dequeued from the queue.");
				}
				System.out.println();
			}
			
			// PEEK (look at) the 1st value of the queue...but do not actually dequeue
			else if (choice == 3) {
				// First, check to see if queue is empty.
				// IF it is, then we clearly cannot PEEK
				if (myQueue.isEmpty()) {
					System.out.println(">    Error: cannot peek at queue (queue is empty).");
				}
				// ELSE, we invoke the peek() method, which returns an int value, representing
				// the value at the front of the queue. If you prefer, you could have the peek() method
				// return a reference to the actual front node. This gives you more flexibility to print
				// a variety of data members, modify the node, etc.
				else {
					System.out.println(">    " + myQueue.peek() + " is the value at the top of the queue.");
				}
				System.out.println();
			}
			
			// Search for an item in the queue
			else if (choice == 4) {
				System.out.print(">    What value do you want to search for: ");
				value = input.nextInt();
				if (myQueue.search(value))
					System.out.println(">    " + value + " was found in the queue.");
				else
					System.out.println(">    " + value + " was not found in the queue.");
				System.out.println();
			}
			
			// Print all nodes in queue
			else if (choice == 5) {
				if (myQueue.isEmpty()) {
					System.out.println(">    Error: cannot print nodes (the queue is empty)");
					System.out.println();
				}
				else {
					System.out.println(">    Printing All Nodes:");
					System.out.print(">    ");
					myQueue.PrintQueue();
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
		System.out.println("|------     Queue - Linked List (Menu)    ------|");
		System.out.println("|-----------------------------------------------|");
		System.out.println("|   1. Enqueue an item                          |");
		System.out.println("|   2. Dequeue (and print) an item              |");
		System.out.println("|   3. Peek (look at) the 1st item in the queue |");
		System.out.println("|   4. Search for an item in the queue          |");
		System.out.println("|   5. Print all nodes in the queue             |");
		System.out.println("|   6. Quit                                     |");
		System.out.println("|-----------------------------------------------|");
		System.out.println();
		System.out.print("> Please enter your choice: ");
	}
}
