package com.practice.ds0;

public class PrintKDistNodes {
    public static void printkDistNodes(Node node,int k,int distance)
    {
        if(node == null)
            return ;
        if(k == distance)
            System.out.println(node.data);
        printkDistNodes(node.left,k,distance+1);
        printkDistNodes(node.right,k,distance+1);

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
        printkDistNodes(root,3,0);
    }
}
