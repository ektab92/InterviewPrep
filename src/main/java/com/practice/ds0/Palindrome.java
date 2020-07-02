package com.practice.ds0;
import java.util.*;
class LNode{
    int data;
    LNode next;
    LNode(int data)
    {
        this.data = data;
    }
}
public class Palindrome {

    static LNode newhead;
    public static boolean findPalindroneRec(LNode head)
    {
        LNode curr = head;
        newhead = head;
        return PHelper(curr);
    }
    private static boolean  PHelper(LNode curr)
    {
        if(curr == null)
            return true;
        boolean s=PHelper(curr.next);
        if(!s || curr.data != newhead.data)
            return false;
        else
            newhead = newhead.next;
        return true;
    }
    public static boolean findPalindrome(LNode head)
    {
        LNode curr = head;
        int count=0;
        Stack<Integer>stk = new Stack<>();
        while(curr!=null)
        {
            count++;
            curr = curr.next;
        }
        int n=0;
        while(n<count/2)
        {
            stk.push(head.data);
            head=head.next;
            n++;
        }
        if(count%2 !=0)
            head=head.next;
        while(!stk.isEmpty())
        {
            if(stk.pop()!=head.data)
                return false;
            head=head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LNode head = new LNode(1);
         head.next = new LNode(2);
         head.next.next = new LNode(2);
         head.next.next.next = new LNode(2);
         head.next.next.next.next = new LNode(1);
        System.out.println(findPalindroneRec(head));
    }
}
