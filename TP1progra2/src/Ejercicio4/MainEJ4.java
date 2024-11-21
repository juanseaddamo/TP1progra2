package Ejercicio4;

import Ejercicio2.StaticGenericQueue;
import Ejercicio2.StaticGenericSet;
import Ejercicio2.StaticGenericStack;
import Ejercicio3.Queueofqueue;
import sun.applet.Main;

import java.util.ArrayList;
import java.util.List;

public class MainEJ4 {
    public static void main(String[] args) {
        Queueofqueue<Integer> q = new Queueofqueue<Integer>();
        Queueofqueue<Integer> q2 = new Queueofqueue<Integer>();



        StaticGenericQueue<Integer> cola = new StaticGenericQueue<Integer>();
        StaticGenericQueue<Integer> cola2 = new StaticGenericQueue<Integer>();

        // Usando el constructor con parÃ¡metros variables
        StaticGenericQueue<Integer> cola3 = new StaticGenericQueue<>(15, 17, 2);
        StaticGenericQueue<Integer> cola4 = new StaticGenericQueue<>(9, 40, 10);

        cola.add(1);
        cola.add(2);
        cola.add(3);
        cola2.add(4);
        cola2.add(5);
        cola2.add(6);

        System.out.println("Cola de parÃ¡metros variables (1):");
        while (!cola3.isEmpty()) {
            System.out.print(cola3.getFirst() + " ");
            cola3.remove();
        }
        System.out.println();


        System.out.println("Cola de parÃ¡metros variables (2):");
        while (!cola4.isEmpty()) {
            System.out.print(cola4.getFirst() + " ");
            cola4.remove();
        }
        System.out.println();



        q.getQueueofqueue().add(cola);
        q2.getQueueofqueue().add(cola2);


        List<Queueofqueue<Integer>> lista = new ArrayList<Queueofqueue<Integer>>();
        lista.add(q);
        lista.add(q2);


        Queueofqueue<Integer> qFinal = new Queueofqueue<Integer>();
        qFinal.concatenate(lista);

        qFinal.reverseWithDepth();
/*
        while (!qFinal.getQueueofqueue().isEmpty()) {
            StaticGenericQueue<Integer> innerQueue = qFinal.getQueueofqueue().getFirst();
            while (!innerQueue.isEmpty()) {
                System.out.println(innerQueue.getFirst());
                innerQueue.remove();
            }
            qFinal.getQueueofqueue().remove();
        }*/


        System.out.println("Cola en Reversa:");
        while (!qFinal.getQueueofqueue().isEmpty()) {
            StaticGenericQueue<Integer> innerQueue = qFinal.getQueueofqueue().getFirst();
            while (!innerQueue.isEmpty()) {
                System.out.println(innerQueue.getFirst());
                innerQueue.remove();
            }
            qFinal.getQueueofqueue().remove();
        }

        StaticGenericSet<Integer> set = new BuilderSet<Integer>()
                .add(1)
                .add(2)
                .add(3)
                .build();

        System.out.println("Elementos en el set:");
        for (Integer element : set.getElements()) {
            System.out.println(element);

        }


        /*System.out.println("Elementos en el set:");
        for (int i = 0; i < set.getCount(); i++) {
            Integer element = (Integer) set.getArray()[i];
            System.out.println(element);
        }*/

        StaticGenericStack<Integer> stack = new BuilderStack<Integer>()
                .add(10)
                .add(20)
                .addAll(cola)
                .build();

        System.out.println("Elementos en la pila:");
        while (!stack.isEmpty()) {
            System.out.println(stack.getTop());
            stack.remove();
        }

        /*
        Queueofqueue<Integer> qflat = new Queueofqueue<Integer>();
        qflat.flat(q3);

        System.out.print("Cola aplanada: ");
        while (!qflat.getQueueflat().isEmpty()) {
            System.out.print(qflat.getQueueflat().getFirst() + " ");
            qflat.getQueueflat().remove();
        }*/


    }
}
