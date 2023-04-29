/*    */ package mzm.gsp.mysteryshop.main;
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
/*    */ 
/*    */ public class MysteryShopResetObserver
/*    */   extends DateObserver
/*    */ {
/*    */   final int shopType;
/*    */   
/*    */   public MysteryShopResetObserver(final int shopType)
/*    */   {
/* 22 */     super(MysteryShopManager.getRefreshtimeByMysterytype(shopType));
/* 23 */     this.shopType = shopType;
/*    */     
/*    */ 
/* 26 */     new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 31 */         long now = DateTimeUtils.getCurrTimeInMillis();
/* 32 */         STimeCommonCfg timeCommonCfg = TimeCommonUtil.getCommonCfg(MysteryShopManager.getRefreshtimeByMysterytype(shopType));
/* 33 */         if (DateTimeUtils.needDailyReset(MysteryShopManager.getMysteryShopResetTime(shopType), now, timeCommonCfg.activeHour, timeCommonCfg.activeMinute)) {
/* 34 */           MysteryShopManager.setMysteryShopResetTime(shopType, now);
/*    */         }
/* 36 */         return true;
/*    */       }
/*    */     }.call();
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean onTimeOut()
/*    */   {
/* 44 */     long cur = DateTimeUtils.getCurrTimeInMillis();
/*    */     
/* 46 */     new UpdateMysteryResetTime(this.shopType, cur).execute();
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mysteryshop\main\MysteryShopResetObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */