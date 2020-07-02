package com.practice.ds0;

public class ConvertBinaryTreeToCircularDLL {

   static class DLLNode{
        DLLNode left;
        DLLNode right;
        int data;
        DLLNode(int data)
        {
            this.data = data;
        }
    }
    static public DLLNode convertTreetoCircularDLL(DLLNode node)
    {
        DLLNode n1 = null;
        DLLNode n2 = null;
        if(node.left == null && node.right == null)
        {
            node.left = node;
            node.right = node;
            return node;
        }
        if(node.left != null)
            n1 = convertTreetoCircularDLL(node.left);
        if(node.right != null)
            n2 = convertTreetoCircularDLL(node.right);
        DLLNode curr1 = n1;
        DLLNode curr2 = n2;
        if(curr1 != null && curr2 != null) {
            while (curr1.right != n1) {
                curr1 = curr1.right;
            }
            while (curr2.right != n2) {
                curr2 = curr2.right;
            }
            curr1.right = node;
            node.left = curr1;
            node.right = n2;
            n2.left = node;
            curr2.right = n1;
            n1.left = curr2;

            return n1;
        }
        else if (curr2 == null)
        {
            while (curr1.right != n1) {
                curr1 = curr1.right;
            }
            curr1.right = node;
            node.left = curr1;
            node.right = n1;
            n1.left = node;
            return n1;
        }
        else
        {
            while (curr2.right != n1) {
                curr2 = curr2.right;
            }
            node.right = n2;
            n2.left = node;
            curr2.right = node;
            node.left = curr2;
            return node;
        }
    }

    public static void main(String[] args) {
        DLLNode root = new DLLNode(10);
        root.left = new DLLNode(12);
        root.right = new DLLNode(15);
        root.left.left = new DLLNode(25);
        root.left.right = new DLLNode(30);
        root.right.left = new DLLNode(36);
        DLLNode newhead = convertTreetoCircularDLL(root);
        DLLNode curr = newhead;
        while (curr.right != newhead) {
            System.out.print("-->" + curr.data);
            curr = curr.right;
        }
        System.out.print("--->"+curr.data);


    }
}
