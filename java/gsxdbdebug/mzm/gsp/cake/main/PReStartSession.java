/*    */ package mzm.gsp.cake.main;
/*    */ 
/*    */ import mzm.gsp.activity4.confbean.SCakeActivityCfg;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.GlobalCakeData;
/*    */ 
/*    */ public class PReStartSession extends Session
/*    */ {
/*    */   private final int nextTurn;
/*    */   
/*    */   public PReStartSession(long interval, long activityId, int nextTurn)
/*    */   {
/* 14 */     super(interval, activityId);
/* 15 */     this.nextTurn = nextTurn;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 21 */     new OnRestartTimeOut((int)super.getOwerId()).execute();
/*    */   }
/*    */   
/*    */   private class OnRestartTimeOut
/*    */     extends LogicProcedure
/*    */   {
/*    */     private final int activityId;
/*    */     
/*    */     public OnRestartTimeOut(int activityId)
/*    */     {
/* 31 */       this.activityId = activityId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 37 */       SCakeActivityCfg activityCfg = SCakeActivityCfg.get(this.activityId);
/* 38 */       if (activityCfg == null)
/*    */       {
/* 40 */         CakeManager.loggerError("OnPrepareTimeOut.processImp@ SCakeActivityCfg is null!| activityId=%d", new Object[] { Integer.valueOf(this.activityId) });
/* 41 */         return false;
/*    */       }
/* 43 */       GlobalCakeData xGlobalCakeData = CakeManager.getXGlobalCakeData(this.activityId);
/* 44 */       if (xGlobalCakeData == null)
/*    */       {
/*    */ 
/* 47 */         return false;
/*    */       }
/* 49 */       xGlobalCakeData.setRecovery(false);
/* 50 */       return CakeManager.startCakeActivity(this.activityId, PReStartSession.this.nextTurn, mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis() + CakeManager.getNeedMillsPerTurn(activityCfg));
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\main\PReStartSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */