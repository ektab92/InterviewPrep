package com.practice.machinecoding.splitwise.usergroup;

import java.util.*;
public class UserGroupDetails {
    public static Map<Integer,List<Integer>> groupIdUserListMap = new HashMap<>();
    public static void addUserToGroup(int userId,int groupId)
    {
        List userList = groupIdUserListMap.get(groupId);
        userList.add(userId);
        groupIdUserListMap.put(userId,userList);
        System.out.println(String.format("user %d added to group %d",userId,groupId));
    }
    public static void deleteUserFromGroup(int userId,int groupId)
    {
        List userList = groupIdUserListMap.get(groupId);
        userList.remove(userId);
        groupIdUserListMap.put(userId,userList);
        System.out.println(String.format("user %d removed from group %d",userId,groupId));
    }
}
