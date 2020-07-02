package com.practice.ds0;

public class SortedArrToBST {

    public static Node convertArrToBST(int arr[])
    {
        if(arr.length == 0)
            return null;
        Node head = convertArrToBSTHelper(arr,0,arr.length-1);
        return head;
    }
    public static Node convertArrToBSTHelper(int arr[],int lo,int hi)
    {
        if(hi<lo)
            return null;
        if(lo == hi)
            return new Node(arr[lo]);
        int mid = lo+(hi-lo)/2;
        Node root = new Node(arr[mid]);
        root.left = convertArrToBSTHelper(arr,lo,mid-1);
        root.right = convertArrToBSTHelper(arr,mid+1,hi);
        return root;
    }
    public static void inOrderTraversal(Node node)
    {
        if(node == null)
            return;
        inOrderTraversal(node.left);
        System.out.print(node.data + " --> ");
        inOrderTraversal(node.right);
    }
    public static void main(String[] args) {
        int arr[]={-10,-3,0,5,9};
        Node root =convertArrToBST(arr);
        inOrderTraversal(root);
    }
}
