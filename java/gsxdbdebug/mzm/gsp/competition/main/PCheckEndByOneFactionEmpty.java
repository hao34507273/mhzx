/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.competition.confbean.SCompetitionConsts;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import xbean.Competition;
/*    */ import xbean.CompetitionAgainst;
/*    */ import xbean.CompetitionMatch;
/*    */ import xbean.FactionCompetition;
/*    */ import xbean.FactionCompetitionTmp;
/*    */ import xbean.MercenaryFights;
/*    */ import xtable.Faction_competition;
/*    */ import xtable.Faction_competition_tmp;
/*    */ 
/*    */ class PCheckEndByOneFactionEmpty extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long factionid;
/*    */   
/*    */   PCheckEndByOneFactionEmpty(long factionid)
/*    */   {
/* 22 */     this.factionid = factionid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     int stage = ActivityInterface.getActivityStage(SCompetitionConsts.getInstance().Activityid);
/* 29 */     if (stage <= 2) {
/* 30 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 34 */     FactionCompetition xFC = Faction_competition.select(Long.valueOf(this.factionid));
/* 35 */     if (xFC == null) {
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     long winFactionid = xFC.getOpponent();
/*    */     
/* 41 */     long tlogRoleid = -1L;
/*    */     
/*    */ 
/* 44 */     mzm.gsp.gang.main.Gang winFaction = GangInterface.getGang(winFactionid, false);
/* 45 */     mzm.gsp.gang.main.Gang loseFaction = GangInterface.getGang(this.factionid, false);
/*    */     
/* 47 */     if (winFaction != null) {
/* 48 */       tlogRoleid = winFaction.getBangZhuId();
/*    */     }
/* 50 */     else if (loseFaction != null) {
/* 51 */       tlogRoleid = loseFaction.getBangZhuId();
/*    */     }
/*    */     
/*    */ 
/* 55 */     String tlogUserid = mzm.gsp.role.main.RoleInterface.getUserId(tlogRoleid);
/*    */     
/*    */ 
/* 58 */     lock(xtable.Gang.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(this.factionid), Long.valueOf(winFactionid) }));
/*    */     
/*    */ 
/* 61 */     Competition xCompetition = CompetitionManager.getXCompetition(true);
/* 62 */     if (xCompetition == null) {
/* 63 */       return false;
/*    */     }
/*    */     
/* 66 */     CompetitionMatch xCompetitionMatch = CompetitionManager.getXMatch(this.factionid, winFactionid);
/* 67 */     CompetitionAgainst xAgainst = (CompetitionAgainst)xCompetition.getAgainsts().get(xCompetitionMatch);
/* 68 */     if (xAgainst == null) {
/* 69 */       return false;
/*    */     }
/* 71 */     if (xAgainst.getFinished()) {
/* 72 */       return false;
/*    */     }
/*    */     
/* 75 */     FactionCompetition xWinFC = Faction_competition.get(Long.valueOf(winFactionid));
/* 76 */     FactionCompetition xLoseFC = Faction_competition.get(Long.valueOf(this.factionid));
/*    */     
/* 78 */     FactionCompetitionTmp xWinFCTmp = Faction_competition_tmp.get(Long.valueOf(winFactionid));
/* 79 */     long world = xWinFCTmp.getWorld();
/*    */     
/*    */ 
/* 82 */     xbean.CompetitionTmp xCompetitionTmp = CompetitionManager.getXCompetitionTmpIfNotExist();
/* 83 */     MercenaryFights xFights = CompetitionManager.getXMercenaryFights(xCompetitionTmp, winFactionid, this.factionid);
/*    */     
/*    */ 
/* 86 */     return CompetitionManager.onOneFactionLeft(winFactionid, this.factionid, winFaction, loseFaction, xWinFC, xLoseFC, xAgainst, xFights, world, tlogUserid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\PCheckEndByOneFactionEmpty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */