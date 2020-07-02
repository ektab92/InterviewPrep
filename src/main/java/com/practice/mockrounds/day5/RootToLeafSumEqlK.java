package com.practice.mockrounds.day5;
import java.util.*;
import com.practice.ds.TreeNode;

public class RootToLeafSumEqlK {
    int sum=0;
    List<Integer>path=new ArrayList<>();
    private void findPathsWithKSum(TreeNode root,int s)
    {
        if(root == null)
            return;
        sum=sum+root.data;
        path.add(root.data);
        if(root.left == null && root.right == null && sum==s)
        {
            System.out.println(path);
        }
        findPathsWithKSum(root.left,s);
        findPathsWithKSum(root.right,s);
        sum=sum-root.data;
        path.remove(path.size()-1);
    }
    public static void main(String[] args) {
        TreeNode TREE = new TreeNode(10);
        TreeNode sbTree = new TreeNode(5);
        sbTree.left = new TreeNode(3);
        sbTree.right = new TreeNode(6);
        sbTree.left.right = new TreeNode(4);
        TREE.left = new TreeNode(7);
        TREE.right = new TreeNode(5);
        TREE.left.left = new TreeNode(2);
        TREE.left.right = new TreeNode(8);
        TREE.right.left = new TreeNode(10);
        TREE.right.right = new TreeNode(30);
        TREE.left.left.right = sbTree;
        RootToLeafSumEqlK treeSample = new RootToLeafSumEqlK();
        treeSample.findPathsWithKSum(TREE,25);
    }
}
