/*     */ package mzm.gsp.chat.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.chat.confbean.ChatConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.XdbUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.NewerChannel;
/*     */ import xbean.NewerChannels;
/*     */ import xbean.Pod;
/*     */ import xio.Protocol;
/*     */ import xtable.Newerchanneltable;
/*     */ 
/*     */ 
/*     */ 
/*     */ class NewerManager
/*     */ {
/*     */   static List<NewerChannel> getNewerChannels()
/*     */   {
/*  24 */     NewerChannels newerChannels = Newerchanneltable.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  25 */     if (newerChannels == null)
/*     */     {
/*  27 */       Newerchanneltable.add(Long.valueOf(GameServerInfoManager.getLocalId()), Pod.newNewerChannels());
/*  28 */       return Newerchanneltable.get(Long.valueOf(GameServerInfoManager.getLocalId())).getNewerchannels();
/*     */     }
/*  30 */     return newerChannels.getNewerchannels();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void rmNewer(long roleId, List<NewerChannel> newerChannels)
/*     */   {
/*  41 */     for (NewerChannel newerChannel : newerChannels)
/*     */     {
/*  43 */       if (newerChannel.getNewerids().remove(Long.valueOf(roleId)))
/*     */       {
/*  45 */         return;
/*     */       }
/*     */     }
/*  48 */     RoleChatManager.logger.error(String.format("[chat]NewerManager.rmNewer@将玩家从新手频道删除失败，新手频道中没有该玩家!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void rmNewerList(List<Long> roleList, List<NewerChannel> newerChannels)
/*     */   {
/*  59 */     for (NewerChannel newerChannel : newerChannels)
/*     */     {
/*  61 */       if ((roleList == null) || (roleList.size() == 0))
/*     */       {
/*  63 */         return;
/*     */       }
/*  65 */       Iterator<Long> it = roleList.iterator();
/*  66 */       while (it.hasNext())
/*     */       {
/*  68 */         long roleId = ((Long)it.next()).longValue();
/*  69 */         if (newerChannel.getNewerids().remove(Long.valueOf(roleId)))
/*     */         {
/*     */ 
/*     */ 
/*  73 */           it.remove();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean addNewer(long roleId, List<NewerChannel> newerChannels)
/*     */   {
/*  87 */     if (newerChannels.size() <= 0)
/*     */     {
/*  89 */       NewerChannel newChannel = Pod.newNewerChannel();
/*  90 */       newChannel.getNewerids().add(Long.valueOf(roleId));
/*  91 */       newerChannels.add(newChannel);
/*  92 */       return true;
/*     */     }
/*  94 */     XdbUtils.sortXBean(newerChannels, new XNewerChannelComparator());
/*  95 */     NewerChannel newChannel = (NewerChannel)newerChannels.get(newerChannels.size() - 1);
/*  96 */     if (newChannel.getNewerids().size() >= ChatConsts.getInstance().newChannelMemberMax)
/*     */     {
/*  98 */       NewerChannel newChannel2 = Pod.newNewerChannel();
/*  99 */       newChannel2.getNewerids().add(Long.valueOf(roleId));
/* 100 */       newerChannels.add(newChannel2);
/*     */     }
/*     */     else
/*     */     {
/* 104 */       newChannel.getNewerids().add(Long.valueOf(roleId));
/*     */     }
/* 106 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean sendToNewer(long roleId, List<NewerChannel> newerChannels, Protocol protocol)
/*     */   {
/* 119 */     for (NewerChannel newerChannel : newerChannels)
/*     */     {
/* 121 */       if (newerChannel.getNewerids().contains(Long.valueOf(roleId)))
/*     */       {
/*     */ 
/*     */ 
/* 125 */         OnlineManager.getInstance().sendMulti(protocol, newerChannel.getNewerids());
/* 126 */         return true;
/*     */       } }
/* 128 */     GameServer.logger().error(String.format("[chat]NewerManager.sendToNewer@ not find role newerChannel|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/* 129 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void mergeNewer(List<NewerChannel> newerChannels)
/*     */   {
/* 139 */     XdbUtils.sortXBean(newerChannels, new XNewerChannelComparator());
/* 140 */     for (int i = newerChannels.size() - 1; i > 0; i--)
/*     */     {
/* 142 */       NewerChannel afterChannel = (NewerChannel)newerChannels.get(i);
/* 143 */       NewerChannel beforeChannel = (NewerChannel)newerChannels.get(i - 1);
/* 144 */       if (afterChannel.getNewerids().size() + beforeChannel.getNewerids().size() > ChatConsts.getInstance().newChannelMemberMergeMax)
/*     */         break;
/* 146 */       beforeChannel.getNewerids().addAll(afterChannel.getNewerids());
/* 147 */       newerChannels.remove(i);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\NewerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */