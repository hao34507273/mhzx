/*    */ package mzm.gsp.activity.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ class BeforeActivityStartStageSession extends Session
/*    */ {
/*    */   private long triggerTime;
/*    */   private int stage;
/*    */   
/*    */   public BeforeActivityStartStageSession(int activityid, int stageIndex, long triggerTime, long interval)
/*    */   {
/* 13 */     super(interval, activityid);
/* 14 */     this.stage = stageIndex;
/* 15 */     this.triggerTime = triggerTime;
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 20 */     xdb.Procedure.execute(new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 24 */         int activityid = (int)BeforeActivityStartStageSession.this.getOwerId();
/*    */         
/* 26 */         if (ActivityInterface.isActivityOpen(activityid)) {
/* 27 */           return false;
/*    */         }
/* 29 */         NoneRealTimeTaskManager.getInstance().addTask(new BeforeActivityStartStageProcedure(activityid, BeforeActivityStartStageSession.this.stage, BeforeActivityStartStageSession.this.triggerTime));
/*    */         
/* 31 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\BeforeActivityStartStageSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */