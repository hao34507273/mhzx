/*    */ package mzm.gsp.crosscompete.roam;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.crosscompete.SSyncFactionPlayerScoreBrd;
/*    */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RoamCrossCompeteFaction;
/*    */ import xbean.RoamCrossCompeteFactionTmp;
/*    */ import xtable.Roam_crosscompete_faction;
/*    */ 
/*    */ class PAddPlayerScore
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long factionid1;
/*    */   private final long factionid2;
/*    */   
/*    */   PAddPlayerScore(long factionid1, long factionid2)
/*    */   {
/* 23 */     this.factionid1 = factionid1;
/* 24 */     this.factionid2 = factionid2;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     lock(Roam_crosscompete_faction.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.factionid1), Long.valueOf(this.factionid2) }));
/*    */     
/*    */ 
/* 33 */     RoamCrossCompeteFactionTmp xRoamFactionTmp1 = CrossCompeteRoamManager.getXRoamCrossCompeteFactionTmp(this.factionid1, true);
/*    */     
/* 35 */     RoamCrossCompeteFactionTmp xRoamFactionTmp2 = CrossCompeteRoamManager.getXRoamCrossCompeteFactionTmp(this.factionid2, true);
/*    */     
/*    */ 
/* 38 */     int playerNum1 = 0;
/* 39 */     int playerNum2 = 0;
/*    */     
/* 41 */     List<Long> roles = new ArrayList();
/* 42 */     if (xRoamFactionTmp1 != null) {
/* 43 */       playerNum1 = xRoamFactionTmp1.getRoles().size();
/* 44 */       roles.addAll(xRoamFactionTmp1.getRoles());
/*    */     }
/* 46 */     if (xRoamFactionTmp2 != null) {
/* 47 */       playerNum2 = xRoamFactionTmp2.getRoles().size();
/* 48 */       roles.addAll(xRoamFactionTmp2.getRoles());
/*    */     }
/*    */     
/* 51 */     RoamCrossCompeteFaction xRoamFaction1 = CrossCompeteRoamManager.createRoamCrossCompeteFactionIfNotExist(this.factionid1);
/*    */     
/* 53 */     RoamCrossCompeteFaction xRoamFaction2 = CrossCompeteRoamManager.createRoamCrossCompeteFactionIfNotExist(this.factionid2);
/*    */     
/*    */ 
/* 56 */     int addScore1 = SCrossCompeteConsts.getInstance().PlayerScoreA * playerNum1;
/* 57 */     int addScore2 = SCrossCompeteConsts.getInstance().PlayerScoreA * playerNum2;
/*    */     
/* 59 */     xRoamFaction1.setPlayer_score(xRoamFaction1.getPlayer_score() + addScore1);
/* 60 */     xRoamFaction2.setPlayer_score(xRoamFaction2.getPlayer_score() + addScore2);
/*    */     
/*    */ 
/* 63 */     SSyncFactionPlayerScoreBrd brd = new SSyncFactionPlayerScoreBrd();
/* 64 */     brd.factionid1 = this.factionid1;
/* 65 */     brd.player_score1 = xRoamFaction1.getPlayer_score();
/* 66 */     brd.factionid2 = this.factionid2;
/* 67 */     brd.player_score2 = xRoamFaction2.getPlayer_score();
/*    */     
/* 69 */     OnlineManager.getInstance().sendMulti(brd, roles);
/*    */     
/* 71 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\PAddPlayerScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */