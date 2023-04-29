/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.map.main.message.MMH_OnRoleAppearanceChanged;
/*    */ import mzm.gsp.wing.event.WingModelChangedArg;
/*    */ import mzm.gsp.wing.event.WingModelChangedEventProcedure;
/*    */ import mzm.gsp.wing.main2.WingChangeReasonEnum;
/*    */ import mzm.gsp.wing.main2.WingInterface;
/*    */ import mzm.gsp.wing.main2.WingInterface.WingExteriorInfo;
/*    */ 
/*    */ public class POnWingChangedEvent extends WingModelChangedEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     if (((WingModelChangedArg)this.arg).changeReasonEnum == WingChangeReasonEnum.CHANGE_OCCUPATION)
/*    */     {
/* 18 */       return false;
/*    */     }
/*    */     
/* 21 */     Map<Integer, Object> changeProps = new HashMap();
/* 22 */     long roleid = ((WingModelChangedArg)this.arg).getRoleId();
/*    */     
/* 24 */     WingInterface.WingExteriorInfo exteriorInfo = WingInterface.getEquipedWingId(roleid, true);
/* 25 */     if (exteriorInfo != null)
/*    */     {
/* 27 */       changeProps.put(Integer.valueOf(8), Integer.valueOf(exteriorInfo.getExteriorId()));
/* 28 */       changeProps.put(Integer.valueOf(9), Integer.valueOf(exteriorInfo.getColorId()));
/*    */     }
/* 30 */     new MMH_OnRoleAppearanceChanged(((WingModelChangedArg)this.arg).getRoleId(), 4, changeProps).execute();
/*    */     
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnWingChangedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */