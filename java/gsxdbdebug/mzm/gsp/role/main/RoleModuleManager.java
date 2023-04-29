/*     */ package mzm.gsp.role.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.common.confbean.STPropertyScoreCfg;
/*     */ import mzm.gsp.fabaolingqi.main.FabaoArtifactInterface;
/*     */ import mzm.gsp.occupation.confbean.SOccupationPropTable;
/*     */ import mzm.gsp.occupation.confbean.SRoleLevelFlyCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.role.SAddBaoShiDuRes;
/*     */ import mzm.gsp.role.SCommonResultRes;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.yuanbao.main.CurrencyType;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.EachMoneyDayCostData;
/*     */ import xbean.MoneyCostDayData;
/*     */ import xbean.Pod;
/*     */ import xbean.Properties;
/*     */ import xtable.Role2daymoneycostinfo;
/*     */ import xtable.Role2properties;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RoleModuleManager
/*     */ {
/*     */   public static ModMoneyResult addSilverInAll(long roleId, long addValue, TLogArg arg, boolean withinMax)
/*     */   {
/*  36 */     return new RoleOperMoneySilver(roleId, addValue, arg, withinMax).addMoneyInAll();
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
/*     */   public static MoneyOperResult addSilverByIDIP(long roleId, long addValue, TLogArg arg)
/*     */   {
/*  53 */     return new RoleOperMoneySilver(roleId, addValue, arg).addMoneyByIDIP();
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
/*     */   public static MoneyOperResult addSilverByAqIDIP(long roleId, long addValue, TLogArg arg)
/*     */   {
/*  73 */     return new RoleOperMoneySilver(roleId, addValue, arg).addMoneyByAqIDIP();
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
/*     */   public static boolean cutSilver(long roleId, long cutValue, TLogArg arg)
/*     */   {
/*  86 */     return new RoleOperMoneySilver(roleId, cutValue, arg).cutMoney();
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
/*     */   public static MoneyOperResult cutSilverByIDIP(long roleId, long cutValue, TLogArg arg)
/*     */   {
/* 101 */     return new RoleOperMoneySilver(roleId, cutValue, arg).cutMoneyByIDIP();
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
/*     */   public static MoneyOperResult cutSilverByAqIDIP(long roleId, long cutValue, TLogArg arg)
/*     */   {
/* 117 */     return new RoleOperMoneySilver(roleId, cutValue, arg).cutMoneyByAqIDIP();
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
/*     */   public static ModMoneyResult addGoldInAll(long roleId, long addValue, TLogArg arg, boolean withinMax)
/*     */   {
/* 131 */     return new RoleOperMoneyGold(roleId, addValue, arg, withinMax).addMoneyInAll();
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
/*     */   public static MoneyOperResult addGoldByIDIP(long roleId, long addValue, TLogArg arg)
/*     */   {
/* 148 */     return new RoleOperMoneyGold(roleId, addValue, arg).addMoneyByIDIP();
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
/*     */   public static MoneyOperResult addGoldByAqIDIP(long roleId, long addValue, TLogArg arg)
/*     */   {
/* 168 */     return new RoleOperMoneyGold(roleId, addValue, arg).addMoneyByAqIDIP();
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
/*     */   public static boolean cutGold(long roleId, long cutValue, TLogArg arg)
/*     */   {
/* 181 */     return new RoleOperMoneyGold(roleId, cutValue, arg).cutMoney();
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
/*     */   public static MoneyOperResult cutGoldByIDIP(long roleId, long cutValue, TLogArg arg)
/*     */   {
/* 196 */     return new RoleOperMoneyGold(roleId, cutValue, arg).cutMoneyByIDIP();
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
/*     */   public static MoneyOperResult cutGoldByAqIDIP(long roleId, long cutValue, TLogArg arg)
/*     */   {
/* 212 */     return new RoleOperMoneyGold(roleId, cutValue, arg).cutMoneyByAqIDIP();
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
/*     */   public static ModMoneyResult addGoldIngotInAll(long roleId, long addValue, TLogArg arg, boolean withinMax)
/*     */   {
/* 226 */     return new RoleOperMoneyGoldIngot(roleId, addValue, arg, withinMax).addMoneyInAll();
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
/*     */   public static MoneyOperResult addGoldIngotByIDIP(long roleId, long addValue, TLogArg arg)
/*     */   {
/* 243 */     return new RoleOperMoneyGoldIngot(roleId, addValue, arg).addMoneyByIDIP();
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
/*     */   public static MoneyOperResult addGoldIngotByAqIDIP(long roleId, long addValue, TLogArg arg)
/*     */   {
/* 263 */     return new RoleOperMoneyGoldIngot(roleId, addValue, arg).addMoneyByAqIDIP();
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
/*     */   public static boolean cutGoldIngot(long roleId, long cutValue, TLogArg arg)
/*     */   {
/* 276 */     return new RoleOperMoneyGoldIngot(roleId, cutValue, arg).cutMoney();
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
/*     */   public static MoneyOperResult cutGoldIngotByIDIP(long roleId, long cutValue, TLogArg arg)
/*     */   {
/* 291 */     return new RoleOperMoneyGoldIngot(roleId, cutValue, arg).cutMoneyByIDIP();
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
/*     */   public static MoneyOperResult cutGoldIngotByAqIDIP(long roleId, long cutValue, TLogArg arg)
/*     */   {
/* 307 */     return new RoleOperMoneyGoldIngot(roleId, cutValue, arg).cutMoneyByAqIDIP();
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public static ModMoneyResult addSilverInAll_old(long roleId, long addValue, TLogArg arg, boolean withinMax)
/*     */   {
/* 313 */     ModMoneyResult result = new ModMoneyResult();
/* 314 */     if (addValue < 0L)
/*     */     {
/* 316 */       result.setbSucceed(false);
/* 317 */       result.setRes(ModMoneyResult.ErrorResult.ERROR_MONEY_NUM_SIGN);
/* 318 */       return result;
/*     */     }
/* 320 */     if (addValue == 0L)
/*     */     {
/* 322 */       return setMoneyModSucRes(result, 0L);
/*     */     }
/* 324 */     Properties xProperties = Role2properties.get(Long.valueOf(roleId));
/* 325 */     long silver = xProperties.getSilver();
/* 326 */     if (Long.MAX_VALUE - silver < addValue)
/*     */     {
/* 328 */       return setMoneyModErrRes(result, ModMoneyResult.ErrorResult.ERROR_MONEY_NUM_HAS_REACH_TOP_LIMIT);
/*     */     }
/*     */     
/*     */ 
/* 332 */     long silverMax = getSilverMax();
/* 333 */     long diffValue = silverMax - silver;
/* 334 */     if (withinMax)
/*     */     {
/* 336 */       if (diffValue < addValue)
/*     */       {
/* 338 */         return setMoneyModErrRes(result, ModMoneyResult.ErrorResult.ERROR_MONEY_NUM_HAS_REACH_TOP_LIMIT);
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 343 */       if (diffValue <= 0L)
/*     */       {
/* 345 */         sendSCommonResultRes(roleId, 10, false);
/* 346 */         return setMoneyModSucRes(result, 0L);
/*     */       }
/* 348 */       if (diffValue < addValue)
/*     */       {
/* 350 */         addValue = diffValue;
/*     */       }
/*     */     }
/*     */     
/* 354 */     xProperties.setSilver(silver + addValue);
/*     */     
/* 356 */     RoleInterface.addCurrencyLog(roleId, CurrencyType.CURRENCY_SILVE, addValue, xProperties.getSilver(), arg);
/* 357 */     return setMoneyModSucRes(result, addValue);
/*     */   }
/*     */   
/*     */   static void sendSCommonResultRes(long roleId, int res, boolean rightNow)
/*     */   {
/* 362 */     SCommonResultRes sCommonResultRes = new SCommonResultRes();
/* 363 */     sCommonResultRes.result = res;
/* 364 */     if (rightNow)
/*     */     {
/* 366 */       OnlineManager.getInstance().sendAtOnce(roleId, sCommonResultRes);
/*     */     }
/*     */     else
/*     */     {
/* 370 */       OnlineManager.getInstance().send(roleId, sCommonResultRes);
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
/*     */   private static ModMoneyResult setMoneyModSucRes(ModMoneyResult result, long addValue)
/*     */   {
/* 383 */     result.setbSucceed(true);
/* 384 */     result.setModValue(addValue);
/* 385 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static ModMoneyResult setMoneyModErrRes(ModMoneyResult result, ModMoneyResult.ErrorResult res)
/*     */   {
/* 397 */     result.setbSucceed(false);
/* 398 */     result.setRes(ModMoneyResult.ErrorResult.ERROR_MONEY_NUM_HAS_REACH_TOP_LIMIT);
/* 399 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static long getSilverMax()
/*     */   {
/* 409 */     return AwardInterface.getMoneyOwnMax(3);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public static ModMoneyResult addGoldInAll_old(long roleId, long addValue, TLogArg arg, boolean withinMax)
/*     */   {
/* 415 */     ModMoneyResult result = new ModMoneyResult();
/* 416 */     if (addValue < 0L)
/*     */     {
/* 418 */       result.setbSucceed(false);
/* 419 */       result.setRes(ModMoneyResult.ErrorResult.ERROR_MONEY_NUM_SIGN);
/* 420 */       return result;
/*     */     }
/* 422 */     if (addValue == 0L)
/*     */     {
/* 424 */       return setMoneyModSucRes(result, 0L);
/*     */     }
/* 426 */     Properties xProperties = Role2properties.get(Long.valueOf(roleId));
/* 427 */     long gold = xProperties.getGold();
/* 428 */     if (Long.MAX_VALUE - gold < addValue)
/*     */     {
/* 430 */       return setMoneyModErrRes(result, ModMoneyResult.ErrorResult.ERROR_MONEY_NUM_HAS_REACH_TOP_LIMIT);
/*     */     }
/*     */     
/*     */ 
/* 434 */     long goldMax = getGoldMax();
/* 435 */     long diffValue = goldMax - gold;
/* 436 */     if (withinMax)
/*     */     {
/* 438 */       if (diffValue < addValue)
/*     */       {
/*     */ 
/* 441 */         return setMoneyModErrRes(result, ModMoneyResult.ErrorResult.ERROR_MONEY_NUM_HAS_REACH_TOP_LIMIT);
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 446 */       if (diffValue <= 0L)
/*     */       {
/* 448 */         sendSCommonResultRes(roleId, 11, false);
/* 449 */         return setMoneyModSucRes(result, 0L);
/*     */       }
/* 451 */       if (diffValue < addValue)
/*     */       {
/* 453 */         addValue = diffValue;
/*     */       }
/*     */     }
/*     */     
/* 457 */     setGold(roleId, xProperties, gold + addValue);
/*     */     
/* 459 */     RoleInterface.addCurrencyLog(roleId, CurrencyType.CURRENCY_GOLD, addValue, xProperties.getGold(), arg);
/* 460 */     return setMoneyModSucRes(result, addValue);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static long getGoldMax()
/*     */   {
/* 470 */     return AwardInterface.getMoneyOwnMax(2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static double getPropertyFactor(int proType, int occupation)
/*     */   {
/* 482 */     STPropertyScoreCfg cfg = STPropertyScoreCfg.get(proType);
/* 483 */     if (cfg == null)
/*     */     {
/* 485 */       return -1.0D;
/*     */     }
/* 487 */     Double factor = (Double)cfg.occ2factor.get(Integer.valueOf(occupation));
/* 488 */     return factor == null ? -1.0D : factor.doubleValue();
/*     */   }
/*     */   
/*     */   public static void setGold(long roleId, Properties xProperty, long value)
/*     */   {
/* 493 */     setGold(roleId, xProperty, value, false);
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
/*     */   public static void setGold(long roleId, Properties xProperty, long value, boolean canBeNegative)
/*     */   {
/* 507 */     if ((value < 0L) && (!canBeNegative))
/*     */     {
/* 509 */       return;
/*     */     }
/* 511 */     long oldGold = xProperty.getGold();
/* 512 */     if (oldGold == value)
/*     */     {
/* 514 */       return;
/*     */     }
/* 516 */     xProperty.setGold(value);
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
/*     */   public static int addBaoShiDu(long roleId, int addValue)
/*     */   {
/* 531 */     if (addValue < 0)
/*     */     {
/* 533 */       GameServer.logger().error(String.format("[role]RoleModuleManager.addBaoShiDu@ param illegal!|roleId=%d|addValue=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(addValue) }));
/*     */       
/* 535 */       return -1;
/*     */     }
/* 537 */     if (addValue == 0)
/*     */     {
/* 539 */       GameServer.logger().info(String.format("[role]RoleModuleManager.addBaoShiDu@ addValue is zero!|roleId=%d|addValue=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(addValue) }));
/*     */       
/*     */ 
/* 542 */       return 0;
/*     */     }
/* 544 */     RoleOutFightObj roleOutFightObj = RoleInterface.getRoleOutFightObject(roleId);
/* 545 */     int oldBaoValue = roleOutFightObj.getBaoShiDu();
/* 546 */     if (!roleOutFightObj.addBaoShiDu(addValue))
/*     */     {
/* 548 */       GameServer.logger().error(String.format("[role]RoleModuleManager.addBaoShiDu@ addBaoShiDu err!|roleId=%d|addValue=%d|oldBaoValue=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(addValue), Integer.valueOf(oldBaoValue) }));
/*     */       
/*     */ 
/* 551 */       return -1;
/*     */     }
/* 553 */     afterAddBaoShiDu(roleId, roleOutFightObj, oldBaoValue);
/*     */     
/* 555 */     return roleOutFightObj.getBaoShiDu() - oldBaoValue;
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
/*     */   private static void afterAddBaoShiDu(long roleId, RoleOutFightObj roleOutFightObj, int oldBaoValue)
/*     */   {
/* 569 */     roleOutFightObj.setHpAndMpFull();
/*     */     
/* 571 */     Set<Long> petids = PetInterface.getPetList(roleId, true);
/* 572 */     for (Iterator i$ = petids.iterator(); i$.hasNext();) { long petid = ((Long)i$.next()).longValue();
/*     */       
/* 574 */       PetInterface.recoveryHPAndMP(roleId, petid);
/*     */     }
/* 576 */     SAddBaoShiDuRes res = new SAddBaoShiDuRes();
/* 577 */     res.addbaoshudu = (roleOutFightObj.getBaoShiDu() - oldBaoValue);
/* 578 */     OnlineManager.getInstance().send(roleId, res);
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
/*     */   public static int getLvTotalPotential(int finalLv, int occupationId, int gender)
/*     */   {
/* 594 */     Occupation ocp = OccupationManager.getOccupationById(occupationId, gender);
/* 595 */     if (!ocp.isRoleOpen())
/*     */     {
/* 597 */       return -1;
/*     */     }
/* 599 */     if (finalLv < ocp.getBornLevel())
/*     */     {
/* 601 */       return -1;
/*     */     }
/* 603 */     int totalPotential = 0;
/* 604 */     Iterator i$; for (int tmpLv = ocp.getBornLevel() + 1; tmpLv <= finalLv; tmpLv++)
/*     */     {
/* 606 */       for (i$ = RoleManager.getPropSet().iterator(); i$.hasNext();) { int propType = ((Integer)i$.next()).intValue();
/*     */         
/* 608 */         int addValue = ocp.getPortentialAddPoint(propType, tmpLv);
/* 609 */         totalPotential += addValue;
/*     */       }
/*     */     }
/* 612 */     return totalPotential;
/*     */   }
/*     */   
/*     */ 
/*     */   private static void outputOccInfo()
/*     */   {
/* 618 */     for (SOccupationPropTable ocp : SOccupationPropTable.getAll().values())
/*     */     {
/* 620 */       for (int level = 0; level < 150; level++)
/*     */       {
/* 622 */         int point = getLvTotalPotential(level, ocp.occupationId, ocp.gender);
/* 623 */         GameServer.logger().debug(String.format("occId=%d|gender=%d|occName=%s|level=%d|point=%d", new Object[] { Integer.valueOf(ocp.occupationId), Integer.valueOf(ocp.gender), ocp.occupationName, Integer.valueOf(level), Integer.valueOf(point) }));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isReachMaxLevel(long roleId, boolean remainRoleLock)
/*     */   {
/* 643 */     Role role = RoleInterface.getRole(roleId, remainRoleLock);
/* 644 */     Occupation occupation = OccupationManager.getOccupationById(role.getOccupationId(), role.getGender());
/* 645 */     return role.getExp() >= occupation.getToNextLevelNeedExp(role.getLevel());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static double getReachMaxLevelExpModRet(int level)
/*     */   {
/* 655 */     SRoleLevelFlyCfg cfg = SRoleLevelFlyCfg.get(level);
/* 656 */     if (cfg == null)
/*     */     {
/* 658 */       return -1.0D;
/*     */     }
/* 660 */     if (cfg.openId <= 0)
/*     */     {
/* 662 */       return -1.0D;
/*     */     }
/* 664 */     if (!OpenInterface.getOpenStatus(cfg.openId))
/*     */     {
/* 666 */       return -1.0D;
/*     */     }
/* 668 */     return cfg.changeRet;
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
/*     */   static long getTotalCostMoneyThisDay(long roleId, CurrencyType currencyType)
/*     */   {
/* 682 */     return getTotalCostMoneyThisDay(roleId, currencyType.value);
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
/*     */   private static long getTotalCostMoneyThisDay(long roleId, int currencyType)
/*     */   {
/* 696 */     MoneyCostDayData xMoneyCostDayData = getAndInitXMoneyCostDayData(roleId, DateTimeUtils.getCurrTimeInMillis());
/* 697 */     EachMoneyDayCostData xEachMoneyDayCostData = (EachMoneyDayCostData)xMoneyCostDayData.getMoneyinfo().get(Integer.valueOf(currencyType));
/* 698 */     return xEachMoneyDayCostData == null ? 0L : xEachMoneyDayCostData.getTotalcost();
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
/*     */   static void recordMoneyCostPerDay(long roleId, long cutValue, int currencyType)
/*     */   {
/* 714 */     if (cutValue <= 0L)
/*     */     {
/* 716 */       return;
/*     */     }
/*     */     
/* 719 */     addDBCostValue(cutValue, getAndInitXMoneyCostDayData(roleId, DateTimeUtils.getCurrTimeInMillis()), currencyType);
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
/*     */   static MoneyCostDayData getAndInitXMoneyCostDayData(long roleId, long curTime)
/*     */   {
/* 735 */     MoneyCostDayData xMoneyCostDayData = Role2daymoneycostinfo.get(Long.valueOf(roleId));
/* 736 */     if (xMoneyCostDayData == null)
/*     */     {
/*     */ 
/* 739 */       xMoneyCostDayData = Pod.newMoneyCostDayData();
/* 740 */       xMoneyCostDayData.setStarttime(curTime);
/* 741 */       Role2daymoneycostinfo.insert(Long.valueOf(roleId), xMoneyCostDayData);
/*     */     }
/* 743 */     if (DateTimeUtils.needDailyReset(xMoneyCostDayData.getStarttime(), curTime, 0))
/*     */     {
/*     */ 
/* 746 */       xMoneyCostDayData.setStarttime(curTime);
/* 747 */       xMoneyCostDayData.getMoneyinfo().clear();
/*     */     }
/* 749 */     return xMoneyCostDayData;
/*     */   }
/*     */   
/*     */   private static void addDBCostValue(long cutValue, MoneyCostDayData xMoneyCostDayData, int currencyType)
/*     */   {
/* 754 */     EachMoneyDayCostData xEachMoneyDayCostData = (EachMoneyDayCostData)xMoneyCostDayData.getMoneyinfo().get(Integer.valueOf(currencyType));
/* 755 */     if (xEachMoneyDayCostData == null)
/*     */     {
/* 757 */       xEachMoneyDayCostData = Pod.newEachMoneyDayCostData();
/* 758 */       xMoneyCostDayData.getMoneyinfo().put(Integer.valueOf(currencyType), xEachMoneyDayCostData);
/*     */     }
/* 760 */     long orgValue = xEachMoneyDayCostData.getTotalcost();
/* 761 */     xEachMoneyDayCostData.setTotalcost(orgValue + cutValue);
/*     */   }
/*     */   
/*     */   static long getOnlineSecondThisDay(long roleId, boolean remainLock) {
/*     */     Properties xProperties;
/*     */     Properties xProperties;
/* 767 */     if (remainLock)
/*     */     {
/* 769 */       xProperties = Role2properties.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/* 773 */       xProperties = Role2properties.select(Long.valueOf(roleId));
/*     */     }
/*     */     
/* 776 */     if (xProperties == null)
/*     */     {
/* 778 */       return 0L;
/*     */     }
/* 780 */     return xProperties.getDayonlineseconds();
/*     */   }
/*     */   
/*     */   static long getOnlineSecondTotal(long roleId, boolean remainLock) {
/*     */     Properties xProperties;
/*     */     Properties xProperties;
/* 786 */     if (remainLock)
/*     */     {
/* 788 */       xProperties = Role2properties.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/* 792 */       xProperties = Role2properties.select(Long.valueOf(roleId));
/*     */     }
/*     */     
/* 795 */     if (xProperties == null)
/*     */     {
/* 797 */       return 0L;
/*     */     }
/* 799 */     return xProperties.getOnlineseconds();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void refreshFaBaoLingQiPro(long roleId)
/*     */   {
/* 809 */     RoleOutFightObj outFightObj = new RoleOutFightObj(roleId);
/* 810 */     outFightObj.setFaBaoLingQiPro(FabaoArtifactInterface.getArtifactProperties(roleId, true));
/* 811 */     outFightObj.syncClientRoleProperty();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\RoleModuleManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */