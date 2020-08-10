package com.practice.ds.amazon.linkedList;

public class DeleteAllOccurenceOfNum {
    //1,2,3,4,2,2,5,2,6,2
    private ListNode deleteOccurenceOfNum(ListNode head,int num)
    {
        if(head == null) return head;
        while(head.data == num)
        {
            head = head.next;
        }
        ListNode curr = head;
        ListNode prev= null;
        while(curr != null)
        {
            if(curr.data == num)
            {
                if(curr.next != null)
                {
                    curr.data = curr.next.data;
                    curr.next=curr.next.next;
                }
                else
                {
                    prev.next=null;
                    curr = curr.next;
                }
            }
            else
            {
                prev=curr;
                curr = curr.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        DeleteAllOccurenceOfNum dltOccurence = new DeleteAllOccurenceOfNum();
        ListNode head = new ListNode(2);
        head.next = new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(2);
        ListNode newHead=dltOccurence.deleteOccurenceOfNum(head,2);
        while(newHead != null)
        {
            System.out.println(newHead.data+"->");
            newHead=newHead.next;
        }
    }
}
