/*     */ package mzm.gsp.crossfield.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.RoleSingleCrossFieldRankAwardInfo;
/*     */ import xbean.SingleCrossFieldRankAwardInfo;
/*     */ import xbean.SingleCrossFieldRankBackup;
/*     */ import xbean.SingleCrossFieldSeasonRankBackup;
/*     */ import xtable.Basic;
/*     */ import xtable.Single_cross_field_rank_backups;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PSendRankAward extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int season;
/*     */   private final int chartType;
/*     */   
/*     */   PSendRankAward(long roleid, int season, int chartType)
/*     */   {
/*  24 */     this.roleid = roleid;
/*  25 */     this.season = season;
/*  26 */     this.chartType = chartType;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     if (!CrossFieldManager.isCrossFieldSwitchOpenForRole(this.roleid))
/*     */     {
/*     */ 
/*  35 */       onFail(-1, null);
/*  36 */       return false;
/*     */     }
/*     */     
/*  39 */     SingleCrossFieldRankBackup xSingleCrossFieldRankBackup = Single_cross_field_rank_backups.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  40 */     if (xSingleCrossFieldRankBackup == null)
/*     */     {
/*     */ 
/*  43 */       return false;
/*     */     }
/*  45 */     SingleCrossFieldSeasonRankBackup xSingleCrossFieldSeasonRankBackup = (SingleCrossFieldSeasonRankBackup)xSingleCrossFieldRankBackup.getBackups().get(Integer.valueOf(this.season));
/*     */     
/*  47 */     if (xSingleCrossFieldSeasonRankBackup == null)
/*     */     {
/*     */ 
/*  50 */       return false;
/*     */     }
/*  52 */     SingleCrossFieldRankAwardInfo xSingleCrossFieldRankAwardInfo = (SingleCrossFieldRankAwardInfo)xSingleCrossFieldSeasonRankBackup.getRank_award_infos().get(Integer.valueOf(this.chartType));
/*     */     
/*  54 */     if (xSingleCrossFieldRankAwardInfo == null)
/*     */     {
/*     */ 
/*  57 */       return false;
/*     */     }
/*  59 */     RoleSingleCrossFieldRankAwardInfo xRoleSingleCrossFieldRankAwardInfo = (RoleSingleCrossFieldRankAwardInfo)xSingleCrossFieldRankAwardInfo.getRole_rank_award_infos().get(Long.valueOf(this.roleid));
/*     */     
/*  61 */     if (xRoleSingleCrossFieldRankAwardInfo == null)
/*     */     {
/*     */ 
/*  64 */       return false;
/*     */     }
/*  66 */     if (xRoleSingleCrossFieldRankAwardInfo.getAwarded())
/*     */     {
/*     */ 
/*  69 */       onFail(10, null);
/*  70 */       return false;
/*     */     }
/*  72 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*     */     
/*  74 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  76 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*  77 */     mzm.gsp.chart.main.RankInterface.sendChartAward(userid, this.roleid, this.chartType, xRoleSingleCrossFieldRankAwardInfo.getRank());
/*  78 */     xRoleSingleCrossFieldRankAwardInfo.setAwarded(true);
/*  79 */     CrossFieldManager.logger.info(String.format("[crossfield]PSendRankAward.processImp@send rank award success|roleid=%d|season=%d|chart_type=%d|rank=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.season), Integer.valueOf(this.chartType), Integer.valueOf(xRoleSingleCrossFieldRankAwardInfo.getRank()) }));
/*     */     
/*     */ 
/*  82 */     CrossFieldTLogManager.addRankAwardTLog(this.roleid, this.season, this.chartType, xRoleSingleCrossFieldRankAwardInfo.getRank());
/*     */     
/*  84 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/*  89 */     StringBuilder sb = new StringBuilder();
/*  90 */     sb.append(String.format("[crossfield]PSendRankAward.processImp@send rank award fail|roleid=%d|season=%d|chart_type=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.season), Integer.valueOf(this.chartType), Integer.valueOf(res) }));
/*     */     
/*     */ 
/*  93 */     if (extraInfo != null)
/*     */     {
/*  95 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/*  97 */         sb.append("|").append((String)entry.getKey());
/*  98 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 101 */     CrossFieldManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\PSendRankAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */