/*    */ package mzm.gsp.lifeskill.main;
/*    */ 
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ 
/*    */ public class POnRoleLevelUp extends mzm.gsp.role.event.RoleLevelUpProcedure {
/*    */   protected boolean processImp() throws Exception {
/*  7 */     xbean.RoleLifeSkill xRoleLifeSkill = xtable.Role2lifeskill.get(Long.valueOf(((RoleLevelUpArg)this.arg).roleId));
/*  8 */     if (xRoleLifeSkill != null) {
/*  9 */       return false;
/*    */     }
/* 11 */     LifeSkillManager.syncRoleLifeSkillList(((RoleLevelUpArg)this.arg).roleId);
/* 12 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lifeskill\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */