package com.practice.mockrounds.day5;

import com.practice.ds.TreeNode;

public class FlattenTreetoLeftLL {
    private void flatten(TreeNode root)
    {
        if(root == null )
            return;
        flatten(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right=null;
        while(root.left!=null)
            root = root.left;
        root.left =temp;
        flatten(root.left);

    }
    public void inorderTraversal(TreeNode root)
    {
        if(root==null)
            return ;
        inorderTraversal(root.left);
        System.out.println(root.data);
        inorderTraversal(root.right);
    }
    public static void main(String[] args) {
        TreeNode TREE = new TreeNode(10);
        /*TreeNode sbTree = new TreeNode(5);
        sbTree.left = new TreeNode(3);
        sbTree.right = new TreeNode(6);
        sbTree.left.right = new TreeNode(4);*/
        TREE.left = new TreeNode(7);
        TREE.right = new TreeNode(5);
        TREE.left.left = new TreeNode(2);
        TREE.left.right = new TreeNode(8);
        TREE.right.left = new TreeNode(13);
        TREE.right.right = new TreeNode(30);
        //TREE.left.left.right = sbTree;
        FlattenTreetoLeftLL treePrblm = new FlattenTreetoLeftLL();
        treePrblm.flatten(TREE);
        treePrblm.inorderTraversal(TREE);

    }
}
