package com.practice.ds0;

import java.util.LinkedList;
import java.util.Queue;

public class DiagonalTraversal {
    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }
    public static void printDiagonal(Node node)
    {
        Queue<Node>q = new LinkedList<>();
        if(node == null)
            return;
        q.add(node);
        q.add(null);
        while(!q.isEmpty())
        {
            Node ele = q.remove();
            if(ele == null && !q.isEmpty())
            {
                System.out.println("\n");
                q.add(null);
            }
            else
            {
                while(ele != null)
                {
                    System.out.println(ele.data+"--->");
                    if(ele.left != null)
                        q.add(ele.left);
                    ele = ele.right;
                }

            }
        }

    }

    public static void main(String[] args) {
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);

            root.right.left = new Node(6);
            root.right.right = new Node(7);
            printDiagonal(root);
        }
}
