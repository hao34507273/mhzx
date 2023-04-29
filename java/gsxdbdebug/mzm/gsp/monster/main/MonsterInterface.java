/*     */ package mzm.gsp.monster.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import mzm.gsp.monster.confbean.SActiveBrightMonster;
/*     */ import mzm.gsp.monster.confbean.SBrightMonster;
/*     */ import mzm.gsp.monster.confbean.SInstanceMonster;
/*     */ import mzm.gsp.monster.confbean.SMonsterCfg;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.pubdata.ModelInfo;
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
/*     */ public class MonsterInterface
/*     */ {
/*     */   public static Monster getMonster(int cfgid, int level)
/*     */   {
/*  30 */     return MonsterManager.getInstance().getMonsterById(cfgid, level);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getMonsterClassType(int cfgId)
/*     */   {
/*  42 */     SMonsterCfg cfg = getMonsterCfg(cfgId);
/*  43 */     return cfg == null ? -1 : cfg.classType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getMonsterClassLevel(int cfgId)
/*     */   {
/*  55 */     SMonsterCfg cfg = getMonsterCfg(cfgId);
/*  56 */     return cfg == null ? -1 : cfg.classLevel;
/*     */   }
/*     */   
/*     */   private static SMonsterCfg getMonsterCfg(int cfgId)
/*     */   {
/*  61 */     return SMonsterCfg.get(cfgId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getMonsterCategoryId(int cfgid)
/*     */   {
/*  72 */     return MonsterManager.getInstance().getMonsterCategoryId(cfgid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isMonsterCfgExist(int cfgid)
/*     */   {
/*  83 */     return MonsterManager.getInstance().isMonsterCfgExist(cfgid);
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
/*     */   public static List<Monster> genMonster(int level, List<Integer> monsterCfgidList)
/*     */   {
/*  96 */     return MonsterManager.getInstance().genMonster(level, monsterCfgidList);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getMonsterName(int monsterCfgid)
/*     */   {
/* 108 */     return MonsterManager.getInstance().getMonsterName(monsterCfgid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getMonsterModelId(int monsterCfgid)
/*     */   {
/* 120 */     return MonsterManager.getInstance().getMonsterModel(monsterCfgid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void fillModelInfo(int monsterCfgid, ModelInfo modelInfo)
/*     */   {
/* 131 */     SMonsterCfg cfg = MonsterManager.getInstance().getMonsterCfg(monsterCfgid);
/* 132 */     if (cfg == null)
/*     */     {
/* 134 */       return;
/*     */     }
/*     */     
/* 137 */     modelInfo.modelid = cfg.monsterModelId;
/*     */     
/* 139 */     int outLookId = cfg.modelFigureId;
/* 140 */     if (outLookId > 0)
/*     */     {
/* 142 */       modelInfo.extramap.put(Integer.valueOf(11), Integer.valueOf(outLookId));
/*     */     }
/*     */     
/* 145 */     int colorId = cfg.modelColorId;
/* 146 */     if (colorId > 0)
/*     */     {
/* 148 */       modelInfo.extramap.put(Integer.valueOf(12), Integer.valueOf(colorId));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getRewardId(int monsterCfgid)
/*     */   {
/* 160 */     return MonsterManager.getInstance().getMonsterReward(monsterCfgid);
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
/*     */   public static boolean isMonsterCanCatch(int monsterCfgid, int level)
/*     */   {
/* 173 */     return MonsterManager.getInstance().isMonsterCanCatch(monsterCfgid, level);
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
/*     */   public static boolean isMonsterCanAutoCatch(int monsterCfgid, int level)
/*     */   {
/* 186 */     SMonsterCfg cfg = MonsterManager.getInstance().getMonsterCfg(monsterCfgid);
/* 187 */     if (cfg == null)
/*     */     {
/* 189 */       return false;
/*     */     }
/*     */     
/* 192 */     int petCfgId = cfg.catchedMonsterId;
/* 193 */     if (petCfgId <= 0)
/*     */     {
/* 195 */       return false;
/*     */     }
/*     */     
/* 198 */     if (!PetInterface.isCanCarray(petCfgId, level))
/*     */     {
/* 200 */       return false;
/*     */     }
/* 202 */     return PetInterface.isPetTypeBaoBaoOrBianYi(petCfgId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getMonsterTypeId(int monsterCfgid)
/*     */   {
/* 213 */     SMonsterCfg cfg = MonsterManager.getInstance().getMonsterCfg(monsterCfgid);
/* 214 */     if (cfg == null)
/*     */     {
/* 216 */       return -1;
/*     */     }
/*     */     
/* 219 */     return cfg.typeId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Integer getMonsterFightCfgId(int monsterCfgid)
/*     */   {
/* 230 */     SActiveBrightMonster activeBrightMonster = SActiveBrightMonster.get(monsterCfgid);
/* 231 */     if (activeBrightMonster != null)
/*     */     {
/* 233 */       return Integer.valueOf(activeBrightMonster.monsterFightTableId);
/*     */     }
/*     */     
/*     */ 
/* 237 */     SBrightMonster brightMonster = SBrightMonster.get(monsterCfgid);
/* 238 */     if (brightMonster != null)
/*     */     {
/* 240 */       return Integer.valueOf(brightMonster.monsterFightTableId);
/*     */     }
/*     */     
/*     */ 
/* 244 */     SInstanceMonster instanceMonster = SInstanceMonster.get(monsterCfgid);
/* 245 */     if (instanceMonster != null)
/*     */     {
/* 247 */       return Integer.valueOf(instanceMonster.monsterFightTableId);
/*     */     }
/*     */     
/*     */ 
/* 251 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\monster\main\MonsterInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */