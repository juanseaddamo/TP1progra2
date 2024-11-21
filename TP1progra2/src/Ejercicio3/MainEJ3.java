package Ejercicio3;

import Ejercicio2.StaticGenericQueue;

import java.util.ArrayList;
import java.util.List;

public class MainEJ3 {
    public static void main(String[] args) {
        Queueofqueue<Integer> q = new Queueofqueue<Integer>();
        Queueofqueue<Integer> q2 = new Queueofqueue<Integer>();
        StaticGenericQueue<Integer> cola = new StaticGenericQueue<Integer>();
        StaticGenericQueue<Integer> cola2 = new StaticGenericQueue<Integer>();
        cola.add(1);
        cola.add(2);
        cola.add(3);
        cola2.add(4);
        cola2.add(5);
        cola2.add(6);
        q.getQueueofqueue().add(cola);
        q2.getQueueofqueue().add(cola2);
        List<Queueofqueue<Integer>> lista = new ArrayList<Queueofqueue<Integer>>();
        lista.add(q);
        lista.add(q2);
        Queueofqueue<Integer> q3 = new Queueofqueue<Integer>();
        q3.concatenate(lista);
        q3.reverseWithDepth();

        while (!q3.getQueueofqueue().isEmpty()) {
            StaticGenericQueue<Integer> innerQueue = q3.getQueueofqueue().getFirst();
            while (!innerQueue.isEmpty()) {
                System.out.println(innerQueue.getFirst());
                innerQueue.remove();
            }
            q3.getQueueofqueue().remove();
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
