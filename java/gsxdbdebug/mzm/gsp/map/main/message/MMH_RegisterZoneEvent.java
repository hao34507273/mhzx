/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapCallback;
/*    */ import mzm.gsp.map.main.scene.Scene;
/*    */ import mzm.gsp.map.main.scene.SceneManager;
/*    */ import mzm.gsp.map.main.scene.zone.ZoneForm;
/*    */ import mzm.gsp.map.main.scene.zone.type.event.IInnerZoneListener;
/*    */ import mzm.gsp.map.main.scene.zone.type.event.IMapEntityZoneListener;
/*    */ import mzm.gsp.map.main.scene.zone.type.event.IZoneListener;
/*    */ import mzm.gsp.map.main.scene.zone.type.event.ZoneListenerProxy;
/*    */ 
/*    */ public class MMH_RegisterZoneEvent
/*    */   extends AbstractMapMsgHandler
/*    */   implements MapMsgHandlerDone<MMH_RegisterZoneEvent>
/*    */ {
/*    */   private final int sceneid;
/*    */   private final ZoneForm zoneForm;
/*    */   private final int spaceFlags;
/*    */   private final IInnerZoneListener listener;
/*    */   private final MapCallback<Integer> callback;
/* 21 */   private int eventId = 0;
/*    */   
/*    */ 
/*    */   public MMH_RegisterZoneEvent(int sceneid, ZoneForm zoneForm, IZoneListener listener, MapCallback<Integer> callback)
/*    */   {
/* 26 */     this(sceneid, zoneForm, 1, listener, callback);
/*    */   }
/*    */   
/*    */ 
/*    */   public MMH_RegisterZoneEvent(int sceneid, ZoneForm zoneForm, int spaceFlags, IZoneListener listener, MapCallback<Integer> callback)
/*    */   {
/* 32 */     this.sceneid = sceneid;
/* 33 */     this.zoneForm = zoneForm;
/* 34 */     this.spaceFlags = spaceFlags;
/* 35 */     this.listener = new ZoneListenerProxy(listener);
/* 36 */     this.callback = callback;
/*    */   }
/*    */   
/*    */ 
/*    */   public MMH_RegisterZoneEvent(int sceneid, ZoneForm zoneForm, IMapEntityZoneListener listener, MapCallback<Integer> callback)
/*    */   {
/* 42 */     this(sceneid, zoneForm, 1, listener, callback);
/*    */   }
/*    */   
/*    */ 
/*    */   public MMH_RegisterZoneEvent(int sceneid, ZoneForm zoneForm, int spaceFlags, IMapEntityZoneListener listener, MapCallback<Integer> callback)
/*    */   {
/* 48 */     this.sceneid = sceneid;
/* 49 */     this.zoneForm = zoneForm;
/* 50 */     this.spaceFlags = spaceFlags;
/* 51 */     this.listener = new ZoneListenerProxy(listener);
/* 52 */     this.callback = callback;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 58 */     Scene scene = SceneManager.getInstance().getScene(this.sceneid);
/* 59 */     if (scene == null)
/*    */     {
/* 61 */       return;
/*    */     }
/*    */     
/* 64 */     this.eventId = scene.registerZoneEvent(this.zoneForm, this.spaceFlags, this.listener);
/*    */   }
/*    */   
/*    */ 
/*    */   protected MapMsgHandlerDone<MMH_RegisterZoneEvent> getMapMsgHandlerDone()
/*    */   {
/* 70 */     if (this.callback == null)
/*    */     {
/* 72 */       return null;
/*    */     }
/*    */     
/* 75 */     return this;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isCallInProcedure()
/*    */   {
/* 81 */     return this.callback.isCallInProcedure();
/*    */   }
/*    */   
/*    */   public boolean onMapMsgHandlerDone(MMH_RegisterZoneEvent mmh)
/*    */     throws Exception
/*    */   {
/* 87 */     return this.callback.onResult(Integer.valueOf(this.eventId));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_RegisterZoneEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */