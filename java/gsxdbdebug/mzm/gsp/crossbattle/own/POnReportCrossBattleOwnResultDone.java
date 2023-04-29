/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*    */ import mzm.gsp.crossbattle.knockout.CrossBattleKnockoutInterface;
/*    */ import mzm.gsp.crossserver.event.ReportCrossBattleOwnResultDoneArg;
/*    */ import mzm.gsp.crossserver.event.ReportCrossBattleOwnResultDoneProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.CrossBattleOwn;
/*    */ import xtable.Cross_battle_owns;
/*    */ 
/*    */ public class POnReportCrossBattleOwnResultDone
/*    */   extends ReportCrossBattleOwnResultDoneProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     int activityCfgid = ((ReportCrossBattleOwnResultDoneArg)this.arg).getActivityCfgid();
/* 19 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(activityCfgid);
/* 20 */     if (cfg == null)
/*    */     {
/* 22 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 26 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgid);
/* 27 */     CrossBattleOwn xCrossBattleOwn = Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/* 28 */     if ((xCrossBattleOwn == null) || (xCrossBattleOwn.getStage() != 3))
/*    */     {
/* 30 */       return false;
/*    */     }
/* 32 */     if (((ReportCrossBattleOwnResultDoneArg)this.arg).isSucceed())
/*    */     {
/* 34 */       xCrossBattleOwn.setReport_result_success(true);
/* 35 */       CrossBattleOwnTLogManager.addReportOwnResultTLog(activityCfgid, 5, xCrossBattleOwn.getRound_robin_stage_promotion_corps_list());
/*    */       
/* 37 */       CrossBattleKnockoutInterface.initCorpsRoleInfoReportObserver();
/* 38 */       CrossBattleOwnManager.logger.info(String.format("[crossbattle_own]POnReportCrossBattleOwnResultDone.processImp@report success|activity_cfg_id=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/*    */ 
/* 44 */       CrossBattleOwnManager.reportCrossBattleOwnResult(xCrossBattleOwn, activityCfgid);
/*    */     }
/* 46 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\POnReportCrossBattleOwnResultDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */