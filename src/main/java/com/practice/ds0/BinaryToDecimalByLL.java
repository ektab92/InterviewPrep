package com.practice.ds0;

public class BinaryToDecimalByLL {
     public static class Node{
        int val;
        Node next;
        Node(int data)
        {
            this.val = data;

        }
    }
    public int getDecimalValue(Node head) {

        if(head == null)
            return 0;
        int count =0;
        Node curr = head;
        int sum =0;
        while(curr.next != null)
        {
            count++;
            curr = curr.next;
        }
        while(head != null)
        {
            sum = sum+(head.val*(2^(count)));
            System.out.println((head.val*(2^(count))));
            System.out.println(sum);
            count--;
            head = head.next;
        }
        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        Node node = new Node(0);
        node.next = new Node(0);
        node.next.next = new Node(1);
        node.next.next.next = new Node(0);
    }
}
