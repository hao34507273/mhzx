/*    */ package mzm.gsp.jingji.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.util.Pair;
/*    */ import xbean.JingjiPvp;
/*    */ import xtable.Role2jingjipvp;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLoginSeasonInit
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     new POnRoleLoginFightCache(((Long)this.arg).longValue()).execute();
/*    */     
/* 21 */     JingjiPvp xJingjiPvp = Role2jingjipvp.get((Long)this.arg);
/* 22 */     if ((xJingjiPvp == null) || (xJingjiPvp.getLastseasonendtime() == 0L))
/*    */     {
/* 24 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 28 */     Pair<Long, Integer> pair = JingjiManager.getSeasonStarttimeAndMergeClear();
/* 29 */     long seasonstarttime = ((Long)pair.first).longValue();
/* 30 */     if (seasonstarttime == 0L)
/*    */     {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     int mergeClear = ((Integer)pair.second).intValue();
/* 36 */     if (mergeClear == 1)
/*    */     {
/*    */ 
/* 39 */       if (xJingjiPvp.getMerge_cleared() == 0)
/*    */       {
/* 41 */         JingjiManager.seasonEndInitRoleData(xJingjiPvp, seasonstarttime);
/* 42 */         xJingjiPvp.setMerge_cleared(1);
/*    */       }
/*    */       
/*    */ 
/*    */     }
/* 47 */     else if (xJingjiPvp.getLastseasonendtime() != seasonstarttime)
/*    */     {
/*    */ 
/* 50 */       JingjiManager.seasonEndInitRoleData(xJingjiPvp, seasonstarttime);
/*    */     }
/*    */     
/*    */ 
/* 54 */     RoleJingjiChartInterface.rank(((Long)this.arg).longValue(), xJingjiPvp.getWinpoint());
/* 55 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\POnRoleLoginSeasonInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */