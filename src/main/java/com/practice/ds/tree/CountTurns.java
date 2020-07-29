package com.practice.ds.tree;

import com.practice.ds.TreeNode;

public class CountTurns {
    static int n1Turns=0;
    static int n2Turns=0;
    TreeNode temp=null;
    public int findTurns(TreeNode root, TreeNode node1, TreeNode node2)
    {
        if(root == null) return 0;
        TreeNode lca=findLCA(root,node1,node2);
        countTurns(root.left,node1,node2,0,true);
        countTurns(root.right,node1,node2,0,false);
        if(lca.data == node1.data || lca.data == node2.data)
        {
            return 1+n1Turns+n2Turns;
        }
        else
        {
            return n1Turns+n2Turns;
        }
    }
    private TreeNode findLCA(TreeNode root , TreeNode n1,TreeNode n2)
    {
        if(root == null) return null;
        if(root == n1) temp = n1;
        if(root == n2) temp = n2;
        TreeNode left = findLCA(root.left,n1,n2);
        TreeNode right = findLCA(root.right,n1,n2);
        if(temp != null) return temp;
        if(left != null && right != null) return root;
        if(left != null)
            return left;
        else
            return right;
    }
    private void countTurns(TreeNode root, TreeNode n1,TreeNode n2,int count,boolean isLeft)
    {
        if(root == null) return ;
        if(root == n1)
        {
            n1Turns=count;
            return;
        }
        if(root == n2)
        {
            n2Turns=count;
            return;
        }
        if(isLeft)
        {
            countTurns(root.right, n1, n2, count+1,false);
            countTurns(root.left, n1, n2, count,true);
        }
        else
        {
            countTurns(root.right, n1, n2, count,false);
            countTurns(root.left, n1, n2, count+1,true);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        CountTurns treeOps = new CountTurns();
        int turns=treeOps.findTurns(root,root.left.right.right,root.right.right );
        System.out.println(turns);
    }
}
