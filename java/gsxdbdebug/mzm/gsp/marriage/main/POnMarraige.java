/*     */ package mzm.gsp.marriage.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.buff.main.BuffInterface;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.marriage.SSendMarriageMsgSucceed;
/*     */ import mzm.gsp.marriage.SSendMarriageMsgToFriend;
/*     */ import mzm.gsp.marriage.confbean.SMarriageConsts;
/*     */ import mzm.gsp.marriage.event.MarriageArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.NotNotifyMarriage;
/*     */ import xtable.Role2notnotifymarriage;
/*     */ 
/*     */ public class POnMarraige extends mzm.gsp.marriage.event.MarriageEventProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  22 */     lock(xtable.Role2marriage.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(((MarriageArg)this.arg).roleidA), Long.valueOf(((MarriageArg)this.arg).roleidB) }));
/*     */     
/*  24 */     String rolenameA = mzm.gsp.role.main.RoleInterface.getName(((MarriageArg)this.arg).roleidA);
/*  25 */     String roleNameB = mzm.gsp.role.main.RoleInterface.getName(((MarriageArg)this.arg).roleidB);
/*     */     
/*     */ 
/*  28 */     List<Long> normalRoleList = mzm.gsp.team.main.TeamInterface.getNormalRoleList(((MarriageArg)this.arg).roleidA);
/*  29 */     if (normalRoleList.contains(Long.valueOf(((MarriageArg)this.arg).roleidB)))
/*     */     {
/*  31 */       BuffInterface.installBuff(((MarriageArg)this.arg).roleidA, SMarriageConsts.getInstance().coupleInteamBuffid);
/*  32 */       BuffInterface.installBuff(((MarriageArg)this.arg).roleidB, SMarriageConsts.getInstance().coupleInteamBuffid);
/*     */     }
/*     */     
/*  35 */     Long marriageid = xtable.Role2marriage.get(Long.valueOf(((MarriageArg)this.arg).roleidA));
/*  36 */     if (marriageid == null) {
/*  37 */       GameServer.logger().error(String.format("[Marriage]POnMarraige.processImp@marriage data not exist|roleid=%d", new Object[] { Long.valueOf(((MarriageArg)this.arg).roleidA) }));
/*     */       
/*     */ 
/*  40 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  44 */     xbean.Marriage xMarriage = xtable.Marriage.get(marriageid);
/*  45 */     if (xMarriage == null) {
/*  46 */       GameServer.logger().error(String.format("[Marriage]POnMarraige.processImp@marriage data not exist|marriageid=%d", new Object[] { marriageid }));
/*     */       
/*     */ 
/*     */ 
/*  50 */       return false;
/*     */     }
/*  52 */     int marriageTimeSec = (int)(xMarriage.getMarrytime() / 1000L);
/*  53 */     SSendMarriageMsgToFriend sendMarriageMsgToFriendA = new SSendMarriageMsgToFriend();
/*  54 */     sendMarriageMsgToFriendA.roleid = ((MarriageArg)this.arg).roleidA;
/*  55 */     sendMarriageMsgToFriendA.roleidaname = rolenameA;
/*  56 */     sendMarriageMsgToFriendA.roleidbname = roleNameB;
/*  57 */     sendMarriageMsgToFriendA.level = ((MarriageArg)this.arg).level;
/*  58 */     sendMarriageMsgToFriendA.timesec = marriageTimeSec;
/*  59 */     List<Long> roleAFriends = FriendInterface.getAllFriends(((MarriageArg)this.arg).roleidA, true);
/*  60 */     for (Iterator i$ = roleAFriends.iterator(); i$.hasNext();) { final long friendId = ((Long)i$.next()).longValue();
/*  61 */       if (friendId != ((MarriageArg)this.arg).roleidB)
/*     */       {
/*     */ 
/*  64 */         boolean ret = OnlineManager.getInstance().send(friendId, sendMarriageMsgToFriendA);
/*  65 */         if (!ret) {
/*  66 */           NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicProcedure()
/*     */           {
/*     */             protected boolean processImp() throws Exception
/*     */             {
/*  70 */               NotNotifyMarriage xNotifyMarriage = Role2notnotifymarriage.get(Long.valueOf(friendId));
/*  71 */               if (xNotifyMarriage == null) {
/*  72 */                 xNotifyMarriage = xbean.Pod.newNotNotifyMarriage();
/*  73 */                 Role2notnotifymarriage.insert(Long.valueOf(friendId), xNotifyMarriage);
/*     */               }
/*  75 */               xNotifyMarriage.getMarriageids().add(this.val$marriageid);
/*  76 */               return true;
/*     */             }
/*     */           });
/*     */         }
/*     */       }
/*     */     }
/*  82 */     SSendMarriageMsgToFriend sendMarriageMsgToFriendB = new SSendMarriageMsgToFriend();
/*  83 */     sendMarriageMsgToFriendB.roleid = ((MarriageArg)this.arg).roleidB;
/*  84 */     sendMarriageMsgToFriendB.roleidaname = roleNameB;
/*  85 */     sendMarriageMsgToFriendB.roleidbname = rolenameA;
/*  86 */     sendMarriageMsgToFriendB.level = ((MarriageArg)this.arg).level;
/*  87 */     sendMarriageMsgToFriendB.timesec = marriageTimeSec;
/*  88 */     List<Long> roleBFriends = FriendInterface.getAllFriends(((MarriageArg)this.arg).roleidB, true);
/*  89 */     for (Iterator i$ = roleBFriends.iterator(); i$.hasNext();) { final long friendId = ((Long)i$.next()).longValue();
/*  90 */       if (friendId != ((MarriageArg)this.arg).roleidA)
/*     */       {
/*     */ 
/*  93 */         boolean ret = OnlineManager.getInstance().send(friendId, sendMarriageMsgToFriendB);
/*  94 */         if (!ret) {
/*  95 */           NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicProcedure()
/*     */           {
/*     */             protected boolean processImp() throws Exception
/*     */             {
/*  99 */               NotNotifyMarriage xNotifyMarriage = Role2notnotifymarriage.get(Long.valueOf(friendId));
/* 100 */               if (xNotifyMarriage == null) {
/* 101 */                 xNotifyMarriage = xbean.Pod.newNotNotifyMarriage();
/* 102 */                 Role2notnotifymarriage.insert(Long.valueOf(friendId), xNotifyMarriage);
/*     */               }
/* 104 */               xNotifyMarriage.getMarriageids().add(this.val$marriageid);
/* 105 */               return true;
/*     */             }
/*     */           });
/*     */         }
/*     */       }
/*     */     }
/* 111 */     SSendMarriageMsgSucceed sendMarriageMsgSucceed = new SSendMarriageMsgSucceed();
/* 112 */     sendMarriageMsgSucceed.roleid = ((MarriageArg)this.arg).roleidA;
/* 113 */     sendMarriageMsgSucceed.level = ((MarriageArg)this.arg).level;
/* 114 */     sendMarriageMsgSucceed.roleidname = rolenameA;
/* 115 */     sendMarriageMsgSucceed.timesec = marriageTimeSec;
/* 116 */     OnlineManager.getInstance().send(((MarriageArg)this.arg).roleidB, sendMarriageMsgSucceed);
/*     */     
/* 118 */     SSendMarriageMsgSucceed sendMarriageMsgSucceedA = new SSendMarriageMsgSucceed();
/* 119 */     sendMarriageMsgSucceedA.roleid = ((MarriageArg)this.arg).roleidB;
/* 120 */     sendMarriageMsgSucceedA.level = ((MarriageArg)this.arg).level;
/* 121 */     sendMarriageMsgSucceedA.roleidname = roleNameB;
/* 122 */     sendMarriageMsgSucceedA.timesec = marriageTimeSec;
/* 123 */     OnlineManager.getInstance().send(((MarriageArg)this.arg).roleidA, sendMarriageMsgSucceedA);
/*     */     
/* 125 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\POnMarraige.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */