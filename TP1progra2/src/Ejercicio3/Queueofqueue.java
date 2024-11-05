package Ejercicio3;

import Ejercicio2.StaticGenericQueue;

import java.util.ArrayList;
import java.util.List;

public class Queueofqueue<T> {

    private StaticGenericQueue<StaticGenericQueue<T>> queueofqueue;

    public StaticGenericQueue queueflat;

    public StaticGenericQueue getQueueflat() {
        return queueflat;
    }

    public Queueofqueue(){
        this.queueofqueue = new StaticGenericQueue<StaticGenericQueue<T>>();
    }

    public StaticGenericQueue<StaticGenericQueue<T>> getQueueofqueue() {
        return queueofqueue;
    }

    public void setQueueofqueue(StaticGenericQueue<StaticGenericQueue<T>> queueofqueue) {
        this.queueofqueue = queueofqueue;
    }


    public Queueofqueue<T> concatenate(List<Queueofqueue<T>> queueofqueues){

        Queueofqueue<T> queueofqueuefinal = new Queueofqueue<T>();
        for(Queueofqueue<T> q : queueofqueues){
            StaticGenericQueue<StaticGenericQueue<T>> queues = q.getQueueofqueue();

            while (!queues.isEmpty()){
                StaticGenericQueue<T> cola = queues.getFirst();
                queueofqueuefinal.getQueueofqueue().add(cola);
                queues.remove();
            }
        }
        queueofqueue = queueofqueuefinal.getQueueofqueue();
        return queueofqueuefinal;
    }


    /*
    public StaticGenericQueue<T> flat(Queueofqueue<T> queueofqueue){
        StaticGenericQueue<T> queueFinal = new StaticGenericQueue<T>();

        StaticGenericQueue<StaticGenericQueue<T>> queueofqueue1 = queueofqueue.getQueueofqueue();

        while (!queueofqueue1.isEmpty()){
            StaticGenericQueue<T> cola = queueofqueue1.getFirst();
            while (!cola.isEmpty()){
                queueFinal.add(cola.getFirst());
                cola.remove();
            }
            queueofqueue1.remove();
        }
        return queueFinal;
    }*/

    public StaticGenericQueue<T> flat(Queueofqueue<T> queueofqueue) {
        StaticGenericQueue<T> queueFinal = new StaticGenericQueue<T>();

        // Obtenemos la cola de colas
        StaticGenericQueue<StaticGenericQueue<T>> queueofqueue1 = queueofqueue.getQueueofqueue();

        // Recorremos cada sub-cola en la cola de colas
        while (!queueofqueue1.isEmpty()) {
            StaticGenericQueue<T> cola = queueofqueue1.getFirst(); // Obtenemos la primera sub-cola

            // Agregamos todos los elementos de la sub-cola a la cola final
            while (!cola.isEmpty()) {
                queueFinal.add(cola.getFirst()); // Agregamos el primer elemento de la sub-cola a la cola final
                cola.remove(); // Eliminamos el primer elemento de la sub-cola
            }

            queueofqueue1.remove(); // Eliminamos la sub-cola procesada de la cola de colas
        }
        queueflat = queueFinal;
        return queueFinal;
    }

    public StaticGenericQueue<StaticGenericQueue<T>> reverseWithDepth() {
        StaticGenericQueue<StaticGenericQueue<T>> reversedQueueofQueue = new StaticGenericQueue<>();
        StaticGenericQueue<StaticGenericQueue<T>> originalQueueofQueue = queueofqueue;

        // Lista temporal para almacenar las sub-colas en orden invertido
        List<StaticGenericQueue<T>> tempQueueList = new ArrayList<>();

        // Paso 1: Invertir cada sub-cola y agregarla a la lista temporal
        while (!originalQueueofQueue.isEmpty()) {
            StaticGenericQueue<T> subQueue = originalQueueofQueue.getFirst();
            originalQueueofQueue.remove();

            // Invertir el contenido de la sub-cola usando una lista temporal
            List<T> tempSubQueueList = new ArrayList<>();
            while (!subQueue.isEmpty()) {
                tempSubQueueList.add(0, subQueue.getFirst()); // Insertamos en la posición 0 para invertir el orden
                subQueue.remove();
            }

            // Crear una nueva sub-cola invertida a partir de la lista temporal
            StaticGenericQueue<T> reversedSubQueue = new StaticGenericQueue<>();
            for (T element : tempSubQueueList) {
                reversedSubQueue.add(element);
            }

            // Agregar la sub-cola invertida a la lista de sub-colas
            tempQueueList.add(0, reversedSubQueue); // Insertamos en la posición 0 para invertir el orden de las sub-colas
        }

        // Paso 2: Convertir la lista de sub-colas invertidas en la cola final
        for (StaticGenericQueue<T> reversedSubQueue : tempQueueList) {
            reversedQueueofQueue.add(reversedSubQueue);
        }
        queueofqueue = reversedQueueofQueue;
        return reversedQueueofQueue;
    }



}
