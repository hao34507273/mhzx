/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.map.main.message.MMH_OnRoleAppearanceChanged;
/*    */ import mzm.gsp.superequipment.wushi.event.PutOnSuperEquipmentWuShiArg;
/*    */ import mzm.gsp.superequipment.wushi.event.PutOnSuperEquipmentWuShiProcedure;
/*    */ 
/*    */ public class POnPutOnSuperEquipmentWuShi extends PutOnSuperEquipmentWuShiProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     Map<Integer, Object> changeProps = new HashMap();
/* 14 */     changeProps.put(Integer.valueOf(18), Integer.valueOf(((PutOnSuperEquipmentWuShiArg)this.arg).wushicfgid));
/* 15 */     new MMH_OnRoleAppearanceChanged(((PutOnSuperEquipmentWuShiArg)this.arg).roleId, 16, changeProps).execute();
/*    */     
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnPutOnSuperEquipmentWuShi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */