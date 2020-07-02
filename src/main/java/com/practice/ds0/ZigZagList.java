package com.practice.ds0;

 class ListNode{
    int data;
    com.practice.ds.ListNode next;
    ListNode(int data)
    {
        this.data=data;
        this.next = null;
    }
}
public class ZigZagList {
     static com.practice.ds.ListNode curr,prev;
     public static com.practice.ds.ListNode printZigZag(com.practice.ds.ListNode head)
     {
         if(head == null||head.next == null)
             return head;
         curr = head;
         prev = null;
         int count =0;
         while(curr != null)
         {
             if(count %2 == 1)
             {
                 int temp = curr.data;
                 if(curr.next == null)
                 {
                     if(prev.data > curr.data) {
                         curr.data = prev.data;
                         prev.data = temp;
                     }
                 }
                 else
                 {
                     if(prev.data > curr.next.data)
                     {
                         if(curr.data < prev.data)
                         {
                             curr.data = prev.data;
                             prev.data = temp;
                         }
                     }
                     else
                     {
                         if(curr.next.data > curr.data)
                         {
                             curr.data = curr.next.data;
                             curr.next.data = temp;
                         }
                     }

                 }
             }
             prev = curr;
             curr= curr.next;
             count++;
         }
         return head;
     }

    public static void main(String[] args) {
         //11->15->20->5->10
        com.practice.ds.ListNode node = new com.practice.ds.ListNode(11);
        node.next =new com.practice.ds.ListNode(15);
        node.next.next =new com.practice.ds.ListNode(20);
        node.next.next.next =new com.practice.ds.ListNode(5);
        node.next.next.next.next =new com.practice.ds.ListNode(10);
        //node.next.next.next.next.next =new ListNode(2);
       // node.next.next.next.next.next.next =new ListNode(1);
        com.practice.ds.ListNode head =printZigZag(node);
        while(head!= null)
        {

            System.out.println(head.data+"-->");
            head = head.next;
        }
    }
}
