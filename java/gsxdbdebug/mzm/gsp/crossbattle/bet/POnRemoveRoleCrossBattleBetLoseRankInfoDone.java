/*    */ package mzm.gsp.crossbattle.bet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.crossbattle.RemoveRoleCrossBattleBetRankInfoContext;
/*    */ import mzm.gsp.crossserver.event.RemoveRoleCrossBattleBetLoseRankInfoDoneArg;
/*    */ import mzm.gsp.crossserver.event.RemoveRoleCrossBattleBetLoseRankInfoDoneProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.RoleCrossBattleBetProfitInfo;
/*    */ import xbean.RoleCrossBattleBetSeasonProfitInfo;
/*    */ import xtable.Role_cross_battle_bet_season_profot_infos;
/*    */ 
/*    */ public class POnRemoveRoleCrossBattleBetLoseRankInfoDone
/*    */   extends RemoveRoleCrossBattleBetLoseRankInfoDoneProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     int activityCfgid = (int)((RemoveRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getRankid();
/* 20 */     RemoveRoleCrossBattleBetRankInfoContext context = new RemoveRoleCrossBattleBetRankInfoContext();
/* 21 */     context.unmarshal(OctetsStream.wrap(((RemoveRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getContext()));
/* 22 */     if (((RemoveRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).isSucceed())
/*    */     {
/* 24 */       CrossBattleBetManager.logger.info(String.format("[crossbattle]POnRemoveRoleCrossBattleBetLoseRankInfoDone.processImp@remove role cross battle bet lose rank info success|count=%d|activity_cfg_id=%d|roleid=%d", new Object[] { Byte.valueOf(context.count), Integer.valueOf(activityCfgid), Long.valueOf(((RemoveRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getRoleid()) }));
/*    */       
/*    */ 
/* 27 */       return true;
/*    */     }
/*    */     
/* 30 */     if (!((RemoveRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).isTimeout())
/*    */     {
/* 32 */       CrossBattleBetManager.logger.error(String.format("[crossbattle]POnRemoveRoleCrossBattleBetLoseRankInfoDone.processImp@remove role cross battle bet lose rank info fail|count=%d|activity_cfg_id=%d|roleid=%d", new Object[] { Byte.valueOf(context.count), Integer.valueOf(activityCfgid), Long.valueOf(((RemoveRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getRoleid()) }));
/*    */       
/*    */ 
/* 35 */       return true;
/*    */     }
/*    */     
/* 38 */     CrossBattleBetManager.logger.error(String.format("[crossbattle]POnRemoveRoleCrossBattleBetLoseRankInfoDone.processImp@remove role cross battle bet lose rank info timeout|count=%d|activity_cfg_id=%d|roleid=%d", new Object[] { Byte.valueOf(context.count), Integer.valueOf(activityCfgid), Long.valueOf(((RemoveRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getRoleid()) }));
/*    */     
/*    */ 
/* 41 */     if (context.count < CrossBattleBetManager.GRC_MAX_TRY_TIMES)
/*    */     {
/*    */ 
/* 44 */       RoleCrossBattleBetSeasonProfitInfo xRoleCrossBattleBetSeasonProfitInfo = Role_cross_battle_bet_season_profot_infos.get(Long.valueOf(((RemoveRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getRoleid()));
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
/* 57 */       CrossBattleBetManager.reportRoleBetRankInfo(activityCfgid, ((RemoveRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getRoleid(), RoleInterface.getName(((RemoveRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getRoleid()), RoleInterface.getOccupationId(((RemoveRoleCrossBattleBetLoseRankInfoDoneArg)this.arg).getRoleid()), xRoleCrossBattleBetProfitInfo.getProfit(), xRoleCrossBattleBetProfitInfo.getTimestamp(), context.count + 1);
/*    */     }
/*    */     
/*    */ 
/* 61 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\POnRemoveRoleCrossBattleBetLoseRankInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */