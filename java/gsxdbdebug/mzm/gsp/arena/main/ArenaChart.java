/*    */ package mzm.gsp.arena.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.chart.main.RoleKeyRankManagerNew;
/*    */ import xbean.ArenaScore;
/*    */ import xtable.Arenascore;
/*    */ 
/*    */ 
/*    */ class ArenaChart
/*    */   extends RoleKeyRankManagerNew<ArenaChartObj>
/*    */ {
/*    */   ArenaChart()
/*    */   {
/* 15 */     super(7);
/*    */   }
/*    */   
/*    */   public void saveToDB()
/*    */   {
/* 20 */     List<ArenaChartObj> rankList = getAllChartObjs();
/* 21 */     xbean.ArenaChart xArenaChart = ArenaManager.getAndCreateXArenaChart();
/*    */     
/* 23 */     xArenaChart.getRanklist().clear();
/* 24 */     for (ArenaChartObj obj : rankList) {
/* 25 */       xArenaChart.getRanklist().add(Long.valueOf(obj.getRoleid()));
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public void rankDataFromDB()
/*    */   {
/* 32 */     xbean.ArenaChart xArenaChart = ArenaManager.getAndCreateXArenaChart();
/* 33 */     for (Iterator i$ = xArenaChart.getRanklist().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 34 */       ArenaScore xScore = Arenascore.select(Long.valueOf(roleid));
/* 35 */       if (xScore != null)
/*    */       {
/*    */ 
/* 38 */         ArenaChartObj obj = new ArenaChartObj(roleid, xScore.getScore(), xScore.getWin_times());
/*    */         
/* 40 */         rank(obj);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public void addRankRoleForIDIP(long roleid) {
/* 46 */     ArenaScore xScore = Arenascore.select(Long.valueOf(roleid));
/* 47 */     if (xScore == null) {
/* 48 */       return;
/*    */     }
/* 50 */     ArenaChartObj obj = new ArenaChartObj(roleid, xScore.getScore(), xScore.getWin_times());
/*    */     
/* 52 */     rank(obj);
/*    */   }
/*    */   
/*    */   public void clearRoleRankData(long roleid)
/*    */   {
/* 57 */     ArenaScore xScore = Arenascore.get(Long.valueOf(roleid));
/* 58 */     if (xScore != null) {
/* 59 */       xScore.setScore(0);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\ArenaChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */