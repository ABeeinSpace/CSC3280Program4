/*
 USING LATE PASS
 Aidan Border
 11/10/2021
 CSC 3280
 Honor Code: I will practice academic and personal integrity and excellence of character and expect the same from
 others
*/

public class FSCvouchers {
	private int top;
	private int maxSize;
	private FSCvoucher[] stack;

	public FSCvouchers(int size) {
		maxSize = size;
		this.stack = new FSCvoucher[maxSize];
		top = -1;
	}

	/*Empty constructor for completeness' sake*/
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

	/*This method is used in the Lowly Minion sim. It nulls out the stack to simulate the Lowly Minion physically
	taking the stack of vouchers into the back room or wherever he takes them. */
	public void clearStack() {
		for (int i = 0; i <= top; i++) {
			stack[i] = null;
		}
	}
}
