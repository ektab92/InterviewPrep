package com.practice.ds.amazon.trees;

import com.practice.ds.TreeNode;

public class LeafNodeToDLL {
    TreeNode head = null;
    TreeNode prev = null;
    private TreeNode convertLeavesToDLL(TreeNode root)
    {
        if(root == null ) return null;
        if(root.left == null && root.right == null)
        {
            if(head == null)
            {
                head=root;
                prev=root;
            }
            else
            {
                prev.right=root;
                root.left=prev;
                prev=root;
            }
            return null;
        }
      root.left=  convertLeavesToDLL(root.left);
      root.right=  convertLeavesToDLL(root.right);
      return root;
    }
    private void printInorder(TreeNode root)
    {
        if(root == null) return ;
        printInorder(root.left);
        System.out.println(root.data);
        printInorder(root.right);
    }
    private void printDLL(TreeNode root)
    {
        if(root == null) return;
        while(root != null) {
            System.out.println(root.data + "->");
            root=root.right;
        }
    }
    public static void main(String[] args)
    {
        LeafNodeToDLL treeOps = new LeafNodeToDLL();
        TreeNode root = new TreeNode(46);
        root.left = new TreeNode(20);
        root.right = new TreeNode(3);
        root.left.left =new TreeNode(4);
        root.left.right = new TreeNode(16);
        root.right.right = new TreeNode(3);
        root =treeOps.convertLeavesToDLL(root);
        treeOps.printInorder(root);
        treeOps.printDLL(treeOps.head);

    }
}
