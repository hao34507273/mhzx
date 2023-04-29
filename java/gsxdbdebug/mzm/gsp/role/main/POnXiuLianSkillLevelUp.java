/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.xiulian.event.XiuLianSkillArg;
/*    */ 
/*    */ public class POnXiuLianSkillLevelUp extends mzm.gsp.xiulian.event.XiuLianSkillLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     RoleOutFightObj outFightObj = RoleInterface.getRoleOutFightObject(((XiuLianSkillArg)this.arg).roleId);
/* 10 */     outFightObj.installPassiveSkill();
/* 11 */     outFightObj.syncClientRoleProperty();
/* 12 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnXiuLianSkillLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */