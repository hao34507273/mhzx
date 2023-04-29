/*     */ package mzm.gsp.awardpool.main;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.awardpool.confbean.SAwardPoolMainTable;
/*     */ import mzm.gsp.awardpool.confbean.SAwardPoolSum;
/*     */ import mzm.gsp.awardpool.confbean.SLotteryViewRandomCfg;
/*     */ import mzm.gsp.awardpool.confbean.SPreciousDropCfg;
/*     */ import mzm.gsp.awardpool.confbean.SWeightCorrectionTypeCfg;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.gang.main.ModBangGongResult;
/*     */ import mzm.gsp.item.confbean.ItemCfgConsts;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.pet.main.Pet;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.role.main.ModMoneyResult;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.xiulian.main.XiuLianSkillInterface;
/*     */ import xbean.WeightCorrectionCounter;
/*     */ import xbean.WeightCorrectionType2Count;
/*     */ import xtable.Role2weightcorrectioncount;
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
/*     */ public class AwardPoolInterface
/*     */ {
/*     */   public static AwardPoolResultData randomAwardPoolForRole(long roleId, int awardPoolSumId)
/*     */   {
/*  48 */     return randomAwardPoolForRole(roleId, null, awardPoolSumId);
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
/*     */   public static AwardPoolResultData randomAwardPoolForRole(long roleId, int awardPoolSumId, boolean isQueryMode)
/*     */   {
/*  64 */     return AwardPoolManager.randomAwardPoolForRole(roleId, null, awardPoolSumId, isQueryMode);
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
/*     */   public static AwardPoolResultData randomAwardPoolForRole(long roleId, List<Integer> buffEffectIds, int awardPoolSumId)
/*     */   {
/*  79 */     return AwardPoolManager.randomAwardPoolForRole(roleId, buffEffectIds, awardPoolSumId, false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<Integer> getItemId2NumMap(List<Integer> itemSubIds)
/*     */   {
/*  90 */     return AwardPoolManager.getItemId2NumMap(itemSubIds);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean hasItem(int awardPoolSumId, int itemid)
/*     */   {
/* 102 */     return AwardPoolManager.hasItem(awardPoolSumId, itemid);
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
/*     */   public static void doAward(String userid, long roleId, AwardPoolResultData resultData, TLogArg logArg)
/*     */   {
/* 117 */     awardMoney(roleId, resultData, logArg);
/*     */     
/* 119 */     awardExp(userid, roleId, resultData, logArg);
/*     */     
/* 121 */     awardItem(roleId, resultData, logArg);
/*     */     
/* 123 */     awardController(roleId, resultData);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static boolean awardMoney(long roleId, AwardPoolResultData resultData, TLogArg logArg)
/*     */   {
/* 130 */     boolean result = true;
/*     */     
/* 132 */     if (resultData.getSilver() > 0)
/*     */     {
/* 134 */       ModMoneyResult r1 = RoleInterface.addSilver(roleId, resultData.getSilver(), logArg);
/* 135 */       result = r1.isSucceed();
/*     */     }
/* 137 */     if (resultData.getGold() > 0)
/*     */     {
/* 139 */       ModMoneyResult r2 = RoleInterface.addGold(roleId, resultData.getGold(), logArg);
/* 140 */       result = r2.isSucceed();
/*     */     }
/* 142 */     if (resultData.getGang() > 0)
/*     */     {
/* 144 */       ModBangGongResult s = GangInterface.addBangGong(roleId, resultData.getGang(), logArg);
/* 145 */       result = s.isSucceed();
/*     */     }
/*     */     
/* 148 */     return result;
/*     */   }
/*     */   
/*     */   private static boolean awardExp(String userid, long roleId, AwardPoolResultData resultData, TLogArg logArg)
/*     */   {
/* 153 */     boolean result = true;
/*     */     
/* 155 */     if (resultData.getPetExp() > 0)
/*     */     {
/* 157 */       Pet pet = PetInterface.getFightPet(roleId, true);
/* 158 */       if (pet != null)
/*     */       {
/* 160 */         pet.addExp(resultData.getPetExp());
/*     */       }
/*     */     }
/*     */     
/* 164 */     if (resultData.getRoleExp() > 0)
/*     */     {
/* 166 */       RoleInterface.addExp(userid, roleId, resultData.getRoleExp(), logArg);
/*     */     }
/* 168 */     if (resultData.getXiuLianExp() > 0)
/*     */     {
/* 170 */       XiuLianSkillInterface.addXiuLianExp(roleId, resultData.getXiuLianExp(), logArg);
/*     */     }
/*     */     
/* 173 */     return result;
/*     */   }
/*     */   
/*     */   private static boolean awardItem(long roleId, AwardPoolResultData resultData, TLogArg logArg)
/*     */   {
/* 178 */     if ((resultData.getItemMap() != null) && (resultData.getItemMap().size() > 0))
/*     */     {
/* 180 */       ItemOperateResult result = ItemInterface.addItem(roleId, resultData.getItemMap(), false, logArg);
/*     */       
/* 182 */       return (result.success()) || (result.isBagFull());
/*     */     }
/* 184 */     return true;
/*     */   }
/*     */   
/*     */   private static void awardController(long roleId, AwardPoolResultData resultData)
/*     */   {
/* 189 */     if (resultData.getControllerId() > 0)
/*     */     {
/* 191 */       ControllerInterface.triggerController(roleId, resultData.getControllerId());
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
/*     */   public static SAwardPoolMainTable getAwardPoolSumIdByLevel(int poolTypeId, int level)
/*     */   {
/* 205 */     return AwardPoolManager.getAwardPoolSumIdByLevel(poolTypeId, level);
/*     */   }
/*     */   
/*     */   public static boolean isSMoneyPoolSub(int id)
/*     */   {
/* 210 */     return AwardPoolManager.isSMoneyPoolSub(id);
/*     */   }
/*     */   
/*     */   public static boolean isSItemPoolSub(int id)
/*     */   {
/* 215 */     return AwardPoolManager.isSItemPoolSub(id);
/*     */   }
/*     */   
/*     */   public static boolean isSExpPoolSub(int id)
/*     */   {
/* 220 */     return AwardPoolManager.isSExpPoolSub(id);
/*     */   }
/*     */   
/*     */   public static boolean isSControllerPoolSub(int id)
/*     */   {
/* 225 */     return AwardPoolManager.isSControllerPoolSub(id);
/*     */   }
/*     */   
/*     */   public static boolean isSReplaceMoneyTypeSub(int id)
/*     */   {
/* 230 */     return AwardPoolManager.isSReplaceMoneyTypeSub(id);
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
/*     */   public static AwardPoolResultData getAwardPoolData(int poolTypeId, long roleid, int level)
/*     */   {
/* 244 */     return AwardPoolManager.randomAwardPoolForRole(poolTypeId, roleid, level, false);
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
/*     */   public static AwardPoolResultData getAwardPoolData(int poolTypeId, int level, boolean isQueryMode)
/*     */   {
/* 260 */     return AwardPoolManager.randomAwardPoolResultData(poolTypeId, level, isQueryMode);
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
/*     */   public static AwardPoolResultData getAwardPoolData(int poolTypeId, int level)
/*     */   {
/* 275 */     return getAwardPoolData(poolTypeId, level, false);
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
/*     */   public static List<AwardPoolResultData> getAwardPoolData(int awardPoolLibId)
/*     */   {
/* 289 */     return AwardPoolManager.randomAwardPoolResultDatas(awardPoolLibId, false);
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
/*     */   public static List<AwardPoolResultData> getAwardPoolData(int awardPoolLibId, boolean isQueryMode)
/*     */   {
/* 303 */     return AwardPoolManager.randomAwardPoolResultDatas(awardPoolLibId, isQueryMode);
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
/*     */   public static AwardPoolResultData getLotteryResultData(long roleid, int lotteryViewId)
/*     */   {
/* 316 */     List<AwardPoolResultData> resultDataList = AwardPoolManager.getLotteryResultData(roleid, Collections.singletonList(Integer.valueOf(lotteryViewId)), false, null, null);
/*     */     
/* 318 */     return (AwardPoolResultData)resultDataList.get(0);
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
/*     */   public static AwardPoolResultData getLotteryResultData(long roleid, int lotteryViewId, boolean isQueryMode)
/*     */   {
/* 333 */     List<AwardPoolResultData> resultDataList = AwardPoolManager.getLotteryResultData(roleid, Collections.singletonList(Integer.valueOf(lotteryViewId)), isQueryMode, null, null);
/*     */     
/* 335 */     return (AwardPoolResultData)resultDataList.get(0);
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
/*     */   public static List<AwardPoolResultData> getLotteryResultData(long roleid, List<Integer> lotteryViewIds, boolean isQueryMode)
/*     */   {
/* 352 */     return AwardPoolManager.getLotteryResultData(roleid, lotteryViewIds, isQueryMode, null, null);
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
/*     */   public static AwardPoolResultData getLotteryResultData(long roleid, int lotteryViewId, List<Integer> removeSubIds)
/*     */   {
/* 366 */     List<AwardPoolResultData> resultDataList = AwardPoolManager.getLotteryResultData(roleid, Collections.singletonList(Integer.valueOf(lotteryViewId)), removeSubIds);
/*     */     
/* 368 */     return (AwardPoolResultData)resultDataList.get(0);
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
/*     */   public static List<AwardPoolResultData> getLotteryResultData(long roleid, List<Integer> lotteryViewIds, List<Integer> removeSubIds)
/*     */   {
/* 383 */     return AwardPoolManager.getLotteryResultData(roleid, lotteryViewIds, removeSubIds);
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
/*     */   public static void awardLottery(List<Long> roleList, int lotteryViewId, TLogArg logArg)
/*     */   {
/* 398 */     awardLottery(roleList, lotteryViewId, true, ItemCfgConsts.getInstance().LOTTERY_DELAY_INTERVAL, logArg);
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
/*     */   public static void awardLottery(List<Long> roleList, int lotteryViewId, boolean isAutoStart, int delayOfferTime, TLogArg logArg)
/*     */   {
/* 416 */     AwardPoolManager.awardLottery(roleList, lotteryViewId, isAutoStart, delayOfferTime, logArg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isSAwardPoolLibExists(int awardpoollib)
/*     */   {
/* 427 */     return AwardPoolManager.isSAwardPoolLibExists(awardpoollib);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<Integer> getAwardPoolSumidsByLibid(int awardPoolLibId)
/*     */   {
/* 439 */     return AwardPoolManager.getAwardPoolSumidsByLibid(awardPoolLibId);
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
/*     */   public static boolean containsItem(int itemId, int poolTypeId, int roleLevel)
/*     */   {
/* 457 */     return AwardPoolManager.containsItem(itemId, poolTypeId, roleLevel);
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
/*     */   public static void setServerDropUnhitCount(int itemSubid, int unhitCount)
/*     */   {
/* 472 */     new PGM_ClearServerDrop(itemSubid, unhitCount).execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isPreciousDrop(int itemSubId)
/*     */   {
/* 484 */     int preciousId = AwardPoolManager.getPreciousCfgId(itemSubId);
/*     */     
/* 486 */     SPreciousDropCfg preciousDropCfg = SPreciousDropCfg.get(preciousId);
/* 487 */     return preciousDropCfg != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Map<Integer, Integer> getBagId2MaxNeedGridNum(int awardTypeId)
/*     */   {
/* 498 */     return AwardPoolManager.getBagId2MaxNeedGridNum(awardTypeId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Map<Integer, Integer> getBagId2LotteryNeedGrid(int lotteryViewId)
/*     */   {
/* 510 */     return AwardPoolManager.getBagId2LotteryNeedGrid(lotteryViewId);
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
/*     */   public static int checkGridNum(long roleId, Map<Integer, Integer> bagId2needGridNum, boolean sendError, boolean retainLock)
/*     */   {
/* 526 */     return checkGridNum(roleId, bagId2needGridNum, 1, sendError, retainLock);
/*     */   }
/*     */   
/*     */ 
/*     */   public static int checkGridNum(long roleId, Map<Integer, Integer> bagId2needGridNum, int lotteryCount, boolean sendError, boolean retainLock)
/*     */   {
/* 532 */     for (Map.Entry<Integer, Integer> entry : bagId2needGridNum.entrySet())
/*     */     {
/* 534 */       int bagId = ((Integer)entry.getKey()).intValue();
/* 535 */       int availableBagGrid = ItemInterface.getAvailableGridNum(roleId, bagId, retainLock);
/* 536 */       if (((Integer)entry.getValue()).intValue() * lotteryCount > availableBagGrid)
/*     */       {
/* 538 */         if (sendError)
/*     */         {
/* 540 */           ItemInterface.sendSpecificBagGridNotEnough(roleId, bagId);
/*     */         }
/* 542 */         return ((Integer)entry.getKey()).intValue();
/*     */       }
/*     */     }
/*     */     
/* 546 */     return 0;
/*     */   }
/*     */   
/*     */   public static AwardPoolResultData randomResultForNormalLottery(long roleid, int roleLevel, int poolTypeId)
/*     */   {
/* 551 */     SAwardPoolMainTable awardPoolMainTable = getAwardPoolSumIdByLevel(poolTypeId, roleLevel);
/* 552 */     if (awardPoolMainTable == null)
/*     */     {
/* 554 */       return null;
/*     */     }
/* 556 */     SAwardPoolSum awardPoolSum = SAwardPoolSum.get(awardPoolMainTable.awardPoolSumId);
/* 557 */     if (awardPoolSum == null)
/*     */     {
/* 559 */       return null;
/*     */     }
/* 561 */     Map<Integer, Integer> bagId2needGridNum = getBagId2MaxNeedGridNum(awardPoolSum.awardTypeId);
/* 562 */     if (checkGridNum(roleid, bagId2needGridNum, true, true) > 0)
/*     */     {
/* 564 */       return null;
/*     */     }
/*     */     
/* 567 */     AwardPoolResultData result = randomAwardPoolForRole(roleid, awardPoolMainTable.buffEffectIds, awardPoolMainTable.awardPoolSumId);
/*     */     
/* 569 */     return result;
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
/*     */   public static AwardPoolResultData getLotteryResultData(long roleid, int lotteryViewId, boolean isQueryMode, List<Integer> removeSubIds, List<Integer> removeTypeIds)
/*     */   {
/* 585 */     List<AwardPoolResultData> resultDataList = AwardPoolManager.getLotteryResultData(roleid, Collections.singletonList(Integer.valueOf(lotteryViewId)), isQueryMode, removeSubIds, removeTypeIds);
/*     */     
/* 587 */     return (AwardPoolResultData)resultDataList.get(0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Map<Integer, Integer> getMaxGridNeededForPoolTypeIds(long roleId, Collection<Integer> poolTypeIds)
/*     */   {
/* 599 */     Map<Integer, Integer> bagId2maxNeedGridNum = new HashMap();
/*     */     
/*     */ 
/*     */ 
/* 603 */     for (Integer poolTypeId : poolTypeIds)
/*     */     {
/* 605 */       SAwardPoolMainTable awardPoolMainTable = getAwardPoolSumIdByLevel(poolTypeId.intValue(), RoleInterface.getLevel(roleId));
/* 606 */       if (awardPoolMainTable != null)
/*     */       {
/*     */ 
/*     */ 
/* 610 */         SAwardPoolSum awardPoolSum = SAwardPoolSum.get(awardPoolMainTable.awardPoolSumId);
/* 611 */         if (awardPoolSum != null)
/*     */         {
/*     */ 
/*     */ 
/* 615 */           Map<Integer, Integer> bagId2needGridNum = getBagId2MaxNeedGridNum(awardPoolSum.awardTypeId);
/* 616 */           for (Map.Entry<Integer, Integer> entry : bagId2needGridNum.entrySet())
/*     */           {
/* 618 */             Integer maxNeedGridNum = (Integer)bagId2maxNeedGridNum.get(entry.getKey());
/* 619 */             if (null == maxNeedGridNum)
/*     */             {
/* 621 */               bagId2maxNeedGridNum.put(entry.getKey(), entry.getValue());
/*     */             }
/*     */             else
/*     */             {
/* 625 */               bagId2maxNeedGridNum.put(entry.getKey(), Integer.valueOf(Math.max(((Integer)entry.getValue()).intValue(), maxNeedGridNum.intValue()))); }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 630 */     return bagId2maxNeedGridNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void clearLotteryWeightCorrectionInfo(long roleId, int lotteryViewRandomCfgId)
/*     */   {
/* 641 */     SLotteryViewRandomCfg lotteryViewRandomCfg = SLotteryViewRandomCfg.get(lotteryViewRandomCfgId);
/* 642 */     if (lotteryViewRandomCfg == null)
/*     */     {
/* 644 */       return;
/*     */     }
/* 646 */     SWeightCorrectionTypeCfg weightCorrectionTypeCfg = SWeightCorrectionTypeCfg.get(lotteryViewRandomCfg.weightCorrectionTypeCfgId);
/*     */     
/* 648 */     if (weightCorrectionTypeCfg == null)
/*     */     {
/* 650 */       return;
/*     */     }
/* 652 */     WeightCorrectionType2Count xWeightCorrectionType2Count = Role2weightcorrectioncount.get(Long.valueOf(roleId));
/* 653 */     if (xWeightCorrectionType2Count == null)
/*     */     {
/* 655 */       return;
/*     */     }
/* 657 */     WeightCorrectionCounter xWeightCorrectionCounter = (WeightCorrectionCounter)xWeightCorrectionType2Count.getWeightcorrectiontype2count().get(Integer.valueOf(lotteryViewRandomCfg.weightCorrectionTypeCfgId));
/*     */     
/* 659 */     if (xWeightCorrectionCounter == null)
/*     */     {
/* 661 */       return;
/*     */     }
/* 663 */     xWeightCorrectionCounter.setCount(0);
/* 664 */     xWeightCorrectionCounter.setModifytime(DateTimeUtils.getCurrTimeInMillis());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addWeightCorrectCount(long roleId, int weightCorrectTypeCfgId)
/*     */   {
/* 675 */     WeightCorrectionManager.addWeightCorrectCount(roleId, weightCorrectTypeCfgId);
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
/*     */   public static int getCorrectedWeight(long roleId, int weightCorrectTypeCfgId, int weightCorrectCfgId)
/*     */   {
/* 690 */     return WeightCorrectionManager.getCorrectedWeight(roleId, weightCorrectTypeCfgId, weightCorrectCfgId);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\main\AwardPoolInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */