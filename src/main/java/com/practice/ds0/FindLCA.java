package com.practice.ds0;

import java.util.ArrayList;

public class FindLCA {
     static private boolean v1= false;
     static private boolean v2= false;
     static class Node {
         Node left;
         Node right;
         int data;

         Node(int data) {
             this.data = data;
         }
     }
     Node findLCAUtil(Node node, int n1, int n2)
     {
         Node temp = null;
         if(node == null )
             return null;
         if(n1== node.data)
         {
             v1=true;
             temp = node;
         }
         if(n2 == node.data) {
             v2 = true;
             temp = node;
         }

         Node left_lca= findLCAUtil(node.left,n1,n2);
         Node right_lca= findLCAUtil(node.right,n1,n2);
         //this check here after above recursive calls will help to find both the nodes and then take decision
         //else the findLCA() function will have only one of either v1 or v2 set and will return false always
         if(temp != null)
             return temp;

         if(left_lca != null && right_lca != null) {
             return node;
         }
         return (left_lca!=null?left_lca:right_lca);


     }
     int findLCA(Node node, int n1,int n2)
     {
         v1 = false;
         v2 = false;
         Node lca = findLCAUtil(node,n1,n2);
         if(v1 && v2) {
             System.out.println(lca.data);
             return lca.data;
         }
         else {
             System.out.println("LCA not find for two nodes given");
             return -1;
         }
     }
     ArrayList<Integer>list = new ArrayList<>();
    public void rootToLeafPaths(Node root)
    {
        if(root == null)
            return ;
        list.add(root.data);
        if(root.left == null && root.right == null)
        {
            System.out.println(list);
        }
        rootToLeafPaths(root.left);
        rootToLeafPaths(root.right);
        list.remove(list.size()-1);
    }
    public int findHgt(Node root)
    {
        if(root == null)
            return 0;
        int l = findHgt(root.left);
        int r= findHgt(root.right);
        if(Math.abs(l-r)>1 || l ==-1 || r== -1)
            return -1;
        return Math.max(l,r)+1;
    }
    public boolean isHgtBalanced(Node root)
    {
        int val=findHgt(root);
        if(val == -1)
            return false;
        else
            return true;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node (2);
        root.right = new Node (3);
        root.left.left = new Node (4);
        root.left.right = new Node (5);

        root.right.left = new Node (6);
        root.right.right = new Node (7);
        root.right.right.right = new Node (77);
        root.right.right.right.right = new Node (17);
        root.right.right.right.right.right = new Node (27);
        FindLCA findlca = new FindLCA();
        System.out.println("is Balanced? " + findlca.isHgtBalanced(root));
        //findlca.findLCA(root,1,7);
        findlca.rootToLeafPaths(root);
    }
}
