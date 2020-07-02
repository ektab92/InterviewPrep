package com.practice.ds0;
import java.util.*;

public class InorderTraversal {
    static private boolean v2= false;
    static Stack <Node > stk = new Stack<>();
    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }
    static class ST{
        int start = 0;
        ST(int start){
            this.start = start;
        }
    }
    public static Node constructTree(String in[],String pre[],Map<String,Integer> nodeIndexMap
            ,ST start,int lo,int hi)
    {
        if(lo>hi)
            return null;
        Node root = new Node(Integer.parseInt(pre[start.start++]));
        if(lo == hi)
            return root;
        int index = nodeIndexMap.get(root.data+"");
        System.out.println(start);
        root.left = constructTree(in,pre,nodeIndexMap,start,lo,index-1);
        root.right = constructTree(in,pre,nodeIndexMap,start,index+1,hi);
        return root;
    }

    static void inorderTraversal(Node node)
    {
            if(node == null)
                return;
            Node curr = node;
            while(curr != null || !stk.empty())
            {
                while(curr != null)
                {
                    stk.push(curr);
                    curr = curr.left;
                }
                curr = stk.pop();
                System.out.print(curr.data+ "--->");
                curr = curr.right;

            }
    }
    static void preorderTraversal(Node node)
    {
        if(node == null)
            return;
        Node curr = node;
        stk.push(curr);
        while(!stk.isEmpty())
        {
            while(curr != null)
            {
                System.out.print(curr.data+"--->");
                if(curr.right != null)
                    stk.push(curr.right);
                curr=curr.left;

            }
            if(!stk.isEmpty()) {
                curr = stk.pop();
            }
        }
    }
    public static void main(String[] args) {
       /* Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        //inorderTraversal(root);*/
//        Node sbTree = new Node(5);
//        sbTree.left = new Node(3);
//        sbTree.right = new Node(6);
//        sbTree.left.right = new Node(4);
//        Node root ;
//        root = new Node(10);
//        root.left = new Node(7);
//        root.right = new Node(15);
//        root.left.left = new Node(2);
//        root.left.right = new Node(8);
//        root.right.left = new Node(13);
//        root.right.right = new Node(30);
//        root.left.left.right = sbTree;
        //preorderTraversal(root);
        //[2, 1, 4, 3, 5]
        //[1, 2, 3, 4, 5]
        String [] in={"2","1","4","3","5"};
        String [] pre={"1","2","3","4","5"};

        Map<String,Integer> nodeIndexMap = new HashMap<>();
        for(int i=0; i< in.length;i++)
        {
            nodeIndexMap.put(in[i],i);
        }
         Node tst = constructTree(in,pre,nodeIndexMap,new ST(0),0,in.length-1);
    }
}
