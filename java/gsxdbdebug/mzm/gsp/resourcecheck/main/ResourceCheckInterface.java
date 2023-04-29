/*    */ package mzm.gsp.resourcecheck.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.resourcecheck.confbean.BindYuanbaoAwardWhiteList;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ResourceCheckInterface
/*    */ {
/*    */   public static boolean canAddBindYuanbaoByAward(LogReason logReason, int awardCfgid)
/*    */   {
/* 19 */     if (!OpenInterface.getOpenStatus(156))
/*    */     {
/* 21 */       return true;
/*    */     }
/*    */     
/* 24 */     BindYuanbaoAwardWhiteList cfg = BindYuanbaoAwardWhiteList.get(logReason.value);
/* 25 */     if (cfg == null)
/*    */     {
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     return cfg.award_cfgids.contains(Integer.valueOf(awardCfgid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean canAddBindYuanbaoByFixAward(LogReason logReason, int fixAwardCfgid)
/*    */   {
/* 43 */     if (!OpenInterface.getOpenStatus(156))
/*    */     {
/* 45 */       return true;
/*    */     }
/*    */     
/* 48 */     BindYuanbaoAwardWhiteList cfg = BindYuanbaoAwardWhiteList.get(logReason.value);
/* 49 */     if (cfg == null)
/*    */     {
/* 51 */       return false;
/*    */     }
/*    */     
/* 54 */     return cfg.fix_award_cfgids.contains(Integer.valueOf(fixAwardCfgid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean canAddBindYuanbaoByAwardPool(LogReason logReason, int awardPoolCfgid)
/*    */   {
/* 68 */     if (!OpenInterface.getOpenStatus(156))
/*    */     {
/* 70 */       return true;
/*    */     }
/*    */     
/* 73 */     BindYuanbaoAwardWhiteList cfg = BindYuanbaoAwardWhiteList.get(logReason.value);
/* 74 */     if (cfg == null)
/*    */     {
/* 76 */       return false;
/*    */     }
/*    */     
/* 79 */     return cfg.award_pool_cfgids.contains(Integer.valueOf(awardPoolCfgid));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\resourcecheck\main\ResourceCheckInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */