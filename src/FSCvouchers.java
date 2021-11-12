/*
 Aidan Border
 11/10/2021
 CSC 3280
 Honor Code: I will practice academic and personal integrity and excellence of character and expect the same from
 others
*/

public class FSCvouchers {
	int top;
	int maxSize;
	FSCvoucher[] stack;

	public FSCvouchers(int size) {
		maxSize = size;
		this.stack = new FSCvoucher[maxSize];
		top = -1;
	}

	public FSCvouchers() {

	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == maxSize - 1);
	}

	public FSCvoucher pop() {
		return stack[top - 1];
	}

	public FSCvoucher peek() {
		return stack[top];
	}

	public void push(FSCvoucher newVoucher) {
		this.stack[++top] = newVoucher;
	}

	public boolean search(int value) {
		for (int i = 0; i <= top; i++) {
			// if the value is found at stack[i], return true
			if (stack[i].getID() == value)
				return true;
		}
		// If we make it till here, the value was not found in the array.
		return false;
	}

	public void printStack() {
		for (int i = 0; i <= top; i++) {
			System.out.print(stack[i]);
		}
		// print a newline
		System.out.println();
	}

	public void clearStack() {
		for (int i = 0; i <= top; i++) {
			stack[i] = null;
		}
	}
}
