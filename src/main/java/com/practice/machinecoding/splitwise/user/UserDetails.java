package com.practice.machinecoding.splitwise.user;

import java.util.*;

public class UserDetails {
    int userId;
    String userName;
    private Map<Integer,Double>balanceMap;
    public UserDetails(int userId,String name)
    {
        this.userId=userId;
        this.userName=name;
        this.balanceMap=new HashMap<>();
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public double totalLent()
    {
        double total =0.0;
        for(double money:balanceMap.values())
        {
            if(money>0)
            {
                total+=money;
            }
        }
        return total;
    }

    public double totalOwe()
    {
        double total =0.0;
        for(double money:balanceMap.values())
        {
            if(money<0)
            {
                total+=money;
            }
        }
        return total;
    }
    public double totalOwedToUser(int userId)
    {
        double total=0.0;
        total=balanceMap.get(userId);
        if(total < 0)
            return Math.abs(total);
        else
            return 0;
    }
    public double totalLentToUser(int userId)
    {
        double total=0.0;
        total=balanceMap.get(userId);
        if(total > 0)
            return total;
        else
            return 0;
    }
    public void updateExpense(int userId,double val)
    {
        balanceMap.put(userId,balanceMap.getOrDefault(userId,0.0)+val);
    }
}
