package com.practice.ds.tree;

import com.practice.ds.TreeNode;
import com.practice.samples.TreeSamples;

import java.util.*;
public class TreeBurning {

    Stack<TreeNode> stk = new Stack<>();
    boolean found=false;
    int dist=1;
    Queue<TreeNode>q = new LinkedList<>();
    Set<TreeNode>visited = new HashSet<>();
    public void burnTree(TreeNode root, TreeNode start)
    {
        if(root == null) return ;
        findNode(root,start);
        q.add(stk.pop());
        while(!q.isEmpty())
        {
            TreeNode curr =q.remove();
            System.out.println(curr.data);
            visited.add(curr);
            if(curr.left != null && !visited.contains(curr.left))
                q.add(curr.left);
            if(curr.right != null && !visited.contains(curr.right))
                q.add(curr.right);
            if(!stk.isEmpty())
                q.add(stk.pop());
        }
    }
    private void findNode(TreeNode root,TreeNode target)
    {
        if(root == null || found) return ;
        stk.add(root);
        if(root==target)
        {
            found = true;
            return;
        }
        findNode(root.left,target);
        findNode(root.right,target);
        if(!found)
            stk.pop();
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

        TreeBurning treeBurning = new TreeBurning();
        treeBurning.burnTree(root,root.left.right );
    }
}
