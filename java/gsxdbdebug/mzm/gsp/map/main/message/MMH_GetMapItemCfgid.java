/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapCallback;
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapItem;
/*    */ 
/*    */ public class MMH_GetMapItemCfgid
/*    */   extends AbstractMapMsgHandler implements MapMsgHandlerDone<MMH_GetMapItemCfgid>
/*    */ {
/*    */   private final int instanceid;
/*    */   private final MapCallback<Integer> callback;
/* 12 */   private Integer mapItemCfgid = null;
/*    */   
/*    */   public MMH_GetMapItemCfgid(int instanceid, MapCallback<Integer> callback)
/*    */   {
/* 16 */     this.instanceid = instanceid;
/* 17 */     this.callback = callback;
/*    */   }
/*    */   
/*    */   public Integer getMapItemCfgid()
/*    */   {
/* 22 */     return this.mapItemCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 28 */     MapItem mapItem = MapObjectInstanceManager.getInstance().getMapItem(this.instanceid);
/* 29 */     if (mapItem != null)
/*    */     {
/* 31 */       this.mapItemCfgid = Integer.valueOf(mapItem.getCfgId());
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected MapMsgHandlerDone<MMH_GetMapItemCfgid> getMapMsgHandlerDone()
/*    */   {
/* 39 */     if (this.callback == null)
/*    */     {
/* 41 */       return null;
/*    */     }
/*    */     
/* 44 */     return this;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isCallInProcedure()
/*    */   {
/* 50 */     return this.callback.isCallInProcedure();
/*    */   }
/*    */   
/*    */   public boolean onMapMsgHandlerDone(MMH_GetMapItemCfgid mmh)
/*    */     throws Exception
/*    */   {
/* 56 */     return this.callback.onResult(mmh.getMapItemCfgid());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_GetMapItemCfgid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */