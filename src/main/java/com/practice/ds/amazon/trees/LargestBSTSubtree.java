package com.practice.ds.amazon.trees;

import com.practice.ds.TreeNode;

public class LargestBSTSubtree {
    class BSTDetails
    {
        boolean isBST = true;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int subTreeSize = 0;
    }
    private int findBSTSubtreeSize(TreeNode root)
    {
        if(root == null) return 0;

        BSTDetails details =findSize(root);
        System.out.println(details.subTreeSize);
        return details.subTreeSize;

    }
    private BSTDetails findSize(TreeNode root)
    {
        if(root == null) return new BSTDetails();
        BSTDetails leftDetails = findSize(root.left);
        BSTDetails rightDetails = findSize(root.right);
        BSTDetails details = new BSTDetails();
        if(!leftDetails.isBST || !rightDetails.isBST ||leftDetails.max> root.data || rightDetails.min<root.data)
        {
            details.isBST=false;
            details.subTreeSize=Math.max(leftDetails.subTreeSize, rightDetails.subTreeSize);
            return details;
        }
        details.isBST=true;
        details.subTreeSize=1+ leftDetails.subTreeSize+rightDetails.subTreeSize;
        details.min = root.left == null?root.data: leftDetails.min;
        details.max = root.right == null? root.data : rightDetails.max;
        return details;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(56);
        root.left = new TreeNode(20);
        root.right = new TreeNode(3);
        root.left.left =new TreeNode(4);
        root.left.right = new TreeNode(26);
        root.right.right = new TreeNode(3);
        LargestBSTSubtree bstSubtree = new LargestBSTSubtree();
        bstSubtree.findBSTSubtreeSize(root);
    }
}
