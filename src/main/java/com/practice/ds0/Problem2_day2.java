package com.practice.ds0;

import com.practice.ds.ListNode;

public class Problem2_day2 {
    public com.practice.ds.ListNode reverseList(com.practice.ds.ListNode head)
    {
        if(head == null)
            return null;
        com.practice.ds.ListNode curr=head;
        com.practice.ds.ListNode prev=null;
        com.practice.ds.ListNode next=null;
        while(curr!=null)
        {
            next =curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public com.practice.ds.ListNode reverseRec(com.practice.ds.ListNode head)
    {
        //head.next is imp check to avoid null ptr exception
        if(head== null || head.next ==null)
            return head;
        //return curr which is new head
        com.practice.ds.ListNode curr=reverseRec(head.next);
        head.next.next=head;
        head.next=null;
        return curr;
    }
    public com.practice.ds.ListNode findIntersection(com.practice.ds.ListNode h1, com.practice.ds.ListNode h2)
    {
        if(h1 == null || h2 == null)
            return null;
        com.practice.ds.ListNode c1=h1;
        com.practice.ds.ListNode c2=h2;
        int l1=0,l2=0;
        while(c1!=null)
        {
            l1=l1+1;
            c1=c1.next;
        }
        while(c2!=null)
        {
            l2=l2+1;
            c2=c2.next;
        }
        int i=0;
        if(l1>l2)
        {
            //travserse till l2-l1 or diff of two lengths and then increase one by one
            while(i<l1-l2)
            {
                h1=h1.next;
                i++;
            }
            while(h2!=null ||h1 !=null)
            {
                if(h1.next == h2.next)
                {
                    return h1.next;
                }
                h1=h1.next;
                h2=h2.next;
            }
        }

        else{
            i=0;
            while(i<l2-l1)
            {
                h2=h2.next;
                i++;
            }
            while(h2!=null || h1!=null)
            {
                if(h1.next == h2.next)
                {
                    return h2.next;
                }
                h1=h1.next;
                h2=h2.next;
            }
        }
        return null;
    }
    public boolean findCycle(com.practice.ds.ListNode head)
    {
        com.practice.ds.ListNode fast_ptr=head,slow_ptr=head;
        while(fast_ptr !=null && fast_ptr.next !=null)
        {
            slow_ptr=slow_ptr.next;
            fast_ptr=fast_ptr.next.next;
            //always done after incrementing else will get true in first condition when both are intialised to head
            if(slow_ptr == fast_ptr )
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        com.practice.ds.ListNode head= new com.practice.ds.ListNode(1);
        head.next = new com.practice.ds.ListNode(2);
        head.next.next = new com.practice.ds.ListNode(3);
        head.next.next.next = new com.practice.ds.ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next =head.next;
        //ListNode head1= new ListNode(10);
        //head1.next = new ListNode(12);
        //head1.next.next = new ListNode(13);
        //head1.next.next = head.next.next;
      //  head1.next.next.next = new ListNode(4);
        Problem2_day2 p = new Problem2_day2();
        System.out.println("Cycle Exists? "+p.findCycle(head));
        /*ListNode newhead=p.findIntersection(head,head1);
        if(newhead!=null)
            System.out.println(newhead.data);
        else
            System.out.println("no intersection");
        /*ListNode newhead=p.reverseRec(head);*/
        /*while(newhead !=null)
        {
            System.out.println(newhead.data+"-->");
            newhead=newhead.next;
        }*/
    }
}
