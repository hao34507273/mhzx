/*     */ package mzm.gsp.map.main.message;
/*     */ 
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.map.main.MapCallback;
/*     */ import mzm.gsp.map.main.MapManager;
/*     */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.map.main.scene.Scene;
/*     */ import mzm.gsp.map.main.scene.SceneManager;
/*     */ import mzm.gsp.map.main.scene.object.MapEntity;
/*     */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*     */ import mzm.gsp.map.main.scene.object.MapRole;
/*     */ import mzm.gsp.map.main.scene.view.IView;
/*     */ 
/*     */ 
/*     */ public class MMH_GetRoleListNearbyMapEntity
/*     */   extends AbstractMapMsgHandler
/*     */   implements MapMsgHandlerDone<MMH_GetRoleListNearbyMapEntity>
/*     */ {
/*     */   private final MapEntityType entityType;
/*     */   private final long entityInstanceid;
/*     */   private final int radius;
/*     */   private final MapCallback<List<Long>> callback;
/*  25 */   private List<Long> result = null;
/*     */   
/*     */   public MMH_GetRoleListNearbyMapEntity(MapEntityType entityType, long entityInstanceid, int radius)
/*     */   {
/*  29 */     this(entityType, entityInstanceid, radius, null);
/*     */   }
/*     */   
/*     */ 
/*     */   public MMH_GetRoleListNearbyMapEntity(MapEntityType entityType, long entityInstanceid, int radius, MapCallback<List<Long>> callback)
/*     */   {
/*  35 */     this.entityType = entityType;
/*  36 */     this.entityInstanceid = entityInstanceid;
/*  37 */     this.radius = radius;
/*  38 */     this.callback = callback;
/*     */   }
/*     */   
/*     */   public final List<Long> getResult()
/*     */   {
/*  43 */     return this.result;
/*     */   }
/*     */   
/*     */ 
/*     */   public void doProcess()
/*     */   {
/*  49 */     if (this.radius < 0)
/*     */     {
/*  51 */       return;
/*     */     }
/*     */     
/*  54 */     if (!this.entityType.isOwnView())
/*     */     {
/*  56 */       return;
/*     */     }
/*     */     
/*  59 */     MapEntity entity = MapObjectInstanceManager.getInstance().getMapEntity(this.entityType.ordinal(), this.entityInstanceid);
/*     */     
/*  61 */     if (entity == null)
/*     */     {
/*  63 */       return;
/*     */     }
/*     */     
/*  66 */     IView view = entity.getView();
/*  67 */     if (view == null)
/*     */     {
/*  69 */       return;
/*     */     }
/*     */     
/*  72 */     List<Long> roles = new LinkedList();
/*  73 */     Position pos; int maxDistanceSquare; if (this.radius == 0)
/*     */     {
/*  75 */       for (MapRole mapRole : view.getPlayers())
/*     */       {
/*  77 */         roles.add(Long.valueOf(mapRole.getRoleId()));
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/*  82 */       pos = entity.getPositionForInner();
/*  83 */       maxDistanceSquare = this.radius * this.radius;
/*  84 */       if (this.radius <= view.getRadius())
/*     */       {
/*  86 */         for (MapRole mapRole : view.getPlayers())
/*     */         {
/*  88 */           Position mapRolePos = mapRole.getPositionForInner();
/*  89 */           float distanceSquare = MapManager.getDistanceSquare(mapRolePos.getX(), mapRolePos.getY(), pos.getX(), pos.getY());
/*     */           
/*  91 */           if (distanceSquare <= maxDistanceSquare)
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*  96 */             roles.add(Long.valueOf(mapRole.getRoleId()));
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 101 */         Scene scene = SceneManager.getInstance().getScene(pos);
/* 102 */         if (scene != null)
/*     */         {
/* 104 */           for (Long roleid : scene.getRoleList())
/*     */           {
/* 106 */             MapRole mapRole = MapObjectInstanceManager.getInstance().getMapRole(roleid.longValue());
/* 107 */             if (mapRole != null)
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/* 112 */               Position mapRolePos = mapRole.getPositionForInner();
/* 113 */               float distanceSquare = MapManager.getDistanceSquare(mapRolePos.getX(), mapRolePos.getY(), pos.getX(), pos.getY());
/*     */               
/* 115 */               if (distanceSquare <= maxDistanceSquare)
/*     */               {
/*     */ 
/*     */ 
/*     */ 
/* 120 */                 roles.add(roleid); }
/*     */             }
/*     */           } }
/*     */       }
/*     */     }
/* 125 */     this.result = roles;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected MapMsgHandlerDone<MMH_GetRoleListNearbyMapEntity> getMapMsgHandlerDone()
/*     */   {
/* 132 */     if (this.callback == null)
/*     */     {
/* 134 */       return null;
/*     */     }
/*     */     
/* 137 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isCallInProcedure()
/*     */   {
/* 143 */     return this.callback.isCallInProcedure();
/*     */   }
/*     */   
/*     */   public boolean onMapMsgHandlerDone(MMH_GetRoleListNearbyMapEntity mmh)
/*     */     throws Exception
/*     */   {
/* 149 */     return this.callback.onResult(mmh.getResult());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_GetRoleListNearbyMapEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */