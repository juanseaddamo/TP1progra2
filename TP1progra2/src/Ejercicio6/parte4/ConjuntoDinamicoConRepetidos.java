package Ejercicio6.parte4;



import java.util.Random;

public class ConjuntoDinamicoConRepetidos implements Set {

    private Node first;
    private final Random random;
    private int size;

    public ConjuntoDinamicoConRepetidos() {
        this.first = null;
        this.random = new Random();
        this.size = 0;
    }

    @Override
    public void add(int a) {
        if(this.isEmpty()) {
            this.first = new Node(a,1,null);
            this.size++;
            return;
        }
        Node current = this.first;
        while (current != null) {
            if (current.getValue() == a) {
                current.setCount(current.getCount() + 1);
                return;
            }
            if (current.getNext() == null) {
                break;
            }
            current = current.getNext();
        }
        current.setNext(new Node(a, 1, null));
        this.size++;
    }

    @Override
    public int choose() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede elegir un elemento de un conjunto vacío");
        }
        int i = random.nextInt(size);
        int count = 0;
        Node current = this.first;
        while(current != null) {
            if(count == i) {
                return current.getValue();
            }
            current = current.getNext();
        }
        return -1;
    }

    @Override
    public void remove(int a) {
        if (this.isEmpty()) {
            return;
        }
        if (this.first.getNext() == null) {
            if (this.first.getValue() == a) {
                if (this.first.getCount() > 1) {
                    this.first.setCount(this.first.getCount() + 1);
                } else {
                    this.first = null;
                    this.size--;
                }
            }
            return;
        }

        if (this.first.getValue() == a) {
            if (this.first.getCount() > 1) {
                this.first.setCount(this.first.getCount() - 1);
            } else {
                this.first = this.first.getNext();
                this.size--;
            }
            return;
        }

        Node current = this.first.getNext();
        Node previous = this.first;
        while (current != null) {
            if (current.getValue() == a) {
                if (current.getCount() > 1) {
                    current.setCount(current.getCount() - 1);
                } else {
                    previous.setNext(current.getNext());
                    this.size--;
                }
                return;
            }
            previous = current;
            current = current.getNext();
        }
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }
}
