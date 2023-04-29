/*    */ package mzm.gsp.grow.LevelGuide;
/*    */ 
/*    */ import mzm.gsp.baotu.event.WaBaoArg;
/*    */ import mzm.gsp.baotu.event.WaBaoProcedure;
/*    */ import mzm.gsp.baotu.main.BaoTuInterface;
/*    */ 
/*    */ public class POnWaBao extends WaBaoProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     int activityId = BaoTuInterface.getBaotuActivityid();
/* 12 */     return LevelGuideManager.finishActivity(((WaBaoArg)this.arg).roleId, activityId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnWaBao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */