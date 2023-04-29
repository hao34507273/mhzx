/*     */ package mzm.gsp.singlebattle.gather;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*     */ import mzm.gsp.singlebattle.SGatherItemAppearanceBro;
/*     */ import mzm.gsp.singlebattle.confbean.SBattleGatherPlayCfg;
/*     */ import mzm.gsp.singlebattle.confbean.SGatherAreaCfg;
/*     */ import mzm.gsp.singlebattle.confbean.STGatherAreaCfg;
/*     */ import mzm.gsp.singlebattle.confbean.STGatherItemWeightCfg;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BattleGatherData;
/*     */ import xbean.GatherItemData;
/*     */ import xbean.Pod;
/*     */ import xdb.Xdb;
/*     */ import xtable.Battlegather;
/*     */ 
/*     */ public class BattleGatherManager
/*     */ {
/*     */   static BattleGatherData getXBattleGatherDataIfAbsence(long battleId)
/*     */   {
/*  35 */     BattleGatherData xBattleGatherData = Battlegather.get(Long.valueOf(battleId));
/*  36 */     if (xBattleGatherData == null)
/*     */     {
/*  38 */       Battlegather.insert(Long.valueOf(battleId), xBattleGatherData = Pod.newBattleGatherData());
/*     */     }
/*  40 */     return xBattleGatherData;
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
/*     */   static void refreshGatherItems(BattleGatherData xBattleGatherData, long battleId, int playCfgId, long worldId, int mapCfgId)
/*     */   {
/*  57 */     SBattleGatherPlayCfg playCfg = SBattleGatherPlayCfg.get(playCfgId);
/*  58 */     if (playCfg == null)
/*     */     {
/*  60 */       GameServer.logger().error(String.format("[battlegather]BattleGatherManager.refreshGatherItems@ SBattleGatherPlayCfg is null!|battleId=%d|playCfgId=%d", new Object[] { Long.valueOf(battleId), Integer.valueOf(playCfgId) }));
/*     */       
/*     */ 
/*     */ 
/*  64 */       return;
/*     */     }
/*  66 */     Map<Long, Integer> instanceId2gatherItemCfgId = new HashMap();
/*  67 */     Set<Integer> areaCfgIds = new HashSet();
/*  68 */     getNeedRefreshGatherItems(worldId, mapCfgId, playCfg, instanceId2gatherItemCfgId, areaCfgIds);
/*  69 */     loadNewGatherItemIntoDB(xBattleGatherData, instanceId2gatherItemCfgId);
/*  70 */     broadcastGatherItemsApearance(battleId, areaCfgIds);
/*     */     
/*  72 */     new Session_ClearGather(playCfg.aliveInterval, battleId, playCfgId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void removeOriginalGatherItems(long battleId, BattleGatherData xBattleGatherData, MapCallBack_RemoveMapEntity.RemoveGatherItemReason reason)
/*     */   {
/*  82 */     if (xBattleGatherData == null)
/*     */     {
/*  84 */       return;
/*     */     }
/*  86 */     for (Map.Entry<Long, GatherItemData> entry : xBattleGatherData.getGatheritemdatas().entrySet())
/*     */     {
/*  88 */       long instanceId = ((Long)entry.getKey()).longValue();
/*  89 */       int gatherItemCfgId = ((GatherItemData)entry.getValue()).getGathercfgid();
/*     */       
/*  91 */       MapInterface.removeMapEntity(MapEntityType.MET_SINGLE_BATTLE_GATHER_ITEM, instanceId, new MapCallBack_RemoveMapEntity(battleId, instanceId, gatherItemCfgId, reason));
/*     */     }
/*     */     
/*     */ 
/*  95 */     xBattleGatherData.getGatheritemdatas().clear();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void loadNewGatherItemIntoDB(BattleGatherData xBattleGatherData, Map<Long, Integer> instanceId2gatherItemCfgId)
/*     */   {
/* 107 */     for (Map.Entry<Long, Integer> entry : instanceId2gatherItemCfgId.entrySet())
/*     */     {
/* 109 */       GatherItemData xGatherItemData = Pod.newGatherItemData();
/* 110 */       xGatherItemData.setGathercfgid(((Integer)entry.getValue()).intValue());
/*     */       
/* 112 */       xBattleGatherData.getGatheritemdatas().put(entry.getKey(), xGatherItemData);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void broadcastGatherItemsApearance(long battleId, Set<Integer> areaCfgIds)
/*     */   {
/* 124 */     if ((areaCfgIds == null) || (areaCfgIds.isEmpty()))
/*     */     {
/* 126 */       GameServer.logger().error(String.format("[gather]BattleGatherManager.broadcastGatherItemsApearance@areaCfgIds.isEmpty!|battleId=%d", new Object[] { Long.valueOf(battleId) }));
/*     */       
/*     */ 
/* 129 */       return;
/*     */     }
/* 131 */     SGatherItemAppearanceBro bro = new SGatherItemAppearanceBro();
/* 132 */     bro.areaids.addAll(areaCfgIds);
/* 133 */     SingleBattleInterface.battleBro(battleId, bro, false);
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
/*     */   private static void getNeedRefreshGatherItems(long worldId, int mapCfgId, SBattleGatherPlayCfg playCfg, Map<Long, Integer> instanceId2gatherItemCfgId, Set<Integer> areaCfgIds)
/*     */   {
/* 148 */     for (Map.Entry<Integer, List<Position>> entry : getAreaRandomPoints(mapCfgId, playCfg).entrySet())
/*     */     {
/* 150 */       List<Position> ranPositions = (List)entry.getValue();
/* 151 */       if (ranPositions.size() == 0)
/*     */       {
/* 153 */         GameServer.logger().error(String.format("[battlegather]BattleGatherManager.getNeedRefreshGatherItems@ ranPositions is zero!|mapCfgId=%d|worldId=%d", new Object[] { Integer.valueOf(mapCfgId), Long.valueOf(worldId) }));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 159 */         int areaCfgId = ((Integer)entry.getKey()).intValue();
/* 160 */         SGatherAreaCfg areaCfg = SGatherAreaCfg.get(areaCfgId);
/* 161 */         if (areaCfg == null)
/*     */         {
/* 163 */           GameServer.logger().error(String.format("[battlegather]BattleGatherManager.getNeedRefreshGatherItems@ areaCfg is null!|mapCfgId=%d|worldId=%d|areaCfgId=%d", new Object[] { Integer.valueOf(mapCfgId), Long.valueOf(worldId), Integer.valueOf(areaCfgId) }));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/* 169 */           STGatherItemWeightCfg gatherItemWeightCfg = STGatherItemWeightCfg.get(areaCfg.gatherItemWeightLibId);
/* 170 */           if (gatherItemWeightCfg.itemWeightInfos.isEmpty())
/*     */           {
/* 172 */             GameServer.logger().error(String.format("[battlegather]BattleGatherManager.getNeedRefreshGatherItems@ gatherItemWeightCfg.itemWeightInfos is empty!|mapCfgId=%d|worldId=%d|areaCfgId=%d", new Object[] { Integer.valueOf(mapCfgId), Long.valueOf(worldId), Integer.valueOf(areaCfgId) }));
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/*     */ 
/* 178 */             instanceId2gatherItemCfgId.putAll(createGatherMapEntity(worldId, mapCfgId, ranPositions, gatherItemWeightCfg));
/* 179 */             areaCfgIds.add(Integer.valueOf(areaCfgId));
/*     */           }
/*     */         }
/*     */       }
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
/*     */   private static Map<Long, Integer> createGatherMapEntity(long worldId, int mapCfgId, List<Position> ranPositions, STGatherItemWeightCfg gatherItemWeightCfg)
/*     */   {
/* 195 */     Map<Long, Integer> instanceId2gatherItemCfgId = new HashMap();
/* 196 */     for (Position position : ranPositions)
/*     */     {
/* 198 */       int x = position.getX();
/* 199 */       int y = position.getY();
/*     */       
/* 201 */       long instanceId = GlobalGatherData.getNewGatherId();
/* 202 */       int gatherItemCfgId = getGatherItemCfgId(gatherItemWeightCfg.itemWeightInfos, gatherItemWeightCfg.totalWeight);
/* 203 */       if (gatherItemCfgId <= 0)
/*     */       {
/* 205 */         GameServer.logger().error(String.format("[battlegather]BattleGatherManager.createGatherMapEntity@ gatherItemCfgId is null!|mapCfgId=%d|worldId=%d|instanceId=%d", new Object[] { Integer.valueOf(mapCfgId), Long.valueOf(worldId), Long.valueOf(instanceId) }));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 211 */         instanceId2gatherItemCfgId.put(Long.valueOf(instanceId), Integer.valueOf(gatherItemCfgId));
/*     */         
/* 213 */         MapInterface.addMapEntity(MapEntityType.MET_SINGLE_BATTLE_GATHER_ITEM, instanceId, worldId, mapCfgId, x, y, gatherItemCfgId, null, null, null, null);
/*     */       }
/*     */     }
/* 216 */     return instanceId2gatherItemCfgId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int getGatherItemCfgId(Map<Integer, Integer> itemWeightInfos, int weightSum)
/*     */   {
/* 228 */     if (weightSum <= 0)
/*     */     {
/* 230 */       return -1;
/*     */     }
/* 232 */     int ran = Xdb.random().nextInt(weightSum);
/* 233 */     int tmpWeight = 0;
/* 234 */     for (Map.Entry<Integer, Integer> entry : itemWeightInfos.entrySet())
/*     */     {
/* 236 */       tmpWeight += ((Integer)entry.getValue()).intValue();
/* 237 */       if (tmpWeight > ran)
/*     */       {
/* 239 */         return ((Integer)entry.getKey()).intValue();
/*     */       }
/*     */     }
/* 242 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Integer, List<Position>> getAreaRandomPoints(int mapCfgId, SBattleGatherPlayCfg playCfg)
/*     */   {
/* 254 */     Set<Integer> needAreaCfgIds = getNeedAreaCfgIds(playCfg);
/* 255 */     if ((needAreaCfgIds == null) || (needAreaCfgIds.size() == 0))
/*     */     {
/* 257 */       GameServer.logger().error(String.format("[battlegather]BattleGatherManager.getAreaRandomPoints@ needAreaCfgIds is null!|mapCfgId=%d|SBattleGatherPlayCfgId=%d", new Object[] { Integer.valueOf(mapCfgId), Integer.valueOf(playCfg.id) }));
/*     */       
/*     */ 
/*     */ 
/* 261 */       return Collections.emptyMap();
/*     */     }
/*     */     
/* 264 */     Map<Integer, List<Position>> areaCfgId2Positions = new HashMap();
/* 265 */     for (Map.Entry<Integer, Integer> entry : getArea2Num(needAreaCfgIds, getNeedItemNum(playCfg)).entrySet())
/*     */     {
/* 267 */       int areaCfgId = ((Integer)entry.getKey()).intValue();
/* 268 */       int num = ((Integer)entry.getValue()).intValue();
/* 269 */       if (num != 0)
/*     */       {
/*     */ 
/*     */ 
/* 273 */         areaCfgId2Positions.put(Integer.valueOf(areaCfgId), getMapPositions(mapCfgId, SGatherAreaCfg.get(areaCfgId).mapAreaId, num)); }
/*     */     }
/* 275 */     if (areaCfgId2Positions.isEmpty())
/*     */     {
/* 277 */       GameServer.logger().error(String.format("[battlegather]BattleGatherManager.getAreaRandomPoints@ areaCfgId2Positions isEmpty!|mapCfgId=%d|SBattleGatherPlayCfgId=%d", new Object[] { Integer.valueOf(mapCfgId), Integer.valueOf(playCfg.id) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 282 */     return areaCfgId2Positions;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Integer, Integer> getArea2Num(Set<Integer> needAreaCfgIds, int totalNum)
/*     */   {
/* 294 */     if (totalNum <= 0)
/*     */     {
/* 296 */       return Collections.emptyMap();
/*     */     }
/* 298 */     Map<Integer, Integer> areaId2numberWeight = new HashMap();
/* 299 */     int totalWeight = 0;
/* 300 */     for (Iterator i$ = needAreaCfgIds.iterator(); i$.hasNext();) { int areaCfgId = ((Integer)i$.next()).intValue();
/*     */       
/* 302 */       SGatherAreaCfg cfg = SGatherAreaCfg.get(areaCfgId);
/* 303 */       if (cfg != null)
/*     */       {
/*     */ 
/*     */ 
/* 307 */         areaId2numberWeight.put(Integer.valueOf(areaCfgId), Integer.valueOf(cfg.numberWeight));
/* 308 */         totalWeight += cfg.numberWeight;
/*     */       } }
/* 310 */     if (totalWeight == 0)
/*     */     {
/* 312 */       return Collections.emptyMap();
/*     */     }
/*     */     
/* 315 */     Map<Integer, Integer> area2Num = getAreaCfgId2Num(areaId2numberWeight, totalNum, totalWeight);
/* 316 */     if (GameServer.logger().isDebugEnabled())
/*     */     {
/* 318 */       GameServer.logger().debug(String.format("[battlegather]BattleGatherManager.getArea2Num@ area2Num=%s|totalWeight=%d|totalNum=%d", new Object[] { area2Num.toString(), Integer.valueOf(totalWeight), Integer.valueOf(totalNum) }));
/*     */     }
/*     */     
/*     */ 
/* 322 */     return area2Num;
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
/*     */   private static Map<Integer, Integer> getAreaCfgId2Num(Map<Integer, Integer> areaId2numberWeight, int leftNum, int leftTotalWeight)
/*     */   {
/* 336 */     Map<Integer, Integer> area2Num = new HashMap();
/* 337 */     for (Map.Entry<Integer, Integer> entry : areaId2numberWeight.entrySet())
/*     */     {
/* 339 */       int areaCfgId = ((Integer)entry.getKey()).intValue();
/* 340 */       int weight = ((Integer)entry.getValue()).intValue();
/*     */       
/* 342 */       int needNum = leftNum * weight / leftTotalWeight;
/*     */       
/* 344 */       area2Num.put(Integer.valueOf(areaCfgId), Integer.valueOf(needNum));
/*     */       
/* 346 */       leftNum -= needNum;
/* 347 */       leftTotalWeight -= weight;
/*     */       
/* 349 */       if (GameServer.logger().isDebugEnabled())
/*     */       {
/* 351 */         GameServer.logger().debug(String.format("[battlegather]BattleGatherManager.getArea2Num@ areaCfgId=%d|weight=%d|leftNum=%d|leftWeight=%d", new Object[] { Integer.valueOf(areaCfgId), Integer.valueOf(weight), Integer.valueOf(leftNum), Integer.valueOf(leftTotalWeight) }));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 357 */     return area2Num;
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
/*     */   private static List<Position> getMapPositions(int mapCfgId, int areaId, int num)
/*     */   {
/* 370 */     if (num <= 0)
/*     */     {
/* 372 */       return Collections.emptyList();
/*     */     }
/* 374 */     List<Position> positions = new ArrayList();
/* 375 */     for (; num > 0; num--)
/*     */     {
/* 377 */       Position position = MapInterface.randomPosFromRegion(mapCfgId, areaId);
/* 378 */       if (position != null)
/*     */       {
/*     */ 
/*     */ 
/* 382 */         positions.add(position); }
/*     */     }
/* 384 */     return positions;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static Set<Integer> getNeedAreaCfgIds(SBattleGatherPlayCfg playCfg)
/*     */   {
/* 395 */     int needAreaNum = getNeedAreaNum(playCfg);
/* 396 */     if (needAreaNum <= 0)
/*     */     {
/* 398 */       return Collections.emptySet();
/*     */     }
/* 400 */     Set<Integer> allAreaCfgIds = getAllAreaCfgIds(playCfg);
/* 401 */     if ((allAreaCfgIds == null) || (allAreaCfgIds.size() == 0))
/*     */     {
/* 403 */       return Collections.emptySet();
/*     */     }
/* 405 */     List<Integer> finalAreaCfgIds = new ArrayList();
/* 406 */     CommonUtils.regionRandom(allAreaCfgIds, needAreaNum, finalAreaCfgIds);
/* 407 */     return new HashSet(finalAreaCfgIds);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static Set<Integer> getAllAreaCfgIds(SBattleGatherPlayCfg playCfg)
/*     */   {
/* 418 */     STGatherAreaCfg cfg = STGatherAreaCfg.get(playCfg.areaLibId);
/* 419 */     if (cfg == null)
/*     */     {
/* 421 */       return Collections.emptySet();
/*     */     }
/* 423 */     return new HashSet(cfg.areaCfgIds);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int getNeedAreaNum(SBattleGatherPlayCfg playCfg)
/*     */   {
/* 434 */     return CommonUtils.random(playCfg.areaNumMin, playCfg.areaNumMax + 1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int getNeedItemNum(SBattleGatherPlayCfg playCfg)
/*     */   {
/* 445 */     return CommonUtils.random(playCfg.itemCountMin, playCfg.itemCountMax + 1);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\gather\BattleGatherManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */