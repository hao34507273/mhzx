/*    */ package mzm.gsp.grow.LevelGuide;
/*    */ 
/*    */ import mzm.gsp.bounty.event.FinishOneTaskArg;
/*    */ import mzm.gsp.bounty.event.FinishOneTaskProcedure;
/*    */ import mzm.gsp.bounty.main.BountyInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnFinishOneTask
/*    */   extends FinishOneTaskProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     int activityId = BountyInterface.getBountyActivityId();
/* 18 */     return LevelGuideManager.finishActivity(((FinishOneTaskArg)this.arg).getRoleId(), activityId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnFinishOneTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */