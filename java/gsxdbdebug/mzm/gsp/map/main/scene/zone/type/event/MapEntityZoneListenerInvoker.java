/*    */ package mzm.gsp.map.main.scene.zone.type.event;
/*    */ 
/*    */ import mzm.gsp.map.main.scene.zone.ZoneForm;
/*    */ 
/*    */ class MapEntityZoneListenerInvoker extends mzm.gsp.util.LogicRunnable
/*    */ {
/*    */   private final IMapEntityZoneListener listener;
/*    */   private final ListenerCallbackType lct;
/*    */   private final mzm.gsp.map.main.scene.object.MapEntityType entityType;
/*    */   private final long entityInstanceid;
/*    */   private final ZoneForm zoneForm;
/*    */   
/*    */   static enum ListenerCallbackType {
/* 14 */     ENTER_MAP_ENTITY, 
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 19 */     LEAVE_MAP_ENTITY;
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */     private ListenerCallbackType() {}
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public MapEntityZoneListenerInvoker(IMapEntityZoneListener listener, ListenerCallbackType lct, mzm.gsp.map.main.scene.object.MapEntityType entityType, long entityInstanceid, ZoneForm zoneForm)
/*    */   {
/* 31 */     this.listener = listener;
/* 32 */     this.lct = lct;
/* 33 */     this.entityType = entityType;
/* 34 */     this.entityInstanceid = entityInstanceid;
/* 35 */     this.zoneForm = zoneForm;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 41 */     switch (this.lct)
/*    */     {
/*    */     case ENTER_MAP_ENTITY: 
/* 44 */       this.listener.onEnterMapEntity(this.entityType, this.entityInstanceid, this.zoneForm);
/* 45 */       break;
/*    */     
/*    */     case LEAVE_MAP_ENTITY: 
/* 48 */       this.listener.onLeaveMapEntity(this.entityType, this.entityInstanceid, this.zoneForm);
/* 49 */       break;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\zone\type\event\MapEntityZoneListenerInvoker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */