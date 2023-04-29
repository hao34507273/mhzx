/*     */ package mzm.gsp.indiana.main;
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
/*     */ public class IndianaModule
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
/*  30 */     IndianaManager.init();
/*  31 */     String refreshIntervalInSecond = (String)envs.get("refresh_interval_in_second");
/*  32 */     if (refreshIntervalInSecond != null)
/*     */     {
/*     */       try
/*     */       {
/*  36 */         int param = Integer.parseInt(refreshIntervalInSecond);
/*  37 */         IndianaManager.REFRESH_INTERVAL_IN_SECOND = param;
/*     */       }
/*     */       catch (NumberFormatException e)
/*     */       {
/*  41 */         throw new RuntimeException("refresh_interval_in_second format error");
/*     */       }
/*     */     }
/*  44 */     String maxAwardNumberNum = (String)envs.get("max_award_number_num");
/*  45 */     if (maxAwardNumberNum != null)
/*     */     {
/*     */       try
/*     */       {
/*  49 */         int param = Integer.parseInt(maxAwardNumberNum);
/*  50 */         IndianaManager.MAX_AWARD_NUMBER_NUM = param;
/*     */       }
/*     */       catch (NumberFormatException e)
/*     */       {
/*  54 */         throw new RuntimeException("max_award_number_num format error");
/*     */       }
/*     */     }
/*  57 */     String maxLogNum = (String)envs.get("max_log_num");
/*  58 */     if (maxLogNum != null)
/*     */     {
/*     */       try
/*     */       {
/*  62 */         int param = Integer.parseInt(maxLogNum);
/*  63 */         IndianaManager.MAX_LOG_NUM = param;
/*     */       }
/*     */       catch (NumberFormatException e)
/*     */       {
/*  67 */         throw new RuntimeException("max_log_num format error");
/*     */       }
/*     */     }
/*  70 */     String grcMinDelayInSecond = (String)envs.get("grc_min_delay_in_second");
/*  71 */     if (grcMinDelayInSecond != null)
/*     */     {
/*     */       try
/*     */       {
/*  75 */         int param = Integer.parseInt(grcMinDelayInSecond);
/*  76 */         IndianaManager.GRC_MIN_DELAY_IN_SECOND = param;
/*     */       }
/*     */       catch (NumberFormatException e)
/*     */       {
/*  80 */         throw new RuntimeException("grc_min_delay_in_second format error");
/*     */       }
/*     */     }
/*  83 */     String grcMaxDelayInSecond = (String)envs.get("grc_max_delay_in_second");
/*  84 */     if (grcMaxDelayInSecond != null)
/*     */     {
/*     */       try
/*     */       {
/*  88 */         int param = Integer.parseInt(grcMaxDelayInSecond);
/*  89 */         IndianaManager.GRC_MAX_DELAY_IN_SECOND = param;
/*     */       }
/*     */       catch (NumberFormatException e)
/*     */       {
/*  93 */         throw new RuntimeException("grc_max_delay_in_second format error");
/*     */       }
/*     */     }
/*  96 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int loadconf(Map<String, String> envs, int reloadcount)
/*     */   {
/* 102 */     return 0;
/*     */   }
/*     */   
/*     */   public void postInit() {}
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\main\IndianaModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */