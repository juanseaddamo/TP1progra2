package Ejercicio5.ComplejidadComp;

import Ejercicio1.StaticStack;

public class Ejercicio5AUtils {

    public static StaticStack removeDuplicatesAndSort(StaticStack stack) {
        // Complejidad computacional = O(N^2) --> Dado que los ciclos que recorren la pila de n
        // elementos únicos y realizan las verificaciones de duplicados (metodo contains) y
        // el ordenamiento son los más costosos (O(N^2)), la complejidad total del algoritmo es O(N^2).

        StaticStack uniqueSortedStack = new StaticStack(stack.size());
        StaticStack tempStack = new StaticStack(stack.size());

        while (!stack.isEmpty()) {
            int current = getTopAndRemove(stack);

            if (!contains(uniqueSortedStack, current)) {

                while (!uniqueSortedStack.isEmpty() && uniqueSortedStack.getTop() > current) {
                    addToStack(tempStack, getTopAndRemove(uniqueSortedStack));
                }
                addToStack(uniqueSortedStack, current);
                while (!tempStack.isEmpty()) {
                    addToStack(uniqueSortedStack, getTopAndRemove(tempStack));
                }
            }
        }

        while (!uniqueSortedStack.isEmpty()) {
            addToStack(tempStack, getTopAndRemove(uniqueSortedStack));
        }
        while (!tempStack.isEmpty()) {
            addToStack(stack, getTopAndRemove(tempStack));
        }

        return stack;
    }

    private static int getTopAndRemove(StaticStack stack) {
        int top = stack.getTop();
        stack.remove();
        return top;
    }

    private static boolean contains(StaticStack stack, int value) {
        // Complejidad computacional = O(N^2) --> ciclo que se repite n veces en cada iteracion del ciclo principal
        StaticStack tempStack = new StaticStack(stack.size());
        boolean found = false;

        while (!stack.isEmpty()) {
            int current = getTopAndRemove(stack);
            if (current == value) {
                found = true;
            }
            addToStack(tempStack, current);
        }

        while (!tempStack.isEmpty()) {
            addToStack(stack, getTopAndRemove(tempStack));
        }

        return found;
    }

    private static void addToStack(StaticStack stack, int value) {
        stack.add(value);
    }

}

