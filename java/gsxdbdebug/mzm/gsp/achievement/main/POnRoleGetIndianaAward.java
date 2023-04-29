/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.indiana.event.RoleGetIndianaAwardArg;
/*    */ import mzm.gsp.indiana.event.RoleGetIndianaAwardProcedure;
/*    */ 
/*    */ public class POnRoleGetIndianaAward
/*    */   extends RoleGetIndianaAwardProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((RoleGetIndianaAwardArg)this.arg).getRoleid(), 1512, Integer.valueOf(1), "POnRoleGetIndianaAward.processImp@handle INDIANA_SUCCESS finish");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnRoleGetIndianaAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */