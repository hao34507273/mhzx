/*    */ package mzm.gsp.singlebattle.buff;
/*    */ 
/*    */ import mzm.gsp.map.main.scene.zone.ZoneForm;
/*    */ import mzm.gsp.map.main.scene.zone.type.event.IZoneListener;
/*    */ import mzm.gsp.singlebattle.main.BattleTaskOneByOne;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BuffZoneListener
/*    */   implements IZoneListener
/*    */ {
/*    */   public void onEnterRole(long roleId, ZoneForm zoneForm)
/*    */   {
/* 17 */     if (!(zoneForm instanceof BuffZoneForm))
/*    */     {
/* 19 */       return;
/*    */     }
/* 21 */     BuffZoneForm buffZoneForm = (BuffZoneForm)zoneForm;
/* 22 */     BattleTaskOneByOne.getInstance().addLogicProcedure(Long.valueOf(buffZoneForm.getBattleid()), new POnRoleEnterBuffZone(roleId, buffZoneForm.getBattleid(), buffZoneForm.getSortid()));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void onLeaveRole(long roleId, ZoneForm zoneForm)
/*    */   {
/* 29 */     if (!(zoneForm instanceof BuffZoneForm))
/*    */     {
/* 31 */       return;
/*    */     }
/* 33 */     BuffZoneForm buffZoneForm = (BuffZoneForm)zoneForm;
/* 34 */     BattleTaskOneByOne.getInstance().addLogicProcedure(Long.valueOf(buffZoneForm.getBattleid()), new POnRoleLeaveBuffZone(roleId, buffZoneForm.getBattleid(), buffZoneForm.getSortid()));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\buff\BuffZoneListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */