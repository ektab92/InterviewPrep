package com.practice.ds0;
import java.util.*;
public class BinaryTreeByInorderPreOrder {
    static Map<Integer,Integer> nodeIndexMap = new HashMap<>();
    //variable to iterate over preorder index
    static int start =0;
    public static Node createTree(int [] pre, int [] in)
    {
        if(pre.length ==0 || in.length == 0)
            return null;
        //Map for faster search in inorder array
        for(int i =0; i < in.length;i++)
        {
            nodeIndexMap.put(in[i],i);
        }
        Node root = constructTree(pre,in,0,in.length-1);
        return root;
    }
    public static Node constructTree(int [] pre, int [] in , int lo, int hi)
    {
        if(lo>hi)
            return null;
        Node root = new Node(pre[start++]);
        //when u have a lonely node// final leaf node
        if(lo == hi)
            return root;
        int index = nodeIndexMap.get(root.data);
        root.left = constructTree(pre,in,lo,index-1);
        root.right= constructTree(pre,in,index+1,hi);
        return root;
    }
    public static void printTree(Node node)
    {
        if(node == null)
            return;
        printTree(node.left);
        System.out.print(node.data+"->");
        printTree(node.right);
    }
    public static void main(String[] args) {
        int pre[]={9,8,6,5,4,7,11,18,19,15};
        int in[]= {6,5,4,8,7,9,11,19,18,15};
        Node root =createTree(pre,in);
        printTree(root);
    }
}
