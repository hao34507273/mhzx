/*     */ package mzm.gsp.apollo.main;
/*     */ 
/*     */ import apollo.GetApolloInfo;
/*     */ import apollo.GetApolloInfoArg;
/*     */ import apollo.ReportSpeakerMicStatus;
/*     */ import apollo.ReportSpeakerOnlineInfo;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import gnet.GDeliveryManager;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import xdb.Executor;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ public class ApolloInterface
/*     */ {
/*     */   public static void sendGetApolloInfo()
/*     */   {
/*  17 */     GetApolloInfoArg arg = new GetApolloInfoArg();
/*  18 */     arg.serverid = mzm.gsp.GameServerInfoManager.getZoneId();
/*  19 */     GetApolloInfo info = new GetApolloInfo(arg);
/*  20 */     if (!GDeliveryManager.getInstance().send(info))
/*     */     {
/*  22 */       onGetApolloInfoTimeout(info);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void onGetApolloInfoRsp(GetApolloInfo info)
/*     */   {
/*  28 */     apollo.GetApolloInfoRes res = (apollo.GetApolloInfoRes)info.getResult();
/*  29 */     if (res.retcode != 0)
/*     */     {
/*  31 */       onGetApolloInfoTimeout(info);
/*  32 */       return;
/*     */     }
/*  34 */     GetApolloInfoArg arg = (GetApolloInfoArg)info.getArgument();
/*  35 */     ApolloManager.onGetApolloInfoRsp(arg, res);
/*     */   }
/*     */   
/*     */   public static void onGetApolloInfoTimeout(GetApolloInfo info)
/*     */   {
/*  40 */     Xdb.executor().schedule(new Runnable()
/*     */     {
/*     */ 
/*     */       public void run()
/*     */       {
/*  45 */         if (!GDeliveryManager.getInstance().send(this.val$info))
/*     */         {
/*  47 */           Xdb.executor().schedule(this, 30L, TimeUnit.SECONDS); } } }, 30L, TimeUnit.SECONDS);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void onSSyncGlobalRoomInfo(apollo.SSyncGlobalRoomInfo info)
/*     */   {
/*  55 */     ApolloManager.onSSyncGlobalRoomInfo(info);
/*     */   }
/*     */   
/*     */   public static void onReportSpeakerOnlineInfoTimeout(ReportSpeakerOnlineInfo reportSpeakerOnlineInfo)
/*     */   {
/*  60 */     Xdb.executor().schedule(new Runnable()
/*     */     {
/*     */ 
/*     */       public void run()
/*     */       {
/*  65 */         if (!GDeliveryManager.getInstance().send(this.val$reportSpeakerOnlineInfo))
/*     */         {
/*  67 */           Xdb.executor().schedule(this, 30L, TimeUnit.SECONDS); } } }, 30L, TimeUnit.SECONDS);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void onReportSpeakerMicStatusTimeout(ReportSpeakerMicStatus reportSpeakerMicStatus)
/*     */   {
/*  75 */     Xdb.executor().schedule(new Runnable()
/*     */     {
/*     */ 
/*     */       public void run()
/*     */       {
/*  80 */         if (!GDeliveryManager.getInstance().send(this.val$reportSpeakerMicStatus))
/*     */         {
/*  82 */           Xdb.executor().schedule(this, 30L, TimeUnit.SECONDS); } } }, 30L, TimeUnit.SECONDS);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void onSyncReportSpeakerMicStatus(apollo.SyncReportSpeakerMicStatus info)
/*     */   {
/*  90 */     ApolloManager.onSyncReportSpeakerMicStatus(info);
/*     */   }
/*     */   
/*     */   public static void sendSyncApolloChatInfo(long sender, int roomType, Octets content)
/*     */   {
/*  95 */     if (!ChatToSpeakerIntervalChecker.getInstance().canSend())
/*     */     {
/*  97 */       return;
/*     */     }
/*     */     
/* 100 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(sender);
/* 101 */     ApolloManager.sendSyncApolloChatInfo(userid, roomType, content);
/*     */   }
/*     */   
/*     */   public static void onSyncApolloChatInfo(apollo.SyncApolloChatInfo info)
/*     */   {
/* 106 */     ApolloManager.onSyncApolloChatInfo(info);
/*     */   }
/*     */   
/*     */ 
/*     */   public static void onCollectGameServerApolloInfoReq(apollo.CollectGameServerApolloInfoArg arg, apollo.CollectGameServerApolloInfoRes res)
/*     */   {
/* 112 */     ApolloManager.onCollectGameServerApolloInfoReq(arg, res);
/*     */   }
/*     */   
/*     */   public static void onApolloCreateLargeRoomRsp(apollo.ApolloCreateLargeRoomRsp rsp)
/*     */   {
/* 117 */     ApolloManager.onApolloCreateLargeRoomRsp(rsp);
/*     */   }
/*     */   
/*     */   public static void onApolloEnterLargeRoomRsp(apollo.ApolloEnterLargeRoomRsp rsp)
/*     */   {
/* 122 */     ApolloManager.onApolloEnterLargeRoomRsp(rsp);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void onApolloCloseLargeRoomRsp(apollo.ApolloCloseLargeRoomRsp rsp) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public static void onApolloCheckLargeRoomExistRsp(apollo.ApolloCheckLargeRoomExistRsp rsp) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public static boolean sendApolloCreateVoipRoom(String userid, long roleid, Octets context)
/*     */   {
/* 137 */     return ApolloManager.createVoipRoom(userid, roleid, context);
/*     */   }
/*     */   
/*     */   public static void onApolloCreateVoipRoomRsp(apollo.ApolloCreateVoipRoomRsp rsp)
/*     */   {
/* 142 */     ApolloManager.onApolloCreateVoipRoomRsp(rsp);
/*     */   }
/*     */   
/*     */ 
/*     */   public static boolean sendApolloCloseVoipRoom(String userid, long roleid, long roomid, Octets context)
/*     */   {
/* 148 */     return ApolloManager.closeVoipRoom(userid, roleid, roomid, context);
/*     */   }
/*     */   
/*     */   public static void onApolloCloseVoipRoomRsp(apollo.ApolloCloseVoipRoomRsp rsp)
/*     */   {
/* 153 */     ApolloManager.onApolloCloseVoipRoomRsp(rsp);
/*     */   }
/*     */   
/*     */   public static boolean sendApolloJoinVoipRoom(String userid, long roleid, long roomid, Octets context)
/*     */   {
/* 158 */     return ApolloManager.joinVoipRoom(userid, roleid, roomid, context);
/*     */   }
/*     */   
/*     */   public static void onApolloJoinVoipRoomRsp(apollo.ApolloJoinVoipRoomRsp rsp)
/*     */   {
/* 163 */     ApolloManager.onApolloJoinVoipRoomRsp(rsp);
/*     */   }
/*     */   
/*     */ 
/*     */   public static boolean sendApolloExitVoipRoom(String userid, long roleid, long roomid, int memberid, Octets context)
/*     */   {
/* 169 */     return ApolloManager.exitVoipRoom(userid, roleid, roomid, memberid, context);
/*     */   }
/*     */   
/*     */   public static void onApolloExitVoipRoomRsp(apollo.ApolloExitVoipRoomRsp rsp)
/*     */   {
/* 174 */     ApolloManager.onApolloExitVoipRoomRsp(rsp);
/*     */   }
/*     */   
/*     */   public static void onApolloGetAuthKeyRsp(apollo.ApolloGetAuthKeyRsp rsp)
/*     */   {
/* 179 */     ApolloManager.onApolloGetAuthKeyRsp(rsp);
/*     */   }
/*     */   
/*     */   public static void onApolloSTTRsp(apollo.ApolloSTTRsp rsp)
/*     */   {
/* 184 */     ApolloManager.onApolloSTTRsp(rsp);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\ApolloInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */