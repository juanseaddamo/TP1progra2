package Ejercicio4;

import Ejercicio2.StaticGenericQueue;
import Ejercicio2.StaticGenericSet;

public class BuilderSet<T> {
    private final StaticGenericSet<T> set;

    public BuilderSet() {
        this.set = new StaticGenericSet<>();
    }

    public BuilderSet<T> add(T value) {
        set.add(value);
        return this;
    }

    /*public BuilderSet<T> addAll(StaticGenericSet<T> otherSet) {
        for (int i = 0; i < otherSet.count; i++) {
            set.add(otherSet.getArray()[i]);
        }
        return this;
    }*/

    public BuilderSet<T> addAll(StaticGenericSet<T> otherSet) {
        for (T element : otherSet.getElements()) {
            set.add(element);
        }
        return this;
    }
    public BuilderSet<T> addAll(StaticGenericQueue<T> queue) {
        while (!queue.isEmpty()) {
            set.add(queue.getFirst());
            queue.remove();
        }
        return this;
    }

    public StaticGenericSet<T> build() {
        return set;
    }


}

