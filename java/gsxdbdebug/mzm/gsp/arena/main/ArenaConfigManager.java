/*    */ package mzm.gsp.arena.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.arena.confbean.SArenaCampCfg;
/*    */ import mzm.gsp.arena.confbean.SArenaConsts;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ 
/*    */ class ArenaConfigManager
/*    */ {
/* 11 */   static ArenaConfigManager instance = new ArenaConfigManager();
/*    */   
/*    */   static ArenaConfigManager getInstance() {
/* 14 */     return instance;
/*    */   }
/*    */   
/*    */   void postInit() {
/* 18 */     checkMap();
/*    */   }
/*    */   
/*    */   void checkMap() {
/* 22 */     if (!MapInterface.isFuBenMap(SArenaConsts.getInstance().ActivityMap)) {
/* 23 */       throw new RuntimeException("天下会武活动地图配置错误，不是副本地图！！！mapid=" + SArenaConsts.getInstance().ActivityMap);
/*    */     }
/* 25 */     if (MapInterface.isFuBenMap(SArenaConsts.getInstance().LeaveMap)) {
/* 26 */       throw new RuntimeException("天下会武离开地图配置错误，不是世界地图！！！mapid=" + SArenaConsts.getInstance().LeaveMap);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   int getCampSize()
/*    */   {
/* 33 */     return SArenaCampCfg.getAll().size();
/*    */   }
/*    */   
/*    */   Set<Integer> getCampSet() {
/* 37 */     return SArenaCampCfg.getAll().keySet();
/*    */   }
/*    */   
/*    */   String getCampName(int camp) {
/* 41 */     SArenaCampCfg campCfg = SArenaCampCfg.get(camp);
/* 42 */     if (campCfg == null) {
/* 43 */       return null;
/*    */     }
/* 45 */     return campCfg.name;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\ArenaConfigManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */