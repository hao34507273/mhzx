/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.homeland.SSynCourtYardBeautifulRes;
/*     */ import mzm.gsp.homeland.confbean.SCourtyardCfg;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfgConsts;
/*     */ import mzm.gsp.homeland.confbean.SSameFurnitureCfg;
/*     */ import mzm.gsp.item.confbean.SFurnitureItem;
/*     */ import mzm.gsp.map.main.MapCallback;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.UuidUtils;
/*     */ import mzm.gsp.util.UuidUtils.UuidType;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FurnitureInfo;
/*     */ import xbean.FurnitureUuIds;
/*     */ import xbean.HomeInfo;
/*     */ import xbean.HomeOperate;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CourtYardManager
/*     */ {
/*     */   static Map<Integer, Set<Long>> moveCourtYardAllFurnitureFromHome2Bag(HomeInfo xHomeInfo, boolean isOwner, HomeOperate xHomeOperate, boolean isMoveSpecialFurniture)
/*     */   {
/*  50 */     Map<Integer, Set<Long>> ret = new HashMap();
/*  51 */     Map<Long, FurnitureInfo> xDisplayUuid2XFurnitureInfoMap = null;
/*  52 */     if (isOwner)
/*     */     {
/*  54 */       xDisplayUuid2XFurnitureInfoMap = xHomeInfo.getMydisplayfurniture();
/*     */     }
/*     */     else
/*     */     {
/*  58 */       xDisplayUuid2XFurnitureInfoMap = xHomeInfo.getPartnerdisplayfurniture();
/*     */     }
/*  60 */     FurnitureInfo xFenceFurnitureInfo = (FurnitureInfo)xDisplayUuid2XFurnitureInfoMap.get(Long.valueOf(xHomeInfo.getFence_uuid()));
/*  61 */     FurnitureInfo xTerrainFurnitureInfo = (FurnitureInfo)xDisplayUuid2XFurnitureInfoMap.get(Long.valueOf(xHomeInfo.getCourt_yard_terrain_uuid()));
/*  62 */     FurnitureInfo xRoadFurnitureInfo = (FurnitureInfo)xDisplayUuid2XFurnitureInfoMap.get(Long.valueOf(xHomeInfo.getCourt_yard_road_uuid()));
/*     */     
/*  64 */     Iterator<Long> iter = xDisplayUuid2XFurnitureInfoMap.keySet().iterator();
/*  65 */     while (iter.hasNext())
/*     */     {
/*  67 */       long uuid = ((Long)iter.next()).longValue();
/*  68 */       if (!HomelandManager.isSpecialFurniture(uuid, xHomeInfo))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  73 */         FurnitureInfo xFurnitureInfo = (FurnitureInfo)xDisplayUuid2XFurnitureInfoMap.get(Long.valueOf(uuid));
/*     */         
/*  75 */         int furnitureid = xFurnitureInfo.getFurnitureid();
/*  76 */         SFurnitureItem sFurnitureItem = SFurnitureItem.get(furnitureid);
/*  77 */         if ((sFurnitureItem != null) && (sFurnitureItem.area == 2))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*  82 */           Set<Long> uuids = (Set)ret.get(Integer.valueOf(furnitureid));
/*  83 */           if (uuids == null)
/*     */           {
/*  85 */             uuids = new HashSet();
/*  86 */             ret.put(Integer.valueOf(xFurnitureInfo.getFurnitureid()), uuids);
/*     */           }
/*  88 */           uuids.add(Long.valueOf(uuid));
/*     */           
/*  90 */           HomelandManager.addFurniture2Bag(furnitureid, uuid, xHomeOperate);
/*  91 */           iter.remove();
/*     */         } } }
/*  93 */     if (isMoveSpecialFurniture)
/*     */     {
/*  95 */       if (xFenceFurnitureInfo != null)
/*     */       {
/*  97 */         HomelandManager.addFurniture2Bag(xFenceFurnitureInfo.getFurnitureid(), xHomeInfo.getFence_uuid(), xHomeOperate);
/*  98 */         xDisplayUuid2XFurnitureInfoMap.remove(Long.valueOf(xHomeInfo.getFence_uuid()));
/*  99 */         xHomeInfo.setFence_uuid(0L);
/*     */       }
/* 101 */       if (xTerrainFurnitureInfo != null)
/*     */       {
/* 103 */         HomelandManager.addFurniture2Bag(xTerrainFurnitureInfo.getFurnitureid(), xHomeInfo.getCourt_yard_terrain_uuid(), xHomeOperate);
/*     */         
/* 105 */         xDisplayUuid2XFurnitureInfoMap.remove(Long.valueOf(xHomeInfo.getCourt_yard_terrain_uuid()));
/* 106 */         xHomeInfo.setCourt_yard_terrain_uuid(0L);
/*     */       }
/* 108 */       if (xRoadFurnitureInfo != null)
/*     */       {
/* 110 */         HomelandManager.addFurniture2Bag(xRoadFurnitureInfo.getFurnitureid(), xHomeInfo.getCourt_yard_road_uuid(), xHomeOperate);
/*     */         
/* 112 */         xDisplayUuid2XFurnitureInfoMap.remove(Long.valueOf(xHomeInfo.getCourt_yard_road_uuid()));
/* 113 */         xHomeInfo.setCourt_yard_road_uuid(0L);
/*     */       }
/*     */     }
/*     */     
/* 117 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isCourtLevelUpSwitchOpenForRole(long roleId)
/*     */   {
/* 125 */     if (!OpenInterface.getOpenStatus(337))
/*     */     {
/* 127 */       return false;
/*     */     }
/* 129 */     if (OpenInterface.isBanPlay(roleId, 337))
/*     */     {
/* 131 */       OpenInterface.sendBanPlayMsg(roleId, 337);
/* 132 */       return false;
/*     */     }
/* 134 */     return true;
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
/*     */   static int computeFurnitureBeautiful(HomeInfo xHomeInfo)
/*     */   {
/* 147 */     int total = 0;
/*     */     
/* 149 */     Map<Integer, List<Integer>> sameId2FurnitureIds = HomelandManager.getSameDisplayFurnitures(xHomeInfo, 2);
/*     */     
/* 151 */     for (Iterator i$ = sameId2FurnitureIds.keySet().iterator(); i$.hasNext();) { int sameId = ((Integer)i$.next()).intValue();
/*     */       
/* 153 */       SSameFurnitureCfg sameFurnitureCfg = SSameFurnitureCfg.get(sameId);
/* 154 */       if (sameFurnitureCfg != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 159 */         total += getMaxBeautifulValue((List)sameId2FurnitureIds.get(Integer.valueOf(sameId)), sameFurnitureCfg.max_add_beautiful_furniture_num);
/*     */       }
/*     */     }
/* 162 */     xHomeInfo.setCourt_yard_beautiful(total);
/* 163 */     return getBeautiful(xHomeInfo);
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
/*     */   private static int getMaxBeautifulValue(List<Integer> furnitureIds, int maxNum)
/*     */   {
/* 178 */     int addValue = 0;
/*     */     
/* 180 */     if (furnitureIds.size() <= maxNum)
/*     */     {
/* 182 */       for (int i = 0; i < furnitureIds.size(); i++)
/*     */       {
/* 184 */         SFurnitureItem furnitureItem = SFurnitureItem.get(((Integer)furnitureIds.get(i)).intValue());
/* 185 */         if (furnitureItem != null)
/*     */         {
/* 187 */           addValue += furnitureItem.addBeautifulValue;
/*     */         }
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 193 */       int size = Math.min(furnitureIds.size(), maxNum);
/* 194 */       Comparator<Integer> comp = new CourtYardFurnitureItemComparator(null);
/*     */       
/* 196 */       Collections.sort(furnitureIds, comp);
/* 197 */       int c = 0;
/* 198 */       for (int i = furnitureIds.size() - 1; i >= 0; i--)
/*     */       {
/* 200 */         SFurnitureItem furnitureItem = SFurnitureItem.get(((Integer)furnitureIds.get(i)).intValue());
/* 201 */         if (furnitureItem != null)
/*     */         {
/* 203 */           addValue += furnitureItem.addBeautifulValue;
/* 204 */           c++;
/*     */         }
/* 206 */         if (c >= size) {
/*     */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 212 */     return addValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static class CourtYardFurnitureItemComparator
/*     */     implements Comparator<Integer>
/*     */   {
/*     */     public int compare(Integer o1, Integer o2)
/*     */     {
/* 225 */       SFurnitureItem s1 = SFurnitureItem.get(o1.intValue());
/* 226 */       SFurnitureItem s2 = SFurnitureItem.get(o2.intValue());
/* 227 */       if ((s1 == null) || (s2 == null))
/*     */       {
/* 229 */         return 0;
/*     */       }
/* 231 */       return s1.addBeautifulValue - s2.addBeautifulValue;
/*     */     }
/*     */   }
/*     */   
/*     */   static int getBeautiful(HomeInfo xHomeInfo)
/*     */   {
/* 237 */     SCourtyardCfg sCourtyardCfg = SCourtyardCfg.get(xHomeInfo.getCourtyardlevel());
/* 238 */     if (sCourtyardCfg == null)
/*     */     {
/* 240 */       return 0;
/*     */     }
/*     */     
/* 243 */     return Math.min(xHomeInfo.getCourt_yard_beautiful() + SHomelandCfgConsts.getInstance().init_homeland_beautiful, sCourtyardCfg.max_beautifual);
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
/*     */   static void sendSSynBeautifulRes(long roleId, int buautiful)
/*     */   {
/* 257 */     SSynCourtYardBeautifulRes res = new SSynCourtYardBeautifulRes();
/* 258 */     res.beautiful = buautiful;
/* 259 */     OnlineManager.getInstance().send(roleId, res);
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
/*     */ 
/*     */ 
/*     */   static boolean cutCourtYardCleanliness(HomeInfoWrapper homeInfoWrapper, long now)
/*     */   {
/* 278 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/* 279 */     checkAndInitCourtYardCleanliness(xHomeInfo);
/* 280 */     if (!DateTimeUtils.needDailyReset(xHomeInfo.getCourt_yard_cleanliness_refresh_time(), now, 0))
/*     */     {
/* 282 */       return false;
/*     */     }
/*     */     
/* 285 */     int courtYardLevel = xHomeInfo.getCourtyardlevel();
/* 286 */     SCourtyardCfg sCourtyardCfg = SCourtyardCfg.get(courtYardLevel);
/* 287 */     if (sCourtyardCfg == null)
/*     */     {
/* 289 */       return false;
/*     */     }
/*     */     
/* 292 */     int oldNum = xHomeInfo.getCourt_yard_cleanliness();
/* 293 */     int cutNum = sCourtyardCfg.day_cut_cleanliness * Math.abs(DateTimeUtils.diffDays(now, xHomeInfo.getCourt_yard_cleanliness_refresh_time()));
/*     */     
/* 295 */     xHomeInfo.setCourt_yard_cleanliness(Math.max(0, xHomeInfo.getCourt_yard_cleanliness() - cutNum));
/* 296 */     xHomeInfo.setCourt_yard_day_clean_count(0);
/* 297 */     xHomeInfo.setCourt_yard_cleanliness_refresh_time(now);
/*     */     
/*     */ 
/* 300 */     changeCourtYardCleanlinessIntoWorld(xHomeInfo, homeInfoWrapper.getOwnerRoleId());
/*     */     
/* 302 */     StringBuilder sb = new StringBuilder();
/* 303 */     sb.append("[home]CourtYardManager.cutCourtYardCleanliness@cut cleanliness success");
/* 304 */     sb.append("|role_id=").append(homeInfoWrapper.getOwnerRoleId());
/* 305 */     sb.append("|partner_role_id=").append(homeInfoWrapper.getPartnerRoleId());
/* 306 */     sb.append("|old_clean_liness=").append(oldNum);
/* 307 */     sb.append("|now=").append(now);
/* 308 */     sb.append("|current_clean_liness=").append(xHomeInfo.getCourt_yard_cleanliness());
/* 309 */     sb.append("|court_level=").append(xHomeInfo.getCourtyardlevel());
/*     */     
/* 311 */     GameServer.logger().info(sb.toString());
/* 312 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void changeCourtYardCleanlinessIntoWorld(HomeInfo xHomeInfo, long ownerRoleId)
/*     */   {
/* 320 */     checkAndInitCourtYardCleanliness(xHomeInfo);
/*     */     
/* 322 */     Map<Integer, Integer> intExtraInfoEntries = new HashMap();
/* 323 */     intExtraInfoEntries.put(Integer.valueOf(308), Integer.valueOf(xHomeInfo.getCourt_yard_cleanliness()));
/*     */     
/* 325 */     MapInterface.changeMapEntityExtraInfos(MapEntityType.MGT_HOME_LAND_BASIC_INFO, ownerRoleId, intExtraInfoEntries, null, null, null, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void changeCourtYardBeautifulIntoWorld(HomeInfo xHomeInfo, long ownerRoleId)
/*     */   {
/* 334 */     Map<Integer, Integer> intExtraInfoEntries = new HashMap();
/* 335 */     intExtraInfoEntries.put(Integer.valueOf(309), Integer.valueOf(getBeautiful(xHomeInfo)));
/*     */     
/* 337 */     MapInterface.changeMapEntityExtraInfos(MapEntityType.MGT_HOME_LAND_BASIC_INFO, ownerRoleId, intExtraInfoEntries, null, null, null, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void changeCourtYardLevelIntoWorld(HomeInfo xHomeInfo, long ownerRoleId)
/*     */   {
/* 346 */     Map<Integer, Integer> intExtraInfoEntries = new HashMap();
/* 347 */     intExtraInfoEntries.put(Integer.valueOf(307), Integer.valueOf(xHomeInfo.getCourtyardlevel()));
/* 348 */     MapInterface.changeMapEntityExtraInfos(MapEntityType.MGT_HOME_LAND_BASIC_INFO, ownerRoleId, intExtraInfoEntries, null, null, null, null);
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
/*     */   static void addAllCourtYardFurnitureIntoWorld(long homeWorldId, int mapCfgid, HomeInfo xHomeInfo)
/*     */   {
/* 364 */     for (Iterator i$ = xHomeInfo.getMydisplayfurniture().keySet().iterator(); i$.hasNext();) { long uuid = ((Long)i$.next()).longValue();
/*     */       
/* 366 */       if (!HomelandManager.isSpecialFurniture(uuid, xHomeInfo))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 371 */         FurnitureInfo xFurnitureInfo = (FurnitureInfo)xHomeInfo.getMydisplayfurniture().get(Long.valueOf(uuid));
/* 372 */         SFurnitureItem sFurnitureItem = SFurnitureItem.get(xFurnitureInfo.getFurnitureid());
/* 373 */         if ((sFurnitureItem != null) && (sFurnitureItem.area == 2))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 378 */           addFurnitureIntoWorld(homeWorldId, mapCfgid, xFurnitureInfo.getFurnitureid(), uuid, xFurnitureInfo.getX(), xFurnitureInfo.getY(), xFurnitureInfo.getDirection(), false, null); }
/*     */       }
/*     */     }
/* 381 */     for (Iterator i$ = xHomeInfo.getPartnerdisplayfurniture().keySet().iterator(); i$.hasNext();) { long uuid = ((Long)i$.next()).longValue();
/*     */       
/* 383 */       if (!HomelandManager.isSpecialFurniture(uuid, xHomeInfo))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 388 */         FurnitureInfo xFurnitureInfo = (FurnitureInfo)xHomeInfo.getPartnerdisplayfurniture().get(Long.valueOf(uuid));
/* 389 */         SFurnitureItem sFurnitureItem = SFurnitureItem.get(xFurnitureInfo.getFurnitureid());
/* 390 */         if ((sFurnitureItem != null) && (sFurnitureItem.area == 2))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 395 */           addFurnitureIntoWorld(homeWorldId, mapCfgid, xFurnitureInfo.getFurnitureid(), uuid, xFurnitureInfo.getX(), xFurnitureInfo.getY(), xFurnitureInfo.getDirection(), false, null);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 400 */     FurnitureInfo xCourtTerrainFurnitureInfo = getTerrainFurnitureInfo(xHomeInfo);
/* 401 */     if (xCourtTerrainFurnitureInfo != null)
/*     */     {
/* 403 */       addTerrainIntoWorld(xHomeInfo.getCourt_yard_terrain_uuid(), homeWorldId, mapCfgid, xCourtTerrainFurnitureInfo.getFurnitureid());
/*     */     }
/*     */     
/*     */ 
/* 407 */     FurnitureInfo xFenceFurnitureInfo = getFenceFurnitureInfo(xHomeInfo);
/* 408 */     if (xFenceFurnitureInfo != null)
/*     */     {
/* 410 */       addFenceIntoWorld(xHomeInfo.getFence_uuid(), homeWorldId, mapCfgid, xFenceFurnitureInfo.getFurnitureid());
/*     */     }
/*     */     
/* 413 */     FurnitureInfo xRoadFurnitureInfo = getRoadFurnitureInfo(xHomeInfo);
/* 414 */     if (xFenceFurnitureInfo != null)
/*     */     {
/* 416 */       addRoadIntoWorld(xHomeInfo.getCourt_yard_road_uuid(), homeWorldId, mapCfgid, xRoadFurnitureInfo.getFurnitureid());
/*     */     }
/*     */   }
/*     */   
/*     */   static FurnitureInfo getTerrainFurnitureInfo(HomeInfo xHomeInfo)
/*     */   {
/* 422 */     long xCourtYardTerrainUuid = xHomeInfo.getCourt_yard_terrain_uuid();
/* 423 */     FurnitureInfo xCourtTerrainFurnitureInfo = (FurnitureInfo)xHomeInfo.getMydisplayfurniture().get(Long.valueOf(xCourtYardTerrainUuid));
/* 424 */     if (xCourtTerrainFurnitureInfo != null)
/*     */     {
/* 426 */       return xCourtTerrainFurnitureInfo;
/*     */     }
/*     */     
/*     */ 
/* 430 */     xCourtTerrainFurnitureInfo = (FurnitureInfo)xHomeInfo.getPartnerdisplayfurniture().get(Long.valueOf(xCourtYardTerrainUuid));
/* 431 */     return xCourtTerrainFurnitureInfo;
/*     */   }
/*     */   
/*     */ 
/*     */   static FurnitureInfo getFenceFurnitureInfo(HomeInfo xHomeInfo)
/*     */   {
/* 437 */     long xFenceUuid = xHomeInfo.getFence_uuid();
/* 438 */     FurnitureInfo xFenceFurnitureInfo = (FurnitureInfo)xHomeInfo.getMydisplayfurniture().get(Long.valueOf(xFenceUuid));
/* 439 */     if (xFenceFurnitureInfo != null)
/*     */     {
/* 441 */       return xFenceFurnitureInfo;
/*     */     }
/*     */     
/*     */ 
/* 445 */     xFenceFurnitureInfo = (FurnitureInfo)xHomeInfo.getPartnerdisplayfurniture().get(Long.valueOf(xFenceUuid));
/* 446 */     return xFenceFurnitureInfo;
/*     */   }
/*     */   
/*     */ 
/*     */   static FurnitureInfo getRoadFurnitureInfo(HomeInfo xHomeInfo)
/*     */   {
/* 452 */     long xRoadUuid = xHomeInfo.getCourt_yard_road_uuid();
/* 453 */     FurnitureInfo xRoadFurnitureInfo = (FurnitureInfo)xHomeInfo.getMydisplayfurniture().get(Long.valueOf(xRoadUuid));
/* 454 */     if (xRoadFurnitureInfo != null)
/*     */     {
/* 456 */       return xRoadFurnitureInfo;
/*     */     }
/*     */     
/*     */ 
/* 460 */     xRoadFurnitureInfo = (FurnitureInfo)xHomeInfo.getPartnerdisplayfurniture().get(Long.valueOf(xRoadUuid));
/* 461 */     return xRoadFurnitureInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void addFurnitureIntoWorld(long homeWorldId, int mapCfgid, int furnitureId, long furnitureUuid, int x, int y, int direction, boolean isNeedCheck, MapCallback<Boolean> callback)
/*     */   {
/* 468 */     Map<Integer, Integer> intExtraInfoEntries = new HashMap();
/* 469 */     intExtraInfoEntries.put(Integer.valueOf(0), Integer.valueOf(direction));
/* 470 */     MapInterface.addMapEntity(MapEntityType.MET_FURNITURE, furnitureUuid, homeWorldId, mapCfgid, x, y, furnitureId, intExtraInfoEntries, null, null, isNeedCheck, callback);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addTerrainIntoWorld(long furnitureUuid, long homeWorldId, int mapCfgid, int furnitureId)
/*     */   {
/* 479 */     MapInterface.addMapEntity(MapEntityType.MET_TERRAIN, furnitureUuid, homeWorldId, mapCfgid, furnitureId, null, null, null, null);
/*     */   }
/*     */   
/*     */ 
/*     */   static void removeTerrainMapEntity(long uuid)
/*     */   {
/* 485 */     MapInterface.removeMapEntity(MapEntityType.MET_TERRAIN, uuid, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addFenceIntoWorld(long furnitureUuid, long homeWorldId, int mapCfgid, int furnitureId)
/*     */   {
/* 493 */     MapInterface.addMapEntity(MapEntityType.MET_BARRIERS, furnitureUuid, homeWorldId, mapCfgid, furnitureId, null, null, null, null);
/*     */   }
/*     */   
/*     */ 
/*     */   static void removeFenceMapEntity(long uuid)
/*     */   {
/* 499 */     MapInterface.removeMapEntity(MapEntityType.MET_BARRIERS, uuid, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addRoadIntoWorld(long furnitureUuid, long homeWorldId, int mapCfgid, int furnitureId)
/*     */   {
/* 507 */     MapInterface.addMapEntity(MapEntityType.MET_ROADS, furnitureUuid, homeWorldId, mapCfgid, furnitureId, null, null, null, null);
/*     */   }
/*     */   
/*     */ 
/*     */   static void removeRoadMapEntity(long uuid)
/*     */   {
/* 513 */     MapInterface.removeMapEntity(MapEntityType.MET_ROADS, uuid, null);
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
/*     */   static void initCourtYardSpellFurniture(long roleId, HomeInfo xHomeInfo, HomeOperate xHomeOperate)
/*     */   {
/* 528 */     Map<Long, FurnitureInfo> xMyDisplayFurnitureMap = xHomeInfo.getMydisplayfurniture();
/*     */     
/* 530 */     FurnitureInfo xRoadFurnitureInfo = getRoadFurnitureInfo(xHomeInfo);
/* 531 */     if (xRoadFurnitureInfo == null)
/*     */     {
/* 533 */       int initCourtYardRoleItemCfgId = SHomelandCfgConsts.getInstance().init_court_yard_road_item_cfg_id;
/* 534 */       FurnitureUuIds xFurnitureUuIds = (FurnitureUuIds)xHomeOperate.getOwnfurnitures().get(Integer.valueOf(initCourtYardRoleItemCfgId));
/* 535 */       if ((xFurnitureUuIds != null) && (!xFurnitureUuIds.getUuids().isEmpty()))
/*     */       {
/* 537 */         long roadUuid = ((Long)xFurnitureUuIds.getUuids().iterator().next()).longValue();
/* 538 */         xFurnitureUuIds.getUuids().remove(Long.valueOf(roadUuid));
/*     */         
/* 540 */         xHomeInfo.setCourt_yard_road_uuid(roadUuid);
/* 541 */         xRoadFurnitureInfo = HomelandManager.getxFurnitureInfo(SHomelandCfgConsts.getInstance().init_court_yard_road_item_cfg_id, 0, 0, -1);
/*     */         
/* 543 */         xMyDisplayFurnitureMap.put(Long.valueOf(roadUuid), xRoadFurnitureInfo);
/* 544 */         HomelandManager.sendSDecFurnitureRes(roleId, initCourtYardRoleItemCfgId, roadUuid, 2);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 549 */         long roadUuid = UuidUtils.generateUuid(UuidUtils.UuidType.Item);
/* 550 */         xHomeInfo.setCourt_yard_road_uuid(roadUuid);
/* 551 */         xRoadFurnitureInfo = HomelandManager.getxFurnitureInfo(initCourtYardRoleItemCfgId, 0, 0, -1);
/* 552 */         xMyDisplayFurnitureMap.put(Long.valueOf(roadUuid), xRoadFurnitureInfo);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 557 */     FurnitureInfo xTerrainFurnitureInfo = getTerrainFurnitureInfo(xHomeInfo);
/* 558 */     if (xTerrainFurnitureInfo == null)
/*     */     {
/* 560 */       int initCourtYardTerrainItemCfgId = SHomelandCfgConsts.getInstance().init_court_yard_terrain_item_cfg_id;
/*     */       
/* 562 */       FurnitureUuIds xFurnitureUuIds = (FurnitureUuIds)xHomeOperate.getOwnfurnitures().get(Integer.valueOf(initCourtYardTerrainItemCfgId));
/* 563 */       if ((xFurnitureUuIds != null) && (!xFurnitureUuIds.getUuids().isEmpty()))
/*     */       {
/* 565 */         long terrainuuid = ((Long)xFurnitureUuIds.getUuids().iterator().next()).longValue();
/* 566 */         xFurnitureUuIds.getUuids().remove(Long.valueOf(terrainuuid));
/* 567 */         xHomeInfo.setCourt_yard_terrain_uuid(terrainuuid);
/* 568 */         xTerrainFurnitureInfo = HomelandManager.getxFurnitureInfo(initCourtYardTerrainItemCfgId, 0, 0, -1);
/* 569 */         xMyDisplayFurnitureMap.put(Long.valueOf(terrainuuid), xTerrainFurnitureInfo);
/*     */         
/* 571 */         HomelandManager.sendSDecFurnitureRes(roleId, initCourtYardTerrainItemCfgId, terrainuuid, 2);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 576 */         long terrainUuid = UuidUtils.generateUuid(UuidUtils.UuidType.Item);
/* 577 */         xHomeInfo.setCourt_yard_terrain_uuid(terrainUuid);
/* 578 */         xTerrainFurnitureInfo = HomelandManager.getxFurnitureInfo(initCourtYardTerrainItemCfgId, 0, 0, -1);
/* 579 */         xMyDisplayFurnitureMap.put(Long.valueOf(terrainUuid), xTerrainFurnitureInfo);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 585 */     FurnitureInfo xFenceFurnitureInfo = getFenceFurnitureInfo(xHomeInfo);
/* 586 */     if (xFenceFurnitureInfo == null)
/*     */     {
/* 588 */       int initCourtYardFenceItemCfgId = SHomelandCfgConsts.getInstance().init_court_yard_fence_item_cfg_id;
/* 589 */       FurnitureUuIds xFurnitureUuIds = (FurnitureUuIds)xHomeOperate.getOwnfurnitures().get(Integer.valueOf(initCourtYardFenceItemCfgId));
/* 590 */       if ((xFurnitureUuIds != null) && (!xFurnitureUuIds.getUuids().isEmpty()))
/*     */       {
/* 592 */         long fenceuuid = ((Long)xFurnitureUuIds.getUuids().iterator().next()).longValue();
/* 593 */         xFurnitureUuIds.getUuids().remove(Long.valueOf(fenceuuid));
/*     */         
/* 595 */         xHomeInfo.setFence_uuid(fenceuuid);
/* 596 */         xFenceFurnitureInfo = HomelandManager.getxFurnitureInfo(initCourtYardFenceItemCfgId, 0, 0, -1);
/* 597 */         xMyDisplayFurnitureMap.put(Long.valueOf(fenceuuid), xFenceFurnitureInfo);
/*     */         
/* 599 */         HomelandManager.sendSDecFurnitureRes(roleId, initCourtYardFenceItemCfgId, fenceuuid, 2);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 604 */         long fenceUuid = UuidUtils.generateUuid(UuidUtils.UuidType.Item);
/* 605 */         xHomeInfo.setFence_uuid(fenceUuid);
/* 606 */         xFenceFurnitureInfo = HomelandManager.getxFurnitureInfo(initCourtYardFenceItemCfgId, 0, 0, -1);
/* 607 */         xMyDisplayFurnitureMap.put(Long.valueOf(fenceUuid), xFenceFurnitureInfo);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static int getHomelandCourtMapCfgId(int courtYardLevel)
/*     */   {
/* 615 */     SCourtyardCfg sCourtyardCfg = SCourtyardCfg.get(courtYardLevel);
/* 616 */     if (sCourtyardCfg == null)
/*     */     {
/* 618 */       return -1;
/*     */     }
/* 620 */     return sCourtyardCfg.mapId;
/*     */   }
/*     */   
/*     */   private static FurnitureInfo returnFenceToRole(HomeInfoWrapper homeInfoWrapper)
/*     */   {
/* 625 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/* 626 */     long ownerRoleid = homeInfoWrapper.getOwnerRoleId();
/* 627 */     long partnerRoleid = homeInfoWrapper.getPartnerRoleId();
/* 628 */     long xFenceUuid = xHomeInfo.getFence_uuid();
/* 629 */     FurnitureInfo xFenceFurnitureInfo = (FurnitureInfo)xHomeInfo.getMydisplayfurniture().remove(Long.valueOf(xFenceUuid));
/* 630 */     if (xFenceFurnitureInfo != null)
/*     */     {
/* 632 */       HomeOperate xHomeOperate = HomelandManager.getXHomeOperate(ownerRoleid);
/* 633 */       HomelandManager.addFurniture2Bag(xFenceFurnitureInfo.getFurnitureid(), xFenceUuid, xHomeOperate);
/* 634 */       HomelandManager.sendSAddFurnitureRes(ownerRoleid, xFenceFurnitureInfo.getFurnitureid(), xFenceUuid);
/* 635 */       return xFenceFurnitureInfo;
/*     */     }
/*     */     
/*     */ 
/* 639 */     if (partnerRoleid != -1L)
/*     */     {
/* 641 */       xFenceFurnitureInfo = (FurnitureInfo)xHomeInfo.getPartnerdisplayfurniture().remove(Long.valueOf(xFenceUuid));
/* 642 */       if (xFenceFurnitureInfo != null)
/*     */       {
/* 644 */         HomeOperate xHomeOperate = HomelandManager.getXHomeOperate(partnerRoleid);
/* 645 */         HomelandManager.addFurniture2Bag(xFenceFurnitureInfo.getFurnitureid(), xFenceUuid, xHomeOperate);
/* 646 */         HomelandManager.sendSAddFurnitureRes(partnerRoleid, xFenceFurnitureInfo.getFurnitureid(), xFenceUuid);
/*     */       }
/* 648 */       return xFenceFurnitureInfo;
/*     */     }
/*     */     
/*     */ 
/* 652 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static FurnitureInfo returnRoadToRole(HomeInfoWrapper homeInfoWrapper)
/*     */   {
/* 660 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/* 661 */     long ownerRoleid = homeInfoWrapper.getOwnerRoleId();
/* 662 */     long partnerRoleid = homeInfoWrapper.getPartnerRoleId();
/* 663 */     long xRoadUuid = xHomeInfo.getCourt_yard_road_uuid();
/* 664 */     FurnitureInfo xRoadFurnitureInfo = (FurnitureInfo)xHomeInfo.getMydisplayfurniture().remove(Long.valueOf(xRoadUuid));
/* 665 */     if (xRoadFurnitureInfo != null)
/*     */     {
/* 667 */       HomeOperate xHomeOperate = HomelandManager.getXHomeOperate(ownerRoleid);
/* 668 */       HomelandManager.addFurniture2Bag(xRoadFurnitureInfo.getFurnitureid(), xRoadUuid, xHomeOperate);
/* 669 */       HomelandManager.sendSAddFurnitureRes(ownerRoleid, xRoadFurnitureInfo.getFurnitureid(), xRoadUuid);
/* 670 */       return xRoadFurnitureInfo;
/*     */     }
/*     */     
/*     */ 
/* 674 */     if (partnerRoleid != -1L)
/*     */     {
/* 676 */       xRoadFurnitureInfo = (FurnitureInfo)xHomeInfo.getPartnerdisplayfurniture().remove(Long.valueOf(xRoadUuid));
/* 677 */       if (xRoadFurnitureInfo != null)
/*     */       {
/* 679 */         HomeOperate xHomeOperate = HomelandManager.getXHomeOperate(partnerRoleid);
/* 680 */         HomelandManager.addFurniture2Bag(xRoadFurnitureInfo.getFurnitureid(), xRoadUuid, xHomeOperate);
/* 681 */         HomelandManager.sendSAddFurnitureRes(partnerRoleid, xRoadFurnitureInfo.getFurnitureid(), xRoadUuid);
/*     */       }
/* 683 */       return xRoadFurnitureInfo;
/*     */     }
/* 685 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   private static FurnitureInfo returnTerrainToRole(HomeInfoWrapper homeInfoWrapper)
/*     */   {
/* 691 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/* 692 */     long ownerRoleid = homeInfoWrapper.getOwnerRoleId();
/* 693 */     long partnerRoleid = homeInfoWrapper.getPartnerRoleId();
/* 694 */     long xTerrainUuid = xHomeInfo.getCourt_yard_terrain_uuid();
/* 695 */     FurnitureInfo xRoadFurnitureInfo = (FurnitureInfo)xHomeInfo.getMydisplayfurniture().remove(Long.valueOf(xTerrainUuid));
/* 696 */     if (xRoadFurnitureInfo != null)
/*     */     {
/* 698 */       HomeOperate xHomeOperate = HomelandManager.getXHomeOperate(ownerRoleid);
/* 699 */       HomelandManager.addFurniture2Bag(xRoadFurnitureInfo.getFurnitureid(), xTerrainUuid, xHomeOperate);
/* 700 */       HomelandManager.sendSAddFurnitureRes(ownerRoleid, xRoadFurnitureInfo.getFurnitureid(), xTerrainUuid);
/* 701 */       return xRoadFurnitureInfo;
/*     */     }
/*     */     
/*     */ 
/* 705 */     if (partnerRoleid != -1L)
/*     */     {
/* 707 */       xRoadFurnitureInfo = (FurnitureInfo)xHomeInfo.getPartnerdisplayfurniture().remove(Long.valueOf(xTerrainUuid));
/* 708 */       if (xRoadFurnitureInfo != null)
/*     */       {
/* 710 */         HomeOperate xHomeOperate = HomelandManager.getXHomeOperate(partnerRoleid);
/* 711 */         HomelandManager.addFurniture2Bag(xRoadFurnitureInfo.getFurnitureid(), xTerrainUuid, xHomeOperate);
/* 712 */         HomelandManager.sendSAddFurnitureRes(partnerRoleid, xRoadFurnitureInfo.getFurnitureid(), xTerrainUuid);
/*     */       }
/* 714 */       return xRoadFurnitureInfo;
/*     */     }
/* 716 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   static FurnitureInfo returnSpecialFurtinureToRole(HomeInfoWrapper homeInfoWrapper, int pos)
/*     */   {
/* 722 */     if (pos == 11)
/*     */     {
/* 724 */       return returnFenceToRole(homeInfoWrapper);
/*     */     }
/* 726 */     if (pos == 12)
/*     */     {
/* 728 */       return returnTerrainToRole(homeInfoWrapper);
/*     */     }
/* 730 */     if (pos == 13)
/*     */     {
/* 732 */       return returnRoadToRole(homeInfoWrapper);
/*     */     }
/*     */     
/*     */ 
/* 736 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   static long getSpecialFurnitureUuid(HomeInfo xHomeInfo, int pos)
/*     */   {
/* 742 */     if (pos == 11)
/*     */     {
/* 744 */       return xHomeInfo.getFence_uuid();
/*     */     }
/* 746 */     if (pos == 12)
/*     */     {
/* 748 */       return xHomeInfo.getCourt_yard_terrain_uuid();
/*     */     }
/* 750 */     if (pos == 13)
/*     */     {
/* 752 */       return xHomeInfo.getCourt_yard_road_uuid();
/*     */     }
/*     */     
/*     */ 
/* 756 */     return 0L;
/*     */   }
/*     */   
/*     */ 
/*     */   static void removeSpecialFurnitureMapEntity(long uuid, int pos)
/*     */   {
/* 762 */     if (pos == 11)
/*     */     {
/* 764 */       removeFenceMapEntity(uuid);
/*     */     }
/* 766 */     else if (pos == 12)
/*     */     {
/* 768 */       removeTerrainMapEntity(uuid);
/*     */     }
/* 770 */     else if (pos == 13)
/*     */     {
/* 772 */       removeRoadMapEntity(uuid);
/*     */     } else {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void changeCourtYardSpecialFurniture(HomeInfo xHomeInfo, boolean isOwner, int newItemCfgId, long newUuid, int pos)
/*     */   {
/* 783 */     FurnitureInfo xFurnitureInfo = HomelandManager.getxFurnitureInfo(newItemCfgId, 0, 0, -1);
/*     */     
/* 785 */     if (pos == 11)
/*     */     {
/* 787 */       xHomeInfo.setFence_uuid(newUuid);
/*     */     }
/* 789 */     else if (pos == 12)
/*     */     {
/* 791 */       xHomeInfo.setCourt_yard_terrain_uuid(newUuid);
/*     */     }
/* 793 */     else if (pos == 13)
/*     */     {
/* 795 */       xHomeInfo.setCourt_yard_road_uuid(newUuid);
/*     */     }
/*     */     
/* 798 */     if (isOwner)
/*     */     {
/* 800 */       xHomeInfo.getMydisplayfurniture().put(Long.valueOf(newUuid), xFurnitureInfo);
/*     */     }
/*     */     else
/*     */     {
/* 804 */       xHomeInfo.getPartnerdisplayfurniture().put(Long.valueOf(newUuid), xFurnitureInfo);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static void addSpecialFurnitureMapEntity(long homeWorldId, int furnitureCfgId, long furnitureUuid, int mapCfgId, int pos)
/*     */   {
/* 811 */     if (pos == 11)
/*     */     {
/* 813 */       addFenceIntoWorld(furnitureUuid, homeWorldId, mapCfgId, furnitureCfgId);
/*     */     }
/* 815 */     else if (pos == 12)
/*     */     {
/* 817 */       addTerrainIntoWorld(furnitureUuid, homeWorldId, mapCfgId, furnitureCfgId);
/*     */     }
/* 819 */     else if (pos == 13)
/*     */     {
/* 821 */       addRoadIntoWorld(furnitureUuid, homeWorldId, mapCfgId, furnitureCfgId);
/*     */     } else {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void checkAndInitCourtYardCleanliness(HomeInfo xHomeInfo)
/*     */   {
/* 831 */     if (xHomeInfo.getCourt_yard_cleanliness_refresh_time() == 0L)
/*     */     {
/* 833 */       xHomeInfo.setCourt_yard_cleanliness_refresh_time(DateTimeUtils.getCurrTimeInMillis());
/* 834 */       xHomeInfo.setCourt_yard_cleanliness(SHomelandCfgConsts.getInstance().init_court_yard_cleanliness);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\CourtYardManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */