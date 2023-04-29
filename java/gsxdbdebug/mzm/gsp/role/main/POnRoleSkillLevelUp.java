/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.skill.event.RoleSkillArg;
/*    */ 
/*    */ public class POnRoleSkillLevelUp extends mzm.gsp.skill.event.RoleSkillLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     RoleOutFightObj obj = new RoleOutFightObj(((RoleSkillArg)this.arg).roleId);
/* 10 */     obj.installPassiveSkill();
/* 11 */     obj.syncClientRoleProperty();
/* 12 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnRoleSkillLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */