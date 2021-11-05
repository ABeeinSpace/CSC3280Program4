// StackNode.java
// Author: Dr. Jonathan Cazalas
// 6/12/2013
// Class from which we can create Stack node objects

package stacklldemo;

public class StackNode {
    private int data;
    private StackNode next;
    
    // CONSTRUCTORS
    public StackNode() {
        data = 0;
        next = null;
    }
    
    public StackNode(int data) {
        this.data = data;
        next = null;
    }
    
    public StackNode(int data, StackNode next) {
        this.data = data;
        this.next = next;
    }

    // ACCESSORS
    public int getData() {
        return data;
    }

    public StackNode getNext() {
        return next;
    }


    // MUTATORS
    public void setData(int data) {
        this.data = data;
    }

    public void setNext(StackNode next) {
        this.next = next;
    }
}
