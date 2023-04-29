/*     */ package mzm.gsp.crossbattle.bet;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleBetRankAwardInfo;
/*     */ import xbean.CrossBattleBetRankBackup;
/*     */ import xbean.CrossBattleBetSeasonRankBackup;
/*     */ import xbean.RoleCrossBattleBetRankAwardInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Cross_battle_bet_rank_backups;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PSendRankAward extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int chartType;
/*     */   
/*     */   PSendRankAward(long roleid, int activityCfgid, int chartType)
/*     */   {
/*  24 */     this.roleid = roleid;
/*  25 */     this.activityCfgid = activityCfgid;
/*  26 */     this.chartType = chartType;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     if (!CrossBattleBetManager.isCrossBattleBetRankSwitchOpenForRole(this.roleid))
/*     */     {
/*     */ 
/*  35 */       onFail(-1, null);
/*  36 */       return false;
/*     */     }
/*  38 */     long localid = GameServerInfoManager.getLocalId();
/*     */     
/*  40 */     lock(Cross_battle_bet_rank_backups.getTable(), Arrays.asList(new Long[] { Long.valueOf(localid) }));
/*  41 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*     */     
/*  43 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  45 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  47 */     CrossBattleBetRankBackup xCrossBattleBetRankBackup = Cross_battle_bet_rank_backups.get(Long.valueOf(localid));
/*  48 */     if (xCrossBattleBetRankBackup == null)
/*     */     {
/*     */ 
/*  51 */       return false;
/*     */     }
/*  53 */     CrossBattleBetSeasonRankBackup xCrossBattleBetSeasonRankBackup = (CrossBattleBetSeasonRankBackup)xCrossBattleBetRankBackup.getBackups().get(Integer.valueOf(this.activityCfgid));
/*     */     
/*  55 */     if (xCrossBattleBetSeasonRankBackup == null)
/*     */     {
/*     */ 
/*  58 */       return false;
/*     */     }
/*  60 */     CrossBattleBetRankAwardInfo xCrossBattleBetRankAwardInfo = (CrossBattleBetRankAwardInfo)xCrossBattleBetSeasonRankBackup.getRank_award_infos().get(Integer.valueOf(this.chartType));
/*     */     
/*  62 */     if (xCrossBattleBetRankAwardInfo == null)
/*     */     {
/*     */ 
/*  65 */       return false;
/*     */     }
/*  67 */     RoleCrossBattleBetRankAwardInfo xRoleCrossBattleBetRankAwardInfo = (RoleCrossBattleBetRankAwardInfo)xCrossBattleBetRankAwardInfo.getRole_rank_award_infos().get(Long.valueOf(this.roleid));
/*     */     
/*  69 */     if (xRoleCrossBattleBetRankAwardInfo == null)
/*     */     {
/*     */ 
/*  72 */       return false;
/*     */     }
/*  74 */     if (xRoleCrossBattleBetRankAwardInfo.getAwarded())
/*     */     {
/*     */ 
/*  77 */       onFail(13, null);
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     mzm.gsp.chart.main.RankInterface.sendChartAward(userid, this.roleid, this.chartType, xRoleCrossBattleBetRankAwardInfo.getRank());
/*  82 */     xRoleCrossBattleBetRankAwardInfo.setAwarded(true);
/*  83 */     CrossBattleBetManager.logger.info(String.format("[crossbattle]PSendRankAward.processImp@send rank award success|roleid=%d|activity_cfg_id=%d|chart_type=%d|rank=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.chartType), Integer.valueOf(xRoleCrossBattleBetRankAwardInfo.getRank()) }));
/*     */     
/*     */ 
/*  86 */     CrossBattleBetTLogManager.addRankAwardTLog(this.roleid, this.activityCfgid, this.chartType, xRoleCrossBattleBetRankAwardInfo.getRank());
/*     */     
/*  88 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/*  93 */     StringBuilder sb = new StringBuilder();
/*  94 */     sb.append(String.format("[crossbattle]PSendRankAward.processImp@send rank award fail|roleid=%d|activity_cfg_id=%d|chart_type=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.chartType), Integer.valueOf(res) }));
/*     */     
/*     */ 
/*  97 */     if (extraInfo != null)
/*     */     {
/*  99 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 101 */         sb.append("|").append((String)entry.getKey());
/* 102 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 105 */     CrossBattleBetManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\PSendRankAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */