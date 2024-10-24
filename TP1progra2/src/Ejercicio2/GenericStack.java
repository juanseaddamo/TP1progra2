package Ejercicio2;

public interface GenericStack<T> {


    T getTop();

    void remove();

    void add(T value);

    boolean isEmpty();

}
