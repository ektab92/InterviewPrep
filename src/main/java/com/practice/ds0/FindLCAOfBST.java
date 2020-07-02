package com.practice.ds0;

public class FindLCAOfBST {
    public static boolean searchElement(Node node, int data)
    {
        if(node == null)
            return false;
        if(node.data >data)
            return searchElement(node.left,data);
        if(node.data<data)
            return searchElement(node.right,data);
        else
            return true;

    }
    public static int findLCA(Node node, int n1,int n2)
    {
            if(node == null)
                return -1;
            if(node.data > n1 && node.data >n2)
                return findLCA(node.left,n1,n2);
            else if(node.data < n1 && node.data < n2)
               return findLCA(node.right,n1,n2);
            else
                return node.data;

    }
    public static int findLCAHelper(Node node,int n1, int n2)
    {
        if(searchElement(node,n1)&&searchElement(node,n2))
            return findLCA( node, n1,n2);
        else
            return -1;
    }
    public static boolean isBST(Node node,int min,int max)
    {
        if(node == null)
            return true;
        boolean l = isBST(node.left,min,node.data);
        boolean r = isBST(node.right,node.data,max);
        //this check should be after recursion, else, it will return if root will or any previous node satiesfies
        //bst property and wont check for remaining nodes
        if(l && r && node.data>min && node.data<max)
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(9);
        root.right = new Node(25);
        root.left.left = new Node(7);
        root.left.right = new Node(10);
        root.right.left = new Node(21);
        root.right.right = new Node(18);
        boolean isBST=isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        System.out.println("Tree is BST? "+isBST);
       // int lca =findLCAHelper(root,9,25);
       // System.out.println("LCA of two given nodes is : "+lca);

    }
}
