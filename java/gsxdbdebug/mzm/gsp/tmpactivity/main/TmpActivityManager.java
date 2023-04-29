/*     */ package mzm.gsp.tmpactivity.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import mzm.gsp.activity.STmpActivityNormalResult;
/*     */ import mzm.gsp.activity.confbean.TmpActivityConsts;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ 
/*     */ 
/*     */ public class TmpActivityManager
/*     */ {
/*  13 */   static TmpActivityConsts consts = ;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getActivityId()
/*     */   {
/*  22 */     return consts.activityId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getJoinNpcId()
/*     */   {
/*  32 */     return consts.npcId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getServiceId()
/*     */   {
/*  42 */     return consts.serviceId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getGraphId()
/*     */   {
/*  52 */     return consts.graphId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean nearByNpc(long roleId, int npcId)
/*     */   {
/*  64 */     return MapInterface.isNearByNPC(roleId, npcId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int finishCount()
/*     */   {
/*  74 */     return 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getNpcControllerId()
/*     */   {
/*  84 */     return consts.npcControlId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getMailId()
/*     */   {
/*  94 */     return consts.mailId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void init() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sendNormalResult(long roleid, int result, String... args)
/*     */   {
/* 110 */     STmpActivityNormalResult pro = new STmpActivityNormalResult();
/* 111 */     pro.result = result;
/* 112 */     for (String arg : args)
/*     */     {
/* 114 */       pro.args.add(arg);
/*     */     }
/* 116 */     OnlineManager.getInstance().sendAtOnce(roleid, pro);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isTmpOpened(long roleId)
/*     */   {
/* 125 */     if (!OpenInterface.getOpenStatus(52)) {
/* 126 */       OpenInterface.sendCloseProtocol(roleId, 52, null);
/* 127 */       return false;
/*     */     }
/* 129 */     if (OpenInterface.isBanPlay(roleId, 52)) {
/* 130 */       OpenInterface.sendBanPlayMsg(roleId, 52);
/* 131 */       return false;
/*     */     }
/* 133 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\tmpactivity\main\TmpActivityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */