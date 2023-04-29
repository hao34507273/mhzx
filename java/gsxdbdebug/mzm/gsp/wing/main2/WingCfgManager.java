/*     */ package mzm.gsp.wing.main2;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.property.confbean.SLevelToPropertyCfg;
/*     */ import mzm.gsp.property.confbean.SOwnLevelToPropertyCfg;
/*     */ import mzm.gsp.wing.confbean.STDyeLib;
/*     */ import mzm.gsp.wing.confbean.STRanProInfos;
/*     */ import mzm.gsp.wing.confbean.STRank2Levels;
/*     */ import mzm.gsp.wing.confbean.STWingPropertyLib;
/*     */ import mzm.gsp.wing.confbean.STWingSkillLib;
/*     */ import mzm.gsp.wing.confbean.SWingCfg;
/*     */ import mzm.gsp.wing.confbean.SWingInfoCfg;
/*     */ import mzm.gsp.wing.confbean.SWingProCfg;
/*     */ import mzm.gsp.wing.confbean.SWingRankCfg;
/*     */ import mzm.gsp.wing.confbean.WingCfgConsts;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Xdb;
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
/*     */ public class WingCfgManager
/*     */ {
/*     */   static final int TYPE_SKILL = 1;
/*     */   static final int TYPE_PRO = 2;
/*     */   static final int GET_SKILL_TYPE__NEW = 1;
/*     */   static final int GET_SKILL_TYPE__RESET = 2;
/*     */   
/*     */   static List<Integer> ranProIds(int proInfoId, Set<Integer> ownPros)
/*     */   {
/*  47 */     List<Integer> proIds = new ArrayList();
/*     */     
/*  49 */     if (proInfoId == 0)
/*     */     {
/*  51 */       if (GameServer.logger().isDebugEnabled())
/*     */       {
/*  53 */         GameServer.logger().debug(String.format("[wing]WingCfgManager.ranProIds@ no need ran!|proInfoId=%d", new Object[] { Integer.valueOf(proInfoId) }));
/*     */       }
/*  55 */       return proIds;
/*     */     }
/*     */     
/*  58 */     STWingPropertyLib sLib = STWingPropertyLib.get(proInfoId);
/*  59 */     if (sLib == null)
/*     */     {
/*  61 */       GameServer.logger().error(String.format("[wing]WingCfgManager.ranProIds@ proLib not exist!|proInfoId=%d", new Object[] { Integer.valueOf(proInfoId) }));
/*     */       
/*  63 */       return proIds;
/*     */     }
/*     */     
/*  66 */     for (STRanProInfos info : sLib.ranInfos)
/*     */     {
/*  68 */       if (!addRanId(proIds, ranOneId(ownPros, info.weightSum, new HashMap(info.ranProInfos))))
/*     */       {
/*  70 */         GameServer.logger().error(String.format("[wing]WingCfgManager.ranProIds@ add error!|proInfoId=%d|proIds=%s", new Object[] { Integer.valueOf(proInfoId), proIds.toString() }));
/*     */         
/*     */ 
/*  73 */         return new ArrayList();
/*     */       }
/*     */     }
/*  76 */     return proIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Integer, Integer> getProValues(List<Integer> ranProIds)
/*     */   {
/*  87 */     if ((ranProIds == null) || (ranProIds.size() == 0))
/*     */     {
/*  89 */       return new HashMap();
/*     */     }
/*  91 */     Map<Integer, Integer> proMap = new HashMap();
/*  92 */     for (Iterator i$ = ranProIds.iterator(); i$.hasNext();) { int proId = ((Integer)i$.next()).intValue();
/*     */       
/*  94 */       SWingProCfg cfg = SWingProCfg.get(proId);
/*  95 */       if (cfg == null)
/*     */       {
/*  97 */         GameServer.logger().error(String.format("[wing]WingCfgManager.getProValues@ SWingProCfg not exist!|proId=%d", new Object[] { Integer.valueOf(proId) }));
/*     */         
/*  99 */         return new HashMap();
/*     */       }
/* 101 */       if (proMap.containsKey(Integer.valueOf(cfg.proType)))
/*     */       {
/* 103 */         GameServer.logger().error(String.format("[wing]WingCfgManager.getProValues@ ran same pro!|ranProIds=%s|proType=%d", new Object[] { ranProIds.toString(), Integer.valueOf(cfg.proType) }));
/*     */         
/*     */ 
/* 106 */         return new HashMap();
/*     */       }
/* 108 */       proMap.put(Integer.valueOf(cfg.proType), Integer.valueOf(cfg.proValue));
/*     */     }
/* 110 */     return proMap;
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
/*     */   static RanResult ranSkills(int skillInfoId, Set<Integer> ownSkills, int type)
/*     */   {
/* 124 */     RanResult res = new RanResult();
/*     */     
/* 126 */     if (skillInfoId == 0)
/*     */     {
/* 128 */       if (GameServer.logger().isDebugEnabled())
/*     */       {
/* 130 */         GameServer.logger().debug(String.format("[wing]WingCfgManager.ranSkills@ no need ran!|skillInfoId=%d", new Object[] { Integer.valueOf(skillInfoId) }));
/*     */       }
/*     */       
/* 133 */       res.setRes(RanRes.NO_RAN_LIB);
/* 134 */       return res;
/*     */     }
/*     */     
/* 137 */     STWingSkillLib sLib = STWingSkillLib.get(skillInfoId);
/* 138 */     if (sLib == null)
/*     */     {
/* 140 */       GameServer.logger().error(String.format("[wing]WingCfgManager.ranSkills@ skillLib not exist!|skillInfoId=%d", new Object[] { Integer.valueOf(skillInfoId) }));
/*     */       
/* 142 */       res.setRes(RanRes.OTHER);
/* 143 */       return res;
/*     */     }
/*     */     
/* 146 */     int oneId = ranOneId(ownSkills, sLib.weightSum, new HashMap(sLib.skillInfos));
/* 147 */     if (oneId == -1)
/*     */     {
/* 149 */       res.setRes(RanRes.NOMORE_TO_RAN);
/* 150 */       return res;
/*     */     }
/*     */     
/* 153 */     res.setSuc(true);
/* 154 */     res.addSkillId(oneId);
/* 155 */     return res;
/*     */   }
/*     */   
/*     */   static enum RanRes
/*     */   {
/* 160 */     NOMORE_TO_RAN,  NO_RAN_LIB,  OTHER;
/*     */     
/*     */     private RanRes() {}
/*     */   }
/*     */   
/*     */   static class RanResult {
/*     */     private boolean suc;
/*     */     private List<Integer> ranSkills;
/*     */     private WingCfgManager.RanRes res;
/*     */     
/*     */     public RanResult() {
/* 171 */       this.suc = false;
/* 172 */       this.ranSkills = new ArrayList();
/*     */     }
/*     */     
/*     */     List<Integer> getRanSkills()
/*     */     {
/* 177 */       return new ArrayList(this.ranSkills);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     void addSkillId(int skillId)
/*     */     {
/* 187 */       if (this.ranSkills.contains(Integer.valueOf(skillId)))
/*     */       {
/* 189 */         return;
/*     */       }
/* 191 */       this.ranSkills.add(Integer.valueOf(skillId));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public boolean isSuc()
/*     */     {
/* 201 */       return this.suc;
/*     */     }
/*     */     
/*     */     public void setSuc(boolean suc)
/*     */     {
/* 206 */       this.suc = suc;
/*     */     }
/*     */     
/*     */     public WingCfgManager.RanRes getRes()
/*     */     {
/* 211 */       return this.res;
/*     */     }
/*     */     
/*     */     public void setRes(WingCfgManager.RanRes res)
/*     */     {
/* 216 */       this.res = res;
/*     */     }
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
/*     */   static boolean addRanId(List<Integer> alRanIds, int ranId)
/*     */   {
/* 231 */     if (ranId <= 0)
/*     */     {
/* 233 */       GameServer.logger().error(String.format("[wing]WingCfgManager.addRanId@ ranId is illegal!|ranId=%d|alRanIds=%s", new Object[] { Integer.valueOf(ranId), alRanIds.toString() }));
/*     */       
/*     */ 
/* 236 */       return false;
/*     */     }
/* 238 */     if (alRanIds.contains(Integer.valueOf(ranId)))
/*     */     {
/* 240 */       GameServer.logger().error(String.format("[wing]WingCfgManager.addRanId@ ranId is same!|ranId=%d|alRanIds=%s", new Object[] { Integer.valueOf(ranId), alRanIds.toString() }));
/*     */       
/*     */ 
/* 243 */       return false;
/*     */     }
/* 245 */     alRanIds.add(Integer.valueOf(ranId));
/* 246 */     return true;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   static int initRanLib(Set<Integer> ownIds, Map<Integer, Integer> libIds, int weightSum)
/*     */   {
/* 264 */     for (Iterator i$ = ownIds.iterator(); i$.hasNext();) { int ownId = ((Integer)i$.next()).intValue();
/*     */       
/* 266 */       if (libIds.containsKey(Integer.valueOf(ownId)))
/*     */       {
/* 268 */         int rmWeight = ((Integer)libIds.remove(Integer.valueOf(ownId))).intValue();
/* 269 */         weightSum -= rmWeight;
/*     */       }
/*     */     }
/* 272 */     return weightSum;
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
/*     */   static int ranOneId(Set<Integer> ownIds, int weightSum, Map<Integer, Integer> libIds)
/*     */   {
/* 285 */     weightSum = initRanLib(ownIds, libIds, weightSum);
/* 286 */     if (libIds.size() == 0)
/*     */     {
/* 288 */       GameServer.logger().error(String.format("[wing]WingCfgManager.ranOneProId@ no more Id to ran!|ownIds=%s", new Object[] { ownIds.toString() }));
/*     */       
/* 290 */       return -1;
/*     */     }
/*     */     
/* 293 */     int ranProId = ranOneId(weightSum, libIds);
/* 294 */     if (ranProId <= 0)
/*     */     {
/* 296 */       GameServer.logger().error(String.format("[wing]WingCfgManager.ranOneProId@ ran one error!|weightSum=%d|libSkills=%s", new Object[] { Integer.valueOf(weightSum), libIds.toString() }));
/*     */     }
/*     */     
/*     */ 
/* 300 */     return ranProId;
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
/*     */   static int ranOneId(int weightSum, Map<Integer, Integer> libIds)
/*     */   {
/* 314 */     int one = -1;
/* 315 */     Random random = Xdb.random();
/* 316 */     int ran = random.nextInt(weightSum);
/* 317 */     int addWeight = 0;
/*     */     
/* 319 */     Iterator<Map.Entry<Integer, Integer>> it = libIds.entrySet().iterator();
/* 320 */     while (it.hasNext())
/*     */     {
/* 322 */       Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/* 323 */       int eachId = ((Integer)entry.getKey()).intValue();
/* 324 */       int weight = ((Integer)entry.getValue()).intValue();
/*     */       
/* 326 */       addWeight += weight;
/* 327 */       if (addWeight > ran)
/*     */       {
/* 329 */         one = eachId;
/* 330 */         break;
/*     */       }
/*     */     }
/* 333 */     return one;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Integer> getRank2Lvs(int rank)
/*     */   {
/* 344 */     STRank2Levels cfg = STRank2Levels.get(rank);
/* 345 */     if (cfg == null)
/*     */     {
/* 347 */       GameServer.logger().error(String.format("[wing]WingCfgManager.getRank2Lvs@ no rank 2 lvs!|rank=%d", new Object[] { Integer.valueOf(rank) }));
/* 348 */       return new HashSet();
/*     */     }
/*     */     
/* 351 */     return new HashSet(cfg.levels);
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
/*     */   static WingItemInfo getResetInfo(int wingId, int type)
/*     */   {
/* 364 */     SWingInfoCfg cfg = SWingInfoCfg.get(wingId);
/* 365 */     if (cfg == null)
/*     */     {
/* 367 */       GameServer.logger().error(String.format("[wing]WingCfgManager.getResetInfo@ no wing data!|wingId=%d", new Object[] { Integer.valueOf(wingId) }));
/* 368 */       return null;
/*     */     }
/* 370 */     switch (type)
/*     */     {
/*     */     case 2: 
/* 373 */       return new WingItemInfo(cfg.resetProItemId, cfg.resetProItemNum);
/*     */     
/*     */     case 1: 
/* 376 */       return new WingItemInfo(cfg.resetSkillItemId, cfg.resetSkillItemNum);
/*     */     }
/*     */     
/* 379 */     GameServer.logger().error(String.format("[wing]WingCfgManager.getResetInfo@ illegal type!|wingId=%d|type=%d", new Object[] { Integer.valueOf(wingId), Integer.valueOf(type) }));
/*     */     
/* 381 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static WingItemInfo getRankUpInfo(int rank)
/*     */   {
/* 393 */     SWingRankCfg cfg = SWingRankCfg.get(rank);
/* 394 */     if (cfg == null)
/*     */     {
/* 396 */       GameServer.logger().error(String.format("[wing]WingCfgManager.getResetInfo@ no rank data!|rank=%d", new Object[] { Integer.valueOf(rank) }));
/* 397 */       return null;
/*     */     }
/* 399 */     return new WingItemInfo(cfg.needItemId, cfg.itemNum);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Integer, Integer> getProMapBy(int level)
/*     */   {
/* 410 */     SLevelToPropertyCfg cfg = getLvProCfg(level);
/* 411 */     if (cfg == null)
/*     */     {
/* 413 */       GameServer.logger().error(String.format("[wing]WingCfgManager.getProMapBy@ no level data!|level=%d", new Object[] { Integer.valueOf(level) }));
/* 414 */       return new HashMap();
/*     */     }
/* 416 */     Map<Integer, Integer> proMap = new HashMap();
/* 417 */     fillProMap(cfg, proMap);
/* 418 */     return proMap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void fillProMap(SLevelToPropertyCfg cfg, Map<Integer, Integer> proMap)
/*     */   {
/* 429 */     proMap.put(Integer.valueOf(1), Integer.valueOf((int)cfg.addMaxHpPerLevel));
/* 430 */     proMap.put(Integer.valueOf(3), Integer.valueOf((int)cfg.addMaxMpPerLevel));
/* 431 */     proMap.put(Integer.valueOf(7), Integer.valueOf((int)cfg.addPhyAtkPerLevel));
/* 432 */     proMap.put(Integer.valueOf(8), Integer.valueOf((int)cfg.addPhyDefPerLevel));
/* 433 */     proMap.put(Integer.valueOf(9), Integer.valueOf((int)cfg.addMagAtkPerLevel));
/* 434 */     proMap.put(Integer.valueOf(10), Integer.valueOf((int)cfg.addMagDefPerLevel));
/* 435 */     proMap.put(Integer.valueOf(11), Integer.valueOf((int)cfg.addPhyCrtRatePerLevel));
/* 436 */     proMap.put(Integer.valueOf(12), Integer.valueOf((int)cfg.addMagCrtRatePerLevel));
/* 437 */     proMap.put(Integer.valueOf(14), Integer.valueOf((int)cfg.addPhyCrtValuePerLevel));
/* 438 */     proMap.put(Integer.valueOf(15), Integer.valueOf((int)cfg.addMagCrtValuePerLevel));
/* 439 */     proMap.put(Integer.valueOf(16), Integer.valueOf((int)cfg.addSealHitLevelPerLevel));
/* 440 */     proMap.put(Integer.valueOf(17), Integer.valueOf((int)cfg.addSealResLevelPerLevel));
/* 441 */     proMap.put(Integer.valueOf(18), Integer.valueOf((int)cfg.addPhyHitLevelPerLevel));
/* 442 */     proMap.put(Integer.valueOf(19), Integer.valueOf((int)cfg.addPhyDodgeLevelPerLevel));
/* 443 */     proMap.put(Integer.valueOf(20), Integer.valueOf((int)cfg.addMagHitLevelPerLevel));
/* 444 */     proMap.put(Integer.valueOf(21), Integer.valueOf((int)cfg.addMagDodgeLevelPerLevel));
/* 445 */     proMap.put(Integer.valueOf(24), Integer.valueOf((int)cfg.addSpeedPerLevelPerLevel));
/*     */     
/* 447 */     proMap.put(Integer.valueOf(85), Integer.valueOf((int)cfg.addPhyCrtLevelPerLevel));
/* 448 */     proMap.put(Integer.valueOf(87), Integer.valueOf((int)cfg.addPhyCrtLevelDefPerLevel));
/* 449 */     proMap.put(Integer.valueOf(86), Integer.valueOf((int)cfg.addMagCrtLevelPerLevel));
/* 450 */     proMap.put(Integer.valueOf(88), Integer.valueOf((int)cfg.addMagCrtLevelDefPerLevel));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getLvProId()
/*     */   {
/* 460 */     return WingCfgConsts.getInstance().LEVEL_PRO_ID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static SLevelToPropertyCfg getLvProCfg(int level)
/*     */   {
/* 471 */     int lvProId = getLvProId();
/* 472 */     int levelKey = lvProId * 1000 + level;
/* 473 */     SOwnLevelToPropertyCfg cfg = SOwnLevelToPropertyCfg.get(levelKey);
/* 474 */     if (cfg == null)
/*     */     {
/* 476 */       GameServer.logger().error(String.format("[wing]WingCfgManager.getLvProCfg@ no levelKey data!|levelKey=%d", new Object[] { Integer.valueOf(levelKey) }));
/*     */       
/* 478 */       return null;
/*     */     }
/* 480 */     return SLevelToPropertyCfg.get(cfg.SLevelToPropertyCfgId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int ranNewColor(int colorLibId, int ownId)
/*     */   {
/* 492 */     STDyeLib lib = STDyeLib.get(colorLibId);
/* 493 */     if (lib == null)
/*     */     {
/* 495 */       GameServer.logger().error(String.format("[wing]WingCfgManager.ranNewColor@ no STDyeLib data!|colorLibId=%d", new Object[] { Integer.valueOf(colorLibId) }));
/*     */       
/* 497 */       return -1;
/*     */     }
/* 499 */     int weightSum = lib.weightSum;
/* 500 */     Map<Integer, Integer> colorId2weight = new HashMap(lib.colors);
/* 501 */     int rmWeight = ((Integer)colorId2weight.remove(Integer.valueOf(ownId))).intValue();
/* 502 */     weightSum -= rmWeight;
/*     */     
/* 504 */     Random random = Xdb.random();
/* 505 */     int ran = random.nextInt(weightSum);
/*     */     
/* 507 */     int sum = 0;
/* 508 */     Iterator<Map.Entry<Integer, Integer>> it = colorId2weight.entrySet().iterator();
/* 509 */     while (it.hasNext())
/*     */     {
/* 511 */       Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/* 512 */       sum += ((Integer)entry.getValue()).intValue();
/* 513 */       if (sum > ran)
/*     */       {
/* 515 */         return ((Integer)entry.getKey()).intValue();
/*     */       }
/*     */     }
/*     */     
/* 519 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getWingRanColorId(int wingId)
/*     */   {
/* 530 */     SWingInfoCfg cfg = SWingInfoCfg.get(wingId);
/* 531 */     if (cfg == null)
/*     */     {
/* 533 */       GameServer.logger().error(String.format("[wing]WingCfgManager.getWingRanColorId@ no SWingInfoCfg data!|wingId=%d", new Object[] { Integer.valueOf(wingId) }));
/*     */       
/* 535 */       return -1;
/*     */     }
/* 537 */     int outLookId = cfg.outlook;
/*     */     
/* 539 */     SWingCfg sWingCfg = SWingCfg.get(outLookId);
/* 540 */     if (sWingCfg == null)
/*     */     {
/* 542 */       GameServer.logger().error(String.format("[wing]WingCfgManager.getWingRanColorId@ no SWingCfg data!|wingId=%d|outLookId=%d", new Object[] { Integer.valueOf(wingId), Integer.valueOf(outLookId) }));
/*     */       
/*     */ 
/* 545 */       return -1;
/*     */     }
/* 547 */     return sWingCfg.dyeLibId;
/*     */   }
/*     */   
/*     */   static int getOutLookType(int wingId)
/*     */   {
/* 552 */     SWingInfoCfg cfg = SWingInfoCfg.get(wingId);
/* 553 */     if (cfg == null)
/*     */     {
/* 555 */       GameServer.logger().error(String.format("[wing]WingCfgManager.getWingGainType@ no SWingInfoCfg data!|wingId=%d", new Object[] { Integer.valueOf(wingId) }));
/*     */       
/* 557 */       return -1;
/*     */     }
/* 559 */     return cfg.outlookType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean canActiveGain(int wingId)
/*     */   {
/* 570 */     return getOutLookType(wingId) == 2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getExteriorId(int wingId)
/*     */   {
/* 581 */     SWingInfoCfg cfg = SWingInfoCfg.get(wingId);
/* 582 */     if (cfg == null)
/*     */     {
/* 584 */       GameServer.logger().error(String.format("[wing]WingCfgManager.getExteriorId@ no wing cfg data!|wingInfoId=%d", new Object[] { Integer.valueOf(wingId) }));
/*     */       
/* 586 */       return -1;
/*     */     }
/* 588 */     return cfg.outlook;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static RanResult ranTargetSkills(int skillInfoId, Collection<Integer> targetSkills)
/*     */   {
/* 600 */     RanResult res = new RanResult();
/*     */     
/* 602 */     if (skillInfoId <= 0)
/*     */     {
/* 604 */       if (GameServer.logger().isDebugEnabled())
/*     */       {
/* 606 */         GameServer.logger().debug(String.format("[wing]WingCfgManager.ranTargetSkills@ no need ran!|skillInfoId=%d", new Object[] { Integer.valueOf(skillInfoId) }));
/*     */       }
/*     */       
/* 609 */       res.setRes(RanRes.NO_RAN_LIB);
/* 610 */       return res;
/*     */     }
/*     */     
/* 613 */     STWingSkillLib sLib = STWingSkillLib.get(skillInfoId);
/* 614 */     if (sLib == null)
/*     */     {
/* 616 */       GameServer.logger().error(String.format("[wing]WingCfgManager.ranTargetSkills@ skillLib not exist!|skillInfoId=%d", new Object[] { Integer.valueOf(skillInfoId) }));
/*     */       
/* 618 */       res.setRes(RanRes.OTHER);
/* 619 */       return res;
/*     */     }
/* 621 */     Map<Integer, Integer> libIds = new HashMap();
/* 622 */     int weightSum = 0;
/*     */     
/* 624 */     for (Integer skillId : targetSkills)
/*     */     {
/* 626 */       Integer weight = (Integer)sLib.skillInfos.get(skillId);
/* 627 */       if (weight != null)
/*     */       {
/* 629 */         libIds.put(skillId, weight);
/* 630 */         weightSum += weight.intValue();
/*     */       }
/*     */     }
/* 633 */     int oneId = ranOneId(weightSum, libIds);
/* 634 */     if (oneId <= 0)
/*     */     {
/* 636 */       res.setRes(RanRes.NOMORE_TO_RAN);
/* 637 */       return res;
/*     */     }
/*     */     
/* 640 */     res.setSuc(true);
/* 641 */     res.addSkillId(oneId);
/* 642 */     return res;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static class WingItemInfo
/*     */   {
/*     */     private final int itemId;
/*     */     
/*     */ 
/*     */     private final int itemNum;
/*     */     
/*     */ 
/*     */ 
/*     */     public WingItemInfo(int itemId, int itemNum)
/*     */     {
/* 659 */       this.itemId = itemId;
/* 660 */       this.itemNum = itemNum;
/*     */     }
/*     */     
/*     */     int getItemId()
/*     */     {
/* 665 */       return this.itemId;
/*     */     }
/*     */     
/*     */     int getItemNum()
/*     */     {
/* 670 */       return this.itemNum;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\main2\WingCfgManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */