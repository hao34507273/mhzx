/*     */ package mzm.gsp.map.main.message;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.map.main.MapCallback;
/*     */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.map.main.scene.object.MapEntity;
/*     */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*     */ 
/*     */ public class MMH_ChangeMapEntityInfos
/*     */   extends AbstractMapMsgHandler
/*     */   implements MapMsgHandlerDone<MMH_ChangeMapEntityInfos>
/*     */ {
/*     */   private final MapEntityType entityType;
/*     */   private final long entityInstanceid;
/*     */   private final int x;
/*     */   private final int y;
/*     */   private final int cfgid;
/*     */   private final Map<Integer, Integer> replaceIntExtraInfoEntries;
/*     */   private final Map<Integer, Long> replaceLongExtraInfoEntries;
/*     */   private final Map<Integer, String> replaceStringExtraInfoEntries;
/*     */   private final Set<Integer> removeExtraInfoKeys;
/*     */   private final MapCallback<Boolean> callback;
/*  25 */   private boolean result = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public MMH_ChangeMapEntityInfos(MapEntityType entityType, long entityInstanceid, int x, int y, int cfgid, Map<Integer, Integer> replaceIntExtraInfoEntries, Map<Integer, Long> replaceLongExtraInfoEntries, Map<Integer, String> replaceStringExtraInfoEntries, Set<Integer> removeExtraInfoKeys, MapCallback<Boolean> callback)
/*     */   {
/*  32 */     this.entityType = entityType;
/*  33 */     this.entityInstanceid = entityInstanceid;
/*  34 */     this.x = x;
/*  35 */     this.y = y;
/*  36 */     this.cfgid = cfgid;
/*  37 */     this.replaceIntExtraInfoEntries = replaceIntExtraInfoEntries;
/*  38 */     this.replaceLongExtraInfoEntries = replaceLongExtraInfoEntries;
/*  39 */     this.replaceStringExtraInfoEntries = replaceStringExtraInfoEntries;
/*  40 */     this.removeExtraInfoKeys = removeExtraInfoKeys;
/*  41 */     this.callback = callback;
/*     */   }
/*     */   
/*     */   public boolean getResult()
/*     */   {
/*  46 */     return this.result;
/*     */   }
/*     */   
/*     */ 
/*     */   public void doProcess()
/*     */   {
/*  52 */     MapEntity entity = MapObjectInstanceManager.getInstance().getMapEntity(this.entityType.ordinal(), this.entityInstanceid);
/*     */     
/*  54 */     if (entity == null)
/*     */     {
/*  56 */       return;
/*     */     }
/*     */     
/*  59 */     int tmpX = this.x;
/*  60 */     int tmpY = this.y;
/*  61 */     if ((this.x < 0) || (this.y < 0))
/*     */     {
/*  63 */       Position pos = entity.getPositionForInner();
/*  64 */       tmpX = pos.getX();
/*  65 */       tmpY = pos.getY();
/*     */     }
/*     */     
/*  68 */     int tmpCfgid = this.cfgid;
/*  69 */     if (this.cfgid <= 0)
/*     */     {
/*  71 */       tmpCfgid = entity.getCfgId().intValue();
/*     */     }
/*     */     
/*  74 */     if (!entity.changeInfos(tmpX, tmpY, tmpCfgid, this.replaceIntExtraInfoEntries, this.replaceLongExtraInfoEntries, this.replaceStringExtraInfoEntries, this.removeExtraInfoKeys))
/*     */     {
/*     */ 
/*  77 */       return;
/*     */     }
/*     */     
/*  80 */     this.result = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected MapMsgHandlerDone<MMH_ChangeMapEntityInfos> getMapMsgHandlerDone()
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
/*     */   public boolean onMapMsgHandlerDone(MMH_ChangeMapEntityInfos mmh)
/*     */     throws Exception
/*     */   {
/* 104 */     return this.callback.onResult(Boolean.valueOf(mmh.getResult()));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_ChangeMapEntityInfos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */