/*    */ package mzm.gsp.makeup.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity4.confbean.SMakeUpActivityCfg;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.GlobalMakeUpInfo;
/*    */ 
/*    */ public class SendQuestionObserver
/*    */   extends Observer
/*    */ {
/*    */   private final int activityId;
/*    */   
/*    */   public SendQuestionObserver(long intervalSeconds, int activityId)
/*    */   {
/* 17 */     super(intervalSeconds);
/* 18 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 24 */     new SendQuestion(this.activityId).execute();
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   private class SendQuestion extends LogicProcedure
/*    */   {
/*    */     private int activityId;
/*    */     
/*    */     public SendQuestion(int activityId)
/*    */     {
/* 34 */       this.activityId = activityId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 40 */       SMakeUpActivityCfg cfg = SMakeUpActivityCfg.get(this.activityId);
/* 41 */       if (cfg == null)
/*    */       {
/* 43 */         MakeUpManager.loggerError("StartQuestion.processImp@SMakeUpActivityCfg is null!|activityId=%d", new Object[] { Integer.valueOf(this.activityId) });
/* 44 */         return false;
/*    */       }
/*    */       
/* 47 */       GlobalMakeUpInfo xGlobalMakeupInfo = MakeUpManager.getGlobalMakeupInfo(this.activityId);
/* 48 */       if (xGlobalMakeupInfo == null)
/*    */       {
/* 50 */         return false;
/*    */       }
/* 52 */       if ((!ActivityInterface.isActivityOpen(cfg.activityId)) || (xGlobalMakeupInfo.getTurn() >= cfg.turn - 1) || (!OpenInterface.getOpenStatus(cfg.switchId)))
/*    */       {
/*    */ 
/* 55 */         MakeUpManager.loggerInfo("--question observer stop!|activity=%d|turn=%d", new Object[] { Integer.valueOf(this.activityId), Integer.valueOf(xGlobalMakeupInfo.getTurn()) });
/*    */         
/*    */ 
/* 58 */         MakeUpObserverManager.getInstance().stopObserver(this.activityId);
/*    */         
/* 60 */         xGlobalMakeupInfo.setQuetioning(false);
/*    */ 
/*    */       }
/*    */       else
/*    */       {
/* 65 */         xGlobalMakeupInfo.setTurn(xGlobalMakeupInfo.getTurn() + 1);
/*    */       }
/* 67 */       MakeUpManager.loggerInfo("--send question!|activity=%d|turn=%d", new Object[] { Integer.valueOf(this.activityId), Integer.valueOf(xGlobalMakeupInfo.getTurn()) });
/*    */       
/* 69 */       MakeUpManager.sendQuestion(this.activityId, PrepareSession.PrepareReason.ACTIVITY_NORMAL);
/* 70 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\makeup\main\SendQuestionObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */