/*    */ package mzm.gsp.drawandguess.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DrawAndGuessBegainSession
/*    */   extends Session
/*    */ {
/*    */   private final List<Long> memberIds;
/*    */   private final int ruleId;
/*    */   private final DrawAndGuessContext context;
/*    */   
/*    */   public DrawAndGuessBegainSession(long interval, long drawerId, List<Long> memberIds, int ruleId, DrawAndGuessContext context)
/*    */   {
/* 18 */     super(interval, drawerId);
/*    */     
/* 20 */     this.memberIds = memberIds;
/* 21 */     this.ruleId = ruleId;
/* 22 */     this.context = context;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 29 */     new LogicProcedure()
/*    */     {
/*    */ 
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 35 */         DrawAndGuessInterface.startDrawAndGuess(DrawAndGuessBegainSession.this.getOwerId(), DrawAndGuessBegainSession.this.memberIds, DrawAndGuessBegainSession.this.ruleId, DrawAndGuessBegainSession.this.context);
/* 36 */         return true;
/*    */       }
/*    */     }.execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\main\DrawAndGuessBegainSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */