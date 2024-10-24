package Ejercicio2;

import java.util.Random;

public class StaticGenericSet<T> implements GenericSet<T> {
    private static final int MAX = 10000;

    private final T[] array;
    private int count;
    private final Random random;

    public StaticGenericSet() {
        this.array = (T[]) new Object[MAX];
        this.count = 0;
        this.random = new Random();
    }

    @Override
    public void add(T a) {
        for(int i = 0; i < this.count; i++){
            if(this.array[i] == a){
                return;
            }
        }
        this.array[this.count] = a;
        this.count++;
    }

    @Override
    public T choose() {
        if(isEmpty()){
            throw new RuntimeException("no se puede elegir un elemento de un conjunto vacio");
        }
        int i = random.nextInt(count); //elige un numero aleatorio entre 0 y count-1
        return this.array[i];

    }

    @Override
    public void remove(T a) {
        for(int i = 0; i < this.count; i++){
            if(this.array[i] == a){
                this.array[i] = this.array[this.count-1];
                this.count--;
            }
        }

    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }


}
