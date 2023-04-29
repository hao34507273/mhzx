/*    */ package mzm.gsp.flowerparade.main;
/*    */ 
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*    */ import mzm.gsp.map.main.scene.zone.ZoneForm;
/*    */ import mzm.gsp.map.main.scene.zone.type.event.IMapEntityZoneListener;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ public class FlowerParadeRestPosZoneListener
/*    */   implements IMapEntityZoneListener
/*    */ {
/*    */   private final int sceneId;
/*    */   private final long instanceId;
/*    */   private final int activityId;
/*    */   private final int pos;
/*    */   private int eventId;
/*    */   
/*    */   public int getEventId()
/*    */   {
/* 20 */     return this.eventId;
/*    */   }
/*    */   
/*    */   public void setEventId(int eventId)
/*    */   {
/* 25 */     this.eventId = eventId;
/*    */   }
/*    */   
/*    */   public FlowerParadeRestPosZoneListener(int sceneId, long instanceId, int pos, int activityId)
/*    */   {
/* 30 */     this.sceneId = sceneId;
/* 31 */     this.instanceId = instanceId;
/* 32 */     this.pos = pos;
/* 33 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */ 
/*    */   public void onEnterMapEntity(MapEntityType entityType, long entityInstanceid, ZoneForm zoneForm)
/*    */   {
/* 39 */     if (this.instanceId != entityInstanceid)
/*    */     {
/* 41 */       return;
/*    */     }
/*    */     
/* 44 */     if (entityType != MapEntityType.MET_FLOAT_PARADE)
/*    */     {
/* 46 */       return;
/*    */     }
/*    */     
/* 49 */     Procedure.execute(new PFlowerParadeMoveEnd(this.activityId, this.pos));
/*    */     
/*    */ 
/* 52 */     MapInterface.unregisterZoneEvent(this.sceneId, this.eventId);
/*    */   }
/*    */   
/*    */   public void onLeaveMapEntity(MapEntityType entityType, long entityInstanceid, ZoneForm zoneForm) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\flowerparade\main\FlowerParadeRestPosZoneListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */