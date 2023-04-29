/*     */ package mzm.gsp.luckystar.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.luckystar.LuckyStarAwardInfo;
/*     */ import mzm.gsp.luckystar.SSyncLuckyStarInfo;
/*     */ import mzm.gsp.luckystar.condition.BalanceCondtion;
/*     */ import mzm.gsp.luckystar.condition.ChildrenEquipLevelCondition;
/*     */ import mzm.gsp.luckystar.condition.EquipQiLinLevelAverageCondition;
/*     */ import mzm.gsp.luckystar.condition.GoldFabaoStarLevelCondition;
/*     */ import mzm.gsp.luckystar.condition.LastMonthSaveAmtCondition;
/*     */ import mzm.gsp.luckystar.condition.LastTwoWeeksSaveAmtCondition;
/*     */ import mzm.gsp.luckystar.condition.LastWeekSaveAmtCondition;
/*     */ import mzm.gsp.luckystar.condition.LuckyStarCondition;
/*     */ import mzm.gsp.luckystar.condition.MountsDouDouRankCondition;
/*     */ import mzm.gsp.luckystar.condition.MountsLeopardRankCondition;
/*     */ import mzm.gsp.luckystar.condition.MountsMengYanRankCondition;
/*     */ import mzm.gsp.luckystar.condition.MountsPandaRankCondition;
/*     */ import mzm.gsp.luckystar.condition.OpenServerTimeCondition;
/*     */ import mzm.gsp.luckystar.condition.OwnEquipSkillCondition;
/*     */ import mzm.gsp.luckystar.condition.RoleCreateTimeCondition;
/*     */ import mzm.gsp.luckystar.condition.RoleFightValueCondition;
/*     */ import mzm.gsp.luckystar.condition.RoleLevelCondition;
/*     */ import mzm.gsp.luckystar.condition.RoleTotalFightValueCondition;
/*     */ import mzm.gsp.luckystar.condition.SaveAmtCondition;
/*     */ import mzm.gsp.luckystar.condition.ShenShouAndMoShouNumCondition;
/*     */ import mzm.gsp.luckystar.condition.ShenShouNumCondition;
/*     */ import mzm.gsp.luckystar.condition.ShenShouSkillNumCondition;
/*     */ import mzm.gsp.luckystar.condition.TopFightPetAmuletLevelCondition;
/*     */ import mzm.gsp.luckystar.condition.WindFabaoStarLevelCondition;
/*     */ import mzm.gsp.luckystar.condition.WingLevelCondition;
/*     */ import mzm.gsp.luckystar.confbean.ConditionMapBean;
/*     */ import mzm.gsp.luckystar.confbean.ConditionValueBean;
/*     */ import mzm.gsp.luckystar.confbean.SLuckyStarConsts;
/*     */ import mzm.gsp.luckystar.confbean.SLuckyStarGiftCfg;
/*     */ import mzm.gsp.luckystar.confbean.SLuckyStarGiftOriginalCfg;
/*     */ import mzm.gsp.luckystar.confbean.SLuckyStarUserGroupCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BuyGiftInfo;
/*     */ import xbean.LuckyStarInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.Role2LuckyStarInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2luckystar;
/*     */ import xtable.User;
/*     */ 
/*     */ public class LuckyStarManager
/*     */ {
/*  64 */   private static Map<Integer, LuckyStarCondition> luckyStarConditionMap = new HashMap();
/*     */   
/*     */   static void init()
/*     */   {
/*  68 */     luckyStarConditionMap.put(Integer.valueOf(1), new mzm.gsp.luckystar.condition.LastLogoffTimeCondition());
/*  69 */     luckyStarConditionMap.put(Integer.valueOf(2), new RoleLevelCondition());
/*  70 */     luckyStarConditionMap.put(Integer.valueOf(3), new SaveAmtCondition());
/*  71 */     luckyStarConditionMap.put(Integer.valueOf(4), new OpenServerTimeCondition());
/*  72 */     luckyStarConditionMap.put(Integer.valueOf(5), new RoleCreateTimeCondition());
/*  73 */     luckyStarConditionMap.put(Integer.valueOf(6), new EquipQiLinLevelAverageCondition());
/*  74 */     luckyStarConditionMap.put(Integer.valueOf(7), new WingLevelCondition());
/*  75 */     luckyStarConditionMap.put(Integer.valueOf(8), new mzm.gsp.luckystar.condition.CommonFabaoStarLevelCondition());
/*  76 */     luckyStarConditionMap.put(Integer.valueOf(9), new GoldFabaoStarLevelCondition());
/*  77 */     luckyStarConditionMap.put(Integer.valueOf(10), new WindFabaoStarLevelCondition());
/*  78 */     luckyStarConditionMap.put(Integer.valueOf(11), new ShenShouNumCondition());
/*  79 */     luckyStarConditionMap.put(Integer.valueOf(12), new mzm.gsp.luckystar.condition.MoShouNumCondition());
/*  80 */     luckyStarConditionMap.put(Integer.valueOf(13), new ShenShouAndMoShouNumCondition());
/*  81 */     luckyStarConditionMap.put(Integer.valueOf(14), new ShenShouSkillNumCondition());
/*  82 */     luckyStarConditionMap.put(Integer.valueOf(15), new TopFightPetAmuletLevelCondition());
/*  83 */     luckyStarConditionMap.put(Integer.valueOf(16), new RoleFightValueCondition());
/*  84 */     luckyStarConditionMap.put(Integer.valueOf(17), new RoleTotalFightValueCondition());
/*  85 */     luckyStarConditionMap.put(Integer.valueOf(18), new MountsPandaRankCondition());
/*  86 */     luckyStarConditionMap.put(Integer.valueOf(19), new MountsDouDouRankCondition());
/*  87 */     luckyStarConditionMap.put(Integer.valueOf(20), new MountsMengYanRankCondition());
/*  88 */     luckyStarConditionMap.put(Integer.valueOf(21), new mzm.gsp.luckystar.condition.MountsFoxRankCondition());
/*  89 */     luckyStarConditionMap.put(Integer.valueOf(22), new MountsLeopardRankCondition());
/*  90 */     luckyStarConditionMap.put(Integer.valueOf(23), new LastWeekSaveAmtCondition());
/*  91 */     luckyStarConditionMap.put(Integer.valueOf(24), new LastTwoWeeksSaveAmtCondition());
/*  92 */     luckyStarConditionMap.put(Integer.valueOf(25), new LastMonthSaveAmtCondition());
/*  93 */     luckyStarConditionMap.put(Integer.valueOf(26), new BalanceCondtion());
/*  94 */     luckyStarConditionMap.put(Integer.valueOf(27), new mzm.gsp.luckystar.condition.PartnerYuanShenCondition());
/*  95 */     luckyStarConditionMap.put(Integer.valueOf(28), new ChildrenEquipLevelCondition());
/*  96 */     luckyStarConditionMap.put(Integer.valueOf(29), new OwnEquipSkillCondition());
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
/*     */   static LuckyStarCondition getLuckyStarCondition(int luckyStarConditionEnum)
/*     */   {
/* 109 */     return (LuckyStarCondition)luckyStarConditionMap.get(Integer.valueOf(luckyStarConditionEnum));
/*     */   }
/*     */   
/*     */   static void sSyncLuckyStarInfo(long roleId, LuckyStarInfo xLuckyStarInfo)
/*     */   {
/* 114 */     SSyncLuckyStarInfo sSyncLuckyStarInfo = new SSyncLuckyStarInfo();
/* 115 */     sSyncLuckyStarInfo.activity_cfg_id = SLuckyStarConsts.getInstance().LUCKY_STAR_ACTIVITY_CFG_ID;
/* 116 */     for (BuyGiftInfo xBuyGiftInfo : xLuckyStarInfo.getBuy_gift_info_list())
/*     */     {
/* 118 */       LuckyStarAwardInfo luckStarAwardInfo = new LuckyStarAwardInfo();
/* 119 */       luckStarAwardInfo.lucky_star_gift_cfg_id = xBuyGiftInfo.getGift_cfg_id();
/* 120 */       luckStarAwardInfo.has_buy_times = xBuyGiftInfo.getAleardy_buy_times();
/* 121 */       sSyncLuckyStarInfo.award_info.add(luckStarAwardInfo);
/*     */     }
/*     */     
/* 124 */     OnlineManager.getInstance().send(roleId, sSyncLuckyStarInfo);
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
/*     */   static long getLeftCurrencyValue(long roleId, int currencyType)
/*     */   {
/* 139 */     switch (currencyType)
/*     */     {
/*     */     case 1: 
/* 142 */       String userid = RoleInterface.getUserId(roleId);
/* 143 */       return QingfuInterface.getBalance(userid, true);
/*     */     
/*     */     case 2: 
/* 146 */       return RoleInterface.getGold(roleId);
/*     */     
/*     */     case 3: 
/* 149 */       return RoleInterface.getSilver(roleId);
/*     */     
/*     */     case 4: 
/* 152 */       return GangInterface.getBangGong(roleId);
/*     */     
/*     */     case 5: 
/* 155 */       return RoleInterface.getGoldIngot(roleId);
/*     */     }
/*     */     
/* 158 */     GameServer.logger().error(String.format("[luckystar]LuckyStarManager.getLeftCurrencyValue@not support the currency type|role_id=%d|currency_type=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(currencyType) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 164 */     return 0L;
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
/*     */   static boolean costCurrencyValue(long roleId, long costValue, int currencyType)
/*     */   {
/* 181 */     if (costValue == 0L)
/*     */     {
/* 183 */       return true;
/*     */     }
/* 185 */     String userId = RoleInterface.getUserId(roleId);
/* 186 */     Lockeys.lock(Lockeys.get(User.getTable(), userId));
/* 187 */     switch (currencyType)
/*     */     {
/*     */     case 1: 
/* 190 */       CostResult costResult = QingfuInterface.costYuanbao(userId, roleId, (int)costValue, mzm.gsp.qingfu.main.CostType.COST_BIND_FIRST_MI_BAO_VALUE, new TLogArg(LogReason.LUCKY_STAR_COST_YUAN_BAO));
/*     */       
/*     */ 
/* 193 */       return costResult == CostResult.Success;
/*     */     
/*     */     case 2: 
/* 196 */       return RoleInterface.cutGold(roleId, costValue, new TLogArg(LogReason.LUCKY_STAR_COST_GOLD));
/*     */     
/*     */     case 3: 
/* 199 */       return RoleInterface.cutSilver(roleId, costValue, new TLogArg(LogReason.LUCKY_STAR_COST_SILVER));
/*     */     
/*     */     case 5: 
/* 202 */       return RoleInterface.cutGoldIngot(roleId, costValue, new TLogArg(LogReason.LUCKY_STAR_COST_JIN_DING));
/*     */     
/*     */     case 4: 
/* 205 */       return GangInterface.cutBangGong(roleId, (int)costValue, new TLogArg(LogReason.LUCKY_STAR_COST_BANG_GONG));
/*     */     }
/*     */     
/* 208 */     GameServer.logger().error(String.format("[luckystar]LuckyStarManager.costCurrencyValue@not support the currency type|role_id=%d|currency_type=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(currencyType) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 214 */     return false;
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
/*     */ 
/*     */   static void checkAndInitLuckyStarActivity(String userId, long roleId, int luckyStarActivityCfgId, String logStr)
/*     */   {
/* 234 */     SLuckyStarUserGroupCfg sLuckyStarUserGroupCfg = SLuckyStarUserGroupCfg.get(luckyStarActivityCfgId);
/* 235 */     if (sLuckyStarUserGroupCfg == null)
/*     */     {
/* 237 */       GameServer.logger().error(String.format("[luckystar]%s@activity cfg id lucky star not exist|activity_cfg_id=%d", new Object[] { logStr, Integer.valueOf(luckyStarActivityCfgId) }));
/*     */       
/*     */ 
/* 240 */       return;
/*     */     }
/*     */     
/*     */ 
/* 244 */     List<Integer> recommandGiftCfgIdList = new ArrayList();
/* 245 */     Map<Integer, ConditionMapBean> luckyStarUserGroupMap = sLuckyStarUserGroupCfg.luckyStarUserGroupMap;
/* 246 */     for (Map.Entry<Integer, ConditionMapBean> entry : luckyStarUserGroupMap.entrySet())
/*     */     {
/* 248 */       int recommandUserGroupId = ((Integer)entry.getKey()).intValue();
/* 249 */       SLuckyStarGiftCfg sLuckyStarGiftCfg = SLuckyStarGiftCfg.get(recommandUserGroupId);
/* 250 */       if (sLuckyStarGiftCfg != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 255 */         boolean checkUserGroupCondition = checkUserGroupCondition(roleId, (ConditionMapBean)entry.getValue());
/* 256 */         if (checkUserGroupCondition)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 261 */           for (Iterator i$ = sLuckyStarGiftCfg.gift_list.iterator(); i$.hasNext();) { int luckyStarGiftId = ((Integer)i$.next()).intValue();
/*     */             
/* 263 */             recommandGiftCfgIdList.add(Integer.valueOf(luckyStarGiftId));
/* 264 */             if (recommandGiftCfgIdList.size() >= SLuckyStarConsts.getInstance().GIFT_MAX_NUM) {
/*     */               break;
/*     */             }
/*     */           }
/*     */           
/*     */ 
/* 270 */           if (recommandGiftCfgIdList.size() >= SLuckyStarConsts.getInstance().GIFT_MAX_NUM) {
/*     */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 276 */     if (recommandGiftCfgIdList.isEmpty())
/*     */     {
/* 278 */       return;
/*     */     }
/*     */     
/* 281 */     LuckyStarInfo xLuckyStarInfo = Pod.newLuckyStarInfo();
/* 282 */     List<BuyGiftInfo> xBuyGiftInfoList = xLuckyStarInfo.getBuy_gift_info_list();
/* 283 */     for (Iterator i$ = recommandGiftCfgIdList.iterator(); i$.hasNext();) { int giftCfgId = ((Integer)i$.next()).intValue();
/*     */       
/* 285 */       SLuckyStarGiftOriginalCfg sLuckyStarGiftOriginalCfg = SLuckyStarGiftOriginalCfg.get(giftCfgId);
/* 286 */       if (sLuckyStarGiftOriginalCfg != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 291 */         BuyGiftInfo xBuyGiftInfo = Pod.newBuyGiftInfo();
/* 292 */         xBuyGiftInfo.setGift_cfg_id(giftCfgId);
/* 293 */         xBuyGiftInfoList.add(xBuyGiftInfo);
/*     */       }
/*     */     }
/* 296 */     Role2LuckyStarInfo xRole2LuckyStarInfo = Role2luckystar.get(Long.valueOf(roleId));
/* 297 */     if (xRole2LuckyStarInfo == null)
/*     */     {
/* 299 */       xRole2LuckyStarInfo = Pod.newRole2LuckyStarInfo();
/* 300 */       Role2luckystar.add(Long.valueOf(roleId), xRole2LuckyStarInfo);
/*     */     }
/*     */     
/* 303 */     xRole2LuckyStarInfo.getLucky_star_info_map().put(Integer.valueOf(luckyStarActivityCfgId), xLuckyStarInfo);
/*     */     
/* 305 */     tlogLuckyStarTriggerStatis(userId, roleId, recommandGiftCfgIdList);
/*     */     
/* 307 */     sSyncLuckyStarInfo(roleId, xLuckyStarInfo);
/*     */     
/* 309 */     GameServer.logger().info(String.format("[luckystar]%s@active lucky star activity|gift_id_list=%s", new Object[] { logStr, recommandGiftCfgIdList.toString() }));
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
/*     */   private static boolean checkUserGroupCondition(long roleId, ConditionMapBean conditionMapBean)
/*     */   {
/* 326 */     Map<Integer, ConditionValueBean> conditionValueMap = conditionMapBean.conditionValueMap;
/* 327 */     for (Map.Entry<Integer, ConditionValueBean> entry : conditionValueMap.entrySet())
/*     */     {
/* 329 */       LuckyStarCondition luckyStarCondition = getLuckyStarCondition(((Integer)entry.getKey()).intValue());
/* 330 */       if (luckyStarCondition == null)
/*     */       {
/* 332 */         GameServer.logger().error(String.format("[luckystar]POnRoleLogin.checkUserGroupCondition@not found condtion check object|enum=%d", new Object[] { entry.getKey() }));
/*     */         
/*     */ 
/*     */ 
/* 336 */         return false;
/*     */       }
/*     */       
/* 339 */       if (!luckyStarCondition.checkCondition(roleId, (ConditionValueBean)entry.getValue()))
/*     */       {
/* 341 */         return false;
/*     */       }
/*     */     }
/* 344 */     return true;
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
/*     */   public static void tlogLuckyStarTriggerStatis(String userId, long roleId, List<Integer> giftCfgIdList)
/*     */   {
/* 359 */     int roleLevel = RoleInterface.getLevel(roleId);
/* 360 */     int totalSize = giftCfgIdList.size();
/*     */     
/* 362 */     List<Integer> giftCfgIdListCopy = new ArrayList(giftCfgIdList);
/*     */     
/* 364 */     while (totalSize > 0)
/*     */     {
/* 366 */       int size = 0;
/* 367 */       if (totalSize > 6)
/*     */       {
/* 369 */         totalSize -= 6;
/* 370 */         size = 6;
/*     */       }
/*     */       else
/*     */       {
/* 374 */         size = totalSize;
/* 375 */         totalSize = -1;
/*     */       }
/*     */       
/* 378 */       StringBuilder sbLog = new StringBuilder();
/* 379 */       sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 380 */       sbLog.append(userId).append('|');
/* 381 */       sbLog.append(roleId).append('|');
/* 382 */       sbLog.append(roleLevel);
/*     */       
/* 384 */       for (int tempSize = 0; tempSize < size; tempSize++)
/*     */       {
/* 386 */         if (!giftCfgIdListCopy.isEmpty())
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 391 */           sbLog.append('|').append(giftCfgIdListCopy.remove(0));
/*     */         }
/*     */       }
/* 394 */       for (int index = 0; index < 6 - size; index++)
/*     */       {
/* 396 */         sbLog.append("|0");
/*     */       }
/*     */       
/* 399 */       TLogManager.getInstance().addLog(roleId, "LuckyStarTriggerStatis", sbLog.toString());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void tlogLuckyStarBuyStatis(String userId, long roleId, int giftCfgId, int costCurrencyType, int costCurrencyValue, int costBindYuanBao, int costUnBindYuanBao, int buyTimesReq)
/*     */   {
/* 425 */     int roleLevel = RoleInterface.getLevel(roleId);
/*     */     
/* 427 */     StringBuilder sbLog = new StringBuilder();
/* 428 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 429 */     sbLog.append(userId).append('|');
/* 430 */     sbLog.append(roleId).append('|');
/* 431 */     sbLog.append(roleLevel).append('|');
/*     */     
/* 433 */     sbLog.append(giftCfgId).append('|');
/* 434 */     sbLog.append(costCurrencyType).append('|');
/* 435 */     sbLog.append(costBindYuanBao).append('|');
/* 436 */     sbLog.append(costUnBindYuanBao).append('|');
/* 437 */     sbLog.append(costCurrencyValue).append('|');
/* 438 */     sbLog.append(buyTimesReq);
/*     */     
/* 440 */     TLogManager.getInstance().addLog(roleId, "LuckyStarBuyStatis", sbLog.toString());
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
/*     */   static boolean isLuckyStarSwitchOpen(long roleId, boolean isSendTips)
/*     */   {
/* 457 */     if (!OpenInterface.getOpenStatus(197))
/*     */     {
/* 459 */       return false;
/*     */     }
/*     */     
/* 462 */     if (OpenInterface.isBanPlay(roleId, 197))
/*     */     {
/* 464 */       if (isSendTips)
/*     */       {
/* 466 */         OpenInterface.sendBanPlayMsg(roleId, 197);
/*     */       }
/*     */       
/* 469 */       return false;
/*     */     }
/*     */     
/* 472 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\main\LuckyStarManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */