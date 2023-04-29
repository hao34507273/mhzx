/*    */ package mzm.gsp.cake.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity4.confbean.SCakeActivityCfg;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PPrepareSession
/*    */   extends Session
/*    */ {
/*    */   public PPrepareSession(long interval, int activityId)
/*    */   {
/* 21 */     super(interval, activityId);
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 27 */     new OnPrepareTimeOut((int)super.getOwerId()).execute();
/*    */   }
/*    */   
/*    */   private class OnPrepareTimeOut extends LogicProcedure
/*    */   {
/*    */     private final int activityId;
/*    */     
/*    */     public OnPrepareTimeOut(int activityId)
/*    */     {
/* 36 */       this.activityId = activityId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 42 */       CakeManager.loggerInfo("--cake time!|activityId=%d", new Object[] { Integer.valueOf(this.activityId) });
/*    */       
/* 44 */       SCakeActivityCfg activityCfg = SCakeActivityCfg.get(this.activityId);
/* 45 */       if (activityCfg == null)
/*    */       {
/* 47 */         CakeManager.loggerError("OnPrepareTimeOut.processImp@ SCakeActivityCfg is null!|activityId=%d", new Object[] { Integer.valueOf(this.activityId) });
/* 48 */         return false;
/*    */       }
/* 50 */       if (!ActivityInterface.isActivityOpen(this.activityId))
/*    */       {
/* 52 */         CakeManager.loggerError("OnPrepareTimeOut.processImp@ activity is closed!|activityId=%d", new Object[] { Integer.valueOf(this.activityId) });
/* 53 */         return false;
/*    */       }
/* 55 */       if (!OpenInterface.getOpenStatus(activityCfg.switchId))
/*    */       {
/* 57 */         CakeManager.loggerError("OnPrepareTimeOut.processImp@ activity's switch is closed!|activityId=%d|switchId=%d", new Object[] { Integer.valueOf(this.activityId), Integer.valueOf(activityCfg.switchId) });
/*    */         
/* 59 */         return false;
/*    */       }
/* 61 */       return CakeManager.startCakeActivity(this.activityId, 1, DateTimeUtils.getCurrTimeInMillis() + CakeManager.getNeedMillsPerTurn(activityCfg));
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\main\PPrepareSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */