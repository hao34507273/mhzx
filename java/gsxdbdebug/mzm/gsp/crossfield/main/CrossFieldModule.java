/*     */ package mzm.gsp.crossfield.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.event.Module;
/*     */ import mzm.event.PostModuleInitListner;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CrossFieldModule
/*     */   implements Module, PostModuleInitListner
/*     */ {
/*     */   public int cleanupForMerge()
/*     */   {
/*  18 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int exit()
/*     */   {
/*  24 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int init(Map<String, String> envs)
/*     */   {
/*  30 */     String deadlineBeforeSeasonEndInMinute = (String)envs.get("deadline_before_season_end_in_minute");
/*  31 */     if (deadlineBeforeSeasonEndInMinute != null)
/*     */     {
/*     */       try
/*     */       {
/*  35 */         int param = Integer.parseInt(deadlineBeforeSeasonEndInMinute);
/*  36 */         CrossFieldManager.DEADLINE_BEFORE_SEASON_END_IN_MINUTE = param;
/*     */       }
/*     */       catch (NumberFormatException e)
/*     */       {
/*  40 */         throw new RuntimeException("deadline_before_season_end_in_minute format error");
/*     */       }
/*     */     }
/*  43 */     String grcMaxTryTimes = (String)envs.get("grc_max_try_times");
/*  44 */     if (grcMaxTryTimes != null)
/*     */     {
/*     */       try
/*     */       {
/*  48 */         int param = Integer.parseInt(grcMaxTryTimes);
/*  49 */         CrossFieldManager.GRC_MAX_TRY_TIMES = param;
/*     */       }
/*     */       catch (NumberFormatException e)
/*     */       {
/*  53 */         throw new RuntimeException("grc_max_try_times format error");
/*     */       }
/*     */     }
/*  56 */     String getRemoteRankMinDelayInSecond = (String)envs.get("get_remote_rank_min_delay_in_second");
/*  57 */     if (getRemoteRankMinDelayInSecond != null)
/*     */     {
/*     */       try
/*     */       {
/*  61 */         int param = Integer.parseInt(getRemoteRankMinDelayInSecond);
/*  62 */         CrossFieldManager.GET_REMOTE_RANK_MIN_DELAY_IN_SECOND = param;
/*     */       }
/*     */       catch (NumberFormatException e)
/*     */       {
/*  66 */         throw new RuntimeException("get_remote_rank_min_delay_in_second format error");
/*     */       }
/*     */     }
/*  69 */     String getRemoteRankMaxDelayInSecond = (String)envs.get("get_remote_rank_max_delay_in_second");
/*  70 */     if (getRemoteRankMaxDelayInSecond != null)
/*     */     {
/*     */       try
/*     */       {
/*  74 */         int param = Integer.parseInt(getRemoteRankMaxDelayInSecond);
/*  75 */         CrossFieldManager.GET_REMOTE_RANK_MAX_DELAY_IN_SECOND = param;
/*     */       }
/*     */       catch (NumberFormatException e)
/*     */       {
/*  79 */         throw new RuntimeException("get_remote_rank_max_delay_in_second format error");
/*     */       }
/*     */     }
/*  82 */     String resultBufferDurationInSecond = (String)envs.get("result_buffer_duration_in_second");
/*  83 */     if (resultBufferDurationInSecond != null)
/*     */     {
/*     */       try
/*     */       {
/*  87 */         int param = Integer.parseInt(resultBufferDurationInSecond);
/*  88 */         CrossFieldManager.RESULT_BUFFER_DURATION_IN_SECOND = param;
/*     */       }
/*     */       catch (NumberFormatException e)
/*     */       {
/*  92 */         throw new RuntimeException("result_buffer_duration_in_second format error");
/*     */       }
/*     */     }
/*  95 */     CrossFieldManager.init();
/*  96 */     SingleCrossFieldChartManager.getInstance().init();
/*  97 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int loadconf(Map<String, String> envs, int reloadcount)
/*     */   {
/* 103 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public void postInit()
/*     */   {
/* 109 */     SingleCrossFieldChartManager.getInstance().postInit();
/* 110 */     SingleCrossFieldSeasonManager.postInit();
/* 111 */     CrossFieldManager.postInit();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\CrossFieldModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */