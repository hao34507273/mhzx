/*    */ package mzm.gsp.factionpve.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.factionpve.confbean.SFactionPVEConsts;
/*    */ import mzm.gsp.factionpve.confbean.SFactionPVEMonsterGoalCfg;
/*    */ import mzm.gsp.factionpve.confbean.SKillBossAwardCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class FactionPVEConfigManager
/*    */ {
/*    */   static boolean isActivityMap(int mapid)
/*    */   {
/* 21 */     return (mapid == SFactionPVEConsts.getInstance().PrepareMap) || (mapid == SFactionPVEConsts.getInstance().FightMap);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isGoalMonster(int monsterid)
/*    */   {
/* 31 */     return SFactionPVEMonsterGoalCfg.getAll().containsKey(Integer.valueOf(monsterid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isBoss(int mapMonsterid)
/*    */   {
/* 40 */     return SKillBossAwardCfg.getAll().containsKey(Integer.valueOf(mapMonsterid));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\FactionPVEConfigManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */