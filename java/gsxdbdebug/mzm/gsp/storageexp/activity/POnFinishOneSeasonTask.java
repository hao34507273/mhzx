/*    */ package mzm.gsp.storageexp.activity;
/*    */ 
/*    */ import mzm.gsp.seasontask.event.FinishOneSeasonTaskProcedure;
/*    */ import mzm.gsp.seasontask.event.FinishOneTaskArg;
/*    */ import mzm.gsp.seasontask.main.SeasonTaskInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnFinishOneSeasonTask
/*    */   extends FinishOneSeasonTaskProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     return LostAwardManager.onActivityCountAdd(((FinishOneTaskArg)this.arg).getRoleId(), SeasonTaskInterface.getSeasonSingleActivityId(), ((FinishOneTaskArg)this.arg).getCount());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\storageexp\activity\POnFinishOneSeasonTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */