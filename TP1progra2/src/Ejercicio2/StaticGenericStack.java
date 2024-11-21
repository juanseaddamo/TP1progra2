package Ejercicio2;

public class StaticGenericStack<T> implements GenericStack<T>{

    //Atributo
    private final T[] array;
    private int count;
    private static final int MAX = 10000;


    //Constructor
    public StaticGenericStack() {
        this.array = (T[]) new Object[MAX];
        this.count = 0;
    }


    @Override
    public T getTop() {
        if(isEmpty()){
            throw new RuntimeException("La pila esta vacia, no se puede obtener el tope");
        }
        return array[this.count - 1];
    }

    @Override
    public void remove() {
        if(isEmpty()){
            throw new RuntimeException("La pila esta vacia, no se eliminar");
        }
        count --;

    }

    @Override
    public void add(T value) {
        if (this.count == MAX) {
            throw new RuntimeException("No hay mas espacio de memoria para la pila");
        }
        this.array[this.count] = value;
        this.count++;

    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    public int getCount() {
        return this.count;
    }

    public T[] getArray() {
        return this.array;
    }

}
