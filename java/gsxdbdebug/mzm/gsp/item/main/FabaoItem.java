/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import mzm.gsp.fabao.confbean.ProType2Value;
/*     */ import mzm.gsp.fabao.confbean.SFabaoAttributeCfg;
/*     */ import mzm.gsp.fabao.main.FabaoInterface;
/*     */ import mzm.gsp.item.confbean.SFabaoItem;
/*     */ import xbean.Item;
/*     */ 
/*     */ public class FabaoItem extends BasicItem
/*     */ {
/*     */   public FabaoItem(Item item)
/*     */   {
/*  15 */     super(item);
/*     */   }
/*     */   
/*     */   public int getExp() {
/*  19 */     Integer curExp = getExtra(ItemStoreEnum.FABAO_CUR_EXP);
/*  20 */     return curExp == null ? 0 : curExp.intValue();
/*     */   }
/*     */   
/*     */   public void setExp(int exp) {
/*  24 */     setExtra(ItemStoreEnum.FABAO_CUR_EXP, exp);
/*     */   }
/*     */   
/*     */   public int getLevel() {
/*  28 */     Integer level = getExtra(ItemStoreEnum.FABAO_CUR_LV);
/*  29 */     return level == null ? 0 : level.intValue();
/*     */   }
/*     */   
/*     */   public int getRankExp() {
/*  33 */     Integer rankExp = getExtra(ItemStoreEnum.FABAO_CUR_RANK_EXP);
/*  34 */     return rankExp == null ? 0 : rankExp.intValue();
/*     */   }
/*     */   
/*     */   public void setRankExp(int rankExp) {
/*  38 */     setExtra(ItemStoreEnum.FABAO_CUR_RANK_EXP, rankExp);
/*     */   }
/*     */   
/*     */   public int getOwnSkillId() {
/*  42 */     Integer ownSkillid = getExtra(ItemStoreEnum.FABAO_OWN_SKILL_ID);
/*  43 */     return ownSkillid == null ? 0 : ownSkillid.intValue();
/*     */   }
/*     */   
/*     */   public void setOwnSkillid(int skillid) {
/*  47 */     setExtra(ItemStoreEnum.FABAO_OWN_SKILL_ID, skillid);
/*     */   }
/*     */   
/*     */   public int getRankRandomSkillid() {
/*  51 */     Integer skillId = getExtra(ItemStoreEnum.FABAO_RANK_RANDOM_SKILL_ID);
/*  52 */     return skillId == null ? 0 : skillId.intValue();
/*     */   }
/*     */   
/*     */   public void setRankRandomSkillid(int skillid) {
/*  56 */     setExtra(ItemStoreEnum.FABAO_RANK_RANDOM_SKILL_ID, skillid);
/*     */   }
/*     */   
/*     */   public int getNextRankSkillid() {
/*  60 */     Integer skillId = getExtra(ItemStoreEnum.FABAO_NEXT_RANK_SKILL_ID);
/*  61 */     return skillId == null ? getOwnSkillId() : skillId.intValue();
/*     */   }
/*     */   
/*     */   public void setNextRankSkillid(int skillid) {
/*  65 */     setExtra(ItemStoreEnum.FABAO_NEXT_RANK_SKILL_ID, skillid);
/*     */   }
/*     */   
/*     */   public int getFaBaoAutoRankUpTo() {
/*  69 */     Integer rankTo = getExtra(ItemStoreEnum.FABAO_AUTO_RANKUP_TO);
/*  70 */     return rankTo == null ? 0 : rankTo.intValue();
/*     */   }
/*     */   
/*     */   public void setFaBaoAutoRankUpTo(int rankTo) {
/*  74 */     setExtra(ItemStoreEnum.FABAO_AUTO_RANKUP_TO, rankTo);
/*     */   }
/*     */   
/*     */   public int getWashSkillId() {
/*  78 */     Integer skillId = getExtra(ItemStoreEnum.FABAO_WASH_SKILL_ID);
/*  79 */     return skillId == null ? 0 : skillId.intValue();
/*     */   }
/*     */   
/*     */   public void setWashSkillId(int skillid) {
/*  83 */     setExtra(ItemStoreEnum.FABAO_WASH_SKILL_ID, skillid);
/*     */   }
/*     */   
/*     */   public void setCfgid(int cfgid) {
/*  87 */     this.xItem.setCfgid(cfgid);
/*     */   }
/*     */   
/*     */   public void setFaoLevel(int lv) {
/*  91 */     setExtra(ItemStoreEnum.FABAO_CUR_LV, lv);
/*     */   }
/*     */   
/*     */   protected boolean onCreateItem()
/*     */   {
/*  96 */     initFabao();
/*  97 */     return true;
/*     */   }
/*     */   
/*     */   void initFabao() {
/* 101 */     int fabaoid = getCfgId();
/* 102 */     SFabaoItem fabaoItem = SFabaoItem.get(fabaoid);
/* 103 */     if (fabaoItem == null) {
/* 104 */       throw new RuntimeException(String.format("[item]FabaoItem.initFabao@fabao config is null|fabaoid=%d", new Object[] { Integer.valueOf(fabaoid) }));
/*     */     }
/*     */     
/*     */ 
/* 108 */     setExtra(ItemStoreEnum.FABAO_CUR_LV, 1);
/* 109 */     setExtra(ItemStoreEnum.FABAO_CUR_EXP, 0);
/* 110 */     setExtra(ItemStoreEnum.FABAO_CUR_RANK_EXP, 0);
/*     */     
/* 112 */     SFabaoItem fabao = SFabaoItem.get(getCfgId());
/* 113 */     initSkill(fabao);
/*     */   }
/*     */   
/*     */   void initSkill(SFabaoItem fabao)
/*     */   {
/* 118 */     int skillid = FabaoInterface.getRandomRankSkillid(fabao);
/* 119 */     setOwnSkillid(skillid);
/*     */   }
/*     */   
/*     */   public java.util.Map<Integer, Integer> getProMap()
/*     */   {
/* 124 */     SFabaoItem sfabaoItem = SFabaoItem.get(getCfgId());
/* 125 */     SFabaoAttributeCfg sFabaoAttributeCfg = SFabaoAttributeCfg.get(sfabaoItem.attrId);
/* 126 */     if (sFabaoAttributeCfg == null) {
/* 127 */       return Collections.EMPTY_MAP;
/*     */     }
/* 129 */     ProType2Value proType2Value = (ProType2Value)sFabaoAttributeCfg.lv2Pro.get(Integer.valueOf(getLevel()));
/* 130 */     if (proType2Value == null) {
/* 131 */       return Collections.EMPTY_MAP;
/*     */     }
/* 133 */     return proType2Value.pro2ValueMap;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\FabaoItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */