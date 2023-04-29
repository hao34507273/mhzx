/*    */ package mzm.gsp.redgift.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.DateObserver;
/*    */ 
/*    */ 
/*    */ public class RedgiftStartObserver
/*    */   extends DateObserver
/*    */ {
/*    */   private int redgiftTimeCfgId;
/*    */   
/*    */   public RedgiftStartObserver(int redgiftTimeCfgId)
/*    */   {
/* 13 */     super(redgiftTimeCfgId);
/* 14 */     this.redgiftTimeCfgId = redgiftTimeCfgId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean onTimeOut()
/*    */   {
/* 20 */     new POnStartRedgift(this.redgiftTimeCfgId).execute();
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\redgift\main\RedgiftStartObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */