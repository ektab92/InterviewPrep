package com.practice.ds0;

public class Gather012UsingLL {
    static  class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
        }
    }
    public static void printReverse(Node head)
    {
        if(head == null)
            return ;
        printReverse(head.next);
        System.out.println(head.data);
    }
    public static Node gather012(Node node)
    {
        Node head = node;
        Node tail = node;
        Node curr = node;
        Node prev = node;
        while(tail.next != null)
        {
            tail= tail.next;
        }
        Node tail_orig = tail;
        //the condition curr != tail will lead to infinite loop as..2 is geeting added at tail every time we find a 2.
        while(curr != tail_orig)
        {
            if(curr.data == 1)
            {
                prev=curr;
                curr = curr.next;
            }
            else if (curr.data == 0)
            {
                if(curr == head)
                {
                    prev= curr;
                    curr = curr.next;
                }
                else
                {
                    //insert 0 at head
                    Node newnode = new Node(0);
                    Node temp = head;
                    head = newnode;
                    newnode.next=temp;
                    //remove 0 from curr
                    Node temp1 = curr;
                    prev.next=curr.next;
                    curr = temp1.next;

                }

            }
            else if(curr.data == 2)
            {
                //insert at tail
                Node newnode = new Node(2);
                tail.next=newnode;
                tail = newnode;
                //remove 2 from curr
                Node temp1 = curr;
                prev.next=curr.next;
                curr = temp1.next;

            }
        }
        return head;
    }
    public static void main(String[] args) {
        Node node = new Node(0);
        node.next = new Node(0);
        node.next.next = new Node(1);
        node.next.next.next = new Node(0);
        node.next.next.next.next = new Node(2);
        node.next.next.next.next.next = new Node(2);
        node.next.next.next.next.next.next = new Node(2);
        node.next.next.next.next.next.next.next = new Node(0);
        node.next.next.next.next.next.next.next.next = new Node(1);
        printReverse(node);
        //Node head= gather012(node);

        /*while(head!= null)
        {
            System.out.println(head.data +"-->");
            head = head.next;
        }*/

    }
}
