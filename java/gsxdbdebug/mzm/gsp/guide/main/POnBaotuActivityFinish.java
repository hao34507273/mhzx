/*    */ package mzm.gsp.guide.main;
/*    */ 
/*    */ import mzm.gsp.baotu.event.BaoTuActivityArg;
/*    */ import mzm.gsp.baotu.event.BaoTuActivityFinishedProcedure;
/*    */ 
/*    */ public class POnBaotuActivityFinish
/*    */   extends BaoTuActivityFinishedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     GuideManager.activityGuideDeal(((BaoTuActivityArg)this.arg).getRoleid(), ((BaoTuActivityArg)this.arg).getActivityId(), ((BaoTuActivityArg)this.arg).getNewcount());
/*    */     
/* 13 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guide\main\POnBaotuActivityFinish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */