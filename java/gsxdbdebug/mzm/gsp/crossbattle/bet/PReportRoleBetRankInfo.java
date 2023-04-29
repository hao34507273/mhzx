/*    */ package mzm.gsp.crossbattle.bet;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RoleCrossBattleBetProfitInfo;
/*    */ import xbean.RoleCrossBattleBetSeasonProfitInfo;
/*    */ import xtable.Role_cross_battle_bet_season_profot_infos;
/*    */ 
/*    */ public class PReportRoleBetRankInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   PReportRoleBetRankInfo(long roleid)
/*    */   {
/* 18 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     RoleCrossBattleBetSeasonProfitInfo xRoleCrossBattleBetSeasonProfitInfo = Role_cross_battle_bet_season_profot_infos.get(Long.valueOf(this.roleid));
/* 26 */     if (xRoleCrossBattleBetSeasonProfitInfo == null)
/*    */     {
/* 28 */       return false;
/*    */     }
/* 30 */     for (Map.Entry<Integer, RoleCrossBattleBetProfitInfo> entry : xRoleCrossBattleBetSeasonProfitInfo.getProfit_infos().entrySet())
/*    */     {
/* 32 */       int activityCfgid = ((Integer)entry.getKey()).intValue();
/* 33 */       RoleCrossBattleBetProfitInfo xRoleCrossBattleBetProfitInfo = (RoleCrossBattleBetProfitInfo)entry.getValue();
/* 34 */       CrossBattleBetManager.reportRoleBetRankInfo(activityCfgid, this.roleid, RoleInterface.getName(this.roleid), RoleInterface.getOccupationId(this.roleid), xRoleCrossBattleBetProfitInfo.getProfit(), xRoleCrossBattleBetProfitInfo.getTimestamp(), 1);
/*    */     }
/*    */     
/*    */ 
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\PReportRoleBetRankInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */