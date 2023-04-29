/*     */ package mzm.gsp.item.main.access;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.active.main.ActiveInterface;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.awardpool.confbean.SAwardPoolMainTable;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.baitan.main.BaiTanInterface;
/*     */ import mzm.gsp.changemodelcard.main.ChangeModelCardInterface;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.item.confbean.SItemCangBaoTuCfg;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.shanghui.main.ShanghuiInterface;
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
/*     */ public class ItemAccessInterface
/*     */ {
/*     */   public static Set<Integer> queryNpcForSellItem(long roleId, int itemId)
/*     */   {
/*  41 */     Set<Integer> npcTradeServiceList = NpcInterface.getAllNpcTradeServiceId();
/*  42 */     Set<Integer> ret = new HashSet();
/*  43 */     for (Iterator i$ = npcTradeServiceList.iterator(); i$.hasNext();) { int npcServiceId = ((Integer)i$.next()).intValue();
/*     */       
/*     */ 
/*  46 */       if ((NpcInterface.isSellItem(npcServiceId, itemId)) && (NpcInterface.isNpcServiceAvailable(npcServiceId, roleId)))
/*     */       {
/*  48 */         ret.add(Integer.valueOf(npcServiceId));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  53 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Set<Integer> querySkillbagidForItem(long roleId, int itemId)
/*     */   {
/*  64 */     Set<Integer> skillIntegers = new HashSet();
/*  65 */     List<Integer> s = ItemAccessManager.getSkillbagid(roleId, itemId);
/*  66 */     if (s != null)
/*     */     {
/*  68 */       skillIntegers.addAll(s);
/*     */     }
/*     */     
/*  71 */     return skillIntegers;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean queryGangDrugShopForItem(long roleId, int itemId)
/*     */   {
/*  83 */     return GangInterface.isSellGangYaoDianItem(roleId, itemId);
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
/*     */   public static Set<Integer> queryActivityForOutputItem(String userId, long roleId, int itemId, int rolelevel)
/*     */   {
/*  96 */     Map<Integer, Set<Integer>> activityId2FixRewardId = ItemAccessManager.getActivityId2FixRewardIdMap();
/*     */     
/*  98 */     Map<Integer, Set<Integer>> activityId2RewardId = ItemAccessManager.getActivityId2rewardIdMap();
/*  99 */     Map<Integer, Set<Integer>> activityId2pooltypeId = ItemAccessManager.getActivityId2PooltypeidMap();
/*     */     
/* 101 */     Map<Integer, Set<Integer>> activityId2AwardPoolLibid = ItemAccessManager.getActivityId2AwardPoolLibidMap();
/*     */     
/* 103 */     Set<Integer> activityIds = new HashSet();
/*     */     
/* 105 */     for (Iterator i$ = ActivityInterface.getActivityids(userId, roleId).iterator(); i$.hasNext();) { activityId = (Integer)i$.next();
/*     */       
/*     */ 
/* 108 */       if (!activityIds.contains(activityId))
/*     */       {
/*     */ 
/*     */ 
/* 112 */         Set<Integer> fixRewardIds = (Set)activityId2FixRewardId.get(activityId);
/* 113 */         if (fixRewardIds != null)
/*     */         {
/* 115 */           for (Integer rewardId : fixRewardIds)
/*     */           {
/* 117 */             if (searchFixAward(roleId, rewardId.intValue(), itemId))
/*     */             {
/* 119 */               activityIds.add(activityId);
/* 120 */               break;
/*     */             }
/*     */           }
/*     */         }
/*     */         
/* 125 */         if (!activityIds.contains(activityId))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 130 */           Set<Integer> rewardIds = (Set)activityId2RewardId.get(activityId);
/* 131 */           if (rewardIds != null)
/*     */           {
/* 133 */             for (Integer rewardId : rewardIds)
/*     */             {
/* 135 */               if (searchAward(rewardId.intValue(), itemId, roleId))
/*     */               {
/* 137 */                 activityIds.add(activityId);
/* 138 */                 break;
/*     */               }
/*     */             }
/*     */           }
/*     */           
/* 143 */           if (!activityIds.contains(activityId))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 148 */             Set<Integer> pooltypeids = (Set)activityId2pooltypeId.get(activityId);
/* 149 */             Iterator i$; if (pooltypeids != null)
/*     */             {
/*     */ 
/* 152 */               for (i$ = pooltypeids.iterator(); i$.hasNext();) { int pooltypeid = ((Integer)i$.next()).intValue();
/*     */                 
/* 154 */                 SAwardPoolMainTable awardpooid = AwardPoolInterface.getAwardPoolSumIdByLevel(pooltypeid, rolelevel);
/* 155 */                 if (awardpooid != null)
/*     */                 {
/*     */ 
/*     */ 
/* 159 */                   if (AwardPoolInterface.hasItem(awardpooid.awardPoolSumId, itemId))
/*     */                   {
/* 161 */                     activityIds.add(activityId);
/* 162 */                     break;
/*     */                   }
/*     */                 }
/*     */               }
/*     */             }
/* 167 */             if (!activityIds.contains(activityId))
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/* 172 */               Set<Integer> awardpoollibis = (Set)activityId2AwardPoolLibid.get(activityId);
/* 173 */               if (awardpoollibis != null)
/*     */               {
/*     */ 
/* 176 */                 for (i$ = awardpoollibis.iterator(); i$.hasNext();) { int awardPoolLibId = ((Integer)i$.next()).intValue();
/*     */                   
/* 178 */                   List<Integer> list = AwardPoolInterface.getAwardPoolSumidsByLibid(awardPoolLibId);
/* 179 */                   if ((list != null) && (list.size() != 0))
/*     */                   {
/*     */ 
/*     */ 
/* 183 */                     for (i$ = list.iterator(); i$.hasNext();) { int awardpooid = ((Integer)i$.next()).intValue();
/*     */                       
/* 185 */                       if (AwardPoolInterface.hasItem(awardpooid, itemId))
/*     */                       {
/* 187 */                         activityIds.add(activityId);
/* 188 */                         break;
/*     */                       }
/*     */                     } }
/*     */                 } }
/*     */             }
/*     */           } } } }
/*     */     Integer activityId;
/*     */     Iterator i$;
/*     */     Iterator i$;
/* 197 */     return activityIds;
/*     */   }
/*     */   
/*     */   private static boolean searchFixAward(long roleId, int fixAwardId, int itemId)
/*     */   {
/* 202 */     List<Integer> itemList = AwardInterface.getFixAwardItems(roleId, fixAwardId);
/* 203 */     if (itemList == null)
/*     */     {
/* 205 */       return false;
/*     */     }
/*     */     
/* 208 */     return itemList.contains(Integer.valueOf(itemId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Set<Integer> queryMapIdForOuputItem(long roleId, int itemId)
/*     */   {
/* 219 */     Set<Integer> retMapIds = new HashSet();
/* 220 */     Map<Integer, Set<Integer>> mapId2RewardId = ItemAccessManager.getMapId2rewardIdMap();
/* 221 */     for (Map.Entry<Integer, Set<Integer>> entry : mapId2RewardId.entrySet())
/*     */     {
/* 223 */       mapId = (Integer)entry.getKey();
/* 224 */       Set<Integer> rewardIdsSet = (Set)entry.getValue();
/*     */       
/* 226 */       for (Integer rewardId : rewardIdsSet)
/*     */       {
/* 228 */         if (searchAward(rewardId.intValue(), itemId, roleId))
/*     */         {
/* 230 */           retMapIds.add(mapId);
/* 231 */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */     Integer mapId;
/* 236 */     return retMapIds;
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
/*     */   private static boolean searchAward(int rewardId, int itemId, long roleId)
/*     */   {
/* 249 */     List<Integer> itemSubTableList = AwardInterface.getAwardItemTableList(roleId, rewardId);
/* 250 */     for (Integer itemSubTableId : itemSubTableList)
/*     */     {
/* 252 */       Set<Integer> itemSet = AwardInterface.getAwardItemList(itemSubTableId.intValue());
/* 253 */       if (itemSet.contains(Integer.valueOf(itemId)))
/*     */       {
/* 255 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 259 */     Set<Integer> timeDropItemIds = AwardInterface.getTimeDropItemIds(rewardId);
/* 260 */     if ((timeDropItemIds == null) || (timeDropItemIds.size() == 0))
/*     */     {
/* 262 */       return false;
/*     */     }
/* 264 */     return timeDropItemIds.contains(Integer.valueOf(itemId));
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
/*     */   public static Set<Integer> queryShanghuiItemBigType(long roleId, int itemId)
/*     */   {
/* 277 */     Set<Integer> bigtypeIds = new HashSet();
/* 278 */     if (!ShanghuiInterface.isItemCanSellForServerLevel(itemId, ServerInterface.getCurrentServerLevel()))
/*     */     {
/* 280 */       return bigtypeIds;
/*     */     }
/* 282 */     Integer bigtype = ShanghuiInterface.getItemBigTypeId(itemId);
/* 283 */     if (bigtype != null)
/*     */     {
/* 285 */       bigtypeIds.add(bigtype);
/*     */     }
/*     */     
/* 288 */     return bigtypeIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Set<Integer> queryShanghuiItemSubType(long roleId, int itemId)
/*     */   {
/* 300 */     Set<Integer> subtypeIds = new HashSet();
/* 301 */     if (!ShanghuiInterface.isItemCanSellForServerLevel(itemId, ServerInterface.getCurrentServerLevel()))
/*     */     {
/* 303 */       return subtypeIds;
/*     */     }
/* 305 */     Integer subtype = ShanghuiInterface.getItemSubTypeId(itemId);
/*     */     
/* 307 */     if ((subtype != null) && (subtype.intValue() != 0))
/*     */     {
/* 309 */       subtypeIds.add(subtype);
/*     */     }
/*     */     
/* 312 */     return subtypeIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Set<Integer> queryBaitanBigType(long roleId, int itemId)
/*     */   {
/* 324 */     Set<Integer> bigtypegroups = new HashSet();
/*     */     
/* 326 */     int bigtypegroup = BaiTanInterface.getBigTypeGroup(itemId);
/* 327 */     if (bigtypegroup != -1)
/*     */     {
/* 329 */       bigtypegroups.add(Integer.valueOf(bigtypegroup));
/*     */     }
/*     */     
/* 332 */     return bigtypegroups;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Set<Integer> queryBaitanSubType(long roleId, int itemId)
/*     */   {
/* 344 */     Set<Integer> bigtypegroups = new HashSet();
/* 345 */     int bigtypegroup = BaiTanInterface.getSubTypeGroup(itemId);
/* 346 */     if (bigtypegroup != -1)
/*     */     {
/* 348 */       bigtypegroups.add(Integer.valueOf(bigtypegroup));
/*     */     }
/* 350 */     return bigtypegroups;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<Integer> queryMallTypeForSellItem(long roleId, int itemId)
/*     */   {
/* 362 */     return MallInterface.getMallTypeForItem(roleId, itemId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Set<Integer> queryJifenTypeForItem(long roleId, int itemid)
/*     */   {
/* 373 */     return MallInterface.getJifenTypeForItem(itemid);
/*     */   }
/*     */   
/*     */ 
/*     */   public static Set<Integer> queryBaotuTypeForThisItem(int itemId, int roleLevel)
/*     */   {
/* 379 */     Set<Integer> baotuItemids = new HashSet();
/*     */     
/* 381 */     for (SItemCangBaoTuCfg c : SItemCangBaoTuCfg.getAllSelf().values())
/*     */     {
/*     */ 
/* 384 */       if (AwardPoolInterface.containsItem(itemId, c.awardPoolId, roleLevel))
/*     */       {
/* 386 */         baotuItemids.add(Integer.valueOf(c.id));
/*     */       }
/*     */     }
/*     */     
/* 390 */     return baotuItemids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isVitalityExchangeOutPutItem(long roleId, int itemId)
/*     */   {
/* 402 */     return ActiveInterface.isActiveAward(roleId, itemId);
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
/*     */   public static boolean isHomelandShopOutPutItem(int itemId)
/*     */   {
/* 415 */     return HomelandInterface.isHomelandSellItem(itemId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isChangeModelCardLotteryOutPutItem(int itemId, int roleLevel)
/*     */   {
/* 427 */     return ChangeModelCardInterface.isCardLotteryOutPutItem(itemId, roleLevel);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\access\ItemAccessInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */