package Ejercicio2;

public interface GenericPriorityQueue<T> {

    T getFirst();

    int getPriority();

    void remove();

    void add(T value,int priority);

    boolean isEmpty();
}
