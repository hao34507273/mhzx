/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.factiontask.event.FinishOneTaskProcedure;
/*    */ import mzm.gsp.factiontask.event.TaskArg;
/*    */ 
/*    */ public class POnFinishFactionTask
/*    */   extends FinishOneTaskProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((TaskArg)this.arg).getRoleId(), 902, Integer.valueOf(1), "GangTaskFinish.updateState@handle GANG_TASK_FINISH success");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnFinishFactionTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */