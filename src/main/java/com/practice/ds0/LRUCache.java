package com.practice.ds0;

import java.util.HashMap;
import java.util.Map;

class DLLNode {
    DLLNode prev,next;
    int data;
    DLLNode(int data)
    {
        this.data = data;
    }

}

public class LRUCache {
    private DLLNode head, tail;
    private Map<Integer,DLLNode> map = new HashMap<Integer,DLLNode>();
    private int capacity;
    private int size;
    public LRUCache(int capacity)
    {
        this.capacity = capacity;
        this.size =0;
    }
    public void put(int data)
    {
            int result=get(data);
            if(result == -1) {
                //if the cache is not full, insert data to tail and add entry to map, and increment the size
                DLLNode newnode = new DLLNode(data);
                map.put(data, newnode);
                if (tail == null) {
                    tail = newnode;
                    head = tail;
                    size++;
                    return;
                }
                if (size < capacity) {
                    tail.next = newnode;
                    newnode.prev = tail;
                    tail = newnode;
                    size++;
                } else {
                    //remove from head, make prev pointer to null to avoid dangling pointers in memory
                    DLLNode oldHead = head;
                    head = head.next;
                    head.prev = null;
                    //then insert at tail
                    tail.next = newnode;
                    newnode.prev = tail;
                    tail = newnode;
                    //remove the head element entry from map also
                    map.remove(oldHead.data);
                }
            }

    }
    public int get(int data)
    {

        if(map.containsKey(data))
        {
            DLLNode temp = map.get(data);
            // If element is head, but not tail example 1,2.... and LRU is 1
            if (temp == head && head != tail)
            {
                //remove the node from the head
                head = head.next;
                head.prev = null;
                //and then push it to the tail
                tail.next=temp;
                temp.prev= tail;
                tail = temp;
            }
            //if element is neither head or tail
            if(temp != tail && temp != head)
            {
                //remove the current occurence of node from DLL
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                //and then add it to the tail of DLL
                tail.next=temp;
                temp.prev= tail;
                tail = temp;
            }
            //If ele is head and tail, example 1,1,1.....
            //Do Nothing
            return temp.data;
        }
        else
            return -1;


    }
    private void printMap ()
    {
        System.out.println("=======================");

        for(int i :map.keySet())
        {
            System.out.println(i+ "::"+map.get(i));
        }
        System.out.println("=======================");

    }
    public static void main(String[] args) {
        //1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5
        LRUCache cache = new LRUCache(3);
        cache.put(1);
        cache.put(1);
        cache.printMap();
        cache.put(2);
        cache.put(3);
        cache.printMap();
        cache.put(4);
        cache.put(1);
        cache.printMap();
        cache.put(1);
        cache.put(2);
        cache.put(3);
        cache.put(4);
        cache.put(5);
        cache.printMap();
        System.out.println(cache.get(1));
        cache.put(1);
        System.out.println(cache.get(1));
        cache.put(2);
        System.out.println(cache.get(2));
        cache.printMap();
        cache.put(3);
        cache.put(4);
        cache.printMap();
        cache.put(5);
        cache.printMap();


    }
}
