package com.practice.ds0;

public class Problem3 {
    static int maxLevel=-1;
    public static void printRightView(Node root,int level)
    {
        if(root == null)
            return ;
        if(level > maxLevel)
        {
            System.out.println(root.data);
            maxLevel=level;
        }
        printRightView(root.right,level+1);
        printRightView(root.left,level+1);
        
    }
    public static void printLeftViewNew(Node root,int level)
    {
        if(root == null)
            return ;
        if(level > maxLevel)
        {
            System.out.println(root.data);
            maxLevel=level;
        }
        printLeftViewNew(root.left,level+1);
        printLeftViewNew(root.right,level+1);

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.left = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);
        //printRightView(root,1);
        printLeftViewNew(root,1);
        //root.right.left = new .Node(21);
        //root.right.right = new .Node(28);
        
    }
}
