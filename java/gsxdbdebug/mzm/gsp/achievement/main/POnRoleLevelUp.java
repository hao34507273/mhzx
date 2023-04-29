/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import mzm.gsp.role.event.RoleLevelUpProcedure;
/*    */ 
/*    */ public class POnRoleLevelUp
/*    */   extends RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     DouDouSongLiActivityHandler.synDouDouSongLiInfo(((RoleLevelUpArg)this.arg).roleId);
/*    */     
/*    */ 
/* 14 */     AchievementManager.updateGoalTypeState(((RoleLevelUpArg)this.arg).roleId, 4500, Integer.valueOf(((RoleLevelUpArg)this.arg).newLevel), "POnRoleLevelUp.processImp@handle ROLE_LEVEL_UP success");
/*    */     
/*    */ 
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */