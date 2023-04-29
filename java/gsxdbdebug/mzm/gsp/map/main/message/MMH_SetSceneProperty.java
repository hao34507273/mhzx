/*     */ package mzm.gsp.map.main.message;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.map.main.MapCallback;
/*     */ import mzm.gsp.map.main.WorldInstance;
/*     */ import mzm.gsp.map.main.WorldManager;
/*     */ import mzm.gsp.map.main.scene.Scene;
/*     */ import mzm.gsp.map.main.scene.ScenePropertyKey;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MMH_SetSceneProperty
/*     */   extends AbstractMapMsgHandler
/*     */   implements MapMsgHandlerDone<MMH_SetSceneProperty>
/*     */ {
/*     */   private final long worldid;
/*     */   private final int mapCfgid;
/*     */   private final Map<ScenePropertyKey, Integer> properties;
/*     */   private final MapCallback<Boolean> callback;
/*  22 */   private boolean result = false;
/*     */   
/*     */ 
/*     */   public MMH_SetSceneProperty(long worldid, int mapCfgid, Map<ScenePropertyKey, Integer> properties, MapCallback<Boolean> callback)
/*     */   {
/*  27 */     this.worldid = worldid;
/*  28 */     this.mapCfgid = mapCfgid;
/*  29 */     this.properties = properties;
/*  30 */     this.callback = callback;
/*     */   }
/*     */   
/*     */   public boolean getResult()
/*     */   {
/*  35 */     return this.result;
/*     */   }
/*     */   
/*     */ 
/*     */   public void doProcess()
/*     */   {
/*  41 */     WorldInstance instance = WorldManager.getInstance().getWorldInstance(this.worldid);
/*  42 */     if (instance == null)
/*     */     {
/*  44 */       return;
/*     */     }
/*     */     
/*  47 */     Scene scene = instance.nextScene(this.mapCfgid);
/*  48 */     if (scene == null)
/*     */     {
/*  50 */       return;
/*     */     }
/*     */     
/*  53 */     for (Map.Entry<ScenePropertyKey, Integer> entry : this.properties.entrySet())
/*     */     {
/*  55 */       switch ((ScenePropertyKey)entry.getKey())
/*     */       {
/*     */       case AUTO_RELEASE: 
/*  58 */         if (((Integer)entry.getValue()).intValue() > 0)
/*     */         {
/*  60 */           scene.autoRelease();
/*     */         }
/*     */         else
/*     */         {
/*  64 */           scene.unAutoRelease();
/*     */         }
/*  66 */         break;
/*     */       
/*     */       case REPEAT_LAZY_INIT: 
/*  69 */         if (((Integer)entry.getValue()).intValue() > 0)
/*     */         {
/*  71 */           scene.repeatLazyInit();
/*     */         }
/*     */         else
/*     */         {
/*  75 */           scene.unRepeatLazyInit();
/*     */         }
/*  77 */         break;
/*     */       
/*     */       default: 
/*  80 */         return;
/*     */       }
/*     */       
/*     */     }
/*  84 */     this.result = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public MapMsgHandlerDone<MMH_SetSceneProperty> getMapMsgHandlerDone()
/*     */   {
/*  91 */     if (this.callback == null)
/*     */     {
/*  93 */       return null;
/*     */     }
/*     */     
/*  96 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isCallInProcedure()
/*     */   {
/* 102 */     return this.callback.isCallInProcedure();
/*     */   }
/*     */   
/*     */   public boolean onMapMsgHandlerDone(MMH_SetSceneProperty mmh)
/*     */     throws Exception
/*     */   {
/* 108 */     return this.callback.onResult(Boolean.valueOf(mmh.getResult()));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_SetSceneProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */