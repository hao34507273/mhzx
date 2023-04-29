/*    */ package mzm.gsp.superequipment.wushi.main;
/*    */ 
/*    */ import mzm.gsp.superequipment.wushi.event.PutOnSuperEquipmentWuShiArg;
/*    */ import mzm.gsp.team.main.POnRoleWuShiAppearanceChanged;
/*    */ 
/*    */ public class POnPutOnSuperEquipmentWuShi extends mzm.gsp.superequipment.wushi.event.PutOnSuperEquipmentWuShiProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     new POnRoleWuShiAppearanceChanged(((PutOnSuperEquipmentWuShiArg)this.arg).roleId).execute();
/* 11 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\wushi\main\POnPutOnSuperEquipmentWuShi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */