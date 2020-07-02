package com.practice.ds0;

public class isHgtBalanced {
    //O(n) solution
    public static int findHeight(Node node)
    {
        if(node == null)
            return 0;
        int lh = findHeight(node.left);
        int rh = findHeight(node.right);
        if(Math.abs(lh-rh)>1 || lh == -1 || rh == -1)
            return -1;
        else
            return(Math.max(lh,rh))+1;
    }
    public static boolean isHeightBalanced(Node node)
    {
        if(node == null)
            return true;
        return (findHeight(node)!= -1);
    }
    //O(n^2) solution
    /*public static int findHeight(Node node)
    {
        if(node == null)
            return 0;
        return(Math.max(findHeight(node.left),findHeight(node.right)))+1;
    }
    public static boolean isHeightBalanced(Node node)
    {
        if(node == null)
            return true;
        int lHgt = findHeight(node.left);
        int rHgt = findHeight(node.right);
        if(Math.abs(lHgt-rHgt)>1 && isHeightBalanced(node.left) && isHeightBalanced(node.right))
            return false;
        else
            return true;
    }*/


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(17);
        root.right.right.right.right = new Node(27);
        //boolean isBalanced = findHeight(root);
        //boolean isBalanced=isHeightBalanced(root);
       // System.out.println("Tree is balance? "+isBalanced);
    }
}
