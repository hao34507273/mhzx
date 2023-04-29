/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.role.event.FightValueChangeProcedure;
/*    */ import mzm.gsp.role.event.RoleXFightValueChangeArg;
/*    */ 
/*    */ public class POnRoleFightValueChange
/*    */   extends FightValueChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     long roleId = ((RoleXFightValueChangeArg)this.arg).getRoleId();
/* 12 */     int newFightValue = ((RoleXFightValueChangeArg)this.arg).getNewFightValue();
/*    */     
/* 14 */     AchievementManager.updateGoalTypeState(roleId, 3303, Integer.valueOf(newFightValue), "POnRoleFightValueChange.processImp@handle FIGHT_VALUE_IMPROVE success");
/*    */     
/*    */ 
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnRoleFightValueChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */