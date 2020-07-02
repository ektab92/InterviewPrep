package com.practice.ds0;

import java.util.*;
public class VerticalTraversal {
    static Set<Integer>levels =new HashSet<>();
    public static void printVerticalView(Node node,int l)
    {
        if(node == null)
            return ;
        if(!levels.contains(l))
        {
            levels.add(l);
            System.out.println(node.data);
        }
        printVerticalView(node.left,l-1);
        printVerticalView(node.right,l+1);
    }
    public static void printVerticalTraversal(Node node,int dist,Map <Integer,List<Integer>>map)
    {
        if(node == null)
            return;
        else
        {

            if(!map.containsKey(dist))
            {
                List <Integer> l = new ArrayList<>();
                l.add(node.data);
                map.put(dist,l);
            }
            else
            {
                map.get(dist).add(node.data);
            }
            printVerticalTraversal(node.left,dist-1,map);
            printVerticalTraversal(node.right,dist+1,map);
        }
    }
    public static void displayTraversal(Node node,Map <Integer,List<Integer>>map)
    {
        for(int i:map.keySet())
        {
            System.out.println(map.get(i));
        }
    }

    public static void main(String[] args) {
         Map <Integer,List<Integer>>map = new TreeMap<>();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.right = new Node(14);
        root.left.left.right.left = new Node(24);
        root.left.left.right.right = new Node(38);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(17);
        root.right.right.right.left = new Node(57);
        root.right.right.right.left.right = new Node(67);
        //printVerticalTraversal(root,0,map);
        //displayTraversal(root,map);
        printVerticalView(root,0);
    }

}
