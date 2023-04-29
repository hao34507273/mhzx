/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.fashiondress.event.FashionDressPassiveSkillChangeProcedure;
/*    */ import mzm.gsp.fashiondress.event.PassiveSkillChangeArg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnDressPSkillChange
/*    */   extends FashionDressPassiveSkillChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     RoleOutFightObj outObj = RoleInterface.getRoleOutFightObject(((PassiveSkillChangeArg)this.arg).getRoleId());
/* 16 */     outObj.installPassiveSkill();
/* 17 */     outObj.syncClientRoleProperty();
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnDressPSkillChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */