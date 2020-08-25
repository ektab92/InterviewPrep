package com.practice.ds.tree;
import java.util.*;
class TrieNode
{
    char data;
    boolean isEOW;
    Map<Character,TrieNode>children;
    TrieNode(char data,boolean isEOW)
    {
        this.data = data;
        this.isEOW=isEOW;
        children= new HashMap<>();
    }
}
class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode('!',false);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode currNode = root;
        for(int i=0;i<word.length();i++)
        {
            char currChar = word.charAt(i);
            if(!currNode.children.containsKey(currChar))
            {
                TrieNode newNode = new TrieNode(currChar,false);
                currNode.children.put(currChar,newNode);
                currNode = newNode;
            }
            else
            {
                currNode =currNode.children.get(currChar);
            }
            if(i == word.length()-1)
                currNode.isEOW=true;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++)
        {
            char currChar = word.charAt(i);
            if(curr.children.containsKey(currChar))
            {
                curr = curr.children.get(currChar);
            }
            else
                return false;
        }
        return curr.isEOW;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0;i<prefix.length();i++)
        {
            char currChar = prefix.charAt(i);
            if(curr.children.containsKey(currChar))
            {
                curr = curr.children.get(currChar);
            }
            else
                return false;
        }
        return true;
    }

    public boolean deleteWordRev(TrieNode curr,String word,int index)
    {
        if(index == word.length()) {
            if (!curr.isEOW)
                return false;
            curr.isEOW = false;
            return (curr.children.size() == 0);
        }
        if(!curr.children.containsKey(word.charAt(index)))
            return false;
        TrieNode temp = curr.children.get(word.charAt(index));
        if(temp == null)
            return false;
        boolean canDelete = deleteWordRev(temp,word,index+1);
        if(canDelete)
        {
            curr.children.remove(word.charAt(index));
            return (curr.children.size() == 0);
        }
        return false;
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc");
        trie.insert("abcd");
        trie.insert("ag");
        trie.insert("bmaq");
        trie.deleteWordRev(trie.root,"abc",0);
        boolean found=trie.search("abc");
        if(found)
            System.out.println("true");
        else
            System.out.println("false");
    }
}

