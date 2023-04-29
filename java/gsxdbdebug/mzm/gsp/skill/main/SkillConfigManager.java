/*     */ package mzm.gsp.skill.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.skill.confbean.MonsterSkill2Prob;
/*     */ import mzm.gsp.skill.confbean.SEnergySkillCfg;
/*     */ import mzm.gsp.skill.confbean.SMonsterSkillCfg;
/*     */ import mzm.gsp.skill.confbean.STPassiveSkillTypeTable;
/*     */ import mzm.gsp.skill.confbean.STPassiveSkillTypeTableInfo;
/*     */ import mzm.gsp.skill.formula.fighter.SkillFormulaFactory;
/*     */ import mzm.gsp.skill.formula.outfight.FormulaFunctionFactory;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class SkillConfigManager
/*     */ {
/*     */   private static final int NORMAL_SKILL_IDX = 0;
/*     */   private static final int HIGH_SKILL_IDX = 1;
/*     */   private static final int SUPER_SKILL_IDX = 2;
/*     */   private static final int PROB_BASE = 10000;
/*     */   private static SkillConfigManager instance;
/*     */   
/*     */   static SkillConfigManager getInstance()
/*     */   {
/*  35 */     if (instance == null) {
/*  36 */       instance = new SkillConfigManager();
/*     */     }
/*  38 */     return instance;
/*     */   }
/*     */   
/*     */   void init() {
/*  42 */     SkillFormulaFactory.getInstance();
/*  43 */     FormulaFunctionFactory.init();
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
/*     */   List<Integer> randomSkills(int cfgId, int skillNum, Set<Integer> exceptSet)
/*     */   {
/*  56 */     List<Integer> skills = new ArrayList();
/*  57 */     if (cfgId == 0) {
/*  58 */       return skills;
/*     */     }
/*  60 */     SMonsterSkillCfg cfg = SMonsterSkillCfg.get(cfgId);
/*     */     
/*  62 */     if (cfg == null)
/*     */     {
/*  64 */       return skills;
/*     */     }
/*  66 */     if (cfg.monsterSkill2Prob.isEmpty())
/*     */     {
/*  68 */       return skills;
/*     */     }
/*  70 */     List<MonsterSkill2Prob> randomList = new ArrayList();
/*  71 */     for (MonsterSkill2Prob prob : cfg.monsterSkill2Prob) {
/*  72 */       if ((exceptSet == null) || (!exceptSet.contains(Integer.valueOf(prob.skillid))))
/*     */       {
/*     */ 
/*  75 */         randomList.add(prob); }
/*     */     }
/*  77 */     if (randomList.isEmpty()) {
/*  78 */       return skills;
/*     */     }
/*  80 */     if ((skillNum <= 0) && (cfg.randomType == 1)) {
/*  81 */       skillNum = 1;
/*     */     }
/*  83 */     if (cfg.randomType == 0) {
/*  84 */       while (skills.size() != skillNum) {
/*  85 */         if (randomList.size() <= skillNum - skills.size()) {
/*  86 */           for (MonsterSkill2Prob prob : randomList) {
/*  87 */             skills.add(Integer.valueOf(prob.skillid));
/*     */           }
/*     */         }
/*     */         else {
/*  91 */           MonsterSkill2Prob prob = (MonsterSkill2Prob)randomList.remove(0);
/*  92 */           int randomValue = Xdb.random().nextInt(10000);
/*  93 */           if (randomValue <= prob.skillidProb) {
/*  94 */             skills.add(Integer.valueOf(prob.skillid));
/*     */           }
/*  96 */           if (randomList.isEmpty())
/*     */             break;
/*     */         }
/*     */       }
/*     */     }
/* 101 */     while (skills.size() != skillNum) {
/* 102 */       if (randomList.size() <= skillNum - skills.size()) {
/* 103 */         for (MonsterSkill2Prob prob : randomList) {
/* 104 */           skills.add(Integer.valueOf(prob.skillid));
/*     */         }
/* 106 */         break;
/*     */       }
/* 108 */       int totalProp = 0;
/* 109 */       int randomValue = Xdb.random().nextInt(10000);
/* 110 */       for (int i = 0; i < randomList.size(); i++) {
/* 111 */         MonsterSkill2Prob prob = (MonsterSkill2Prob)randomList.get(i);
/* 112 */         totalProp += prob.skillidProb;
/* 113 */         if (randomValue <= totalProp) {
/* 114 */           randomList.remove(i);
/* 115 */           skills.add(Integer.valueOf(prob.skillid));
/* 116 */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 121 */     return skills;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<Integer> getMonsterSkills(int cfgid, int skillnum)
/*     */   {
/* 131 */     return randomSkills(cfgid, skillnum, null);
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
/*     */   Set<Integer> getMonsterSkills(int cfgid, Set<Integer> studySkills, int skillnum)
/*     */   {
/* 144 */     Set<Integer> set = new HashSet();
/* 145 */     List<Integer> skillList = randomSkills(cfgid, skillnum, studySkills);
/* 146 */     set.addAll(skillList);
/* 147 */     return set;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<Integer> getMonsterSkills(int cfgId)
/*     */   {
/* 157 */     return randomSkills(cfgId, -1, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Integer> getHigherSkill(int skillId)
/*     */   {
/* 165 */     List<Integer> skillList = new ArrayList();
/* 166 */     getNextSkills(skillId, skillList);
/* 167 */     return skillList;
/*     */   }
/*     */   
/* 170 */   private List<Integer> getNextSkills(int skillid, List<Integer> skillList) { int curSkillid = skillid;
/* 171 */     STPassiveSkillTypeTable stPassiveSkillTypeTable = STPassiveSkillTypeTable.get(curSkillid);
/* 172 */     if ((stPassiveSkillTypeTable != null) && 
/* 173 */       (stPassiveSkillTypeTable.skillTypeInfo.nextSkillId != 0)) {
/* 174 */       skillList.add(Integer.valueOf(stPassiveSkillTypeTable.skillTypeInfo.nextSkillId));
/* 175 */       curSkillid = stPassiveSkillTypeTable.skillTypeInfo.nextSkillId;
/* 176 */       getNextSkills(curSkillid, skillList);
/*     */     }
/*     */     
/* 179 */     return skillList;
/*     */   }
/*     */   
/*     */   private List<Integer> getBeforeSkills(int skillid, List<Integer> skillList) {
/* 183 */     int curSkillid = skillid;
/* 184 */     STPassiveSkillTypeTable stPassiveSkillTypeTable = STPassiveSkillTypeTable.get(curSkillid);
/* 185 */     if ((stPassiveSkillTypeTable != null) && 
/* 186 */       (stPassiveSkillTypeTable.skillTypeInfo.beforeSkillId != 0)) {
/* 187 */       skillList.add(Integer.valueOf(stPassiveSkillTypeTable.skillTypeInfo.beforeSkillId));
/* 188 */       curSkillid = stPassiveSkillTypeTable.skillTypeInfo.beforeSkillId;
/* 189 */       getBeforeSkills(curSkillid, skillList);
/*     */     }
/*     */     
/* 192 */     return skillList;
/*     */   }
/*     */   
/*     */   public boolean isSameSKill(int skillid, Set<Integer> skillList) {
/* 196 */     List<Integer> mutexList = new ArrayList();
/* 197 */     getBeforeSkills(skillid, mutexList);
/* 198 */     getNextSkills(skillid, mutexList);
/* 199 */     STPassiveSkillTypeTable stPassiveSkillTypeTable = STPassiveSkillTypeTable.get(skillid);
/* 200 */     if (stPassiveSkillTypeTable != null) {
/* 201 */       mutexList.addAll(stPassiveSkillTypeTable.skillTypeInfo.mutexList);
/*     */     }
/* 203 */     for (int j = 0; j < mutexList.size(); j++) {
/* 204 */       if (skillList.contains(mutexList.get(j))) {
/* 205 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 209 */     return false;
/*     */   }
/*     */   
/*     */   public Set<Integer> removeMutexSkill(Set<Integer> skillList) {
/* 213 */     Set<Integer> skillSet = new HashSet();
/* 214 */     skillSet.addAll(skillList);
/* 215 */     for (Iterator i$ = skillList.iterator(); i$.hasNext();) { skillId = (Integer)i$.next();
/* 216 */       STPassiveSkillTypeTable stPassiveSkillTypeTable = STPassiveSkillTypeTable.get(skillId.intValue());
/* 217 */       if ((stPassiveSkillTypeTable != null) && (stPassiveSkillTypeTable.skillTypeInfo.mutexList != null) && (stPassiveSkillTypeTable.skillTypeInfo.mutexList.size() > 0)) {
/* 218 */         for (Integer mutexSkillId : stPassiveSkillTypeTable.skillTypeInfo.mutexList) {
/* 219 */           if ((skillId.intValue() != mutexSkillId.intValue()) && (skillSet.contains(mutexSkillId)))
/* 220 */             skillSet.remove(skillId);
/*     */         }
/*     */       }
/*     */     }
/*     */     Integer skillId;
/* 225 */     return skillSet;
/*     */   }
/*     */   
/*     */   public void removeMutexSkill(Map<Integer, Integer> skill2Lv) {
/* 229 */     Iterator<Map.Entry<Integer, Integer>> iterator = skill2Lv.entrySet().iterator();
/* 230 */     int skillId; Iterator i$; while (iterator.hasNext()) {
/* 231 */       Map.Entry<Integer, Integer> entry = (Map.Entry)iterator.next();
/* 232 */       skillId = ((Integer)entry.getKey()).intValue();
/* 233 */       STPassiveSkillTypeTable stPassiveSkillTypeTable = STPassiveSkillTypeTable.get(skillId);
/* 234 */       if ((stPassiveSkillTypeTable != null) && 
/*     */       
/*     */ 
/* 237 */         (stPassiveSkillTypeTable.skillTypeInfo.mutexList != null))
/*     */       {
/*     */ 
/* 240 */         for (i$ = stPassiveSkillTypeTable.skillTypeInfo.mutexList.iterator(); i$.hasNext();) { int mutexSkillId = ((Integer)i$.next()).intValue();
/* 241 */           if ((skillId != mutexSkillId) && (skill2Lv.containsKey(Integer.valueOf(mutexSkillId)))) {
/* 242 */             iterator.remove();
/* 243 */             break;
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
/*     */   public boolean isHightSkill(int skillId)
/*     */   {
/* 256 */     return isIdxEqual(skillId, 1);
/*     */   }
/*     */   
/*     */   private boolean isIdxEqual(int skillId, int typeSkillIdx) {
/* 260 */     STPassiveSkillTypeTable stPassiveSkillTypeTable = STPassiveSkillTypeTable.get(skillId);
/* 261 */     if (stPassiveSkillTypeTable == null) {
/* 262 */       return false;
/*     */     }
/* 264 */     return stPassiveSkillTypeTable.skillTypeInfo.index == typeSkillIdx;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isLowSkill(int skillId)
/*     */   {
/* 273 */     return isIdxEqual(skillId, 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isSuperSkill(int skillId)
/*     */   {
/* 283 */     return isIdxEqual(skillId, 2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getExchangeSkill(int skillid, int energy)
/*     */   {
/* 294 */     for (SEnergySkillCfg energySkillCfg : SEnergySkillCfg.getAll().values()) {
/* 295 */       if ((energySkillCfg.skillid == skillid) && (energySkillCfg.energy == energy)) {
/* 296 */         return energySkillCfg.changeSkillid;
/*     */       }
/*     */     }
/* 299 */     return -1;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\main\SkillConfigManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */