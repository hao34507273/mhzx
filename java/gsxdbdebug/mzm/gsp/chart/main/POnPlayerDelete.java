/*   */ package mzm.gsp.chart.main;
/*   */ 
/*   */ import mzm.gsp.online.event.PlayerRealDeleteProcedure;
/*   */ 
/*   */ public class POnPlayerDelete extends PlayerRealDeleteProcedure {
/*   */   protected boolean processImp() throws Exception {
/* 7 */     RankCacheManager.removeRoleidInAllRank(((Long)this.arg).longValue(), true);
/* 8 */     return true;
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\main\POnPlayerDelete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */