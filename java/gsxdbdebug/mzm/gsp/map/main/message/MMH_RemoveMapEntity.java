/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapCallback;
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapEntity;
/*    */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*    */ 
/*    */ public class MMH_RemoveMapEntity
/*    */   extends AbstractMapMsgHandler implements MapMsgHandlerDone<MMH_RemoveMapEntity>
/*    */ {
/*    */   private final MapEntityType entityType;
/*    */   private final long entityInstanceid;
/*    */   private final MapCallback<Boolean> callback;
/* 14 */   private boolean result = false;
/*    */   
/*    */   public MMH_RemoveMapEntity(MapEntityType entityType, long entityInstanceid, MapCallback<Boolean> callback)
/*    */   {
/* 18 */     this.entityType = entityType;
/* 19 */     this.entityInstanceid = entityInstanceid;
/* 20 */     this.callback = callback;
/*    */   }
/*    */   
/*    */   public boolean getResult()
/*    */   {
/* 25 */     return this.result;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 31 */     MapEntity entity = MapObjectInstanceManager.getInstance().getMapEntity(this.entityType.ordinal(), this.entityInstanceid);
/*    */     
/* 33 */     if (entity == null)
/*    */     {
/* 35 */       return;
/*    */     }
/*    */     
/* 38 */     entity.destroy();
/*    */     
/* 40 */     this.result = true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected MapMsgHandlerDone<MMH_RemoveMapEntity> getMapMsgHandlerDone()
/*    */   {
/* 47 */     if (this.callback == null)
/*    */     {
/* 49 */       return null;
/*    */     }
/*    */     
/* 52 */     return this;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isCallInProcedure()
/*    */   {
/* 58 */     return this.callback.isCallInProcedure();
/*    */   }
/*    */   
/*    */   public boolean onMapMsgHandlerDone(MMH_RemoveMapEntity mmh)
/*    */     throws Exception
/*    */   {
/* 64 */     return this.callback.onResult(Boolean.valueOf(mmh.getResult()));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_RemoveMapEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */