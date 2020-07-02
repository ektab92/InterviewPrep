package com.practice.ds0;
import java.util.*;
class CountElementDLLNode{
    int val;
    int count;
    DLLNode next;
    DLLNode prev;
}
class CountElementNode implements  Comparable{
    int val;
    int count;
    CountElementNode(int val, int count)
    {
        this.val = val;
        this.count=count;
    }

    // to compare object only on the basis of value and not count
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountElementNode that = (CountElementNode) o;
        return val == that.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }

    @Override
    public int compareTo(Object o)
    {
        CountElementNode obj = (CountElementNode)o;
        if(this.count == obj.count)
            return 0;
        if(this.count > obj.count)
            return 1;
        else
            return -1;
    }
}
class Producer implements Runnable{
    Queue<Integer>Q;
    int QCapacity;
    Random randInt = new Random();
    int [] input = {1,2,3,4,5,4,6,4,7,4,9,9,9,7,2,9,5,1,6,7,6,7,9,5,6,7,3,1,2,3,1};
    int i =0;
    Producer(Queue<Integer> blockingQ,int capacity)
    {
        this.Q=blockingQ;
        this.QCapacity=capacity;
    }

    @Override
    public void run() {
        while(true)
        {
            synchronized (Q){
                if(Q.size()>=QCapacity) {
                    try {
                        System.out.println("Queue is full.Waiting for empty space....");
                        Q.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }

                }
                else
                {
                    int publishMessage=randInt.nextInt(10)+1;
                    /*if(i == input.length)
                        i=0;
                    int publishMessage = input[i++];*/
                    Q.add(publishMessage);
                    System.out.println("Published Message : "+publishMessage);
                    Q.notify();
                    try {
                        Thread.sleep(2000);
                    }catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}
class Consumer implements Runnable{
    Queue<Integer>Q;
    int QCapacity;

    //For mean
    double sum =0;
    int count =0;
    double mean =0.0;
    //For median
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //by default its mean priority queue.
    // To convert into max priority Queue ,we provide collections.reverseOrder()
    //for median
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    //for mode
    Map<Integer,CountElementNode> elementNodeMap = new HashMap<>();
    PriorityQueue<CountElementNode> maxHeapForMode = new PriorityQueue<>(Collections.reverseOrder());

    //for k max and kth max
    PriorityQueue<Integer> minHeapforKthMax = new PriorityQueue<>();

    //for kth min and k mins
    PriorityQueue<Integer> maxHeapForKMin = new PriorityQueue<>(Collections.reverseOrder());

    //for k non repeating elements
    DLLNode head = null;
    DLLNode tail = null;
    Map<Integer,DLLNode> dataNodeMap = new HashMap<>();
    Consumer(Queue<Integer> blockingQ,int capacity)
    {
        this.Q=blockingQ;
        this.QCapacity=capacity;
    }

    @Override
    public void run() {
        while(true)
        {
            synchronized (Q){
                if(Q.size()==0)
                {
                    try {
                        System.out.println("Queue is Empty.Waiting until there is any message published....");
                        Q.wait();
                    }catch(InterruptedException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
                else
                {

                    //adding data to min and max heaps
                    int consumedData = Q.remove();
                    System.out.println("Message Consumed : "+consumedData);

                    //for Mean calculation
                    forMeanCalculation(consumedData);

                    //for Median calculation
                    medianCalculation(consumedData);

                    //for Mode calculation
                    modeCalculation(consumedData);

                    //for kth max calculation
                    findKMax(consumedData,3);

                    //for kth min calculation
                    findKMin(consumedData,3);
                    Q.notify();

                    //for k non repeating elements
                    findKNonRepeatingElements(consumedData,3);
                    System.out.print("First k Non Repeating Elements : ");
                    int count =0;
                    DLLNode curr = head;
                    while(count <3 && curr != null)
                    {
                            System.out.print(curr.data+",");
                            curr = curr.next;
                            count++;
                    }
                    System.out.println();
                    try {
                        System.out.println("Consumer is processing consumed message");
                        Thread.sleep(2000);
                    }catch(InterruptedException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }

    private void findKNonRepeatingElements(int consumedData,int k)
    {
       if(!dataNodeMap.containsKey(consumedData))
       {
           DLLNode newNode = new DLLNode(consumedData);
           if(head == null) {
               head = tail=newNode;
           }
           else
           {
               tail.next = newNode;
               newNode.prev = tail;
               tail = newNode;
           }
           dataNodeMap.put(consumedData,newNode);
       }
       else
       {
            DLLNode repeatedEle = dataNodeMap.get(consumedData);

           if (repeatedEle == head && repeatedEle == tail)
            {
                head = tail = null;
            }
           else if (repeatedEle == head && repeatedEle != tail)
            {

                head = head.next;
                head.prev = null;
            }
           else if ( repeatedEle == tail && repeatedEle != head)
           {
               tail = tail.prev;
               tail.next = null;
           }
           else
           {
               repeatedEle.prev.next=repeatedEle.next;
               repeatedEle.next.prev= repeatedEle.prev;
           }
       }
    }
    private void findKMin(int consumedData,int k)
    {
        //discard element if it is greater than head of the heap
        if(maxHeapForKMin.size()<=k || maxHeapForKMin.peek()>=consumedData)
            maxHeapForKMin.add(consumedData);
        if(maxHeapForKMin.size()-k ==1)
            maxHeapForKMin.remove();
        System.out.println("Kth min : " +maxHeapForKMin.peek());
        System.out.println("K min elements : "+Arrays.toString(maxHeapForKMin.toArray()) );
    }
    private void findKMax(int consumedData,int k)
    {
        //discard any element which is lesser than the head of heap
        if(minHeapforKthMax.size()<=k || minHeapforKthMax.peek() <= consumedData)
        {
            minHeapforKthMax.add(consumedData);
        }
        if(minHeapforKthMax.size()-k==1)
            minHeapforKthMax.remove();
        System.out.println("Kth max : "+minHeapforKthMax.peek());
        System.out.println("K max elements : "+Arrays.toString(minHeapforKthMax.toArray()));
    }
    /**
     * O(log n) time complexity for each mode computation
     * n is number of unique elements at that time
     * @param consumedData
     */
    private void modeCalculation(int consumedData)
    {
        CountElementNode newNode =elementNodeMap.getOrDefault(consumedData,new CountElementNode(consumedData,0));
        maxHeapForMode.remove(newNode);
        newNode.count++;
        elementNodeMap.put(consumedData,newNode);
        maxHeapForMode.add(newNode);
        System.out.println("Current Mode : "+maxHeapForMode.peek().val);
    }
    private void medianCalculation(int consumedData) {
        if(maxHeap.isEmpty())
            maxHeap.add(consumedData);
        else if(maxHeap.peek() >= consumedData)
            maxHeap.add(consumedData);
        else minHeap.add(consumedData);

        //checking if heaps are balanced, balancing if not
        if (maxHeap.size()>minHeap.size() && maxHeap.size()-minHeap.size()>1) {
           minHeap.add(maxHeap.remove());
        }
        else if(minHeap.size()>maxHeap.size() && minHeap.size()-maxHeap.size()>1)
        {
            maxHeap.add(minHeap.remove());
        }

        //Finding Median as heaps are balanced
        double median =0.0;
        if(maxHeap.size() == minHeap.size())
            median =(double)(maxHeap.peek()+minHeap.peek())/2;
        else if(maxHeap.size()>minHeap.size())
            median =maxHeap.peek();
        else median=minHeap.peek();
        System.out.println("Median Value : "+median);
    }

    private void forMeanCalculation(int consumedData) {
        sum = sum+consumedData;
        count++;
        mean = sum/count;
        System.out.println("Mean till now : "+mean);
    }
    private void CalulateMedian(int no)
    {
        PriorityQueue<Integer>minHeap = new PriorityQueue<>();
        PriorityQueue<Integer>maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        if(maxHeap.size() == 0 || maxHeap.peek()>=no)
            maxHeap.add(no);
        else
            minHeap.add(no);
        if(maxHeap.size()>minHeap.size() && maxHeap.size()-minHeap.size()>1)
        {
            minHeap.add(maxHeap.remove());
        }
        else
        {
            maxHeap.add(minHeap.remove());
        }

    }
    public void printMedian()
    {
        //if size of both heaps are equal, peek() from maxheap, peek() fromm min heap, return average of both
        //else return root of heap who's size is maximum
    }
}
public class ProducerConsumerProblem {
    static Queue<Integer>blockingQ = new LinkedList<>();
    static int capacity =10;
    public static void main(String[] args) throws InterruptedException {
        Producer producer= new Producer(blockingQ,capacity);
        Consumer consumer= new Consumer(blockingQ,capacity);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
