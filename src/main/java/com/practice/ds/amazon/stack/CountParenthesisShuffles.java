package com.practice.ds.amazon.stack;

import java.util.Stack;

public class CountParenthesisShuffles {
    Stack<Character>stk = new Stack<>();
    private int countShuffles(String expr)
    {
        for(int i=0;i<expr.length();i++)
        {
            if( expr.charAt(i)=='}')
            {
                if(!stk.isEmpty() &&  stk.peek()=='{')
                    stk.pop();
                else
                    stk.push(expr.charAt(i));
            }
            else
                stk.push(expr.charAt(i));

        }
        double openCount = 0.0;
        double closedCount =0.0;
        while(!stk.isEmpty())
        {
            char c = stk.pop();
            if(c == '{')
                openCount++;
            else
                closedCount++;
        }
        return (int)Math.ceil(openCount/2)+(int)Math.ceil(closedCount/2);
    }
    public static void main(String[] args) {
        String expr = "}{{}}{{{";
        CountParenthesisShuffles stkOps = new CountParenthesisShuffles();
        System.out.println(stkOps.countShuffles(expr));
    }
}
