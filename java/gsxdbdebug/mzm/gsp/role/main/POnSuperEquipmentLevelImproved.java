/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.superequipment.event.SuperEquipmentLevelImprovedArg;
/*    */ import mzm.gsp.superequipment.event.SuperEquipmentLevelImprovedProcedure;
/*    */ 
/*    */ public class POnSuperEquipmentLevelImproved extends SuperEquipmentLevelImprovedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     if (!((SuperEquipmentLevelImprovedArg)this.arg).isEquipped)
/*    */     {
/* 13 */       return false;
/*    */     }
/*    */     
/* 16 */     RoleOutFightObj role = RoleInterface.getRoleOutFightObject(((SuperEquipmentLevelImprovedArg)this.arg).roleId);
/* 17 */     role.setEquipPro(ItemInterface.getAllEquipmentProMap(((SuperEquipmentLevelImprovedArg)this.arg).roleId));
/* 18 */     role.installPassiveSkill();
/* 19 */     role.syncClientRoleProperty();
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnSuperEquipmentLevelImproved.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */