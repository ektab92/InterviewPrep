package com.practice.ds0;

public class printLeftView {
    static int max = Integer.MIN_VALUE;

    public static void printLeftView(Node node,int level)
    {
        if (node == null)
            return;
        if(level>max)
        {
            System.out.println(node.data);
            max = level;
        }
        printLeftView(node.left,level+1);
        printLeftView(node.right,level+1);
    }

    public static void main(String[] args) {


        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.right = new Node(14);
        root.left.left.right.left = new Node(24);
        root.left.left.right.right = new Node(38);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(17);
        root.right.right.right.left = new Node(57);
        root.right.right.right.left.right = new Node(67);
    }

}
