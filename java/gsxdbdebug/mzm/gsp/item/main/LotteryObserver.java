/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ class LotteryObserver extends Session
/*    */ {
/*    */   private int lotterytype;
/*    */   
/*    */   public LotteryObserver(long interval, long roleId, int lotterytype)
/*    */   {
/* 11 */     super(interval, roleId);
/* 12 */     this.lotterytype = lotterytype;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 19 */     new POfferLotteryResult(getOwerId(), this.lotterytype).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\LotteryObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */