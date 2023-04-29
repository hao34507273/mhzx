/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.competition.confbean.SCompetitionConsts;
/*    */ import mzm.gsp.util.ELO;
/*    */ import mzm.gsp.util.ELO.MatchResult;
/*    */ import mzm.gsp.util.ELO.RankResult;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.FactionCompetition;
/*    */ import xtable.Faction_competition;
/*    */ 
/*    */ 
/*    */ 
/*    */ class PCalculateELORank
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long winFaction;
/*    */   private final long loseFaction;
/*    */   
/*    */   PCalculateELORank(long winFaction, long loseFaction)
/*    */   {
/* 22 */     this.winFaction = winFaction;
/* 23 */     this.loseFaction = loseFaction;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     lock(Faction_competition.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.winFaction), Long.valueOf(this.loseFaction) }));
/*    */     
/* 31 */     FactionCompetition xFC1 = CompetitionManager.getXFactionCompetitionIfNotExist(this.winFaction);
/* 32 */     FactionCompetition xFC2 = CompetitionManager.getXFactionCompetitionIfNotExist(this.loseFaction);
/*    */     
/* 34 */     ELO.RankResult rankResult = ELO.getELORankResult(xFC1.getElo_rank(), xFC2.getElo_rank(), SCompetitionConsts.getInstance().ELO_K, ELO.MatchResult.Win);
/*    */     
/*    */ 
/* 37 */     xFC1.setElo_rank(rankResult.getRankA());
/* 38 */     xFC2.setElo_rank(rankResult.getRankB());
/*    */     
/* 40 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\PCalculateELORank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */