/*     */ package mzm.gsp.map.main.message;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import mzm.gsp.map.confbean.MapConsts;
/*     */ import mzm.gsp.map.main.MapCallback;
/*     */ import mzm.gsp.map.main.MapManager;
/*     */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.map.main.scene.Scene;
/*     */ import mzm.gsp.map.main.scene.SceneManager;
/*     */ import mzm.gsp.map.main.scene.object.MapRole;
/*     */ 
/*     */ public class MMH_IsNearByPos
/*     */   extends AbstractMapMsgHandler
/*     */   implements MapMsgHandlerDone<MMH_IsNearByPos>
/*     */ {
/*     */   private final List<Long> roleids;
/*     */   private final int mapCfgid;
/*     */   private final int x;
/*     */   private final int y;
/*     */   private final int thresholdDistance;
/*     */   private final MapCallback<Boolean> callback;
/*  25 */   private boolean result = false;
/*     */   
/*     */   public MMH_IsNearByPos(long roleid, int mapCfgid, int x, int y, MapCallback<Boolean> callback)
/*     */   {
/*  29 */     this(roleid, mapCfgid, x, y, MapConsts.getInstance().MAPOBJECT_TALK_DIST, callback);
/*     */   }
/*     */   
/*     */ 
/*     */   public MMH_IsNearByPos(long roleid, int mapCfgid, int x, int y, int thresholdDistance, MapCallback<Boolean> callback)
/*     */   {
/*  35 */     this.roleids = new ArrayList(1);
/*  36 */     this.roleids.add(Long.valueOf(roleid));
/*  37 */     this.mapCfgid = mapCfgid;
/*  38 */     this.x = x;
/*  39 */     this.y = y;
/*  40 */     this.thresholdDistance = thresholdDistance;
/*     */     
/*  42 */     this.callback = callback;
/*     */   }
/*     */   
/*     */ 
/*     */   public MMH_IsNearByPos(Collection<Long> roleids, int mapCfgid, int x, int y, MapCallback<Boolean> callback)
/*     */   {
/*  48 */     this(roleids, mapCfgid, x, y, MapConsts.getInstance().MAPOBJECT_TALK_DIST, callback);
/*     */   }
/*     */   
/*     */ 
/*     */   public MMH_IsNearByPos(Collection<Long> roleids, int mapCfgid, int x, int y, int thresholdDistance, MapCallback<Boolean> callback)
/*     */   {
/*  54 */     this.roleids = new ArrayList(roleids);
/*  55 */     this.mapCfgid = mapCfgid;
/*  56 */     this.x = x;
/*  57 */     this.y = y;
/*  58 */     this.thresholdDistance = thresholdDistance;
/*     */     
/*  60 */     this.callback = callback;
/*     */   }
/*     */   
/*     */   public boolean getResult()
/*     */   {
/*  65 */     return this.result;
/*     */   }
/*     */   
/*     */ 
/*     */   public void doProcess()
/*     */   {
/*  71 */     for (Long roleid : this.roleids)
/*     */     {
/*  73 */       MapRole role = MapObjectInstanceManager.getInstance().getMapRole(roleid.longValue());
/*  74 */       if (role == null)
/*     */       {
/*  76 */         return;
/*     */       }
/*     */       
/*  79 */       Scene scene = SceneManager.getInstance().getScene(role.getPositionForInner());
/*  80 */       if ((scene == null) || (scene.getCfgId() != this.mapCfgid))
/*     */       {
/*  82 */         return;
/*     */       }
/*     */       
/*  85 */       Position pos = role.getPositionForInner();
/*  86 */       int dist = (int)Math.ceil(MapManager.getDistance(pos.getX(), pos.getY(), this.x, this.y));
/*  87 */       if (dist > this.thresholdDistance)
/*     */       {
/*  89 */         return;
/*     */       }
/*     */     }
/*     */     
/*  93 */     this.result = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected MapMsgHandlerDone<MMH_IsNearByPos> getMapMsgHandlerDone()
/*     */   {
/* 100 */     if (this.callback == null)
/*     */     {
/* 102 */       return null;
/*     */     }
/*     */     
/* 105 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isCallInProcedure()
/*     */   {
/* 111 */     return this.callback.isCallInProcedure();
/*     */   }
/*     */   
/*     */   public boolean onMapMsgHandlerDone(MMH_IsNearByPos mmh)
/*     */     throws Exception
/*     */   {
/* 117 */     return this.callback.onResult(Boolean.valueOf(mmh.getResult()));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_IsNearByPos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */