package Ejercicio1;

public class QueueOfStacks {
    private final int MAX = 10;
    private final ArrayOfStacks[] array;
    private int front = 0;
    private int rear = -1;
    private int count = 0;

    public QueueOfStacks() {
        this.array = new ArrayOfStacks[MAX];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void add(ArrayOfStacks stack) {
        if (count == MAX) {
            throw new RuntimeException("La cola esta vacia");
        }
        rear = (rear + 1) % MAX;
        array[rear] = stack;
        count++;
    }

    public ArrayOfStacks getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("La cola esta vacia");
        }
        return array[front];
    }

    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("La cola esta vacia");
        }
        front = (front + 1) % MAX;
        count--;
    }

    public int size() {
        return count;
    }
}

