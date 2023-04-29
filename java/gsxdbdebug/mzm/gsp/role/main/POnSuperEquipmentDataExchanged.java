/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.superequipment.event.SuperEquipmentDataExchangedArg;
/*    */ import mzm.gsp.superequipment.event.SuperEquipmentDataExchangedProcedure;
/*    */ 
/*    */ public class POnSuperEquipmentDataExchanged extends SuperEquipmentDataExchangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     RoleOutFightObj role = RoleInterface.getRoleOutFightObject(((SuperEquipmentDataExchangedArg)this.arg).roleId);
/* 12 */     role.setEquipPro(ItemInterface.getAllEquipmentProMap(((SuperEquipmentDataExchangedArg)this.arg).roleId));
/* 13 */     role.installPassiveSkill();
/* 14 */     role.syncClientRoleProperty();
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnSuperEquipmentDataExchanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */