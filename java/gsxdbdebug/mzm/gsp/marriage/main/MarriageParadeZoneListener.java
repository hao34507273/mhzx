/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.map.main.scene.zone.ZoneForm;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ class MarriageParadeZoneListener implements mzm.gsp.map.main.scene.zone.type.event.IZoneListener
/*    */ {
/*    */   public void onEnterRole(long roleId, ZoneForm zoneForm)
/*    */   {
/* 11 */     if ((zoneForm instanceof MarriageParadeZoneForm)) {
/* 12 */       MarriageParadeZoneForm marraigeParadeZoneForm = (MarriageParadeZoneForm)zoneForm;
/* 13 */       long waitRoleid = marraigeParadeZoneForm.getRoleid1();
/* 14 */       if (waitRoleid != roleId) {
/* 15 */         return;
/*    */       }
/* 17 */       MapInterface.unregisterZoneEvent(marraigeParadeZoneForm.getSceneid(), marraigeParadeZoneForm.getEventid());
/*    */       
/* 19 */       Procedure.execute(new PonArrivalPointSeq(marraigeParadeZoneForm.getSeq(), marraigeParadeZoneForm.getParadeMil(), waitRoleid));
/*    */     }
/*    */   }
/*    */   
/*    */   public void onLeaveRole(long roleId, ZoneForm zoneForm) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\MarriageParadeZoneListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */