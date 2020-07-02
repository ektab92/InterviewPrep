package com.practice.ds0;
import java.util.*;
class Produce implements Runnable{
    Queue<Integer>Q;
    int capacity;
    Random randInt = new Random();
    Produce(Queue<Integer>PCQueue,int capacity)
    {
        this.Q=PCQueue;
        this.capacity=capacity;
    }

    @Override
    public void run() {
        while(true)
        {
            synchronized (Q) {
                if (Q.size() == capacity) {
                    System.out.println("Queue is full.Waiting for vacancy to produce...");
                    try {
                        Q.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    int data = randInt.nextInt();
                    Q.add(data);
                    System.out.println("Published Data int o the Queue : " + data);
                    Q.notify();
                }
            }
        }
    }
}
class Consume implements Runnable{
    Queue<Integer>Q;
    Consume(Queue<Integer>PCQueue)
    {
        this.Q=PCQueue;
    }
    @Override
    public void run()
    {
        while(true)
        {
            synchronized (Q) {
                if (Q.size() == 0) {
                    System.out.println("Consumer going to wait state.No data in Queue");
                    try {
                        Q.wait();
                    } catch (InterruptedException exception) {
                        exception.getMessage();
                    }
                } else {
                    int data = Q.remove();
                    System.out.println("Consumed from Queue Data : " + data);
                    Q.notify();
                }
            }
        }
    }
}
public class PCProblem {
    static Queue<Integer>blockingQ = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {
        Produce producer = new Produce(blockingQ,10);
        Consume consumer = new Consume(blockingQ);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
