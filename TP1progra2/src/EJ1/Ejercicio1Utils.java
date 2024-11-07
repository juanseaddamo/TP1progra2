package org.example.utils;

import org.example.adt.StaticStack;

import java.util.LinkedList;
import java.util.Queue;


public class Ejercicio1Utils {
    // 1. Calculamos la traza de la matriz --> Complejidad computacional O(n^2),
    //donde n es el número de columnas (o filas) en la matriz.
    public static int calculateTrace(Queue<StaticStack> matrix) {
        int trace = 0;
        int columnIndex = 0;

        // Iteramos sobre queue of stacks (las columnas de la matriz)
        for (StaticStack stack : matrix) {
            // Simulate extracting the columnIndex-th element from the stack
            StaticStack temp = new StaticStack(stack.size());
            int value = 0;

            // Removemos elementos hasta llegar el elemento diagonal (elemento por columna)
            for (int i = 0; i <= columnIndex && !stack.isEmpty(); i++) {
                value = stack.getTop();  // Obtenemos el elemento del tope
                stack.remove();          // Removemos el elemento del tope

                // Guardamos los elementos que no sean de la diagonal en una temporary stack
                if (i < columnIndex) {
                    temp.add(value);
                }
            }

            // volvemos a poner a los elementos en la stack original
            while (!temp.isEmpty()) {
                stack.add(temp.getTop());
                temp.remove();
            }

            // Agregamos el elemento diagonal a la suma de la traza
            trace += value;
            columnIndex++;
        }

        return trace;
    }

    // 2. Transponemos la matriz (Intercambiamos filas por columnas)
    // Complejidad computacional --> O(n) . n = O(n^2) --> O(n^2) + O(n^2) = O(n^2)
    public static Queue<StaticStack> transpose(Queue<StaticStack> matrix) {
        int numStacks = matrix.size();  // Numero de columnas en la matriz original
        int stackSize = matrix.element().size();  // Tamaño de cada stack (numero de filas)

        // Primero inicializamos la cola de colas para guardar los elementos fila por fila
        Queue<Queue<Integer>> rowQueue = new LinkedList<>();
        for (int i = 0; i < stackSize; i++) {
            rowQueue.add(new LinkedList<>());  // Cada queue interna representa una fila
        }

        // Segundo transferimos los elementos de cada pila (columna) a filas de colas
        for (StaticStack column : matrix) {
            StaticStack tempStack = new StaticStack(stackSize);

            // Revertimos el orden de la pila a una pila temporal para mantener el orden
            while (!column.isEmpty()) {
                tempStack.add(column.getTop());
                column.remove();
            }

            // Distribuimos los elementos revertidos a las filas correctas
            int row = 0;
            while (!tempStack.isEmpty()) {
                int value = tempStack.getTop();
                tempStack.remove();

                // Agregamos el elemento a la fila correcta
                getNthQueue(rowQueue, row).add(value);
                row++;
            }
        }

        // Tercero, convertimos las colas de filas devuelta a pilas para la transpuesta
        Queue<StaticStack> transposedMatrix = new LinkedList<>();
        for (Queue<Integer> row : rowQueue) {
            StaticStack newStack = new StaticStack(numStacks);
            while (!row.isEmpty()) {
                newStack.add(row.remove());
            }
            transposedMatrix.add(newStack);
        }

        return transposedMatrix;
    }

    // Una funcion para ayudar a encontrar el elemento de la cola en la que nos paramos
    private static Queue<Integer> getNthQueue(Queue<Queue<Integer>> queue, int n) {
        int index = 0;
        for (Queue<Integer> q : queue) {
            if (index == n) return q;
            index++;
        }
        throw new IllegalArgumentException("Index invalido: " + n);
    }

    // 3. Funcion que suma dos matrices y sus elementos
    // Complejidad computacional --> n filas x n columnas = O(n) . n = O(n^2)
    public static Queue<StaticStack> addMatrices(Queue<StaticStack> m1, Queue<StaticStack> m2) {
        Queue<StaticStack> sumMatrix = new LinkedList<>();

        // Crear una cola temporal para guardar la matriz original
        Queue<StaticStack> m1Copy = new LinkedList<>(m1);
        Queue<StaticStack> m2Copy = new LinkedList<>(m2);

        // Itero sobre las dos matrices y agrego sus pilas
        while (!m1Copy.isEmpty() && !m2Copy.isEmpty()) {
            StaticStack stack1 = m1Copy.remove(); // Tomo la primera pila
            StaticStack stack2 = m2Copy.remove(); // Tomo la primera pila

            // Crear una nueva pila para guardar la suma de la fila actual
            StaticStack sumStack = new StaticStack(stack1.size());

            // Pilas temporales para guardar los valores que querramos guardar
            StaticStack temp1 = new StaticStack(stack1.size());
            StaticStack temp2 = new StaticStack(stack2.size());

            // Agregamos los elementos de las dos pilas
            while (!stack1.isEmpty() && !stack2.isEmpty()) {
                // Guardamos los elementos del tope para sumarlos
                int value1 = stack1.getTop();
                int value2 = stack2.getTop();
                int sum = value1 + value2;
                sumStack.add(sum);

                // Guardamos los elementos temporalmente para volver a las pilas originales
                temp1.add(value1);
                temp2.add(value2);

                stack1.remove();
                stack2.remove();
            }

            // Volvemos a las pilas originales
            while (!temp1.isEmpty()) {
                stack1.add(temp1.getTop());
                temp1.remove();
            }
            while (!temp2.isEmpty()) {
                stack2.add(temp2.getTop());
                temp2.remove();
            }

            // Agregamos la suma de cada pila a la matriz
            sumMatrix.add(sumStack);
        }

        return sumMatrix;
    }

}
