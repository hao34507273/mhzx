/*    */ package mzm.gsp.scochallenge.main;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.SSchoolChallengeCfgConsts;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     if ((!ScoChallengeManager.isSocSwitchOpenForRole(((Long)this.arg).longValue(), false)) || (!ActivityInterface.isActivityOpen(SSchoolChallengeCfgConsts.getInstance().ACTIVITYID)))
/*    */     {
/*    */ 
/*    */ 
/* 17 */       if (TaskInterface.isHaveGraphId(((Long)this.arg).longValue(), SSchoolChallengeCfgConsts.getInstance().GRAPH_ID))
/*    */       {
/* 19 */         TaskInterface.closeActivityGraphWithoutEvent(((Long)this.arg).longValue(), SSchoolChallengeCfgConsts.getInstance().GRAPH_ID);
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\scochallenge\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */