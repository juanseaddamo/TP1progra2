package Ejercicio6.parte1y3;

public class MainEJ6 {
    public static void main(String[] args) {
        DynamicStackLimitada stack = new DynamicStackLimitada(3);
        DynamicQueueCiclica queue = new DynamicQueueCiclica();

        try {
            System.out.println("Agregando 10 a la pila...");
            stack.add(10);
            System.out.println("Agregando 20 a la pila...");
            stack.add(20);
            System.out.println("Agregando 30 a la pila...");
            stack.add(30);

            // Intento agregar un elemento más
            System.out.println("Agregando 40 a la pila...");
            stack.add(40);
        } catch (RuntimeException e) {
            System.out.println("No se puedó agregar el ultimo elemento a la pila, la misma se encuentra llena.");
        }

        // Mostrar el contenido de la pila
        System.out.println("\nEstado final de la pila:");
        StringBuilder pilaContenido = new StringBuilder("Elementos de la pila: ");
        while (!stack.isEmpty()) {
            pilaContenido.append(stack.getTop());
            stack.remove();
            if (!stack.isEmpty()) {
                pilaContenido.append(", ");
            }
        }
        System.out.println(pilaContenido);

        System.out.println('\n');
        System.out.println("Cola Ciclica");

        System.out.println("Agregando elementos a la cola...");
        queue.add(1);
        queue.add(2);
        queue.add(3);

    // Mostrar el contenido de la cola
        System.out.println("\nEstado inicial de la cola:");
        queue.printQueue();

        System.out.println("\nPrimer elemento: " + queue.getFirst());

        System.out.println("\nQuitando un elemento...");
        queue.remove();
        queue.printQueue();

        System.out.println("\nAgregando un nuevo elemento a la cola...");
        queue.add(4);
        queue.printQueue();

        System.out.println("\nQuitando todos los elementos...");
        while (!queue.isEmpty()) {
        System.out.println("Removido: " + queue.getFirst());
        queue.remove();
    }

        System.out.println("\nEstado final de la cola:");
        queue.printQueue();
    }
}
