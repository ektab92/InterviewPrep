package com.practice.ds0;
import java.util.*;
public  class ProducerConsumer {

    static class Producer implements Runnable{
        int capacity;
        Queue<Integer>q;
        Random random = new Random();
        Producer(int capacity,Queue<Integer>q)
        {
            this.capacity=capacity;
            this.q=q;
        }

        @Override
        public void run() {
            while(true)
            {
                synchronized (q)
                {
                        if(this.q.size()>=this.capacity)
                        {
                            try {
                                q.wait();
                            } catch (InterruptedException exception) {
                                exception.printStackTrace();
                            }
                        }
                        else
                        {
                            q.add(random.nextInt(100));
                            q.notify();
                        }
                }
            }
        }
    }
    static class Consumer implements Runnable{
        Queue<Integer>q;
        Consumer(Queue<Integer>q)
        {
            this.q=q;
        }
        @Override
        public void run() {
            while(true)
            {
                synchronized (q)
                {
                    if(q.size()<=0)
                    {
                        try {
                            q.wait();
                        } catch (InterruptedException exception) {
                            exception.printStackTrace();
                        }
                    }
                    else
                    {
                        q.remove();
                        q.notify();
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Queue<Integer>q = new LinkedList<>();
        Producer p = new Producer(10,q);
        Thread th1 = new Thread(p);
        Consumer c = new Consumer(q);
        Thread th2 = new Thread(c);
        th1.start();
        th2.start();
        th1.join();
        th2.join();
    }
}
