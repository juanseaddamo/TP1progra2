package Ejercicio4;

import Ejercicio2.StaticGenericQueue;
import Ejercicio2.StaticGenericStack;

public class BuilderStack<T> {
    private final StaticGenericStack<T> stack;

    public BuilderStack() {
        this.stack = new StaticGenericStack<>();
    }

    public BuilderStack<T> add(T value) {
        stack.add(value);
        return this;
    }

    public BuilderStack<T> addAll(StaticGenericStack<T> otherStack) {
        for (int i = 0; i < otherStack.getCount(); i++) {
            stack.add(otherStack.getArray()[i]);
        }
        return this;
    }

    public BuilderStack<T> addAll(StaticGenericQueue<T> queue) {
        while (!queue.isEmpty()) {
            stack.add(queue.getFirst());
            queue.remove();
        }
        return this;
    }

    public StaticGenericStack<T> build() {
        return stack;
    }


}
