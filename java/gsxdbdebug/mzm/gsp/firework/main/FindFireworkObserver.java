/*    */ package mzm.gsp.firework.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.timer.main.DateObserver;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class FindFireworkObserver extends DateObserver
/*    */ {
/*    */   private final int activityId;
/*    */   private final int commonTimeCfgid;
/*    */   private final int controllerId;
/*    */   
/*    */   public FindFireworkObserver(int commonTimeCfgid, int activityCfgid, int controllerId)
/*    */   {
/* 15 */     super(commonTimeCfgid);
/*    */     
/* 17 */     this.commonTimeCfgid = commonTimeCfgid;
/* 18 */     this.activityId = activityCfgid;
/* 19 */     this.controllerId = controllerId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean onTimeOut()
/*    */   {
/* 25 */     new RRefresh(this.activityId, this.commonTimeCfgid, this.controllerId).execute();
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   private static class RRefresh extends LogicProcedure
/*    */   {
/*    */     private final int activityId;
/*    */     private final int commonTimeCfgid;
/*    */     private final int controllerId;
/*    */     
/*    */     public RRefresh(int activityCfgid, int commonTimeCfgid, int controllerId)
/*    */     {
/* 37 */       this.activityId = activityCfgid;
/* 38 */       this.commonTimeCfgid = commonTimeCfgid;
/* 39 */       this.controllerId = controllerId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 45 */       if (ActivityInterface.isActivityOpen(this.activityId))
/*    */       {
/* 47 */         FireworkManager.refreshFirework(this.activityId, this.controllerId);
/*    */       }
/* 49 */       FObserverManager.getInstance().remove(this.activityId, this.commonTimeCfgid);
/* 50 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\firework\main\FindFireworkObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */