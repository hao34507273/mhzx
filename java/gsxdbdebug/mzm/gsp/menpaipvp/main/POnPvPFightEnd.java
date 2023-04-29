/*     */ package mzm.gsp.menpaipvp.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.fight.event.PVPFightEndArg;
/*     */ import mzm.gsp.menpaipvp.confbean.SMenpaiPVPConsts;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.ELO;
/*     */ import mzm.gsp.util.ELO.MatchResult;
/*     */ import mzm.gsp.util.ELO.RankResult;
/*     */ import xbean.MenpaiPVP;
/*     */ import xbean.MenpaiPVPScore;
/*     */ 
/*     */ public class POnPvPFightEnd extends mzm.gsp.fight.event.PVPFightEndProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  24 */     if ((((PVPFightEndArg)this.arg).context instanceof MenpaiPVPFightContext))
/*     */     {
/*  26 */       long r1 = ((Long)((PVPFightEndArg)this.arg).activeRoleList.get(0)).longValue();
/*  27 */       long r2 = ((Long)((PVPFightEndArg)this.arg).passiveRoleList.get(0)).longValue();
/*     */       
/*  29 */       String u1 = RoleInterface.getUserId(r1);
/*  30 */       String u2 = RoleInterface.getUserId(r2);
/*     */       
/*  32 */       lock(xdb.Lockeys.get(xtable.User.getTable(), Arrays.asList(new String[] { u1, u2 })));
/*     */       
/*  34 */       lock(xtable.Menpaipvpscore.getTable(), Arrays.asList(new Long[] { Long.valueOf(r1), Long.valueOf(r2) }));
/*     */       
/*     */ 
/*  37 */       MenpaiPVP xMenpaiPVP = MenpaiPVPManager.getXMenpaiPVPIfNotExist();
/*     */       
/*  39 */       MenpaiPVPScore xScore1 = MenpaiPVPManager.getXScoreIfNotExist(r1);
/*  40 */       MenpaiPVPScore xScore2 = MenpaiPVPManager.getXScoreIfNotExist(r2);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  45 */       Integer matchTimes1 = (Integer)xScore1.getMatchroles().get(Long.valueOf(r2));
/*  46 */       if (matchTimes1 == null) {
/*  47 */         matchTimes1 = Integer.valueOf(0);
/*     */       }
/*  49 */       matchTimes1 = Integer.valueOf(matchTimes1.intValue() + 1);
/*  50 */       xScore1.getMatchroles().put(Long.valueOf(r2), matchTimes1);
/*     */       
/*  52 */       Integer matchTimes2 = (Integer)xScore2.getMatchroles().get(Long.valueOf(r1));
/*  53 */       if (matchTimes2 == null) {
/*  54 */         matchTimes2 = Integer.valueOf(0);
/*     */       }
/*  56 */       matchTimes2 = Integer.valueOf(matchTimes2.intValue() + 1);
/*  57 */       xScore2.getMatchroles().put(Long.valueOf(r1), matchTimes2);
/*     */       
/*     */       ELO.RankResult rankResult;
/*     */       ELO.RankResult rankResult;
/*  61 */       if (((PVPFightEndArg)this.arg).isActiveWin) {
/*  62 */         MenpaiPVPManager.addWinTimes(xScore1);
/*  63 */         MenpaiPVPManager.addLoseTimes(r2, xScore2);
/*  64 */         rankResult = ELO.getELORankResult(xScore1.getScore(), xScore2.getScore(), MenpaiPVPConfigManager.getInstance().getELO_K(), ELO.MatchResult.Win);
/*     */       }
/*     */       else
/*     */       {
/*  68 */         MenpaiPVPManager.addLoseTimes(r1, xScore1);
/*  69 */         MenpaiPVPManager.addWinTimes(xScore2);
/*  70 */         rankResult = ELO.getELORankResult(xScore1.getScore(), xScore2.getScore(), MenpaiPVPConfigManager.getInstance().getELO_K(), ELO.MatchResult.Lose);
/*     */       }
/*     */       
/*     */ 
/*  74 */       xScore1.setScore(rankResult.getRankA());
/*  75 */       xScore2.setScore(rankResult.getRankB());
/*     */       
/*     */ 
/*     */ 
/*  79 */       MenpaiPVPManager.syncScore(r1, xScore1);
/*  80 */       MenpaiPVPManager.syncScore(r2, xScore2);
/*     */       
/*     */ 
/*  83 */       AwardReason winReason = new AwardReason(LogReason.MENPAI_PVP_WIN_AWARD);
/*  84 */       AwardReason loseReason = new AwardReason(LogReason.MENPAI_PVP_LOSE_AWARD);
/*  85 */       if (((PVPFightEndArg)this.arg).isActiveWin) {
/*  86 */         AwardInterface.award(MenpaiPVPConfigManager.getInstance().getWinAward(), u1, r1, false, true, winReason);
/*  87 */         AwardInterface.award(MenpaiPVPConfigManager.getInstance().getLoseAward(), u2, r2, false, true, loseReason);
/*     */       }
/*     */       else {
/*  90 */         AwardInterface.award(MenpaiPVPConfigManager.getInstance().getWinAward(), u2, r2, false, true, winReason);
/*  91 */         AwardInterface.award(MenpaiPVPConfigManager.getInstance().getLoseAward(), u1, r1, false, true, loseReason);
/*     */       }
/*     */       
/*     */ 
/*  95 */       MenpaiPVPManager.checkGiveFightTimesAward(u1, r1, xScore1);
/*  96 */       MenpaiPVPManager.checkGiveFightTimesAward(u2, r2, xScore2);
/*     */       
/*     */ 
/*  99 */       xMenpaiPVP.getFights().remove(Long.valueOf(((PVPFightEndArg)this.arg).fightid));
/*     */       
/*     */ 
/*     */ 
/* 103 */       ActivityInterface.logActivity(r1, SMenpaiPVPConsts.getInstance().Activityid, ActivityLogStatus.FINISH);
/* 104 */       ActivityInterface.logActivity(r2, SMenpaiPVPConsts.getInstance().Activityid, ActivityLogStatus.FINISH);
/*     */       
/*     */ 
/* 107 */       ActivityInterface.tlogActivity(r1, SMenpaiPVPConsts.getInstance().Activityid, ActivityLogStatus.FINISH);
/* 108 */       ActivityInterface.tlogActivity(r2, SMenpaiPVPConsts.getInstance().Activityid, ActivityLogStatus.FINISH);
/*     */       
/*     */ 
/*     */ 
/* 112 */       MenpaiPVPChart chart = MenpaiPVPManager.getChart(RoleInterface.getOccupationId(r1));
/* 113 */       chart.rank(new MenpaiPVPChartObj(r1, xScore1.getScore(), xScore1.getWin_times()));
/* 114 */       chart.rank(new MenpaiPVPChartObj(r2, xScore2.getScore(), xScore2.getWin_times()));
/*     */     }
/*     */     
/*     */ 
/* 118 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\main\POnPvPFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */