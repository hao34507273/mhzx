/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.CrossBattleOwn;
/*    */ import xtable.Cross_battle_owns;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PTryReportCrossBattleOwnResult
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final int activityCfgid;
/*    */   
/*    */   public PTryReportCrossBattleOwnResult(int activityCfgid)
/*    */   {
/* 18 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(this.activityCfgid);
/* 25 */     if (cfg == null)
/*    */     {
/*    */ 
/* 28 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 32 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/* 33 */     CrossBattleOwn xCrossBattleOwn = Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/* 34 */     if ((xCrossBattleOwn == null) || (xCrossBattleOwn.getStage() != 3))
/*    */     {
/* 36 */       return false;
/*    */     }
/* 38 */     CrossBattleOwnManager.reportCrossBattleOwnResult(xCrossBattleOwn, this.activityCfgid);
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\PTryReportCrossBattleOwnResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */