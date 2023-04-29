/*     */ package mzm.gsp.lifeskill.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.gang.SSyncMiFangLevelNotEqual;
/*     */ import mzm.gsp.lifeskill.SSyncCommonInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.skill.confbean.LifeSkillShiftItemId2ItemIdCfg;
/*     */ import mzm.gsp.skill.confbean.SLifeSkillBag;
/*     */ import mzm.gsp.skill.confbean.SLifeSkillBagCfg;
/*     */ import xbean.RoleLifeSkill;
/*     */ import xtable.Role2lifeskill;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LifeSkillInterface
/*     */ {
/*     */   public static Map<Integer, Integer> getLifeSkill(long roleId)
/*     */   {
/*  25 */     Map<Integer, Integer> lifeskillMap = new HashMap();
/*  26 */     RoleLifeSkill xRoleRoleLifeSkill = Role2lifeskill.select(Long.valueOf(roleId));
/*  27 */     if (xRoleRoleLifeSkill == null) {
/*  28 */       return lifeskillMap;
/*     */     }
/*  30 */     lifeskillMap.putAll(xRoleRoleLifeSkill.getLifeskillbagmap());
/*  31 */     return lifeskillMap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static LifeSkillBag<?> getLifeSkill(long roleId, int skillBgId, int itemId)
/*     */   {
/*  42 */     RoleLifeSkill xRoleRoleLifeSkill = Role2lifeskill.get(Long.valueOf(roleId));
/*  43 */     if (xRoleRoleLifeSkill == null) {
/*  44 */       return null;
/*     */     }
/*  46 */     Integer lv = (Integer)xRoleRoleLifeSkill.getLifeskillbagmap().get(Integer.valueOf(skillBgId));
/*  47 */     if (lv == null) {
/*  48 */       return null;
/*     */     }
/*     */     
/*  51 */     Integer skillId = LifeSkillManager.getSkillIdByItemId(itemId);
/*  52 */     if (skillId == null) {
/*  53 */       return null;
/*     */     }
/*     */     
/*  56 */     if (!LifeSkillManager.isSkillInBag(skillBgId, skillId.intValue()))
/*     */     {
/*  58 */       return null;
/*     */     }
/*     */     
/*  61 */     SLifeSkillBag sLifeSkillBag = SLifeSkillBag.get(skillId.intValue());
/*  62 */     if (sLifeSkillBag.openLevel > lv.intValue()) {
/*  63 */       SSyncCommonInfo commonInfo = new SSyncCommonInfo();
/*  64 */       commonInfo.res = 5;
/*  65 */       OnlineManager.getInstance().sendAtOnce(roleId, commonInfo);
/*  66 */       return null;
/*     */     }
/*     */     
/*  69 */     LifeSkillBag lifeSkillBag = new LifeSkillBag(skillBgId, sLifeSkillBag.openLevel);
/*  70 */     return lifeSkillBag;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Map<Integer, List<Integer>> getAllLifeSkill2Item()
/*     */   {
/*  78 */     Map<Integer, List<Integer>> skill2item = new HashMap();
/*  79 */     for (SLifeSkillBagCfg skillBagCfg : SLifeSkillBagCfg.getAll().values()) {
/*  80 */       for (Integer skillBagId : skillBagCfg.skillBagList) {
/*  81 */         SLifeSkillBag sLifeSkillBag = SLifeSkillBag.get(skillBagId.intValue());
/*  82 */         List<Integer> itemIdList = new ArrayList();
/*  83 */         skill2item.put(skillBagId, itemIdList);
/*  84 */         if (sLifeSkillBag.idType == 0) {
/*  85 */           itemIdList.add(Integer.valueOf(sLifeSkillBag.siftItemId));
/*     */         } else {
/*  87 */           LifeSkillShiftItemId2ItemIdCfg cfg = LifeSkillShiftItemId2ItemIdCfg.get(sLifeSkillBag.siftItemId);
/*  88 */           itemIdList.addAll(cfg.itemIdList);
/*     */         }
/*     */       }
/*     */     }
/*  92 */     return skill2item;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static GangMiYaoSkill getGangLifeSkill(long roleId, int skillBgId, int skillId, boolean isSuccess)
/*     */   {
/* 103 */     RoleLifeSkill xRoleRoleLifeSkill = Role2lifeskill.get(Long.valueOf(roleId));
/* 104 */     if (xRoleRoleLifeSkill == null) {
/* 105 */       SSyncCommonInfo commonInfo = new SSyncCommonInfo();
/* 106 */       commonInfo.res = 5;
/* 107 */       OnlineManager.getInstance().sendAtOnce(roleId, commonInfo);
/* 108 */       return null;
/*     */     }
/* 110 */     Integer lv = (Integer)xRoleRoleLifeSkill.getLifeskillbagmap().get(Integer.valueOf(skillBgId));
/* 111 */     SLifeSkillBag sLifeSkillBag = SLifeSkillBag.get(skillId);
/* 112 */     if (lv == null) {
/* 113 */       SSyncMiFangLevelNotEqual sSyncMiFangLevelNotEqual = new SSyncMiFangLevelNotEqual();
/* 114 */       sSyncMiFangLevelNotEqual.level = sLifeSkillBag.openLevel;
/* 115 */       OnlineManager.getInstance().sendAtOnce(roleId, sSyncMiFangLevelNotEqual);
/* 116 */       return null;
/*     */     }
/*     */     
/* 119 */     if (sLifeSkillBag.openLevel > lv.intValue()) {
/* 120 */       SSyncCommonInfo commonInfo = new SSyncCommonInfo();
/* 121 */       commonInfo.res = 5;
/* 122 */       OnlineManager.getInstance().sendAtOnce(roleId, commonInfo);
/* 123 */       return null;
/*     */     }
/* 125 */     LianYaoSkillBag skillBag = new LianYaoSkillBag(skillBgId, lv.intValue());
/* 126 */     LianYaoSkill skill = skillBag.randomSkill(Arrays.asList(new Integer[] { Integer.valueOf(skillId) }));
/* 127 */     GangMiYaoSkill lifeSkillBag = new GangMiYaoSkill(sLifeSkillBag, sLifeSkillBag.openLevel, false, null);
/* 128 */     GangMiYaoSkill skill1 = new GangMiYaoSkill(skill.skillBag, skill.getLevel(), !isSuccess, lifeSkillBag);
/* 129 */     skill1.setParent(skillBag);
/* 130 */     return skill1;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lifeskill\main\LifeSkillInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */