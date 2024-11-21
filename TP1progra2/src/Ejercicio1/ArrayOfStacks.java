package Ejercicio1;

public class ArrayOfStacks implements Stack {
    private final int[] array;
    private int count;
    private final int MAX;

    public ArrayOfStacks(int maxSize) {
        this.MAX = maxSize;
        this.array = new int[MAX];
        this.count = 0;
    }

    @Override
    public void add(int value) {
        if (count == MAX) {
            throw new RuntimeException("La pila esta llena");
        }
        array[count++] = value;
    }

    @Override
    public int getTop() {
        if (count == 0) {
            throw new RuntimeException("La pila esta llena");
        }
        return array[count - 1];
    }

    @Override
    public void remove() {
        if (count == 0) {
            throw new RuntimeException("La pila esta llena");
        }
        count--;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }
    public int size() {
        return count;
    }
}

