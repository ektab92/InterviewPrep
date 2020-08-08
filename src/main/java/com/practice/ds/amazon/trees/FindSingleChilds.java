package com.practice.ds.amazon.trees;

import com.practice.ds.TreeNode;

import java.util.*;

public class FindSingleChilds {
    static List<Integer>singleChilds = new ArrayList<>();
    private void findSingleChild(TreeNode root)
    {
        if(root == null) return ;
        if(root.left == null && root.right != null)
            singleChilds.add(root.right.data);
        else if(root.right == null && root.left != null)
            singleChilds.add(root.left.data);
        findSingleChild(root.left);
        findSingleChild(root.right);
    }
    public static void main(String[] args) {
        FindSingleChilds treeOps = new FindSingleChilds();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right =new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(6);
        treeOps.findSingleChild(root);
        System.out.println(singleChilds.toString());
    }
}
