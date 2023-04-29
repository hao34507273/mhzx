/*    */ package mzm.gsp.task.surprise;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class SurpriseItemStartSession
/*    */   extends Session
/*    */ {
/* 11 */   private final Set<Integer> serverIds = new HashSet();
/*    */   
/*    */   public SurpriseItemStartSession(long interval, int activityId, Set<Integer> serverIds)
/*    */   {
/* 15 */     super(interval, activityId);
/* 16 */     serverIds.addAll(serverIds);
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 22 */     new POnStartSurprise((int)super.getOwerId()).execute();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private class POnStartSurprise
/*    */     extends LogicProcedure
/*    */   {
/*    */     private final int activityId;
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */     public POnStartSurprise(int activityId)
/*    */     {
/* 38 */       this.activityId = activityId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 44 */       SurpriseTaskManager.triggerControllers(SurpriseItemStartSession.this.serverIds);
/* 45 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\surprise\SurpriseItemStartSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */