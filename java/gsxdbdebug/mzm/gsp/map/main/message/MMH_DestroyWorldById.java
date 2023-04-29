/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapCallback;
/*    */ import mzm.gsp.map.main.WorldInstance;
/*    */ import mzm.gsp.map.main.WorldManager;
/*    */ 
/*    */ public class MMH_DestroyWorldById
/*    */   extends AbstractMapMsgHandler implements MapMsgHandlerDone<MMH_DestroyWorldById>
/*    */ {
/*    */   private final long worldId;
/*    */   private final MapCallback<Boolean> callback;
/* 12 */   private boolean result = false;
/*    */   
/*    */   public MMH_DestroyWorldById(long worldId, MapCallback<Boolean> callback)
/*    */   {
/* 16 */     this.worldId = worldId;
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
/* 28 */     WorldInstance instance = WorldManager.getInstance().removeWorldInstance(this.worldId);
/* 29 */     if (instance != null)
/*    */     {
/* 31 */       instance.release();
/*    */       
/* 33 */       this.result = true;
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public MapMsgHandlerDone<MMH_DestroyWorldById> getMapMsgHandlerDone()
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
/*    */   public boolean onMapMsgHandlerDone(MMH_DestroyWorldById mmh)
/*    */     throws Exception
/*    */   {
/* 58 */     return this.callback.onResult(Boolean.valueOf(mmh.getResult()));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_DestroyWorldById.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */