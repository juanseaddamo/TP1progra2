package Ejercicio6.parte4;

public class Node {

    private int value;
    private int count;
    private Node next;

    public Node(int value, int count, Node next) {
        this.value = value;
        this.count = count;
        this.next = next;
    }

    public int getValue() { // C
        return value; // C
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Node getNext() { // C
        return next; // C
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
