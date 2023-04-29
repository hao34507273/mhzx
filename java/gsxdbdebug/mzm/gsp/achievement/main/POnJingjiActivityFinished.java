/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.jingji.event.JingjiActivityArg;
/*    */ import mzm.gsp.jingji.event.JingjiActivityFinishedProcedure;
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
/* 15 */     AchievementManager.updateGoalTypeState(((JingjiActivityArg)this.arg).getRoleid(), 2400, Integer.valueOf(((JingjiActivityArg)this.arg).getActivityId()), "POnJingjiActivityFinished.processImp@handle ACTIVITY_JOIN finish");
/*    */     
/*    */ 
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnJingjiActivityFinished.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */