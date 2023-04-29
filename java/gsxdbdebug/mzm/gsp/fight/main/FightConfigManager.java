/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import mzm.gsp.fight.ai.script.fighter.CommonAI;
/*     */ import mzm.gsp.fight.confbean.MonsterProb;
/*     */ import mzm.gsp.fight.confbean.SFightOperateCfg;
/*     */ import mzm.gsp.fight.confbean.SFightTypeCfg;
/*     */ import mzm.gsp.fight.confbean.SLostHpToAngerCfg;
/*     */ import mzm.gsp.fight.confbean.SMonsterFightCfg;
/*     */ import mzm.gsp.fight.confbean.SMonsterNumCfg;
/*     */ import mzm.gsp.fight.confbean.SNewerPassiveEffect;
/*     */ import mzm.gsp.fight.confbean.SRoleNum2MonsterNumCfg;
/*     */ import mzm.gsp.pvc.confbean.PVCRobotCfg;
/*     */ import mzm.gsp.pvc.confbean.PVCRobotCfgList;
/*     */ import mzm.gsp.pvc.confbean.SPVCAICfg;
/*     */ import mzm.gsp.pvc.confbean.SPVCRobotMapCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class FightConfigManager
/*     */ {
/*  32 */   private static final FightConfigManager instance = new FightConfigManager();
/*     */   
/*     */   static FightConfigManager getInstance() {
/*  35 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   void init() {}
/*     */   
/*     */ 
/*     */   public String getPVCAIString(int occupationid)
/*     */   {
/*  45 */     SPVCAICfg pvcAICfg = SPVCAICfg.get(occupationid);
/*  46 */     if (pvcAICfg != null) {
/*  47 */       return pvcAICfg.aiName;
/*     */     }
/*  49 */     return CommonAI.class.getSimpleName();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int randomGenerateMonsterID(int monsterFightCfgID)
/*     */   {
/*  59 */     SMonsterFightCfg cfg = SMonsterFightCfg.get(monsterFightCfgID);
/*  60 */     int p = Xdb.random().nextInt(10000);
/*  61 */     for (MonsterProb mp : cfg.monsterProbs) {
/*  62 */       if (p < mp.prob) {
/*  63 */         return mp.monsterid;
/*     */       }
/*     */     }
/*  66 */     FightManager.logger.error("随机生成战斗怪物id失败，战斗怪物配置id=" + monsterFightCfgID);
/*  67 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getMonsterNum(int roleNum2MonsterCfgID, int roleNum)
/*     */   {
/*  78 */     SRoleNum2MonsterNumCfg roleNum2MonsterNumCfg = SRoleNum2MonsterNumCfg.get(roleNum2MonsterCfgID);
/*  79 */     if (roleNum2MonsterNumCfg == null) {
/*  80 */       return -1;
/*     */     }
/*  82 */     int monsterNumCfgID = ((Integer)roleNum2MonsterNumCfg.monsterNumCfgs.get(roleNum - 1)).intValue();
/*  83 */     return getMonsterNum(monsterNumCfgID);
/*     */   }
/*     */   
/*     */   int getMonsterNum(int monsterNumCfgID) {
/*  87 */     SMonsterNumCfg cfg = SMonsterNumCfg.get(monsterNumCfgID);
/*  88 */     if (cfg == null) {
/*  89 */       return -1;
/*     */     }
/*  91 */     int p = Xdb.random().nextInt(10000);
/*  92 */     for (int i = 0; i < cfg.probs.size(); i++) {
/*  93 */       if (p < ((Integer)cfg.probs.get(i)).intValue()) {
/*  94 */         return i + 1;
/*     */       }
/*     */     }
/*  97 */     return -1;
/*     */   }
/*     */   
/*     */   SFightOperateCfg getFightOperateCfgByOperateType(int operateType) {
/* 101 */     return SFightOperateCfg.get(operateType);
/*     */   }
/*     */   
/*     */   SFightTypeCfg getFightTypeCfg(int fightType) {
/* 105 */     return SFightTypeCfg.get(fightType);
/*     */   }
/*     */   
/*     */   boolean hasPVCRobotClassid(int classid) {
/* 109 */     return SPVCRobotMapCfg.get(classid) != null;
/*     */   }
/*     */   
/*     */   PVCRobotCfg getPVCRobotCfg(int classid, int occupation, int gender, int level) {
/* 113 */     PVCRobotCfgList pvcRobotCfgList = (PVCRobotCfgList)SPVCRobotMapCfg.get(classid).occu2RobotCfgs.get(Integer.valueOf(occupation));
/* 114 */     PVCRobotCfg retCfg = (PVCRobotCfg)pvcRobotCfgList.pvcRobotCfgs.get(0);
/* 115 */     for (PVCRobotCfg pvcRobotCfg : pvcRobotCfgList.pvcRobotCfgs) {
/* 116 */       if ((pvcRobotCfg.gender == gender) && (pvcRobotCfg.levelMax >= level) && (pvcRobotCfg.levelMin <= level)) {
/* 117 */         retCfg = pvcRobotCfg;
/* 118 */         break;
/*     */       }
/*     */     }
/* 121 */     return retCfg;
/*     */   }
/*     */   
/*     */   PVCRobotCfg getPVCRobotCfg(int classid, int level) {
/* 125 */     List<Integer> occupations = new ArrayList();
/* 126 */     if (SPVCRobotMapCfg.getAll().containsKey(Integer.valueOf(classid))) {
/* 127 */       occupations.addAll(SPVCRobotMapCfg.get(classid).occu2RobotCfgs.keySet());
/*     */     } else {
/* 129 */       return null;
/*     */     }
/* 131 */     int index = Xdb.random().nextInt(occupations.size());
/* 132 */     int occupation = ((Integer)occupations.get(index)).intValue();
/* 133 */     if (Xdb.random().nextBoolean()) {
/* 134 */       return getPVCRobotCfg(classid, occupation, 2, level);
/*     */     }
/* 136 */     return getPVCRobotCfg(classid, occupation, 1, level);
/*     */   }
/*     */   
/*     */ 
/*     */   List<Integer> getPartnerids(PVCRobotCfg pvcRobotCfg)
/*     */   {
/* 142 */     if ((pvcRobotCfg.partnerRobotCount <= 0) || (pvcRobotCfg.partnerRandomMap.size() <= 0)) {
/* 143 */       return new ArrayList();
/*     */     }
/* 145 */     Map<Integer, Integer> randomMap = new HashMap();
/* 146 */     randomMap.putAll(pvcRobotCfg.partnerRandomMap);
/* 147 */     List<Integer> retList = new ArrayList(pvcRobotCfg.partnerRobotCount);
/* 148 */     for (int i = 0; i < pvcRobotCfg.partnerRobotCount; i++) {
/* 149 */       int ret = randomFromMap(randomMap);
/* 150 */       if (ret <= 0) {
/*     */         break;
/*     */       }
/* 153 */       randomMap.remove(Integer.valueOf(ret));
/* 154 */       retList.add(Integer.valueOf(ret));
/*     */     }
/* 156 */     return retList;
/*     */   }
/*     */   
/*     */   private int randomFromMap(Map<Integer, Integer> randomMap) {
/* 160 */     int total = 0;
/* 161 */     for (Integer rate : randomMap.values()) {
/* 162 */       total += rate.intValue();
/*     */     }
/* 164 */     int random = Xdb.random().nextInt(total);
/* 165 */     int currentValue = 0;
/* 166 */     for (Map.Entry<Integer, Integer> entry : randomMap.entrySet()) {
/* 167 */       currentValue += ((Integer)entry.getValue()).intValue();
/* 168 */       if (random < currentValue) {
/* 169 */         return ((Integer)entry.getKey()).intValue();
/*     */       }
/*     */     }
/* 172 */     return 0;
/*     */   }
/*     */   
/*     */   int getPetid(PVCRobotCfg pvcrouRobotCfg) {
/* 176 */     if (pvcrouRobotCfg.petRobotids.size() <= 0) {
/* 177 */       return -1;
/*     */     }
/* 179 */     int index = Xdb.random().nextInt(pvcrouRobotCfg.petRobotids.size());
/* 180 */     return ((Integer)pvcrouRobotCfg.petRobotids.get(index)).intValue();
/*     */   }
/*     */   
/*     */   int getAddAnger(double lostHpRateValue)
/*     */   {
/* 185 */     int anger = 0;
/* 186 */     for (SLostHpToAngerCfg lostHpToAngerCfg : SLostHpToAngerCfg.getAll().values()) {
/* 187 */       if (lostHpRateValue <= lostHpToAngerCfg.lostHpRateMax) {
/* 188 */         anger = lostHpToAngerCfg.anger;
/* 189 */         break;
/*     */       }
/* 191 */       anger = lostHpToAngerCfg.anger;
/*     */     }
/*     */     
/*     */ 
/* 195 */     return anger;
/*     */   }
/*     */   
/*     */   int getNewerPassiveEffect(int subLevel) {
/* 199 */     int id = 0;
/* 200 */     for (SNewerPassiveEffect newerPassiveEffect : SNewerPassiveEffect.getAll().values()) {
/* 201 */       if (subLevel <= newerPassiveEffect.subLevel) {
/* 202 */         id = newerPassiveEffect.passiveEffectid;
/* 203 */         break;
/*     */       }
/*     */     }
/* 206 */     return id;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FightConfigManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */