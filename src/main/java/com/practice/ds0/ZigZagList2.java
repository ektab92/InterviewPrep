package com.practice.ds0;

import com.practice.ds.ListNode;

public class ZigZagList2 {
    public static com.practice.ds.ListNode doZigZag(com.practice.ds.ListNode head)
    {
        com.practice.ds.ListNode curr = head;
        /*int len=0;
        while(curr!=null)
        {
            len++;
            curr=curr.next;
        }
        int i=1;
        curr=head;

        //len+1 for handling hald calculation in odd and even cases
        while(i<(len+1)/2)
        {
            curr=curr.next;
            i++;
        }*/
        com.practice.ds.ListNode list2head =breakList(curr);
        //curr.next=null;
        list2head=reverseList(list2head);
        //curr=head;
        while(list2head!=null && curr!=null)
        {
            com.practice.ds.ListNode temp1=curr.next;
            com.practice.ds.ListNode temp2=list2head.next;
            curr.next=list2head;
            list2head.next=temp1;
            list2head=temp2;
            curr=temp1;
        }

       return head;
    }
    public static com.practice.ds.ListNode breakList(com.practice.ds.ListNode head)
    {
        com.practice.ds.ListNode slow= head;
        com.practice.ds.ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        com.practice.ds.ListNode temp = slow.next;
        //never do prev.next = null as, it creates complication.
        //sllow.next=null ensures...right list to be bigger always
        //do a dry run on odd and even length list and check
        slow.next = null;
        return temp;
    }
    public static com.practice.ds.ListNode reverseList(com.practice.ds.ListNode head)
    {
        com.practice.ds.ListNode prev=null;
        com.practice.ds.ListNode next = null;
        com.practice.ds.ListNode curr = head;
        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public static void main(String[] args) {
        com.practice.ds.ListNode node = new com.practice.ds.ListNode(11);
        node.next =new com.practice.ds.ListNode(15);
        node.next.next =new com.practice.ds.ListNode(20);
        node.next.next.next =new com.practice.ds.ListNode(5);
        node.next.next.next.next =new com.practice.ds.ListNode(10);
       // node.next.next.next.next.next =new ListNode(17);
        ListNode head=doZigZag(node);
        while(head!=null)
        {
            System.out.println(head.data);
            head=head.next;
        }

    }
}
