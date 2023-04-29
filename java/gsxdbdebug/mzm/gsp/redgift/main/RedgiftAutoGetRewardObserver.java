/*    */ package mzm.gsp.redgift.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RedgiftAutoGetRewardObserver
/*    */   extends Observer
/*    */ {
/*    */   public RedgiftAutoGetRewardObserver(long intervalSeconds)
/*    */   {
/* 15 */     super(intervalSeconds);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 23 */     new PAutoGetRedgiftActivityRewardReq().execute();
/*    */     
/* 25 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\redgift\main\RedgiftAutoGetRewardObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */