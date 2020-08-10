package com.practice.ds.amazon.linkedList;


import com.practice.ds.amazon.linkedList.ListNode;

public class DeleteNNodesAfterMNodes {
    //1->2->3->4->5->6->7->8->9->10
    private ListNode deleteNodes(int M,int N,ListNode head)
    {
        ListNode curr = head;
        while(curr != null) 
        {
            for (int i = 1; i < M; i++) {
                if(curr == null) break;
                curr = curr.next;
            }
            if(curr != null) {
                ListNode skipPointer = curr.next;
                for (int i = 1; i <= N; i++) {
                    if (skipPointer == null) break;
                    skipPointer = skipPointer.next;
                }
                curr.next = skipPointer;
                curr=skipPointer;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        //head.next.next.next.next.next.next.next.next.next = new ListNode(10);
        DeleteNNodesAfterMNodes deleteInList = new DeleteNNodesAfterMNodes();
        ListNode curr =deleteInList.deleteNodes(1, 10, head);
        while(curr !=null) {
            System.out.println(curr.data + "->");
            curr = curr.next;
        }

    }
}
