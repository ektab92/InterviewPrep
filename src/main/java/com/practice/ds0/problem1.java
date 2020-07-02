package com.practice.ds0;

public class problem1 {
    static boolean v1=false,v2=false;
    Node temp;
    Node l;
    Node r;
    //finding LCA in any tree when nodes are not gauranteed to be present
    public Node findLCAInBSt(Node root,int a,int b)
    {
        if(root == null)
            return null;
       if (root.data == a)
       {
           v1=true;
           return root;
       }
       if(root.data== b)
       {
           v2=true;
           return root;
       }
       Node l = findLCAInBSt(root.left,a,b);
       Node r = findLCAInBSt(root.right,a,b);
       if(l != null && r!=null)
           return root;
       else if(l !=null)
           return l;
       else
           return r;
    }
    public int findLCAHelper(Node root,int a,int b)
    {
        if(root == null)
            return -1;
        Node lca=findLCAInBSt(root,a,b);
        if(v1 && v2)
            return lca.data;
        else
            return -1;
    }
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(9);
        root.right = new Node(25);
        root.left.left = new Node(7);
        root.left.right = new Node(10);
        root.right.left = new Node(21);
        root.right.right = new Node(28);
        problem1 p = new problem1();
        System.out.println(p.findLCAHelper(root,20,45));
    }
}
