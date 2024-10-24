package Ejercicio2;

public class GenericStackUtil {



    public static <T> GenericStack<T> copy(GenericStack<T> stack) {
        GenericStack<T> copy = new StaticGenericStack<>();
        GenericStack<T> aux = new StaticGenericStack<>();

        // Copy elements from the original stack to temp without removing from the original stack
        while (!stack.isEmpty()) {
            T element = stack.getTop();
            aux.add(element);
            stack.remove();
        }

        // Restore the original stack and copy elements to aux
        while (!aux.isEmpty()) {
            T element = aux.getTop();
            stack.add(element);
            copy.add(element);
            aux.remove();
        }

        return copy;
    }

    public static <T> GenericStack <T> revert(GenericStack<T> stack) {
        GenericStack<T> copy = copy(stack);
        GenericStack<T> revert = new StaticGenericStack<>();

        // Restore the original stack and add elements to reverse in reverse order
        while (!copy.isEmpty()) {
            T element = copy.getTop();
            revert.add(element);
            copy.remove();
        }
        return revert;
    }

    public static <T> void print(GenericStack<T> stack) {
        GenericStack<T> copy = copy(stack);
        while (!copy.isEmpty()) {
            System.out.println(copy.getTop());
            copy.remove();
        }
    }



}
