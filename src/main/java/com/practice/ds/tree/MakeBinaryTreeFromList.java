package com.practice.ds.tree;

import com.practice.ds.ListNode;
import com.practice.ds.TreeNode;

import java.util.*;

public class MakeBinaryTreeFromList {
    Queue<TreeNode>q =new LinkedList<>();
    private TreeNode constructTree(ListNode curr)
    {
        if(curr == null ) return null;
        TreeNode head = new TreeNode(curr.data);
        q.add(head);
        while(curr != null && !q.isEmpty())
        {
            TreeNode root = q.remove();
            if(curr!= null && root != null && curr.next != null)
            {
                curr = curr.next;
                root.left = new TreeNode(curr.data);
                q.add(root.left);
                if(curr != null && root != null && curr.next != null)
                {
                    curr = curr.next;
                    root.right = new TreeNode(curr.data);
                    q.add(root.right);
                }
            }
        }
        return head;
    }
    private void printTree(TreeNode root)
    {
        if(root == null) return;
        printTree(root.left);
        System.out.println(root.data);
        printTree(root.right);
    }
    public static void main(String[] args) {
        MakeBinaryTreeFromList construct = new MakeBinaryTreeFromList();
        ListNode head = new ListNode(10);
        head.next = new ListNode(12);
        head.next.next = new ListNode(15);
        head.next.next.next = new ListNode(25);
        head.next.next.next.next = new ListNode(30);
        head.next.next.next.next.next = new ListNode(35);
        TreeNode root= construct.constructTree(head);
        construct.printTree(root);
    }
}
