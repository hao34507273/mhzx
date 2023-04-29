/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapCallback;
/*    */ import mzm.gsp.map.main.MapManager;
/*    */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*    */ 
/*    */ public class MMH_IsNearByMapEntity
/*    */   extends AbstractMapMsgHandler implements MapMsgHandlerDone<MMH_IsNearByMapEntity>
/*    */ {
/*    */   private final long roleid;
/*    */   private final MapEntityType entityType;
/*    */   private final long entityInstanceid;
/*    */   private final MapCallback<Boolean> callback;
/* 14 */   private boolean result = false;
/*    */   
/*    */   public MMH_IsNearByMapEntity(long roleid, MapEntityType entityType, long entityInstanceid)
/*    */   {
/* 18 */     this(roleid, entityType, entityInstanceid, null);
/*    */   }
/*    */   
/*    */ 
/*    */   public MMH_IsNearByMapEntity(long roleid, MapEntityType entityType, long entityInstanceid, MapCallback<Boolean> callback)
/*    */   {
/* 24 */     this.roleid = roleid;
/* 25 */     this.entityType = entityType;
/* 26 */     this.entityInstanceid = entityInstanceid;
/* 27 */     this.callback = callback;
/*    */   }
/*    */   
/*    */   public boolean getResult()
/*    */   {
/* 32 */     return this.result;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 38 */     this.result = MapManager.isNearByMapEntity(this.roleid, this.entityType, this.entityInstanceid);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected MapMsgHandlerDone<MMH_IsNearByMapEntity> getMapMsgHandlerDone()
/*    */   {
/* 45 */     if (this.callback == null)
/*    */     {
/* 47 */       return null;
/*    */     }
/*    */     
/* 50 */     return this;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isCallInProcedure()
/*    */   {
/* 56 */     return this.callback.isCallInProcedure();
/*    */   }
/*    */   
/*    */   public boolean onMapMsgHandlerDone(MMH_IsNearByMapEntity mmh)
/*    */     throws Exception
/*    */   {
/* 62 */     return this.callback.onResult(Boolean.valueOf(mmh.getResult()));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_IsNearByMapEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */