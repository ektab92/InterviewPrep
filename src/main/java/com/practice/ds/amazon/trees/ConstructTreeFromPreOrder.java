package com.practice.ds.amazon.trees;

import com.practice.ds.TreeNode;

public class ConstructTreeFromPreOrder {
    int index=0;
    private TreeNode constructTree(int[]nodes,char [] leafInfo)
    {
        if(index == nodes.length) return null;
        TreeNode newNode = new TreeNode(nodes[index++]);
        if(leafInfo[index-1]== 'L') return newNode;
        newNode.left = constructTree(nodes,leafInfo);
        newNode.right= constructTree(nodes,leafInfo);
        return newNode;
    }
    private void printInorder(TreeNode root)
    {
        if(root == null) return ;
        printInorder(root.left);
        System.out.println(root.data);
        printInorder(root.right);
    }
    public static void main(String[] args) {
        int [] nodes = {10, 30, 20, 5, 15};
        char [] leafInfo = {'N','N','L','L','L'};
        ConstructTreeFromPreOrder treeOps = new ConstructTreeFromPreOrder();
        TreeNode root =treeOps.constructTree(nodes,leafInfo);
        treeOps.printInorder(root);
    }
}
