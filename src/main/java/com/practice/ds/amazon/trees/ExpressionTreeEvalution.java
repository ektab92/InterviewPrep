package com.practice.ds.amazon.trees;

class TreeNode
{
    String c;
    TreeNode left;
    TreeNode right;
    TreeNode(String c)
    {
        this.c = c;
    }
}
public class ExpressionTreeEvalution {
    private int evaluateTree(TreeNode root)
    {
        if(root == null) return 0;
        if(root.left == null && root.right ==null)
        {
            return Integer.parseInt(root.c);
        }
        int lVal = evaluateTree(root.left);
        int rVal = evaluateTree(root.right);
        if(root.c.equals("*"))
            return (lVal * rVal);
        if(root.c.equals("/"))
            return (lVal/rVal);
        if(root.c.equals("+"))
            return (lVal+rVal);
        else
            return (lVal-rVal);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode("*");
        root.left = new TreeNode("+");
        root.right = new TreeNode("/");
        root.left.left = new TreeNode("1");
        root.left.right = new TreeNode("9");
        root.right.left = new TreeNode("5");
        root.right.right = new TreeNode("4");
        ExpressionTreeEvalution evaluate = new ExpressionTreeEvalution();
        int result =evaluate.evaluateTree(root);
        System.out.println("the result is : "+result);
    }
}
