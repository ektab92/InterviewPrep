package com.practice.ds0;

public class BoundaryTraversal {

    public static void printLeftBoundaryTD(Node node)
    {
        if(node == null)
            return ;
        if(node.left != null || node.right != null)
            System.out.println(node.data);
        if(node.left != null)
            printLeftBoundaryTD(node.left);
        else
            printLeftBoundaryTD(node.right);
    }
    public static void  printRightBoundaryBU(Node node)
    {
       if(node == null)
           return ;
       if(node.right != null)
           printRightBoundaryBU(node.right);
       else
           printRightBoundaryBU(node.left);
       if(node.left != null || node.right != null)
           System.out.println(node.data);
    }
    public static void printLeafNodes(Node node)
    {
        if(node == null)
            return ;
        if(node.left == null && node.right == null)
            System.out.println(node.data);
        printLeafNodes(node.left);
        printLeafNodes(node.right);
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
        System.out.println("Top down Boundary teaversal from Left is:");
        printLeftBoundaryTD(root);
        System.out.println("======================");
        printLeafNodes(root);
        System.out.println("======================");
        printRightBoundaryBU(root);



    }
}
