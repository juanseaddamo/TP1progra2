package Ejercicio1;

public class Ejercicio1Utils {

    public static int calculateTrace(QueueOfStacks matrix) {
        // Complejidad computacional = O(N^2) --> Recorre la matriz de nxn
        int trace = 0;
        int columnIndex = 0;

        while (!matrix.isEmpty()) {
            ArrayOfStacks stack = matrix.getFirst();
            int value = 0;

            ArrayOfStacks tempStack = new ArrayOfStacks(10);
            for (int i = 0; i <= columnIndex && !stack.isEmpty(); i++) {
                value = stack.getTop();
                stack.remove();

                if (i < columnIndex) {
                    tempStack.add(value);
                }
            }

            while (!tempStack.isEmpty()) {
                stack.add(tempStack.getTop());
                tempStack.remove();
            }

            trace += value;
            columnIndex++;
            matrix.remove();
        }

        return trace;
    }

    public static QueueOfStacks transpose(QueueOfStacks matrix) {
        // Complejidad computacional = O(N^2) --> Recorre la matriz de nxn
        QueueOfStacks transposedMatrix = new QueueOfStacks();

        int numColumns = matrix.size();
        int numRows = matrix.getFirst().size();

        ArrayOfStacks[] rows = new ArrayOfStacks[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new ArrayOfStacks(numColumns);
        }

        while (!matrix.isEmpty()) {
            ArrayOfStacks column = matrix.getFirst();
            ArrayOfStacks temp = new ArrayOfStacks(column.size());
            int row = 0;

            while (!column.isEmpty()) {
                temp.add(column.getTop());
                column.remove();
            }

            while (!temp.isEmpty()) {
                rows[row].add(temp.getTop());
                temp.remove();
                row++;
            }

            matrix.remove();
        }

        for (ArrayOfStacks row : rows) {
            transposedMatrix.add(row);
        }

        return transposedMatrix;
    }
    public static QueueOfStacks addMatrices(QueueOfStacks m1, QueueOfStacks m2) {
        // Complejidad computacional = O(N^2) --> Recorre las dos matrices de nxn
        QueueOfStacks sumMatrix = new QueueOfStacks();

        while (!m1.isEmpty() && !m2.isEmpty()) {
            ArrayOfStacks stack1 = m1.getFirst();
            ArrayOfStacks stack2 = m2.getFirst();

            ArrayOfStacks sumStack = new ArrayOfStacks(stack1.size());

            while (!stack1.isEmpty() && !stack2.isEmpty()) {
                int sum = stack1.getTop() + stack2.getTop();
                sumStack.add(sum);

                stack1.remove();
                stack2.remove();
            }

            sumMatrix.add(sumStack);
            m1.remove();
            m2.remove();
        }

        return sumMatrix;
    }
}