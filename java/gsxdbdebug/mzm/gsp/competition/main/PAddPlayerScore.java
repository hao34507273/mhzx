/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.competition.SSyncFactionPlayerScoreBrd;
/*    */ import mzm.gsp.competition.confbean.SCompetitionConsts;
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.FactionCompetition;
/*    */ import xbean.FactionCompetitionTmp;
/*    */ import xtable.Faction_competition;
/*    */ import xtable.Faction_competition_tmp;
/*    */ 
/*    */ class PAddPlayerScore extends LogicProcedure
/*    */ {
/*    */   private final long factionid1;
/*    */   private final long factionid2;
/*    */   
/*    */   PAddPlayerScore(long factionid1, long factionid2)
/*    */   {
/* 25 */     this.factionid1 = factionid1;
/* 26 */     this.factionid2 = factionid2;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     lock(Faction_competition.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.factionid1), Long.valueOf(this.factionid2) }));
/*    */     
/* 34 */     FactionCompetitionTmp xFCTmp = Faction_competition_tmp.select(Long.valueOf(this.factionid1));
/* 35 */     if (xFCTmp == null) {
/* 36 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 40 */     Gang faction1 = GangInterface.getGang(this.factionid1, true);
/* 41 */     Gang faction2 = GangInterface.getGang(this.factionid2, true);
/* 42 */     List<Long> roles = MapInterface.getRoleList(xFCTmp.getWorld());
/*    */     
/* 44 */     int playerNum1 = 0;
/* 45 */     int playerNum2 = 0;
/*    */     
/* 47 */     for (Iterator i$ = roles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 48 */       if ((faction1 != null) && (faction1.isInGang(r))) {
/* 49 */         playerNum1++;
/*    */       }
/* 51 */       else if ((faction2 != null) && (faction2.isInGang(r))) {
/* 52 */         playerNum2++;
/*    */       }
/*    */     }
/*    */     
/* 56 */     FactionCompetition xFC1 = CompetitionManager.getXFactionCompetitionIfNotExist(this.factionid1);
/* 57 */     FactionCompetition xFC2 = CompetitionManager.getXFactionCompetitionIfNotExist(this.factionid2);
/*    */     
/* 59 */     int addScore1 = SCompetitionConsts.getInstance().PlayerScoreA * playerNum1;
/* 60 */     int addScore2 = SCompetitionConsts.getInstance().PlayerScoreA * playerNum2;
/*    */     
/* 62 */     xFC1.setPlayer_score(xFC1.getPlayer_score() + addScore1);
/* 63 */     xFC2.setPlayer_score(xFC2.getPlayer_score() + addScore2);
/*    */     
/*    */ 
/* 66 */     SSyncFactionPlayerScoreBrd brd = new SSyncFactionPlayerScoreBrd();
/* 67 */     brd.factionid1 = this.factionid1;
/* 68 */     brd.player_score1 = xFC1.getPlayer_score();
/* 69 */     brd.factionid2 = this.factionid2;
/* 70 */     brd.player_score2 = xFC2.getPlayer_score();
/*    */     
/* 72 */     OnlineManager.getInstance().sendMulti(brd, roles);
/*    */     
/* 74 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\PAddPlayerScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */