package Ejercicio2;

public interface GenericSet<T> {

    void add(T a);

    T choose();

    /**
     * a es el elemento a borrar, y si no exise en la estructura no hace nada
     */
    void remove(T a);

    boolean isEmpty();
}
