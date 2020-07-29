package com.practice.ds.tree;

import com.practice.ds.TreeNode;
import java.util.*;

public class KthAncestorOfNode {
    Stack<TreeNode>stk=new Stack<>();
    boolean found=false;
    private void findNode(TreeNode root,TreeNode target)
    {
        if(root == null || found ) return ;

        if(root == target)
        {
            found = true;
            return;
        }
        stk.push(root);
        findNode(root.left,target);
        findNode(root.right,target);
        if(!found)
            stk.pop();
    }
    private int findKthAncestor(TreeNode root,int k,TreeNode target)
    {
        if(root == null) return 0;
        findNode(root,target);
        TreeNode ancestor=null;
        while(k != 0)
        {
            ancestor=stk.pop();
            k--;
        }
        return ancestor.data;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        KthAncestorOfNode treeops = new KthAncestorOfNode();
        int ancestor=treeops.findKthAncestor(root,3,root.left.right.right  );
        System.out.println(ancestor);
    }
}
