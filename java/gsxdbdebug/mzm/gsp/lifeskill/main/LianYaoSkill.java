/*     */ package mzm.gsp.lifeskill.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.item.confbean.SBaoshiduItem;
/*     */ import mzm.gsp.item.confbean.SItemDrugInFightCfg;
/*     */ import mzm.gsp.item.confbean.SItemDrugOutFightCfg;
/*     */ import mzm.gsp.item.confbean.SPetLifeItem;
/*     */ import mzm.gsp.skill.confbean.LifeSkillShiftItemId2ItemIdCfg;
/*     */ import mzm.gsp.skill.confbean.SCookDrugQualityCfg;
/*     */ import mzm.gsp.skill.confbean.SLifeSkillBag;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LianYaoSkill
/*     */   extends LifeSkill
/*     */ {
/*  22 */   private static final Logger logger = Logger.getLogger(LianYaoSkill.class);
/*     */   
/*     */   public LianYaoSkill(SLifeSkillBag skillBag, int level) {
/*  25 */     super(skillBag, level);
/*     */   }
/*     */   
/*     */   public int getId() {
/*  29 */     return this.skillBag.id;
/*     */   }
/*     */   
/*     */   public List<Integer> getItemIdList() {
/*  33 */     List<Integer> itemIdList = new ArrayList();
/*  34 */     if (this.skillBag.idType == 0) {
/*  35 */       itemIdList.add(Integer.valueOf(this.skillBag.siftItemId));
/*     */     } else {
/*  37 */       LifeSkillShiftItemId2ItemIdCfg cfg = LifeSkillShiftItemId2ItemIdCfg.get(this.skillBag.siftItemId);
/*  38 */       itemIdList.addAll(cfg.itemIdList);
/*     */     }
/*     */     
/*  41 */     return itemIdList;
/*     */   }
/*     */   
/*     */   public int generateItem() {
/*  45 */     SCookDrugQualityCfg sCookDrugQualityCfg = randomQuality();
/*  46 */     if (sCookDrugQualityCfg == null) {
/*  47 */       return -1;
/*     */     }
/*  49 */     if (this.skillBag.idType == 0) {
/*  50 */       return this.skillBag.siftItemId;
/*     */     }
/*  52 */     return randomItemId(sCookDrugQualityCfg);
/*     */   }
/*     */   
/*     */   protected SCookDrugQualityCfg randomQuality() {
/*  56 */     SCookDrugQualityCfg sCookDrugQualityCfg = null;
/*  57 */     for (SCookDrugQualityCfg temp : SCookDrugQualityCfg.getAll().values()) {
/*  58 */       if ((temp.itemId == this.skillBag.id) && 
/*     */       
/*     */ 
/*  61 */         (temp.maxLevel > this.level) && (temp.minLevel <= this.level))
/*     */       {
/*     */ 
/*  64 */         sCookDrugQualityCfg = temp; }
/*     */     }
/*  66 */     return sCookDrugQualityCfg;
/*     */   }
/*     */   
/*     */   protected int randomItemId(SCookDrugQualityCfg sCookDrugQualityCfg) {
/*  70 */     List<Integer> itemIdList = getItemIdList();
/*  71 */     if (itemIdList.isEmpty()) {
/*  72 */       logger.error("cook drug found item sift cfg not exist skillbag id " + this.skillBag.id);
/*  73 */       return -1;
/*     */     }
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
/*  87 */     int quality = sCookDrugQualityCfg.itemMaxQuality;
/*  88 */     for (Integer itemId : itemIdList) {
/*  89 */       SItemDrugOutFightCfg outFightCfg = SItemDrugOutFightCfg.get(itemId.intValue());
/*  90 */       if ((outFightCfg != null) && (outFightCfg.drugPro == quality)) {
/*  91 */         return itemId.intValue();
/*     */       }
/*  93 */       SItemDrugInFightCfg inFightCfg = SItemDrugInFightCfg.get(itemId.intValue());
/*  94 */       if ((inFightCfg != null) && (inFightCfg.drugPro == quality)) {
/*  95 */         return itemId.intValue();
/*     */       }
/*  97 */       SPetLifeItem item = SPetLifeItem.get(itemId.intValue());
/*  98 */       if ((item != null) && (item.itemPro == quality)) {
/*  99 */         return itemId.intValue();
/*     */       }
/* 101 */       SBaoshiduItem baoshiduItem = SBaoshiduItem.get(itemId.intValue());
/* 102 */       if ((baoshiduItem != null) && (baoshiduItem.drugPro == quality)) {
/* 103 */         return itemId.intValue();
/*     */       }
/*     */     }
/* 106 */     return -1;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lifeskill\main\LianYaoSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */