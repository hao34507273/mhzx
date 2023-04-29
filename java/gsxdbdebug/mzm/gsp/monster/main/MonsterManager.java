/*     */ package mzm.gsp.monster.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.monster.confbean.BasicMonsterConfigInfo;
/*     */ import mzm.gsp.monster.confbean.SBasicMonsterCfg;
/*     */ import mzm.gsp.monster.confbean.SMonsterCfg;
/*     */ import mzm.gsp.monster.confbean.SMonsterGroupidToMonsterCfgids;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MonsterManager
/*     */ {
/*  19 */   private static final Logger logger = Logger.getLogger(MonsterManager.class);
/*     */   
/*  21 */   private static MonsterManager instance = new MonsterManager();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static MonsterManager getInstance()
/*     */   {
/*  29 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   SMonsterCfg getMonsterCfgByGroupId(int groupId, int level)
/*     */   {
/*  41 */     SMonsterGroupidToMonsterCfgids monsterGroupidToMonsterCfgids = SMonsterGroupidToMonsterCfgids.get(groupId);
/*  42 */     if (monsterGroupidToMonsterCfgids == null)
/*     */     {
/*  44 */       return null;
/*     */     }
/*  46 */     for (Iterator i$ = monsterGroupidToMonsterCfgids.monsterCfgids.iterator(); i$.hasNext();) { int cfgId = ((Integer)i$.next()).intValue();
/*     */       
/*  48 */       SMonsterCfg cfg = SMonsterCfg.get(cfgId);
/*  49 */       if (isInLevel(cfg, level))
/*     */       {
/*  51 */         return cfg;
/*     */       }
/*     */     }
/*  54 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isInLevel(SMonsterCfg cfg, int level)
/*     */   {
/*  65 */     if (level < cfg.levelLow)
/*     */     {
/*  67 */       return false;
/*     */     }
/*  69 */     if (level >= cfg.levelHigh)
/*     */     {
/*  71 */       return false;
/*     */     }
/*  73 */     return true;
/*     */   }
/*     */   
/*     */   boolean isMonsterCanCatch(int cfgid, int level)
/*     */   {
/*  78 */     SMonsterCfg cfg = SMonsterCfg.get(cfgid);
/*  79 */     if (cfg == null)
/*     */     {
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     return (cfg.catchedMonsterId != 0) && (PetInterface.isCanCarray(cfg.catchedMonsterId, level));
/*     */   }
/*     */   
/*     */   SMonsterCfg getMonsterCfg(int cfgid)
/*     */   {
/*  89 */     return SMonsterCfg.get(cfgid);
/*     */   }
/*     */   
/*     */   public Monster getMonsterById(int cfgid, int level)
/*     */   {
/*  94 */     SMonsterCfg cfg = checkCfg(cfgid, level);
/*  95 */     if (cfg == null)
/*     */     {
/*  97 */       return null;
/*     */     }
/*     */     
/* 100 */     SBasicMonsterCfg basicMonsterCfg = SBasicMonsterCfg.get(cfg.propertyTierId);
/* 101 */     if (basicMonsterCfg == null)
/*     */     {
/* 103 */       logger.error(String.format("MonsterManager.getMonsterById@can not find basic monster config info|cfgid=%d|property_tierid=%d|level=%d", new Object[] { Integer.valueOf(cfgid), Integer.valueOf(cfg.propertyTierId), Integer.valueOf(level) }));
/*     */       
/*     */ 
/*     */ 
/* 107 */       return null;
/*     */     }
/*     */     
/* 110 */     BasicMonsterConfigInfo basicMonsterConfigInfo = (BasicMonsterConfigInfo)basicMonsterCfg.levels.get(Integer.valueOf(level));
/* 111 */     if (basicMonsterConfigInfo == null)
/*     */     {
/* 113 */       logger.error(String.format("MonsterManager.getMonsterById@can not find basic monster config info|cfgid=%d|property_tierid=%d|level=%d", new Object[] { Integer.valueOf(cfgid), Integer.valueOf(cfg.propertyTierId), Integer.valueOf(level) }));
/*     */       
/*     */ 
/*     */ 
/* 117 */       return null;
/*     */     }
/*     */     
/* 120 */     return new Monster(cfg, basicMonsterConfigInfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   SMonsterCfg checkCfg(int cfgid, int level)
/*     */   {
/* 132 */     SMonsterCfg cfg = SMonsterCfg.get(cfgid);
/* 133 */     if (cfg == null)
/*     */     {
/* 135 */       logger.error("can not find monster cfgid =" + cfgid);
/* 136 */       return null;
/*     */     }
/*     */     
/* 139 */     if (isInLevel(cfg, level))
/*     */     {
/* 141 */       return cfg;
/*     */     }
/*     */     
/* 144 */     int groupId = cfg.groupId;
/* 145 */     cfg = getMonsterCfgByGroupId(groupId, level);
/* 146 */     if (cfg == null)
/*     */     {
/* 148 */       logger.error("怪物id = " + cfgid + " 找不到groupId = " + groupId + ",对应的等级 level = " + level);
/* 149 */       return null;
/*     */     }
/*     */     
/* 152 */     return cfg;
/*     */   }
/*     */   
/*     */   String getMonsterName(int cfgid)
/*     */   {
/* 157 */     SMonsterCfg cfg = SMonsterCfg.get(cfgid);
/* 158 */     if (cfg == null)
/*     */     {
/* 160 */       logger.error("can not find monster cfgid =" + cfgid);
/* 161 */       return null;
/*     */     }
/* 163 */     return cfg.name;
/*     */   }
/*     */   
/*     */   int getMonsterReward(int cfgid)
/*     */   {
/* 168 */     SMonsterCfg cfg = SMonsterCfg.get(cfgid);
/* 169 */     if (cfg == null)
/*     */     {
/* 171 */       logger.error("can not find monster cfgid =" + cfgid);
/* 172 */       return -1;
/*     */     }
/*     */     
/* 175 */     return cfg.rewardTableId;
/*     */   }
/*     */   
/*     */   int getMonsterCategoryId(int cfgid)
/*     */   {
/* 180 */     SMonsterCfg cfg = SMonsterCfg.get(cfgid);
/* 181 */     if (cfg == null)
/*     */     {
/* 183 */       logger.error("can not find monster cfgid =" + cfgid);
/* 184 */       return -1;
/*     */     }
/* 186 */     return cfg.categoryId;
/*     */   }
/*     */   
/*     */   int getMonsterModel(int cfgid)
/*     */   {
/* 191 */     SMonsterCfg cfg = SMonsterCfg.get(cfgid);
/* 192 */     if (cfg == null)
/*     */     {
/* 194 */       logger.error("can not find monster cfgid =" + cfgid);
/* 195 */       return -1;
/*     */     }
/* 197 */     return cfg.monsterModelId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isMonsterCfgExist(int cfgid)
/*     */   {
/* 209 */     return getMonsterCfg(cfgid) != null;
/*     */   }
/*     */   
/*     */   List<Monster> genMonster(int level, List<Integer> monsterCfgidList)
/*     */   {
/* 214 */     List<Monster> monsterList = new ArrayList();
/* 215 */     for (Integer cfgid : monsterCfgidList)
/*     */     {
/* 217 */       Monster monster = getInstance().getMonsterById(cfgid.intValue(), level);
/* 218 */       if (monster != null)
/*     */       {
/* 220 */         monsterList.add(monster);
/*     */       }
/*     */     }
/* 223 */     return monsterList;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\monster\main\MonsterManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */