package com.practice.ds.linkedLists;

import com.practice.ds.ListNode;
import com.practice.ds.TreeNode;
import com.practice.samples.TreeSamples;

public class BSTToDLL {
    TreeNode prev=null;
    TreeNode newhead = null;
    public TreeNode convertBSTTODLL(TreeNode root)
    {
        if(root == null)
            return root;
        convertBSTTODLL(root.left);
        if(newhead == null)
        {
            newhead = root;
            prev=newhead;
        }
        else
        {
            root.left = prev;
            prev.right=root;
            prev=root;
        }
        convertBSTTODLL(root.right);
        return root;
    }
    public void printDLL()
    {
        while(newhead != null)
        {
            System.out.print(newhead.data+"->");
            newhead=newhead.right;
        }
    }
    public static void main(String[] args) {
        BSTToDLL bstops = new BSTToDLL();
        bstops.convertBSTTODLL(TreeSamples.TREE);
        bstops.printDLL();
    }
}
