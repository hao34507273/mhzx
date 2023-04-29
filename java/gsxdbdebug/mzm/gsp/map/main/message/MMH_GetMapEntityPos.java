/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapCallback;
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.Position;
/*    */ import mzm.gsp.map.main.scene.object.MapEntity;
/*    */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*    */ 
/*    */ 
/*    */ public class MMH_GetMapEntityPos<T extends Position>
/*    */   extends AbstractMapMsgHandler
/*    */   implements MapMsgHandlerDone<MMH_GetMapEntityPos>
/*    */ {
/*    */   private final MapEntityType entityType;
/*    */   private final long entityInstanceid;
/*    */   private final MapCallback<T> callback;
/* 17 */   private T result = null;
/*    */   
/*    */   public MMH_GetMapEntityPos(MapEntityType entityType, long entityInstanceid)
/*    */   {
/* 21 */     this(entityType, entityInstanceid, null);
/*    */   }
/*    */   
/*    */   public MMH_GetMapEntityPos(MapEntityType entityType, long entityInstanceid, MapCallback<T> callback)
/*    */   {
/* 26 */     this.entityType = entityType;
/* 27 */     this.entityInstanceid = entityInstanceid;
/* 28 */     this.callback = callback;
/*    */   }
/*    */   
/*    */   public final T getResult()
/*    */   {
/* 33 */     return this.result;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 40 */     MapEntity entity = MapObjectInstanceManager.getInstance().getMapEntity(this.entityType.ordinal(), this.entityInstanceid);
/*    */     
/* 42 */     if (entity == null)
/*    */     {
/* 44 */       return;
/*    */     }
/*    */     
/* 47 */     this.result = entity.getPositionWithExtraInfo();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected MapMsgHandlerDone<MMH_GetMapEntityPos> getMapMsgHandlerDone()
/*    */   {
/* 54 */     if (this.callback == null)
/*    */     {
/* 56 */       return null;
/*    */     }
/*    */     
/* 59 */     return this;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isCallInProcedure()
/*    */   {
/* 65 */     return this.callback.isCallInProcedure();
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean onMapMsgHandlerDone(MMH_GetMapEntityPos mmh)
/*    */     throws Exception
/*    */   {
/* 72 */     return this.callback.onResult(mmh.getResult());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_GetMapEntityPos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */