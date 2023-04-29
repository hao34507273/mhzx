/*    */ package mzm.gsp.relatedboss.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.relatedboss.confbean.SMapMonsterRelatedCfg;
/*    */ import mzm.gsp.relatedboss.confbean.SRelatedBossCfg;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.BossFights;
/*    */ import xbean.RelatedBoss;
/*    */ import xtable.Relatedboss;
/*    */ 
/*    */ class RelatedBossManager
/*    */ {
/*    */   static Logger logger;
/*    */   
/*    */   static void init()
/*    */   {
/* 20 */     logger = Logger.getLogger("relatedboss");
/*    */   }
/*    */   
/*    */   static RelatedBoss getXRelatedBossIfNotExist(long world)
/*    */   {
/* 25 */     RelatedBoss xBoss = Relatedboss.get(Long.valueOf(world));
/* 26 */     if (xBoss == null) {
/* 27 */       xBoss = xbean.Pod.newRelatedBoss();
/* 28 */       Relatedboss.insert(Long.valueOf(world), xBoss);
/*    */     }
/* 30 */     return xBoss;
/*    */   }
/*    */   
/*    */   static RelatedBoss getXRelatedBoss(long world, boolean remainLock) {
/* 34 */     RelatedBoss xBoss = null;
/* 35 */     if (remainLock) {
/* 36 */       xBoss = Relatedboss.get(Long.valueOf(world));
/*    */     }
/*    */     else {
/* 39 */       xBoss = Relatedboss.select(Long.valueOf(world));
/*    */     }
/* 41 */     return xBoss;
/*    */   }
/*    */   
/*    */   static boolean addBossFight(RelatedBoss xBoss, int mapBossid, long fightid) {
/* 45 */     BossFights xFights = (BossFights)xBoss.getBoss_fights().get(Integer.valueOf(mapBossid));
/* 46 */     if (xFights == null) {
/* 47 */       xFights = xbean.Pod.newBossFights();
/* 48 */       xBoss.getBoss_fights().put(Integer.valueOf(mapBossid), xFights);
/*    */     }
/* 50 */     return xFights.getFights().add(Long.valueOf(fightid));
/*    */   }
/*    */   
/*    */   static boolean removeBossFight(RelatedBoss xBoss, int mapBossid, long fightid)
/*    */   {
/* 55 */     BossFights xFights = (BossFights)xBoss.getBoss_fights().get(Integer.valueOf(mapBossid));
/* 56 */     if (xFights == null) {
/* 57 */       return false;
/*    */     }
/* 59 */     return xFights.getFights().remove(Long.valueOf(fightid));
/*    */   }
/*    */   
/*    */   static boolean addRelatedMapMonster(RelatedBoss xBoss, int mapMonster)
/*    */   {
/* 64 */     return xBoss.getRelated_monsters().add(Integer.valueOf(mapMonster));
/*    */   }
/*    */   
/*    */   static Map<Integer, List<Integer>> getMonsterBuffs(RelatedBoss xBoss, int mapBossid)
/*    */   {
/* 69 */     Map<Integer, List<Integer>> monsterBuffs = new java.util.HashMap();
/*    */     
/* 71 */     SRelatedBossCfg bossCfg = SRelatedBossCfg.get(mapBossid);
/* 72 */     Iterator i$; if (bossCfg != null) {
/* 73 */       for (i$ = bossCfg.relatedMapMonsters.iterator(); i$.hasNext();) { int mapMonster = ((Integer)i$.next()).intValue();
/* 74 */         if (xBoss.getRelated_monsters().contains(Integer.valueOf(mapMonster))) {
/* 75 */           SMapMonsterRelatedCfg monsterCfg = SMapMonsterRelatedCfg.get(mapMonster);
/* 76 */           if (monsterCfg != null) {
/* 77 */             addMonsterBuff(monsterBuffs, monsterCfg.dstMonsterid, monsterCfg.fightBuffid);
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 83 */     return monsterBuffs;
/*    */   }
/*    */   
/*    */   static void addMonsterBuff(Map<Integer, List<Integer>> monsterBuffs, int monsterid, int buffid)
/*    */   {
/* 88 */     List<Integer> buffs = (List)monsterBuffs.get(Integer.valueOf(monsterid));
/* 89 */     if (buffs == null) {
/* 90 */       buffs = new java.util.ArrayList();
/* 91 */       monsterBuffs.put(Integer.valueOf(monsterid), buffs);
/*    */     }
/* 93 */     buffs.add(Integer.valueOf(buffid));
/*    */   }
/*    */   
/*    */   static void logError(String formatStr, Object... args)
/*    */   {
/* 98 */     logger.error(String.format(formatStr, args));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\relatedboss\main\RelatedBossManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */