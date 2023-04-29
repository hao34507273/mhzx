/*    */ package mzm.gsp.crossbattle.bet;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattleStageDurationCfg;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Pod;
/*    */ import xbean.RoleCrossBattleBetProfitInfo;
/*    */ import xbean.RoleCrossBattleBetSeasonProfitInfo;
/*    */ import xtable.Role_cross_battle_bet_season_profot_infos;
/*    */ 
/*    */ public class PGM_SetCrossBattleBetProfit extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   private final int activityCfgid;
/*    */   private final long profit;
/*    */   
/*    */   public PGM_SetCrossBattleBetProfit(long gmRoleid, long roleid, int activityCfgid, long profit)
/*    */   {
/* 22 */     this.gmRoleid = gmRoleid;
/* 23 */     this.roleid = roleid;
/* 24 */     this.activityCfgid = activityCfgid;
/* 25 */     this.profit = profit;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     if (SCrossBattleStageDurationCfg.get(this.activityCfgid) == null)
/*    */     {
/*    */ 
/* 34 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("活动配置ID错误", new Object[0]));
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     RoleCrossBattleBetSeasonProfitInfo xRoleCrossBattleBetSeasonProfitInfo = Role_cross_battle_bet_season_profot_infos.get(Long.valueOf(this.roleid));
/* 39 */     if (xRoleCrossBattleBetSeasonProfitInfo == null)
/*    */     {
/* 41 */       xRoleCrossBattleBetSeasonProfitInfo = Pod.newRoleCrossBattleBetSeasonProfitInfo();
/* 42 */       Role_cross_battle_bet_season_profot_infos.insert(Long.valueOf(this.roleid), xRoleCrossBattleBetSeasonProfitInfo);
/*    */     }
/* 44 */     RoleCrossBattleBetProfitInfo xRoleCrossBattleBetProfitInfo = (RoleCrossBattleBetProfitInfo)xRoleCrossBattleBetSeasonProfitInfo.getProfit_infos().get(Integer.valueOf(this.activityCfgid));
/*    */     
/* 46 */     if (xRoleCrossBattleBetProfitInfo == null)
/*    */     {
/* 48 */       xRoleCrossBattleBetProfitInfo = Pod.newRoleCrossBattleBetProfitInfo();
/* 49 */       xRoleCrossBattleBetSeasonProfitInfo.getProfit_infos().put(Integer.valueOf(this.activityCfgid), xRoleCrossBattleBetProfitInfo);
/*    */     }
/* 51 */     xRoleCrossBattleBetProfitInfo.setProfit(this.profit);
/* 52 */     xRoleCrossBattleBetProfitInfo.setTimestamp(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/* 53 */     CrossBattleBetManager.reportRoleBetRankInfo(this.activityCfgid, this.roleid, RoleInterface.getName(this.roleid), RoleInterface.getOccupationId(this.roleid), xRoleCrossBattleBetProfitInfo.getProfit(), xRoleCrossBattleBetProfitInfo.getTimestamp(), 1);
/*    */     
/*    */ 
/* 56 */     CrossBattleBetManager.logger.info(String.format("[crossbattle]PGM_SetCrossBattleBetProfit.processImp@set cross battle bet profit|activity_cfg_id=%d|roleid=%d|profit=%d|timestamp=%d", new Object[] { Integer.valueOf(this.activityCfgid), Long.valueOf(this.roleid), Long.valueOf(xRoleCrossBattleBetProfitInfo.getProfit()), Long.valueOf(xRoleCrossBattleBetProfitInfo.getTimestamp()) }));
/*    */     
/*    */ 
/* 59 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("设置跨服战押注获利成功|角色ID=%d|活动配置ID=%d|获利=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Long.valueOf(this.profit) }));
/*    */     
/* 61 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\PGM_SetCrossBattleBetProfit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */