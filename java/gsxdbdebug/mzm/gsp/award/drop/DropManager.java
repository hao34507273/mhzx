/*     */ package mzm.gsp.award.drop;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.award.confbean.DropItemIds;
/*     */ import mzm.gsp.award.confbean.STAward2DropInfo;
/*     */ import mzm.gsp.award.confbean.STTimeDropCommonCfg;
/*     */ import mzm.gsp.award.confbean.STimeDropCfg;
/*     */ import mzm.gsp.award.confbean.STimeDropItemCfg;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.DropInfo;
/*     */ import xbean.Pod;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Xdb;
/*     */ import xtable.Role2drop;
/*     */ import xtable.User;
/*     */ 
/*     */ public class DropManager
/*     */ {
/*  35 */   private static int WAN = 10000;
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
/*     */   public static Map<Integer, Integer> getTimeDropItems(long roleId, int awardDropLibId, int awardId, long awardTime)
/*     */   {
/*  50 */     Collection<Integer> dropCfgIds = getDropCfgIdsByAwardId(awardId);
/*  51 */     if ((dropCfgIds == null) || (dropCfgIds.size() == 0))
/*     */     {
/*  53 */       return new HashMap();
/*     */     }
/*  55 */     Map<Integer, Integer> itemIds = new HashMap();
/*  56 */     for (Iterator i$ = dropCfgIds.iterator(); i$.hasNext();) { int dropCfgId = ((Integer)i$.next()).intValue();
/*     */       
/*  58 */       addNewItemIds(itemIds, getDropItems(roleId, dropCfgId, awardId, awardTime));
/*     */     }
/*  60 */     return itemIds;
/*     */   }
/*     */   
/*     */   private static void addNewItemIds(Map<Integer, Integer> baseItemIds, Map<Integer, Integer> addItemIds)
/*     */   {
/*  65 */     if ((addItemIds == null) || (addItemIds.size() == 0))
/*     */     {
/*  67 */       return;
/*     */     }
/*  69 */     for (Map.Entry<Integer, Integer> addEntry : addItemIds.entrySet())
/*     */     {
/*  71 */       int itemId = ((Integer)addEntry.getKey()).intValue();
/*  72 */       int num = ((Integer)addEntry.getValue()).intValue();
/*     */       
/*  74 */       Integer orgNum = (Integer)baseItemIds.get(Integer.valueOf(itemId));
/*  75 */       if (orgNum == null)
/*     */       {
/*  77 */         orgNum = Integer.valueOf(0);
/*     */       }
/*  79 */       baseItemIds.put(Integer.valueOf(itemId), Integer.valueOf(orgNum.intValue() + num));
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
/*     */ 
/*     */   static Map<Integer, Integer> getDropItems(long roleId, int dropId, int awardId, long awardTime)
/*     */   {
/*  96 */     if (dropId <= 0)
/*     */     {
/*  98 */       return new HashMap();
/*     */     }
/*     */     
/* 101 */     if (!isDropOpen(roleId))
/*     */     {
/* 103 */       return new HashMap();
/*     */     }
/* 105 */     Map<Integer, Integer> items = new HashMap();
/* 106 */     STimeDropCfg cfg = STimeDropCfg.get(dropId);
/*     */     
/* 108 */     if (!canDropInCfg(roleId, awardId, awardTime, cfg))
/*     */     {
/* 110 */       return items;
/*     */     }
/* 112 */     Set<Integer> itemDropIds = getAwardItemIds(cfg.dropLibId);
/* 113 */     if ((itemDropIds == null) || (itemDropIds.size() == 0))
/*     */     {
/* 115 */       if (cfg.dropLibId > 0)
/*     */       {
/* 117 */         GameServer.logger().info(String.format("[drop]DropManager.getDropItems@getAwardItemIds is null!|roleId=%d|dropId=%d|dropLibId=%d|awardId=%d|", new Object[] { Long.valueOf(roleId), Integer.valueOf(dropId), Integer.valueOf(cfg.dropLibId), Integer.valueOf(awardId) }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 122 */       return items;
/*     */     }
/*     */     
/* 125 */     String userid = RoleInterface.getUserId(roleId);
/* 126 */     Lockeys.lock(Lockeys.get(User.getTable(), userid));
/*     */     
/* 128 */     DropInfo xDropInfo = getXDropInfoAndCheck(roleId, DateTimeUtils.getCurrTimeInMillis());
/*     */     
/* 130 */     items.putAll(getallAwardItemIds(roleId, awardId, itemDropIds, xDropInfo));
/*     */     
/* 132 */     tlogSingleDrop(roleId, awardId, items, xDropInfo, awardTime);
/* 133 */     return items;
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
/*     */   private static boolean canDropInCfg(long roleId, int awardId, long curTime, STimeDropCfg cfg)
/*     */   {
/* 147 */     if (cfg == null)
/*     */     {
/* 149 */       return false;
/*     */     }
/*     */     
/* 152 */     if (!isInAwardTime(cfg, curTime))
/*     */     {
/* 154 */       return false;
/*     */     }
/* 156 */     GameServer.logger().info(String.format("[drop]DropManager.canDropInCfg@within effect time!|roleId=%d|awardId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(awardId) }));
/*     */     
/*     */ 
/* 159 */     if (!getTarget(cfg.dropRate))
/*     */     {
/* 161 */       return false;
/*     */     }
/* 163 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static DropInfo getXDropInfoAndCheck(long roleId, long curTime)
/*     */   {
/* 175 */     DropInfo xDropInfo = Role2drop.get(Long.valueOf(roleId));
/* 176 */     if (xDropInfo == null)
/*     */     {
/* 178 */       xDropInfo = Pod.newDropInfo();
/* 179 */       xDropInfo.setStarttime(curTime);
/* 180 */       Role2drop.insert(Long.valueOf(roleId), xDropInfo);
/*     */     }
/* 182 */     if (!DateTimeUtils.isInSameDay(curTime, xDropInfo.getStarttime()))
/*     */     {
/* 184 */       xDropInfo.getDropcounts().clear();
/* 185 */       xDropInfo.setStarttime(curTime);
/*     */     }
/* 187 */     return xDropInfo;
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
/*     */   private static Map<Integer, Integer> getallAwardItemIds(long roleId, int awardId, Set<Integer> itemDropIds, DropInfo xDropInfo)
/*     */   {
/* 200 */     Map<Integer, Integer> itemIds = new HashMap();
/* 201 */     for (Iterator i$ = itemDropIds.iterator(); i$.hasNext();) { int itemDropId = ((Integer)i$.next()).intValue();
/*     */       
/* 203 */       STimeDropItemCfg dropCfg = STimeDropItemCfg.get(itemDropId);
/* 204 */       if (dropCfg == null)
/*     */       {
/* 206 */         GameServer.logger().error(String.format("[drop]DropManager.getallAwardItemIds@dropCfg is null!|itemDropId=%d", new Object[] { Integer.valueOf(itemDropId) }));
/*     */       }
/*     */       else
/*     */       {
/* 210 */         int itemId = dropCfg.itemId;
/* 211 */         if (!addGlobalNum(dropCfg.globalGainNumMax, itemId))
/*     */         {
/* 213 */           GameServer.logger().error(String.format("[drop]DropManager.getallAwardItemIds@addGlobalNum err!|itemId=%d|globalGainNumMax=%d", new Object[] { Integer.valueOf(itemId), Integer.valueOf(dropCfg.globalGainNumMax) }));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 218 */           Integer num = (Integer)xDropInfo.getDropcounts().get(Integer.valueOf(itemDropId));
/* 219 */           if (num == null)
/*     */           {
/* 221 */             num = new Integer(0);
/*     */           }
/* 223 */           if (num.intValue() >= dropCfg.singleGainNumMax)
/*     */           {
/* 225 */             GameServer.logger().info(String.format("[drop]DropManager.getallAwardItemIds@gain item to max!|roleId=%d|awardId=%d|itemId=%d|singleGainNumMax=%d|ownNum=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(awardId), Integer.valueOf(itemId), Integer.valueOf(dropCfg.singleGainNumMax), Integer.valueOf(num.intValue()) }));
/*     */ 
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/*     */ 
/*     */ 
/* 233 */             int cfgCount = dropCfg.count;
/* 234 */             int diffCount = dropCfg.singleGainNumMax - num.intValue();
/* 235 */             int needAddCount = Math.min(cfgCount, diffCount);
/*     */             
/* 237 */             xDropInfo.getDropcounts().put(Integer.valueOf(itemDropId), Integer.valueOf(num.intValue() + needAddCount));
/* 238 */             addItem(itemId, needAddCount, itemIds);
/* 239 */             GameServer.logger().info(String.format("[drop]DropManager.getallAwardItemIds@ add new item!|roleId=%d|awardId=%d|itemDropId=%d|itemId=%d|startTime=%d|ownItemInfo=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(awardId), Integer.valueOf(itemDropId), Integer.valueOf(itemId), Long.valueOf(xDropInfo.getStarttime()), xDropInfo.getDropcounts() }));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 244 */     if (itemIds.size() > 0)
/*     */     {
/* 246 */       GameServer.logger().info(String.format("[drop]DropManager.getallAwardItemIds@ add new item!|roleId=%d|awardId=%d|itemDropIds=%s|itemIds=%s|startTime=%d|ownItemInfo=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(awardId), itemDropIds, itemIds, Long.valueOf(xDropInfo.getStarttime()), xDropInfo.getDropcounts() }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 251 */     return itemIds;
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
/*     */   private static void addItem(int itemId, int num, Map<Integer, Integer> itemIds)
/*     */   {
/* 266 */     if ((itemId <= 0) || (num <= 0))
/*     */     {
/* 268 */       return;
/*     */     }
/* 270 */     Integer oldNum = (Integer)itemIds.get(Integer.valueOf(itemId));
/* 271 */     if (oldNum == null)
/*     */     {
/* 273 */       oldNum = new Integer(0);
/*     */     }
/* 275 */     itemIds.put(Integer.valueOf(itemId), Integer.valueOf(oldNum.intValue() + num));
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
/*     */   private static boolean addGlobalNum(int globalGainNumMax, int itemId)
/*     */   {
/* 288 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static Set<Integer> getAwardItemIds(int dropLibId)
/*     */   {
/* 300 */     STTimeDropCommonCfg cfg = STTimeDropCommonCfg.get(dropLibId);
/* 301 */     if (cfg == null)
/*     */     {
/* 303 */       GameServer.logger().error(String.format("[drop]DropManager.getAwardItemIds@STTimeDropCommonCfg is null!|dropLibId=%d", new Object[] { Integer.valueOf(dropLibId) }));
/*     */       
/* 305 */       return new HashSet();
/*     */     }
/* 307 */     Map<Integer, Integer> itemDropCfgIds = cfg.itemDropIds;
/* 308 */     if ((itemDropCfgIds == null) || (itemDropCfgIds.size() == 0))
/*     */     {
/* 310 */       GameServer.logger().error(String.format("[drop]DropManager.getAwardItemIds@STTimeDropCommonCfg.itemDropIds is null!|dropLibId=%d", new Object[] { Integer.valueOf(dropLibId) }));
/*     */       
/*     */ 
/* 313 */       return new HashSet();
/*     */     }
/* 315 */     if (cfg.dropWeight <= 0)
/*     */     {
/* 317 */       GameServer.logger().error(String.format("[drop]DropManager.getAwardItemIds@STTimeDropCommonCfg.dropWeight is null!|dropLibId=%d", new Object[] { Integer.valueOf(dropLibId) }));
/*     */       
/*     */ 
/* 320 */       return new HashSet();
/*     */     }
/* 322 */     int ran = Xdb.random().nextInt(cfg.dropWeight);
/* 323 */     int tmpWeight = 0;
/* 324 */     Set<Integer> itemDropIds = new HashSet();
/* 325 */     Iterator<Map.Entry<Integer, Integer>> it = itemDropCfgIds.entrySet().iterator();
/* 326 */     while (it.hasNext())
/*     */     {
/* 328 */       Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/* 329 */       tmpWeight += ((Integer)entry.getValue()).intValue();
/* 330 */       if (ran < tmpWeight)
/*     */       {
/*     */ 
/*     */ 
/* 334 */         itemDropIds.add(entry.getKey());
/*     */       }
/*     */     }
/* 337 */     if (itemDropIds.size() == 0)
/*     */     {
/* 339 */       GameServer.logger().info(String.format("[drop]DropManager.getAwardItemIds@itemDropIds is still null!|dropLibId=%d", new Object[] { Integer.valueOf(dropLibId) }));
/*     */     }
/*     */     
/* 342 */     return itemDropIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean getTarget(int rate)
/*     */   {
/* 353 */     if ((rate <= 0) || (rate > WAN))
/*     */     {
/* 355 */       return false;
/*     */     }
/* 357 */     int ran = Xdb.random().nextInt(WAN);
/* 358 */     return ran < rate;
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
/*     */   private static boolean isInAwardTime(STimeDropCfg cfg, long curTime)
/*     */   {
/* 372 */     List<Integer> intervals = cfg.intervals;
/* 373 */     if ((intervals == null) || (intervals.size() == 0))
/*     */     {
/* 375 */       return false;
/*     */     }
/* 377 */     for (Iterator i$ = intervals.iterator(); i$.hasNext();) { int timeLimitId = ((Integer)i$.next()).intValue();
/*     */       
/* 379 */       if (isInAwardTime(timeLimitId, curTime))
/*     */       {
/* 381 */         return true;
/*     */       }
/*     */     }
/* 384 */     return false;
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
/*     */   private static boolean isInAwardTime(int timeLimitId, long curTime)
/*     */   {
/* 398 */     long beginTime = TimeCommonUtil.getLimitTimeBegin(timeLimitId);
/* 399 */     long endTime = TimeCommonUtil.getLimitTimeEnd(timeLimitId);
/* 400 */     if (beginTime > curTime)
/*     */     {
/* 402 */       return false;
/*     */     }
/* 404 */     if (endTime < curTime)
/*     */     {
/* 406 */       return false;
/*     */     }
/* 408 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static List<Integer> getAllGlobalItemIds()
/*     */   {
/* 418 */     STAward2DropInfo cfg = STAward2DropInfo.get(0);
/* 419 */     if (cfg == null)
/*     */     {
/* 421 */       return new ArrayList();
/*     */     }
/* 423 */     return cfg.globalItemIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static List<Integer> getAllGlobalItemDropIds()
/*     */   {
/* 433 */     STAward2DropInfo cfg = STAward2DropInfo.get(0);
/* 434 */     if (cfg == null)
/*     */     {
/* 436 */       return new ArrayList();
/*     */     }
/* 438 */     return cfg.globalItemDropIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Collection<Integer> getDropCfgIdsByAwardId(int awardId)
/*     */   {
/* 449 */     STAward2DropInfo cfg = STAward2DropInfo.get(0);
/* 450 */     if (cfg == null)
/*     */     {
/* 452 */       return new ArrayList();
/*     */     }
/* 454 */     DropItemIds dropItemInfo = (DropItemIds)cfg.awardId2dropInfo.get(Integer.valueOf(awardId));
/* 455 */     return dropItemInfo == null ? new ArrayList() : dropItemInfo.dropCfgIds;
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
/*     */   private static void tlogSingleDrop(long roleId, int awardId, Map<Integer, Integer> itemids, DropInfo xDropInfo, long awardTime)
/*     */   {
/* 470 */     if ((itemids == null) || (itemids.size() == 0) || (xDropInfo == null))
/*     */     {
/* 472 */       return;
/*     */     }
/* 474 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 475 */     String userid = RoleInterface.getUserId(roleId);
/* 476 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 478 */     Object[] colums = { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(awardId), itemids.toString(), Long.valueOf(xDropInfo.getStarttime()), xDropInfo.getDropcounts().toString(), Long.valueOf(awardTime) };
/*     */     
/*     */ 
/* 481 */     TLogManager.getInstance().addLog(roleId, "SingleTimeDrop", colums);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isDropOpen(long roleId)
/*     */   {
/* 493 */     if (!OpenInterface.getOpenStatus(176))
/*     */     {
/* 495 */       return false;
/*     */     }
/* 497 */     if (OpenInterface.isBanPlay(roleId, 176))
/*     */     {
/* 499 */       return false;
/*     */     }
/* 501 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Set<Integer> getAllTimeDropItemIds(int awardId)
/*     */   {
/* 513 */     STAward2DropInfo cfg = STAward2DropInfo.get(0);
/* 514 */     if (cfg == null)
/*     */     {
/* 516 */       return new HashSet();
/*     */     }
/* 518 */     Set<Integer> allItemIds = new HashSet();
/* 519 */     DropItemIds itemDropInfo = (DropItemIds)cfg.awardId2dropInfo.get(Integer.valueOf(awardId));
/* 520 */     if (itemDropInfo != null)
/*     */     {
/* 522 */       allItemIds.addAll(itemDropInfo.itemIds);
/*     */     }
/* 524 */     return allItemIds;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\drop\DropManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */