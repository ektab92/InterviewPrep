package com.practice.ds0;
import java.lang.*;
import java.util.Arrays;

public class MinHeapify {
    int arr[];
    int size;
    int pos;
    MinHeapify(int size)
    {
        this.size = size;
        this.arr = new int[size];
        this.pos =0;
    }
    public  void addToHeap(int data) throws IndexOutOfBoundsException
    {
        if(pos == size)
            throw  new  IndexOutOfBoundsException();
        arr[pos]=data;
        swim(arr,pos);
        pos++;
    }

    public int deleteFromHeap()
    {
      int data = arr[0];
      arr[0]= arr[pos-1];
      //arr[pos-1]=-1;
      pos--;
      sink(0);
      return data;
    }
    public void swim (int arr[],int index)
    {
        while(index > 0) {
            int parent = (index-1)/2;
            if (arr[index] < arr[parent]) {
                int temp = arr[parent];
                arr[parent] = arr[index];
                arr[index] = temp;
            }
            index = parent;
        }
    }
    public void sink(int index)
    {
        int swap;
        while(2*index+1< pos)
        {
            swap = 2*index+1;
            if(2*index+2 < pos && arr[2*index+2]< arr[2*index+1]) {
                swap = 2 * index + 2;
            }
            if(arr[swap ]<arr[index])
            {
                int temp = arr[swap];
                arr[swap]= arr[index];
                arr[index]= temp;
            }
            index =swap;
        }
    }
    public void heapSort(int a[])
    {
        //from last parent
        for(int i =(a.length/2)-1;i>=0;i--)
        {
//            int p =i;
//            while(2*p+1<a.length) {
//                int swap = 2*p+1;
//                if(swap+1< a.length && a[swap+1]>a[swap])
//                    swap = swap+1;
//                if(a[swap]>a[p])
//                {
//                    int temp = a[swap];
//                    a[swap]=a[p];
//                    a[p]=temp;
//                }
//                p = swap;
//
//            }
            swim(a,i);

        }
        System.out.println(Arrays.toString(a));
    }
    public static void main(String[] args) {
        int ar[]={1,3,5,4,6,13,10,9,8,15,17};
        MinHeapify heap = new MinHeapify(7);
        heap.addToHeap(10);
        heap.addToHeap(1);
        heap.addToHeap(3);
        heap.addToHeap(11);
        heap.addToHeap(4);
        heap.addToHeap(5);
        heap.addToHeap(2);
        heap.deleteFromHeap();
        heap.addToHeap(12);
        System.out.println(Arrays.toString(heap.arr));
        heap.heapSort(ar);

    }
}
