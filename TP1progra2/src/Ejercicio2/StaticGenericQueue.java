package Ejercicio2;

public class StaticGenericQueue<T> implements GenericQueue<T>{

    //Atributo
    private final T[] array;
    private int count;
    private static final int MAX = 10000;

    //Constructor
    public StaticGenericQueue() {
        this.array = (T[]) new Object[MAX];
        this.count = 0;
    }


    @Override
    public T getFirst() {
        if(isEmpty()){
            throw new RuntimeException("La cola esta vacia");
        }
        //return array[this.count - 1]; (Se cambio debido a que en una cola se devuelve el primer item)
        return array[0];
    }

    @Override
    public void remove() {
        if(isEmpty()){
            throw new RuntimeException("La pila esta vacia, no se eliminar");
        }
        for( int i = 0; i < count; i++){
            this.array[i] = this.array[i+1];
        }
        count --;

    }

    @Override
    public void add(T value) {
        if (this.count == MAX) {
            throw new RuntimeException("No hay mas espacio de memoria para la pila");
        }
        this.array[this.count]=value;
        this.count++;

    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }
}
