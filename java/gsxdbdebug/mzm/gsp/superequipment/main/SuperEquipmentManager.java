/*     */ package mzm.gsp.superequipment.main;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.gm.SGMMessageTipRes;
/*     */ import mzm.gsp.item.ItemInfo;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.EquipmentItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.RoleEquipBag;
/*     */ import mzm.gsp.mall.main.JifenOperateResult;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.mibao.confbean.BaoKuConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.superequipment.SImproveSuperEquipmentLevelFail;
/*     */ import mzm.gsp.superequipment.SImproveSuperEquipmentLevelSuccess;
/*     */ import mzm.gsp.superequipment.SImproveSuperEquipmentStageFail;
/*     */ import mzm.gsp.superequipment.SImproveSuperEquipmentStageSuccess;
/*     */ import mzm.gsp.superequipment.STransferSuperEquipmentFail;
/*     */ import mzm.gsp.superequipment.confbean.SSuperEquipmentConsts;
/*     */ import mzm.gsp.superequipment.confbean.SSuperEquipmentLevelCfg;
/*     */ import mzm.gsp.superequipment.confbean.SSuperEquipmentStageCfg;
/*     */ import mzm.gsp.superequipment.confbean.SuperEquipmentLevelBean;
/*     */ import mzm.gsp.superequipment.confbean.SuperEquipmentLevelRequiredItem;
/*     */ import mzm.gsp.superequipment.confbean.SuperEquipmentPropertyImproveBean;
/*     */ import mzm.gsp.superequipment.confbean.SuperEquipmentStageRequiredItem;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ class SuperEquipmentManager
/*     */ {
/*     */   static boolean checkBasicConditions(long roleId)
/*     */   {
/*  54 */     return (!GameServerInfoManager.isRoamServer()) && (OpenInterface.getOpenStatus(382)) && (!OpenInterface.isBanPlay(roleId, 382)) && (RoleStatusInterface.checkCanSetStatus(roleId, 147, true)) && (RoleInterface.getLevel(roleId) >= SSuperEquipmentConsts.getInstance().OPEN_ROLE_LEVEL) && (ServerInterface.getCurrentServerLevel() >= SSuperEquipmentConsts.getInstance().OPEN_SERVER_LEVEL);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  63 */   private static final Logger logger = Logger.getLogger("SuperEquipment");
/*     */   private static final String TLOG_STAGE_IMPROVED = "SuperEquipmentImproveStage";
/*     */   
/*     */   static void info(String str, Object... args) {
/*  67 */     logger.info(String.format("[SuperEquipment]" + str, args));
/*     */   }
/*     */   
/*     */   static void error(String str, Object... args)
/*     */   {
/*  72 */     logger.error(String.format("[SuperEquipment]" + str, args));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void tlog(long roleId, String logName, Object... args)
/*     */   {
/*  80 */     String userId = RoleInterface.getUserId(roleId);
/*  81 */     if (userId == null)
/*  82 */       return;
/*  83 */     List<Object> list = new ArrayList();
/*  84 */     list.addAll(Arrays.asList(new Serializable[] { GameServerInfoManager.getHostIP(), userId, Long.valueOf(roleId), Integer.valueOf(RoleInterface.getLevel(roleId)) }));
/*  85 */     Collections.addAll(list, args);
/*  86 */     TLogManager.getInstance().addLog(userId, logName, list.toArray());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static void tlogImproveStage(long roleId, long uuid, int stage, List<Integer> idAndCostNums)
/*     */   {
/*  93 */     List<Object> args = new ArrayList();
/*  94 */     args.addAll(Arrays.asList(new Number[] { Long.valueOf(uuid), Integer.valueOf(stage) }));
/*  95 */     args.addAll(idAndCostNums);
/*  96 */     tlog(roleId, "SuperEquipmentImproveStage", args.toArray());
/*     */   }
/*     */   
/*     */   static void tlogImproveStage(long roleId, EquipmentItem item)
/*     */   {
/* 101 */     ArrayList<Integer> idAndCostNums = new ArrayList();
/* 102 */     SSuperEquipmentStageCfg nextStageCfg = getNextStageCfg(item);
/* 103 */     Map<Integer, Integer> costMap; if (nextStageCfg != null)
/*     */     {
/*     */ 
/* 106 */       costMap = item.getSuperEquipmentImproveStageCostMap();
/* 107 */       for (SuperEquipmentStageRequiredItem requiredItem : nextStageCfg.requiredItems)
/*     */       {
/* 109 */         Integer costNum = (Integer)costMap.get(Integer.valueOf(requiredItem.id));
/* 110 */         idAndCostNums.add(Integer.valueOf(requiredItem.id));
/* 111 */         idAndCostNums.add(Integer.valueOf(costNum == null ? 0 : costNum.intValue()));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 117 */     while (idAndCostNums.size() < 8) {
/* 118 */       idAndCostNums.add(Integer.valueOf(0));
/*     */     }
/* 120 */     tlogImproveStage(roleId, item.getFirstUuid().longValue(), item.getSuperEquipmentStage(), idAndCostNums);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static void tlogImproveLevel(long roleId, long uuid, int level, List<Integer> idAndCostNums)
/*     */   {
/* 127 */     List<Object> args = new ArrayList();
/* 128 */     args.addAll(Arrays.asList(new Number[] { Long.valueOf(uuid), Integer.valueOf(level) }));
/* 129 */     args.addAll(idAndCostNums);
/* 130 */     tlog(roleId, "SuperEquipmentImproveLevel", args.toArray());
/*     */   }
/*     */   
/*     */   static void tlogImproveLevel(long roleId, EquipmentItem item)
/*     */   {
/* 135 */     ArrayList<Integer> idAndCostNums = new ArrayList();
/* 136 */     SuperEquipmentLevelBean nextLevelBean = getNextLevelBean(item);
/* 137 */     Map<Integer, Integer> costMap; if (nextLevelBean != null)
/*     */     {
/*     */ 
/* 140 */       costMap = item.getSuperEquipmentImproveLevelCostMap();
/* 141 */       for (SuperEquipmentLevelRequiredItem requiredItem : nextLevelBean.requiredItems)
/*     */       {
/* 143 */         Integer costNum = (Integer)costMap.get(Integer.valueOf(requiredItem.id));
/* 144 */         idAndCostNums.add(Integer.valueOf(requiredItem.id));
/* 145 */         idAndCostNums.add(Integer.valueOf(costNum == null ? 0 : costNum.intValue()));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 151 */     while (idAndCostNums.size() < 8) {
/* 152 */       idAndCostNums.add(Integer.valueOf(0));
/*     */     }
/* 154 */     tlogImproveLevel(roleId, item.getFirstUuid().longValue(), item.getSuperEquipmentLevel(), idAndCostNums);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void tlogExchangeData(long roleId, long srcUUID, long dstUUID)
/*     */   {
/* 161 */     tlog(roleId, "SuperEquipmentExchangeData", new Object[] { Long.valueOf(srcUUID), Long.valueOf(dstUUID), Integer.valueOf(0) });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void sendImproveStageSuccess(long roleId, boolean improved, EquipmentItem item)
/*     */   {
/* 168 */     SImproveSuperEquipmentStageSuccess p = new SImproveSuperEquipmentStageSuccess();
/* 169 */     p.improved = (improved ? 1 : 0);
/* 170 */     p.item_info = new ItemInfo();
/* 171 */     ItemInterface.fillInItemInfoBean(p.item_info, item.getItem());
/* 172 */     OnlineManager.getInstance().send(roleId, p);
/*     */   }
/*     */   
/*     */   static void sendImproveStageFailAtOnce(long roleId, int retcode)
/*     */   {
/* 177 */     SImproveSuperEquipmentStageFail p = new SImproveSuperEquipmentStageFail();
/* 178 */     p.retcode = retcode;
/* 179 */     OnlineManager.getInstance().sendAtOnce(roleId, p);
/*     */   }
/*     */   
/*     */   static void sendImproveLevelSuccess(long roleId, boolean improved, EquipmentItem item)
/*     */   {
/* 184 */     SImproveSuperEquipmentLevelSuccess p = new SImproveSuperEquipmentLevelSuccess();
/* 185 */     p.improved = (improved ? 1 : 0);
/* 186 */     p.item_info = new ItemInfo();
/* 187 */     ItemInterface.fillInItemInfoBean(p.item_info, item.getItem());
/* 188 */     OnlineManager.getInstance().send(roleId, p);
/*     */   }
/*     */   
/*     */   static void sendImproveLevelFailAtOnce(long roleId, int retcode)
/*     */   {
/* 193 */     SImproveSuperEquipmentLevelFail p = new SImproveSuperEquipmentLevelFail();
/* 194 */     p.retcode = retcode;
/* 195 */     OnlineManager.getInstance().sendAtOnce(roleId, p);
/*     */   }
/*     */   
/*     */   static void sendTransferFailAtOnce(long roleId, int retcode)
/*     */   {
/* 200 */     STransferSuperEquipmentFail p = new STransferSuperEquipmentFail();
/* 201 */     p.retcode = retcode;
/* 202 */     OnlineManager.getInstance().sendAtOnce(roleId, p);
/*     */   }
/*     */   
/*     */   static void sendCommonTip(long roleId, String str)
/*     */   {
/* 207 */     SGMMessageTipRes p = new SGMMessageTipRes();
/* 208 */     p.result = Integer.MAX_VALUE;
/* 209 */     p.args.add(str);
/* 210 */     OnlineManager.getInstance().send(roleId, p);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void triggerStageImproved(long roleId, EquipmentItem item, boolean isEquipped)
/*     */   {
/* 217 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.superequipment.event.SuperEquipmentStageImproved(), new mzm.gsp.superequipment.event.SuperEquipmentStageImprovedArg(roleId, item.getFirstUuid().longValue(), item.getSuperEquipmentStage(), isEquipped), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void triggerLevelImproved(long roleId, EquipmentItem item, boolean isEquipped)
/*     */   {
/* 225 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.superequipment.event.SuperEquipmentLevelImproved(), new mzm.gsp.superequipment.event.SuperEquipmentLevelImprovedArg(roleId, item.getFirstUuid().longValue(), item.getSuperEquipmentLevel(), isEquipped), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void triggerDataExchanged(long roleId, long srcUUID, long dstUUID)
/*     */   {
/* 233 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.superequipment.event.SuperEquipmentDataExchanged(), new mzm.gsp.superequipment.event.SuperEquipmentDataExchangedArg(roleId, srcUUID, dstUUID), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static final String TLOG_LEVEL_IMPROVED = "SuperEquipmentImproveLevel";
/*     */   
/*     */ 
/*     */   private static final String TLOG_EXCHANGED = "SuperEquipmentExchangeData";
/*     */   
/*     */   static boolean isSuperEquipment(EquipmentItem item)
/*     */   {
/* 245 */     return item.getSuperEquipmentStage() > 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isPotentialSuperEquipment(EquipmentItem item)
/*     */   {
/* 253 */     if (isSuperEquipment(item)) {
/* 254 */       return false;
/*     */     }
/* 256 */     int wearPos = ItemInterface.getEquipWearpos(item.getCfgId());
/* 257 */     if ((wearPos == -1) || (wearPos == 10000000) || (wearPos == 6) || (wearPos == 8)) {
/* 258 */       return false;
/*     */     }
/* 260 */     return canImproveStage(0L, item);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean meetLowestConditionsForSuperEquipment(EquipmentItem item)
/*     */   {
/* 268 */     int wearPos = ItemInterface.getEquipWearpos(item.getCfgId());
/* 269 */     if ((wearPos == -1) || (wearPos == 10000000) || (wearPos == 6) || (wearPos == 8)) {
/* 270 */       return false;
/*     */     }
/* 272 */     SSuperEquipmentStageCfg stage1Cfg = SSuperEquipmentStageCfg.get(1);
/* 273 */     if (stage1Cfg == null) {
/* 274 */       return false;
/*     */     }
/* 276 */     SItemCfg itemCfg = SItemCfg.get(item.getCfgId());
/* 277 */     if (itemCfg == null) {
/* 278 */       return false;
/*     */     }
/* 280 */     return (itemCfg.useLevel >= stage1Cfg.requiredEquipmentLevel) && (itemCfg.namecolor >= stage1Cfg.requiredEquipmentQuality);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static SSuperEquipmentStageCfg getStageCfg(EquipmentItem item)
/*     */   {
/* 288 */     return SSuperEquipmentStageCfg.get(item.getSuperEquipmentStage());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static SSuperEquipmentStageCfg getNextStageCfg(EquipmentItem item)
/*     */   {
/* 296 */     return SSuperEquipmentStageCfg.get(item.getSuperEquipmentStage() + 1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean canImproveStage(long roleId, EquipmentItem item)
/*     */   {
/* 306 */     if (item.getSuperEquipmentStage() >= SSuperEquipmentConsts.getInstance().MAX_SUPER_EQUIPMENT_STAGE)
/* 307 */       return false;
/* 308 */     return canReachStage(roleId, item, item.getSuperEquipmentStage() + 1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean canReachStage(long roleId, EquipmentItem item, int stage)
/*     */   {
/* 318 */     SSuperEquipmentStageCfg stageCfg = SSuperEquipmentStageCfg.get(stage);
/* 319 */     if (stageCfg == null) {
/* 320 */       return false;
/*     */     }
/* 322 */     if (roleId > 0L)
/*     */     {
/* 324 */       if (RoleInterface.getLevel(roleId) < stageCfg.requiredRoleLevel) {
/* 325 */         return false;
/*     */       }
/* 327 */       if (ServerInterface.getCurrentServerLevel() < stageCfg.requiredServerLevel) {
/* 328 */         return false;
/*     */       }
/*     */     }
/* 331 */     if (item.getSuperEquipmentLevel() < stageCfg.requiredLevel) {
/* 332 */       return false;
/*     */     }
/* 334 */     SItemCfg itemCfg = SItemCfg.get(item.getCfgId());
/* 335 */     if (itemCfg == null)
/* 336 */       return false;
/* 337 */     if (itemCfg.namecolor < stageCfg.requiredEquipmentQuality)
/* 338 */       return false;
/* 339 */     if (itemCfg.useLevel < stageCfg.requiredEquipmentLevel) {
/* 340 */       return false;
/*     */     }
/* 342 */     if (item.getStrengthLevel() < stageCfg.requiredStrengthLevel) {
/* 343 */       return false;
/*     */     }
/* 345 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static SuperEquipmentLevelBean getLevelBean(EquipmentItem item)
/*     */   {
/* 353 */     int wearPos = ItemInterface.getEquipWearpos(item.getCfgId());
/* 354 */     SSuperEquipmentLevelCfg levelCfg = SSuperEquipmentLevelCfg.get(wearPos);
/* 355 */     if (levelCfg == null)
/* 356 */       return null;
/* 357 */     return (SuperEquipmentLevelBean)levelCfg.level2cfg.get(Integer.valueOf(item.getSuperEquipmentLevel()));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static SuperEquipmentLevelBean getNextLevelBean(EquipmentItem item)
/*     */   {
/* 365 */     int wearPos = ItemInterface.getEquipWearpos(item.getCfgId());
/* 366 */     SSuperEquipmentLevelCfg levelCfg = SSuperEquipmentLevelCfg.get(wearPos);
/* 367 */     if (levelCfg == null)
/* 368 */       return null;
/* 369 */     return (SuperEquipmentLevelBean)levelCfg.level2cfg.get(Integer.valueOf(item.getSuperEquipmentLevel() + 1));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean canImproveLevel(EquipmentItem item)
/*     */   {
/* 377 */     return canReachLevel(item, item.getSuperEquipmentLevel() + 1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean canReachLevel(EquipmentItem item, int level)
/*     */   {
/* 386 */     int wearPos = ItemInterface.getEquipWearpos(item.getCfgId());
/* 387 */     if ((wearPos == -1) || (wearPos == 10000000) || (wearPos == 6) || (wearPos == 8)) {
/* 388 */       return false;
/*     */     }
/* 390 */     if (level == 0) {
/* 391 */       return true;
/*     */     }
/* 393 */     SSuperEquipmentLevelCfg levelCfg = SSuperEquipmentLevelCfg.get(wearPos);
/* 394 */     if (levelCfg == null) {
/* 395 */       return false;
/*     */     }
/* 397 */     SuperEquipmentLevelBean levelBean = (SuperEquipmentLevelBean)levelCfg.level2cfg.get(Integer.valueOf(level));
/* 398 */     if (levelBean == null) {
/* 399 */       return false;
/*     */     }
/* 401 */     if (item.getSuperEquipmentStage() < levelBean.requiredStage) {
/* 402 */       return false;
/*     */     }
/* 404 */     if (item.getStrengthLevel() < levelBean.requiredStrengthLevel) {
/* 405 */       return false;
/*     */     }
/* 407 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Integer, Integer> getProperties(EquipmentItem item)
/*     */   {
/* 417 */     HashMap<Integer, Integer> properties = new HashMap();
/* 418 */     SItemEquipCfg equipCfg = SItemEquipCfg.get(item.getCfgId());
/* 419 */     if (equipCfg == null)
/* 420 */       return properties;
/* 421 */     SuperEquipmentLevelBean levelBean = getLevelBean(item);
/* 422 */     if (levelBean == null)
/* 423 */       return properties;
/* 424 */     for (SuperEquipmentPropertyImproveBean improveBean : levelBean.improveBeans)
/*     */     {
/* 426 */       if ((improveBean.type == equipCfg.attrA) || (improveBean.type == equipCfg.attrB))
/*     */       {
/* 428 */         Integer value = (Integer)properties.get(Integer.valueOf(improveBean.type));
/* 429 */         if (value == null)
/*     */         {
/* 431 */           properties.put(Integer.valueOf(improveBean.type), Integer.valueOf(improveBean.value));
/*     */         }
/*     */         else
/*     */         {
/* 435 */           properties.put(Integer.valueOf(improveBean.type), Integer.valueOf(improveBean.value + value.intValue()));
/*     */         }
/*     */       }
/*     */     }
/* 439 */     return properties;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Integer, Integer> getProperties(RoleEquipBag equipBag)
/*     */   {
/* 447 */     HashMap<Integer, Integer> properties = new HashMap();
/* 448 */     if (!OpenInterface.getOpenStatus(382)) {
/* 449 */       return properties;
/*     */     }
/* 451 */     for (BasicItem basicItem : equipBag.getAllItems(false).values())
/*     */     {
/* 453 */       if ((basicItem instanceof EquipmentItem))
/*     */       {
/* 455 */         EquipmentItem item = (EquipmentItem)basicItem;
/* 456 */         Map<Integer, Integer> itemProperties = getProperties(item);
/* 457 */         for (Map.Entry<Integer, Integer> e : itemProperties.entrySet())
/*     */         {
/* 459 */           Integer value = (Integer)properties.get(e.getKey());
/* 460 */           if (value == null)
/*     */           {
/* 462 */             properties.put(e.getKey(), e.getValue());
/*     */           }
/*     */           else
/*     */           {
/* 466 */             properties.put(e.getKey(), Integer.valueOf(((Integer)e.getValue()).intValue() + value.intValue()));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 471 */     return properties;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getRoleCurrencyForImproving(long roleId, int type)
/*     */   {
/* 479 */     switch (type)
/*     */     {
/*     */     case 1: 
/* 482 */       String userId = RoleInterface.getUserId(roleId);
/* 483 */       if (userId == null)
/* 484 */         return 0;
/* 485 */       return (int)QingfuInterface.getBalance(userId, false);
/*     */     
/*     */     case 2: 
/* 488 */       return (int)RoleInterface.getGold(roleId);
/*     */     
/*     */     case 3: 
/* 491 */       return (int)RoleInterface.getSilver(roleId);
/*     */     
/*     */     case 4: 
/* 494 */       return (int)GangInterface.getBangGong(roleId);
/*     */     
/*     */     case 5: 
/* 497 */       return (int)MallInterface.getJifen(roleId, 3);
/*     */     
/*     */     case 6: 
/* 500 */       return (int)MallInterface.getJifen(roleId, 2);
/*     */     
/*     */     case 7: 
/* 503 */       return (int)MallInterface.getJifen(roleId, 1);
/*     */     
/*     */     case 8: 
/* 506 */       return (int)MallInterface.getJifen(roleId, 4);
/*     */     
/*     */     case 9: 
/* 509 */       return RoleInterface.getVigor(roleId);
/*     */     
/*     */     case 10: 
/* 512 */       return (int)RoleInterface.getGoldIngot(roleId);
/*     */     
/*     */     case 11: 
/* 515 */       BasicItem basicItem = ItemInterface.getItemByCfgId(roleId, BaoKuConsts.getInstance().exchangeCostItemId);
/* 516 */       if (basicItem == null)
/* 517 */         return 0;
/* 518 */       return basicItem.getNumber();
/*     */     }
/*     */     
/* 521 */     error("SuperEquipmentManager.getRoleCurrencyForImproving()@invalid currency type|currency_type=%d", new Object[] { Integer.valueOf(type) });
/* 522 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean chargeCurrencyForImproving(long roleId, int roleCurrency, CostType costType, TLogArg tLogArg, int type, int num)
/*     */   {
/* 534 */     if (roleCurrency < num) {
/* 535 */       return false;
/*     */     }
/* 537 */     switch (type)
/*     */     {
/*     */     case 1: 
/* 540 */       String userId = RoleInterface.getUserId(roleId);
/* 541 */       if (userId == null)
/* 542 */         return false;
/* 543 */       if (QingfuInterface.getBalance(userId, true) != roleCurrency)
/* 544 */         return false;
/* 545 */       return QingfuInterface.costYuanbao(userId, roleId, num, costType, tLogArg) == CostResult.Success;
/*     */     
/*     */     case 2: 
/* 548 */       if (RoleInterface.getGold(roleId) != roleCurrency)
/* 549 */         return false;
/* 550 */       return RoleInterface.cutGold(roleId, num, tLogArg);
/*     */     
/*     */     case 3: 
/* 553 */       if (RoleInterface.getSilver(roleId) != roleCurrency)
/* 554 */         return false;
/* 555 */       return RoleInterface.cutSilver(roleId, num, tLogArg);
/*     */     
/*     */     case 4: 
/* 558 */       if (GangInterface.getBangGong(roleId) != roleCurrency)
/* 559 */         return false;
/* 560 */       return GangInterface.cutBangGong(roleId, num, tLogArg);
/*     */     
/*     */     case 5: 
/* 563 */       if (MallInterface.getJifen(roleId, 3) != roleCurrency)
/* 564 */         return false;
/* 565 */       return MallInterface.cutJifen(roleId, num, 3, tLogArg).isSuccess();
/*     */     
/*     */     case 6: 
/* 568 */       if (MallInterface.getJifen(roleId, 2) != roleCurrency)
/* 569 */         return false;
/* 570 */       return MallInterface.cutJifen(roleId, num, 2, tLogArg).isSuccess();
/*     */     
/*     */     case 7: 
/* 573 */       if (MallInterface.getJifen(roleId, 1) != roleCurrency)
/* 574 */         return false;
/* 575 */       return MallInterface.cutJifen(roleId, num, 1, tLogArg).isSuccess();
/*     */     
/*     */     case 8: 
/* 578 */       if (MallInterface.getJifen(roleId, 4) != roleCurrency)
/* 579 */         return false;
/* 580 */       return MallInterface.cutJifen(roleId, num, 4, tLogArg).isSuccess();
/*     */     
/*     */     case 9: 
/* 583 */       if (RoleInterface.getVigor(roleId) != roleCurrency)
/* 584 */         return false;
/* 585 */       return RoleInterface.cutVigor(roleId, num, tLogArg);
/*     */     
/*     */     case 10: 
/* 588 */       if (RoleInterface.getGoldIngot(roleId) != roleCurrency)
/* 589 */         return false;
/* 590 */       return RoleInterface.cutGoldIngot(roleId, num, tLogArg);
/*     */     
/*     */     case 11: 
/* 593 */       BasicItem basicItem = ItemInterface.getItemByCfgId(roleId, BaoKuConsts.getInstance().exchangeCostItemId);
/* 594 */       if (basicItem == null)
/* 595 */         return false;
/* 596 */       if (basicItem.getNumber() != roleCurrency)
/* 597 */         return false;
/* 598 */       return ItemInterface.removeItemById(roleId, BaoKuConsts.getInstance().exchangeCostItemId, num, tLogArg);
/*     */     }
/*     */     
/* 601 */     error("SuperEquipmentManager.chargeCurrencyForImprovingStage()@unhandled currency type|currency_type=%d", new Object[] { Integer.valueOf(type) });
/* 602 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Integer, Integer> getLackedItemsForImprovingStage(EquipmentItem item)
/*     */   {
/* 611 */     SSuperEquipmentStageCfg nextStageCfg = getNextStageCfg(item);
/* 612 */     if (nextStageCfg == null)
/*     */     {
/* 614 */       error("SuperEquipmentManager.getLackedItemsForImprovingStage()@stage conf not found|stage=%d", new Object[] { Integer.valueOf(item.getSuperEquipmentStage()) });
/*     */       
/* 616 */       return null;
/*     */     }
/* 618 */     HashMap<Integer, Integer> lackedItems = new HashMap();
/* 619 */     Map<Integer, Integer> costMap = item.getSuperEquipmentImproveStageCostMap();
/* 620 */     for (SuperEquipmentStageRequiredItem requiredItem : nextStageCfg.requiredItems)
/*     */     {
/* 622 */       int costNum = costMap.containsKey(Integer.valueOf(requiredItem.id)) ? ((Integer)costMap.get(Integer.valueOf(requiredItem.id))).intValue() : 0;
/* 623 */       int lackNum = requiredItem.num - costNum;
/* 624 */       if (lackNum > 0)
/* 625 */         lackedItems.put(Integer.valueOf(requiredItem.id), Integer.valueOf(lackNum));
/*     */     }
/* 627 */     return lackedItems;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getYuanbaoForImprovingStage(EquipmentItem item)
/*     */   {
/* 635 */     Map<Integer, Integer> lackedItems = getLackedItemsForImprovingStage(item);
/* 636 */     if (lackedItems == null)
/* 637 */       return -1;
/* 638 */     int yuanbao = 0;
/* 639 */     for (Map.Entry<Integer, Integer> e : lackedItems.entrySet())
/* 640 */       yuanbao += ItemInterface.getItemYuanBaoPrice(((Integer)e.getKey()).intValue()) * ((Integer)e.getValue()).intValue();
/* 641 */     return yuanbao;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Integer, Integer> getLackedItemsForImprovingLevel(EquipmentItem item)
/*     */   {
/* 649 */     SuperEquipmentLevelBean nextLevelBean = getNextLevelBean(item);
/* 650 */     if (nextLevelBean == null)
/* 651 */       return null;
/* 652 */     HashMap<Integer, Integer> lackedItems = new HashMap();
/* 653 */     Map<Integer, Integer> costMap = item.getSuperEquipmentImproveLevelCostMap();
/* 654 */     for (SuperEquipmentLevelRequiredItem requiredItem : nextLevelBean.requiredItems)
/*     */     {
/* 656 */       int costNum = costMap.containsKey(Integer.valueOf(requiredItem.id)) ? ((Integer)costMap.get(Integer.valueOf(requiredItem.id))).intValue() : 0;
/* 657 */       int lackNum = requiredItem.num - costNum;
/* 658 */       if (lackNum > 0)
/* 659 */         lackedItems.put(Integer.valueOf(requiredItem.id), Integer.valueOf(lackNum));
/*     */     }
/* 661 */     return lackedItems;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getYuanbaoForImprovingLevel(EquipmentItem item)
/*     */   {
/* 669 */     Map<Integer, Integer> lackedItems = getLackedItemsForImprovingLevel(item);
/* 670 */     if (lackedItems == null)
/* 671 */       return -1;
/* 672 */     int yuanbao = 0;
/* 673 */     for (Map.Entry<Integer, Integer> e : lackedItems.entrySet())
/* 674 */       yuanbao += ItemInterface.getItemYuanBaoPrice(((Integer)e.getKey()).intValue()) * ((Integer)e.getValue()).intValue();
/* 675 */     return yuanbao;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getMaxStrengthLevel(int stage)
/*     */   {
/* 683 */     SSuperEquipmentStageCfg stageCfg = SSuperEquipmentStageCfg.get(stage);
/* 684 */     if (stageCfg == null)
/* 685 */       return -1;
/* 686 */     return stageCfg.maxStrengthLevel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getMinStageFromRoleEquipments(long roleId)
/*     */   {
/* 696 */     RoleEquipBag equipBag = ItemInterface.getRoleEquipBag(roleId);
/* 697 */     if (equipBag == null) {
/* 698 */       return -1;
/*     */     }
/* 700 */     Integer minStage = null;
/* 701 */     for (int i = 0; i <= 5; i++)
/*     */     {
/* 703 */       BasicItem basicItem = (BasicItem)equipBag.getAllItems(false).get(Integer.valueOf(i));
/* 704 */       if (basicItem == null) {
/* 705 */         return 0;
/*     */       }
/* 707 */       if (!(basicItem instanceof EquipmentItem))
/* 708 */         return -1;
/* 709 */       EquipmentItem item = (EquipmentItem)basicItem;
/* 710 */       if ((minStage == null) || (item.getSuperEquipmentStage() < minStage.intValue()))
/* 711 */         minStage = Integer.valueOf(item.getSuperEquipmentStage());
/*     */     }
/* 713 */     return minStage.intValue();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\main\SuperEquipmentManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */