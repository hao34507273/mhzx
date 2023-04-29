/*     */ package mzm.gsp.mibao.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.LotteryManager;
/*     */ import mzm.gsp.mibao.MiBaoItemInfo;
/*     */ import mzm.gsp.mibao.SBuyMiBaoFail;
/*     */ import mzm.gsp.mibao.SBuyMiBaoSuccess;
/*     */ import mzm.gsp.mibao.confbean.BaoKuConsts;
/*     */ import mzm.gsp.mibao.confbean.SBaoKuDrawLotteryCfg;
/*     */ import mzm.gsp.mibao.confbean.SBaoKuLotteryCfg;
/*     */ import mzm.gsp.mibao.event.DrawMiBaoLottery;
/*     */ import mzm.gsp.mibao.event.DrawMiBaoLotteryArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Role2MiBaoInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2mibao;
/*     */ import xtable.User;
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
/*     */ public class PCBuyMiBaoReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long clientCurrencyValue;
/*     */   private final int currentIndexId;
/*     */   private final int buyTimes;
/*     */   private final boolean isUseYuanBao;
/*     */   private final int clientNeedYuanBao;
/*     */   private int costCurrencyType;
/*     */   private int costCurrencyValue;
/*     */   
/*     */   public PCBuyMiBaoReq(long roleId, long clientCurrencyValue, int currentIndexId, int buyTimes, int isUseYuanBao, int clientNeedYuanBao)
/*     */   {
/*  67 */     this.roleId = roleId;
/*  68 */     this.clientCurrencyValue = clientCurrencyValue;
/*  69 */     this.currentIndexId = currentIndexId;
/*  70 */     this.buyTimes = buyTimes;
/*  71 */     this.clientNeedYuanBao = clientNeedYuanBao;
/*  72 */     this.isUseYuanBao = (isUseYuanBao == 1);
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  78 */     if (((this.buyTimes != 1) && (this.buyTimes != 10)) || (this.clientCurrencyValue < 0L) || (this.currentIndexId <= 0) || (this.currentIndexId > SBaoKuDrawLotteryCfg.getAll().size()))
/*     */     {
/*     */ 
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     if (!MiBaoManager.checkMutexStatus(this.roleId))
/*     */     {
/*  86 */       return false;
/*     */     }
/*     */     
/*  89 */     if (!MiBaoManager.isMiBaoSwitchOpen(this.roleId, "PCBuyMiBaoReq.processImp"))
/*     */     {
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     String userId = RoleInterface.getUserId(this.roleId);
/*  95 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  97 */     int miBaoActivityCfgId = BaoKuConsts.getInstance().miBaoActivityId;
/*  98 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, miBaoActivityCfgId);
/*     */     
/* 100 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/* 102 */       Map<String, Object> extraMap = new HashMap();
/* 103 */       extraMap.put("activity_cfg_id", Integer.valueOf(miBaoActivityCfgId));
/* 104 */       extraMap.put("reason_value", Integer.valueOf(activityJoinResult.getReasonValue()));
/*     */       
/* 106 */       onBuyMiBaoFail(10, extraMap);
/*     */       
/* 108 */       return false;
/*     */     }
/*     */     
/* 111 */     Role2MiBaoInfo xRole2MiBaoInfo = Role2mibao.get(Long.valueOf(this.roleId));
/* 112 */     if (xRole2MiBaoInfo == null)
/*     */     {
/* 114 */       onBuyMiBaoFail(11);
/* 115 */       return false;
/*     */     }
/*     */     
/* 118 */     if (!LotteryManager.canAdd(this.roleId, 5))
/*     */     {
/* 120 */       onBuyMiBaoFail(2);
/* 121 */       return false;
/*     */     }
/*     */     
/* 124 */     SBaoKuDrawLotteryCfg sBaoKuDrawLotteryCfg = SBaoKuDrawLotteryCfg.get(this.currentIndexId);
/* 125 */     if (sBaoKuDrawLotteryCfg == null)
/*     */     {
/* 127 */       Map<String, Object> extraMap = new HashMap();
/* 128 */       extraMap.put("db_current_index_id", Integer.valueOf(xRole2MiBaoInfo.getCurrent_index_id()));
/*     */       
/* 130 */       onBuyMiBaoFail(5, extraMap);
/*     */       
/* 132 */       return false;
/*     */     }
/*     */     
/* 135 */     SBaoKuLotteryCfg sBaoKuLotteryCfg = SBaoKuLotteryCfg.get(sBaoKuDrawLotteryCfg.lotteryCfgId);
/* 136 */     Map<Integer, Integer> bagId2MaxNeedGrid = AwardPoolInterface.getBagId2LotteryNeedGrid(sBaoKuLotteryCfg.awardPoolLotteryCfgId);
/* 137 */     if (AwardPoolInterface.checkGridNum(this.roleId, bagId2MaxNeedGrid, this.buyTimes, true, true) > 0)
/*     */     {
/* 139 */       int leftGrid = ItemInterface.getAvailableGridNum(this.roleId, 340600000, true);
/* 140 */       Map<String, Object> extraMap = new HashMap();
/* 141 */       extraMap.put("lottery_cfg_id", Integer.valueOf(sBaoKuDrawLotteryCfg.lotteryCfgId));
/* 142 */       extraMap.put("need_grid", bagId2MaxNeedGrid);
/* 143 */       extraMap.put("left_grid", Integer.valueOf(leftGrid));
/*     */       
/* 145 */       onBuyMiBaoFail(14, extraMap, true);
/* 146 */       return false;
/*     */     }
/*     */     
/* 149 */     long activityLimitEndTime = ActivityInterface.getActivityLimitTimeEnd(BaoKuConsts.getInstance().miBaoActivityId);
/* 150 */     long banBuyTime = activityLimitEndTime - BaoKuConsts.getInstance().banBuyDays * 86400000L;
/* 151 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/* 152 */     if (currentTimeMillis >= banBuyTime)
/*     */     {
/* 154 */       Map<String, Object> extraMap = new HashMap();
/* 155 */       extraMap.put("current_time_millis", Long.valueOf(currentTimeMillis));
/* 156 */       extraMap.put("ban_buy_time_millis", Long.valueOf(banBuyTime));
/* 157 */       extraMap.put("activity_limit_end_time", Long.valueOf(activityLimitEndTime));
/* 158 */       extraMap.put("ban_days", Integer.valueOf(BaoKuConsts.getInstance().banBuyDays));
/*     */       
/* 160 */       onBuyMiBaoFail(3, extraMap);
/*     */       
/* 162 */       return false;
/*     */     }
/*     */     
/* 165 */     if (currentTimeMillis >= activityLimitEndTime)
/*     */     {
/* 167 */       Map<String, Object> extraMap = new HashMap();
/* 168 */       extraMap.put("current_time_millis", Long.valueOf(currentTimeMillis));
/* 169 */       extraMap.put("ban_buy_time_millis", Long.valueOf(banBuyTime));
/* 170 */       extraMap.put("activity_limit_end_time", Long.valueOf(activityLimitEndTime));
/* 171 */       extraMap.put("ban_days", Integer.valueOf(BaoKuConsts.getInstance().banBuyDays));
/*     */       
/* 173 */       onBuyMiBaoFail(10, extraMap);
/*     */       
/* 175 */       return false;
/*     */     }
/*     */     
/* 178 */     this.costCurrencyType = sBaoKuLotteryCfg.costCurrencyType;
/* 179 */     long serverCurrentValue = MiBaoManager.getLeftCurrencyValue(this.roleId, this.costCurrencyType);
/*     */     
/* 181 */     this.costCurrencyValue = sBaoKuLotteryCfg.costCurrencyNum;
/*     */     
/* 183 */     if ((this.costCurrencyType != 0) && (serverCurrentValue != this.clientCurrencyValue))
/*     */     {
/* 185 */       Map<String, Object> extraMap = new HashMap();
/* 186 */       extraMap.put("real_currency_value", Long.valueOf(serverCurrentValue));
/*     */       
/* 188 */       onBuyMiBaoFail(4, extraMap);
/*     */       
/* 190 */       return false;
/*     */     }
/*     */     
/* 193 */     int xCurrentDbIndexId = xRole2MiBaoInfo.getCurrent_index_id();
/* 194 */     if ((this.currentIndexId != xRole2MiBaoInfo.getCurrent_index_id()) && (this.currentIndexId != BaoKuConsts.getInstance().yuanBaoIndex) && (this.currentIndexId != BaoKuConsts.getInstance().exchangeIndex))
/*     */     {
/*     */ 
/*     */ 
/* 198 */       Map<String, Object> extraMap = new HashMap();
/* 199 */       extraMap.put("db_current_index_id", Integer.valueOf(xCurrentDbIndexId));
/*     */       
/* 201 */       onBuyMiBaoFail(5, extraMap);
/*     */       
/* 203 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 207 */     if (ItemInterface.isBagFull(this.roleId, 340600000, true))
/*     */     {
/* 209 */       onBuyMiBaoFail(6);
/*     */       
/* 211 */       return false;
/*     */     }
/*     */     
/* 214 */     int hasBuyTimesToday = xRole2MiBaoInfo.getBuy_times_today();
/* 215 */     if ((BaoKuConsts.getInstance().maxBuyTimesEveryDay > 0) && (hasBuyTimesToday >= BaoKuConsts.getInstance().maxBuyTimesEveryDay))
/*     */     {
/*     */ 
/* 218 */       Map<String, Object> extraMap = new HashMap();
/* 219 */       extraMap.put("buy_times_today", Integer.valueOf(hasBuyTimesToday));
/* 220 */       extraMap.put("max_buy_times_today", Integer.valueOf(BaoKuConsts.getInstance().maxBuyTimesEveryDay));
/*     */       
/* 222 */       onBuyMiBaoFail(1, extraMap);
/*     */       
/* 224 */       return false;
/*     */     }
/*     */     
/* 227 */     int yuanBaoIndexId = BaoKuConsts.getInstance().yuanBaoIndex;
/* 228 */     int exChangeIndexId = BaoKuConsts.getInstance().exchangeIndex;
/*     */     
/* 230 */     if ((this.buyTimes == 10) && (yuanBaoIndexId != this.currentIndexId) && (exChangeIndexId != this.currentIndexId))
/*     */     {
/* 232 */       Map<String, Object> extraMap = new HashMap();
/* 233 */       extraMap.put("yuan_bao_index", Integer.valueOf(yuanBaoIndexId));
/* 234 */       extraMap.put("exchange_index_id", Integer.valueOf(exChangeIndexId));
/* 235 */       extraMap.put("db_current_index_id", Integer.valueOf(xCurrentDbIndexId));
/*     */       
/* 237 */       onBuyMiBaoFail(5, extraMap);
/*     */       
/* 239 */       return false;
/*     */     }
/*     */     
/* 242 */     if ((this.buyTimes == 10) && (this.costCurrencyType != 1) && (this.costCurrencyType != 11))
/*     */     {
/*     */ 
/* 245 */       onBuyMiBaoFail(13);
/*     */       
/* 247 */       return false;
/*     */     }
/* 249 */     int needCurrencyNum = sBaoKuLotteryCfg.costCurrencyNum * this.buyTimes;
/* 250 */     int realCostCurrency = this.buyTimes == 10 ? (int)(needCurrencyNum * (1.0D * BaoKuConsts.getInstance().onSaleValue / BaoKuConsts.getInstance().onSaleBase)) : needCurrencyNum;
/*     */     
/*     */ 
/* 253 */     if (realCostCurrency < 0)
/*     */     {
/* 255 */       return false;
/*     */     }
/*     */     
/* 258 */     if ((realCostCurrency > this.clientCurrencyValue) && (this.costCurrencyType != 0))
/*     */     {
/* 260 */       if ((!this.isUseYuanBao) || (this.costCurrencyType != 11))
/*     */       {
/* 262 */         Map<String, Object> extraMap = new HashMap();
/* 263 */         extraMap.put("need_currency_num", Integer.valueOf(needCurrencyNum));
/* 264 */         extraMap.put("real_cost_currency", Integer.valueOf(realCostCurrency));
/* 265 */         extraMap.put("db_current_index_id", Integer.valueOf(xCurrentDbIndexId));
/*     */         
/* 267 */         onBuyMiBaoFail(8);
/*     */         
/* 269 */         return false;
/*     */       }
/*     */       
/* 272 */       int costItemId = BaoKuConsts.getInstance().exchangeCostItemId;
/* 273 */       int itemYuanBaoPrice = ItemInterface.getItemYuanBaoPrice(costItemId);
/*     */       
/* 275 */       if (itemYuanBaoPrice < 0)
/*     */       {
/* 277 */         Map<String, Object> extraMap = new HashMap();
/* 278 */         extraMap.put("itemYuanBaoPrice", Integer.valueOf(itemYuanBaoPrice));
/* 279 */         extraMap.put("costItemId", Integer.valueOf(costItemId));
/*     */         
/* 281 */         onBuyMiBaoFail(15);
/* 282 */         return false;
/*     */       }
/*     */       
/* 285 */       int serverNeedYuanBao = (realCostCurrency - (int)this.clientCurrencyValue) * itemYuanBaoPrice;
/* 286 */       if (serverNeedYuanBao != this.clientNeedYuanBao)
/*     */       {
/* 288 */         Map<String, Object> extraMap = new HashMap();
/* 289 */         extraMap.put("clientNeedYuanBao", Integer.valueOf(this.clientNeedYuanBao));
/* 290 */         extraMap.put("serverNeedYuanBao", Integer.valueOf(serverNeedYuanBao));
/*     */         
/* 292 */         onBuyMiBaoFail(16);
/* 293 */         return false;
/*     */       }
/*     */       
/* 296 */       CostResult costResult = QingfuInterface.costYuanbao(userId, this.roleId, serverNeedYuanBao, CostType.COST_BIND_FIRST_MI_BAO_VALUE, new TLogArg(LogReason.YI_XIAN_MI_BAO_COST_YUAN_BAO, this.buyTimes));
/*     */       
/* 298 */       if (costResult != CostResult.Success)
/*     */       {
/* 300 */         Map<String, Object> extraMap = new HashMap();
/* 301 */         extraMap.put("cost_result_desc", costResult.desc);
/* 302 */         extraMap.put("cost_result_code", Integer.valueOf(costResult.code));
/*     */         
/* 304 */         onBuyMiBaoFail(17);
/* 305 */         return false;
/*     */       }
/*     */       
/* 308 */       realCostCurrency = (int)this.clientCurrencyValue;
/*     */     }
/*     */     
/* 311 */     boolean ret = MiBaoManager.costCurrencyValue(this.roleId, realCostCurrency, this.costCurrencyType, this.buyTimes);
/* 312 */     if (!ret)
/*     */     {
/* 314 */       GameServer.logger().error(String.format("[mibao]PCBuyMiBaoReq.processImp@currency cut failed|role_id=%d|currency_type=%d|client_currency_value=%d|has_buy_times_today=%d|buy_times_req=%d|cost_currency_num_cfg=%d|real_cut_currency_num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.costCurrencyType), Long.valueOf(this.clientCurrencyValue), Integer.valueOf(hasBuyTimesToday), Integer.valueOf(this.buyTimes), Integer.valueOf(sBaoKuLotteryCfg.costCurrencyNum), Integer.valueOf(realCostCurrency) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 319 */       onBuyMiBaoFail(9);
/* 320 */       return false;
/*     */     }
/* 322 */     int oldScore = xRole2MiBaoInfo.getCurrent_score();
/* 323 */     List<MiBaoItemInfo> awardItemList = MiBaoManager.getRandomItemList(userId, this.roleId, xRole2MiBaoInfo, sBaoKuDrawLotteryCfg, this.buyTimes);
/*     */     
/* 325 */     int nextIndexId = 0;
/* 326 */     if ((this.currentIndexId == BaoKuConsts.getInstance().yuanBaoIndex) || (this.currentIndexId == BaoKuConsts.getInstance().exchangeIndex))
/*     */     {
/*     */ 
/* 329 */       nextIndexId = xRole2MiBaoInfo.getCurrent_index_id();
/*     */     }
/*     */     else
/*     */     {
/* 333 */       nextIndexId = this.currentIndexId + 1;
/*     */     }
/*     */     
/* 336 */     xRole2MiBaoInfo.setBuy_times_today(hasBuyTimesToday + this.buyTimes);
/* 337 */     if (nextIndexId != xRole2MiBaoInfo.getCurrent_index_id())
/*     */     {
/* 339 */       xRole2MiBaoInfo.setCurrent_index_id(nextIndexId);
/*     */     }
/*     */     
/* 342 */     SBuyMiBaoSuccess sBuyMiBaoSuccess = new SBuyMiBaoSuccess();
/* 343 */     sBuyMiBaoSuccess.random_item_map.addAll(awardItemList);
/* 344 */     sBuyMiBaoSuccess.current_lucky_value = xRole2MiBaoInfo.getCurrent_lucky_value();
/* 345 */     sBuyMiBaoSuccess.current_score = xRole2MiBaoInfo.getCurrent_score();
/* 346 */     sBuyMiBaoSuccess.current_mibao_index_id = xRole2MiBaoInfo.getCurrent_index_id();
/*     */     
/* 348 */     OnlineManager.getInstance().send(this.roleId, sBuyMiBaoSuccess);
/*     */     
/* 350 */     MiBaoManager.tlogDrawLOttery(this.roleId, this.costCurrencyType, realCostCurrency, this.buyTimes, awardItemList);
/* 351 */     MiBaoManager.tlogScoreChange(userId, this.roleId, xRole2MiBaoInfo.getCurrent_score());
/*     */     
/*     */ 
/* 354 */     ActivityInterface.logActivity(this.roleId, BaoKuConsts.getInstance().miBaoActivityId, ActivityLogStatus.FINISH);
/*     */     
/*     */ 
/* 357 */     ActivityInterface.tlogActivity(this.roleId, BaoKuConsts.getInstance().miBaoActivityId, ActivityLogStatus.FINISH);
/*     */     
/* 359 */     DrawMiBaoLotteryArg drawMiBaoLotteryArg = new DrawMiBaoLotteryArg(this.roleId, this.buyTimes, xRole2MiBaoInfo.getCurrent_score() - oldScore, xRole2MiBaoInfo.getCurrent_score());
/*     */     
/*     */ 
/* 362 */     TriggerEventsManger.getInstance().triggerEvent(new DrawMiBaoLottery(), drawMiBaoLotteryArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/* 365 */     GameServer.logger().info(String.format("[mibao]PCBuyMiBaoReq.processImp@buy mi bao success|role_id=%d|currency_type=%d|client_currency_value=%d|buy_times_req=%d|need_currency_value=%d|random_item_list=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(sBaoKuLotteryCfg.costCurrencyType), Long.valueOf(this.clientCurrencyValue), Integer.valueOf(this.buyTimes), Integer.valueOf(needCurrencyNum), awardItemList.toString() }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 370 */     return true;
/*     */   }
/*     */   
/*     */   private void onBuyMiBaoFail(int ret)
/*     */   {
/* 375 */     onBuyMiBaoFail(ret, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onBuyMiBaoFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 383 */     onBuyMiBaoFail(ret, extraMap, true);
/*     */   }
/*     */   
/*     */   private void onBuyMiBaoFail(int ret, Map<String, ?> extraMap, boolean sendFail)
/*     */   {
/* 388 */     StringBuilder sbLog = new StringBuilder();
/* 389 */     sbLog.append("[mibao]PCBuyMiBaoReq.processImp@buy mi bao failed");
/* 390 */     sbLog.append("|ret=").append(ret);
/* 391 */     sbLog.append("|role_id=").append(this.roleId);
/* 392 */     sbLog.append("|client_currency_value=").append(this.currentIndexId);
/* 393 */     sbLog.append("|buy_times=").append(this.buyTimes);
/* 394 */     sbLog.append("|cost_currency_type=").append(this.costCurrencyType);
/* 395 */     sbLog.append("|cost_currency_value=").append(this.costCurrencyValue);
/* 396 */     sbLog.append("|is_use_yuan_bao=").append(this.isUseYuanBao);
/* 397 */     sbLog.append("|client_yuan_bao=").append(this.clientNeedYuanBao);
/*     */     
/* 399 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 401 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 403 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 406 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 408 */     if (sendFail)
/*     */     {
/* 410 */       SBuyMiBaoFail sBuyMiBaoFail = new SBuyMiBaoFail();
/* 411 */       sBuyMiBaoFail.result = ret;
/* 412 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sBuyMiBaoFail);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mibao\main\PCBuyMiBaoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */