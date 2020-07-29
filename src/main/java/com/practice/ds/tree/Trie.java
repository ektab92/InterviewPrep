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
        if(index == word.length())
        {
            if(!curr.isEOW)
            {
                return false;
            }
            curr.isEOW=false;
            return (curr.children.size() == 0);
        }
        if(!curr.children.containsKey(word.charAt(index)))
        {
            return false;
        }
        else
        {
           boolean canDelete= deleteWordRev(curr.children.get(word.charAt(index)),word,index+1);
           if(canDelete)
           {
               curr.children.remove(word.charAt(index));
               return (curr.children.size() == 0);
           }
        }
        return false;
    }
    public boolean deleteWord(TrieNode curr,String word,int index)
    {
        // if index is equal to length of word
        if(index == word.length()){

            if(curr.isEOW == false){
                // this substring exist but word does not exist in our Trie
                // return false as nothing to delete
                return false;
            }
            // isEOW is true
            curr.isEOW = false; // the word got deleted
            return curr.children.size()==0; // if size is zero then this is not prefix to any other word and should be deleted
        }

        // find the node based on the current char
        TrieNode n = curr.children.get(word.charAt(index));
        if(n == null){
            return false;
        }
        boolean shouldDelete = deleteWord(n,word,index+1);

        if(shouldDelete){
            curr.children.remove(word.charAt(index)); // delete entry of node mapping from curr node
            return curr.children.size()==0; // check if mapping has some value . If 0 then consider this current node for deletion in successive recursion stack.
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

