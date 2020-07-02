package com.practice.ds0;
import java.util.*;
 class TreeNode {
      int val;
      com.practice.ds.TreeNode left;
      com.practice.ds.TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, com.practice.ds.TreeNode left, com.practice.ds.TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class UniqueBST {
    public List<com.practice.ds.TreeNode> generateTrees(int n) {
        ArrayList<com.practice.ds.TreeNode>trees= constructTrees(1,n);
        return trees;
    }
    private static ArrayList<com.practice.ds.TreeNode> constructTrees(int start, int end)
    {

        ArrayList<com.practice.ds.TreeNode>treeList = new ArrayList<>();
        if(start>end)
        {
            treeList.add(null);
            return treeList;
        }
        for(int i =start;i<=end;i++)
        {
            ArrayList<com.practice.ds.TreeNode> left= constructTrees(start,i-1);
            ArrayList<com.practice.ds.TreeNode> right= constructTrees(i+1,end);
            for(int j =0; j < left.size();j++)
            {
                com.practice.ds.TreeNode leftNode = left.get(j);
                for(int k=0;k<right.size();k++)
                {
                    com.practice.ds.TreeNode rightNode = right.get(k);
                    com.practice.ds.TreeNode node = new com.practice.ds.TreeNode(i);
                    node.left = leftNode;
                    node.right = rightNode;
                    treeList.add(node);
                }
            }
        }
        return treeList;
    }

    public static void main(String[] args) {
        constructTrees(1,5);
    }
}
