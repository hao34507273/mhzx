/*     */ package mzm.gsp.luckybag.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.bag.confbean.ItemType2BagCfg;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.item.main.LotteryManager;
/*     */ import mzm.gsp.luckybag.ItemInfo;
/*     */ import mzm.gsp.luckybag.SOpenLuckyBagSuccess;
/*     */ import mzm.gsp.luckybag.SOpenMultipleLuckyBagSuccess;
/*     */ import mzm.gsp.luckybag.confbean.SLuckyBagCfgConsts;
/*     */ import mzm.gsp.luckybag.event.OpenLuckyBag;
/*     */ import mzm.gsp.luckybag.event.OpenLuckyBagArg;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.MapItemGatherContext;
/*     */ import mzm.gsp.map.main.MapItemGatherHandler;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.LuckyBagInfo;
/*     */ import xdb.Lockey;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PLuckyBagGatherHandler implements MapItemGatherHandler
/*     */ {
/*     */   private final int handlerType;
/*     */   
/*     */   public PLuckyBagGatherHandler(int handlerType)
/*     */   {
/*  51 */     this.handlerType = handlerType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Lockey> collectLocks(String userid, long roleid, long worldid, int mapCfgid, int mapItemCfgid, MapItemGatherContext context)
/*     */   {
/*  58 */     Set<Lockey> lockeys = new HashSet();
/*  59 */     lockeys.add(Lockeys.get(User.getTable(), userid));
/*  60 */     lockeys.add(Lockeys.get(Basic.getTable(), Long.valueOf(roleid)));
/*  61 */     return lockeys;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean gatherCheck(String userid, long roleid, long worldid, int mapCfgid, int mapItemCfgid, MapItemGatherContext context)
/*     */   {
/*  68 */     if (!LuckyBagManager.isFunOpen(roleid))
/*     */     {
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     if (!(context instanceof LuckyBagGatherContext))
/*     */     {
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     LuckyBagGatherContext luckyBagGatherContext = (LuckyBagGatherContext)context;
/*     */     
/*     */ 
/*  81 */     long roleWorldid = MapInterface.getRoleWorldInstanceId(roleid);
/*  82 */     if (roleWorldid != worldid)
/*     */     {
/*  84 */       Map<String, Object> extras = new HashMap();
/*  85 */       extras.put("worldid", Long.valueOf(worldid));
/*  86 */       extras.put("map_cfgid", Integer.valueOf(mapCfgid));
/*  87 */       extras.put("map_item_cfgid", Integer.valueOf(mapItemCfgid));
/*  88 */       extras.put("handler_type", Integer.valueOf(this.handlerType));
/*  89 */       extras.put("role_worldid", Long.valueOf(roleWorldid));
/*  90 */       LuckyBagManager.onFailed(roleid, 1, luckyBagGatherContext, extras);
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     int activityCfgid = SLuckyBagCfgConsts.getInstance().ACTIVITY_CFG_ID;
/*  95 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, activityCfgid);
/*     */     
/*  97 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*  99 */       Map<String, Object> extras = new HashMap();
/* 100 */       extras.put("worldid", Long.valueOf(worldid));
/* 101 */       extras.put("map_cfgid", Integer.valueOf(mapCfgid));
/* 102 */       extras.put("map_item_cfgid", Integer.valueOf(mapItemCfgid));
/* 103 */       extras.put("handler_type", Integer.valueOf(this.handlerType));
/* 104 */       extras.put("activity_join_result", Integer.valueOf(activityJoinResult.getReasonValue()));
/* 105 */       LuckyBagManager.onFailed(roleid, -4, luckyBagGatherContext, extras);
/* 106 */       return false;
/*     */     }
/*     */     
/* 109 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean onGather(String userid, long roleid, long worldid, int mapCfgid, int mapItemCfgid, int itemCfgid, int itemNum, MapItemGatherContext context)
/*     */   {
/* 116 */     if (!(context instanceof LuckyBagGatherContext))
/*     */     {
/* 118 */       return false;
/*     */     }
/*     */     
/* 121 */     LuckyBagGatherContext luckyBagGatherContext = (LuckyBagGatherContext)context;
/* 122 */     boolean useYuanbao = luckyBagGatherContext.useYuanbao;
/* 123 */     long clientYuanbao = luckyBagGatherContext.clientYuanbao;
/* 124 */     boolean multiple = luckyBagGatherContext.multiple;
/*     */     
/* 126 */     LuckyBagContext luckyBagContext = getContext();
/* 127 */     LogReason logReason = luckyBagContext.getLogReason();
/* 128 */     int costItemCfgid = luckyBagContext.getItemCfgid();
/* 129 */     int costItemNum = multiple ? luckyBagContext.getMutipleItemNum() : luckyBagContext.getItemNum();
/* 130 */     int openNum = multiple ? 10 : 1;
/* 131 */     int type = luckyBagContext.getType();
/*     */     
/* 133 */     int bagItemNum = ItemInterface.getItemNumberById(roleid, costItemCfgid);
/* 134 */     int needYuanbao = ItemInterface.getItemYuanBaoPrice(costItemCfgid) * (costItemNum - bagItemNum);
/* 135 */     if (needYuanbao < 0)
/*     */     {
/* 137 */       needYuanbao = 0;
/*     */     }
/*     */     
/* 140 */     if (useYuanbao)
/*     */     {
/* 142 */       long yuanbao = QingfuInterface.getBalance(userid, true);
/* 143 */       if (yuanbao != clientYuanbao)
/*     */       {
/* 145 */         Map<String, Object> extras = new HashMap();
/* 146 */         extras.put("handler_type", Integer.valueOf(this.handlerType));
/* 147 */         LuckyBagManager.onFailed(roleid, -6, luckyBagGatherContext, extras);
/*     */         
/* 149 */         return false;
/*     */       }
/*     */       
/* 152 */       if (!LuckyBagManager.removeItem(userid, roleid, clientYuanbao, needYuanbao, costItemCfgid, costItemNum, logReason))
/*     */       {
/* 154 */         Map<String, Object> extras = new HashMap();
/* 155 */         extras.put("worldid", Long.valueOf(worldid));
/* 156 */         extras.put("map_cfgid", Integer.valueOf(mapCfgid));
/* 157 */         extras.put("map_item_cfgid", Integer.valueOf(mapItemCfgid));
/* 158 */         extras.put("handler_type", Integer.valueOf(this.handlerType));
/* 159 */         LuckyBagManager.onFailed(roleid, -2, luckyBagGatherContext, extras);
/* 160 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */     }
/* 165 */     else if (!LuckyBagManager.removeItem(roleid, costItemCfgid, costItemNum, logReason))
/*     */     {
/* 167 */       Map<String, Object> extras = new HashMap();
/* 168 */       extras.put("worldid", Long.valueOf(worldid));
/* 169 */       extras.put("map_cfgid", Integer.valueOf(mapCfgid));
/* 170 */       extras.put("map_item_cfgid", Integer.valueOf(mapItemCfgid));
/* 171 */       extras.put("handler_type", Integer.valueOf(this.handlerType));
/* 172 */       LuckyBagManager.onFailed(roleid, -1, luckyBagGatherContext, extras);
/* 173 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 178 */     int awardCfgid = luckyBagContext.getAwardCfgid();
/* 179 */     int uiCfgid = luckyBagContext.getUiCfgid();
/* 180 */     int addScore = luckyBagContext.getAddScore();
/*     */     
/*     */ 
/* 183 */     int grid = 0;
/* 184 */     Map<Integer, Integer> fixedItems = new HashMap();
/* 185 */     if (awardCfgid > 0)
/*     */     {
/*     */ 
/* 188 */       grid = getGridAndFillFixItems(roleid, awardCfgid, openNum, fixedItems, logReason);
/* 189 */       if (grid < 0)
/*     */       {
/* 191 */         Map<String, Object> extras = new HashMap();
/* 192 */         extras.put("worldid", Long.valueOf(worldid));
/* 193 */         extras.put("map_cfgid", Integer.valueOf(mapCfgid));
/* 194 */         extras.put("map_item_cfgid", Integer.valueOf(mapItemCfgid));
/* 195 */         extras.put("handler_type", Integer.valueOf(this.handlerType));
/* 196 */         extras.put("award_cfgid", Integer.valueOf(awardCfgid));
/* 197 */         LuckyBagManager.onFailed(roleid, 2, luckyBagGatherContext, extras);
/* 198 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 204 */     Set<Integer> needBagIds = new HashSet(2);
/* 205 */     for (Iterator i$ = fixedItems.keySet().iterator(); i$.hasNext();) { int itemId = ((Integer)i$.next()).intValue();
/*     */       
/* 207 */       int itemType = SItemCfg.get(itemId).type;
/* 208 */       ItemType2BagCfg itemType2BagCfg = ItemType2BagCfg.get(itemType);
/* 209 */       if (itemType2BagCfg == null)
/*     */       {
/* 211 */         needBagIds.add(Integer.valueOf(340600000));
/*     */       }
/*     */       else
/*     */       {
/* 215 */         needBagIds.add(Integer.valueOf(itemType2BagCfg.bagId));
/*     */       }
/*     */     }
/* 218 */     Map<Integer, Integer> bagId2MaxNeedGrid = AwardPoolInterface.getBagId2LotteryNeedGrid(uiCfgid);
/* 219 */     for (Iterator i$ = bagId2MaxNeedGrid.keySet().iterator(); i$.hasNext();) { int key = ((Integer)i$.next()).intValue();
/*     */       
/* 221 */       bagId2MaxNeedGrid.put(Integer.valueOf(key), Integer.valueOf(((Integer)bagId2MaxNeedGrid.get(Integer.valueOf(key))).intValue() * openNum));
/*     */     }
/* 223 */     for (Iterator i$ = needBagIds.iterator(); i$.hasNext();) { int bagId = ((Integer)i$.next()).intValue();
/*     */       
/* 225 */       Integer oldNum = (Integer)bagId2MaxNeedGrid.get(Integer.valueOf(bagId));
/* 226 */       if (null == oldNum)
/*     */       {
/* 228 */         bagId2MaxNeedGrid.put(Integer.valueOf(bagId), Integer.valueOf(grid));
/*     */       }
/*     */       else
/*     */       {
/* 232 */         bagId2MaxNeedGrid.put(Integer.valueOf(bagId), Integer.valueOf(oldNum.intValue() + grid));
/*     */       }
/*     */     }
/* 235 */     if (AwardPoolInterface.checkGridNum(roleid, bagId2MaxNeedGrid, true, true) > 0)
/*     */     {
/* 237 */       Map<String, Object> extras = new HashMap();
/* 238 */       extras.put("worldid", Long.valueOf(worldid));
/* 239 */       extras.put("map_cfgid", Integer.valueOf(mapCfgid));
/* 240 */       extras.put("map_item_cfgid", Integer.valueOf(mapItemCfgid));
/* 241 */       extras.put("handler_type", Integer.valueOf(this.handlerType));
/* 242 */       LuckyBagManager.onFailed(roleid, -5, luckyBagGatherContext, extras, false);
/* 243 */       return false;
/*     */     }
/*     */     
/* 246 */     TLogArg logArg = new TLogArg(logReason, openNum);
/* 247 */     if (!fixedItems.isEmpty())
/*     */     {
/*     */ 
/* 250 */       ItemOperateResult fixAwardResult = ItemInterface.addItem(roleid, fixedItems, false, logArg);
/* 251 */       if ((!fixAwardResult.isBagFull()) && (!fixAwardResult.success()))
/*     */       {
/* 253 */         Map<String, Object> extras = new HashMap();
/* 254 */         extras.put("worldid", Long.valueOf(worldid));
/* 255 */         extras.put("map_cfgid", Integer.valueOf(mapCfgid));
/* 256 */         extras.put("map_item_cfgid", Integer.valueOf(mapItemCfgid));
/* 257 */         extras.put("handler_type", Integer.valueOf(this.handlerType));
/* 258 */         extras.put("award_cfgid", Integer.valueOf(awardCfgid));
/* 259 */         LuckyBagManager.onFailed(roleid, 2, luckyBagGatherContext, extras);
/* 260 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 264 */     if (addScore > 0)
/*     */     {
/*     */ 
/* 267 */       LuckyBagInfo xLuckyBagInfo = LuckyBagManager.getAndInitLuckyBagInfo(roleid);
/* 268 */       int beginScore = xLuckyBagInfo.getScore();
/* 269 */       int endScore = beginScore + addScore * openNum;
/* 270 */       xLuckyBagInfo.setScore(endScore);
/*     */       
/* 272 */       LuckyBagManager.syncLuckyBagExchangeScore(roleid, xLuckyBagInfo.getScore());
/*     */       
/*     */ 
/* 275 */       LuckyBagManager.addTLog(roleid, "LuckyBagScoreExchangeForServer", new Object[] { Integer.valueOf(beginScore), Integer.valueOf(endScore), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
/*     */     }
/*     */     
/*     */ 
/* 279 */     Map<Integer, Integer> awards = new HashMap();
/* 280 */     if (multiple)
/*     */     {
/*     */ 
/* 283 */       List<ItemInfo> itemInfos = new ArrayList();
/* 284 */       multipleOpenAndFillInfo(roleid, uiCfgid, openNum, itemInfos, awards, logArg);
/*     */       
/* 286 */       SOpenMultipleLuckyBagSuccess msg = new SOpenMultipleLuckyBagSuccess();
/* 287 */       msg.award_items.addAll(itemInfos);
/* 288 */       msg.client_yuanbao = clientYuanbao;
/* 289 */       msg.instanceid = luckyBagGatherContext.instanceid;
/* 290 */       msg.items.putAll(awards);
/* 291 */       msg.use_yuanbao = ((byte)(useYuanbao ? 1 : 0));
/* 292 */       OnlineManager.getInstance().send(roleid, msg);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 297 */       AwardPoolResultData awardPoolResultData = AwardPoolInterface.getLotteryResultData(roleid, uiCfgid);
/* 298 */       LotteryManager.addLottery(roleid, 6, 0, awardPoolResultData, logArg, 8);
/*     */       
/* 300 */       awards.putAll(awardPoolResultData.getItemMap());
/*     */       
/* 302 */       SOpenLuckyBagSuccess msg = new SOpenLuckyBagSuccess();
/* 303 */       msg.award_items.putAll(awards);
/* 304 */       msg.items.putAll(fixedItems);
/* 305 */       msg.index = awardPoolResultData.getIndex();
/* 306 */       msg.client_yuanbao = clientYuanbao;
/* 307 */       msg.instanceid = luckyBagGatherContext.instanceid;
/* 308 */       msg.use_yuanbao = ((byte)(useYuanbao ? 1 : 0));
/* 309 */       OnlineManager.getInstance().send(roleid, msg);
/*     */     }
/*     */     
/*     */ 
/* 313 */     TriggerEventsManger.getInstance().triggerEvent(new OpenLuckyBag(), new OpenLuckyBagArg(roleid, type, openNum));
/*     */     
/*     */ 
/* 316 */     LuckyBagManager.addTlog(roleid, mapItemCfgid, useYuanbao, clientYuanbao, needYuanbao, awardCfgid, awards, openNum);
/*     */     
/*     */ 
/* 319 */     ActivityInterface.logActivity(roleid, SLuckyBagCfgConsts.getInstance().ACTIVITY_CFG_ID, ActivityLogStatus.FINISH);
/*     */     
/* 321 */     ActivityInterface.tlogActivity(roleid, SLuckyBagCfgConsts.getInstance().ACTIVITY_CFG_ID, ActivityLogStatus.FINISH);
/*     */     
/* 323 */     GameServer.logger().info(String.format("[luckybag]PLuckyBagGatherHandler.onGather@gather success|roleid=%d|activity_cfgid=%d|instanceid=%d|use_yuanbao=%b|client_yuanbao=%d|multiple=%b", new Object[] { Long.valueOf(roleid), Integer.valueOf(SLuckyBagCfgConsts.getInstance().ACTIVITY_CFG_ID), Integer.valueOf(luckyBagGatherContext.instanceid), Boolean.valueOf(useYuanbao), Long.valueOf(clientYuanbao), Boolean.valueOf(multiple) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 328 */     return true;
/*     */   }
/*     */   
/*     */   protected LuckyBagContext getContext()
/*     */   {
/* 333 */     return new LuckyBagContext();
/*     */   }
/*     */   
/*     */ 
/*     */   private void multipleOpenAndFillInfo(long roleid, int uiCfgid, int openNum, List<ItemInfo> itemInfos, Map<Integer, Integer> awards, TLogArg logArg)
/*     */   {
/* 339 */     List<AwardPoolResultData> awardPoolResultDatas = new ArrayList();
/* 340 */     for (int i = 0; i < openNum; i++)
/*     */     {
/* 342 */       AwardPoolResultData awardPoolResultData = AwardPoolInterface.getLotteryResultData(roleid, uiCfgid);
/* 343 */       awardPoolResultDatas.add(awardPoolResultData);
/* 344 */       Map<Integer, Integer> awardItems = awardPoolResultData.getItemMap();
/* 345 */       for (Map.Entry<Integer, Integer> entry : awardItems.entrySet())
/*     */       {
/* 347 */         int itemid = ((Integer)entry.getKey()).intValue();
/* 348 */         int num = ((Integer)entry.getValue()).intValue();
/*     */         
/* 350 */         ItemInfo itemInfo = new ItemInfo(itemid, num);
/* 351 */         itemInfos.add(itemInfo);
/*     */         
/* 353 */         Integer oldNum = (Integer)awards.get(Integer.valueOf(itemid));
/* 354 */         if (oldNum == null)
/*     */         {
/* 356 */           awards.put(Integer.valueOf(itemid), Integer.valueOf(num));
/*     */         }
/*     */         else
/*     */         {
/* 360 */           awards.put(Integer.valueOf(itemid), Integer.valueOf(oldNum.intValue() + num));
/*     */         }
/*     */       }
/*     */     }
/* 364 */     LotteryManager.addLottery(roleid, 6, 0, awardPoolResultDatas, logArg, 8);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getGridAndFillFixItems(long roleid, int awardCfgid, int openNum, Map<Integer, Integer> fixedItems, LogReason logReason)
/*     */   {
/* 372 */     AwardReason openBagAwardReason = new AwardReason(logReason, awardCfgid);
/* 373 */     openBagAwardReason.setAwardItemBind(false);
/* 374 */     AwardModel awardModel = mzm.gsp.award.main.AwardInterface.getRoleFixAwardModel(awardCfgid, roleid, openBagAwardReason);
/* 375 */     if (awardModel == null)
/*     */     {
/* 377 */       return -1;
/*     */     }
/*     */     
/* 380 */     for (Map.Entry<Integer, Integer> entry : awardModel.getItemMap().entrySet())
/*     */     {
/* 382 */       fixedItems.put(entry.getKey(), Integer.valueOf(((Integer)entry.getValue()).intValue() * openNum));
/*     */     }
/*     */     
/* 385 */     return ItemInterface.needGrid(fixedItems);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckybag\main\PLuckyBagGatherHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */