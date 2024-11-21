package Ejercicio6.parte1y3;


public class Node {

    private int value;
    private Node next;
    private Node prev;

    public Node(int value, Node next,Node prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public int getValue() { // C
        return value; // C
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() { // C
        return next; // C
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}