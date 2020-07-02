package com.practice.ds0;

import java.io.*;
import java.lang.reflect.Constructor;

public class Singleton implements Cloneable ,Serializable{
    int data;
    static volatile Singleton instance ;
    /*private Singleton(int data)
    {
        this.data = data;
    }*/
    private Singleton(){}
    public static Singleton getInstance(int data)
    {
        if(instance!= null)
            return instance;
        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton();
            }
        }
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    static void breakWithSerialization() throws IOException, ClassNotFoundException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("abc.ser"));
        Singleton s6 = Singleton.getInstance(56);
        System.out.println("S6 hashcode"+s6.hashCode());
        os.writeObject(s6);
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("abc.ser"));
        Singleton s7= (Singleton)is.readObject();
        System.out.println(s7.hashCode());
    }

    static void breakWithReflection()
    {
        Singleton s1 = Singleton.getInstance(12);
        System.out.println(s1.hashCode());
        Singleton s2 = null;
        try {
            Constructor c=Singleton.class.getDeclaredConstructor();
            c.setAccessible(true);
            s2 = (Singleton)c.newInstance();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(s2.hashCode());
    }
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Thread T1 = new Thread(new Runnable(){
            @Override
            public void run()
            {
                Singleton s = Singleton.getInstance(5);
                System.out.println(s.toString()+"  "+s.data);
            }
        });
        Thread T2 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                Singleton s1 = Singleton.getInstance(10);
                System.out.println(s1.toString()+"  "+s1.data);
            }
        });
        Thread T3 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                Singleton s1 = Singleton.getInstance(10);
                System.out.println(s1.toString()+"  "+s1.data);
            }
        });
        //T1.start();
       // T2.start();
        //T3.start();
        //breakWithReflection();
        /*Singleton s5=Singleton.getInstance(4);
        System.out.println(s5.hashCode());
        Singleton s6 = (Singleton) s5.clone();
        System.out.println(s6.hashCode());*/
        breakWithSerialization();
    }
}
