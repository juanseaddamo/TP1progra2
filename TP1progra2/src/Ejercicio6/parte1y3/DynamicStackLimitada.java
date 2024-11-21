package Ejercicio6.parte1y3;



public class DynamicStackLimitada implements Stack {
    private Node first;
    private final int maxCapacity;
    private int size;


    public DynamicStackLimitada(int maxCapacity) {
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("La capacidad máxima debe ser mayor a 0");
        }
        this.maxCapacity = maxCapacity;
        this.size = 0;
    }

    @Override
    public int getTop() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacía");
        }
        return this.first.getValue();
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacía");
        }
        this.first = this.first.getNext();
        this.size--;
    }

    @Override
    public void add(int value) {
        if (this.size == this.maxCapacity) {
            throw new RuntimeException("La pila está llena");
        }
        this.first = new Node(value, this.first, null);
        this.size++;
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }


    public int getSize() {
        return this.size;
    }


    public int getMaxCapacity() {
        return this.maxCapacity;
    }
}
