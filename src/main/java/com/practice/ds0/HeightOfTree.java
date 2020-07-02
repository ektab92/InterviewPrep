package com.practice.ds0;

public class HeightOfTree {
    public static int findHeight(Node node)
    {
        int lh,rh;
        if(node == null)
            return 0;
        else
        {
            lh = findHeight(node.left);
            rh = findHeight(node.right);
            return Math.max(lh,rh)+1;

        }
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
        int h = findHeight(root);
        System.out.println(h);
    }
}
