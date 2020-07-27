package com.practice.ds;

public class OddEvenPriting {
    static int maxNum = 10;
    static int currNum = 1;
    static Object Lock = new Object();
    private static class Printer implements  Runnable{

        boolean isEven ;
        Printer(boolean isEven)
        {
            this.isEven=isEven;
        }
        @Override
        public void run() {
            while(currNum <= maxNum)
            {
                synchronized (Lock)
                {
                    if(this.isEven && currNum%2 == 0  )
                    {
                        System.out.println(String.format("Thread = %s , currNum = %d",Thread.currentThread().getName(),currNum));
                        currNum++;
                        Lock.notify();
                    }
                    else if( !this.isEven && currNum%2 == 0 )
                    {
                        try {
                            Lock.wait();
                        } catch (InterruptedException exception) {
                            exception.printStackTrace();
                        }
                    }
                    else if( !this.isEven &&currNum%2 != 0 )
                    {
                        System.out.println(String.format("Thread = %s , currNum = %d",Thread.currentThread().getName(),currNum));
                        currNum++;
                        Lock.notify();
                    }
                    else if( this.isEven && currNum%2 != 0 )
                    {
                        try {
                            Lock.wait();
                        } catch (InterruptedException exception) {
                            exception.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(new Printer(true),"evenPrinter");
        Thread t2 = new Thread(new Printer(false),"oddPrinter");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
