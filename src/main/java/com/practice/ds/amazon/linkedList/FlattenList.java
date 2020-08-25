package com.practice.ds.amazon.linkedList;

public class FlattenList {
    static class ListNode
    {
        int data;
        ListNode right;
        ListNode below;
        ListNode(int data)
        {
            this.data=data;
            this.right=null;
            this.below=null;
        }
    }
    private ListNode flatten(ListNode head)
    {
       if(head == null || head.right == null)
           return head;
       head.right = flatten(head.right);
       merge(head,head.right);
       return head;
    }
    private ListNode merge(ListNode head1, ListNode head2)
    {
        if(head1 == null )
            return head2;
        if(head2 == null)
            return head1;
        ListNode result=null;
        if(head1.data < head2.data)
        {
            result = head1;
            result.below = merge(head1.below,head2);
        }
        else
        {
            result = head2;
            result.below=merge(head1,head2.below);
        }
        result.right = null;
        return result;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.below = new ListNode(7);
        head.below.below = new ListNode(8);
        head.below.below.below = new ListNode(30);
        head.right= new ListNode(10);

        head.right.below = new ListNode(20);
        head.right.right= new ListNode(19);

        head.right.right.below = new ListNode(22);
        head.right.right.below.below = new ListNode(50);
        head.right.right.right= new ListNode(28);

        head.right.right.right.below= new ListNode(35);
        head.right.right.right.below.below= new ListNode(40);
        head.right.right.right.below.below.below= new ListNode(45);
        FlattenList flatList = new FlattenList();
        ListNode root = flatList.flatten(head);
        while(root != null)
        {
            System.out.println(root.data+"-->");
            root = root.below;
        }
    }
}
