package com.practice.ds.amazon.trees;

import com.practice.ds.TreeNode;

public class SumTree {
    boolean flag = true;

    //convert to sumTree
    private int convertToSumTree(TreeNode root)
    {
        if(root == null) return 0;
        int l = convertToSumTree(root.left);
        int r = convertToSumTree(root.right);
        int subtreeSum = l+r;
        int temp = root.data;
        root.data=subtreeSum;
        return subtreeSum+temp;
    }
    //to check if a tree is sumTree
    private boolean isSumTree(TreeNode root)
    {
        if(root == null) return true;
        sumTreeHelper(root);
        return flag;
    }
    private int sumTreeHelper(TreeNode root)
    {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.data;
        if(flag == false) return 0;
        int left = sumTreeHelper(root.left);
        int right = sumTreeHelper(root.right);
        if(root.data != left +right)
        {
            flag = false;
            return 0;
        }
        else
            return left+right+root.data;

    }
    private void printInorder(TreeNode root)
    {
        if(root == null) return;
        printInorder(root.left);
        System.out.println(root.data);
        printInorder(root.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(46);
        root.left = new TreeNode(20);
        root.right = new TreeNode(3);
        root.left.left =new TreeNode(4);
        root.left.right = new TreeNode(16);
        root.right.right = new TreeNode(3);
        SumTree treeOps = new SumTree();
        System.out.println(treeOps.isSumTree(root));
        treeOps.convertToSumTree(root);
        treeOps.printInorder(root);
    }
}
