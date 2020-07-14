package com.practice.java;
import java.awt.*;
import java.util.*   ;


public class Multithreading
{
    static NumInfo numInfo=null;
    private static class NumInfo
    {
        int currNum=1;
    }
    private static class Printer implements Runnable{
        int maxNum;
        int thCount;
        Printer(int m,int th)
        {
            this.maxNum=m;
            this.thCount=th;
        }
        @Override
        public void run()
        {
            while(true) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                synchronized (numInfo) {
                    if (numInfo.currNum <= maxNum) {
                        int threadId = Integer.parseInt(Thread.currentThread().getName());
                        if ((numInfo.currNum % thCount) + 1 == threadId) {
                            System.out.println(String.format("Thread Id %d , number %d", threadId, numInfo.currNum));
                            numInfo.currNum += 1;
                            numInfo.notifyAll();
                        } else {
                            try {
                                numInfo.wait();
                            } catch (InterruptedException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    } else
                        numInfo.currNum = 1;
                }
            }
        }

    }
    public static void main(String[] args) throws InterruptedException {

        Printer printer = new Printer(10,3);
        numInfo = new NumInfo();
        Thread th1 = new Thread(printer,"1");
        Thread th2 = new Thread(printer,"2");
        Thread th3 = new Thread(printer,"3");
        th1.start();
        th2.start();
        th3.start();

        th1.join();
        th2.join();
        th3.join();
    }
}

