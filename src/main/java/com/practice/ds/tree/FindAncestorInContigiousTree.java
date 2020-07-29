package com.practice.ds.tree;

import com.practice.ds.TreeNode;

import java.util.*;

public class FindAncestorInContigiousTree {
    int arr[];
    private void createArrFromTreee(TreeNode root, int n)
    {
        arr = new int [n+1];
        Queue<TreeNode>q= new LinkedList<>();
        arr[0]=-1;
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode ele = q.remove();
            if(ele.left != null)
            {
                q.add(ele.left);
                //parent of left child is root
                arr[ele.left.data]=ele.data;
            }
            if(ele.right != null)
            {
                //parent of right child is root
                q.add(ele.right);
                arr[ele.right.data]=ele.data;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private int findKthAncestor(int target,int k)
    {
        if(k == 0) return target;
        int ancestor=-1;
        while(k!= 0 && ancestor>0)
        {
            ancestor = arr[target];
            target = ancestor;
            k--;
        }
        return ancestor;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        FindAncestorInContigiousTree treeOps = new FindAncestorInContigiousTree();
        treeOps.createArrFromTreee(root,8);
        System.out.println(treeOps.findKthAncestor(7,4));

    }
}
