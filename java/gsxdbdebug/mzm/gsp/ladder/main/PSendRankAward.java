/*     */ package mzm.gsp.ladder.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossLadderLevelRangeRankBackup;
/*     */ import xbean.CrossLadderRankAwardInfo;
/*     */ import xbean.CrossLadderRankBackup;
/*     */ import xbean.CrossLadderSeasonRankBackup;
/*     */ import xbean.RoleCrossLadderRankAwardInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Cross_ladder_rank_backups;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PSendRankAward extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long seasonBeginTimestamp;
/*     */   private final int levelRange;
/*     */   private final int chartType;
/*     */   
/*     */   PSendRankAward(long roleid, long seasonBeginTimestamp, int levelRange, int chartType)
/*     */   {
/*  28 */     this.roleid = roleid;
/*  29 */     this.seasonBeginTimestamp = seasonBeginTimestamp;
/*  30 */     this.levelRange = levelRange;
/*  31 */     this.chartType = chartType;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (!OpenInterface.getOpenStatus(188))
/*     */     {
/*     */ 
/*  40 */       onFail(-1, null);
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     long localid = GameServerInfoManager.getLocalId();
/*  45 */     CrossLadderRankBackup xCrossLadderRankBackup = Cross_ladder_rank_backups.get(Long.valueOf(localid));
/*  46 */     if (xCrossLadderRankBackup == null)
/*     */     {
/*     */ 
/*  49 */       return false;
/*     */     }
/*  51 */     CrossLadderSeasonRankBackup xCrossLadderSeasonRankBackup = (CrossLadderSeasonRankBackup)xCrossLadderRankBackup.getBackups().get(Long.valueOf(this.seasonBeginTimestamp));
/*     */     
/*  53 */     if (xCrossLadderSeasonRankBackup == null)
/*     */     {
/*     */ 
/*  56 */       return false;
/*     */     }
/*  58 */     CrossLadderLevelRangeRankBackup xCrossLadderLevelRangeRankBackup = (CrossLadderLevelRangeRankBackup)xCrossLadderSeasonRankBackup.getLevel_range_rank_backups().get(Integer.valueOf(this.levelRange));
/*     */     
/*  60 */     if (xCrossLadderLevelRangeRankBackup == null)
/*     */     {
/*     */ 
/*  63 */       return false;
/*     */     }
/*  65 */     CrossLadderRankAwardInfo xCrossLadderRankAwardInfo = (CrossLadderRankAwardInfo)xCrossLadderLevelRangeRankBackup.getRank_award_infos().get(Integer.valueOf(this.chartType));
/*     */     
/*  67 */     if (xCrossLadderRankAwardInfo == null)
/*     */     {
/*     */ 
/*  70 */       return false;
/*     */     }
/*  72 */     RoleCrossLadderRankAwardInfo xRoleCrossLadderRankAwardInfo = (RoleCrossLadderRankAwardInfo)xCrossLadderRankAwardInfo.getRole_rank_award_infos().get(Long.valueOf(this.roleid));
/*     */     
/*  74 */     if (xRoleCrossLadderRankAwardInfo == null)
/*     */     {
/*     */ 
/*  77 */       return false;
/*     */     }
/*  79 */     if (xRoleCrossLadderRankAwardInfo.getAwarded())
/*     */     {
/*     */ 
/*  82 */       onFail(1, null);
/*  83 */       return false;
/*     */     }
/*  85 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*     */     
/*  87 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  89 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*  90 */     mzm.gsp.chart.main.RankInterface.sendChartAward(userid, this.roleid, this.chartType, xRoleCrossLadderRankAwardInfo.getRank());
/*  91 */     xRoleCrossLadderRankAwardInfo.setAwarded(true);
/*  92 */     GameServer.logger().info(String.format("[ladder]PSendRankAward.processImp@send rank award success|roleid=%d|season_begin_timestamp=%d|level_range=%d|chart_type=%d|rank=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.seasonBeginTimestamp), Integer.valueOf(this.levelRange), Integer.valueOf(this.chartType), Integer.valueOf(xRoleCrossLadderRankAwardInfo.getRank()) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  97 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 102 */     StringBuilder sb = new StringBuilder();
/* 103 */     sb.append(String.format("[ladder]PSendRankAward.processImp@send rank award fail|roleid=%d|season_begin_timestamp=%d|level_range=%d|chart_type=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.seasonBeginTimestamp), Integer.valueOf(this.levelRange), Integer.valueOf(this.chartType), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 106 */     if (extraInfo != null)
/*     */     {
/* 108 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 110 */         sb.append("|").append((String)entry.getKey());
/* 111 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 114 */     GameServer.logger().info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\PSendRankAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */