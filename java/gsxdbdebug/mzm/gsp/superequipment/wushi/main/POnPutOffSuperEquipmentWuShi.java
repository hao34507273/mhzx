/*    */ package mzm.gsp.superequipment.wushi.main;
/*    */ 
/*    */ import mzm.gsp.superequipment.wushi.event.PutOffSuperEquipmentWuShiArg;
/*    */ import mzm.gsp.team.main.POnRoleWuShiAppearanceChanged;
/*    */ 
/*    */ public class POnPutOffSuperEquipmentWuShi extends mzm.gsp.superequipment.wushi.event.PutOffSuperEquipmentWuShiProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     new POnRoleWuShiAppearanceChanged(((PutOffSuperEquipmentWuShiArg)this.arg).roleId).execute();
/* 11 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\wushi\main\POnPutOffSuperEquipmentWuShi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */