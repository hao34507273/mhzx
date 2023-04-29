/*     */ package mzm.gsp.mibao.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.LotteryManager;
/*     */ import mzm.gsp.mall.main.JifenOperateResult;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.mibao.MiBaoItemInfo;
/*     */ import mzm.gsp.mibao.confbean.BaoKuConsts;
/*     */ import mzm.gsp.mibao.confbean.SBaoKuDrawLotteryCfg;
/*     */ import mzm.gsp.mibao.confbean.SBaoKuLotteryCfg;
/*     */ import mzm.gsp.mibao.confbean.SMiBaoLuckyCfg;
/*     */ import mzm.gsp.mibao.confbean.SMiBaoSpecialItemCfg;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Role2MiBaoInfo;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Xdb;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MiBaoManager
/*     */ {
/*     */   private static final String SCORE_EXCHANGE_TLOG_NAME_STRING = "BaoKuScoreExchange";
/*     */   private static final String DRAW_LOTTERY_TLOG_NAME_STRING = "BaoKuDrawLottery";
/*     */   
/*     */   static long getLeftCurrencyValue(long roleId, int currencyType)
/*     */   {
/*  56 */     switch (currencyType)
/*     */     {
/*     */     case 0: 
/*  59 */       return 0L;
/*     */     
/*     */     case 1: 
/*  62 */       String userid = RoleInterface.getUserId(roleId);
/*  63 */       return QingfuInterface.getBalance(userid, true);
/*     */     
/*     */     case 2: 
/*  66 */       return RoleInterface.getGold(roleId);
/*     */     
/*     */     case 11: 
/*  69 */       return ItemInterface.getItemNumberById(roleId, BaoKuConsts.getInstance().exchangeCostItemId);
/*     */     
/*     */     case 4: 
/*  72 */       return GangInterface.getBangGong(roleId);
/*     */     
/*     */     case 3: 
/*  75 */       return RoleInterface.getSilver(roleId);
/*     */     
/*     */     case 10: 
/*  78 */       return RoleInterface.getGoldIngot(roleId);
/*     */     
/*     */     case 5: 
/*  81 */       return MallInterface.getJifen(roleId, 3);
/*     */     
/*     */     case 6: 
/*  84 */       return MallInterface.getJifen(roleId, 2);
/*     */     
/*     */     case 8: 
/*  87 */       return MallInterface.getJifen(roleId, 4);
/*     */     
/*     */     case 7: 
/*  90 */       return MallInterface.getJifen(roleId, 1);
/*     */     
/*     */     case 9: 
/*  93 */       return RoleInterface.getVigor(roleId);
/*     */     }
/*     */     
/*  96 */     GameServer.logger().error(String.format("[mibao]MiBaoManager.getLeftCurrencyValue@not support the currency type|role_id=%d|currency_type=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(currencyType) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 102 */     return 0L;
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
/*     */   static boolean costCurrencyValue(long roleId, long costValue, int currencyType, int buyTimes)
/*     */   {
/* 119 */     if (costValue == 0L)
/*     */     {
/* 121 */       return true;
/*     */     }
/*     */     
/* 124 */     String userId = RoleInterface.getUserId(roleId);
/* 125 */     Lockeys.lock(Lockeys.get(User.getTable(), userId));
/* 126 */     switch (currencyType)
/*     */     {
/*     */     case 0: 
/* 129 */       return true;
/*     */     
/*     */     case 1: 
/* 132 */       CostResult costResult = QingfuInterface.costYuanbao(userId, roleId, (int)costValue, CostType.COST_BIND_FIRST_MI_BAO_VALUE, new TLogArg(LogReason.YI_XIAN_MI_BAO_COST_YUAN_BAO, buyTimes));
/*     */       
/*     */ 
/* 135 */       return costResult == CostResult.Success;
/*     */     
/*     */     case 2: 
/* 138 */       return RoleInterface.cutGold(roleId, costValue, new TLogArg(LogReason.YI_XIAN_MI_BAO_COST_GOLD));
/*     */     
/*     */     case 11: 
/* 141 */       int costItemId = BaoKuConsts.getInstance().exchangeCostItemId;
/* 142 */       boolean removeItemResult = ItemInterface.removeItemById(roleId, costItemId, (int)costValue, new TLogArg(LogReason.YI_XIAN_MI_BAO_COST_EXCHANGE, costItemId));
/*     */       
/* 144 */       return removeItemResult;
/*     */     
/*     */     case 4: 
/* 147 */       return GangInterface.cutBangGong(roleId, (int)costValue, new TLogArg(LogReason.YI_XIAN_MI_BAO_COST_BANG_GONG));
/*     */     
/*     */     case 3: 
/* 150 */       return RoleInterface.cutSilver(roleId, costValue, new TLogArg(LogReason.YI_XIAN_MI_BAO_COST_SILVER));
/*     */     
/*     */     case 10: 
/* 153 */       return RoleInterface.cutGoldIngot(roleId, costValue, new TLogArg(LogReason.YI_XIAN_MI_BAO_COST_JIN_DING));
/*     */     
/*     */     case 5: 
/* 156 */       JifenOperateResult shiMenResult = MallInterface.cutJifen(roleId, costValue, 3, new TLogArg(LogReason.YI_XIAN_MI_BAO_COST_SHI_MEN_VALUE));
/*     */       
/* 158 */       return shiMenResult.isSuccess();
/*     */     
/*     */     case 6: 
/* 161 */       JifenOperateResult jingJiResult = MallInterface.cutJifen(roleId, costValue, 2, new TLogArg(LogReason.YI_XIAN_MI_BAO_COST_JING_JI_VALUE));
/*     */       
/* 163 */       return jingJiResult.isSuccess();
/*     */     
/*     */     case 8: 
/* 166 */       JifenOperateResult reputationResult = MallInterface.cutJifen(roleId, costValue, 4, new TLogArg(LogReason.YI_XIAN_MI_BAO_COST_REPUTATION_VALUE));
/*     */       
/* 168 */       return reputationResult.isSuccess();
/*     */     
/*     */     case 7: 
/* 171 */       JifenOperateResult xiaYiResult = MallInterface.cutJifen(roleId, costValue, 1, new TLogArg(LogReason.YI_XIAN_MI_BAO_COST_XIA_YI_VALUE));
/*     */       
/* 173 */       return xiaYiResult.isSuccess();
/*     */     
/*     */     case 9: 
/* 176 */       return RoleInterface.cutVigor(roleId, (int)costValue, new TLogArg(LogReason.YI_XIAN_MI_BAO_COST_VIGOR));
/*     */     }
/*     */     
/* 179 */     GameServer.logger().error(String.format("[mibao]MiBaoManager.costCurrencyValue@not support the currency type|role_id=%d|currency_type=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(currencyType) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 185 */     return false;
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
/*     */   static List<MiBaoItemInfo> getRandomItemList(String userId, long roleId, Role2MiBaoInfo xRole2MiBaoInfo, SBaoKuDrawLotteryCfg sBaoKuDrawLotteryCfg, int times)
/*     */   {
/* 203 */     List<MiBaoItemInfo> miBaoItemInfoList = new ArrayList();
/* 204 */     List<AwardPoolResultData> awardPoolResultDataList = new ArrayList();
/* 205 */     for (int usedTimes = 0; usedTimes < times; usedTimes++)
/*     */     {
/*     */ 
/* 208 */       Pair<Boolean, Integer> luckyLotteryPair = triggerLuckyLottery(xRole2MiBaoInfo.getCurrent_lucky_value());
/* 209 */       int realLotteryCfgId = ((Boolean)luckyLotteryPair.first).booleanValue() ? ((Integer)luckyLotteryPair.second).intValue() : sBaoKuDrawLotteryCfg.lotteryCfgId;
/*     */       
/* 211 */       SBaoKuLotteryCfg sBaoKuLotteryCfg = SBaoKuLotteryCfg.get(realLotteryCfgId);
/*     */       
/* 213 */       List<Integer> limitRandomTextTableCfgIdList = getLimitRandomTextTableCfgIdList(xRole2MiBaoInfo);
/* 214 */       AwardPoolResultData awardPoolResultData = AwardPoolInterface.getLotteryResultData(roleId, sBaoKuLotteryCfg.awardPoolLotteryCfgId, false, limitRandomTextTableCfgIdList, null);
/*     */       
/*     */ 
/* 217 */       updateLimitDrawItemTimesInfo(xRole2MiBaoInfo, awardPoolResultData.getItemMap());
/*     */       
/* 219 */       awardPoolResultDataList.add(awardPoolResultData);
/*     */       
/* 221 */       for (Map.Entry<Integer, Integer> entry : awardPoolResultData.getItemMap().entrySet())
/*     */       {
/* 223 */         MiBaoItemInfo miBaoItemInfo = new MiBaoItemInfo();
/* 224 */         miBaoItemInfo.itemid = ((Integer)entry.getKey()).intValue();
/* 225 */         miBaoItemInfo.itemnum = ((Integer)entry.getValue()).intValue();
/* 226 */         miBaoItemInfoList.add(miBaoItemInfo);
/*     */       }
/*     */       
/* 229 */       int newLuckyValue = ((Boolean)luckyLotteryPair.first).booleanValue() ? 0 : xRole2MiBaoInfo.getCurrent_lucky_value() + sBaoKuLotteryCfg.addLuckValue;
/*     */       
/* 231 */       xRole2MiBaoInfo.setCurrent_lucky_value(newLuckyValue);
/* 232 */       xRole2MiBaoInfo.setCurrent_score(xRole2MiBaoInfo.getCurrent_score() + sBaoKuLotteryCfg.addScore);
/*     */     }
/* 234 */     LotteryManager.addLottery(roleId, 5, 0, awardPoolResultDataList, new TLogArg(LogReason.YI_XIAN_MI_BAO_ADD_RANDOM_ITEM, times), BaoKuConsts.getInstance().awardedDelayTime);
/*     */     
/*     */ 
/* 237 */     return miBaoItemInfoList;
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
/*     */   static Pair<Boolean, Integer> triggerLuckyLottery(int luckyValue)
/*     */   {
/* 250 */     TreeMap<Integer, SMiBaoLuckyCfg> sMiBaoLuckyTreeMap = (TreeMap)SMiBaoLuckyCfg.getAll();
/* 251 */     Map.Entry<Integer, SMiBaoLuckyCfg> entry = sMiBaoLuckyTreeMap.floorEntry(Integer.valueOf(luckyValue));
/* 252 */     if (entry == null)
/*     */     {
/* 254 */       return new Pair(Boolean.valueOf(false), Integer.valueOf(-1));
/*     */     }
/* 256 */     SMiBaoLuckyCfg sMiBaoLuckyCfg = (SMiBaoLuckyCfg)entry.getValue();
/*     */     
/* 258 */     boolean isTriggerSuccess = Xdb.random().nextInt(BaoKuConsts.getInstance().onSaleBase) < sMiBaoLuckyCfg.luckyProb;
/* 259 */     return isTriggerSuccess ? new Pair(Boolean.valueOf(true), Integer.valueOf(sMiBaoLuckyCfg.lotteryCfgId)) : new Pair(Boolean.valueOf(false), Integer.valueOf(-1));
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
/*     */   static boolean isMiBaoSwitchOpen(long roleId, String logString)
/*     */   {
/* 275 */     if (!OpenInterface.getOpenStatus(123))
/*     */     {
/* 277 */       GameServer.logger().info(String.format("[mibao]%s@mi bao system switch closed|role_id=%d", new Object[] { logString, Long.valueOf(roleId) }));
/*     */       
/* 279 */       return false;
/*     */     }
/*     */     
/* 282 */     if (OpenInterface.isBanPlay(roleId, 123))
/*     */     {
/* 284 */       GameServer.logger().info(String.format("[mibao]%s@mi bao is ban play|role_id=%d", new Object[] { logString, Long.valueOf(roleId) }));
/*     */       
/* 286 */       OpenInterface.sendBanPlayMsg(roleId, 123);
/* 287 */       return false;
/*     */     }
/*     */     
/* 290 */     return true;
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
/*     */   static void tlogScoreExchangeAwarded(String userId, long roleId, int score, int awardId, int leftScore, int exchangeNTimes)
/*     */   {
/* 306 */     int roleLevel = RoleInterface.getLevel(roleId);
/*     */     
/* 308 */     StringBuilder sbLog = new StringBuilder();
/* 309 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 310 */     sbLog.append(userId).append('|');
/* 311 */     sbLog.append(roleId).append('|');
/* 312 */     sbLog.append(roleLevel).append('|');
/*     */     
/* 314 */     sbLog.append(score).append('|');
/* 315 */     sbLog.append(awardId).append('|');
/* 316 */     sbLog.append(BaoKuConsts.getInstance().miBaoActivityId).append('|');
/* 317 */     sbLog.append(leftScore).append('|');
/* 318 */     sbLog.append(exchangeNTimes);
/*     */     
/* 320 */     TLogManager.getInstance().addLog(roleId, "BaoKuScoreExchange", sbLog.toString());
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
/*     */   static void tlogScoreChange(String userId, long roleId, int leftScore)
/*     */   {
/* 335 */     int roleLevel = RoleInterface.getLevel(roleId);
/*     */     
/* 337 */     StringBuilder sbLog = new StringBuilder();
/* 338 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 339 */     sbLog.append(userId).append('|');
/* 340 */     sbLog.append(roleId).append('|');
/* 341 */     sbLog.append(roleLevel).append('|');
/*     */     
/* 343 */     sbLog.append(leftScore);
/*     */     
/* 345 */     TLogManager.getInstance().addLog(roleId, "BaoKuScoreChange", sbLog.toString());
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
/*     */   static void tlogDrawLOttery(long roleId, int costCurrencyType, int costCurrencyValue, int times, List<MiBaoItemInfo> miBaoItemInfos)
/*     */   {
/* 361 */     int roleLevel = RoleInterface.getLevel(roleId);
/* 362 */     String userId = RoleInterface.getUserId(roleId);
/*     */     
/* 364 */     StringBuilder sbLog = new StringBuilder();
/* 365 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 366 */     sbLog.append(userId).append('|');
/* 367 */     sbLog.append(roleId).append('|');
/* 368 */     sbLog.append(roleLevel).append('|');
/*     */     
/* 370 */     sbLog.append(costCurrencyType).append('|');
/* 371 */     sbLog.append(costCurrencyValue).append('|');
/* 372 */     sbLog.append(times);
/*     */     
/* 374 */     for (MiBaoItemInfo miBaoItemInfo : miBaoItemInfos)
/*     */     {
/* 376 */       sbLog.append('|').append(miBaoItemInfo.itemid).append('|').append(miBaoItemInfo.itemnum);
/*     */     }
/*     */     
/* 379 */     int size = miBaoItemInfos.size();
/* 380 */     for (int index = 0; index < 10 - size; index++)
/*     */     {
/* 382 */       sbLog.append("|0|0");
/*     */     }
/* 384 */     sbLog.append("|").append(BaoKuConsts.getInstance().miBaoActivityId);
/* 385 */     TLogManager.getInstance().addLog(roleId, "BaoKuDrawLottery", sbLog.toString());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static List<Integer> getLimitRandomTextTableCfgIdList(Role2MiBaoInfo xRole2MiBaoInfo)
/*     */   {
/* 397 */     List<Integer> limitRandomTextTableCfgIdList = new ArrayList();
/* 398 */     Map<Integer, Integer> xLimitDrawItemMap = xRole2MiBaoInfo.getLimit_item_draw_times_map();
/*     */     
/* 400 */     for (Map.Entry<Integer, Integer> entry : xLimitDrawItemMap.entrySet())
/*     */     {
/* 402 */       int itemId = ((Integer)entry.getKey()).intValue();
/* 403 */       int drawTimes = ((Integer)entry.getValue()).intValue();
/*     */       
/* 405 */       SMiBaoSpecialItemCfg sMiBaoSpecialItemCfg = SMiBaoSpecialItemCfg.get(itemId);
/* 406 */       if ((sMiBaoSpecialItemCfg != null) && (sMiBaoSpecialItemCfg.limitTimes <= drawTimes))
/*     */       {
/* 408 */         limitRandomTextTableCfgIdList.addAll(sMiBaoSpecialItemCfg.randomTextTableCfgIdList);
/*     */       }
/*     */     }
/* 411 */     return limitRandomTextTableCfgIdList;
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
/*     */   private static void updateLimitDrawItemTimesInfo(Role2MiBaoInfo xRole2MiBaoInfo, Map<Integer, Integer> item2NumMap)
/*     */   {
/* 425 */     Map<Integer, Integer> xLimitDrawTimesMap = xRole2MiBaoInfo.getLimit_item_draw_times_map();
/* 426 */     for (Iterator i$ = item2NumMap.keySet().iterator(); i$.hasNext();) { int itemId = ((Integer)i$.next()).intValue();
/*     */       
/* 428 */       SMiBaoSpecialItemCfg sMiBaoSpecialItemCfg = SMiBaoSpecialItemCfg.get(itemId);
/* 429 */       if (sMiBaoSpecialItemCfg != null)
/*     */       {
/* 431 */         Integer hasDrawTimes = (Integer)xLimitDrawTimesMap.get(Integer.valueOf(itemId));
/* 432 */         if (hasDrawTimes == null)
/*     */         {
/* 434 */           xLimitDrawTimesMap.put(Integer.valueOf(itemId), Integer.valueOf(1));
/*     */         }
/*     */         else
/*     */         {
/* 438 */           xLimitDrawTimesMap.put(Integer.valueOf(itemId), Integer.valueOf(hasDrawTimes.intValue() + 1));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean checkMutexStatus(long roleId)
/*     */   {
/* 449 */     if (!RoleStatusInterface.checkCanSetStatus(roleId, 81, true))
/*     */     {
/* 451 */       GameServer.logger().error(String.format("[mibao]MiBaoManager.checkMutexStatus@contains mutex state|role_id=%d", new Object[] { Long.valueOf(roleId) }));
/*     */       
/* 453 */       return false;
/*     */     }
/* 455 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mibao\main\MiBaoManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */