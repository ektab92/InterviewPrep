package com.practice.ds.amazon.stack;

import java.util.Stack;

public class ReverseStack {
    public void revsere(Stack<Integer>stk)
    {
        if(stk.isEmpty()) return ;
        int temp = stk.pop();
        revsere(stk);
        insertAtBottom(stk,temp);
    }
    private void insertAtBottom(Stack<Integer>stk,int a)
    {
        if(stk.isEmpty())
            stk.push(a);
        else
        {
            int temp = stk.pop();
            insertAtBottom(stk,a);
            stk.push(temp);
        }
    }
    public static void main(String[] args) {
        Stack<Integer>stk = new Stack<>();
        stk.push(2);
        stk.push(4);
        stk.push(5);
        stk.push(6);

        ReverseStack rev = new ReverseStack();
        rev.revsere(stk);
        while(!stk.isEmpty())
            System.out.println(stk.pop());
    }
}
