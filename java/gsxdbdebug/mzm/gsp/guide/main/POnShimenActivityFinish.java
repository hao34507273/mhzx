/*    */ package mzm.gsp.guide.main;
/*    */ 
/*    */ import mzm.gsp.shimen.event.ShimenActivityArg;
/*    */ import mzm.gsp.shimen.event.ShimenActivityFinishedProcedure;
/*    */ 
/*    */ public class POnShimenActivityFinish
/*    */   extends ShimenActivityFinishedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     GuideManager.activityGuideDeal(((ShimenActivityArg)this.arg).getRoleid(), ((ShimenActivityArg)this.arg).getActivityId(), ((ShimenActivityArg)this.arg).getNewcount());
/*    */     
/* 13 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guide\main\POnShimenActivityFinish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */