package com.practice.ds.amazon.trees;

import com.practice.ds.TreeNode;

public class MaxDiffBtwnNodeAncestor {
    static int maxDiff = Integer.MIN_VALUE;
    private int findDiff(TreeNode root)
    {
        if(root == null) return Integer.MAX_VALUE;
        if(root.left == null && root.right == null)
            return root.data;
        int val = Math.min(findDiff(root.left),findDiff(root.right));
        maxDiff = Math.max(maxDiff,root.data-val);
        return Math.min(val, root.data);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(46);
        root.left = new TreeNode(20);
        root.right = new TreeNode(3);
        root.left.left =new TreeNode(4);
        root.left.right = new TreeNode(16);
        root.right.right = new TreeNode(3);
        MaxDiffBtwnNodeAncestor diffNodes = new MaxDiffBtwnNodeAncestor();
        diffNodes.findDiff(root);
        System.out.println(maxDiff);
    }
}
