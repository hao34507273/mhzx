/*     */ package mzm.gsp.huanhun.main;
/*     */ 
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.HuanHunMiShuConsts;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.baitan.main.BaiTanInterface;
/*     */ import mzm.gsp.common.confbean.STimeCommonCfg;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.huanhun.RoleBaseInfo;
/*     */ import mzm.gsp.huanhun.SHuanhunNormalResult;
/*     */ import mzm.gsp.huanhun.SNextTaskItemsRep;
/*     */ import mzm.gsp.huanhun.SRmGangHelpCache;
/*     */ import mzm.gsp.huanhun.SSynHuanHunStatus;
/*     */ import mzm.gsp.huanhun.SSynHuanhuiInfo;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.GangHelpInfo;
/*     */ import xbean.HanhunInfo;
/*     */ import xbean.Pod;
/*     */ import xdb.Xdb;
/*     */ import xtable.Gang2hunhelp;
/*     */ import xtable.Role2huanhun;
/*     */ 
/*     */ public class HuanhunManager
/*     */ {
/*  47 */   private static final Logger logger = Logger.getLogger(HuanhunManager.class);
/*  48 */   private static HuanHunMiShuConsts hunConsts = HuanHunMiShuConsts.getInstance();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void fillItemInfoBean(Map<Integer, xbean.ItemInfo> nowInfo, HashMap<Integer, mzm.gsp.huanhun.ItemInfo> iteminfos)
/*     */   {
/*  58 */     if (nowInfo.size() > 0)
/*     */     {
/*  60 */       Iterator<Map.Entry<Integer, xbean.ItemInfo>> it = nowInfo.entrySet().iterator();
/*  61 */       while (it.hasNext())
/*     */       {
/*  63 */         Map.Entry<Integer, xbean.ItemInfo> entry = (Map.Entry)it.next();
/*  64 */         xbean.ItemInfo info = (xbean.ItemInfo)entry.getValue();
/*  65 */         mzm.gsp.huanhun.ItemInfo itemInfo = new mzm.gsp.huanhun.ItemInfo();
/*  66 */         if (info.getGanghelpstate())
/*     */         {
/*  68 */           itemInfo.ganghelpstate = 1;
/*     */         }
/*     */         else
/*     */         {
/*  72 */           itemInfo.ganghelpstate = 0;
/*     */         }
/*  74 */         if (info.getFriendhelpstate())
/*     */         {
/*  76 */           itemInfo.friendhelpstate = 1;
/*     */         }
/*     */         else
/*     */         {
/*  80 */           itemInfo.friendhelpstate = 0;
/*     */         }
/*  82 */         if (info.getTaskstate())
/*     */         {
/*  84 */           itemInfo.taskstate = 1;
/*     */         }
/*     */         else
/*     */         {
/*  88 */           itemInfo.taskstate = 0;
/*     */         }
/*  90 */         RoleBaseInfo roleBaseInfo = new RoleBaseInfo();
/*  91 */         if (info.getRoleid() > 0L)
/*     */         {
/*  93 */           roleBaseInfo.roleid = info.getRoleid();
/*  94 */           roleBaseInfo.gender = RoleInterface.getGender(info.getRoleid());
/*  95 */           roleBaseInfo.level = RoleInterface.getLevel(info.getRoleid());
/*  96 */           roleBaseInfo.name = RoleInterface.getName(info.getRoleid());
/*  97 */           roleBaseInfo.occupationid = RoleInterface.getOccupationId(info.getRoleid());
/*     */         }
/*  99 */         itemInfo.itemcfgid = info.getItemcfgid();
/* 100 */         itemInfo.itemnum = info.getItemnum();
/* 101 */         itemInfo.roleinfo = roleBaseInfo;
/*     */         
/* 103 */         iteminfos.put(entry.getKey(), itemInfo);
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
/*     */   static boolean isAllBoxFull(HanhunInfo xHunInfo)
/*     */   {
/* 116 */     boolean isFull = true;
/* 117 */     if (xHunInfo.getIteminfos().size() == 0)
/*     */     {
/* 119 */       return false;
/*     */     }
/* 121 */     for (xbean.ItemInfo xInfo : xHunInfo.getIteminfos().values())
/*     */     {
/* 123 */       if (!xInfo.getTaskstate())
/*     */       {
/* 125 */         isFull = false;
/* 126 */         break;
/*     */       }
/*     */     }
/* 129 */     return isFull;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void setHunTaskFinish(long roleId)
/*     */   {
/* 139 */     int graphId = HuanHunMiShuConsts.getInstance().TASK_GRAPH_ID;
/* 140 */     int taskId = TaskInterface.findTaskInGraph(roleId, graphId);
/* 141 */     TaskInterface.changeTaskFinish(roleId, graphId, taskId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean setNowTaskAndFlushNewNextTask(HanhunInfo xHunInfo, long roleId)
/*     */   {
/* 151 */     xHunInfo.setHelpotherleftcount(HuanHunMiShuConsts.getInstance().HELP_OTHER_NUM);
/* 152 */     xHunInfo.setSeekhelpleftcount(HuanHunMiShuConsts.getInstance().SEEK_HELP_NUM);
/* 153 */     xHunInfo.setStatus(1);
/* 154 */     synHunStatus(roleId, xHunInfo.getStatus());
/* 155 */     Map<Integer, xbean.ItemInfo> nextItemMap = xHunInfo.getIteminfosnext();
/* 156 */     if (nextItemMap.size() != HuanhunInitManager.BOX_NUM)
/*     */     {
/* 158 */       flushNewHunTask(xHunInfo, roleId);
/*     */     }
/* 160 */     xHunInfo.getIteminfos().clear();
/*     */     
/* 162 */     fillNewTask(xHunInfo);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 169 */     synHunInfo(roleId, xHunInfo, true);
/*     */     
/* 171 */     flushNewHunTask(xHunInfo, roleId);
/* 172 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean synHunStatus(long roleId, int status)
/*     */   {
/* 184 */     SSynHuanHunStatus sSynHuanHunStatus = new SSynHuanHunStatus();
/* 185 */     sSynHuanHunStatus.status = status;
/* 186 */     return OnlineManager.getInstance().send(roleId, sSynHuanHunStatus);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void flushNewHunTask(HanhunInfo xHunInfo, long roleId)
/*     */   {
/* 197 */     xHunInfo.getIteminfosnext().clear();
/* 198 */     Map<Integer, SingleItemInfo> itemMap = HuanhunInitManager.getNeedItemMap(roleId);
/*     */     
/* 200 */     if (itemMap.size() != HuanhunInitManager.BOX_NUM)
/*     */     {
/* 202 */       return;
/*     */     }
/* 204 */     Map<SingleItemInfo, Integer> itemXiuLianMap = new HashMap();
/* 205 */     for (int i = 1; i <= HuanhunInitManager.BOX_NUM; i++)
/*     */     {
/* 207 */       SingleItemInfo itemGet = (SingleItemInfo)itemMap.get(Integer.valueOf(i));
/* 208 */       int xiulianExp = getXBoxXiuLianValue(itemXiuLianMap, itemGet);
/* 209 */       if (xiulianExp <= 0)
/*     */       {
/* 211 */         logger.error("[" + RoleInterface.getName(roleId) + "]获取箱子修炼经验出错！箱子号[" + i + "]，itemId= " + itemGet.getItemId());
/* 212 */         return;
/*     */       }
/* 214 */       xbean.ItemInfo xInfo = Pod.newItemInfo();
/* 215 */       xInfo.setItemcfgid(itemGet.getItemId());
/* 216 */       xInfo.setItemnum(itemGet.getItemNum());
/* 217 */       xInfo.setItemtype(itemGet.getItemIdType());
/* 218 */       xInfo.setXiulianexp(xiulianExp);
/* 219 */       xHunInfo.getIteminfosnext().put(Integer.valueOf(i), xInfo);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int getXBoxXiuLianValue(Map<SingleItemInfo, Integer> itemXiuLianMap, SingleItemInfo itemGet)
/*     */   {
/*     */     int xiulianExp;
/*     */     
/*     */ 
/*     */ 
/* 233 */     if (itemXiuLianMap.get(itemGet) == null)
/*     */     {
/* 235 */       int xiulianExp = getAwardXiulianExpValue(itemGet);
/* 236 */       if (xiulianExp <= 0)
/*     */       {
/* 238 */         return -1;
/*     */       }
/* 240 */       itemXiuLianMap.put(itemGet, Integer.valueOf(xiulianExp));
/*     */     }
/*     */     else
/*     */     {
/* 244 */       xiulianExp = ((Integer)itemXiuLianMap.get(itemGet)).intValue();
/*     */     }
/* 246 */     return xiulianExp;
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
/*     */   static int getAwardXiulianExpValue(SingleItemInfo itemGet)
/*     */   {
/* 259 */     if (itemGet == null)
/*     */     {
/* 261 */       return -1;
/*     */     }
/*     */     
/* 264 */     List<Integer> itemList = null;
/*     */     
/* 266 */     if (itemGet.getItemIdType() == 1)
/*     */     {
/* 268 */       itemList = HuanhunInterface.getHuanHunAwardItems(itemGet.getItemId());
/* 269 */       if (itemList == null)
/*     */       {
/* 271 */         return -1;
/*     */       }
/*     */     }
/* 274 */     else if (itemGet.getItemIdType() == 2)
/*     */     {
/* 276 */       itemList = new ArrayList();
/* 277 */       itemList.add(Integer.valueOf(itemGet.getItemId()));
/*     */     }
/*     */     
/* 280 */     int minPrice = getMinPriceInList(itemList);
/* 281 */     int xiuLianValue = calXiuExp(minPrice, itemGet.getItemNum());
/*     */     
/* 283 */     return xiuLianValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getMinPriceInList(List<Integer> itemList)
/*     */   {
/* 294 */     int priceLow = 0;
/*     */     
/*     */ 
/* 297 */     for (Iterator i$ = itemList.iterator(); i$.hasNext();) { int itemId = ((Integer)i$.next()).intValue();
/*     */       
/* 299 */       int baiPrice = BaiTanInterface.getItemRecommandPrice(itemId);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 304 */       if ((baiPrice > 0) && ((priceLow == 0) || (priceLow >= baiPrice)))
/*     */       {
/* 306 */         priceLow = baiPrice;
/*     */       }
/*     */       else {
/* 309 */         int shangPrce = NpcInterface.getNPCShopItemPrice(itemId);
/* 310 */         if ((shangPrce > 0) && ((priceLow == 0) || (priceLow >= shangPrce)))
/*     */         {
/* 312 */           priceLow = shangPrce; }
/*     */       }
/*     */     }
/* 315 */     return priceLow;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int calXiuExp(int price, int num)
/*     */   {
/* 327 */     int xiuExpNeedSilver = HuanHunMiShuConsts.getInstance().NEED_SILVER_PER_XIULIAN;
/* 328 */     int fmax = (int)(hunConsts.XIULIAN_RATE_HIGH * 1000.0D);
/* 329 */     int fmin = (int)(hunConsts.XIULIAN_RATE_LOW * 1000.0D);
/*     */     
/*     */ 
/* 332 */     int rate = 1000;
/* 333 */     int seed = fmax - fmin;
/* 334 */     if (seed == 0)
/*     */     {
/* 336 */       rate = fmax;
/*     */     }
/* 338 */     else if (seed > 0)
/*     */     {
/* 340 */       Random random = Xdb.random();
/* 341 */       rate = fmin + random.nextInt(seed);
/*     */     }
/* 343 */     int xiuExp = price * rate / xiuExpNeedSilver / 1000;
/*     */     
/* 345 */     if (xiuExp < hunConsts.XIULIAN_PER_ITEM_LOW)
/*     */     {
/* 347 */       xiuExp = hunConsts.XIULIAN_PER_ITEM_LOW;
/*     */     }
/* 349 */     return xiuExp * num;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void fillNewTask(HanhunInfo xHunInfo)
/*     */   {
/* 360 */     xHunInfo.getIteminfos().clear();
/* 361 */     Iterator<Map.Entry<Integer, xbean.ItemInfo>> it = xHunInfo.getIteminfosnext().entrySet().iterator();
/* 362 */     while (it.hasNext())
/*     */     {
/* 364 */       Map.Entry<Integer, xbean.ItemInfo> entry = (Map.Entry)it.next();
/* 365 */       xHunInfo.getIteminfos().put(entry.getKey(), ((xbean.ItemInfo)entry.getValue()).copy());
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
/*     */   static HashMap<Integer, mzm.gsp.huanhun.ItemInfo> fillItemInfosBean(HanhunInfo xHunInfo)
/*     */   {
/* 379 */     HashMap<Integer, mzm.gsp.huanhun.ItemInfo> iteminfos = new HashMap();
/* 380 */     Iterator<Map.Entry<Integer, xbean.ItemInfo>> it = xHunInfo.getIteminfos().entrySet().iterator();
/* 381 */     while (it.hasNext())
/*     */     {
/* 383 */       Map.Entry<Integer, xbean.ItemInfo> entry = (Map.Entry)it.next();
/* 384 */       xbean.ItemInfo xItemInfo = (xbean.ItemInfo)entry.getValue();
/* 385 */       mzm.gsp.huanhun.ItemInfo itemInfoPro = new mzm.gsp.huanhun.ItemInfo();
/* 386 */       itemInfoPro.itemcfgid = xItemInfo.getItemcfgid();
/* 387 */       itemInfoPro.itemnum = xItemInfo.getItemnum();
/* 388 */       if (xItemInfo.getFriendhelpstate())
/*     */       {
/* 390 */         itemInfoPro.friendhelpstate = 1;
/*     */       }
/*     */       else
/*     */       {
/* 394 */         itemInfoPro.friendhelpstate = 0;
/*     */       }
/* 396 */       if (xItemInfo.getGanghelpstate())
/*     */       {
/* 398 */         itemInfoPro.ganghelpstate = 1;
/*     */       }
/*     */       else
/*     */       {
/* 402 */         itemInfoPro.ganghelpstate = 0;
/*     */       }
/* 404 */       if (xItemInfo.getTaskstate())
/*     */       {
/* 406 */         itemInfoPro.taskstate = 1;
/*     */       }
/*     */       else
/*     */       {
/* 410 */         itemInfoPro.taskstate = 0;
/*     */       }
/* 412 */       itemInfoPro.awardxiulianexp = xItemInfo.getXiulianexp();
/*     */       
/* 414 */       fillHelperBaseInfo(xItemInfo, itemInfoPro);
/*     */       
/* 416 */       iteminfos.put(entry.getKey(), itemInfoPro);
/*     */     }
/* 418 */     return iteminfos;
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
/*     */   private static void fillHelperBaseInfo(xbean.ItemInfo xItemInfo, mzm.gsp.huanhun.ItemInfo itemInfoPro)
/*     */   {
/* 431 */     if (xItemInfo.getRoleid() <= 0L)
/*     */     {
/* 433 */       return;
/*     */     }
/* 435 */     long roleId = xItemInfo.getRoleid();
/* 436 */     RoleBaseInfo roleBaseInfo = getRoleBaseInfo(roleId);
/* 437 */     if (roleBaseInfo == null)
/*     */     {
/* 439 */       GameServer.logger().info(String.format("[hun]HuanhunManager.@玩家信息不存在！|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/* 440 */       return;
/*     */     }
/* 442 */     itemInfoPro.roleinfo = roleBaseInfo;
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
/*     */   private static RoleBaseInfo getRoleBaseInfo(long roleId)
/*     */   {
/* 456 */     Role role = RoleInterface.getRole(roleId, false);
/* 457 */     if (role == null)
/*     */     {
/* 459 */       return null;
/*     */     }
/* 461 */     RoleBaseInfo roleBaseInfo = new RoleBaseInfo();
/* 462 */     roleBaseInfo.roleid = roleId;
/* 463 */     roleBaseInfo.gender = role.getGender();
/* 464 */     roleBaseInfo.level = role.getLevel();
/* 465 */     roleBaseInfo.name = role.getName();
/* 466 */     roleBaseInfo.occupationid = role.getOccupationId();
/* 467 */     return roleBaseInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static HanhunInfo createHunXTable(long roleId)
/*     */   {
/* 478 */     HanhunInfo xHanhunInfo = Pod.newHanhunInfo();
/* 479 */     xHanhunInfo.setHelpotherleftcount(hunConsts.HELP_OTHER_NUM);
/* 480 */     xHanhunInfo.setStatus(0);
/* 481 */     xHanhunInfo.setSeekhelpleftcount(hunConsts.SEEK_HELP_NUM);
/*     */     
/*     */ 
/* 484 */     Role2huanhun.insert(Long.valueOf(roleId), xHanhunInfo);
/* 485 */     return Role2huanhun.get(Long.valueOf(roleId));
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
/*     */   private static boolean setNewNextTask(long roleId, HanhunInfo xHanhunInfo)
/*     */   {
/* 498 */     xHanhunInfo.getIteminfosnext().clear();
/* 499 */     Map<Integer, SingleItemInfo> itemMap = HuanhunInitManager.getNeedItemMap(roleId);
/* 500 */     for (int i = 1; i < 9; i++)
/*     */     {
/* 502 */       SingleItemInfo itemGet = (SingleItemInfo)itemMap.get(Integer.valueOf(i));
/* 503 */       xbean.ItemInfo xInfo = Pod.newItemInfo();
/* 504 */       xInfo.setItemcfgid(itemGet.getItemId());
/* 505 */       xInfo.setItemnum(itemGet.getItemNum());
/*     */       
/* 507 */       xHanhunInfo.getIteminfosnext().put(Integer.valueOf(i), xInfo);
/*     */     }
/* 509 */     if (xHanhunInfo.getIteminfosnext().size() != 8)
/*     */     {
/* 511 */       return false;
/*     */     }
/* 513 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean sendNextNeedInfo(long roleId, HanhunInfo xHunInfo)
/*     */   {
/* 524 */     SNextTaskItemsRep sNextRep = new SNextTaskItemsRep();
/* 525 */     Map<Integer, xbean.ItemInfo> xNextInfo = xHunInfo.getIteminfosnext();
/* 526 */     if (xNextInfo == null)
/*     */     {
/* 528 */       return false;
/*     */     }
/* 530 */     if (xNextInfo.size() != 8)
/*     */     {
/* 532 */       flushNewHunTask(xHunInfo, roleId);
/*     */     }
/* 534 */     Iterator<Map.Entry<Integer, xbean.ItemInfo>> it = xNextInfo.entrySet().iterator();
/* 535 */     List<Integer> nextItemList = new ArrayList();
/* 536 */     while (it.hasNext())
/*     */     {
/* 538 */       Map.Entry<Integer, xbean.ItemInfo> entry = (Map.Entry)it.next();
/* 539 */       xbean.ItemInfo info = (xbean.ItemInfo)entry.getValue();
/* 540 */       if (!nextItemList.contains(Integer.valueOf(info.getItemcfgid())))
/*     */       {
/*     */ 
/*     */ 
/* 544 */         nextItemList.add(Integer.valueOf(info.getItemcfgid()));
/* 545 */         if (nextItemList.size() == 3) {
/*     */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 551 */     sNextRep.itemids.addAll(nextItemList);
/* 552 */     OnlineManager.getInstance().send(roleId, sNextRep);
/* 553 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static RoleBaseInfo fillRoleInfo(long roleId)
/*     */   {
/* 564 */     RoleBaseInfo roleBaseInfo = new RoleBaseInfo();
/* 565 */     roleBaseInfo.roleid = roleId;
/* 566 */     roleBaseInfo.gender = RoleInterface.getGender(roleId);
/* 567 */     roleBaseInfo.level = RoleInterface.getLevel(roleId);
/* 568 */     roleBaseInfo.name = RoleInterface.getName(roleId);
/* 569 */     roleBaseInfo.occupationid = RoleInterface.getOccupationId(roleId);
/* 570 */     return roleBaseInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static long getFinishTime(long roleId)
/*     */   {
/* 581 */     int hour = HuanHunMiShuConsts.getInstance().TASK_TIME_LIMIT;
/* 582 */     long millis = TimeUnit.HOURS.toMillis(hour);
/* 583 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/* 585 */     long limitMillis = getLeftMillis(HuanHunMiShuConsts.getInstance().FLUSH_TIME, now);
/*     */     
/* 587 */     if (limitMillis < millis) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 596 */     return now + limitMillis;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static long getLeftMillis(int timeCommonCfgId, long now)
/*     */   {
/* 607 */     long endMillis = getEndMillis(timeCommonCfgId);
/*     */     
/*     */ 
/* 610 */     long timeOut = 0L;
/* 611 */     if (endMillis > now)
/*     */     {
/* 613 */       timeOut = endMillis - now;
/*     */     }
/*     */     else
/*     */     {
/* 617 */       timeOut = getLeftTime(endMillis, timeCommonCfgId, now);
/*     */     }
/*     */     
/* 620 */     return timeOut;
/*     */   }
/*     */   
/*     */   static long getEndMillis(int timeCommonCfgId)
/*     */   {
/* 625 */     Calendar startCalendar = DateTimeUtils.getCalendar();
/* 626 */     STimeCommonCfg commonCfg = STimeCommonCfg.get(timeCommonCfgId);
/* 627 */     startCalendar.set(11, commonCfg.activeHour);
/* 628 */     startCalendar.set(12, commonCfg.activeMinute);
/* 629 */     startCalendar.set(13, 0);
/* 630 */     return startCalendar.getTimeInMillis();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static long getStartTimeOfNextDay()
/*     */   {
/* 640 */     Calendar startCalendar = Calendar.getInstance();
/* 641 */     startCalendar.set(11, 23);
/* 642 */     startCalendar.set(12, 59);
/* 643 */     startCalendar.set(14, 999);
/* 644 */     return startCalendar.getTimeInMillis() + 1L;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static long getStartTimeOfNowDay()
/*     */   {
/* 654 */     Calendar startCalendar = Calendar.getInstance();
/* 655 */     startCalendar.set(11, 0);
/* 656 */     startCalendar.set(12, 0);
/* 657 */     startCalendar.set(14, 0);
/* 658 */     return startCalendar.getTimeInMillis();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static long getXDayTimeTo0(int hour, int min)
/*     */   {
/* 670 */     Calendar startCalendar = Calendar.getInstance();
/* 671 */     startCalendar.set(11, hour);
/* 672 */     startCalendar.set(12, min);
/*     */     
/* 674 */     return startCalendar.getTimeInMillis() - getStartTimeOfNowDay();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static long getNowTo24()
/*     */   {
/* 684 */     return getStartTimeOfNextDay() - DateTimeUtils.getCurrTimeInMillis();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static long get24Mis()
/*     */   {
/* 694 */     return 86400000L;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static long getLeftTime(long endMillis, int timeCommonCfgId, long now)
/*     */   {
/* 706 */     long dayMills = get24Mis();
/* 707 */     int count = 0;
/* 708 */     while (endMillis < now)
/*     */     {
/* 710 */       endMillis += dayMills;
/* 711 */       count++;
/* 712 */       if (count >= 50)
/*     */       {
/* 714 */         GameServer.logger().error(String.format("[hun]HuanhunManager.getLeftTime@算取结束时间失败，取当前时间后一天为结束时间！|endMillis=%d|now=%d|timeCommonCfgId=%d", new Object[] { Long.valueOf(endMillis), Long.valueOf(now), Integer.valueOf(timeCommonCfgId) }));
/*     */         
/*     */ 
/* 717 */         endMillis = now + dayMills;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 722 */     endMillis -= now;
/* 723 */     return endMillis;
/*     */   }
/*     */   
/*     */   public static String getTimeString(long mills)
/*     */   {
/* 728 */     Date d = new Date(mills);
/* 729 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 730 */     return sdf.format(d);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static long getNowToNextDayXTime(int hour, int min)
/*     */   {
/* 742 */     return getNowTo24() + getXDayTimeTo0(hour, min);
/*     */   }
/*     */   
/*     */   static long getNowToNextDayXTime(int timeCommonCfgId)
/*     */   {
/* 747 */     STimeCommonCfg commonCfg = STimeCommonCfg.get(timeCommonCfgId);
/* 748 */     return getNowToNextDayXTime(commonCfg.activeHour, commonCfg.activeMinute);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sendNormalResult(int result, long roleid, String... args)
/*     */   {
/* 760 */     SHuanhunNormalResult pro = new SHuanhunNormalResult();
/* 761 */     pro.result = result;
/* 762 */     for (String arg : args)
/*     */     {
/* 764 */       pro.args.add(arg);
/*     */     }
/* 766 */     OnlineManager.getInstance().sendAtOnce(roleid, pro);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isHunOpen(long roleId)
/*     */   {
/* 776 */     if (!OpenInterface.getOpenStatus(9))
/*     */     {
/* 778 */       return false;
/*     */     }
/* 780 */     if (OpenInterface.isBanPlay(roleId, 9))
/*     */     {
/* 782 */       OpenInterface.sendBanPlayMsg(roleId, 9);
/* 783 */       return false;
/*     */     }
/* 785 */     return true;
/*     */   }
/*     */   
/*     */   static boolean isHunHelpOpen(long roleId)
/*     */   {
/* 790 */     if (!OpenInterface.getOpenStatus(146))
/*     */     {
/* 792 */       return false;
/*     */     }
/* 794 */     if (OpenInterface.isBanPlay(roleId, 146))
/*     */     {
/* 796 */       OpenInterface.sendBanPlayMsg(roleId, 146);
/* 797 */       return false;
/*     */     }
/* 799 */     return true;
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
/*     */   static void synHunInfo(long roleId, HanhunInfo xHunInfo, boolean fristTime)
/*     */   {
/* 813 */     SSynHuanhuiInfo syn = new SSynHuanhuiInfo();
/* 814 */     syn.helpotherleftcount = xHunInfo.getHelpotherleftcount();
/* 815 */     syn.seekhelpleftcount = xHunInfo.getSeekhelpleftcount();
/* 816 */     syn.timelimit = ActivityInterface.getActivityEndTime(HuanHunMiShuConsts.getInstance().ACTIVITYID);
/* 817 */     syn.status = xHunInfo.getStatus();
/* 818 */     if (fristTime)
/*     */     {
/* 820 */       syn.firsttime = 1;
/*     */     }
/*     */     else
/*     */     {
/* 824 */       syn.firsttime = 0;
/*     */     }
/* 826 */     HashMap<Integer, mzm.gsp.huanhun.ItemInfo> iteminfos = fillItemInfosBean(xHunInfo);
/* 827 */     syn.iteminfos = iteminfos;
/*     */     
/* 829 */     OnlineManager.getInstance().send(roleId, syn);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static HunNeedItemData getHunNeedItemData(long roleId)
/*     */   {
/* 840 */     HanhunInfo xHunInfo = Role2huanhun.select(Long.valueOf(roleId));
/* 841 */     if (xHunInfo == null)
/*     */     {
/* 843 */       return null;
/*     */     }
/* 845 */     if (!TaskInterface.isHaveGraphId(roleId, HuanHunMiShuConsts.getInstance().TASK_GRAPH_ID))
/*     */     {
/* 847 */       return null;
/*     */     }
/* 849 */     HunNeedItemData data = new HunNeedItemData();
/* 850 */     for (xbean.ItemInfo xItemInfo : xHunInfo.getIteminfos().values())
/*     */     {
/* 852 */       getBoxNeedItem(data, xItemInfo);
/*     */     }
/* 854 */     return data;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void getBoxNeedItem(HunNeedItemData data, xbean.ItemInfo xItemInfo)
/*     */   {
/* 865 */     if (xItemInfo.getTaskstate())
/*     */     {
/* 867 */       return;
/*     */     }
/* 869 */     int itemType = xItemInfo.getItemtype();
/* 870 */     int itemId = xItemInfo.getItemcfgid();
/* 871 */     int num = xItemInfo.getItemnum();
/* 872 */     switch (itemType)
/*     */     {
/*     */     case 2: 
/* 875 */       data.addNormalItem(itemId, num);
/* 876 */       break;
/*     */     case 1: 
/* 878 */       data.addEqualItem(itemId, num);
/* 879 */       break;
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void rmGangAllHelp(long gangId, Collection<Long> members)
/*     */   {
/* 892 */     GameServer.logger().info(String.format("[hun]HuanhunManager.rmGangAllHelp@ rmGangAllHelp!|gangId=%d", new Object[] { Long.valueOf(gangId) }));
/* 893 */     OnlineManager.getInstance().sendMulti(new SRmGangHelpCache(), members);
/*     */     
/* 895 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 901 */         Gang2hunhelp.remove(Long.valueOf(this.val$gangId));
/* 902 */         return false;
/*     */       }
/*     */     });
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
/*     */   static boolean isRoleCallFactionHelp(long roleId, int boxIndex)
/*     */   {
/* 921 */     long gangId = GangInterface.getGangId(roleId);
/* 922 */     if (gangId <= 0L)
/*     */     {
/* 924 */       return false;
/*     */     }
/*     */     
/* 927 */     GangHelpInfo xHelpInfo = Gang2hunhelp.select(Long.valueOf(gangId));
/* 928 */     if (xHelpInfo == null)
/*     */     {
/* 930 */       return false;
/*     */     }
/* 932 */     HunGangHelpInfo helpInfo = new HunGangHelpInfo(xHelpInfo);
/* 933 */     return helpInfo.isBoxCallHelped(roleId, boxIndex);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\HuanhunManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */