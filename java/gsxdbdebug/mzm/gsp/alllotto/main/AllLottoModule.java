/*     */ package mzm.gsp.alllotto.main;
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
/*     */ public class AllLottoModule
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
/*  30 */     AllLottoManager.init();
/*  31 */     String maxLogNum = (String)envs.get("max_log_num");
/*  32 */     if (maxLogNum != null)
/*     */     {
/*     */       try
/*     */       {
/*  36 */         int param = Integer.parseInt(maxLogNum);
/*  37 */         AllLottoManager.MAX_LOG_NUM = param;
/*     */       }
/*     */       catch (NumberFormatException e)
/*     */       {
/*  41 */         throw new RuntimeException("max_log_num format error");
/*     */       }
/*     */     }
/*  44 */     String sendAwardDelayInSecond = (String)envs.get("send_award_delay_in_second");
/*  45 */     if (sendAwardDelayInSecond != null)
/*     */     {
/*     */       try
/*     */       {
/*  49 */         int param = Integer.parseInt(sendAwardDelayInSecond);
/*  50 */         AllLottoManager.SEND_AWARD_DELAY_IN_SECOND = param;
/*     */       }
/*     */       catch (NumberFormatException e)
/*     */       {
/*  54 */         throw new RuntimeException("send_award_delay_in_second format error");
/*     */       }
/*     */     }
/*  57 */     String turnProtectDurationInSecond = (String)envs.get("turn_protect_duration_in_second");
/*  58 */     if (turnProtectDurationInSecond != null)
/*     */     {
/*     */       try
/*     */       {
/*  62 */         int param = Integer.parseInt(turnProtectDurationInSecond);
/*  63 */         AllLottoManager.TURN_PROTECT_DURATION_IN_SECOND = param;
/*     */       }
/*     */       catch (NumberFormatException e)
/*     */       {
/*  67 */         throw new RuntimeException("turn_protect_duration_in_second format error");
/*     */       }
/*     */     }
/*  70 */     String grcMinDelayInSecond = (String)envs.get("grc_min_delay_in_second");
/*  71 */     if (grcMinDelayInSecond != null)
/*     */     {
/*     */       try
/*     */       {
/*  75 */         int param = Integer.parseInt(grcMinDelayInSecond);
/*  76 */         AllLottoManager.GRC_MIN_DELAY_IN_SECOND = param;
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
/*  89 */         AllLottoManager.GRC_MAX_DELAY_IN_SECOND = param;
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\alllotto\main\AllLottoModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */