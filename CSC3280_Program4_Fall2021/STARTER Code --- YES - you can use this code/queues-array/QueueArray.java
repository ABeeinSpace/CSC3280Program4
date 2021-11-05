// QueueArray.java
// Author: Dr. Jonathan Cazalas
// Class from which we can create fully functional Queues (using arrays)

public class QueueArray {
	private int[] queue;
	private int maxSize;
	private int front;
	private int numItems;
	
	// Constructor
	public QueueArray (int size) {
		maxSize = size;             // set array size
		queue = new int[maxSize];   // create array for stack
		front = 0;                  // set top to -1 (no items in stack yet)
		numItems = 0;               // initialize numItems to zero
	}
	
	
	//
	// boolean | isFull()
	//
	public boolean isFull () {
		return (numItems == maxSize);
	}
	
	
	//
	// boolean | isEmpty()
	//
	public boolean isEmpty() {
		return (numItems == 0);
	}
	
	
	//
	// int | size()
	//
	public int size() {
		return numItems;
	}
	
	
	//
	// void | enqueue(int)
	//
	public void enqueue(int value) {
		queue[(front+numItems) % maxSize] = value;
		numItems++;
	}
	
	
	//
	// int | dequeue()
	//
	public int dequeue() {
		int temp = queue[front];
		// update the location of front
		front = (front+1) % maxSize;
		// decrement numItems
		numItems--;
		// return the previous front value
		return temp;
	}
	
	
	//
	// int | peek()
	//
	public int peek() {
		return queue[front];
	}
	
	
	//
	// boolean | search(int)
	//
	public boolean search(int value) {
		for(int i=0; i<numItems; i++) {
			// if the value is found, return true
			if (queue[(front+i)%maxSize] == value)
				return true;
		}
		// If we make it till here, the value was not found in the array.
		return false;
	}
	
	
	//
	// void | PrintQueue()
	//
	public void PrintQueue() {
		for(int i=0; i<numItems; i++) {
			System.out.print(queue[(front+i)%maxSize] + ", ");
		}
		// print a newline
		System.out.println();
	}
}
