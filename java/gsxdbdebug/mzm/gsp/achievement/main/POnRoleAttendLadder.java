/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.ladder.event.RoleAttendLadderArg;
/*    */ import mzm.gsp.ladder.event.RoleAttendLadderProcedure;
/*    */ 
/*    */ public class POnRoleAttendLadder
/*    */   extends RoleAttendLadderProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((RoleAttendLadderArg)this.arg).getRoleid(), 6000, Integer.valueOf(1), "POnRoleAttendLadder.processImp@handle LADDER_ATTEND_COUNT finish");
/*    */     
/*    */ 
/*    */ 
/* 15 */     if (((RoleAttendLadderArg)this.arg).isWin())
/*    */     {
/* 17 */       AchievementManager.updateGoalTypeState(((RoleAttendLadderArg)this.arg).getRoleid(), 6001, Integer.valueOf(1), "POnRoleAttendLadder.processImp@handle LADDER_WIN_COUNT finish");
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 22 */       AchievementManager.updateGoalTypeState(((RoleAttendLadderArg)this.arg).getRoleid(), 6002, Integer.valueOf(1), "POnRoleAttendLadder.processImp@handle LADDER_LOSE_COUNT finish");
/*    */     }
/*    */     
/*    */ 
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnRoleAttendLadder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */