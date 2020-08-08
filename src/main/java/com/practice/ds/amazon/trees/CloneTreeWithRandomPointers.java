package com.practice.ds.amazon.trees;

import com.practice.ds.TreeNode;

import java.util.HashMap;

//treeNod with random pointer
class TreeNodeWithRandomPointer{

    int data;
    TreeNodeWithRandomPointer left;
    TreeNodeWithRandomPointer right;
    TreeNodeWithRandomPointer randomPointer;
    TreeNodeWithRandomPointer(int data)
    {
        this.data = data;
    }
}
public class CloneTreeWithRandomPointers {

    //Map to store key(original TreeNode) = value(Its respective cloned treeNode)
    HashMap<TreeNodeWithRandomPointer,TreeNodeWithRandomPointer>originalTreeNewTreeMapping = new HashMap<>();

    //driver function
    private TreeNodeWithRandomPointer cloneTreeWithRandomPointers(TreeNodeWithRandomPointer root)
    {
        if(root == null) return null;
        //call clone tree
        TreeNodeWithRandomPointer clonedTreeRoot =cloneTree(root);
        //now populate randome pointers
        populateRndomPointer(root,clonedTreeRoot);
        return clonedTreeRoot;
    }
    /*
    function that clones the tree to new tree and populates hashmap
     */
    private TreeNodeWithRandomPointer cloneTree(TreeNodeWithRandomPointer root)
    {
        if(root == null) return null;
        TreeNodeWithRandomPointer newRoot = new TreeNodeWithRandomPointer(root.data);
        originalTreeNewTreeMapping.put(root,newRoot);
        newRoot.left=cloneTree(root.left);
        newRoot.right=cloneTree(root.right);
        return newRoot;
    }
    private void populateRndomPointer(TreeNodeWithRandomPointer root,TreeNodeWithRandomPointer clonedTreeRoot)
    {
        if(root == null) return ;
        if(root.randomPointer != null)
        {
            //cloneTreeNode random pointer = from hashmap get refernce of node which is random pointer of curr root
            clonedTreeRoot.randomPointer = originalTreeNewTreeMapping.get(root.randomPointer);
        }
        populateRndomPointer(root.left,clonedTreeRoot.left);
        populateRndomPointer(root.right,clonedTreeRoot.right);
    }

    private void printInorder(TreeNodeWithRandomPointer root)
    {
        if(root == null) return;
        printInorder(root.left);
        System.out.println("root.data : "+root.data);
        if(root.randomPointer != null)
            System.out.println("root.randomPointer : "+root.randomPointer.data);
        printInorder(root.right);
    }
    public static void main(String[] args) {
        TreeNodeWithRandomPointer root = new TreeNodeWithRandomPointer(1);

        root.left = new TreeNodeWithRandomPointer(2);
        root.right = new TreeNodeWithRandomPointer(3);
        root.left.left = new TreeNodeWithRandomPointer(4);
        root.left.right = new TreeNodeWithRandomPointer(5);
        root.randomPointer = root.left.right;
        root.left.left.randomPointer= root;
        root.left.right.randomPointer=root.right;
        CloneTreeWithRandomPointers cloneTree = new CloneTreeWithRandomPointers();
        TreeNodeWithRandomPointer newRoot=cloneTree.cloneTreeWithRandomPointers(root);
        cloneTree.printInorder(newRoot);

    }
}
