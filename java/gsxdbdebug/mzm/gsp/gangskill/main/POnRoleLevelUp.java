/*    */ package mzm.gsp.gangskill.main;
/*    */ 
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ 
/*    */ public class POnRoleLevelUp extends mzm.gsp.role.event.RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     if (((RoleLevelUpArg)this.arg).newLevel >= mzm.gsp.skill.confbean.GangSkillConst.getInstance().ENABLE_GANG_SKILL_ROLE_LEVEL) {
/* 10 */       if (GangSkillManager.hasGangSkill(((RoleLevelUpArg)this.arg).roleId)) {
/* 11 */         return false;
/*    */       }
/*    */       
/* 14 */       for (java.util.Iterator i$ = GangSkillManager.getAllSkillids().iterator(); i$.hasNext();) { int skillid = ((Integer)i$.next()).intValue();
/* 15 */         GangSkillManager.addGangSkill(((RoleLevelUpArg)this.arg).roleId, skillid, 0);
/*    */       }
/* 17 */       GangSkillManager.triggerGankSkillChangedEvent(((RoleLevelUpArg)this.arg).roleId);
/*    */       
/* 19 */       GangSkillManager.synGangSkill(((RoleLevelUpArg)this.arg).roleId);
/*    */     }
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangskill\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */