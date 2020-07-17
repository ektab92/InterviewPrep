package com.practice.machinecoding.latest.notificationChannel;

import com.practice.machinecoding.latest.notificationChannel.channels.Channel;
import com.practice.machinecoding.latest.notificationChannel.channels.ChannelFactory;
import com.practice.machinecoding.latest.notificationChannel.channels.ChannelTypes;
import com.practice.machinecoding.latest.notificationChannel.users.UserRepo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class NotificationManager {
    Map<String, Channel> channelObjectMap = new HashMap<>();

    public void registerChannel(String channelId, ChannelTypes types,double sf)
    {
        Channel channelObj =ChannelFactory.getChannelInstance(types);
        channelObj.setSuccessFactor(sf);
        channelObjectMap.put(channelId,channelObj);
        System.out.println(String.format("%s channel is registered with system.",channelId));
    }

    public void triggerNotification(String message , int clientId) throws Exception
    {
            double maxSF=-1.0;
            Channel bestChannel = null;
            for(String channelId:channelObjectMap.keySet())
            {
                if(channelObjectMap.get(channelId).successFactor >maxSF)
                {
                    maxSF = channelObjectMap.get(channelId).successFactor;
                    bestChannel=channelObjectMap.get(channelId);
                }
            }
            try {
                bestChannel.sendNotification(message, clientId);
            }catch(Exception e)
            {
                bestChannel.totalFailure++;
            }
            finally {
                bestChannel.totalRequest++;
                double oldsf = bestChannel.getSuccessFactor();
                bestChannel.updateSuccessFactor();
                System.out.println(String.format("%s success Factor is now %.2f",oldsf,bestChannel.getSuccessFactor()));
            }
    }

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        UserRepo userRepo = UserRepo.getInstance();
        System.out.println("******Welcome to Ekta's notification Channel*******");
        System.out.println("Enter Number of Channels EMAIL/SMS/Phone(max 3)");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
           int noOfChannels= Integer.parseInt(br.readLine().trim());
           for(int i =0;i<noOfChannels;i++)
           {
               String channelInput[]=br.readLine().split("\\s+");
               notificationManager.registerChannel(channelInput[0].trim(),ChannelTypes.getChannel(channelInput[1].trim()),
                       Double.parseDouble(channelInput[2].trim()));
           }
           System.out.println("All channels are registered");

           System.out.println("Enter Number of Users (ClientId Phone WhatsAPP Email) ");
           int noOfUsers= Integer.parseInt(br.readLine().trim());
           for(int i =0;i<noOfUsers;i++)
           {
               String u[]=br.readLine().split("\\s+");
               userRepo.addUser(Integer.parseInt(u[0].trim()),u[1].trim(),u[2].trim(),u[3].trim());
           }

           while(true)
           {
               System.out.println("Enter Message Details: Message ClientID");
               String text[]=br.readLine().split("\\s+");
               notificationManager.triggerNotification(text[0].trim(),Integer.parseInt(text[1].trim()));
           }

        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
