/*      */ package mzm.gsp.awardpool.main;
/*      */ 
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.award.main.AwardInterface;
/*      */ import mzm.gsp.awardpool.confbean.SAwardPoolLib;
/*      */ import mzm.gsp.awardpool.confbean.SAwardPoolMainTable;
/*      */ import mzm.gsp.awardpool.confbean.SAwardPoolSum;
/*      */ import mzm.gsp.awardpool.confbean.SAwardTypeId2ControllerSubId;
/*      */ import mzm.gsp.awardpool.confbean.SAwardTypeId2ExpSubId;
/*      */ import mzm.gsp.awardpool.confbean.SAwardTypeId2ItemSubId;
/*      */ import mzm.gsp.awardpool.confbean.SAwardTypeId2MoneySubId;
/*      */ import mzm.gsp.awardpool.confbean.SAwardTypeId2PreciousItemSubId;
/*      */ import mzm.gsp.awardpool.confbean.SAwardTypeId2ReplaceMoneySubId;
/*      */ import mzm.gsp.awardpool.confbean.SControllerPoolSub;
/*      */ import mzm.gsp.awardpool.confbean.SExpPoolSub;
/*      */ import mzm.gsp.awardpool.confbean.SItemPoolSub;
/*      */ import mzm.gsp.awardpool.confbean.SLotteryViewRandomCfg;
/*      */ import mzm.gsp.awardpool.confbean.SMoneyPoolSub;
/*      */ import mzm.gsp.awardpool.confbean.SPoolTypeId2AwardPoolMainTableId;
/*      */ import mzm.gsp.awardpool.confbean.SPreciousDropCfg;
/*      */ import mzm.gsp.awardpool.confbean.SRandomTextTableCfg;
/*      */ import mzm.gsp.awardpool.confbean.SReplaceMoneyTypeSub;
/*      */ import mzm.gsp.awardpool.confbean.STypeId2RandomTextTableCfgId;
/*      */ import mzm.gsp.buff.main.BuffInterface;
/*      */ import mzm.gsp.buff.main.ProfitArg;
/*      */ import mzm.gsp.buff.main.ProfitResult;
/*      */ import mzm.gsp.item.SLotteryViewRandomResult;
/*      */ import mzm.gsp.item.SStartLotteryViewRes;
/*      */ import mzm.gsp.item.main.LotteryManager;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.open.main.OpenInterface;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.tlog.TLogArg;
/*      */ import mzm.gsp.tlog.TLogManager;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.util.LogicProcedure;
/*      */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.ItemSubid2Count;
/*      */ import xbean.Pod;
/*      */ import xdb.Xdb;
/*      */ import xtable.Role2itemsubid;
/*      */ 
/*      */ 
/*      */ 
/*      */ public class AwardPoolManager
/*      */ {
/*   60 */   static Logger logger = null;
/*      */   
/*      */   private static final float WAN = 10000.0F;
/*      */   
/*      */   static void init()
/*      */   {
/*   66 */     logger = Logger.getLogger(AwardPoolManager.class);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isSAwardPoolSumExists(int awardPoolSumId)
/*      */   {
/*   77 */     return SAwardPoolSum.get(awardPoolSumId) != null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isSAwardPoolLibExists(int awardpoollib)
/*      */   {
/*   89 */     return SAwardPoolLib.get(awardpoollib) != null;
/*      */   }
/*      */   
/*      */ 
/*      */   private static List<Integer> getMoneyPoolByAwardTypeId(int awardTypeId)
/*      */   {
/*   95 */     SAwardTypeId2MoneySubId awardTypeId2MoneySubId = SAwardTypeId2MoneySubId.get(awardTypeId);
/*      */     
/*   97 */     if ((awardTypeId2MoneySubId == null) || (awardTypeId2MoneySubId.moneySubIds.isEmpty()))
/*      */     {
/*   99 */       return new ArrayList();
/*      */     }
/*      */     
/*  102 */     List<Integer> moneyPoolSubs = new ArrayList();
/*  103 */     moneyPoolSubs.addAll(awardTypeId2MoneySubId.moneySubIds);
/*  104 */     return moneyPoolSubs;
/*      */   }
/*      */   
/*      */   private static List<Integer> getExpPoolByAwardTypeId(int awardTypeId)
/*      */   {
/*  109 */     SAwardTypeId2ExpSubId awardTypeId2ExpSubId = SAwardTypeId2ExpSubId.get(awardTypeId);
/*      */     
/*  111 */     if ((awardTypeId2ExpSubId == null) || (awardTypeId2ExpSubId.expSubIds.isEmpty()))
/*      */     {
/*  113 */       return new ArrayList();
/*      */     }
/*      */     
/*  116 */     List<Integer> expPoolSubs = new ArrayList();
/*  117 */     expPoolSubs.addAll(awardTypeId2ExpSubId.expSubIds);
/*  118 */     return expPoolSubs;
/*      */   }
/*      */   
/*      */   private static List<Integer> getItemPoolByAwardTypeId(int awardTypeId)
/*      */   {
/*  123 */     SAwardTypeId2ItemSubId awardTypeId2ItemSubId = SAwardTypeId2ItemSubId.get(awardTypeId);
/*      */     
/*  125 */     if ((awardTypeId2ItemSubId == null) || (awardTypeId2ItemSubId.itemSubIds.isEmpty()))
/*      */     {
/*  127 */       return new ArrayList();
/*      */     }
/*  129 */     List<Integer> itemPoolSubs = new ArrayList();
/*  130 */     itemPoolSubs.addAll(awardTypeId2ItemSubId.itemSubIds);
/*  131 */     return itemPoolSubs;
/*      */   }
/*      */   
/*      */   private static List<Integer> getControllerPoolByAwardTypeId(int awardTypeId)
/*      */   {
/*  136 */     SAwardTypeId2ControllerSubId awardTypeId2ControllerSubId = SAwardTypeId2ControllerSubId.get(awardTypeId);
/*      */     
/*  138 */     if ((awardTypeId2ControllerSubId == null) || (awardTypeId2ControllerSubId.controllerSubIds.isEmpty()))
/*      */     {
/*  140 */       return new ArrayList();
/*      */     }
/*  142 */     List<Integer> controllerPoolSubs = new ArrayList();
/*  143 */     controllerPoolSubs.addAll(awardTypeId2ControllerSubId.controllerSubIds);
/*  144 */     return controllerPoolSubs;
/*      */   }
/*      */   
/*      */   private static List<Integer> getReplaceMoneyPoolByAwardTypeId(int awardTypeId)
/*      */   {
/*  149 */     SAwardTypeId2ReplaceMoneySubId awardTypeId2ReplaceMoneySubId = SAwardTypeId2ReplaceMoneySubId.get(awardTypeId);
/*      */     
/*  151 */     if ((awardTypeId2ReplaceMoneySubId == null) || (awardTypeId2ReplaceMoneySubId.replaceMoneySubIds.isEmpty()))
/*      */     {
/*  153 */       return new ArrayList();
/*      */     }
/*  155 */     List<Integer> replaceMoneyTypeSubs = new ArrayList();
/*  156 */     replaceMoneyTypeSubs.addAll(awardTypeId2ReplaceMoneySubId.replaceMoneySubIds);
/*  157 */     return replaceMoneyTypeSubs;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean hasItem(int awardPoolSumId, int itemid)
/*      */   {
/*  169 */     SAwardPoolSum awardPoolSum = SAwardPoolSum.get(awardPoolSumId);
/*  170 */     List<Integer> itemPoolSubList = getItemPoolByAwardTypeId(awardPoolSum.awardTypeId);
/*  171 */     for (Iterator i$ = itemPoolSubList.iterator(); i$.hasNext();) { int id = ((Integer)i$.next()).intValue();
/*      */       
/*  173 */       SItemPoolSub i = SItemPoolSub.get(id);
/*  174 */       if (i.itemId == itemid)
/*      */       {
/*  176 */         return true;
/*      */       }
/*      */     }
/*  179 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static RandomDropResult randomPrecious(List<Integer> preciousItemSubids, boolean isFromRole)
/*      */   {
/*  191 */     if ((preciousItemSubids == null) || (preciousItemSubids.isEmpty()))
/*      */     {
/*  193 */       return null;
/*      */     }
/*  195 */     if (SItemPoolSub.get(((Integer)preciousItemSubids.get(0)).intValue()) != null)
/*      */     {
/*  197 */       int hitId = randomIdFromSItemPoolSubs(preciousItemSubids);
/*  198 */       if (hitId == -1)
/*      */       {
/*  200 */         return null;
/*      */       }
/*      */       
/*      */ 
/*  204 */       RandomDropResult randomDropResult = new RandomDropResult();
/*      */       
/*  206 */       randomDropResult.setHitItemSubId(hitId);
/*      */       
/*  208 */       if ((isFromRole) && (randomDropResult.getHitItemSubId() != -1) && (SItemPoolSub.get(randomDropResult.getHitItemSubId()) != null))
/*      */       {
/*      */ 
/*  211 */         Integer preciousCfgId = Integer.valueOf(SItemPoolSub.get(randomDropResult.getHitItemSubId()).preciousCfgId);
/*      */         
/*  213 */         if ((preciousCfgId != null) && (SPreciousDropCfg.get(preciousCfgId.intValue()) != null) && (SPreciousDropCfg.get(preciousCfgId.intValue()).roleDropType == 2))
/*      */         {
/*      */ 
/*      */ 
/*  217 */           List<Integer> newItemPoolSubList = getItemPoolByAwardTypeId(SPreciousDropCfg.get(preciousCfgId.intValue()).awardTypeId);
/*  218 */           int inDirectHitId = randomIdFromSItemPoolSubs(newItemPoolSubList);
/*      */           
/*  220 */           randomDropResult.setIn_direct_hitItemSubId(inDirectHitId);
/*      */         }
/*      */       }
/*      */       
/*      */ 
/*  225 */       return randomDropResult;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  231 */     int hitId = randomIdFromSRandomTextTableCfgs(preciousItemSubids);
/*  232 */     if (hitId == -1)
/*      */     {
/*  234 */       return null;
/*      */     }
/*      */     
/*      */ 
/*  238 */     RandomDropResult randomDropResult = new RandomDropResult();
/*  239 */     randomDropResult.setHitItemSubId(hitId);
/*      */     
/*  241 */     if ((isFromRole) && (randomDropResult.getHitItemSubId() != -1) && (SRandomTextTableCfg.get(randomDropResult.getHitItemSubId()) != null))
/*      */     {
/*      */ 
/*  244 */       Integer preciousCfgId = Integer.valueOf(SRandomTextTableCfg.get(randomDropResult.getHitItemSubId()).preciousCfgId);
/*      */       
/*  246 */       if ((preciousCfgId != null) && (SPreciousDropCfg.get(preciousCfgId.intValue()) != null) && (SPreciousDropCfg.get(preciousCfgId.intValue()).roleDropType == 2))
/*      */       {
/*      */ 
/*      */ 
/*  250 */         STypeId2RandomTextTableCfgId typeId2RandomTextTableCfgId = STypeId2RandomTextTableCfgId.get(SPreciousDropCfg.get(preciousCfgId.intValue()).awardTypeId);
/*  251 */         if (typeId2RandomTextTableCfgId != null)
/*      */         {
/*  253 */           List<Integer> newItemPoolSubList = typeId2RandomTextTableCfgId.randomTextTableCfgIds;
/*      */           
/*  255 */           int inDirectHitId = randomIdFromSRandomTextTableCfgs(newItemPoolSubList);
/*      */           
/*  257 */           randomDropResult.setIn_direct_hitItemSubId(inDirectHitId);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  264 */     return randomDropResult;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static int randomIdFromSItemPoolSubs(List<Integer> itemPoolSubs)
/*      */   {
/*  278 */     if ((itemPoolSubs == null) || (itemPoolSubs.isEmpty()))
/*      */     {
/*  280 */       return -1;
/*      */     }
/*  282 */     int i = Xdb.random().nextInt(itemPoolSubs.size());
/*  283 */     return ((Integer)itemPoolSubs.get(i)).intValue();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static int randomIdFromSRandomTextTableCfgs(List<Integer> randomTextTableCfgIds)
/*      */   {
/*  295 */     if ((randomTextTableCfgIds == null) || (randomTextTableCfgIds.isEmpty()))
/*      */     {
/*  297 */       return -1;
/*      */     }
/*  299 */     int i = Xdb.random().nextInt(randomTextTableCfgIds.size());
/*  300 */     return ((Integer)randomTextTableCfgIds.get(i)).intValue();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static List<Integer> computePrepareList(int outPutPrepareNum, int totalWeight, List<Integer> moneyPoolSubList, List<Integer> expPoolSubList, List<Integer> itemPoolSubList, List<Integer> controllerPoolSubList, List<Integer> replaceMoneyTypeSubList, boolean isFilterRepeat, Map<Integer, Integer> id2revisedWeight)
/*      */   {
/*  308 */     List<Integer> resultList = new ArrayList();
/*      */     
/*  310 */     for (int i = 0; i < outPutPrepareNum; i++)
/*      */     {
/*  312 */       int randNum = Xdb.random().nextInt(totalWeight);
/*  313 */       int count = 0;
/*  314 */       boolean isGot = false;
/*  315 */       for (int j = 0; j < moneyPoolSubList.size(); j++)
/*      */       {
/*  317 */         SMoneyPoolSub moneyPoolSub = SMoneyPoolSub.get(((Integer)moneyPoolSubList.get(j)).intValue());
/*  318 */         int weight = getWeight(id2revisedWeight, moneyPoolSub.weight, moneyPoolSub.id);
/*  319 */         count += weight;
/*  320 */         if (randNum < count)
/*      */         {
/*  322 */           resultList.add(Integer.valueOf(moneyPoolSub.id));
/*  323 */           if (isFilterRepeat)
/*      */           {
/*  325 */             totalWeight -= weight;
/*  326 */             moneyPoolSubList.remove(j);
/*      */           }
/*  328 */           isGot = true;
/*  329 */           break;
/*      */         }
/*      */       }
/*  332 */       if (!isGot)
/*      */       {
/*      */ 
/*      */ 
/*  336 */         for (int j = 0; j < expPoolSubList.size(); j++)
/*      */         {
/*  338 */           SExpPoolSub expPoolSub = SExpPoolSub.get(((Integer)expPoolSubList.get(j)).intValue());
/*  339 */           int weight = getWeight(id2revisedWeight, expPoolSub.weight, expPoolSub.id);
/*  340 */           count += weight;
/*  341 */           if (randNum < count)
/*      */           {
/*  343 */             resultList.add(Integer.valueOf(expPoolSub.id));
/*  344 */             if (isFilterRepeat)
/*      */             {
/*  346 */               totalWeight -= weight;
/*  347 */               expPoolSubList.remove(j);
/*      */             }
/*  349 */             isGot = true;
/*  350 */             break;
/*      */           }
/*      */         }
/*  353 */         if (!isGot)
/*      */         {
/*      */ 
/*      */ 
/*  357 */           for (int j = 0; j < itemPoolSubList.size(); j++)
/*      */           {
/*  359 */             SItemPoolSub itemPoolSub = SItemPoolSub.get(((Integer)itemPoolSubList.get(j)).intValue());
/*  360 */             int weight = getWeight(id2revisedWeight, itemPoolSub.weight, itemPoolSub.id);
/*  361 */             count += weight;
/*  362 */             if (randNum < count)
/*      */             {
/*  364 */               resultList.add(Integer.valueOf(itemPoolSub.id));
/*  365 */               if (isFilterRepeat)
/*      */               {
/*  367 */                 totalWeight -= weight;
/*  368 */                 itemPoolSubList.remove(j);
/*      */               }
/*  370 */               isGot = true;
/*  371 */               break;
/*      */             }
/*      */           }
/*  374 */           if (!isGot)
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*  379 */             for (int j = 0; j < controllerPoolSubList.size(); j++)
/*      */             {
/*  381 */               SControllerPoolSub controllerPoolSub = SControllerPoolSub.get(((Integer)controllerPoolSubList.get(j)).intValue());
/*  382 */               int weight = getWeight(id2revisedWeight, controllerPoolSub.weight, controllerPoolSub.id);
/*  383 */               count += weight;
/*  384 */               if (randNum < count)
/*      */               {
/*  386 */                 resultList.add(Integer.valueOf(controllerPoolSub.id));
/*  387 */                 if (isFilterRepeat)
/*      */                 {
/*  389 */                   totalWeight -= weight;
/*  390 */                   controllerPoolSubList.remove(j);
/*      */                 }
/*  392 */                 isGot = true;
/*  393 */                 break;
/*      */               }
/*      */             }
/*  396 */             if (!isGot)
/*      */             {
/*      */ 
/*      */ 
/*  400 */               for (int j = 0; j < replaceMoneyTypeSubList.size(); j++)
/*      */               {
/*  402 */                 SReplaceMoneyTypeSub replaceMoneyTypeSub = SReplaceMoneyTypeSub.get(((Integer)replaceMoneyTypeSubList.get(j)).intValue());
/*  403 */                 int weight = getWeight(id2revisedWeight, replaceMoneyTypeSub.weight, replaceMoneyTypeSub.id);
/*  404 */                 count += weight;
/*  405 */                 if (randNum < count)
/*      */                 {
/*  407 */                   resultList.add(Integer.valueOf(replaceMoneyTypeSub.id));
/*  408 */                   if (isFilterRepeat)
/*      */                   {
/*  410 */                     totalWeight -= weight;
/*  411 */                     replaceMoneyTypeSubList.remove(j);
/*      */                   }
/*  413 */                   isGot = true;
/*  414 */                   break;
/*      */                 }
/*      */               } }
/*      */           }
/*      */         } } }
/*  419 */     return resultList;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static AwardPoolResultData randomAwardPoolForRole(long roleId, List<Integer> buffEffectIds, int awardPoolSumId, boolean isQueryMode)
/*      */   {
/*  433 */     SAwardPoolSum awardPoolSum = SAwardPoolSum.get(awardPoolSumId);
/*  434 */     if (awardPoolSum == null)
/*      */     {
/*  436 */       return null;
/*      */     }
/*      */     
/*  439 */     Map<Integer, Integer> correctedWeightMap = WeightCorrectionManager.getPoolCorrectedWeightMap(roleId, awardPoolSumId);
/*      */     
/*      */ 
/*  442 */     AwardPoolResultData resultData = randomAwardPoolForRole(roleId, buffEffectIds, awardPoolSum, isQueryMode, correctedWeightMap);
/*      */     
/*      */ 
/*  445 */     WeightCorrectionManager.addPoolCount(roleId, awardPoolSumId);
/*  446 */     return resultData;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void addDropCount(long roleId, int hitPreciousItemSubid, ItemSubid2Count xItemSubid2Count)
/*      */   {
/*  458 */     ItemSubidObject itemSubidObject = ItemSubIdDropcCounter.getInstance().getItemSubidObject(hitPreciousItemSubid);
/*  459 */     if (itemSubidObject != null)
/*      */     {
/*  461 */       itemSubidObject.addDropCount();
/*      */     }
/*      */     
/*  464 */     RolePreciousDropManager.addRoleDropCount(roleId, Arrays.asList(new Integer[] { Integer.valueOf(hitPreciousItemSubid) }), xItemSubid2Count);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static int getPreciousDropFromRoleOrServer(long roleId, Map<Integer, Integer> itemSubId2PrecioisCfgId, ItemSubid2Count xItemSubid2Count)
/*      */   {
/*  477 */     int hitPreciousItemSubid = -1;
/*  478 */     if ((itemSubId2PrecioisCfgId == null) || (itemSubId2PrecioisCfgId.isEmpty()))
/*      */     {
/*  480 */       return hitPreciousItemSubid;
/*      */     }
/*  482 */     List<Integer> canRandomPrecious = RolePreciousDropManager.getPreciousItemSubIdsFrom(itemSubId2PrecioisCfgId, xItemSubid2Count);
/*      */     
/*  484 */     if ((canRandomPrecious == null) || (canRandomPrecious.isEmpty()))
/*      */     {
/*  486 */       canRandomPrecious = getPreciousItemSubIds(itemSubId2PrecioisCfgId);
/*  487 */       if ((canRandomPrecious != null) && (!canRandomPrecious.isEmpty()))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  495 */         RandomDropResult randomDropResult = randomPrecious(canRandomPrecious, false);
/*      */         
/*  497 */         if ((randomDropResult != null) && (randomDropResult.getHitItemSubId() != -1))
/*      */         {
/*  499 */           hitPreciousItemSubid = randomDropResult.getHitItemSubId();
/*      */           
/*  501 */           addDropCount(roleId, randomDropResult.getHitItemSubId(), xItemSubid2Count);
/*      */           
/*  503 */           itemSubId2PrecioisCfgId.remove(Integer.valueOf(randomDropResult.getHitItemSubId()));
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/*  510 */       RandomDropResult randomDropResult = randomPrecious(canRandomPrecious, true);
/*      */       
/*  512 */       if ((randomDropResult != null) && (randomDropResult.getHitItemSubId() != -1))
/*      */       {
/*  514 */         if (randomDropResult.getIn_direct_hitItemSubId() != -1)
/*      */         {
/*  516 */           hitPreciousItemSubid = randomDropResult.getIn_direct_hitItemSubId();
/*      */ 
/*      */         }
/*      */         else
/*      */         {
/*  521 */           hitPreciousItemSubid = randomDropResult.getHitItemSubId();
/*      */         }
/*      */         
/*  524 */         addDropCount(roleId, randomDropResult.getHitItemSubId(), xItemSubid2Count);
/*      */         
/*  526 */         itemSubId2PrecioisCfgId.remove(Integer.valueOf(randomDropResult.getHitItemSubId()));
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  531 */     return hitPreciousItemSubid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static Map<Integer, Integer> getTotalItemSubId2PrecioisCfgId(int awardTypeId)
/*      */   {
/*  542 */     Map<Integer, Integer> itemSubId2PrecioisCfgId = new HashMap();
/*  543 */     SAwardTypeId2PreciousItemSubId sAwardTypeId2PreciousItemSubId = SAwardTypeId2PreciousItemSubId.get(awardTypeId);
/*  544 */     Iterator i$; if (sAwardTypeId2PreciousItemSubId != null)
/*      */     {
/*      */ 
/*  547 */       for (i$ = sAwardTypeId2PreciousItemSubId.itemSubIds.iterator(); i$.hasNext();) { int itemsubid = ((Integer)i$.next()).intValue();
/*      */         
/*  549 */         itemSubId2PrecioisCfgId.put(Integer.valueOf(itemsubid), Integer.valueOf(SItemPoolSub.get(itemsubid).preciousCfgId));
/*      */       }
/*      */     }
/*  552 */     return itemSubId2PrecioisCfgId;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static AwardPoolResultData randomAwardPoolForRole(long roleid, List<Integer> buffEffectIds, SAwardPoolSum awardPoolSum, boolean isQueryMode, Map<Integer, Integer> id2revisedWeight)
/*      */   {
/*  566 */     Set<Integer> buffEffectIdSet = new HashSet();
/*  567 */     if (buffEffectIds != null)
/*      */     {
/*  569 */       buffEffectIdSet.addAll(buffEffectIds);
/*      */     }
/*  571 */     Map<Integer, Set<Integer>> buffMap = AwardInterface.getAwardType2ConIds(buffEffectIdSet);
/*      */     
/*  573 */     List<Integer> moneyPoolSubList = getMoneyPoolByAwardTypeId(awardPoolSum.awardTypeId);
/*  574 */     List<Integer> expPoolSubList = getExpPoolByAwardTypeId(awardPoolSum.awardTypeId);
/*  575 */     List<Integer> itemPoolSubList = getItemPoolByAwardTypeId(awardPoolSum.awardTypeId);
/*  576 */     List<Integer> controllerPoolSubList = getControllerPoolByAwardTypeId(awardPoolSum.awardTypeId);
/*  577 */     List<Integer> replaceMoneyTypeSubList = getReplaceMoneyPoolByAwardTypeId(awardPoolSum.awardTypeId);
/*      */     
/*  579 */     Map<Integer, Integer> itemSubId2PrecioisCfgId = getTotalItemSubId2PrecioisCfgId(awardPoolSum.awardTypeId);
/*  580 */     ItemSubid2Count xItemSubid2Count = Role2itemsubid.get(Long.valueOf(roleid));
/*  581 */     if (xItemSubid2Count == null)
/*      */     {
/*  583 */       xItemSubid2Count = Pod.newItemSubid2Count();
/*  584 */       Role2itemsubid.insert(Long.valueOf(roleid), xItemSubid2Count);
/*      */     }
/*      */     
/*  587 */     int hitPreciousItemSubid = -1;
/*  588 */     boolean isOpenPrecious = !isQueryMode & isPreciousDropSwitchOpenForRole();
/*  589 */     if (isOpenPrecious)
/*      */     {
/*      */ 
/*  592 */       for (Integer itemSubId : id2revisedWeight.keySet())
/*      */       {
/*  594 */         if (((Integer)id2revisedWeight.get(itemSubId)).intValue() == 0)
/*  595 */           itemSubId2PrecioisCfgId.remove(itemSubId);
/*      */       }
/*  597 */       hitPreciousItemSubid = getPreciousDropFromRoleOrServer(roleid, itemSubId2PrecioisCfgId, xItemSubid2Count);
/*      */     }
/*      */     
/*  600 */     AwardPoolResultData resultData = computeAwardPoolResultData(Long.valueOf(roleid), buffMap, awardPoolSum, hitPreciousItemSubid, itemSubId2PrecioisCfgId, moneyPoolSubList, expPoolSubList, itemPoolSubList, controllerPoolSubList, replaceMoneyTypeSubList, xItemSubid2Count, isOpenPrecious, id2revisedWeight);
/*      */     
/*      */ 
/*      */ 
/*  604 */     if (isOpenPrecious)
/*      */     {
/*      */ 
/*  607 */       addRoleAndServerUnHitCount(roleid, itemSubId2PrecioisCfgId, xItemSubid2Count);
/*      */     }
/*      */     
/*  610 */     return resultData;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static void addRoleAndServerUnHitCount(long roleId, Map<Integer, Integer> itemSubId2PrecioisCfgId, ItemSubid2Count xItemSubid2Count)
/*      */   {
/*  617 */     RolePreciousDropManager.addRoleUnHitCount(roleId, itemSubId2PrecioisCfgId, xItemSubid2Count);
/*  618 */     addServerUnHitCount(itemSubId2PrecioisCfgId);
/*      */   }
/*      */   
/*      */   private static void addServerUnHitCount(Map<Integer, Integer> itemSubId2PrecioisCfgId) {
/*      */     Iterator i$;
/*  623 */     if ((itemSubId2PrecioisCfgId != null) && (!itemSubId2PrecioisCfgId.isEmpty()))
/*      */     {
/*  625 */       for (i$ = itemSubId2PrecioisCfgId.keySet().iterator(); i$.hasNext();) { int unhit = ((Integer)i$.next()).intValue();
/*      */         
/*  627 */         ItemSubidObject itemSubidObject = ItemSubIdDropcCounter.getInstance().getItemSubidObject(unhit);
/*  628 */         if (itemSubidObject != null)
/*      */         {
/*  630 */           itemSubidObject.addUnHitCount();
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static AwardPoolResultData randomAwardPoolResultData(int poolTypeId, int level, boolean isQueryModel)
/*      */   {
/*  645 */     SAwardPoolMainTable sAwardPoolMainTable = getAwardPoolSumIdByLevel(poolTypeId, level);
/*  646 */     if (sAwardPoolMainTable == null)
/*      */     {
/*  648 */       return null;
/*      */     }
/*  650 */     SAwardPoolSum awardPoolSum = SAwardPoolSum.get(sAwardPoolMainTable.awardPoolSumId);
/*  651 */     if (awardPoolSum == null)
/*      */     {
/*  653 */       return null;
/*      */     }
/*  655 */     return randomAwardPoolResultData(awardPoolSum, isQueryModel);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static AwardPoolResultData randomAwardPoolResultData(SAwardPoolSum awardPoolSum, boolean isQueryMode)
/*      */   {
/*  668 */     List<Integer> moneyPoolSubList = getMoneyPoolByAwardTypeId(awardPoolSum.awardTypeId);
/*  669 */     List<Integer> expPoolSubList = getExpPoolByAwardTypeId(awardPoolSum.awardTypeId);
/*  670 */     List<Integer> itemPoolSubList = getItemPoolByAwardTypeId(awardPoolSum.awardTypeId);
/*  671 */     List<Integer> controllerPoolSubList = getControllerPoolByAwardTypeId(awardPoolSum.awardTypeId);
/*  672 */     List<Integer> replaceMoneyTypeSubList = getReplaceMoneyPoolByAwardTypeId(awardPoolSum.awardTypeId);
/*      */     
/*  674 */     Map<Integer, Integer> itemSubId2PrecioisCfgId = getTotalItemSubId2PrecioisCfgId(awardPoolSum.awardTypeId);
/*      */     
/*  676 */     boolean isOpenPrecious = !isQueryMode & isPreciousDropSwitchOpenForRole();
/*  677 */     int hitPreciousItemSubid = -1;
/*  678 */     if (isOpenPrecious)
/*      */     {
/*  680 */       List<Integer> canRandomPrecious = getPreciousItemSubIds(itemSubId2PrecioisCfgId);
/*  681 */       if ((canRandomPrecious != null) && (!canRandomPrecious.isEmpty()))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  686 */         RandomDropResult randomDropResult = randomPrecious(canRandomPrecious, false);
/*      */         
/*  688 */         if ((randomDropResult != null) && (randomDropResult.getHitItemSubId() != -1))
/*      */         {
/*  690 */           hitPreciousItemSubid = randomDropResult.getHitItemSubId();
/*  691 */           ItemSubidObject itemSubidObject = ItemSubIdDropcCounter.getInstance().getItemSubidObject(hitPreciousItemSubid);
/*      */           
/*  693 */           if (itemSubidObject != null)
/*      */           {
/*  695 */             itemSubidObject.addDropCount();
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  702 */     AwardPoolResultData resultData = computeAwardPoolResultData(null, null, awardPoolSum, hitPreciousItemSubid, itemSubId2PrecioisCfgId, moneyPoolSubList, expPoolSubList, itemPoolSubList, controllerPoolSubList, replaceMoneyTypeSubList, null, isOpenPrecious, null);
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  707 */     if (isOpenPrecious)
/*      */     {
/*  709 */       addServerUnHitCount(itemSubId2PrecioisCfgId);
/*      */     }
/*      */     
/*  712 */     return resultData;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static AwardPoolResultData computeAwardPoolResultData(Long roleId, Map<Integer, Set<Integer>> buffMap, SAwardPoolSum awardPoolSum, int hitPreciousItemSubid, Map<Integer, Integer> itemSubId2PrecioisCfgId, List<Integer> moneyPoolSubList, List<Integer> expPoolSubList, List<Integer> itemPoolSubList, List<Integer> controllerPoolSubList, List<Integer> replaceMoneyTypeSubList, ItemSubid2Count xItemSubid2Count, boolean isOpenPrecious, Map<Integer, Integer> id2revisedWeight)
/*      */   {
/*  721 */     int outPutPrepareNum = awardPoolSum.initNum;
/*  722 */     int resultNum = awardPoolSum.resultNum;
/*  723 */     if ((hitPreciousItemSubid != -1) && (itemSubId2PrecioisCfgId != null) && (isOpenPrecious))
/*      */     {
/*      */ 
/*  726 */       itemPoolSubList.removeAll(itemSubId2PrecioisCfgId.keySet());
/*  727 */       itemPoolSubList.remove(Integer.valueOf(hitPreciousItemSubid));
/*      */       
/*  729 */       outPutPrepareNum--;
/*  730 */       resultNum--;
/*      */     }
/*      */     
/*  733 */     int totalWeight = computeTotalWeight(moneyPoolSubList, expPoolSubList, itemPoolSubList, controllerPoolSubList, replaceMoneyTypeSubList, id2revisedWeight);
/*      */     
/*  735 */     List<Integer> initList = computePrepareList(outPutPrepareNum, totalWeight, moneyPoolSubList, expPoolSubList, itemPoolSubList, controllerPoolSubList, replaceMoneyTypeSubList, awardPoolSum.isFilterRepeat, id2revisedWeight);
/*      */     
/*  737 */     List<Integer> resultList = getResultAwardPools(resultNum, initList);
/*      */     
/*  739 */     AwardPoolResultData resultData = new AwardPoolResultData();
/*      */     
/*  741 */     if (roleId != null)
/*      */     {
/*  743 */       fillAwardPoolResultData(roleId.longValue(), resultData, hitPreciousItemSubid, initList, resultList, itemSubId2PrecioisCfgId, buffMap, xItemSubid2Count, isOpenPrecious);
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/*      */ 
/*  749 */       fillAwardPoolResultData(resultData, hitPreciousItemSubid, initList, resultList, itemSubId2PrecioisCfgId, isOpenPrecious);
/*      */     }
/*      */     
/*      */ 
/*  753 */     return resultData;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void checkResultListAndSetUnHitCount(List<Integer> resultList, Map<Integer, Integer> itemSubId2PreciousId, ItemSubid2Count xItemSubid2Count)
/*      */   {
/*  765 */     for (Iterator i$ = resultList.iterator(); i$.hasNext();) { int hitid = ((Integer)i$.next()).intValue();
/*      */       
/*  767 */       int precoiousCfgId = getPreciousCfgId(hitid);
/*      */       
/*  769 */       if ((precoiousCfgId != -1) && (SPreciousDropCfg.get(precoiousCfgId) != null))
/*      */       {
/*  771 */         ItemSubidObject itemSubidObject = ItemSubIdDropcCounter.getInstance().getItemSubidObject(hitid);
/*  772 */         if (itemSubidObject != null)
/*      */         {
/*  774 */           itemSubidObject.setUnHitCount(0);
/*      */         }
/*  776 */         if (xItemSubid2Count != null)
/*      */         {
/*  778 */           RolePreciousDropManager.setUnHitCount(Arrays.asList(new Integer[] { Integer.valueOf(hitid) }), xItemSubid2Count, 0);
/*      */         }
/*      */         
/*  781 */         itemSubId2PreciousId.remove(Integer.valueOf(hitid));
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void fillAwardPoolResultData(AwardPoolResultData resultData, int hitPreciousItemSubid, List<Integer> initList, List<Integer> resultList, Map<Integer, Integer> itemSubId2PreciousId, boolean isOpenPrecious)
/*      */   {
/*  791 */     if ((hitPreciousItemSubid != -1) && (isOpenPrecious))
/*      */     {
/*  793 */       resultList.add(Integer.valueOf(hitPreciousItemSubid));
/*  794 */       initList.add(Integer.valueOf(hitPreciousItemSubid));
/*      */     }
/*      */     
/*  797 */     resultData.addPrepareSubPoolIds(initList);
/*  798 */     resultData.addFinalSubPoolIds(resultList);
/*      */     
/*  800 */     if (isOpenPrecious)
/*      */     {
/*  802 */       checkResultListAndSetUnHitCount(resultList, itemSubId2PreciousId, null);
/*      */     }
/*      */     
/*  805 */     for (Integer subPoolId : resultList)
/*      */     {
/*  807 */       if (SMoneyPoolSub.get(subPoolId.intValue()) != null)
/*      */       {
/*  809 */         fillMoney(SMoneyPoolSub.get(subPoolId.intValue()), resultData);
/*      */       }
/*  811 */       else if (SExpPoolSub.get(subPoolId.intValue()) != null)
/*      */       {
/*      */ 
/*  814 */         fillExp(SExpPoolSub.get(subPoolId.intValue()), resultData);
/*      */       }
/*  816 */       else if (SItemPoolSub.get(subPoolId.intValue()) != null)
/*      */       {
/*  818 */         fillItem(SItemPoolSub.get(subPoolId.intValue()), resultData);
/*      */       }
/*  820 */       else if (SControllerPoolSub.get(subPoolId.intValue()) != null)
/*      */       {
/*  822 */         fillController(SControllerPoolSub.get(subPoolId.intValue()), resultData);
/*      */ 
/*      */       }
/*  825 */       else if (SReplaceMoneyTypeSub.get(subPoolId.intValue()) != null)
/*      */       {
/*  827 */         fillReplaceMoneyType(SReplaceMoneyTypeSub.get(subPoolId.intValue()));
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void fillAwardPoolResultData(long roleid, AwardPoolResultData resultData, int hitPreciousItemSubid, List<Integer> initList, List<Integer> resultList, Map<Integer, Integer> itemSubId2PreciousId, Map<Integer, Set<Integer>> buffMap, ItemSubid2Count xItemSubid2Count, boolean isOpenPrecious)
/*      */   {
/*  837 */     if ((hitPreciousItemSubid != -1) && (isOpenPrecious))
/*      */     {
/*  839 */       resultList.add(Integer.valueOf(hitPreciousItemSubid));
/*  840 */       initList.add(Integer.valueOf(hitPreciousItemSubid));
/*      */     }
/*      */     
/*  843 */     resultData.addPrepareSubPoolIds(initList);
/*  844 */     resultData.addFinalSubPoolIds(resultList);
/*      */     
/*  846 */     if (isOpenPrecious)
/*      */     {
/*  848 */       checkResultListAndSetUnHitCount(resultList, itemSubId2PreciousId, xItemSubid2Count);
/*      */     }
/*      */     
/*  851 */     for (Integer subPoolId : resultList)
/*      */     {
/*  853 */       if (SMoneyPoolSub.get(subPoolId.intValue()) != null)
/*      */       {
/*  855 */         fillMoney(roleid, SMoneyPoolSub.get(subPoolId.intValue()), resultData, buffMap);
/*      */       }
/*  857 */       else if (SExpPoolSub.get(subPoolId.intValue()) != null)
/*      */       {
/*      */ 
/*  860 */         fillExp(roleid, SExpPoolSub.get(subPoolId.intValue()), resultData, buffMap);
/*      */       }
/*  862 */       else if (SItemPoolSub.get(subPoolId.intValue()) != null)
/*      */       {
/*  864 */         fillItem(roleid, SItemPoolSub.get(subPoolId.intValue()), resultData, buffMap);
/*      */       }
/*  866 */       else if (SControllerPoolSub.get(subPoolId.intValue()) != null)
/*      */       {
/*  868 */         fillController(roleid, SControllerPoolSub.get(subPoolId.intValue()), resultData, buffMap);
/*      */ 
/*      */       }
/*  871 */       else if (SReplaceMoneyTypeSub.get(subPoolId.intValue()) != null)
/*      */       {
/*  873 */         fillReplaceMoneyType(roleid, SReplaceMoneyTypeSub.get(subPoolId.intValue()), buffMap);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static int computeTotalWeight(List<Integer> moneyPoolSubList, List<Integer> expPoolSubList, List<Integer> itemPoolSubList, List<Integer> controllerPoolSubList, List<Integer> replaceMoneyTypeSubList, Map<Integer, Integer> id2revisedWeight)
/*      */   {
/*  883 */     int weight = 0;
/*  884 */     Iterator i$; if (moneyPoolSubList != null)
/*      */     {
/*  886 */       for (i$ = moneyPoolSubList.iterator(); i$.hasNext();) { int id = ((Integer)i$.next()).intValue();
/*      */         
/*  888 */         SMoneyPoolSub moneyPoolSub = SMoneyPoolSub.get(id);
/*  889 */         weight += getWeight(id2revisedWeight, moneyPoolSub.weight, moneyPoolSub.id);
/*      */       } }
/*      */     Iterator i$;
/*  892 */     if (expPoolSubList != null)
/*      */     {
/*  894 */       for (i$ = expPoolSubList.iterator(); i$.hasNext();) { int id = ((Integer)i$.next()).intValue();
/*      */         
/*  896 */         SExpPoolSub expPoolSub = SExpPoolSub.get(id);
/*  897 */         weight += getWeight(id2revisedWeight, expPoolSub.weight, expPoolSub.id);
/*      */       }
/*      */     }
/*      */     Iterator i$;
/*  901 */     if (itemPoolSubList != null)
/*      */     {
/*  903 */       for (i$ = itemPoolSubList.iterator(); i$.hasNext();) { int id = ((Integer)i$.next()).intValue();
/*      */         
/*  905 */         SItemPoolSub itemPoolSub = SItemPoolSub.get(id);
/*  906 */         weight += getWeight(id2revisedWeight, itemPoolSub.weight, itemPoolSub.id);
/*      */       } }
/*      */     Iterator i$;
/*  909 */     if (controllerPoolSubList != null)
/*      */     {
/*  911 */       for (i$ = controllerPoolSubList.iterator(); i$.hasNext();) { int id = ((Integer)i$.next()).intValue();
/*      */         
/*  913 */         SControllerPoolSub controllerPoolSub = SControllerPoolSub.get(id);
/*  914 */         weight += getWeight(id2revisedWeight, controllerPoolSub.weight, controllerPoolSub.id);
/*      */       }
/*      */     }
/*      */     Iterator i$;
/*  918 */     if (replaceMoneyTypeSubList != null)
/*      */     {
/*  920 */       for (i$ = replaceMoneyTypeSubList.iterator(); i$.hasNext();) { int id = ((Integer)i$.next()).intValue();
/*      */         
/*  922 */         SReplaceMoneyTypeSub replaceMoneyTypeSub = SReplaceMoneyTypeSub.get(id);
/*  923 */         weight += getWeight(id2revisedWeight, replaceMoneyTypeSub.weight, replaceMoneyTypeSub.id);
/*      */       }
/*      */     }
/*      */     
/*  927 */     return weight;
/*      */   }
/*      */   
/*      */   private static int getWeight(Map<Integer, Integer> id2revisedWeight, int cfgWeight, int cfgId)
/*      */   {
/*  932 */     if (id2revisedWeight == null)
/*      */     {
/*  934 */       return cfgWeight;
/*      */     }
/*  936 */     if (id2revisedWeight.containsKey(Integer.valueOf(cfgId)))
/*      */     {
/*  938 */       return ((Integer)id2revisedWeight.get(Integer.valueOf(cfgId))).intValue();
/*      */     }
/*      */     
/*      */ 
/*  942 */     return cfgWeight;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static List<Integer> getResultAwardPools(int resultNum, List<Integer> initList)
/*      */   {
/*  957 */     ArrayList<Integer> copyInitList = new ArrayList(initList);
/*  958 */     ArrayList<Integer> resultList = new ArrayList();
/*      */     
/*  960 */     for (int i = 0; i < Math.min(initList.size(), resultNum); i++)
/*      */     {
/*  962 */       int c = Xdb.random().nextInt(copyInitList.size());
/*  963 */       resultList.add(copyInitList.get(c));
/*  964 */       copyInitList.remove(c);
/*      */     }
/*  966 */     return resultList;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static SAwardPoolMainTable getAwardPoolSumIdByLevel(int poolTypeId, int level)
/*      */   {
/*  979 */     SPoolTypeId2AwardPoolMainTableId pooltAwardPoolMainTableId = SPoolTypeId2AwardPoolMainTableId.get(poolTypeId);
/*  980 */     if ((pooltAwardPoolMainTableId == null) || (pooltAwardPoolMainTableId.mainTableIds.isEmpty()))
/*      */     {
/*  982 */       return null;
/*      */     }
/*      */     
/*  985 */     for (Iterator i$ = pooltAwardPoolMainTableId.mainTableIds.iterator(); i$.hasNext();) { int id = ((Integer)i$.next()).intValue();
/*      */       
/*  987 */       SAwardPoolMainTable mainTable = SAwardPoolMainTable.get(id);
/*  988 */       if ((mainTable.minLevel <= level) && (level <= mainTable.maxLevel))
/*      */       {
/*      */ 
/*  991 */         return mainTable;
/*      */       }
/*      */     }
/*      */     
/*  995 */     return null;
/*      */   }
/*      */   
/*      */   static boolean isSMoneyPoolSub(int id)
/*      */   {
/* 1000 */     return SMoneyPoolSub.get(id) != null;
/*      */   }
/*      */   
/*      */   static boolean isSItemPoolSub(int id)
/*      */   {
/* 1005 */     return SItemPoolSub.get(id) != null;
/*      */   }
/*      */   
/*      */   static boolean isSExpPoolSub(int id)
/*      */   {
/* 1010 */     return SExpPoolSub.get(id) != null;
/*      */   }
/*      */   
/*      */   static boolean isSControllerPoolSub(int id)
/*      */   {
/* 1015 */     return SControllerPoolSub.get(id) != null;
/*      */   }
/*      */   
/*      */   static boolean isSReplaceMoneyTypeSub(int id)
/*      */   {
/* 1020 */     return SReplaceMoneyTypeSub.get(id) != null;
/*      */   }
/*      */   
/*      */   static List<Integer> getItemId2NumMap(List<Integer> itemSubIds)
/*      */   {
/* 1025 */     List<Integer> itemids = new ArrayList();
/* 1026 */     for (Iterator i$ = itemSubIds.iterator(); i$.hasNext();) { int id = ((Integer)i$.next()).intValue();
/*      */       
/* 1028 */       if (SItemPoolSub.get(id) != null)
/*      */       {
/* 1030 */         itemids.add(Integer.valueOf(SItemPoolSub.get(id).itemId));
/*      */       }
/*      */     }
/*      */     
/* 1034 */     return itemids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static int computeLotteryTotalWeightAndFindRandomTextCfgIds(SLotteryViewRandomCfg lotteryViewRandomCfg, List<Integer> randomTextCfgIds, Map<Integer, Integer> preciousRandomTextCfgIds, Map<Integer, Integer> id2revisedWeight, List<Integer> removeSubIds, List<Integer> removeTypeIds)
/*      */   {
/* 1041 */     int totalWeight = 0;
/*      */     
/* 1043 */     for (Iterator i$ = lotteryViewRandomCfg.typeIds.iterator(); i$.hasNext();) { int typeid = ((Integer)i$.next()).intValue();
/*      */       
/* 1045 */       if ((removeTypeIds == null) || (!removeTypeIds.contains(Integer.valueOf(typeid))))
/*      */       {
/*      */ 
/*      */ 
/* 1049 */         STypeId2RandomTextTableCfgId typeId2RandomTextTableCfgId = STypeId2RandomTextTableCfgId.get(typeid);
/* 1050 */         if (typeId2RandomTextTableCfgId == null)
/*      */         {
/* 1052 */           String logStr = String.format("[awardpool]AwardPoolManager.computeLotteryTotalWeightAndFindRandomTextCfgIds@STypeId2RandomTextTableCfgId get null|lotteryViewId=%d|typeid=%d", new Object[] { Integer.valueOf(lotteryViewRandomCfg.id), Integer.valueOf(typeid) });
/*      */           
/*      */ 
/*      */ 
/* 1056 */           logger.error(logStr);
/*      */         }
/*      */         else {
/* 1059 */           List<Integer> randomTextTableCfgIds = typeId2RandomTextTableCfgId.randomTextTableCfgIds;
/* 1060 */           for (i$ = randomTextTableCfgIds.iterator(); i$.hasNext();) { int cfgid = ((Integer)i$.next()).intValue();
/*      */             
/* 1062 */             SRandomTextTableCfg randomTextTableCfg = SRandomTextTableCfg.get(cfgid);
/* 1063 */             if ((removeSubIds == null) || (!removeSubIds.contains(Integer.valueOf(cfgid))))
/*      */             {
/*      */ 
/*      */ 
/* 1067 */               totalWeight += getWeight(id2revisedWeight, randomTextTableCfg.weight, randomTextTableCfg.id);
/* 1068 */               if (SPreciousDropCfg.get(randomTextTableCfg.preciousCfgId) != null)
/*      */               {
/* 1070 */                 preciousRandomTextCfgIds.put(Integer.valueOf(cfgid), Integer.valueOf(randomTextTableCfg.preciousCfgId));
/*      */               }
/* 1072 */               randomTextCfgIds.add(Integer.valueOf(cfgid));
/*      */             }
/*      */           } } } }
/*      */     Iterator i$;
/* 1076 */     return totalWeight;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static List<AwardPoolResultData> getLotteryResultData(long roleId, List<Integer> lotteryViewIds, boolean isQueryMode, List<Integer> removeSubIds, List<Integer> removeTypeIds)
/*      */   {
/* 1090 */     List<AwardPoolResultData> resultDataList = new LinkedList();
/* 1091 */     for (Iterator i$ = lotteryViewIds.iterator(); i$.hasNext();) { int lotteryViewId = ((Integer)i$.next()).intValue();
/*      */       
/*      */ 
/* 1094 */       Map<Integer, Integer> correctedWeightMap = WeightCorrectionManager.getLotteryCorrectedWeightMap(roleId, lotteryViewId);
/*      */       
/*      */ 
/* 1097 */       AwardPoolResultData resultData = getLotteryResultData(roleId, lotteryViewId, isQueryMode, correctedWeightMap, removeSubIds, removeTypeIds);
/*      */       
/* 1099 */       resultDataList.add(resultData);
/*      */     }
/*      */     
/* 1102 */     WeightCorrectionManager.addLotteryCount(roleId, lotteryViewIds);
/* 1103 */     return resultDataList;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static AwardPoolResultData getLotteryResultData(long roleid, int lotteryViewId, boolean isQueryMode, Map<Integer, Integer> id2revisedWeight, List<Integer> removeSubIds, List<Integer> removeTypeIds)
/*      */   {
/* 1120 */     SLotteryViewRandomCfg lotteryViewRandomCfg = SLotteryViewRandomCfg.get(lotteryViewId);
/* 1121 */     if (lotteryViewRandomCfg == null)
/*      */     {
/* 1123 */       return null;
/*      */     }
/* 1125 */     List<Integer> randomTextCfgIds = new ArrayList();
/* 1126 */     Map<Integer, Integer> itemSubId2PrecioisCfgId = new HashMap();
/* 1127 */     int totalWeight = computeLotteryTotalWeightAndFindRandomTextCfgIds(lotteryViewRandomCfg, randomTextCfgIds, itemSubId2PrecioisCfgId, id2revisedWeight, removeSubIds, removeTypeIds);
/*      */     
/* 1129 */     ItemSubid2Count xItemSubid2Count = Role2itemsubid.get(Long.valueOf(roleid));
/* 1130 */     if (xItemSubid2Count == null)
/*      */     {
/* 1132 */       xItemSubid2Count = Pod.newItemSubid2Count();
/* 1133 */       Role2itemsubid.insert(Long.valueOf(roleid), xItemSubid2Count);
/*      */     }
/* 1135 */     boolean isOpenPrecious = !isQueryMode & isPreciousDropSwitchOpenForRole();
/* 1136 */     int hitPreciousItemSubid = -1;
/* 1137 */     if (isOpenPrecious)
/*      */     {
/*      */ 
/* 1140 */       for (Integer itemSubId : id2revisedWeight.keySet())
/*      */       {
/* 1142 */         if (((Integer)id2revisedWeight.get(itemSubId)).intValue() == 0)
/* 1143 */           itemSubId2PrecioisCfgId.remove(itemSubId);
/*      */       }
/* 1145 */       hitPreciousItemSubid = getPreciousDropFromRoleOrServer(roleid, itemSubId2PrecioisCfgId, xItemSubid2Count);
/*      */     }
/*      */     
/* 1148 */     AwardPoolResultData resultData = new AwardPoolResultData();
/*      */     
/* 1150 */     if ((hitPreciousItemSubid != -1) && (SRandomTextTableCfg.get(hitPreciousItemSubid) != null) && (isOpenPrecious))
/*      */     {
/* 1152 */       SRandomTextTableCfg r = SRandomTextTableCfg.get(hitPreciousItemSubid);
/* 1153 */       fillLotteryRandomResult(resultData, lotteryViewId, r);
/*      */     }
/*      */     else
/*      */     {
/* 1157 */       int randomnum = Xdb.random().nextInt(totalWeight);
/* 1158 */       int c = 0;
/* 1159 */       for (int i = 0; i < randomTextCfgIds.size(); i++)
/*      */       {
/* 1161 */         SRandomTextTableCfg r = SRandomTextTableCfg.get(((Integer)randomTextCfgIds.get(i)).intValue());
/* 1162 */         c += getWeight(id2revisedWeight, r.weight, r.id);
/* 1163 */         if (randomnum < c)
/*      */         {
/* 1165 */           fillLotteryRandomResult(resultData, lotteryViewId, r);
/* 1166 */           if (!isOpenPrecious)
/*      */             break;
/* 1168 */           checkResultListAndSetUnHitCount(Arrays.asList(new Integer[] { Integer.valueOf(r.id) }), itemSubId2PrecioisCfgId, xItemSubid2Count);
/* 1169 */           itemSubId2PrecioisCfgId.remove(Integer.valueOf(r.id)); break;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1176 */     if (isOpenPrecious)
/*      */     {
/* 1178 */       addRoleAndServerUnHitCount(roleid, itemSubId2PrecioisCfgId, xItemSubid2Count);
/*      */     }
/*      */     
/* 1181 */     return resultData;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static void fillLotteryRandomResult(AwardPoolResultData resultData, int lotteryViewId, SRandomTextTableCfg r)
/*      */   {
/* 1188 */     resultData.addItem(r.itemId, r.itemNum);
/* 1189 */     resultData.setIndex(SLotteryViewRandomCfg.get(lotteryViewId).typeIds.indexOf(Integer.valueOf(r.typeId)));
/* 1190 */     resultData.addFinalSubPoolIds(r.id);
/* 1191 */     resultData.setTypeId(r.typeId);
/*      */     
/* 1193 */     int moneynum = r.minMoneyNum;
/* 1194 */     if (r.maxMoneyNum > r.minMoneyNum)
/*      */     {
/* 1196 */       moneynum += Xdb.random().nextInt(r.maxMoneyNum - r.minMoneyNum);
/*      */     }
/*      */     
/* 1199 */     if (r.moneyType == 2)
/*      */     {
/* 1201 */       resultData.setGold(moneynum);
/*      */     }
/* 1203 */     else if (r.moneyType == 3)
/*      */     {
/* 1205 */       resultData.setSilver(moneynum);
/*      */     }
/* 1207 */     else if (r.moneyType == 1)
/*      */     {
/* 1209 */       resultData.setYuanbao(moneynum);
/*      */     }
/* 1211 */     else if (r.moneyType == 4)
/*      */     {
/* 1213 */       resultData.setGang(moneynum);
/*      */     }
/*      */     
/* 1216 */     int expnum = r.minExpNum;
/* 1217 */     if (r.maxExpNum > r.minExpNum)
/*      */     {
/* 1219 */       expnum += Xdb.random().nextInt(r.maxExpNum - r.minExpNum);
/*      */     }
/* 1221 */     if (r.expType == 1)
/*      */     {
/* 1223 */       resultData.setRoleExp(expnum);
/*      */     }
/* 1225 */     else if (r.expType == 2)
/*      */     {
/* 1227 */       resultData.setPetExp(expnum);
/*      */     }
/* 1229 */     else if (r.expType == 3)
/*      */     {
/* 1231 */       resultData.setXiuLianExp(expnum);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static AwardPoolResultData randomAwardPoolForRole(int poolTypeId, long roleid, int level, boolean isQueryMode)
/*      */   {
/* 1247 */     SAwardPoolMainTable sAwardPoolMainTable = getAwardPoolSumIdByLevel(poolTypeId, level);
/* 1248 */     if (sAwardPoolMainTable == null)
/*      */     {
/* 1250 */       return null;
/*      */     }
/*      */     
/* 1253 */     AwardPoolResultData resultData = randomAwardPoolForRole(roleid, sAwardPoolMainTable.buffEffectIds, sAwardPoolMainTable.awardPoolSumId, isQueryMode);
/*      */     
/*      */ 
/* 1256 */     return resultData;
/*      */   }
/*      */   
/*      */   static List<AwardPoolResultData> randomAwardPoolResultDatas(int awardPoolLibId, boolean isQueryMode)
/*      */   {
/* 1261 */     SAwardPoolLib awardPoolLib = SAwardPoolLib.get(awardPoolLibId);
/*      */     
/* 1263 */     List<AwardPoolResultData> resultDatas = new ArrayList();
/* 1264 */     if ((awardPoolLib == null) || (awardPoolLib.awardPoolSumIds.size() == 0))
/*      */     {
/* 1266 */       return resultDatas;
/*      */     }
/* 1268 */     for (Iterator i$ = awardPoolLib.awardPoolSumIds.iterator(); i$.hasNext();) { int awardPoolSumid = ((Integer)i$.next()).intValue();
/*      */       
/* 1270 */       if (isSAwardPoolSumExists(awardPoolSumid))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1275 */         AwardPoolResultData resultData = randomAwardPoolResultData(SAwardPoolSum.get(awardPoolSumid), isQueryMode);
/* 1276 */         if (resultData != null)
/*      */         {
/* 1278 */           resultDatas.add(resultData);
/*      */         }
/*      */       }
/*      */     }
/* 1282 */     return resultDatas;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void fillItem(long roleid, SItemPoolSub itemPoolSub, AwardPoolResultData resultData, Map<Integer, Set<Integer>> buffMap)
/*      */   {
/* 1290 */     ProfitResult profitResult = BuffInterface.getProfitEffect(roleid, 2048, (Set)buffMap.get(Integer.valueOf(12)));
/*      */     
/*      */ 
/* 1293 */     resultData.addItem(itemPoolSub.itemId, computeProfitResult(itemPoolSub.itemNum, profitResult));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static void fillController(long roleid, SControllerPoolSub controllerPoolSub, AwardPoolResultData resultData, Map<Integer, Set<Integer>> buffSet)
/*      */   {
/* 1300 */     resultData.setControllerId(controllerPoolSub.controllerId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void fillReplaceMoneyType(long roleid, SReplaceMoneyTypeSub replaceMoneyTypeSub, Map<Integer, Set<Integer>> buffSet) {}
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void fillMoney(long roleid, SMoneyPoolSub moneyPoolSub, AwardPoolResultData resultData, Map<Integer, Set<Integer>> buffMap)
/*      */   {
/* 1313 */     int moneyNum = moneyPoolSub.minMoneyNum;
/* 1314 */     if (moneyPoolSub.maxMoneyNum > moneyPoolSub.minMoneyNum)
/*      */     {
/* 1316 */       moneyNum += Xdb.random().nextInt(moneyPoolSub.maxMoneyNum - moneyPoolSub.minMoneyNum);
/*      */     }
/* 1318 */     ProfitResult profitResult = null;
/*      */     
/* 1320 */     switch (moneyPoolSub.moneyType)
/*      */     {
/*      */ 
/*      */     case 3: 
/* 1324 */       profitResult = BuffInterface.getProfitEffect(roleid, 32, (Set)buffMap.get(Integer.valueOf(6)));
/*      */       
/*      */ 
/* 1327 */       resultData.setSilver(computeProfitResult(moneyNum, profitResult));
/* 1328 */       break;
/*      */     
/*      */     case 2: 
/* 1331 */       profitResult = BuffInterface.getProfitEffect(roleid, 16, (Set)buffMap.get(Integer.valueOf(5)));
/*      */       
/*      */ 
/* 1334 */       resultData.setGold(computeProfitResult(moneyNum, profitResult));
/* 1335 */       break;
/*      */     
/*      */     case 4: 
/* 1338 */       profitResult = BuffInterface.getProfitEffect(roleid, 64, (Set)buffMap.get(Integer.valueOf(7)));
/*      */       
/*      */ 
/* 1341 */       resultData.setGang(computeProfitResult(moneyNum, profitResult));
/* 1342 */       break;
/*      */     }
/*      */     
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static void fillExp(long roleid, SExpPoolSub expPoolSub, AwardPoolResultData resultData, Map<Integer, Set<Integer>> buffMap)
/*      */   {
/* 1351 */     int expNum = expPoolSub.minExpNum;
/* 1352 */     if (expPoolSub.maxExpNum > expPoolSub.minExpNum)
/*      */     {
/* 1354 */       expNum += Xdb.random().nextInt(expPoolSub.maxExpNum - expPoolSub.minExpNum);
/*      */     }
/* 1356 */     ProfitResult profitResult = null;
/*      */     
/* 1358 */     switch (expPoolSub.expType)
/*      */     {
/*      */ 
/*      */     case 2: 
/* 1362 */       profitResult = BuffInterface.getProfitEffect(roleid, 2, (Set)buffMap.get(Integer.valueOf(2)));
/*      */       
/* 1364 */       resultData.setPetExp(computeProfitResult(expNum, profitResult));
/*      */     
/*      */ 
/*      */     case 1: 
/* 1368 */       profitResult = BuffInterface.getProfitEffect(roleid, 1, (Set)buffMap.get(Integer.valueOf(1)));
/*      */       
/* 1370 */       resultData.setRoleExp(computeProfitResult(expNum, profitResult));
/* 1371 */       break;
/*      */     
/*      */     case 3: 
/* 1374 */       profitResult = BuffInterface.getProfitEffect(roleid, 4, (Set)buffMap.get(Integer.valueOf(3)));
/*      */       
/* 1376 */       resultData.setXiuLianExp(computeProfitResult(expNum, profitResult));
/* 1377 */       break;
/*      */     }
/*      */     
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void awardLottery(List<Long> roleList, int lotteryViewId, boolean isAutoStart, int delayOfferTime, TLogArg logArg)
/*      */   {
/* 1387 */     if ((roleList == null) || (roleList.size() == 0))
/*      */     {
/* 1389 */       return;
/*      */     }
/*      */     
/* 1392 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */       
/* 1394 */       NoneRealTimeTaskManager.getInstance().addTask(new AwardLotteryPro(roleid, lotteryViewId, logArg, isAutoStart, delayOfferTime));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void fillItem(SItemPoolSub itemPoolSub, AwardPoolResultData resultData)
/*      */   {
/* 1403 */     resultData.addItem(itemPoolSub.itemId, itemPoolSub.itemNum);
/*      */   }
/*      */   
/*      */ 
/*      */   private static void fillController(SControllerPoolSub controllerPoolSub, AwardPoolResultData resultData)
/*      */   {
/* 1409 */     resultData.setControllerId(controllerPoolSub.controllerId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static void fillReplaceMoneyType(SReplaceMoneyTypeSub replaceMoneyTypeSub) {}
/*      */   
/*      */ 
/*      */ 
/*      */   private static void fillMoney(SMoneyPoolSub moneyPoolSub, AwardPoolResultData resultData)
/*      */   {
/* 1420 */     int moneyNum = moneyPoolSub.minMoneyNum;
/* 1421 */     if (moneyPoolSub.maxMoneyNum > moneyPoolSub.minMoneyNum)
/*      */     {
/* 1423 */       moneyNum += Xdb.random().nextInt(moneyPoolSub.maxMoneyNum - moneyPoolSub.minMoneyNum);
/*      */     }
/* 1425 */     switch (moneyPoolSub.moneyType)
/*      */     {
/*      */ 
/*      */     case 3: 
/* 1429 */       resultData.setSilver(moneyNum);
/* 1430 */       break;
/*      */     
/*      */     case 2: 
/* 1433 */       resultData.setGold(moneyNum);
/* 1434 */       break;
/*      */     
/*      */     case 4: 
/* 1437 */       resultData.setGang(moneyNum);
/* 1438 */       break;
/*      */     }
/*      */     
/*      */   }
/*      */   
/*      */ 
/*      */   private static void fillExp(SExpPoolSub expPoolSub, AwardPoolResultData resultData)
/*      */   {
/* 1446 */     int expNum = expPoolSub.minExpNum;
/* 1447 */     if (expPoolSub.maxExpNum > expPoolSub.minExpNum)
/*      */     {
/* 1449 */       expNum += Xdb.random().nextInt(expPoolSub.maxExpNum - expPoolSub.minExpNum);
/*      */     }
/*      */     
/* 1452 */     switch (expPoolSub.expType)
/*      */     {
/*      */     case 2: 
/* 1455 */       resultData.setPetExp(expNum);
/*      */     
/*      */     case 1: 
/* 1458 */       resultData.setRoleExp(expNum);
/* 1459 */       break;
/*      */     
/*      */     case 3: 
/* 1462 */       resultData.setXiuLianExp(expNum);
/* 1463 */       break;
/*      */     }
/*      */     
/*      */   }
/*      */   
/*      */ 
/*      */   private static class AwardLotteryPro
/*      */     extends LogicProcedure
/*      */   {
/*      */     private final long roleid;
/*      */     
/*      */     private final int lotteryViewId;
/*      */     
/*      */     private TLogArg logArg;
/*      */     
/*      */     private final boolean isAutoStart;
/*      */     
/*      */     private final int delayOfferTime;
/*      */     
/*      */     public AwardLotteryPro(long roleid, int lotteryViewId, TLogArg logArg, boolean isAutoStart, int delayOfferTime)
/*      */     {
/* 1484 */       this.roleid = roleid;
/* 1485 */       this.lotteryViewId = lotteryViewId;
/* 1486 */       this.logArg = logArg;
/* 1487 */       this.isAutoStart = isAutoStart;
/* 1488 */       this.delayOfferTime = delayOfferTime;
/*      */     }
/*      */     
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/* 1494 */       List<AwardPoolResultData> resultList = AwardPoolManager.getLotteryResultData(this.roleid, Collections.singletonList(Integer.valueOf(this.lotteryViewId)), false, null, null);
/*      */       
/* 1496 */       AwardPoolResultData result = (AwardPoolResultData)resultList.get(0);
/* 1497 */       if (result == null)
/*      */       {
/* 1499 */         String logStr = String.format("[awardpool]AwardLotteryPro.processImp@awardLottery error,null|lotteryViewId=%d|roleid=%d", new Object[] { Integer.valueOf(this.lotteryViewId), Long.valueOf(this.roleid) });
/*      */         
/*      */ 
/*      */ 
/* 1503 */         AwardPoolManager.logger.error(logStr);
/*      */         
/* 1505 */         return false;
/*      */       }
/*      */       
/* 1508 */       if (result.getItemMap().size() <= 0)
/*      */       {
/*      */ 
/* 1511 */         return false;
/*      */       }
/*      */       
/* 1514 */       int itemid = ((Integer)result.getItemMap().keySet().iterator().next()).intValue();
/* 1515 */       int itemnum = ((Integer)result.getItemMap().get(Integer.valueOf(itemid))).intValue();
/* 1516 */       boolean ret = LotteryManager.addLottery(this.roleid, 2, 0, result, this.logArg, this.delayOfferTime);
/*      */       
/* 1518 */       if (!ret)
/*      */       {
/* 1520 */         String logStr = String.format("[awardpool]AwardPoolManager.awardLottery@awardLottery to role error|lotteryViewId=%d|roleid=%d", new Object[] { Integer.valueOf(this.lotteryViewId), Long.valueOf(this.roleid) });
/*      */         
/*      */ 
/* 1523 */         AwardPoolManager.logger.error(logStr);
/* 1524 */         return false;
/*      */       }
/* 1526 */       if (this.isAutoStart)
/*      */       {
/* 1528 */         SLotteryViewRandomResult res = new SLotteryViewRandomResult();
/* 1529 */         res.itemid = itemid;
/* 1530 */         res.itemnum = itemnum;
/* 1531 */         res.lotteryviewid = this.lotteryViewId;
/* 1532 */         res.finalindex = (result.getIndex() + 1);
/* 1533 */         OnlineManager.getInstance().send(this.roleid, res);
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/* 1538 */         SStartLotteryViewRes res = new SStartLotteryViewRes();
/* 1539 */         res.itemid = itemid;
/* 1540 */         res.itemnum = itemnum;
/* 1541 */         res.lotteryviewid = this.lotteryViewId;
/* 1542 */         res.finalindex = (result.getIndex() + 1);
/* 1543 */         OnlineManager.getInstance().send(this.roleid, res);
/*      */       }
/*      */       
/* 1546 */       return true;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static List<Integer> getAwardPoolSumidsByLibid(int awardPoolLibId)
/*      */   {
/* 1558 */     List<Integer> reIntegers = new ArrayList();
/* 1559 */     SAwardPoolLib awardPoolLib = SAwardPoolLib.get(awardPoolLibId);
/*      */     
/* 1561 */     if ((awardPoolLib == null) || (awardPoolLib.awardPoolSumIds.isEmpty()))
/*      */     {
/* 1563 */       return reIntegers;
/*      */     }
/* 1565 */     reIntegers.addAll(awardPoolLib.awardPoolSumIds);
/* 1566 */     return reIntegers;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean containsItem(int itemId, int poolTypeId, int roleLevel)
/*      */   {
/* 1581 */     SAwardPoolMainTable sAwardPoolMainTable = getAwardPoolSumIdByLevel(poolTypeId, roleLevel);
/* 1582 */     if (sAwardPoolMainTable == null)
/*      */     {
/* 1584 */       return false;
/*      */     }
/* 1586 */     SAwardPoolSum awardPoolSum = SAwardPoolSum.get(sAwardPoolMainTable.awardPoolSumId);
/* 1587 */     if (awardPoolSum == null)
/*      */     {
/* 1589 */       String logStr = String.format("[awardpool]AwardPoolManager.containsItem@SAwardPoolSum error null|poolTypeId=%d|roleLevel=%d|itemId=%d", new Object[] { Integer.valueOf(poolTypeId), Integer.valueOf(roleLevel), Integer.valueOf(itemId) });
/*      */       
/*      */ 
/* 1592 */       logger.info(logStr);
/* 1593 */       return false;
/*      */     }
/* 1595 */     SAwardTypeId2ItemSubId sAwardTypeId2ItemSubId = SAwardTypeId2ItemSubId.get(awardPoolSum.awardTypeId);
/*      */     
/* 1597 */     if (sAwardTypeId2ItemSubId == null)
/*      */     {
/* 1599 */       String logStr = String.format("[awardpool]AwardPoolManager.containsItem@SAwardTypeId2ItemSubId error null|awardTypeId=%d|poolTypeId=%d|roleLevel=%d|itemId=%d", new Object[] { Integer.valueOf(awardPoolSum.awardTypeId), Integer.valueOf(poolTypeId), Integer.valueOf(roleLevel), Integer.valueOf(itemId) });
/*      */       
/*      */ 
/* 1602 */       logger.error(logStr);
/* 1603 */       return false;
/*      */     }
/* 1605 */     List<Integer> itemPoolSubList = sAwardTypeId2ItemSubId.itemSubIds;
/* 1606 */     for (Iterator i$ = itemPoolSubList.iterator(); i$.hasNext();) { int id = ((Integer)i$.next()).intValue();
/*      */       
/* 1608 */       SItemPoolSub s = SItemPoolSub.get(id);
/* 1609 */       if ((s.itemId == itemId) && (s.weight > 0) && (s.itemNum > 0))
/*      */       {
/* 1611 */         return true;
/*      */       }
/*      */     }
/* 1614 */     return false;
/*      */   }
/*      */   
/*      */   static int computeProfitResult(int baseValue, ProfitResult profitResult)
/*      */   {
/* 1619 */     if (profitResult.isZeroProfit())
/*      */     {
/* 1621 */       return 0;
/*      */     }
/* 1623 */     float sum = 0.0F;
/*      */     
/* 1625 */     for (ProfitArg profitArg : profitResult.getRateList())
/*      */     {
/* 1627 */       sum += profitArg.getValue() / 10000.0F * (profitArg.getNTimes() / 10000.0F);
/*      */     }
/*      */     
/* 1630 */     int addnum = 0;
/* 1631 */     for (ProfitArg profitArg : profitResult.getAddList())
/*      */     {
/* 1633 */       addnum += profitArg.getValue();
/*      */     }
/* 1635 */     return (int)(baseValue * (1.0F + sum) + addnum);
/*      */   }
/*      */   
/*      */ 
/*      */   static int computeItemProfitResult(int baseValue, ProfitResult profitResult)
/*      */   {
/* 1641 */     if (profitResult.isZeroProfit())
/*      */     {
/* 1643 */       return 0;
/*      */     }
/* 1645 */     float sum = 0.0F;
/*      */     
/* 1647 */     for (ProfitArg profitArg : profitResult.getRateList())
/*      */     {
/* 1649 */       sum += profitArg.getValue() / 10000.0F * (profitArg.getNTimes() / 10000.0F);
/*      */     }
/*      */     
/* 1652 */     return (int)(baseValue * (1.0F + sum));
/*      */   }
/*      */   
/*      */ 
/*      */   static int getPreciousCfgId(int itemSubId)
/*      */   {
/* 1658 */     SItemPoolSub sItemPoolSub = SItemPoolSub.get(itemSubId);
/* 1659 */     if (sItemPoolSub != null)
/*      */     {
/* 1661 */       return sItemPoolSub.preciousCfgId;
/*      */     }
/* 1663 */     SRandomTextTableCfg sRandomTextTableCfg = SRandomTextTableCfg.get(itemSubId);
/* 1664 */     if (sRandomTextTableCfg != null)
/*      */     {
/* 1666 */       return sRandomTextTableCfg.preciousCfgId;
/*      */     }
/* 1668 */     return -1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static List<AwardPoolResultData> getLotteryResultData(long roleId, List<Integer> lotteryViewIds, List<Integer> removeSubids)
/*      */   {
/* 1682 */     List<AwardPoolResultData> resultDataList = new LinkedList();
/* 1683 */     for (Iterator i$ = lotteryViewIds.iterator(); i$.hasNext();) { int lotteryViewId = ((Integer)i$.next()).intValue();
/*      */       
/*      */ 
/* 1686 */       Map<Integer, Integer> correctedWeightMap = WeightCorrectionManager.getLotteryCorrectedWeightMap(roleId, lotteryViewId);
/*      */       
/*      */ 
/* 1689 */       AwardPoolResultData resultData = getLotteryResultData(roleId, lotteryViewId, removeSubids, correctedWeightMap);
/* 1690 */       resultDataList.add(resultData);
/*      */     }
/*      */     
/* 1693 */     WeightCorrectionManager.addLotteryCount(roleId, lotteryViewIds);
/* 1694 */     return resultDataList;
/*      */   }
/*      */   
/*      */ 
/*      */   private static AwardPoolResultData getLotteryResultData(long roleId, int id, List<Integer> removeSubids, Map<Integer, Integer> id2revisedWeight)
/*      */   {
/* 1700 */     if (SLotteryViewRandomCfg.get(id) == null)
/*      */     {
/* 1702 */       return null;
/*      */     }
/*      */     
/* 1705 */     AwardPoolResultData resultData = new AwardPoolResultData();
/* 1706 */     int sum = 0;
/* 1707 */     List<SRandomTextTableCfg> list = new ArrayList();
/* 1708 */     for (Iterator i$ = SLotteryViewRandomCfg.get(id).typeIds.iterator(); i$.hasNext();) { int typeid = ((Integer)i$.next()).intValue();
/*      */       
/* 1710 */       STypeId2RandomTextTableCfgId typeId2RandomTextTableCfgId = STypeId2RandomTextTableCfgId.get(typeid);
/* 1711 */       if (typeId2RandomTextTableCfgId == null)
/*      */       {
/* 1713 */         String logStr = String.format("[awardpool]AwardPoolManager.getLotteryResultData@STypeId2RandomTextTableCfgId get null|id=%d|typeid=%d", new Object[] { Integer.valueOf(id), Integer.valueOf(typeid) });
/*      */         
/*      */ 
/*      */ 
/* 1717 */         logger.error(logStr);
/*      */       }
/*      */       else {
/* 1720 */         List<Integer> randomTextTableCfgIds = typeId2RandomTextTableCfgId.randomTextTableCfgIds;
/* 1721 */         for (i$ = randomTextTableCfgIds.iterator(); i$.hasNext();) { int cfgid = ((Integer)i$.next()).intValue();
/*      */           
/* 1723 */           if (!removeSubids.contains(Integer.valueOf(cfgid)))
/*      */           {
/*      */ 
/*      */ 
/* 1727 */             SRandomTextTableCfg r = SRandomTextTableCfg.get(cfgid);
/* 1728 */             sum += getWeight(id2revisedWeight, r.weight, r.id);
/* 1729 */             list.add(r);
/*      */           } } } }
/*      */     Iterator i$;
/* 1732 */     int randomnum = Xdb.random().nextInt(sum);
/* 1733 */     int c = 0;
/* 1734 */     for (int i = 0; i < list.size(); i++)
/*      */     {
/* 1736 */       SRandomTextTableCfg r = (SRandomTextTableCfg)list.get(i);
/* 1737 */       c += getWeight(id2revisedWeight, r.weight, r.id);
/* 1738 */       if (randomnum < c)
/*      */       {
/* 1740 */         resultData.addItem(r.itemId, r.itemNum);
/* 1741 */         resultData.setIndex(SLotteryViewRandomCfg.get(id).typeIds.indexOf(Integer.valueOf(r.typeId)));
/* 1742 */         resultData.addFinalSubPoolIds(r.id);
/*      */         
/* 1744 */         int moneynum = r.minMoneyNum;
/* 1745 */         if (r.maxMoneyNum > r.minMoneyNum)
/*      */         {
/* 1747 */           moneynum += Xdb.random().nextInt(r.maxMoneyNum - r.minMoneyNum);
/*      */         }
/*      */         
/* 1750 */         if (r.moneyType == 2)
/*      */         {
/* 1752 */           resultData.setGold(moneynum);
/*      */         }
/* 1754 */         else if (r.moneyType == 3)
/*      */         {
/* 1756 */           resultData.setSilver(moneynum);
/*      */         }
/* 1758 */         else if (r.moneyType == 1)
/*      */         {
/* 1760 */           resultData.setYuanbao(moneynum);
/*      */         }
/* 1762 */         else if (r.moneyType == 4)
/*      */         {
/* 1764 */           resultData.setGang(moneynum);
/*      */         }
/*      */         
/* 1767 */         int expnum = r.minExpNum;
/* 1768 */         if (r.maxExpNum > r.minExpNum)
/*      */         {
/* 1770 */           expnum += Xdb.random().nextInt(r.maxExpNum - r.minExpNum);
/*      */         }
/* 1772 */         if (r.expType == 1)
/*      */         {
/* 1774 */           resultData.setRoleExp(expnum); break;
/*      */         }
/* 1776 */         if (r.expType == 2)
/*      */         {
/* 1778 */           resultData.setPetExp(expnum); break;
/*      */         }
/* 1780 */         if (r.expType != 3)
/*      */           break;
/* 1782 */         resultData.setXiuLianExp(expnum); break;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1788 */     return resultData;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isPreciousDropSwitchOpenForRole()
/*      */   {
/* 1801 */     return OpenInterface.getOpenStatus(131);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static List<Integer> getPreciousItemSubIds(Map<Integer, Integer> itemSubId2preciousCfgId)
/*      */   {
/* 1813 */     if ((itemSubId2preciousCfgId == null) || (itemSubId2preciousCfgId.isEmpty()))
/*      */     {
/* 1815 */       return null;
/*      */     }
/*      */     
/* 1818 */     List<Integer> canRandonPreciousSubIds = new ArrayList();
/*      */     
/* 1820 */     for (Iterator i$ = itemSubId2preciousCfgId.keySet().iterator(); i$.hasNext();) { int itemSubId = ((Integer)i$.next()).intValue();
/*      */       
/* 1822 */       ItemSubidObject itemSubidObject = ItemSubIdDropcCounter.getInstance().getItemSubidObject(itemSubId);
/* 1823 */       if (itemSubidObject.canDrop(((Integer)itemSubId2preciousCfgId.get(Integer.valueOf(itemSubId))).intValue()))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1830 */         canRandonPreciousSubIds.add(Integer.valueOf(itemSubId));
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1835 */     return canRandonPreciousSubIds;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogRoleDrop(long roleId, int itemSubId, int roleDropCount, int roleHistoryDropCount, int roleUnHitCount, boolean isDrop)
/*      */   {
/* 1843 */     String vGameIP = GameServerInfoManager.getHostIP();
/*      */     
/* 1845 */     int rolelevel = RoleInterface.getLevel(roleId);
/*      */     
/* 1847 */     String userId = RoleInterface.getUserId(roleId);
/*      */     
/* 1849 */     Object[] columns = { vGameIP, userId, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(itemSubId), Integer.valueOf(getItemId(itemSubId)), Integer.valueOf(roleDropCount), Integer.valueOf(roleHistoryDropCount), Integer.valueOf(roleUnHitCount), Integer.valueOf(isDrop ? 1 : 0) };
/*      */     
/* 1851 */     TLogManager.getInstance().addLog(roleId, "RoleAwardPoolDrop", columns);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void tlogServerDrop(int itemSubId, int serverDropCount, int serverHistoryDropCount, int serverUnHitCount, boolean isDrop)
/*      */   {
/* 1858 */     SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 1859 */     long time = DateTimeUtils.getCurrTimeInMillis();
/* 1860 */     String dtEventTime = sdf.format(Long.valueOf(time));
/* 1861 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 1862 */     int iZoneAreaID = GameServerInfoManager.getZoneId();
/*      */     
/* 1864 */     Object[] columns = { dtEventTime, vGameIP, Integer.valueOf(iZoneAreaID), Integer.valueOf(itemSubId), Integer.valueOf(getItemId(itemSubId)), Integer.valueOf(serverDropCount), Integer.valueOf(serverHistoryDropCount), Integer.valueOf(serverUnHitCount), Integer.valueOf(isDrop ? 1 : 0) };
/*      */     
/* 1866 */     TLogManager.getInstance().addLog("ServerAwardPoolDrop", columns);
/*      */   }
/*      */   
/*      */   static int getItemId(int itemSubId)
/*      */   {
/* 1871 */     SItemPoolSub sItemPoolSub = SItemPoolSub.get(itemSubId);
/* 1872 */     if (sItemPoolSub != null)
/*      */     {
/* 1874 */       return sItemPoolSub.itemId;
/*      */     }
/* 1876 */     SRandomTextTableCfg sRandomTextTableCfg = SRandomTextTableCfg.get(itemSubId);
/* 1877 */     if (sRandomTextTableCfg != null)
/*      */     {
/* 1879 */       return sRandomTextTableCfg.itemId;
/*      */     }
/* 1881 */     return -1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static Map<Integer, Integer> getBagId2MaxNeedGridNum(int awardTypeId)
/*      */   {
/* 1893 */     SAwardTypeId2ItemSubId sAwardTypeId2ItemSubId = SAwardTypeId2ItemSubId.get(awardTypeId);
/* 1894 */     Map<Integer, Integer> resultMap = new HashMap();
/*      */     
/* 1896 */     if (sAwardTypeId2ItemSubId == null)
/*      */     {
/* 1898 */       String logStr = String.format("[awardpool]AwardPoolManager.getMaxNeedGridNum@sAwardTypeId2ItemSubId not exist!|awardTypeId=%d", new Object[] { Integer.valueOf(awardTypeId) });
/*      */       
/*      */ 
/* 1901 */       logger.error(logStr);
/* 1902 */       return resultMap;
/*      */     }
/*      */     
/* 1905 */     resultMap.putAll(sAwardTypeId2ItemSubId.bagId2MaxNeedGrid);
/* 1906 */     return resultMap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static Map<Integer, Integer> getBagId2LotteryNeedGrid(int lotteryViewId)
/*      */   {
/* 1917 */     SLotteryViewRandomCfg lotteryViewRandomCfg = SLotteryViewRandomCfg.get(lotteryViewId);
/* 1918 */     Map<Integer, Integer> resultMap = new HashMap();
/*      */     
/* 1920 */     if (lotteryViewRandomCfg == null)
/*      */     {
/* 1922 */       String logStr = String.format("[awardpool]AwardPoolManager.getLotteryNeedGrid@lotteryViewRandomCfg not exist!|lotteryViewId=%d", new Object[] { Integer.valueOf(lotteryViewId) });
/*      */       
/*      */ 
/* 1925 */       logger.error(logStr);
/* 1926 */       return resultMap;
/*      */     }
/*      */     
/* 1929 */     resultMap.putAll(lotteryViewRandomCfg.bagId2MaxNeedGrid);
/* 1930 */     return resultMap;
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\main\AwardPoolManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */