package Ejercicio6.parte1y3;

public class DynamicQueueCiclica  implements Queue {
    private Node first; // Nodo inicial (cabeza de la cola)
    private Node last;  // Nodo final (cola de la cola)

    @Override
    public int getFirst() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el primer elemento de una cola vacía");
        }
        return this.first.getValue();
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacía");
        }

        if (this.first == this.last) {
            // Caso especial: Solo hay un elemento
            this.first = null;
            this.last = null;
        } else {
            // Avanza el puntero `first` y ajusta los enlaces
            this.first = this.first.getNext();
            this.first.setPrev(this.last);
            this.last.setNext(this.first);
        }
    }

    @Override
    public void add(int value) {
        Node newNode = new Node(value, null, null);

        if (this.isEmpty()) {
            // Caso especial: Cola vacía
            this.first = newNode;
            this.last = newNode;
            this.first.setNext(this.first);
            this.first.setPrev(this.first);
        } else {
            // Agrega el nuevo nodo al final
            newNode.setPrev(this.last);
            newNode.setNext(this.first);

            this.last.setNext(newNode);
            this.first.setPrev(newNode);
            this.last = newNode;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    // Metodo adicional para imprimir la cola
    public void printQueue() {
        if (this.isEmpty()) {
            System.out.println("La cola está vacía.");
            return;
        }

        Node current = this.first;
        System.out.print("Elementos de la cola: ");
        do {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        } while (current != this.first);
        System.out.println();
    }
}
