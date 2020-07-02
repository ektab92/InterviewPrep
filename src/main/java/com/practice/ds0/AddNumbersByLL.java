package com.practice.ds0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AddNumbersByLL {

     // Definition for singly-linked list.
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    static class Node{
        int data;
        Node next;
        Node(int data)
        {
            this.data= data;
        }
    }
    public static Node addNumbers(Node n1,Node n2 )
    {
        Node n3 =null;
        Node n3_head = n3;
        int carry=0;
        if(n1 == null)
            return n2;
        if(n2 == null)
            return n1;
        while(n1 != null && n2!= null)
        {
            int temp = n1.data+n2.data+carry;
            carry = temp/10;
            if(n3 == null)
            {
                n3 = new Node(temp%10);
                n3_head = n3;
            }
            else {
                n3.next = new Node(temp % 10);
                n3 = n3.next;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        while(n1 != null)
        {
            int temp = n1.data+carry;
            carry = temp/10;
            n3.next = new Node(temp%10);
            n3 = n3.next;
            n1 = n1.next;

        }

        while(n2 != null)
        {
            int temp = n2.data+carry;
            carry = temp/10;
            n3.next = new Node(temp %10);
            n3 = n3.next;
            n2= n2.next;
        }

        return n3_head;
    }
    public static ListNode partition(ListNode head, int x) {
        if(head == null)
            return null;
        ListNode curr = head;
        ListNode tail=head;
        while(tail.next != null)
        {
            tail = tail.next;
        }
        ListNode newTail = tail;
        ListNode prev = null;
        while(curr != tail)
        {
            if(curr.val >= x)
            {
                ListNode temp = curr;
                if(prev == null)
                {
                    prev = head = head.next;
                }
                prev.next = curr.next;
                curr = curr.next;
                newTail.next = temp;;
                newTail = temp;
                newTail.next = null;
            }
            else
            {
                prev = curr;
                curr = curr.next;
            }

        }
        return head;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(2);
        node1.next.next.next.next = new ListNode(5);
        node1.next.next.next.next.next = new ListNode(2);
        node1.next.next.next.next.next.next  = new ListNode(4);
        partition(node1,3);

        int[][] intervals = {{1,2},{2,6}};




    }
}

class Interval{
    int start;
    int end;
    Interval(int s,int e)
    {
        this.start = s;
        this.end = e;
    }
}
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <=1)
            return intervals;
        List<Interval> intervalList = new ArrayList<>();
        for(int i =0; i < intervals.length;i++)
        {
            Interval intervalObj = new Interval(intervals[i][0],intervals[i][1]);
            intervalList.add(intervalObj);
        }
        Collections.sort(intervalList, new Comparator<Interval>(){

            @Override
            public int compare(Interval o1, Interval o2) {
                return 0;
            }
        });
        System.out.println(intervalList);
        return null;
    }
}