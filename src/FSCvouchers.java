public class FSCvouchers {
	int top;
	int maxSize;
	FSCvoucher[] stack;

	public FSCvouchers(int size) {
		maxSize = size;
		stack = new FSCvoucher[maxSize];
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
		return stack[top--];
	}

	public FSCvoucher peek() {
		return stack[top];
	}

	public void push(FSCvoucher newVoucher) {
		stack[top++] = newVoucher;
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

	public void PrintStack() {
		for (int i = 0; i <= top; i++) {
			System.out.print(stack[i] + ", ");
		}
		// print a newline
		System.out.println();
	}
}
