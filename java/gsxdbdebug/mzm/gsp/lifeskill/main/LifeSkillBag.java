/*     */ package mzm.gsp.lifeskill.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.item.confbean.SBaoshiduItem;
/*     */ import mzm.gsp.item.confbean.SItemDrugInFightCfg;
/*     */ import mzm.gsp.item.confbean.SItemDrugOutFightCfg;
/*     */ import mzm.gsp.item.confbean.SPetLifeItem;
/*     */ import mzm.gsp.skill.confbean.SCookDrugQualityCfg;
/*     */ import mzm.gsp.skill.confbean.SLifeSkillBag;
/*     */ import mzm.gsp.skill.confbean.SLifeSkillBagCfg;
/*     */ import mzm.gsp.skill.confbean.SLifeSkillBagLevelUpCfg;
/*     */ import mzm.gsp.skill.confbean.SLifeSkillVigorCostCfg;
/*     */ 
/*     */ public class LifeSkillBag<T extends LifeSkill>
/*     */ {
/*     */   protected int lifeSkillBagCfgId;
/*     */   protected int level;
/*     */   protected Integer levelUpCfgId;
/*     */   
/*     */   public Integer getLeveluNeedSilver()
/*     */   {
/*  26 */     if (this.levelUpCfgId == null) {
/*  27 */       return null;
/*     */     }
/*  29 */     SLifeSkillBagLevelUpCfg sLifeSkillBagLevelUpCfg = SLifeSkillBagLevelUpCfg.get(this.levelUpCfgId.intValue());
/*  30 */     if (sLifeSkillBagLevelUpCfg == null) {
/*  31 */       return null;
/*     */     }
/*  33 */     return Integer.valueOf(sLifeSkillBagLevelUpCfg.needSilver);
/*     */   }
/*     */   
/*     */   public Integer getLevelUpNeedBangGong() {
/*  37 */     if (this.levelUpCfgId == null) {
/*  38 */       return null;
/*     */     }
/*  40 */     SLifeSkillBagLevelUpCfg sLifeSkillBagLevelUpCfg = SLifeSkillBagLevelUpCfg.get(this.levelUpCfgId.intValue());
/*  41 */     if (sLifeSkillBagLevelUpCfg == null) {
/*  42 */       return null;
/*     */     }
/*  44 */     return Integer.valueOf(sLifeSkillBagLevelUpCfg.needBanggong);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public LifeSkillBag(int lefSkillBagCfgId, int level)
/*     */   {
/*  53 */     this.lifeSkillBagCfgId = lefSkillBagCfgId;
/*  54 */     this.level = level;
/*  55 */     SLifeSkillBagCfg cfg = SLifeSkillBagCfg.get(this.lifeSkillBagCfgId);
/*  56 */     this.levelUpCfgId = LifeSkillManager.getLevelUpCfgId(cfg.levelUpTypeId, level);
/*     */   }
/*     */   
/*     */   public int getSkillBagType() {
/*  60 */     SLifeSkillBagCfg cfg = SLifeSkillBagCfg.get(this.lifeSkillBagCfgId);
/*  61 */     return cfg.skillBagType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<T> getAvaliableLifeSkillList()
/*     */   {
/*  68 */     SLifeSkillBagCfg cfg = SLifeSkillBagCfg.get(this.lifeSkillBagCfgId);
/*  69 */     List<T> lifeSkills = new ArrayList();
/*  70 */     for (Integer skillId : cfg.skillBagList) {
/*  71 */       SLifeSkillBag sLifeSkillBag = SLifeSkillBag.get(skillId.intValue());
/*  72 */       if (sLifeSkillBag.openLevel <= this.level) {
/*  73 */         T skill = newLifeSkill(skillId.intValue());
/*  74 */         skill.setParent(this);
/*  75 */         lifeSkills.add(skill);
/*     */       }
/*     */     }
/*  78 */     return lifeSkills;
/*     */   }
/*     */   
/*     */   private int getMaxQuality(int skillId) {
/*  82 */     for (SCookDrugQualityCfg temp : SCookDrugQualityCfg.getAll().values()) {
/*  83 */       if ((temp.itemId == skillId) && 
/*     */       
/*     */ 
/*  86 */         (temp.maxLevel > this.level) && (temp.minLevel <= this.level))
/*     */       {
/*     */ 
/*  89 */         return temp.itemMaxQuality; }
/*     */     }
/*  91 */     return 0;
/*     */   }
/*     */   
/*     */   private int getItemQuality(int itemId) {
/*  95 */     SItemDrugOutFightCfg outFightCfg = SItemDrugOutFightCfg.get(itemId);
/*  96 */     if (outFightCfg != null) {
/*  97 */       return outFightCfg.drugPro;
/*     */     }
/*  99 */     SItemDrugInFightCfg inFightCfg = SItemDrugInFightCfg.get(itemId);
/* 100 */     if (inFightCfg != null) {
/* 101 */       return inFightCfg.drugPro;
/*     */     }
/* 103 */     SPetLifeItem item = SPetLifeItem.get(itemId);
/* 104 */     if (item != null) {
/* 105 */       return item.itemPro;
/*     */     }
/* 107 */     SBaoshiduItem baoshiduItem = SBaoshiduItem.get(itemId);
/* 108 */     if (baoshiduItem != null) {
/* 109 */       return baoshiduItem.drugPro;
/*     */     }
/* 111 */     return Integer.MAX_VALUE;
/*     */   }
/*     */   
/*     */   public void setLevel(int newLevel) {
/* 115 */     this.level = newLevel;
/*     */   }
/*     */   
/*     */   public int getAllAvaliableItemCount() {
/* 119 */     int count = 0;
/* 120 */     SLifeSkillBagCfg cfg = SLifeSkillBagCfg.get(this.lifeSkillBagCfgId);
/* 121 */     for (Integer skillId : cfg.skillBagList) {
/* 122 */       SLifeSkillBag sLifeSkillBag = SLifeSkillBag.get(skillId.intValue());
/*     */       
/* 124 */       if (sLifeSkillBag.openLevel <= this.level) {
/* 125 */         count++;
/*     */       }
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
/*     */ 
/*     */ 
/*     */ 
/* 143 */     return count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Map<Integer, T> getAvaliableLifeSkillMap()
/*     */   {
/* 151 */     SLifeSkillBagCfg cfg = SLifeSkillBagCfg.get(this.lifeSkillBagCfgId);
/* 152 */     Map<Integer, T> lifeSkillMap = new HashMap();
/* 153 */     for (int i = 0; i < cfg.skillBagList.size(); i++) {
/* 154 */       int skillId = ((Integer)cfg.skillBagList.get(i)).intValue();
/* 155 */       SLifeSkillBag sLifeSkillBag = SLifeSkillBag.get(skillId);
/* 156 */       if (sLifeSkillBag.openLevel <= this.level) {
/* 157 */         T skill = newLifeSkill(skillId);
/* 158 */         skill.setParent(this);
/* 159 */         lifeSkillMap.put(Integer.valueOf(i), skill);
/*     */       }
/*     */     }
/* 162 */     return lifeSkillMap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public T getLifeSkill(int id)
/*     */   {
/* 172 */     SLifeSkillBagCfg cfg = SLifeSkillBagCfg.get(this.lifeSkillBagCfgId);
/* 173 */     if (!cfg.skillBagList.contains(Integer.valueOf(id))) {
/* 174 */       return null;
/*     */     }
/* 176 */     SLifeSkillBag sLifeSkillBag = SLifeSkillBag.get(id);
/* 177 */     if (sLifeSkillBag.openLevel <= this.level) {
/* 178 */       T skill = newLifeSkill(id);
/* 179 */       skill.setParent(this);
/* 180 */       return skill;
/*     */     }
/* 182 */     return null;
/*     */   }
/*     */   
/*     */   public T newLifeSkill(int skillId) {
/* 186 */     return null;
/*     */   }
/*     */   
/*     */   public int getCostVigor() {
/* 190 */     for (SLifeSkillVigorCostCfg sLifeSkillVigorCostCfg : SLifeSkillVigorCostCfg.getAll().values()) {
/* 191 */       if ((sLifeSkillVigorCostCfg.skillBagCfgId == this.lifeSkillBagCfgId) && 
/*     */       
/*     */ 
/* 194 */         (sLifeSkillVigorCostCfg.maxLevel >= this.level) && (sLifeSkillVigorCostCfg.minLevel <= this.level))
/*     */       {
/*     */ 
/* 197 */         return sLifeSkillVigorCostCfg.costVigor; }
/*     */     }
/* 199 */     return -1;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lifeskill\main\LifeSkillBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */