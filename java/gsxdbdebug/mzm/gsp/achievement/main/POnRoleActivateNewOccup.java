/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.multioccupation.event.ActivateNewOccupArg;
/*    */ import mzm.gsp.multioccupation.event.ActivateNewOccupProcedure;
/*    */ 
/*    */ public class POnRoleActivateNewOccup
/*    */   extends ActivateNewOccupProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((ActivateNewOccupArg)this.arg).roleid, 3304, Integer.valueOf(1), "POnRoleActivateNewOccup.processImp@handle MULTI_OCCUP_COUNT finish");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnRoleActivateNewOccup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */