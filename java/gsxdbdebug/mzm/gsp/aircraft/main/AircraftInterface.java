/*     */ package mzm.gsp.aircraft.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.aircraft.AircraftDataInfo;
/*     */ import mzm.gsp.feijian.confbean.Pro2Value;
/*     */ import mzm.gsp.feijian.confbean.SFeiJianCfg;
/*     */ import xbean.AircraftInfo;
/*     */ import xbean.Role2AircraftInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AircraftInterface
/*     */ {
/*     */   public static RideAircraftObj getRideAircraftObj(long roleId, boolean isRemainRolelock)
/*     */   {
/*  24 */     Role2AircraftInfo xRole2AircraftInfo = AircraftManager.getRole2AircraftInfo(roleId, isRemainRolelock);
/*  25 */     if ((xRole2AircraftInfo == null) || (xRole2AircraftInfo.getCurrent_aircraft_cfg_id() <= 0))
/*     */     {
/*  27 */       return null;
/*     */     }
/*     */     
/*  30 */     int rideAircraftCfgId = xRole2AircraftInfo.getCurrent_aircraft_cfg_id();
/*     */     
/*  32 */     AircraftInfo xAircraftInfo = (AircraftInfo)xRole2AircraftInfo.getOwn_aircraft_map().get(Integer.valueOf(rideAircraftCfgId));
/*  33 */     int dyeColorId = xAircraftInfo != null ? xAircraftInfo.getDye_color_id() : -1;
/*     */     
/*  35 */     SFeiJianCfg sFeiJianCfg = SFeiJianCfg.get(rideAircraftCfgId);
/*  36 */     int feiJianSpeed = sFeiJianCfg != null ? sFeiJianCfg.velocity : -1;
/*     */     
/*  38 */     return new RideAircraftObj(rideAircraftCfgId, feiJianSpeed, dyeColorId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static class RideAircraftObj
/*     */   {
/*     */     public final int aircraftCfgId;
/*     */     
/*     */ 
/*     */ 
/*     */     public final int aircraftSpeed;
/*     */     
/*     */ 
/*     */ 
/*     */     public final int aircraftDyeColorId;
/*     */     
/*     */ 
/*     */ 
/*     */     public RideAircraftObj(int aircraftCfgId, int aircraftSpeed, int aircraftDyeColorId)
/*     */     {
/*  60 */       this.aircraftCfgId = aircraftCfgId;
/*  61 */       this.aircraftSpeed = aircraftSpeed;
/*  62 */       this.aircraftDyeColorId = aircraftDyeColorId;
/*     */     }
/*     */   }
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
/*     */   public static Map<Integer, Integer> getAircraftPropertyMap(long roleId, boolean isRemainRolelock)
/*     */   {
/*  78 */     Map<Integer, Integer> propertyMap = null;
/*     */     
/*  80 */     Role2AircraftInfo xRole2AircraftInfo = AircraftManager.getRole2AircraftInfo(roleId, isRemainRolelock);
/*  81 */     if (xRole2AircraftInfo == null)
/*     */     {
/*  83 */       return propertyMap;
/*     */     }
/*     */     
/*  86 */     for (Iterator i$ = xRole2AircraftInfo.getOwn_aircraft_map().keySet().iterator(); i$.hasNext();) { int aircraftCfgId = ((Integer)i$.next()).intValue();
/*     */       
/*  88 */       SFeiJianCfg sFeiJianCfg = SFeiJianCfg.get(aircraftCfgId);
/*  89 */       if ((sFeiJianCfg != null) && 
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  94 */         (!sFeiJianCfg.proList.isEmpty()))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  99 */         if (propertyMap == null)
/*     */         {
/* 101 */           propertyMap = new HashMap();
/*     */         }
/*     */         
/* 104 */         for (Pro2Value pro2Value : sFeiJianCfg.proList)
/*     */         {
/* 106 */           int propertyKey = pro2Value.protype;
/* 107 */           int propertyValue = pro2Value.provalue;
/*     */           
/* 109 */           Integer oldValue = (Integer)propertyMap.get(Integer.valueOf(propertyKey));
/* 110 */           if (oldValue != null)
/*     */           {
/* 112 */             propertyMap.put(Integer.valueOf(propertyKey), Integer.valueOf(oldValue.intValue() + propertyValue));
/*     */           }
/*     */           else
/*     */           {
/* 116 */             propertyMap.put(Integer.valueOf(propertyKey), Integer.valueOf(propertyValue));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 121 */     return propertyMap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getEquipedFeiJianCfgId(long roleId, boolean isRemainRolelock)
/*     */   {
/* 133 */     Role2AircraftInfo xRole2AircraftInfo = AircraftManager.getRole2AircraftInfo(roleId, isRemainRolelock);
/* 134 */     if ((xRole2AircraftInfo == null) || (xRole2AircraftInfo.getCurrent_aircraft_cfg_id() == 0))
/*     */     {
/* 136 */       return -1;
/*     */     }
/*     */     
/* 139 */     return xRole2AircraftInfo.getCurrent_aircraft_cfg_id();
/*     */   }
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
/*     */ 
/*     */ 
/*     */   public static AircraftDataInfo getRoleAircraftInfo(long roleId, int aircraftCfgId, boolean isRemainRolelock)
/*     */   {
/* 156 */     Role2AircraftInfo xRole2AircraftInfo = AircraftManager.getRole2AircraftInfo(roleId, isRemainRolelock);
/* 157 */     if (xRole2AircraftInfo == null)
/*     */     {
/* 159 */       return null;
/*     */     }
/*     */     
/* 162 */     AircraftInfo xAircraftInfo = (AircraftInfo)xRole2AircraftInfo.getOwn_aircraft_map().get(Integer.valueOf(aircraftCfgId));
/* 163 */     if (xAircraftInfo == null)
/*     */     {
/* 165 */       return null;
/*     */     }
/*     */     
/* 168 */     return new AircraftDataInfo(aircraftCfgId, xAircraftInfo.getDye_color_id());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<Integer> getOwnAircraftCfgIdList(long roleId, boolean isRemainRolelock)
/*     */   {
/* 181 */     return AircraftManager.getOwnAircraftCfgIdList(roleId, isRemainRolelock);
/*     */   }
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
/*     */   public static int removeAircraft(long roleId, int aircraftCfgId)
/*     */   {
/* 195 */     return AircraftManager.removeAircraft(roleId, aircraftCfgId);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\aircraft\main\AircraftInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */