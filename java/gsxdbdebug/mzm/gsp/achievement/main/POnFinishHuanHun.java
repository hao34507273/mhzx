/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.HuanHunMiShuConsts;
/*    */ import mzm.gsp.huanhun.event.FinishHuanHunArg;
/*    */ import mzm.gsp.huanhun.event.FinishHuanHunProcedure;
/*    */ 
/*    */ public class POnFinishHuanHun
/*    */   extends FinishHuanHunProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     AchievementManager.updateGoalTypeState(((FinishHuanHunArg)this.arg).getRoleId(), 2400, Integer.valueOf(HuanHunMiShuConsts.getInstance().ACTIVITYID), "POnFinishHuanHun.processImp@handle ACTIVITY_JOIN finish");
/*    */     
/*    */ 
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnFinishHuanHun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */