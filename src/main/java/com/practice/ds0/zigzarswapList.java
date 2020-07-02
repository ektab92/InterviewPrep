package com.practice.ds0;

import com.practice.ds.ListNode;

import java.util.Stack;

public class zigzarswapList {
    Stack<com.practice.ds.ListNode>stk = new Stack<>();
    private com.practice.ds.ListNode findmid(com.practice.ds.ListNode curr)
    {
        com.practice.ds.ListNode prev=null;
        com.practice.ds.ListNode slow_ptr=curr;
        com.practice.ds.ListNode fast_ptr=curr;
        while(fast_ptr!= null && fast_ptr.next!=null)
        {
            prev=slow_ptr;
            slow_ptr=slow_ptr.next;
            fast_ptr=fast_ptr.next.next;

        }
        prev.next = null;
        return slow_ptr;
    }
    public void zigZagConverstion(com.practice.ds.ListNode head)
    {
        if(head == null)
            return ;
        com.practice.ds.ListNode mid=findmid(head);
        while(mid != null)
        {
            stk.push(mid);
            mid=mid.next;
        }
        com.practice.ds.ListNode curr = head;
        com.practice.ds.ListNode prev=head;
        while(!stk.isEmpty() && curr!=null )
        {

                com.practice.ds.ListNode temp = curr.next;
                com.practice.ds.ListNode t = stk.pop();
                t.next = null;
                curr.next = t;
                curr.next.next = temp;
                prev=curr;
                curr = curr.next.next;


        }
        if(!stk.isEmpty()) {
            com.practice.ds.ListNode temp = stk.pop();
            temp.next = null;
            prev.next.next = temp;
        }
        while(head!= null)
        {
            System.out.println(head.data+"--->");
            head=head.next;
        }
       // System.out.println(stk.pop().data);
    }
    public static com.practice.ds.ListNode pairWiseSwap(com.practice.ds.ListNode head)
    {
        if(head== null)
            return null;
        com.practice.ds.ListNode newhead=head.next;
        com.practice.ds.ListNode remain=head.next.next;
        head.next.next = head;
        head.next = pairWiseSwap(remain);
        return newhead;
    }
    public static void main(String[] args) {
        com.practice.ds.ListNode head = new com.practice.ds.ListNode(1);
        head.next = new com.practice.ds.ListNode(2);
        head.next.next = new com.practice.ds.ListNode(3);
        head.next.next.next = new com.practice.ds.ListNode(4);
        head.next.next.next.next = new com.practice.ds.ListNode(5);
        head.next.next.next.next.next = new com.practice.ds.ListNode(6);
       // head.next.next.next.next.next.next = new ListNode(7);
        ListNode newhead=pairWiseSwap(head);
        while(newhead != null)
        {
            System.out.println(newhead.data);
            newhead=newhead.next;
        }
        //zigzarswapList l = new zigzarswapList();

        //l.zigZagConverstion(head);
    }
}
