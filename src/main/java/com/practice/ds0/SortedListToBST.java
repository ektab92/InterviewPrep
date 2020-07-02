package com.practice.ds0;

public class SortedListToBST {

     // Definition for singly-linked list.
     public static class ListNode {
         int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
      // Definition for a binary tree node.
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
    public static ListNode findMid(ListNode head)
    {
        ListNode slow_ptr = head;
        ListNode fast_ptr = head;
        ListNode prev = null;
        while(  fast_ptr != null && fast_ptr.next != null )
        {
            prev = slow_ptr;
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
        }

        prev.next = null;
        return slow_ptr;
    }
    public static TreeNode ListToBSTHelper(ListNode head)
    {
        if(head == null)
            return null;
        if(head.next == null)
            return new TreeNode(head.val);

        ListNode mid = findMid( head);
        TreeNode root = new TreeNode(mid.val);
        root.left = ListToBSTHelper(head);
        root.right = ListToBSTHelper(mid.next);
        return root;

    }
    public static TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        TreeNode root = ListToBSTHelper(head);
        return root;
    }
    public static void inOrderTraversal(TreeNode node)
    {
        if(node == null)
            return;
        inOrderTraversal(node.left);
        System.out.print(node.val + " --> ");
        inOrderTraversal(node.right);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);
        TreeNode root = sortedListToBST(head);
        inOrderTraversal(root);
    }
}
