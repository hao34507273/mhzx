/*     */ package mzm.gsp.map.main.scene.zone;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.map.main.SpaceBitMask;
/*     */ import mzm.gsp.map.main.scene.object.MapEntity;
/*     */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*     */ import mzm.gsp.map.main.scene.object.MapMonster;
/*     */ import mzm.gsp.map.main.scene.object.MapNPC;
/*     */ import mzm.gsp.map.main.scene.object.MapRole;
/*     */ import mzm.gsp.map.main.scene.object.SceneObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SimpleZone
/*     */   implements IZone
/*     */ {
/*     */   protected ZoneForm bbox;
/*     */   protected int spaceFlags;
/*  31 */   private Map<Long, MapRole> roleMap = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  36 */   private Map<Integer, Map<Long, MapEntity>> entities = new HashMap();
/*     */   
/*     */   public SimpleZone(ZoneForm zoneForm, int spaceFlags)
/*     */   {
/*  40 */     this.bbox = zoneForm;
/*  41 */     this.spaceFlags = spaceFlags;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onEnterEntity(MapEntity obj) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onLeaveEntity(MapEntity obj) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onEnterMonster(MapMonster obj) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onLeaveMonster(MapMonster obj) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onEnterNPC(MapNPC obj) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onLeaveNPC(MapNPC obj) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onEnterRole(MapRole obj) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onLeaveRole(MapRole obj) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isEffectOn(SceneObject obj)
/*     */   {
/*  87 */     return true;
/*     */   }
/*     */   
/*     */   public ZoneForm getBoundingBox()
/*     */   {
/*  92 */     return this.bbox;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onMove(SceneObject obj) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public final boolean enterRole(MapRole obj)
/*     */   {
/* 103 */     if (obj.isFlyState())
/*     */     {
/* 105 */       if (!SpaceBitMask.isSkyValid(this.spaceFlags))
/*     */       {
/* 107 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */     }
/* 112 */     else if (!SpaceBitMask.isGroundValid(this.spaceFlags))
/*     */     {
/* 114 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 118 */     if (!isEffectOn(obj))
/*     */     {
/* 120 */       return false;
/*     */     }
/*     */     
/* 123 */     if (this.roleMap.put(Long.valueOf(obj.getRoleId()), obj) != null)
/*     */     {
/* 125 */       onMove(obj);
/* 126 */       return false;
/*     */     }
/*     */     
/* 129 */     onEnterRole(obj);
/*     */     
/* 131 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean leaveRole(MapRole obj)
/*     */   {
/* 137 */     if (this.roleMap.remove(Long.valueOf(obj.getRoleId())) == null)
/*     */     {
/* 139 */       return false;
/*     */     }
/*     */     
/* 142 */     onLeaveRole(obj);
/*     */     
/* 144 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean enterEntity(MapEntity obj)
/*     */   {
/* 150 */     if (!isEffectOn(obj))
/*     */     {
/* 152 */       return false;
/*     */     }
/*     */     
/* 155 */     int entityTypeOrdinal = obj.getEntityType().ordinal();
/* 156 */     Map<Long, MapEntity> entityMap = (Map)this.entities.get(Integer.valueOf(entityTypeOrdinal));
/* 157 */     if (entityMap == null)
/*     */     {
/* 159 */       entityMap = new HashMap();
/* 160 */       this.entities.put(Integer.valueOf(entityTypeOrdinal), entityMap);
/*     */     }
/* 162 */     if (entityMap.put(obj.getInstanceid(), obj) != null)
/*     */     {
/* 164 */       onMove(obj);
/* 165 */       return false;
/*     */     }
/*     */     
/* 168 */     onEnterEntity(obj);
/*     */     
/* 170 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean leaveEntity(MapEntity obj)
/*     */   {
/* 176 */     int entityTypeOrdinal = obj.getEntityType().ordinal();
/* 177 */     Map<Long, MapEntity> entityMap = (Map)this.entities.get(Integer.valueOf(entityTypeOrdinal));
/* 178 */     if (entityMap == null)
/*     */     {
/* 180 */       return false;
/*     */     }
/*     */     
/* 183 */     if (entityMap.remove(obj.getInstanceid()) == null)
/*     */     {
/* 185 */       return false;
/*     */     }
/*     */     
/* 188 */     onLeaveEntity(obj);
/*     */     
/* 190 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean intersectsRectangle(int x1, int x2, int y1, int y2)
/*     */   {
/* 196 */     return this.bbox.intersectsRectangle(x1, x2, y1, y2);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean containPoint(int x, int y)
/*     */   {
/* 202 */     return this.bbox.test(x, y, 0);
/*     */   }
/*     */   
/*     */   public void release()
/*     */   {
/* 207 */     this.roleMap.clear();
/* 208 */     this.roleMap = null;
/* 209 */     Iterator<Map.Entry<Integer, Map<Long, MapEntity>>> iterator = this.entities.entrySet().iterator();
/* 210 */     while (iterator.hasNext())
/*     */     {
/* 212 */       ((Map)((Map.Entry)iterator.next()).getValue()).clear();
/* 213 */       iterator.remove();
/*     */     }
/* 215 */     this.entities = null;
/* 216 */     this.bbox = null;
/*     */   }
/*     */   
/*     */   public void fillSingleRole(Collection<Long> roleCollection)
/*     */   {
/* 221 */     for (MapRole role : this.roleMap.values())
/*     */     {
/* 223 */       if (!role.isInTeam())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 228 */         roleCollection.add(Long.valueOf(role.getRoleId()));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void fillTeam(Collection<Long> collection) {
/* 234 */     for (MapRole role : this.roleMap.values())
/*     */     {
/* 236 */       if ((role.isInTeam()) && 
/*     */       
/*     */ 
/*     */ 
/* 240 */         (!collection.contains(Long.valueOf(role.getTeamId()))))
/*     */       {
/*     */ 
/*     */ 
/* 244 */         collection.add(Long.valueOf(role.getTeamId()));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean containRole(long roleId) {
/* 250 */     return this.roleMap.containsKey(Long.valueOf(roleId));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\zone\SimpleZone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */