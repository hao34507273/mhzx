/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.map.main.message.MMH_OnRoleAppearanceChanged;
/*    */ import mzm.gsp.superequipment.wushi.event.PutOffSuperEquipmentWuShiArg;
/*    */ import mzm.gsp.superequipment.wushi.event.PutOffSuperEquipmentWuShiProcedure;
/*    */ 
/*    */ public class POnPutOffSuperEquipmentWuShi extends PutOffSuperEquipmentWuShiProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     Map<Integer, Object> changeProps = new HashMap();
/* 14 */     new MMH_OnRoleAppearanceChanged(((PutOffSuperEquipmentWuShiArg)this.arg).roleId, 16, changeProps).execute();
/*    */     
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnPutOffSuperEquipmentWuShi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */