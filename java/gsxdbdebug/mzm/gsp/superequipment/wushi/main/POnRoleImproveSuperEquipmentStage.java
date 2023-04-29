/*   */ package mzm.gsp.superequipment.wushi.main;
/*   */ 
/*   */ import mzm.gsp.superequipment.event.SuperEquipmentStageImprovedArg;
/*   */ 
/*   */ public class POnRoleImproveSuperEquipmentStage extends mzm.gsp.superequipment.event.SuperEquipmentStageImprovedProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception {
/* 8 */     return WuShiManager.sendWuShiAward(((SuperEquipmentStageImprovedArg)this.arg).roleId);
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\wushi\main\POnRoleImproveSuperEquipmentStage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */