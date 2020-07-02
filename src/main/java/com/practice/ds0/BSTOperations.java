package com.practice.ds0;

public class BSTOperations {
    static boolean rootSet=false;

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
        }

    }
    static void insertToBST(Node node, int data)
    {
        if(node.data >data && node.left == null) {
            node.left = new Node(data);
            return;
        }
        if(node.data <data && node.right == null) {
            node.right = new Node(data);
            return;
        }
        if(node.data > data)
            insertToBST(node.left,data);
        else
            insertToBST(node.right,data);
    }
    static Node findInorderSuccesor(Node node)
    {
        if(node == null)
            return null;
        if(node.left == null){
            return node;
        }
        return findInorderSuccesor(node.left);

    }
    //Delete from BST
    static Node deleteFromBST(Node node, int data)
    {
       if(node == null)
           return null;
       if(node.data > data)
       {
           node.left = deleteFromBST(node.left,data);
       }
       else if(node.data < data)
       {
           node.right = deleteFromBST(node.right,data);
       }
       else
       {
           //in case of one child or no child
           if(node.left == null)
               return node.right;
           else if(node.right == null)
               return node.left;
           //in case of two childs
           Node succ=findInorderSuccesor(node.right);
           //copy the data of inorder successor at current node
           node.data = succ.data;
           //delete inorder successor from its original position and attach its desendants again
           node.right=deleteFromBST(node.right,succ.data);
       }
       return node;
    }
    static void displayTree(Node root)
    {
        if(root == null)
            return;
        displayTree(root.left);
        System.out.print("---"+root.data+"---");
        displayTree(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(9);
        root.right = new Node(25);
        root.left.left = new Node(7);
        root.left.right = new Node(10);
        root.right.left = new Node(21);
        root.right.right = new Node(28);
        //insertToBST(root,18);
        //Node newRoot = deleteFromBST(root,20);
        Node newRoot = deleteFromBST(root,25);
        displayTree(newRoot);
    }
}
