// QueueNode.java
// Author: Dr. Jonathan Cazalas
// 6/12/2013
// Class from which we can create Stack node objects

package queuelldemo;

public class QueueNode {
	private int data;
    private QueueNode next;
    
    // CONSTRUCTORS
    public QueueNode() {
        data = 0;
        next = null;
    }
    
    public QueueNode(int data) {
        this.data = data;
        next = null;
    }
    
    public QueueNode(int data, QueueNode next) {
        this.data = data;
        this.next = next;
    }

    // ACCESSORS
    public int getData() {
        return data;
    }

    public QueueNode getNext() {
        return next;
    }


    // MUTATORS
    public void setData(int data) {
        this.data = data;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }
}
