/*     */ package mzm.gsp.map.main.message;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import mzm.gsp.map.confbean.SMapGlobalConfig;
/*     */ import mzm.gsp.map.main.MapCallback;
/*     */ import mzm.gsp.map.main.WorldInstance;
/*     */ import mzm.gsp.map.main.WorldManager;
/*     */ import mzm.gsp.map.main.scene.Scene;
/*     */ import mzm.gsp.map.main.scene.SceneManager;
/*     */ 
/*     */ public class MMH_DestroyScene extends AbstractMapMsgHandler implements MapMsgHandlerDone<MMH_DestroyScene>
/*     */ {
/*     */   private final long worldid;
/*     */   private final int mapCfgidOrSceneid;
/*     */   private final boolean forceStop;
/*     */   private final MapCallback<Boolean> callback;
/*  17 */   private boolean result = false;
/*     */   
/*     */   public MMH_DestroyScene(int sceneid)
/*     */   {
/*  21 */     this(-1L, sceneid, true, null);
/*     */   }
/*     */   
/*     */   public MMH_DestroyScene(int sceneid, boolean forceStop)
/*     */   {
/*  26 */     this(-1L, sceneid, forceStop, null);
/*     */   }
/*     */   
/*     */   public MMH_DestroyScene(long worldid, int mapCfgid, MapCallback<Boolean> callback)
/*     */   {
/*  31 */     this(worldid, mapCfgid, true, callback);
/*     */   }
/*     */   
/*     */ 
/*     */   public MMH_DestroyScene(long worldid, int mapCfgidOrSceneid, boolean forceStop, MapCallback<Boolean> callback)
/*     */   {
/*  37 */     this.worldid = worldid;
/*  38 */     this.mapCfgidOrSceneid = mapCfgidOrSceneid;
/*  39 */     this.forceStop = forceStop;
/*  40 */     this.callback = callback;
/*     */   }
/*     */   
/*     */   public boolean getResult()
/*     */   {
/*  45 */     return this.result;
/*     */   }
/*     */   
/*     */ 
/*     */   public void doProcess()
/*     */   {
/*  51 */     Scene scene = null;
/*  52 */     if (this.worldid > 0L)
/*     */     {
/*  54 */       WorldInstance worldInstance = WorldManager.getInstance().getWorldInstance(this.worldid);
/*  55 */       if (worldInstance == null)
/*     */       {
/*  57 */         return;
/*     */       }
/*     */       
/*  60 */       scene = worldInstance.getSceneByCfgId(this.mapCfgidOrSceneid);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  65 */       if (SMapGlobalConfig.get(1).worldMapCfgids.contains(Integer.valueOf(this.mapCfgidOrSceneid)))
/*     */       {
/*  67 */         return;
/*     */       }
/*     */       
/*  70 */       scene = SceneManager.getInstance().getScene(this.mapCfgidOrSceneid);
/*     */     }
/*     */     
/*  73 */     if (scene == null)
/*     */     {
/*  75 */       return;
/*     */     }
/*     */     
/*  78 */     scene.stop(this.forceStop, false);
/*     */     
/*  80 */     this.result = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public MapMsgHandlerDone<MMH_DestroyScene> getMapMsgHandlerDone()
/*     */   {
/*  87 */     if (this.callback == null)
/*     */     {
/*  89 */       return null;
/*     */     }
/*     */     
/*  92 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isCallInProcedure()
/*     */   {
/*  98 */     return this.callback.isCallInProcedure();
/*     */   }
/*     */   
/*     */   public boolean onMapMsgHandlerDone(MMH_DestroyScene mmh)
/*     */     throws Exception
/*     */   {
/* 104 */     return this.callback.onResult(Boolean.valueOf(mmh.getResult()));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_DestroyScene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */