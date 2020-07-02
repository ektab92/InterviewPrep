package com.practice.ds0;
import java.util.*;
public class FindNodePath {
    static List <Integer> list1 = new ArrayList <Integer>();
    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }
        static boolean findNodePath(Node node,int data,List<Integer>list)
        {
            if(node == null)
                return false;
            list.add(node.data);
            if(node.data == data)
                return true;
            boolean leftval=findNodePath(node.left,data,list);
            boolean rightval=findNodePath(node.right,data,list);
            if(leftval || rightval)
                return true;
            else {
                list.remove(list.size() - 1);
                return false;
            }
        }


    public static void main(String[] args) {
        FindNodePath.Node root = new FindNodePath.Node(1);
        root.left = new FindNodePath.Node(2);
        root.right = new FindNodePath.Node(3);
        root.left.left = new FindNodePath.Node(4);
        root.left.right = new FindNodePath.Node(5);
        root.right.left = new FindNodePath.Node(6);
        root.right.right = new FindNodePath.Node(7);
        findNodePath(root,7,list1);
        System.out.println(list1);
    }

}
