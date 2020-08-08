package com.practice.ds.amazon.trees;

import com.practice.ds.TreeNode;

import java.util.*;

public class BinaryTreeToBST {
    List<Integer> inorderArr = new ArrayList<>();
    int index=0;
    /* approach is
        Do inorder traversal and make a list, sort that list
        Again do inorder traversal over the tree and whle trversal
        keep replacing the elements from the sorted list to the node
        finally return root and print inorder trversal
     */
    private TreeNode convertBinaryTreeToBST(TreeNode root)
    {
        if(root == null) return null;
        inorderTraversalAddToList(root);
        Collections.sort(inorderArr);
        inorderTraversalMakeBST(root);
        return root;
    }
    private void inorderTraversalMakeBST(TreeNode root)
    {
        if(root == null) return ;
        inorderTraversalMakeBST(root.left);
        root.data = inorderArr.get(index++);
        inorderTraversalMakeBST(root.right);
    }
    private void inorderTraversalAddToList(TreeNode root)
    {
        if(root == null) return;
        inorderTraversalAddToList(root.left);
        inorderArr.add(root.data);
        inorderTraversalAddToList(root.right);

    }
    private void printInorder(TreeNode root)
    {
        if(root == null) return ;
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
        BinaryTreeToBST bstOps = new BinaryTreeToBST();
        root =bstOps.convertBinaryTreeToBST(root);
        bstOps.printInorder(root);

    }
}
