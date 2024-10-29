package Ejercicio3;

import Ejercicio2.StaticGenericQueue;

import java.util.List;

public class Queueofqueue<T> {

    private StaticGenericQueue<StaticGenericQueue<T>> queueofqueue;


    public Queueofqueue(){
        this.queueofqueue = new StaticGenericQueue<StaticGenericQueue<T>>();
    }

    public StaticGenericQueue<StaticGenericQueue<T>> getQueueofqueue() {
        return queueofqueue;
    }

    public void setQueueofqueue(StaticGenericQueue<StaticGenericQueue<T>> queueofqueue) {
        this.queueofqueue = queueofqueue;
    }


    //Se da por hecho que recibe un parametro n y una lista de queuesofqueues
    public Queueofqueue<T> concatenate(Integer n, List<Queueofqueue<T>> queueofqueues){

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


}
