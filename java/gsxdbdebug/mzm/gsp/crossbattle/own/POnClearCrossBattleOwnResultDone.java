/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*    */ import mzm.gsp.crossserver.event.ClearCrossBattleOwnResultDoneArg;
/*    */ import mzm.gsp.crossserver.event.ClearCrossBattleOwnResultDoneProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.CrossBattleOwn;
/*    */ import xtable.Cross_battle_owns;
/*    */ 
/*    */ public class POnClearCrossBattleOwnResultDone
/*    */   extends ClearCrossBattleOwnResultDoneProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     int activityCfgid = ((ClearCrossBattleOwnResultDoneArg)this.arg).getActivityCfgid();
/* 18 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(activityCfgid);
/* 19 */     if (cfg == null)
/*    */     {
/* 21 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 25 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgid);
/* 26 */     CrossBattleOwn xCrossBattleOwn = Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/* 27 */     if ((xCrossBattleOwn == null) || (xCrossBattleOwn.getStage() != 3))
/*    */     {
/* 29 */       return false;
/*    */     }
/* 31 */     if (((ClearCrossBattleOwnResultDoneArg)this.arg).isSucceed())
/*    */     {
/* 33 */       CrossBattleOwnTLogManager.addReportOwnResultTLog(activityCfgid, 6, xCrossBattleOwn.getRound_robin_stage_promotion_corps_list());
/*    */       
/* 35 */       xCrossBattleOwn.setReport_result_success(false);
/* 36 */       xCrossBattleOwn.setStage(2);
/* 37 */       xCrossBattleOwn.getRound_robin_stage_promotion_corps_list().clear();
/* 38 */       CrossBattleOwnManager.logger.info(String.format("[crossbattle_own]POnClearCrossBattleOwnResultDone.processImp@set report result success to false|activity_cfg_id=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/*    */ 
/* 44 */       CrossBattleOwnManager.clearCrossBattleOwnResultByIdip(activityCfgid);
/*    */     }
/* 46 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\POnClearCrossBattleOwnResultDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */