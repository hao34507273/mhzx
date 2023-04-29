/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapCallback;
/*    */ import mzm.gsp.map.main.WorldManager;
/*    */ 
/*    */ public class MMH_IsWorldExist
/*    */   extends AbstractMapMsgHandler implements MapMsgHandlerDone<MMH_IsWorldExist>
/*    */ {
/*    */   private final long worldid;
/*    */   private final MapCallback<Boolean> callback;
/* 11 */   private boolean result = false;
/*    */   
/*    */   public MMH_IsWorldExist(long worldid)
/*    */   {
/* 15 */     this(worldid, null);
/*    */   }
/*    */   
/*    */   public MMH_IsWorldExist(long worldId, MapCallback<Boolean> callback)
/*    */   {
/* 20 */     this.worldid = worldId;
/* 21 */     this.callback = callback;
/*    */   }
/*    */   
/*    */   public boolean getResult()
/*    */   {
/* 26 */     return this.result;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 32 */     this.result = (WorldManager.getInstance().getWorldInstance(this.worldid) != null);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public MapMsgHandlerDone<MMH_IsWorldExist> getMapMsgHandlerDone()
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
/*    */   public boolean onMapMsgHandlerDone(MMH_IsWorldExist mmh)
/*    */     throws Exception
/*    */   {
/* 56 */     return this.callback.onResult(Boolean.valueOf(mmh.getResult()));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_IsWorldExist.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */