package com.practice.ds.amazon.trees;

import com.practice.ds.TreeNode;

public class SumTreeRev {
    boolean flag = true;
    private int helper(TreeNode root)
    {
        if(root == null) return 0;
        if(root.right == null && root.left == null)
            return root.data;
        if(!flag) return 0;
        int lSum = helper(root.left);
        int rSum = helper(root.right);
        if(root.data != lSum+rSum)
        {
            flag = false;
            return 0;
        }
        return root.data+lSum+rSum;
    }
    private boolean isSumTree(TreeNode root)
    {
        if(root == null) return true;
        helper(root);
        return flag;
    }
    private void printInorder(TreeNode root)
    {
        if(root == null) return;
        printInorder(root.left);
        System.out.println(root.data);
        printInorder(root.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(56);
        root.left = new TreeNode(20);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(16);
        root.right.right = new TreeNode(3);
        SumTreeRev treeOps = new SumTreeRev();
        System.out.println(treeOps.isSumTree(root));

    }
}
