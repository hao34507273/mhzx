/*    */ package mzm.gsp.drawandguess.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ 
/*    */ public class DrawAndGuessGameSession
/*    */   extends Session
/*    */ {
/*    */   private final long drawandguessId;
/*    */   private final List<Long> memberIds;
/*    */   
/*    */   public DrawAndGuessGameSession(long interval, long drawandguessId, List<Long> memberIds)
/*    */   {
/* 15 */     super(interval, drawandguessId);
/*    */     
/* 17 */     this.drawandguessId = drawandguessId;
/* 18 */     this.memberIds = memberIds;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 25 */     new PGameFinished(this.drawandguessId, this.memberIds).execute();
/*    */   }
/*    */   
/*    */ 
/*    */   public long getDrawandguessId()
/*    */   {
/* 31 */     return this.drawandguessId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\main\DrawAndGuessGameSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */