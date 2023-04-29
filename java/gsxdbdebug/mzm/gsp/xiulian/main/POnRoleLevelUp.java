/*    */ package mzm.gsp.xiulian.main;
/*    */ 
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import mzm.gsp.role.event.RoleLevelUpProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.skill.confbean.XiuLianSkillConsts;
/*    */ 
/*    */ public class POnRoleLevelUp extends RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     if (RoleInterface.getLevel(((RoleLevelUpArg)this.arg).roleId) < XiuLianSkillConsts.getInstance().OPEN_LEVEL) {
/* 13 */       return false;
/*    */     }
/* 15 */     if (XiuLianSkillManager.tryOpenFunction(((RoleLevelUpArg)this.arg).roleId)) {
/* 16 */       XiuLianSkillManager.syncXiuLianInfo(((RoleLevelUpArg)this.arg).roleId);
/*    */     } else {
/* 18 */       java.util.List<XiuLianSkill> skillList = XiuLianSkillInterface.getXiuLianSkill(((RoleLevelUpArg)this.arg).roleId, -1, true);
/* 19 */       for (XiuLianSkill skill : skillList) {
/* 20 */         skill.autoLevelUp();
/*    */       }
/*    */     }
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiulian\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */