/*     */ package mzm.gsp.award.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.award.confbean.AwardCfgConsts;
/*     */ import mzm.gsp.award.confbean.ItemPair;
/*     */ import mzm.gsp.award.confbean.ItemdropMod;
/*     */ import mzm.gsp.award.confbean.SAward;
/*     */ import mzm.gsp.award.confbean.SAwardItem;
/*     */ import mzm.gsp.award.confbean.SAwardItemContent;
/*     */ import mzm.gsp.award.confbean.SModifyValueTable;
/*     */ import mzm.gsp.award.confbean.STAwardItemContent;
/*     */ import mzm.gsp.item.main.sift.SiftInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ItemCalculator
/*     */ {
/*  30 */   private static final Logger logger = Logger.getLogger(ItemCalculator.class);
/*     */   
/*     */ 
/*     */   static List<Integer> calItem(List<Long> roleList, Collection<Long> allRoleList, SAward sAward, long roleId, int modifileId, AwardModel awardModel)
/*     */   {
/*  35 */     List<Integer> itemList = new ArrayList();
/*  36 */     Map<Integer, Double> finalRetList = new HashMap();
/*     */     
/*     */ 
/*  39 */     SModifyValueTable sModifyValueTable = SModifyValueTable.get(modifileId);
/*     */     
/*  41 */     int itemAwardId = sAward.awardItemId;
/*  42 */     if (itemAwardId == 0)
/*     */     {
/*  44 */       return itemList;
/*     */     }
/*  46 */     List<SAwardItem> sAwardItems = AwardManager.getItemAwardCfgs(itemAwardId);
/*  47 */     if ((sAwardItems == null) || (sAwardItems.size() == 0))
/*     */     {
/*  49 */       logger.error("未找到物品奖励类id=" + itemAwardId + "下的奖励列表！");
/*  50 */       return itemList;
/*     */     }
/*  52 */     SAwardItem sAwardItem = RoleAwardManager.getItemAward(allRoleList, itemAwardId, sAwardItems, roleId);
/*  53 */     if (sAwardItem == null)
/*     */     {
/*  55 */       logger.error("未找到玩家[" + RoleInterface.getName(roleId) + "]level=" + RoleInterface.getLevel(roleId) + "）物品奖励类id=" + itemAwardId + "下的奖励类！");
/*     */       
/*  57 */       return new ArrayList();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  62 */     AwardAddParam addParam = new AwardAddParam();
/*  63 */     if (!PBuffEffect.calBuffAdd(sAward.addModifyCnfId, roleId, addParam, 12, 2048))
/*     */     {
/*     */ 
/*  66 */       awardModel.setZeroState(true);
/*  67 */       return new ArrayList();
/*     */     }
/*     */     
/*  70 */     for (int i = 0; i < sAwardItem.awardItemList.size(); i++)
/*     */     {
/*  72 */       Double addRet = Double.valueOf(0.0D);
/*  73 */       Double modRet = null;
/*     */       
/*  75 */       if ((sModifyValueTable == null) || (sModifyValueTable.itemTableModList == null) || (sModifyValueTable.itemTableModList.size() <= i))
/*     */       {
/*     */ 
/*  78 */         modRet = Double.valueOf(1.0D);
/*     */       }
/*     */       else
/*     */       {
/*  82 */         modRet = (Double)sModifyValueTable.itemTableModList.get(i);
/*     */       }
/*  84 */       if (modRet == null)
/*     */       {
/*  86 */         modRet = Double.valueOf(1.0D);
/*     */       }
/*     */       
/*  89 */       double finalRet = (1.0D + addRet.doubleValue() + addParam.getAllAddParam()) * modRet.doubleValue();
/*  90 */       finalRetList.put(Integer.valueOf(i), Double.valueOf(finalRet));
/*     */     }
/*     */     
/*  93 */     getItemList(sAwardItem, itemList, finalRetList, roleList, allRoleList, roleId);
/*  94 */     return itemList;
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
/*     */   private static void getItemList(SAwardItem sAwardItem, List<Integer> itemList, Map<Integer, Double> finanlRetList, List<Long> roleList, Collection<Long> allRoleList, long roleId)
/*     */   {
/* 109 */     for (int i = 0; i < sAwardItem.awardItemList.size(); i++)
/*     */     {
/* 111 */       Random random = Xdb.random();
/* 112 */       int ran = random.nextInt(AwardCfgConsts.getInstance().AWARD_SEED);
/* 113 */       int afterModifyValue = ((ItemPair)sAwardItem.awardItemList.get(i)).itemRate;
/* 114 */       if (finanlRetList.containsKey(Integer.valueOf(i)))
/*     */       {
/* 116 */         afterModifyValue = (int)(afterModifyValue * ((Double)finanlRetList.get(Integer.valueOf(i))).doubleValue());
/*     */       }
/*     */       
/* 119 */       if (ran < afterModifyValue)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 124 */         int itemAwardContentId = ((ItemPair)sAwardItem.awardItemList.get(i)).itemId;
/* 125 */         ItemdropMod item = randomItem(STAwardItemContent.get(itemAwardContentId));
/* 126 */         if (item != null)
/*     */         {
/*     */ 
/*     */ 
/* 130 */           int itemId = getItemId(item);
/*     */           
/* 132 */           if (itemId > 0)
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 137 */             for (int k = 0; k < item.dropNum; k++)
/*     */             {
/* 139 */               itemList.add(Integer.valueOf(itemId));
/*     */             }
/*     */           }
/*     */         }
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
/*     */   private static int getItemId(ItemdropMod item)
/*     */   {
/* 155 */     int itemId = item.itemId;
/* 156 */     if (item.dropType == 1)
/*     */     {
/* 158 */       return itemId;
/*     */     }
/* 160 */     Set<Integer> itemCondition = getItemSet(item);
/* 161 */     if (itemCondition.size() > 0)
/*     */     {
/* 163 */       return randomItemCondition(itemCondition);
/*     */     }
/*     */     
/*     */ 
/* 167 */     return -1;
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
/*     */   static Set<Integer> getAwartItemSet(int AwardItemContentId)
/*     */   {
/* 182 */     Set<Integer> awartItemSet = new HashSet();
/* 183 */     SAwardItemContent awardItem = SAwardItemContent.get(AwardItemContentId);
/* 184 */     if (awardItem == null)
/*     */     {
/* 186 */       return awartItemSet;
/*     */     }
/* 188 */     for (ItemdropMod itemdropMod : awardItem.itemdropModList)
/*     */     {
/* 190 */       if (itemdropMod.weight != 0)
/*     */       {
/*     */ 
/*     */ 
/* 194 */         if (itemdropMod.dropType == 1)
/*     */         {
/* 196 */           awartItemSet.add(Integer.valueOf(itemdropMod.itemId));
/*     */         }
/*     */         else {
/* 199 */           Set<Integer> itemCondition = getItemSet(itemdropMod);
/* 200 */           if (itemCondition.size() > 0)
/*     */           {
/* 202 */             awartItemSet.addAll(itemCondition); }
/*     */         } }
/*     */     }
/* 205 */     return awartItemSet;
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
/*     */   private static Set<Integer> getItemSet(ItemdropMod item)
/*     */   {
/* 219 */     Set<Integer> itemCondition = new HashSet();
/* 220 */     if (item.dropType != 1)
/*     */     {
/* 222 */       switch (item.dropType)
/*     */       {
/*     */       case 2: 
/* 225 */         itemCondition = SiftInterface.siftEquipItem(item.itemId);
/* 226 */         break;
/*     */       case 3: 
/* 228 */         itemCondition = SiftInterface.siftDrugInFightItem(item.itemId);
/* 229 */         break;
/*     */       case 4: 
/* 231 */         itemCondition = SiftInterface.siftDrugOutFightItem(item.itemId);
/* 232 */         break;
/*     */       case 5: 
/* 234 */         itemCondition = SiftInterface.siftPetSkilbokItem(item.itemId);
/* 235 */         break;
/*     */       }
/*     */       
/*     */       
/*     */ 
/* 240 */       if (itemCondition.size() == 0)
/*     */       {
/* 242 */         logger.error(String.format("Award@按照筛选条件id[" + item.itemId + "]没有找到符合条件的物品", new Object[0]));
/*     */       }
/*     */     }
/* 245 */     return itemCondition;
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
/*     */   private static int randomItemCondition(Set<Integer> itemSet)
/*     */   {
/* 258 */     Random random = Xdb.random();
/* 259 */     List<Integer> itemList = new ArrayList(itemSet);
/* 260 */     int ran = random.nextInt(itemList.size());
/* 261 */     return ((Integer)itemList.get(ran)).intValue();
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
/*     */   private static ItemdropMod randomItem(STAwardItemContent sAwardItemContent)
/*     */   {
/* 274 */     if (sAwardItemContent == null)
/*     */     {
/* 276 */       return null;
/*     */     }
/* 278 */     Integer weightSum = Integer.valueOf(sAwardItemContent.weight);
/* 279 */     if ((weightSum == null) || (weightSum.intValue() <= 0))
/*     */     {
/* 281 */       if (logger.isDebugEnabled())
/*     */       {
/* 283 */         logger.debug("奖励物品无权值，奖励物品id= " + sAwardItemContent.id);
/*     */       }
/* 285 */       return null;
/*     */     }
/* 287 */     Random random = Xdb.random();
/* 288 */     int ran = random.nextInt(weightSum.intValue());
/* 289 */     int valueNow = 0;
/*     */     
/* 291 */     for (ItemdropMod itemdropMod : sAwardItemContent.itemdropModList)
/*     */     {
/* 293 */       valueNow += itemdropMod.weight;
/* 294 */       if (ran < valueNow)
/*     */       {
/* 296 */         return itemdropMod;
/*     */       }
/*     */     }
/*     */     
/* 300 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\main\ItemCalculator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */