/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.magicmark.event.MagicMarkPassiveSkillChangeEventProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnMagicMarkPassiveSkillChange
/*    */   extends MagicMarkPassiveSkillChangeEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     RoleOutFightObj outObj = RoleInterface.getRoleOutFightObject(((Long)this.arg).longValue());
/* 16 */     outObj.installPassiveSkill();
/* 17 */     outObj.syncClientRoleProperty();
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnMagicMarkPassiveSkillChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */