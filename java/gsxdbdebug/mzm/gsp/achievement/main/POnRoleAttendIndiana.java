/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.indiana.event.RoleAttendIndianaArg;
/*    */ import mzm.gsp.indiana.event.RoleAttendIndianaProcedure;
/*    */ 
/*    */ 
/*    */ public class POnRoleAttendIndiana
/*    */   extends RoleAttendIndianaProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 13 */     if (((RoleAttendIndianaArg)this.arg).getMoneyType() == 1)
/*    */     {
/* 15 */       AchievementManager.updateGoalTypeState(((RoleAttendIndianaArg)this.arg).getRoleid(), 1513, Integer.valueOf(((RoleAttendIndianaArg)this.arg).getMoneyNum()), "POnRoleAttendIndiana.processImp@handle INDIANA_CONSUME_YUANBAO finish");
/*    */     }
/*    */     
/*    */ 
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnRoleAttendIndiana.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */