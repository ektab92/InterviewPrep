package com.practice.ds.amazon.linkedList;
import com.practice.ds.ListNode;
public class MergeKLinkedLists {
    private ListNode mergeTwoSortedLists(ListNode head1, ListNode head2)
    {
        if(head1 == null ) return head2;
        if(head2 == null ) return head1;
        ListNode result = null;
        if(head1.data< head2.data) {
            result = head1;
            result.next= mergeTwoSortedLists(head1.next,head2);
        }
        else {
            result = head2;
            result.next = mergeTwoSortedLists(head1,head2.next);
        }
        return result;
    }
    private ListNode mergeKLists( ListNode[] nodes)
    {
        int s= 0;
        int e= nodes.length-1;
        while(e!=0)
        {
            int i = s;
            int j = e;
            while(i<j)
            {
                nodes[i]=mergeTwoSortedLists(nodes[i],nodes[j]);
                i++;
                j--;
                if(i >= j)
                {
                    e = j;
                }
            }

        }
        return nodes[0];
    }
    public static void main(String[] args) {
        int k = 3; // Number of linked lists 
        int n = 4; // Number of elements in each list 

        // an array of pointers storing the head ListNodes 
        // of the linked lists 
        ListNode arr[] = new ListNode[k];

        arr[0] = new ListNode(1);
        arr[0].next = new ListNode(3);
        arr[0].next.next = new ListNode(5);
        arr[0].next.next.next = new ListNode(7);

        arr[1] = new ListNode(2);
        arr[1].next = new ListNode(4);
        arr[1].next.next = new ListNode(6);
        arr[1].next.next.next = new ListNode(8);

        arr[2] = new ListNode(0);
        arr[2].next = new ListNode(9);
        arr[2].next.next = new ListNode(10);
        arr[2].next.next.next = new ListNode(11);
        MergeKLinkedLists merge = new MergeKLinkedLists();
        ListNode head=merge.mergeKLists(arr);
        while(head != null)
        {
            System.out.println(head.data+"-->");
            head=head.next;
        }
    }
}
