/*    */ package mzm.gsp.map.main.scene.zone.type.event;
/*    */ 
/*    */ import mzm.gsp.map.main.scene.zone.ZoneForm;
/*    */ import xdb.Executor;
/*    */ 
/*    */ public class ZoneListenerProxy implements IInnerZoneListener
/*    */ {
/*    */   private final IZoneListener listener;
/*    */   private final IMapEntityZoneListener mapEntityListener;
/*    */   
/*    */   public ZoneListenerProxy(IZoneListener listener)
/*    */   {
/* 13 */     this.listener = listener;
/* 14 */     this.mapEntityListener = null;
/*    */   }
/*    */   
/*    */   public ZoneListenerProxy(IMapEntityZoneListener listener)
/*    */   {
/* 19 */     this.listener = null;
/* 20 */     this.mapEntityListener = listener;
/*    */   }
/*    */   
/*    */ 
/*    */   public void onEnterRole(long roleId, ZoneForm zoneForm)
/*    */   {
/* 26 */     if (this.listener == null)
/*    */     {
/* 28 */       return;
/*    */     }
/*    */     
/* 31 */     Executor.getInstance().execute(new ZoneListenerInvoker(this.listener, ZoneListenerInvoker.ListenerCallbackType.ENTER_ROLE, roleId, zoneForm));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void onLeaveRole(long roleId, ZoneForm zoneForm)
/*    */   {
/* 38 */     if (this.listener == null)
/*    */     {
/* 40 */       return;
/*    */     }
/*    */     
/* 43 */     Executor.getInstance().execute(new ZoneListenerInvoker(this.listener, ZoneListenerInvoker.ListenerCallbackType.LEAVE_ROLE, roleId, zoneForm));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onEnterMapEntity(mzm.gsp.map.main.scene.object.MapEntityType entityType, long entityInstanceid, ZoneForm zoneForm)
/*    */   {
/* 51 */     if (this.mapEntityListener == null)
/*    */     {
/* 53 */       return;
/*    */     }
/*    */     
/* 56 */     Executor.getInstance().execute(new MapEntityZoneListenerInvoker(this.mapEntityListener, MapEntityZoneListenerInvoker.ListenerCallbackType.ENTER_MAP_ENTITY, entityType, entityInstanceid, zoneForm));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onLeaveMapEntity(mzm.gsp.map.main.scene.object.MapEntityType entityType, long entityInstanceid, ZoneForm zoneForm)
/*    */   {
/* 65 */     if (this.mapEntityListener == null)
/*    */     {
/* 67 */       return;
/*    */     }
/*    */     
/* 70 */     Executor.getInstance().execute(new MapEntityZoneListenerInvoker(this.mapEntityListener, MapEntityZoneListenerInvoker.ListenerCallbackType.LEAVE_MAP_ENTITY, entityType, entityInstanceid, zoneForm));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\zone\type\event\ZoneListenerProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */