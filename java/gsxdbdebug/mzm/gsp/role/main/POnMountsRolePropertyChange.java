/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.mounts.event.MountsRolePropertyChangeArg;
/*    */ import mzm.gsp.mounts.event.MountsRolePropertyChangeProcedure;
/*    */ import mzm.gsp.mounts.main.MountsInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnMountsRolePropertyChange
/*    */   extends MountsRolePropertyChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     RoleOutFightObj role = RoleInterface.getRoleOutFightObject(((MountsRolePropertyChangeArg)this.arg).getRoleId());
/* 18 */     role.setRidePro(MountsInterface.getCurrentMountsRoleProperty(((MountsRolePropertyChangeArg)this.arg).getRoleId(), true));
/* 19 */     role.installPassiveSkill();
/* 20 */     role.syncClientRoleProperty();
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnMountsRolePropertyChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */