/*    */ package mzm.gsp.skill.main;
/*    */ 
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ 
/*    */ public class POnRoleLevelUp extends mzm.gsp.role.event.RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     if (((RoleLevelUpArg)this.arg).newLevel < mzm.gsp.skill.confbean.SkillConsts.getInstance().OPENLEVEL) {
/* 10 */       return false;
/*    */     }
/* 12 */     MenPaiSkillBagManager.getInstance().openFunction(((RoleLevelUpArg)this.arg).roleId);
/* 13 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */