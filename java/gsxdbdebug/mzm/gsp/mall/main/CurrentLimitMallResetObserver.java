/*    */ package mzm.gsp.mall.main;
/*    */ 
/*    */ import mzm.gsp.common.TimeCommonUtil;
/*    */ import mzm.gsp.common.confbean.STimeCommonCfg;
/*    */ import mzm.gsp.timer.main.DateObserver;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CurrentLimitMallResetObserver
/*    */   extends DateObserver
/*    */ {
/*    */   final int shopType;
/*    */   
/*    */   public CurrentLimitMallResetObserver(final int shopType)
/*    */   {
/* 21 */     super(MallManager.getRefreshtimeByMalltype(shopType));
/* 22 */     this.shopType = shopType;
/*    */     
/*    */ 
/* 25 */     new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 30 */         long now = DateTimeUtils.getCurrTimeInMillis();
/* 31 */         STimeCommonCfg timeCommonCfg = TimeCommonUtil.getCommonCfg(MallManager.getRefreshtimeByMalltype(shopType));
/* 32 */         if (DateTimeUtils.needDailyReset(MallManager.getMallRefreshTime(shopType), now, timeCommonCfg.activeHour, timeCommonCfg.activeMinute)) {
/* 33 */           MallManager.setMallRefreshTime(shopType, now);
/*    */         }
/* 35 */         return true;
/*    */       }
/*    */     }.call();
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean onTimeOut()
/*    */   {
/* 43 */     long cur = DateTimeUtils.getCurrTimeInMillis();
/*    */     
/* 45 */     new UpdateMallFreshtime(this.shopType, cur).execute();
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   private static class UpdateMallFreshtime extends LogicProcedure
/*    */   {
/*    */     private final int shopType;
/*    */     private long cur;
/*    */     
/*    */     public UpdateMallFreshtime(int shopType, long cur)
/*    */     {
/* 56 */       this.shopType = shopType;
/* 57 */       this.cur = cur;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 63 */       MallManager.setMallRefreshTime(this.shopType, this.cur);
/* 64 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\main\CurrentLimitMallResetObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */