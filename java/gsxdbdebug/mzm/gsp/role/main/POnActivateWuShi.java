/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.superequipment.wushi.event.ActivateWuShiArg;
/*    */ import mzm.gsp.superequipment.wushi.event.ActivateWuShiProcedure;
/*    */ 
/*    */ public class POnActivateWuShi extends ActivateWuShiProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     RoleOutFightObj role = RoleInterface.getRoleOutFightObject(((ActivateWuShiArg)this.arg).roleId);
/* 12 */     role.setEquipPro(ItemInterface.getAllEquipmentProMap(((ActivateWuShiArg)this.arg).roleId));
/* 13 */     role.installPassiveSkill();
/* 14 */     role.syncClientRoleProperty();
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnActivateWuShi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */