package com.practice.machinecoding.notificationchannel;

import com.practice.machinecoding.notificationchannel.channel.ChannelFactory;
import com.practice.machinecoding.notificationchannel.channel.Channels;

import java.util.HashMap;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class NotificationChannelManager {
    //Map<String,Double> channelStatsMap = new ConcurrentHashMap<>();
    Map<String, Channels> channelMap = new HashMap<>();
    Map<String,ChannelStats>channelStatsMap = new HashMap<>();
    PriorityQueue<ChannelStats> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    public void registerChannel(ChannelFactory.ChannelsType type)
    {
        Channels channelObj = ChannelFactory.getChannelInstance(type);
        channelMap.put(type.name(),channelObj);
        ChannelStats stats = new ChannelStats(type.name(),0,0,100.0);
        channelStatsMap.put(type.name(),stats);
        maxHeap.add(stats);
    }
    public void triggerNotification(String message, int clientId)
    {
        String channelId=null;
        channelId = maxHeap.peek().ChannelId;
        ChannelStats cStat = channelStatsMap.get(channelId);
        double oldSF = cStat.successFactor;
        try {
            channelMap.get(channelId).sendNotification(message,clientId);
            maxHeap.remove();
            cStat.totalRequest++;
        } catch (Exception e) {
            cStat.failedCount++;
            cStat.totalRequest++;
            e.printStackTrace();
        }
        cStat.updateSuccessFactor();
        channelStatsMap.put(channelId,cStat);
        maxHeap.add(cStat);
        System.out.println(String.format("Success Factor for %s, changed from %2f to %2f ",channelId,oldSF,cStat.successFactor));
    }
  /*  public void updateSuccessFactor(String channelId ,double successFactor)
    {
        if(channelStatsMap.containsKey(channelId))
            ChannelStats stats = new ChannelStats(channelId,)
            channelStatsMap.put(channelId,);
    }*/
    public static void main(String[] args) throws Exception {
        NotificationChannelManager channelManager = new NotificationChannelManager();
        final Random random = new Random();
        channelManager.registerChannel(ChannelFactory.ChannelsType.EMAIL);
        channelManager.registerChannel(ChannelFactory.ChannelsType.SMS);
        channelManager.registerChannel(ChannelFactory.ChannelsType.Whatsapp);
        UserRepo userRepo=UserRepo.getInstance();
        userRepo.addUser(1,"12345678","15677888","a@yopmail.com");
        userRepo.addUser(2,"223455678","22277888","b@yopmail.com");
        userRepo.addUser(3,"323455678","32277888","c@yopmail.com");
        userRepo.addUser(4,"423455678","42277888","d@yopmail.com");
        while(true)
        {
            int clientId = random.nextInt(4)+1;
            Thread.sleep(2000);
            channelManager.triggerNotification("sending message for testing",clientId);
        }

        /*Thread channelUpdater = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    double newSF = random.nextInt(45) + 48.8;
                    List<String> keys = new ArrayList<>(channelManager.channelStatsMap.keySet());
                    int index = random.nextInt(keys.size());
                    channelManager.updateSuccessFactor(keys.get(index), newSF);
                    try {
                        Thread.sleep(1000);
                    }catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
            }
        });
        UserRepo userRepo=UserRepo.getInstance();
        userRepo.addUser(1,"12345678","15677888","a@yopmail.com");
        userRepo.addUser(2,"223455678","22277888","b@yopmail.com");
        userRepo.addUser(3,"323455678","32277888","c@yopmail.com");
        userRepo.addUser(4,"423455678","42277888","d@yopmail.com");
        channelUpdater.start();
        for(int i =0;i<10;i++)
        {
            int clientId = random.nextInt(4)+1;
            Thread.sleep(2000);
            channelManager.triggerNotification("sending message for testing",clientId);
        }
        channelUpdater.join();*/
    }
}
