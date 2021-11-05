// StackLL.java
// Author: Dr. Jonathan Cazalas
// 6/12/2013
// Class from which we can create fully functional Stacks (using linked lists)

package stacklldemo;

public class StackLL {
	// top: reference variable to the top of the stack (same as "head" of linked list)
    private StackNode top;
    
    // CONSTRUCTOR
    public StackLL() {
        top = null;
    }
	
	
	/* Below are MANY methods that are used on stacks.
	 * 
	 * Examples:
	 * isEmpty, PUSH, POP, PEEK, and more.
	 */
	
	
	//
	// boolean | isEmpty()
	//
	public boolean isEmpty() {
		return top == null;
	}
	
	
	//
	// void | PrintStack()
	//
	public void PrintStack() {
		PrintStack(top);
	}
	//
	// void | PrintStack(StackNode)
	//
	private void PrintStack(StackNode top) {
		// We need to traverse...so we need a help ptr
		StackNode helpPtr = top;
		// Traverse to correct insertion point
		while (helpPtr != null) {
			// Print the data value of the node
			System.out.print(helpPtr.getData() + ", ");
			// Step one node over
			helpPtr = helpPtr.getNext();
		}
		System.out.println();
	}
	
	
	//
	// boolean | search(int)
	//
	public boolean search(int data) {
		return search(top, data);
	}
	//
	// boolean | search(StackNode, int)
	//
	private boolean search(StackNode p, int data) {
		// To search, we must traverse. Therefore, we need helpPtr.
		StackNode helpPtr = p;
		while (helpPtr != null) {
			if (helpPtr.getData() == data)
				return true;
			helpPtr = helpPtr.getNext(); // step one node over		
		}
		return false;
	}
	
	
	//
	// void | push(int)
	//
	public void push(int data) {
		top = push(top, data);
	}
	//
	// StackNode | push(StackNode, int)
	//
	private StackNode push(StackNode top, int data) {
		// Make a new StackNode with "data" as the data value
		// and set the "next" of this new node to the same address as top
		// * This is the same as addToFront() method for Linked Lists.
		top = new StackNode(data, top);
		
		// Now, return the newly updated top.
		return top;
	}
	
	
	//
	// StackNode | pop()
	//
	public StackNode pop() {
		// Save a reference to the current top node (because we will change where top points to)
		StackNode temp = top;
		
		// Now, invoke the pop method with top as a parameter.
		// This method will return a new top node.
		top = pop(top);
		
		// Finally, return temp, which is the previous top node that we just "popped" off the list.
		return temp;
	}
	//
	// StackNode | pop(StackNode)
	//
	private StackNode pop(StackNode top) {
		// Set top equal to the next node.
		// This will make top point to the 2nd node instead of the first node.
		top = top.getNext();
		
		// return the address/reference of the new top node
		return top;
	}
	
	
	//
	// int | peek()
	//
	public int peek() {
		// Invoke the peek method with top as a parameter
		int topValue = peek(top);
		
		// return topValue
		return topValue;
	}
	//
	// int | peek(StackNode)
	//
	private int peek(StackNode top) {
		// Return the data value of the top node.
		// You can see that we do NOT pop. We are only returning the data value.
		return top.getData();
	}
}
