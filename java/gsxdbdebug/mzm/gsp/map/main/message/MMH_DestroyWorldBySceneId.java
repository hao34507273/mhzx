/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapCallback;
/*    */ import mzm.gsp.map.main.WorldInstance;
/*    */ import mzm.gsp.map.main.scene.Scene;
/*    */ import mzm.gsp.map.main.scene.SceneManager;
/*    */ 
/*    */ public class MMH_DestroyWorldBySceneId extends AbstractMapMsgHandler implements MapMsgHandlerDone<MMH_DestroyWorldBySceneId>
/*    */ {
/*    */   private final int sceneid;
/*    */   private final MapCallback<Boolean> callback;
/* 12 */   private boolean result = false;
/*    */   
/*    */   public MMH_DestroyWorldBySceneId(int sceneid, MapCallback<Boolean> callback)
/*    */   {
/* 16 */     this.sceneid = sceneid;
/* 17 */     this.callback = callback;
/*    */   }
/*    */   
/*    */   public boolean getResult()
/*    */   {
/* 22 */     return this.result;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 28 */     Scene scene = SceneManager.getInstance().getScene(this.sceneid);
/* 29 */     if (scene != null)
/*    */     {
/* 31 */       scene.getWorld().release();
/*    */       
/* 33 */       this.result = true;
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public MapMsgHandlerDone<MMH_DestroyWorldBySceneId> getMapMsgHandlerDone()
/*    */   {
/* 41 */     if (this.callback == null)
/*    */     {
/* 43 */       return null;
/*    */     }
/*    */     
/* 46 */     return this;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isCallInProcedure()
/*    */   {
/* 52 */     return this.callback.isCallInProcedure();
/*    */   }
/*    */   
/*    */   public boolean onMapMsgHandlerDone(MMH_DestroyWorldBySceneId mmh)
/*    */     throws Exception
/*    */   {
/* 58 */     return this.callback.onResult(Boolean.valueOf(mmh.getResult()));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_DestroyWorldBySceneId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */