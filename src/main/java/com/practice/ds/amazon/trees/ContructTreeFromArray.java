package com.practice.ds.amazon.trees;

import com.practice.ds.TreeNode;

import java.util.Arrays;

public class ContructTreeFromArray {
    //{1,5,5,2,2,-1,3}
    TreeNode root = null;
    private TreeNode constructTree(int[]arr)
    {
        TreeNode nodeObjMap [] = new TreeNode[arr.length];
        for(int i =0;i<arr.length;i++)
        {
            if(nodeObjMap[i]==null)
            {
                nodeObjMap[i]=new TreeNode(i);
            }

            if(arr[i]!=-1 && nodeObjMap[arr[i]] == null)
            {
                nodeObjMap[arr[i]] = new TreeNode(arr[i]);
            }
            else if(arr[i] == -1 )
            {
                root = nodeObjMap[i];
                continue;
            }
            if(nodeObjMap[arr[i]].left == null)
                nodeObjMap[arr[i]].left=nodeObjMap[i];
            else
                nodeObjMap[arr[i]].right=nodeObjMap[i];
        }
        return root;
    }

    private void printInorder(TreeNode root)
    {
        if(root == null) return ;
        printInorder(root.left);
        System.out.println(root.data);
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int arr[] = {1,5,5,2,2,-1,3};
       ContructTreeFromArray treeOps = new ContructTreeFromArray();
       TreeNode root = treeOps.constructTree(arr);
       treeOps.printInorder(root);
    }
}
