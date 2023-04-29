/*     */ package mzm.gsp.item.main.sift;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.item.confbean.SItemSiftConCfg;
/*     */ import mzm.gsp.item.main.sift.condition.AbsSiftCondition;
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
/*     */ public class SiftInterface
/*     */ {
/*     */   public static Set<Integer> siftItem(int itemType, List<AbsSiftCondition> conditionsList)
/*     */   {
/*  26 */     Collections.sort(conditionsList);
/*  27 */     return SiftCacheManager.getAndSetCacheItemSet(itemType, conditionsList);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Set<Integer> siftEquipItem(int siftCfgId)
/*     */   {
/*  38 */     List<AbsSiftCondition> conditionsList = SiftConditionFac.createEquipSiftCondition(siftCfgId);
/*  39 */     Collections.sort(conditionsList);
/*  40 */     return SiftCacheManager.getAndSetCacheItemSet(2, conditionsList);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Set<Integer> siftDrugInFightItem(int siftCfgId)
/*     */   {
/*  51 */     List<AbsSiftCondition> conditionsList = SiftConditionFac.createInFightDrugSiftCondition(siftCfgId);
/*  52 */     Collections.sort(conditionsList);
/*  53 */     return SiftCacheManager.getAndSetCacheItemSet(5, conditionsList);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Set<Integer> siftDrugOutFightItem(int siftCfgId)
/*     */   {
/*  64 */     List<AbsSiftCondition> conditionsList = SiftConditionFac.createOutFightDrugSiftCondition(siftCfgId);
/*  65 */     Collections.sort(conditionsList);
/*  66 */     return SiftCacheManager.getAndSetCacheItemSet(8, conditionsList);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Set<Integer> siftPetSkilbokItem(int siftCfgId)
/*     */   {
/*  77 */     List<AbsSiftCondition> conditionsList = SiftConditionFac.createPetSkilBokSiftCondition(siftCfgId);
/*  78 */     Collections.sort(conditionsList);
/*  79 */     return SiftCacheManager.getAndSetCacheItemSet(4, conditionsList);
/*     */   }
/*     */   
/*  82 */   public static Set<Integer> siftItems(int siftCfgId) { Set<Integer> set = new HashSet();
/*  83 */     SItemSiftConCfg itemSiftConCfg = SItemSiftConCfg.get(siftCfgId);
/*  84 */     if (itemSiftConCfg == null) {
/*  85 */       return set;
/*     */     }
/*  87 */     switch (itemSiftConCfg.itemType) {
/*     */     case 2: 
/*  89 */       set.addAll(siftEquipItem(siftCfgId));
/*  90 */       break;
/*     */     case 5: 
/*  92 */       set.addAll(siftDrugInFightItem(siftCfgId));
/*  93 */       break;
/*     */     case 7: 
/*  95 */       set.addAll(siftDrugOutFightItem(siftCfgId));
/*  96 */       break;
/*     */     case 4: 
/*  98 */       set.addAll(siftPetSkilbokItem(siftCfgId));
/*  99 */       break;
/*     */     }
/*     */     
/*     */     
/* 103 */     return set;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\sift\SiftInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */