/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import mzm.gsp.map.main.MapCallback;
/*    */ import mzm.gsp.map.main.WorldInstance;
/*    */ import mzm.gsp.map.main.WorldManager;
/*    */ 
/*    */ 
/*    */ public class MMH_CreateWorld
/*    */   extends AbstractMapMsgHandler
/*    */   implements MapMsgHandlerDone<MMH_CreateWorld>
/*    */ {
/*    */   private final Collection<Integer> mapCfgIds;
/*    */   private final MapCallback<Long> callback;
/* 15 */   private long result = -1L;
/*    */   
/*    */   public long getResult()
/*    */   {
/* 19 */     return this.result;
/*    */   }
/*    */   
/*    */   public MMH_CreateWorld(Collection<Integer> mapCfgIds)
/*    */   {
/* 24 */     this(mapCfgIds, null);
/*    */   }
/*    */   
/*    */   public MMH_CreateWorld(Collection<Integer> mapCfgIds, MapCallback<Long> callback)
/*    */   {
/* 29 */     this.mapCfgIds = mapCfgIds;
/* 30 */     this.callback = callback;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 36 */     WorldInstance instance = new WorldInstance();
/* 37 */     instance.lazyInit(this.mapCfgIds);
/*    */     
/* 39 */     WorldManager.getInstance().addWorldInstance(instance);
/*    */     
/* 41 */     this.result = instance.getId();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public MapMsgHandlerDone<MMH_CreateWorld> getMapMsgHandlerDone()
/*    */   {
/* 48 */     if (this.callback == null)
/*    */     {
/* 50 */       return null;
/*    */     }
/*    */     
/* 53 */     return this;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isCallInProcedure()
/*    */   {
/* 59 */     return this.callback.isCallInProcedure();
/*    */   }
/*    */   
/*    */   public boolean onMapMsgHandlerDone(MMH_CreateWorld mmh)
/*    */     throws Exception
/*    */   {
/* 65 */     return this.callback.onResult(Long.valueOf(mmh.getResult()));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_CreateWorld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */