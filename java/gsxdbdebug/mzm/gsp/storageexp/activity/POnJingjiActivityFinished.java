/*    */ package mzm.gsp.storageexp.activity;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.JingjiActivityCfgConsts;
/*    */ import mzm.gsp.jingji.event.JingjiActivityArg;
/*    */ import mzm.gsp.jingji.event.JingjiActivityFinishedProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnJingjiActivityFinished
/*    */   extends JingjiActivityFinishedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     return LostAwardManager.onActivityCountAdd(((JingjiActivityArg)this.arg).getRoleid(), JingjiActivityCfgConsts.getInstance().ACTIVITYID, ((JingjiActivityArg)this.arg).getActivityCount());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\storageexp\activity\POnJingjiActivityFinished.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */