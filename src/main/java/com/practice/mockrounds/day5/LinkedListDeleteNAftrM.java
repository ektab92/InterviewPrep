package com.practice.mockrounds.day5;

import com.practice.ds.ListNode;
//1->2->3->4->5->6->7
//3 modes after 2nd node
//n = 3, m=2
//1->2->6->7
public class LinkedListDeleteNAftrM {
    private ListNode deleteNodes(ListNode head,int n,int m)
    {
        if(head == null)
            return null;
        int m_ctr=1;
        ListNode curr = head;
        while(m_ctr<m)
        {
            m_ctr++;
            curr=curr.next;
        }
        ListNode prev=curr;
        m_ctr=1;
        while(curr!=null && m_ctr<=n)
        {
            curr=curr.next;
            m_ctr++;
        }

        if(curr !=null)
            prev.next=curr.next;
        else
            prev.next=null;
        return head;
    }
    public static void main(String[] args) {
       ListNode head = new ListNode(1);
       head.next=new ListNode(2);
       head.next.next=new ListNode(3);
       head.next.next.next=new ListNode(4);
       head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(6);
       LinkedListDeleteNAftrM listOps = new LinkedListDeleteNAftrM();
       ListNode newh=listOps.deleteNodes(head,2,4);
       while(newh!=null)
       {
           System.out.println(newh.data);
           newh=newh.next;
       }
    }
}
