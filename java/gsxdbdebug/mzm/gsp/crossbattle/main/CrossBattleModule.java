/*     */ package mzm.gsp.crossbattle.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.event.Module;
/*     */ import mzm.event.PostModuleInitListner;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.crossbattle.bet.CrossBattleBetInterface;
/*     */ import mzm.gsp.crossbattle.knockout.CrossBattleKnockoutInterface;
/*     */ import mzm.gsp.crossbattle.own.CrossBattleOwnInterface;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CrossBattleModule
/*     */   implements Module, PostModuleInitListner
/*     */ {
/*     */   public int cleanupForMerge()
/*     */   {
/*  23 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int exit()
/*     */   {
/*  29 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int init(Map<String, String> envs)
/*     */   {
/*  35 */     String grcRetryInterval = (String)envs.get("grc_retry_interval_in_second");
/*  36 */     if (grcRetryInterval != null)
/*     */     {
/*     */       try
/*     */       {
/*  40 */         int param = Integer.parseInt(grcRetryInterval);
/*  41 */         CrossBattleBetInterface.setGrcRetryInterval(param);
/*     */       }
/*     */       catch (NumberFormatException e)
/*     */       {
/*  45 */         throw new RuntimeException("grc_retry_interval_in_second format error");
/*     */       }
/*     */     }
/*  48 */     String grcMaxTryTimes = (String)envs.get("grc_max_try_times");
/*  49 */     if (grcMaxTryTimes != null)
/*     */     {
/*     */       try
/*     */       {
/*  53 */         int param = Integer.parseInt(grcMaxTryTimes);
/*  54 */         CrossBattleBetInterface.setGrcMaxTryTimes(param);
/*     */       }
/*     */       catch (NumberFormatException e)
/*     */       {
/*  58 */         throw new RuntimeException("grc_max_try_times format error");
/*     */       }
/*     */     }
/*  61 */     String grcMaxDelay = (String)envs.get("grc_max_delay_in_second");
/*  62 */     if (grcMaxDelay != null)
/*     */     {
/*     */       try
/*     */       {
/*  66 */         int param = Integer.parseInt(grcMaxDelay);
/*  67 */         CrossBattleBetInterface.setGrcMaxDelay(param);
/*     */       }
/*     */       catch (NumberFormatException e)
/*     */       {
/*  71 */         throw new RuntimeException("grc_max_delay_in_second format error");
/*     */       }
/*     */     }
/*  74 */     String getRemoteRankMinDelayInSecond = (String)envs.get("get_remote_rank_min_delay_in_second");
/*  75 */     if (getRemoteRankMinDelayInSecond != null)
/*     */     {
/*     */       try
/*     */       {
/*  79 */         int param = Integer.parseInt(getRemoteRankMinDelayInSecond);
/*  80 */         CrossBattleBetInterface.setGetRemoteRankMinDelayInSecond(param);
/*     */       }
/*     */       catch (NumberFormatException e)
/*     */       {
/*  84 */         throw new RuntimeException("get_remote_rank_min_delay_in_second format error");
/*     */       }
/*     */     }
/*  87 */     String getRemoteRankMaxDelayInSecond = (String)envs.get("get_remote_rank_max_delay_in_second");
/*  88 */     if (getRemoteRankMaxDelayInSecond != null)
/*     */     {
/*     */       try
/*     */       {
/*  92 */         int param = Integer.parseInt(getRemoteRankMaxDelayInSecond);
/*  93 */         CrossBattleBetInterface.setGetRemoteRankMaxDelayInSecond(param);
/*     */       }
/*     */       catch (NumberFormatException e)
/*     */       {
/*  97 */         throw new RuntimeException("get_remote_rank_max_delay_in_second format error");
/*     */       }
/*     */     }
/* 100 */     ActivityInterface.registerActivityByLogicType(97, new CrossBattleActivityHandler());
/* 101 */     CrossBattleManager.init();
/* 102 */     CrossBattleOwnInterface.init();
/* 103 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int loadconf(Map<String, String> envs, int reloadcount)
/*     */   {
/* 109 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public void postInit()
/*     */   {
/* 115 */     CrossBattleOwnInterface.postInit();
/* 116 */     CrossBattleBetInterface.postInit();
/* 117 */     CrossBattleKnockoutInterface.initCorpsRoleInfoReportObserver();
/* 118 */     CrossBattleKnockoutInterface.initFinalServerAward();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\main\CrossBattleModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */