/*    */ package mzm.gsp.grow.LevelGuide;
/*    */ 
/*    */ import mzm.gsp.shimen.event.ShimenActivityArg;
/*    */ import mzm.gsp.shimen.event.ShimenActivityFinishedProcedure;
/*    */ import mzm.gsp.shimen.main.ShimenInterface;
/*    */ 
/*    */ public class POnShimenActivityFinished extends ShimenActivityFinishedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     int activityId = ShimenInterface.getShimenActivityId();
/* 12 */     return LevelGuideManager.finishActivity(((ShimenActivityArg)this.arg).getRoleid(), activityId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnShimenActivityFinished.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */