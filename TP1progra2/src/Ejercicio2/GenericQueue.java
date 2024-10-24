package Ejercicio2;


public interface GenericQueue <T> {


    T getFirst();

    void remove();

    void add(T value);

    boolean isEmpty();

}
