/*    */ package mzm.gsp.crossbattle.bet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.crossbattle.RemoveRoleCrossBattleBetRankInfoContext;
/*    */ import mzm.gsp.crossserver.event.RemoveRoleCrossBattleBetWinRankInfoDoneArg;
/*    */ import mzm.gsp.crossserver.event.RemoveRoleCrossBattleBetWinRankInfoDoneProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.RoleCrossBattleBetProfitInfo;
/*    */ import xbean.RoleCrossBattleBetSeasonProfitInfo;
/*    */ import xtable.Role_cross_battle_bet_season_profot_infos;
/*    */ 
/*    */ public class POnRemoveRoleCrossBattleBetWinRankInfoDone
/*    */   extends RemoveRoleCrossBattleBetWinRankInfoDoneProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     int activityCfgid = (int)((RemoveRoleCrossBattleBetWinRankInfoDoneArg)this.arg).getRankid();
/* 20 */     RemoveRoleCrossBattleBetRankInfoContext context = new RemoveRoleCrossBattleBetRankInfoContext();
/* 21 */     context.unmarshal(OctetsStream.wrap(((RemoveRoleCrossBattleBetWinRankInfoDoneArg)this.arg).getContext()));
/* 22 */     if (((RemoveRoleCrossBattleBetWinRankInfoDoneArg)this.arg).isSucceed())
/*    */     {
/* 24 */       CrossBattleBetManager.logger.info(String.format("[crossbattle]POnRemoveRoleCrossBattleBetWinRankInfoDone.processImp@remove role cross battle bet win rank info success|count=%d|activity_cfg_id=%d|roleid=%d", new Object[] { Byte.valueOf(context.count), Integer.valueOf(activityCfgid), Long.valueOf(((RemoveRoleCrossBattleBetWinRankInfoDoneArg)this.arg).getRoleid()) }));
/*    */       
/*    */ 
/* 27 */       return true;
/*    */     }
/*    */     
/* 30 */     if (!((RemoveRoleCrossBattleBetWinRankInfoDoneArg)this.arg).isTimeout())
/*    */     {
/* 32 */       CrossBattleBetManager.logger.error(String.format("[crossbattle]POnRemoveRoleCrossBattleBetWinRankInfoDone.processImp@remove role cross battle bet win rank info fail|count=%d|activity_cfg_id=%d|roleid=%d", new Object[] { Byte.valueOf(context.count), Integer.valueOf(activityCfgid), Long.valueOf(((RemoveRoleCrossBattleBetWinRankInfoDoneArg)this.arg).getRoleid()) }));
/*    */       
/*    */ 
/* 35 */       return true;
/*    */     }
/*    */     
/* 38 */     CrossBattleBetManager.logger.error(String.format("[crossbattle]POnRemoveRoleCrossBattleBetWinRankInfoDone.processImp@remove role cross battle bet win rank info timeout|count=%d|activity_cfg_id=%d|roleid=%d", new Object[] { Byte.valueOf(context.count), Integer.valueOf(activityCfgid), Long.valueOf(((RemoveRoleCrossBattleBetWinRankInfoDoneArg)this.arg).getRoleid()) }));
/*    */     
/*    */ 
/* 41 */     if (context.count < CrossBattleBetManager.GRC_MAX_TRY_TIMES)
/*    */     {
/*    */ 
/* 44 */       RoleCrossBattleBetSeasonProfitInfo xRoleCrossBattleBetSeasonProfitInfo = Role_cross_battle_bet_season_profot_infos.get(Long.valueOf(((RemoveRoleCrossBattleBetWinRankInfoDoneArg)this.arg).getRoleid()));
/* 45 */       if (xRoleCrossBattleBetSeasonProfitInfo == null)
/*    */       {
/*    */ 
/* 48 */         return false;
/*    */       }
/* 50 */       RoleCrossBattleBetProfitInfo xRoleCrossBattleBetProfitInfo = (RoleCrossBattleBetProfitInfo)xRoleCrossBattleBetSeasonProfitInfo.getProfit_infos().get(Integer.valueOf(activityCfgid));
/*    */       
/* 52 */       if (xRoleCrossBattleBetProfitInfo == null)
/*    */       {
/*    */ 
/* 55 */         return false;
/*    */       }
/* 57 */       CrossBattleBetManager.reportRoleBetRankInfo(activityCfgid, ((RemoveRoleCrossBattleBetWinRankInfoDoneArg)this.arg).getRoleid(), RoleInterface.getName(((RemoveRoleCrossBattleBetWinRankInfoDoneArg)this.arg).getRoleid()), RoleInterface.getOccupationId(((RemoveRoleCrossBattleBetWinRankInfoDoneArg)this.arg).getRoleid()), xRoleCrossBattleBetProfitInfo.getProfit(), xRoleCrossBattleBetProfitInfo.getTimestamp(), context.count + 1);
/*    */     }
/*    */     
/*    */ 
/* 61 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\POnRemoveRoleCrossBattleBetWinRankInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */