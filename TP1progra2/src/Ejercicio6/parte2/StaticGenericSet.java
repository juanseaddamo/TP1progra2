package Ejercicio6.parte2;

import Ejercicio2.GenericSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
            if(this.array[i].equals(a)){
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
            if(this.array[i].equals(a)){
                this.array[i] = this.array[this.count-1];
                this.count--;
                return;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    public int getCount() {
        return this.count;
    }

    // Method to retrieve elements
    private List<T> getElements() {
        List<T> elements = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            elements.add(array[i]);
        }
        return elements;
    }

    public boolean esSubconjunto(StaticGenericSet<T> conjunto) {
        List<T> elements = conjunto.getElements();
        Set<T> elementSet = new HashSet<>(elements);
        for (int i = 0; i < this.count; i++) {
            if (!elementSet.contains(this.array[i])) {
                return false;
            }
        }
        return true;
    }

        public GenericSet<T> complemento(StaticGenericSet<T> conjunto) {
        if (!esSubconjunto(conjunto)) {
            throw new IllegalArgumentException("El conjunto no es un subconjunto del superconjunto");
        }
        GenericSet<T> complemento = new StaticGenericSet<>();
        Set<T> elementSet = new HashSet<>(conjunto.getElements());
        for (int i = 0; i < this.count; i++) {
            if (!elementSet.contains(this.array[i])) {
                complemento.add(this.array[i]);
            }
        }
        return complemento;
    }
}
