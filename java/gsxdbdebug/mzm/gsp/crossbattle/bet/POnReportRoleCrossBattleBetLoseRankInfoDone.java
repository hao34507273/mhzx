/*    */ package mzm.gsp.crossbattle.bet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.crossbattle.ReportRoleCrossBattleBetRankInfoContext;
/*    */ import mzm.gsp.crossserver.event.ReportRoleCrossBattleBetLoseRankInfoDoneArg;
/*    */ import mzm.gsp.crossserver.event.ReportRoleCrossBattleBetLoseRankInfoDoneProcedure;
/*    */ import mzm.gsp.crossserver.top.CrossBattleBetLoseTopChartObj;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.RoleCrossBattleBetProfitInfo;
/*    */ import xbean.RoleCrossBattleBetSeasonProfitInfo;
/*    */ import xtable.Role_cross_battle_bet_season_profot_infos;
/*    */ 
/*    */ public class POnReportRoleCrossBattleBetLoseRankInfoDone extends ReportRoleCrossBattleBetLoseRankInfoDoneProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     int activityCfgid = (int)((ReportRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getRankid();
/* 20 */     ReportRoleCrossBattleBetRankInfoContext context = new ReportRoleCrossBattleBetRankInfoContext();
/* 21 */     context.unmarshal(OctetsStream.wrap(((ReportRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getContext()));
/* 22 */     if (((ReportRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).isSucceed())
/*    */     {
/* 24 */       CrossBattleBetManager.logger.info(String.format("[crossbattle]POnReportRoleCrossBattleBetLoseRankInfoDone.processImp@report role cross battle bet lose rank info success|count=%d|activity_cfg_id=%d|roleid=%d|profit=%d|timestamp=%d", new Object[] { Byte.valueOf(context.count), Integer.valueOf(activityCfgid), Long.valueOf(((ReportRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getChartObj().getRoleid()), Long.valueOf(((ReportRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getChartObj().getProfit()), Long.valueOf(((ReportRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getChartObj().getTimestamp()) }));
/*    */       
/*    */ 
/*    */ 
/* 28 */       return true;
/*    */     }
/*    */     
/* 31 */     if (!((ReportRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).isTimeout())
/*    */     {
/* 33 */       CrossBattleBetManager.logger.error(String.format("[crossbattle]POnReportRoleCrossBattleBetLoseRankInfoDone.processImp@report role cross battle bet lose rank info fail|count=%d|activity_cfg_id=%d|roleid=%d|profit=%d|timestamp=%d", new Object[] { Byte.valueOf(context.count), Integer.valueOf(activityCfgid), Long.valueOf(((ReportRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getChartObj().getRoleid()), Long.valueOf(((ReportRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getChartObj().getProfit()), Long.valueOf(((ReportRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getChartObj().getTimestamp()) }));
/*    */       
/*    */ 
/*    */ 
/* 37 */       return true;
/*    */     }
/*    */     
/* 40 */     CrossBattleBetManager.logger.error(String.format("[crossbattle]POnReportRoleCrossBattleBetLoseRankInfoDone.processImp@report role cross battle bet lose rank info timeout|count=%d|activity_cfg_id=%d|roleid=%d|profit=%d|timestamp=%d", new Object[] { Byte.valueOf(context.count), Integer.valueOf(activityCfgid), Long.valueOf(((ReportRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getChartObj().getRoleid()), Long.valueOf(((ReportRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getChartObj().getProfit()), Long.valueOf(((ReportRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getChartObj().getTimestamp()) }));
/*    */     
/*    */ 
/*    */ 
/* 44 */     if (context.count < CrossBattleBetManager.GRC_MAX_TRY_TIMES)
/*    */     {
/*    */ 
/* 47 */       RoleCrossBattleBetSeasonProfitInfo xRoleCrossBattleBetSeasonProfitInfo = Role_cross_battle_bet_season_profot_infos.get(Long.valueOf(((ReportRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getChartObj().getRoleid()));
/* 48 */       if (xRoleCrossBattleBetSeasonProfitInfo == null)
/*    */       {
/*    */ 
/* 51 */         return false;
/*    */       }
/* 53 */       RoleCrossBattleBetProfitInfo xRoleCrossBattleBetProfitInfo = (RoleCrossBattleBetProfitInfo)xRoleCrossBattleBetSeasonProfitInfo.getProfit_infos().get(Integer.valueOf(activityCfgid));
/*    */       
/* 55 */       if (xRoleCrossBattleBetProfitInfo == null)
/*    */       {
/*    */ 
/* 58 */         return false;
/*    */       }
/* 60 */       CrossBattleBetManager.reportRoleBetRankInfo(activityCfgid, ((ReportRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getChartObj().getRoleid(), RoleInterface.getName(((ReportRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getChartObj().getRoleid()), RoleInterface.getOccupationId(((ReportRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getChartObj().getRoleid()), xRoleCrossBattleBetProfitInfo.getProfit(), xRoleCrossBattleBetProfitInfo.getTimestamp(), context.count + 1);
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 65 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\POnReportRoleCrossBattleBetLoseRankInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */