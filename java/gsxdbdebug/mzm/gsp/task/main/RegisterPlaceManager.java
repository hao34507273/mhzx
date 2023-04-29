/*     */ package mzm.gsp.task.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.map.main.MapCallback;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.scene.zone.ZoneForm;
/*     */ import mzm.gsp.map.main.scene.zone.bounding.CylinderBounding;
/*     */ import mzm.gsp.map.main.scene.zone.type.event.IZoneListener;
/*     */ import mzm.gsp.task.conParamObj.ToPlaceParamObj;
/*     */ import mzm.gsp.task.confbean.STaskContoPlace;
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
/*     */ 
/*     */ public class RegisterPlaceManager
/*     */ {
/*  27 */   private static Map<PositionInfo, ToPlaceListener> listenerMap = new HashMap();
/*     */   
/*  29 */   private static Object lock = new Object();
/*     */   
/*     */   static void addListener(long roleId, STaskContoPlace sTaskContoPlace)
/*     */   {
/*  33 */     synchronized (lock)
/*     */     {
/*  35 */       PositionInfo positionInfo = new PositionInfo(sTaskContoPlace.mapId, sTaskContoPlace.x, sTaskContoPlace.y, sTaskContoPlace.z);
/*     */       
/*  37 */       if (listenerMap.containsKey(positionInfo))
/*     */       {
/*  39 */         ((ToPlaceListener)listenerMap.get(positionInfo)).addRole(roleId);
/*     */       }
/*     */       else
/*     */       {
/*  43 */         ToPlaceListener toPlaceListener = new ToPlaceListener(positionInfo);
/*  44 */         toPlaceListener.addRole(roleId);
/*  45 */         toPlaceListener.register(sTaskContoPlace.radis);
/*  46 */         listenerMap.put(positionInfo, toPlaceListener);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static void onRoleLogoff(long roleId)
/*     */   {
/*  53 */     synchronized (lock)
/*     */     {
/*  55 */       for (ToPlaceListener toPlaceListener : listenerMap.values())
/*     */       {
/*  57 */         if (toPlaceListener.contains(roleId))
/*     */         {
/*  59 */           toPlaceListener.remRole(roleId);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class ToPlaceListener
/*     */     implements IZoneListener
/*     */   {
/*  68 */     private Set<Long> roleIdSet = new HashSet();
/*     */     
/*     */     private final RegisterPlaceManager.PositionInfo positionInfo;
/*     */     
/*     */     private int eventId;
/*     */     
/*     */     public ToPlaceListener(RegisterPlaceManager.PositionInfo positionInfo)
/*     */     {
/*  76 */       this.positionInfo = positionInfo;
/*     */     }
/*     */     
/*     */ 
/*     */     public void onEnterRole(long roleId, ZoneForm zoneForm)
/*     */     {
/*  82 */       boolean unreg = false;
/*  83 */       synchronized (RegisterPlaceManager.lock)
/*     */       {
/*  85 */         if (!this.roleIdSet.contains(Long.valueOf(roleId)))
/*     */         {
/*  87 */           return;
/*     */         }
/*  89 */         this.roleIdSet.remove(Long.valueOf(roleId));
/*  90 */         if (this.roleIdSet.size() == 0)
/*     */         {
/*  92 */           RegisterPlaceManager.listenerMap.remove(this.positionInfo);
/*  93 */           unreg = true;
/*     */         }
/*     */       }
/*  96 */       if (unreg)
/*     */       {
/*     */ 
/*  99 */         MapInterface.unregisterZoneEvent(this.positionInfo.mapId, this.eventId);
/*     */       }
/* 101 */       ToPlaceParamObj obj = new ToPlaceParamObj();
/* 102 */       obj.setMapId(this.positionInfo.mapId);
/* 103 */       obj.setX(this.positionInfo.x);
/* 104 */       obj.setY(this.positionInfo.y);
/* 105 */       obj.setZ(this.positionInfo.z);
/* 106 */       TaskInterface.updateTaskCondition(roleId, 4, obj);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public void onLeaveRole(long roleId, ZoneForm zoneForm) {}
/*     */     
/*     */ 
/*     */ 
/*     */     public void addRole(long roleId)
/*     */     {
/* 118 */       this.roleIdSet.add(Long.valueOf(roleId));
/*     */     }
/*     */     
/*     */     public void remRole(long roleId)
/*     */     {
/* 123 */       this.roleIdSet.remove(Long.valueOf(roleId));
/*     */     }
/*     */     
/*     */     public boolean contains(long roleId)
/*     */     {
/* 128 */       return this.roleIdSet.contains(Long.valueOf(roleId));
/*     */     }
/*     */     
/*     */     public void register(int r)
/*     */     {
/* 133 */       ZoneForm zf = new CylinderBounding(this.positionInfo.x, this.positionInfo.y, this.positionInfo.z, r);
/* 134 */       MapInterface.registerZoneEvent(this.positionInfo.mapId, zf, 1, this, new MapCallback()
/*     */       {
/*     */ 
/*     */         public boolean isCallInProcedure()
/*     */         {
/* 139 */           return false;
/*     */         }
/*     */         
/*     */ 
/*     */         public boolean onResult(Integer result)
/*     */         {
/* 145 */           RegisterPlaceManager.ToPlaceListener.this.eventId = result.intValue();
/* 146 */           return true;
/*     */         }
/*     */       });
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class PositionInfo
/*     */   {
/*     */     private int mapId;
/*     */     private int x;
/*     */     private int y;
/*     */     private int z;
/*     */     
/*     */     public PositionInfo(int mapId, int x, int y, int z)
/*     */     {
/* 161 */       this.mapId = mapId;
/* 162 */       this.x = x;
/* 163 */       this.y = y;
/* 164 */       this.z = z;
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 170 */       return this.mapId + this.x + this.y + this.z;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 176 */       if ((obj instanceof PositionInfo))
/*     */       {
/* 178 */         PositionInfo objPositionInfo = (PositionInfo)obj;
/* 179 */         if ((this.mapId == objPositionInfo.getMapId()) && (this.x == objPositionInfo.getX()) && (this.y == objPositionInfo.getY()) && (this.z == objPositionInfo.getZ()))
/*     */         {
/*     */ 
/* 182 */           return true;
/*     */         }
/*     */       }
/* 185 */       return false;
/*     */     }
/*     */     
/*     */     public int getMapId()
/*     */     {
/* 190 */       return this.mapId;
/*     */     }
/*     */     
/*     */     public int getX()
/*     */     {
/* 195 */       return this.x;
/*     */     }
/*     */     
/*     */     public int getY()
/*     */     {
/* 200 */       return this.y;
/*     */     }
/*     */     
/*     */     public int getZ()
/*     */     {
/* 205 */       return this.z;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\RegisterPlaceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */