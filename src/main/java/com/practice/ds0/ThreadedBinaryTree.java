package com.practice.ds0;

public class ThreadedBinaryTree {
    static class Node {
        Node left;
        Node right;
        int data;
        boolean isThreaded = false;


        Node(int data) {
            this.data = data;
        }

    }
    public static Node CreateThreadedBinaryTee(Node node)
    {
        if(node == null)
            return null;
        if(node.left == null && node.right == null)
            return node;
        if(node.left != null)
        {
            Node l = CreateThreadedBinaryTee(node.left);
            l.right = node;
            l.isThreaded = true;
        }
        if(node.right == null)
            return node;
        else
            return CreateThreadedBinaryTee(node.right);

    }
    public static Node leftmost(Node node)
    {
        Node curr = node;
        if(node == null)
            return null;
       while(curr != null && curr.left != null )
       {
           curr = curr.left;
       }
       return curr;

    }
    public static void inOrderTraversl(Node node)
    {
        if (node == null)
            return ;
        Node curr = leftmost(node);
        while(curr != null)
        {
            System.out.println(curr.data+"--->");
            if(curr.isThreaded)
            {
                curr = curr.right;
            }
            else
                curr = leftmost(curr.right);
        }

    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(9);
        root.right = new Node(25);
        root.left.left = new Node(7);
        root.left.right = new Node(10);
        root.right.left = new Node(27);
        root.right.right = new Node(30);
        CreateThreadedBinaryTee(root);
        inOrderTraversl(root);
    }
}
