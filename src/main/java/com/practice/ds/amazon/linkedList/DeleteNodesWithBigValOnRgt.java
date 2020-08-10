package com.practice.ds.amazon.linkedList;

/*
1. Reverse the list.
2. Traverse the reversed list. Keep max till now.
    If next node is less than max, then delete the next node, otherwise max = next node.
3. Reverse the list again to retain the original order.
 */
public class DeleteNodesWithBigValOnRgt {
    private ListNode deleteNodes(ListNode head)
    {
       if(head == null) return null;
       head=reverseList(head);

       ListNode curr = head;
       while(curr !=null && curr.next!= null)
       {
           if(curr.data>curr.next.data)
           {
               curr.next = curr.next.next;
           }
           else
               curr = curr.next;
       }
       head = reverseList(head);
       return head;
    }

    private ListNode reverseList(ListNode head)
    {
        if(head == null) return null;
        ListNode next = null;
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null)
        {
            next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(15);
        head.next = new ListNode(22);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);
        DeleteNodesWithBigValOnRgt listOps = new DeleteNodesWithBigValOnRgt();
        ListNode newHead=listOps.deleteNodes(head);
        while(newHead!=null)
        {
            System.out.println(newHead.data);
            newHead=newHead.next;
        }
    }
}
