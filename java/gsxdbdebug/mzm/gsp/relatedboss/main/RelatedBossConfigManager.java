/*    */ package mzm.gsp.relatedboss.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.relatedboss.confbean.SMapMonsterRelatedCfg;
/*    */ import mzm.gsp.relatedboss.confbean.SRelatedBossCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class RelatedBossConfigManager
/*    */ {
/*    */   static boolean isRelatedMapMonster(int mapMonsterid)
/*    */   {
/* 17 */     return SMapMonsterRelatedCfg.getAll().containsKey(Integer.valueOf(mapMonsterid));
/*    */   }
/*    */   
/*    */   static boolean isBoss(int mapMonsterid) {
/* 21 */     return SRelatedBossCfg.getAll().containsKey(Integer.valueOf(mapMonsterid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static List<Integer> getBossList(int relatedMapMonster)
/*    */   {
/* 30 */     List<Integer> bossList = new ArrayList();
/* 31 */     SMapMonsterRelatedCfg monsterCfg = SMapMonsterRelatedCfg.get(relatedMapMonster);
/* 32 */     if (monsterCfg != null) {
/* 33 */       bossList.addAll(monsterCfg.bossList);
/*    */     }
/* 35 */     return bossList;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\relatedboss\main\RelatedBossConfigManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */