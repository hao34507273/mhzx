/*    */ package mzm.gsp.crossbattle.bet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.crossbattle.ReportRoleCrossBattleBetRankInfoContext;
/*    */ import mzm.gsp.crossserver.event.ReportRoleCrossBattleBetWinRankInfoDoneArg;
/*    */ import mzm.gsp.crossserver.event.ReportRoleCrossBattleBetWinRankInfoDoneProcedure;
/*    */ import mzm.gsp.crossserver.top.CrossBattleBetWinTopChartObj;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.RoleCrossBattleBetProfitInfo;
/*    */ import xbean.RoleCrossBattleBetSeasonProfitInfo;
/*    */ import xtable.Role_cross_battle_bet_season_profot_infos;
/*    */ 
/*    */ public class POnReportRoleCrossBattleBetWinRankInfoDone extends ReportRoleCrossBattleBetWinRankInfoDoneProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     int activityCfgid = (int)((ReportRoleCrossBattleBetWinRankInfoDoneArg)this.arg).getRankid();
/* 20 */     ReportRoleCrossBattleBetRankInfoContext context = new ReportRoleCrossBattleBetRankInfoContext();
/* 21 */     context.unmarshal(OctetsStream.wrap(((ReportRoleCrossBattleBetWinRankInfoDoneArg)this.arg).getContext()));
/* 22 */     if (((ReportRoleCrossBattleBetWinRankInfoDoneArg)this.arg).isSucceed())
/*    */     {
/* 24 */       CrossBattleBetManager.logger.info(String.format("[crossbattle]POnReportRoleCrossBattleBetWinRankInfoDone.processImp@report role cross battle bet win rank info success|count=%d|activity_cfg_id=%d|roleid=%d|profit=%d|timestamp=%d", new Object[] { Byte.valueOf(context.count), Integer.valueOf(activityCfgid), Long.valueOf(((ReportRoleCrossBattleBetWinRankInfoDoneArg)this.arg).getChartObj().getRoleid()), Long.valueOf(((ReportRoleCrossBattleBetWinRankInfoDoneArg)this.arg).getChartObj().getProfit()), Long.valueOf(((ReportRoleCrossBattleBetWinRankInfoDoneArg)this.arg).getChartObj().getTimestamp()) }));
/*    */       
/*    */ 
/*    */ 
/* 28 */       return true;
/*    */     }
/*    */     
/* 31 */     if (!((ReportRoleCrossBattleBetWinRankInfoDoneArg)this.arg).isTimeout())
/*    */     {
/* 33 */       CrossBattleBetManager.logger.error(String.format("[crossbattle]POnReportRoleCrossBattleBetWinRankInfoDone.processImp@report role cross battle bet win rank info fail|count=%d|activity_cfg_id=%d|roleid=%d|profit=%d|timestamp=%d", new Object[] { Byte.valueOf(context.count), Integer.valueOf(activityCfgid), Long.valueOf(((ReportRoleCrossBattleBetWinRankInfoDoneArg)this.arg).getChartObj().getRoleid()), Long.valueOf(((ReportRoleCrossBattleBetWinRankInfoDoneArg)this.arg).getChartObj().getProfit()), Long.valueOf(((ReportRoleCrossBattleBetWinRankInfoDoneArg)this.arg).getChartObj().getTimestamp()) }));
/*    */       
/*    */ 
/*    */ 
/* 37 */       return true;
/*    */     }
/*    */     
/* 40 */     CrossBattleBetManager.logger.error(String.format("[crossbattle]POnReportRoleCrossBattleBetWinRankInfoDone.processImp@report role cross battle bet win rank info timeout|count=%d|activity_cfg_id=%d|roleid=%d|profit=%d|timestamp=%d", new Object[] { Byte.valueOf(context.count), Integer.valueOf(activityCfgid), Long.valueOf(((ReportRoleCrossBattleBetWinRankInfoDoneArg)this.arg).getChartObj().getRoleid()), Long.valueOf(((ReportRoleCrossBattleBetWinRankInfoDoneArg)this.arg).getChartObj().getProfit()), Long.valueOf(((ReportRoleCrossBattleBetWinRankInfoDoneArg)this.arg).getChartObj().getTimestamp()) }));
/*    */     
/*    */ 
/*    */ 
/* 44 */     if (context.count < CrossBattleBetManager.GRC_MAX_TRY_TIMES)
/*    */     {
/*    */ 
/* 47 */       RoleCrossBattleBetSeasonProfitInfo xRoleCrossBattleBetSeasonProfitInfo = Role_cross_battle_bet_season_profot_infos.get(Long.valueOf(((ReportRoleCrossBattleBetWinRankInfoDoneArg)this.arg).getChartObj().getRoleid()));
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
/* 60 */       CrossBattleBetManager.reportRoleBetRankInfo(activityCfgid, ((ReportRoleCrossBattleBetWinRankInfoDoneArg)this.arg).getChartObj().getRoleid(), RoleInterface.getName(((ReportRoleCrossBattleBetWinRankInfoDoneArg)this.arg).getChartObj().getRoleid()), RoleInterface.getOccupationId(((ReportRoleCrossBattleBetWinRankInfoDoneArg)this.arg).getChartObj().getRoleid()), xRoleCrossBattleBetProfitInfo.getProfit(), xRoleCrossBattleBetProfitInfo.getTimestamp(), context.count + 1);
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 65 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\POnReportRoleCrossBattleBetWinRankInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */