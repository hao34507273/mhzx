/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.genius.event.GeniusSkillChangeArg;
/*    */ import mzm.gsp.genius.event.GeniusSkillChangeProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnGeniusSkillChange
/*    */   extends GeniusSkillChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     RoleOutFightObj outObj = RoleInterface.getRoleOutFightObject(((GeniusSkillChangeArg)this.arg).roleid);
/* 16 */     outObj.installPassiveSkill();
/* 17 */     outObj.syncClientRoleProperty();
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnGeniusSkillChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */