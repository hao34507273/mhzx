/*    */ package mzm.gsp.breakegg.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ 
/*    */ public class BreakEggSession
/*    */   extends Session
/*    */ {
/*    */   private final List<Long> memberIds;
/*    */   
/*    */   public BreakEggSession(long interval, List<Long> memberIds)
/*    */   {
/* 14 */     super(interval, ((Long)memberIds.get(0)).longValue());
/* 15 */     this.memberIds = memberIds;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 22 */     new PGameFinished(this.memberIds).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\main\BreakEggSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */