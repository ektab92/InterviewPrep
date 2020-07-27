package com.practice.machinecoding.splitwise;

import com.practice.machinecoding.splitwise.user.UserDetails;
import com.practice.machinecoding.splitwise.user.UserRepository;
import com.practice.machinecoding.splitwise.usergroup.UserGroupDetails;

import java.util.*;
public class ExpenseManager {
    UserRepository userRepo = UserRepository.getInstance();
    public void addExpense(int groupId, int userId, SplitTypes splitType, double amount, Map<Integer,Double>userShareMap) throws Exception
    {
        List<Integer> users = UserGroupDetails.groupIdUserListMap.get(groupId);
        switch(splitType)
        {
            case EQUAL:
                double share = amount/users.size();
                for(int user :users)
                {
                    if(user != userId)
                    {
                        //user who need to give to userId(one who did expense)
                        userRepo.userObjectMap.get(user).updateExpense(userId, (-1) * share);

                        //user who will get the money from all others
                        userRepo.userObjectMap.get(userId).updateExpense(user, share);
                    }
                }
                break;
            case EXACT:
                for(int user:userShareMap.keySet())
                {
                    if(users.contains(user))
                    {
                        userRepo.userObjectMap.get(user).updateExpense(userId,(-1)*userShareMap.get(user));
                        userRepo.userObjectMap.get(userId).updateExpense(user,userShareMap.get(user));
                    }
                    else
                    {
                        throw new Exception(String.format("User in map is not a memeber of Group %d",groupId));
                    }
                }
                break;
            case PERCENT:
                double total=0.0;
                for(int user:userShareMap.keySet())
                {
                    if(!users.contains(user) )
                        throw new Exception(String.format("User in map is not a memeber of Group %d",groupId));
                    else
                    {
                        total+=userShareMap.get(user);
                    }
                }
                if(total != 100.00)
                    throw new Exception(String.format("Invalid share distribution!!!"));
                else
                {
                    for(int user:userShareMap.keySet())
                    {
                        if(userId != user)
                        {
                            //user who need to give to userId(one who did expense)
                            double perUserAmt = (amount*userShareMap.get(user))/100;
                            userRepo.userObjectMap.get(user).updateExpense(userId, (-1) * perUserAmt);

                            //user who will get the money from all others
                            userRepo.userObjectMap.get(userId).updateExpense(user, perUserAmt);
                        }
                    }
                }
                break;
            default:
                System.out.println("Unsupported Operation");
        }
    }

    public void settleUpByGroupID(int groupId)
    {

    }
}
