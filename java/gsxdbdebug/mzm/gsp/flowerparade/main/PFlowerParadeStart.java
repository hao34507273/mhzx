/*     */ package mzm.gsp.flowerparade.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity4.confbean.FlowerParadeMapCfg;
/*     */ import mzm.gsp.activity4.confbean.FlowerParadePos;
/*     */ import mzm.gsp.activity4.confbean.SFlowerParadeCfg;
/*     */ import mzm.gsp.activity4.confbean.SFlowerParadeMapGroupCfg;
/*     */ import mzm.gsp.activity4.confbean.SFlowerParadeOcpGroupCfg;
/*     */ import mzm.gsp.flowerparade.ParadeRoleInfo;
/*     */ import mzm.gsp.flowerparade.SFlowerParadeCounddown;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.MilliSession;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FlowerParade;
/*     */ import xbean.FlowerParadeHistory;
/*     */ import xbean.Pod;
/*     */ import xtable.Flowerparade;
/*     */ import xtable.Flowerparadehistory;
/*     */ 
/*     */ public class PFlowerParadeStart extends mzm.gsp.util.LogicProcedure
/*     */ {
/*  31 */   private static AtomicInteger FLOWER_PARADE_INSTANCE_INDEX = new AtomicInteger(0);
/*     */   
/*  33 */   private static AtomicInteger FLOWER_PARADE_INDEX_GM = new AtomicInteger(-1);
/*     */   
/*     */   private final int activityId;
/*     */   
/*     */   private final int assignedMapId;
/*     */   private final int assignedOcp;
/*     */   private final int paradeIndex;
/*     */   
/*     */   public PFlowerParadeStart(int activityId, int paradeIndex, int mapId, int ocp)
/*     */   {
/*  43 */     this.activityId = activityId;
/*  44 */     this.paradeIndex = paradeIndex;
/*  45 */     this.assignedMapId = mapId;
/*  46 */     this.assignedOcp = ocp;
/*     */   }
/*     */   
/*     */   public int getParadeIndex()
/*     */   {
/*  51 */     return this.paradeIndex;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  57 */     SFlowerParadeCfg cfg = SFlowerParadeCfg.get(this.activityId);
/*  58 */     long localid = mzm.gsp.GameServerInfoManager.getLocalId();
/*  59 */     List<Integer> historyMapIds = new ArrayList();
/*  60 */     List<Integer> historyOcps = new ArrayList();
/*  61 */     List<Long> histroyRoles = new ArrayList();
/*  62 */     FlowerParadeHistory xHistroySelect = Flowerparadehistory.select(Long.valueOf(localid));
/*  63 */     if (xHistroySelect != null)
/*     */     {
/*  65 */       historyMapIds.addAll(xHistroySelect.getHistorymapids());
/*  66 */       historyOcps.addAll(xHistroySelect.getHistoryocpids());
/*  67 */       histroyRoles.addAll(xHistroySelect.getHistoryroles());
/*     */     }
/*     */     
/*     */ 
/*  71 */     SFlowerParadeMapGroupCfg mapGroupCfg = SFlowerParadeMapGroupCfg.get(cfg.mapGroupId);
/*  72 */     SFlowerParadeOcpGroupCfg ocpGroupCfg = SFlowerParadeOcpGroupCfg.get(cfg.ocpGroupId);
/*     */     
/*     */ 
/*  75 */     int mapId = 0;
/*  76 */     if (this.assignedMapId == -1)
/*     */     {
/*  78 */       List<Integer> excludeMaps = new ArrayList();
/*  79 */       int mapHistorySize = historyMapIds.size();
/*  80 */       for (int i = 0; i < cfg.mapUniqueTime; i++)
/*     */       {
/*  82 */         int index = mapHistorySize - 1 - i;
/*  83 */         if (index >= 0)
/*     */         {
/*  85 */           excludeMaps.add(historyMapIds.get(index));
/*     */         }
/*     */       }
/*  88 */       mapId = FlowerParadeManager.randomParadeMap(excludeMaps, mapGroupCfg.map2Pos.keySet());
/*     */     }
/*     */     else
/*     */     {
/*  92 */       mapId = this.assignedMapId;
/*     */     }
/*  94 */     if ((mapId == 0) && (mapGroupCfg.map2Pos.keySet().size() > 0))
/*     */     {
/*  96 */       Iterator i$ = mapGroupCfg.map2Pos.keySet().iterator(); if (i$.hasNext()) { int tmpMap = ((Integer)i$.next()).intValue();
/*     */         
/*  98 */         mapId = tmpMap;
/*     */       }
/*     */       
/* 101 */       GameServer.logger().info(String.format("[flowerparade]PFlowerParadeStart.processImp@random mapid with some exclude failed then got a new one|activityid=%d|mapId=%d", new Object[] { Integer.valueOf(this.activityId), Integer.valueOf(mapId) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 108 */     int ocp = 0;
/* 109 */     if (this.assignedOcp == -1)
/*     */     {
/*     */ 
/* 112 */       List<Integer> excludeOcps = new ArrayList();
/* 113 */       int ocpHistorySize = historyOcps.size();
/* 114 */       for (int i = 0; i < cfg.ocpUniqueTime; i++)
/*     */       {
/* 116 */         int index = ocpHistorySize - 1 - i;
/* 117 */         if (index >= 0)
/*     */         {
/* 119 */           excludeOcps.add(historyOcps.get(index));
/*     */         }
/*     */       }
/*     */       
/* 123 */       ocp = FlowerParadeManager.randomParadeOcp(excludeOcps, ocpGroupCfg.ocpPradCfg.keySet());
/*     */     }
/*     */     else
/*     */     {
/* 127 */       ocp = this.assignedOcp;
/*     */     }
/* 129 */     if ((ocp == 0) && (ocpGroupCfg.ocpPradCfg.keySet().size() > 0))
/*     */     {
/* 131 */       Iterator i$ = ocpGroupCfg.ocpPradCfg.keySet().iterator(); if (i$.hasNext()) { int tmpOcp = ((Integer)i$.next()).intValue();
/*     */         
/* 133 */         ocp = tmpOcp;
/*     */       }
/*     */       
/* 136 */       GameServer.logger().info(String.format("[flowerparade]PFlowerParadeStart.processImp@random ocp with some exclude failed then got a new one|activityid=%d|ocp=%d", new Object[] { Integer.valueOf(this.activityId), Integer.valueOf(ocp) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 143 */     List<Long> excludeRoleIdList = histroyRoles;
/* 144 */     long roleMale = FlowerParadeManager.randomParadeRole(ocp, excludeRoleIdList, 1).longValue();
/* 145 */     long roleFemale = FlowerParadeManager.randomParadeRole(ocp, excludeRoleIdList, 2).longValue();
/*     */     
/*     */ 
/* 148 */     List<Long> roleIds = new ArrayList();
/* 149 */     roleIds.add(Long.valueOf(roleMale));
/* 150 */     roleIds.add(Long.valueOf(roleFemale));
/* 151 */     lock(xtable.Basic.getTable(), roleIds);
/*     */     
/*     */ 
/* 154 */     if (Flowerparade.get(Long.valueOf(localid)) != null)
/*     */     {
/* 156 */       GameServer.logger().info(String.format("[flowerparade]PFlowerParadeStart.processImp@end parade before starting a new one|activityid=%d", new Object[] { Integer.valueOf(this.activityId) }));
/*     */       
/*     */ 
/*     */ 
/* 160 */       FlowerParadeManager.stopFlowerParadeCall(this.activityId);
/*     */     }
/* 162 */     FlowerParade xFlowerParade = Pod.newFlowerParade();
/* 163 */     Flowerparade.insert(Long.valueOf(localid), xFlowerParade);
/*     */     
/* 165 */     FlowerParadeHistory xHistroy = Flowerparadehistory.get(Long.valueOf(localid));
/* 166 */     if (xHistroy == null)
/*     */     {
/* 168 */       xHistroy = Pod.newFlowerParadeHistory();
/* 169 */       Flowerparadehistory.insert(Long.valueOf(localid), xHistroy);
/*     */     }
/*     */     
/*     */ 
/* 173 */     if (this.paradeIndex != -1)
/*     */     {
/* 175 */       xHistroy.setParadeindex(this.paradeIndex);
/* 176 */       xFlowerParade.setParadeindex(this.paradeIndex);
/*     */     }
/*     */     else
/*     */     {
/* 180 */       int gmIndex = FLOWER_PARADE_INDEX_GM.decrementAndGet();
/* 181 */       xHistroy.setParadeindex(gmIndex);
/* 182 */       xFlowerParade.setParadeindex(gmIndex);
/*     */     }
/* 184 */     int START_POS_INDEX = 1;
/*     */     
/* 186 */     xFlowerParade.setMapid(mapId);
/* 187 */     xFlowerParade.setOcpid(ocp);
/* 188 */     xFlowerParade.getRoles().add(Long.valueOf(roleMale));
/* 189 */     xFlowerParade.getRoles().add(Long.valueOf(roleFemale));
/* 190 */     xFlowerParade.setToposindex(1);
/* 191 */     xFlowerParade.setState(0);
/*     */     
/* 193 */     xHistroy.getHistorymapids().add(Integer.valueOf(mapId));
/* 194 */     xHistroy.getHistoryocpids().add(Integer.valueOf(ocp));
/* 195 */     xHistroy.getHistoryroles().add(Long.valueOf(roleMale));
/* 196 */     xHistroy.getHistoryroles().add(Long.valueOf(roleFemale));
/*     */     
/*     */ 
/* 199 */     Map<Integer, Long> longExtraInfoEntries = new HashMap();
/* 200 */     longExtraInfoEntries.put(Integer.valueOf(1700), Long.valueOf(roleMale));
/* 201 */     longExtraInfoEntries.put(Integer.valueOf(1701), Long.valueOf(roleFemale));
/* 202 */     Map<Integer, Integer> intExtraInfoEntries = new HashMap();
/* 203 */     intExtraInfoEntries.put(Integer.valueOf(1702), Integer.valueOf(ocp));
/* 204 */     int velocity = cfg.paradeVelocity;
/* 205 */     intExtraInfoEntries.put(Integer.valueOf(1703), Integer.valueOf(velocity));
/* 206 */     int entityInstanceid = FLOWER_PARADE_INSTANCE_INDEX.incrementAndGet();
/* 207 */     long worldid = MapInterface.getBigWorldid();
/* 208 */     FlowerParadeMapCfg mapCfg = (FlowerParadeMapCfg)mapGroupCfg.map2Pos.get(Integer.valueOf(mapId));
/* 209 */     FlowerParadePos cfgPos = FlowerParadeManager.getFlowerParadePos(mapCfg.pathId, 1);
/* 210 */     MapInterface.addMapEntity(mzm.gsp.map.main.scene.object.MapEntityType.MET_FLOAT_PARADE, entityInstanceid, worldid, mapId, cfgPos.x, cfgPos.y, -1, intExtraInfoEntries, longExtraInfoEntries, null, null);
/*     */     
/* 212 */     xFlowerParade.setFlowerinstanceid(entityInstanceid);
/*     */     
/* 214 */     String maleName = RoleInterface.getName(roleMale);
/* 215 */     String femaleName = RoleInterface.getName(roleFemale);
/* 216 */     ArrayList<ParadeRoleInfo> roleList = new ArrayList();
/* 217 */     roleList.add(new ParadeRoleInfo(roleMale, maleName == null ? "" : maleName));
/* 218 */     roleList.add(new ParadeRoleInfo(roleFemale, femaleName == null ? "" : femaleName));
/* 219 */     long startTimeInSec = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis() / 1000L + cfg.prepareTime;
/* 220 */     SFlowerParadeCounddown protocol = new SFlowerParadeCounddown(this.activityId, roleList, ocp, mapId, startTimeInSec);
/* 221 */     OnlineManager.getInstance().sendAll(protocol);
/*     */     
/* 223 */     MilliSession session = new FlowerParadeSessionCountdown(cfg.prepareTime * 1000, this.activityId);
/* 224 */     xFlowerParade.setSessionidcountdown(session.getSessionId());
/* 225 */     xFlowerParade.setStarttimeinsec(startTimeInSec);
/*     */     
/* 227 */     GameServer.logger().info(String.format("[flowerparade]PFlowerParadeStart.processImp@create a parade and start to counddown|paradeinstance=%d|activityid=%d|ocp=%d|map=%d|rolemale=%d|rolefemale=%d|paradeindex=%d|countdowninsec=%d|localid=%d", new Object[] { Integer.valueOf(entityInstanceid), Integer.valueOf(this.activityId), Integer.valueOf(ocp), Integer.valueOf(mapId), Long.valueOf(roleMale), Long.valueOf(roleFemale), Integer.valueOf(this.paradeIndex), Integer.valueOf(cfg.prepareTime), Long.valueOf(localid) }));
/*     */     
/*     */ 
/*     */ 
/* 231 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\flowerparade\main\PFlowerParadeStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */