/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.superequipment.jewel.event.UnMountSuperEquipmentJewelArg;
/*    */ import mzm.gsp.superequipment.jewel.event.UnMountSuperEquipmentJewelProcedure;
/*    */ 
/*    */ public class POnUnMountSuperEquipmentJewel
/*    */   extends UnMountSuperEquipmentJewelProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     RoleOutFightObj role = RoleInterface.getRoleOutFightObject(((UnMountSuperEquipmentJewelArg)this.arg).roleId);
/* 13 */     role.setEquipPro(ItemInterface.getAllEquipmentProMap(((UnMountSuperEquipmentJewelArg)this.arg).roleId));
/* 14 */     role.installPassiveSkill();
/* 15 */     role.syncClientRoleProperty();
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnUnMountSuperEquipmentJewel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */