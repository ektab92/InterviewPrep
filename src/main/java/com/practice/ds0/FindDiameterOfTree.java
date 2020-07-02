package com.practice.ds0;

public class FindDiameterOfTree {

    public static int findHeight(Node node)
    {
        if(node == null)
            return 0;
        return Math.max(findHeight(node.left),findHeight(node.right))+1;

    }
    public static int findDiameter(Node node)
    {
        if(node == null)
            return 0;
        int lh = findHeight(node.left);
        int rh = findHeight(node.right);

        int ld = findDiameter(node.left);
        int rd = findDiameter(node.right);

        return Math.max(Math.max(rd,ld),lh+rh+1);
    }
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(9);
        root.right = new Node(25);
        root.left.left = new Node(7);
        root.left.right = new Node(10);
        root.right.left = new Node(21);
        root.right.right = new Node(28);
        int diameter =findDiameter(root);
        System.out.println("Diameter = "+diameter);
    }
}
