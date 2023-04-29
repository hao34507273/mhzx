/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.superequipment.jewel.event.MountSuperEquipmentJewelArg;
/*    */ import mzm.gsp.superequipment.jewel.event.MountSuperEquipmentJewelProcedure;
/*    */ 
/*    */ public class POnMountSuperEquipmentJewel
/*    */   extends MountSuperEquipmentJewelProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     RoleOutFightObj role = RoleInterface.getRoleOutFightObject(((MountSuperEquipmentJewelArg)this.arg).roleId);
/* 13 */     role.setEquipPro(ItemInterface.getAllEquipmentProMap(((MountSuperEquipmentJewelArg)this.arg).roleId));
/* 14 */     role.installPassiveSkill();
/* 15 */     role.syncClientRoleProperty();
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnMountSuperEquipmentJewel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */