/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.item.event.PlayerEquipChangeProcedure;
/*    */ import mzm.gsp.item.main.EquipChangeArg;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ 
/*    */ public class POnPlayerEquipChange
/*    */   extends PlayerEquipChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     RoleOutFightObj role = RoleInterface.getRoleOutFightObject(((EquipChangeArg)this.arg).roleId);
/*    */     
/* 14 */     role.setEquipPro(ItemInterface.getAllEquipmentProMap(((EquipChangeArg)this.arg).roleId));
/* 15 */     role.installPassiveSkill();
/* 16 */     role.syncClientRoleProperty();
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnPlayerEquipChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */