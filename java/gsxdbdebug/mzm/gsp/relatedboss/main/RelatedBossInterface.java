/*    */ package mzm.gsp.relatedboss.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.fight.main.FightParam;
/*    */ import mzm.gsp.map.main.MapVisibleMonsterFightContext;
/*    */ import xbean.RelatedBoss;
/*    */ import xtable.Relatedboss;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RelatedBossInterface
/*    */ {
/*    */   public static boolean isBoss(int mapMonsterid)
/*    */   {
/* 22 */     return RelatedBossConfigManager.isBoss(mapMonsterid);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean isRelatedMapMonster(int mapMonsterid)
/*    */   {
/* 32 */     return RelatedBossConfigManager.isRelatedMapMonster(mapMonsterid);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void fillFightParam(FightParam param, MapVisibleMonsterFightContext context)
/*    */   {
/* 44 */     if (RelatedBossConfigManager.isBoss(context.monsterCfgId)) {
/* 45 */       long world = context.worldId;
/*    */       
/* 47 */       RelatedBoss xBoss = Relatedboss.select(Long.valueOf(world));
/* 48 */       Map<Integer, List<Integer>> monsterBuffs = null;
/* 49 */       if (xBoss != null) {
/* 50 */         monsterBuffs = RelatedBossManager.getMonsterBuffs(xBoss, context.monsterCfgId);
/* 51 */         for (Map.Entry<Integer, List<Integer>> entry : monsterBuffs.entrySet()) {
/* 52 */           int monsterid = ((Integer)entry.getKey()).intValue();
/* 53 */           List<Integer> buffs = (List)entry.getValue();
/* 54 */           param.addMonsterBuff(monsterid, buffs);
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static List<Integer> getBossList(int relatedMapMonster)
/*    */   {
/* 67 */     return RelatedBossConfigManager.getBossList(relatedMapMonster);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\relatedboss\main\RelatedBossInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */