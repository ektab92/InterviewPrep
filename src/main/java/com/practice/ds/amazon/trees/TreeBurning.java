package com.practice.ds.amazon.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;
import com.practice.ds.TreeNode;

public class TreeBurning {
    boolean found = false;
    Stack<TreeNode>stk = new Stack<>();
    private int timeForTreeBurning(TreeNode root,int start)
    {
        if(root == null) return 0;
        findStart(root,start);
        int totalTime = 0;
        Queue<TreeNode>q = new LinkedList<>();
        List<List<Integer>>nodes= new ArrayList<>();
        List<Integer>level = new ArrayList<>();
        Set<Integer>visited = new HashSet<>();
        q.add(stk.pop());
        q.add(null);
        while(!q.isEmpty())
        {
            TreeNode curr =q.remove();

            if(curr == null)
            {
                if(level.size()>0) {
                    nodes.add(new ArrayList<>(level));
                    totalTime++;
                }
                level= new ArrayList<>();
                if(!q.isEmpty())
                    q.add(null);
            }
            else{
                level.add(curr.data);
                if( curr.left != null && !visited.contains(curr.left.data) )
                {
                    q.add(curr.left);
                }
                if(curr.right != null && !visited.contains(curr.right.data) )
                {
                    q.add(curr.right);
                }
                if(!stk.isEmpty())
                {
                    TreeNode temp = stk.pop();
                    q.add(temp);
                }
                visited.add(curr.data);
            }
        }
        for(int i =0;i< nodes.size();i++)
            System.out.println(nodes.get(i));
        System.out.println("timetaken"+totalTime);
        return totalTime;
    }
    private void findStart(TreeNode root, int start)
    {
        if(root == null || found) return;
        stk.push(root);
        if(root.data == start)
        {
            found=true;
            return;
        }
        findStart(root.left,start);
        findStart(root.right,start);
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
        TreeBurning burnTree  = new TreeBurning();
        burnTree.timeForTreeBurning(root,7);

    }
}
