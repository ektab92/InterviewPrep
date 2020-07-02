package com.practice.ds0;
import java.util.*;

public class MwayTree {
    MNode root;
    static class MNode {
        int data;
        Map <Integer,MNode> childMap = new HashMap<>();
        MNode(int data)
        {
            this.data = data;
        }
    }
    MNode findparent(MNode node,int data)
    {
        if(node.data == data)
            return node;
        if(node.childMap.containsKey(data))
            return node.childMap.get(data);
        for(int i:node.childMap.keySet())
            return findparent(node.childMap.get(i),data);
        return null;
    }
    void addNodeToPos(int data, int parent )
    {
        MNode newnode = new MNode(data);
        if(root == null)
            root = newnode;
        else
        {
            MNode parentNode=findparent(root, parent);
            if(parentNode != null)
                parentNode.childMap.put(data,newnode);

        }

    }
}
