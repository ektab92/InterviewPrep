package com.practice.ds;

public class SequenceNumberPrinter {
    static int maxNum = 9;
    static int currNum = 1;
    static int maxThreads = 3;
    static Object Lock = new Object();
    private static class  Printer implements  Runnable
    {

        @Override
        public void run()
        {
            while(true) {
                synchronized (Lock)
                {
                    if ((currNum%maxThreads)+1  == Integer.parseInt(Thread.currentThread().getName()))
                    {
                        System.out.println(String.format("Thread : %s, Value : %d", Thread.currentThread().getName(), currNum));
                        currNum++;
                        if (currNum == 10)
                            currNum = 1;
                        Lock.notifyAll();
                    }
                    else {
                        try
                        {
                            Lock.wait();
                        } catch (InterruptedException exception)
                        {
                            exception.printStackTrace();
                        }
                    }

                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        Thread t1 = new Thread (new Printer(),"1");
        Thread t2 = new Thread (new Printer(),"2");
        Thread t3 = new Thread (new Printer(),"3");
        t1.start();
        t2.start();
        t3.start();
    }
}
