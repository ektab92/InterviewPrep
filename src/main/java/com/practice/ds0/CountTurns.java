package com.practice.ds0;

public class CountTurns {
    //static TreeNode temp=null;
    static int  n1Turns=0;
    static int n2Turns=0;
    public static int countTurns(TreeNode root,int n1,int n2)
    {
        if(root == null)
            return 0;
        TreeNode lca = findLCA(root,n1,n2);
        System.out.println("lca is : "+lca.val);
        if(lca.val == n1 || lca.val == n2 )
        {
            turnCountFromLCA(lca.left,n1,n2,0,true);
            turnCountFromLCA(lca.right,n1,n2,0,false);
            return n1Turns+n2Turns;
        }
        else
        {
             turnCountFromLCA(lca.left,n1,n2,0,true) ;
             turnCountFromLCA(lca.right,n1,n2,0,false);
             return 1+n1Turns+n2Turns;
        }
    }
    public static TreeNode findLCA(TreeNode root, int n1,int n2)
    {

        if(root == null)
            return null;
        TreeNode temp=null;
        if(root.val == n1)
             temp = root;
        if(root.val == n2)
             temp = root;
        TreeNode l = findLCA(root.left,n1,n2);
        TreeNode r = findLCA(root.right,n1,n2);
        if(temp !=null)
            return temp;
        if(l != null && r != null)
            return root;
        return (l==null)?r:l;
    }
    public static void  turnCountFromLCA(TreeNode root, int n1,int n2,int count,boolean cameFromLeft)
    {
        if(root == null)
            return ;
        if(root.val == n1)
        {
            n1Turns = count;
            return;
        }
        if(root.val == n2)
        {
            n2Turns=count;
            return;
        }
        if(cameFromLeft)
        {
              turnCountFromLCA(root.left,n1,n2,count,true);
              turnCountFromLCA(root.right,n1,n2,count+1,false);
        }
        else
        {
            turnCountFromLCA(root.right,n1,n2,count,false);
            turnCountFromLCA(root.left,n1,n2,count+1,true);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(77);
        root.right.right.right.right = new TreeNode(17);
        root.right.right.right.right.right = new TreeNode(27);
        int turns =countTurns(root,77,5);
        System.out.println(turns);
    }
}
