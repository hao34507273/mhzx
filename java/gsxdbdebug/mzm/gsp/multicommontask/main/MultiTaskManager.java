/*     */ package mzm.gsp.multicommontask.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.SMultiLineTaskNormalRes;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity3.confbean.SMultiLineTaskCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class MultiTaskManager
/*     */ {
/*  18 */   private static String loggerTag = "[multitask]";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  23 */   private static Map<Integer, Set<Integer>> openId2activityIds = new HashMap();
/*     */   
/*     */   static
/*     */   {
/*  27 */     for (SMultiLineTaskCfg cfg : SMultiLineTaskCfg.getAll().values())
/*     */     {
/*  29 */       Set<Integer> activityIds = (Set)openId2activityIds.get(Integer.valueOf(cfg.openId));
/*  30 */       if (activityIds == null)
/*     */       {
/*  32 */         openId2activityIds.put(Integer.valueOf(cfg.openId), activityIds = new HashSet());
/*     */       }
/*  34 */       activityIds.add(Integer.valueOf(cfg.activityId));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Integer> getActivityIdsBy(int openId)
/*     */   {
/*  46 */     return (Set)openId2activityIds.get(Integer.valueOf(openId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getJoinMinLevel(int activityId)
/*     */   {
/*  57 */     return ActivityInterface.getActivityLevelMin(activityId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sendMultiTaskNotice(long roleid, boolean afterSuc, int result, String... args)
/*     */   {
/*  65 */     SMultiLineTaskNormalRes pro = new SMultiLineTaskNormalRes();
/*  66 */     pro.result = result;
/*  67 */     for (String arg : args)
/*     */     {
/*  69 */       pro.args.add(arg);
/*     */     }
/*  71 */     if (afterSuc)
/*     */     {
/*  73 */       OnlineManager.getInstance().send(roleid, pro);
/*     */     }
/*     */     else
/*     */     {
/*  77 */       OnlineManager.getInstance().sendAtOnce(roleid, pro);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isActivityValid(int activityId, int openId)
/*     */   {
/*  90 */     if (!OpenInterface.getOpenStatus(openId))
/*     */     {
/*  92 */       return false;
/*     */     }
/*  94 */     if (!ActivityInterface.isActivityOpen(activityId))
/*     */     {
/*  96 */       return false;
/*     */     }
/*  98 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void loggerError(String format, Object... args)
/*     */   {
/* 106 */     GameServer.logger().error(loggerTag + String.format(format, args));
/*     */   }
/*     */   
/*     */   static void loggerInfo(String format, Object... args)
/*     */   {
/* 111 */     GameServer.logger().info(loggerTag + String.format(format, args));
/*     */   }
/*     */   
/*     */   static void loggerDebug(String format, Object... args)
/*     */   {
/* 116 */     if (!GameServer.logger().isDebugEnabled())
/*     */     {
/* 118 */       return;
/*     */     }
/* 120 */     GameServer.logger().debug(loggerTag + String.format(format, args));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\multicommontask\main\MultiTaskManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */