/*    */ package mzm.gsp.masswedding.main;
/*    */ 
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.map.main.scene.zone.ZoneForm;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ class MassWeddingParadeZoneListener implements mzm.gsp.map.main.scene.zone.type.event.IZoneListener
/*    */ {
/*    */   public void onEnterRole(long roleId, ZoneForm zoneForm)
/*    */   {
/* 11 */     if ((zoneForm instanceof MassWeddingZoneForm)) {
/* 12 */       MassWeddingZoneForm massWeddingZoneForm = (MassWeddingZoneForm)zoneForm;
/* 13 */       long waitRoleid = massWeddingZoneForm.getRoleid1();
/* 14 */       if (waitRoleid != roleId) {
/* 15 */         return;
/*    */       }
/* 17 */       MapInterface.unregisterZoneEvent(massWeddingZoneForm.getSceneid(), massWeddingZoneForm.getEventid());
/* 18 */       Procedure.execute(new PonArrivalPointSeq(massWeddingZoneForm.getSeq(), massWeddingZoneForm.getRoleid1(), massWeddingZoneForm.getRoleid2()));
/*    */     }
/*    */   }
/*    */   
/*    */   public void onLeaveRole(long roleId, ZoneForm zoneForm) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\MassWeddingParadeZoneListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */