public class FSCcarCleanQ {
	FSCmember front;
	FSCmember back;
	int numCustomers;
	int maxSize;

	public FSCcarCleanQ() {
		this.front = null;
		this.back = null;
	}

	public FSCcarCleanQ(int maxSize) {
		this.front = null;
		this.back = null;
		this.maxSize = maxSize;
	}

	public boolean isEmpty() {
		return front == null;
	}

	public void printQueue() {
		PrintQueue(front);
	}

	private void PrintQueue(FSCmember front) {
		// We need to traverse...so we need a help ptr
		FSCmember helpPtr = front;
		// Traverse to correct insertion point
		while (helpPtr != null) {
			// Print the data value of the node
			System.out.print(helpPtr + ", ");
			// Step one node over
			helpPtr = helpPtr.getNext();
		}
		System.out.println();
	}

	public boolean search(int ID) {
		return search(front, ID);
	}

	private boolean search(FSCmember p, int ID) {
		// To search, we must traverse. Therefore, we need helpPtr.
		FSCmember helpPtr = p;
		while (helpPtr != null) {
			if (helpPtr.getID() == ID)
				return true;
			helpPtr = helpPtr.getNext(); // step one node over
		}
		return false;
	}

	public void enqueue(FSCmember newPerson) {
		if (isEmpty()) {
			front = back = enqueue(front, back, newPerson);
		} else {
			back = enqueue(front, back, newPerson);
		}
	}

	private FSCmember enqueue(FSCmember front, FSCmember back, FSCmember newPerson) {
		// Make a new QueueNode with "data" as the data value
		FSCmember temp = newPerson;

		// Now, if the list is empty, return the reference for temp
		// and save this reference into both "front" and "back"
		// Why? Since this is the only node in the queue, it will be the front and back node
		if (isEmpty()) {
			numCustomers++;
			return temp;
		}
		// ELSE, the queue is not empty. We need to insert temp at the back of the queue.
		// So save the address of the new node into the next of back.
		// Then, make back "traverse" one node over, so it now points to the new back node.
		// Finally, return the updated address of back.
		else {
			back.setNext(temp);
			back = back.getNext();
			numCustomers++;
			return back;
		}
	}

	public FSCmember dequeque() {
		FSCmember temp = front;
		front = dequeue(front);
		if (front == null)
			back = null;
		return temp;
	}

	private FSCmember dequeue(FSCmember front) {
		front = front.getNext();
		return front;
	}

	public FSCmember peek() {
		return front;
	}

	private String peek(FSCmember front) {
		// Return the data value of the front node.
		// You can see that we do NOT dequeue. We are only returning the data value.
		return front.toString();
	}
}
