package com.practice.samples;

import com.practice.ds.TreeNode;

public class TreeSamples {

    public static TreeNode TREE = null;

    static{
        // Construction of a BST
        TreeNode TREE = new TreeNode(10);
        TreeNode sbTree = new TreeNode(5);
        sbTree.left = new TreeNode(3);
        sbTree.right = new TreeNode(6);
        sbTree.left.right = new TreeNode(4);
        TREE.left = new TreeNode(7);
        TREE.right = new TreeNode(15);
        TREE.left.left = new TreeNode(2);
        TREE.left.right = new TreeNode(8);
        TREE.right.left = new TreeNode(13);
        TREE.right.right = new TreeNode(30);
        TREE.left.left.right = sbTree;

        //TODO : Other Sample trees

    }


}
