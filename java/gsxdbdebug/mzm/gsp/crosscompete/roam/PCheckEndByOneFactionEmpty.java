/*    */ package mzm.gsp.crosscompete.roam;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*    */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*    */ import xbean.CrossCompete;
/*    */ import xbean.CrossCompeteAgainst;
/*    */ import xbean.RoamCrossCompeteFaction;
/*    */ import xbean.RoamCrossCompeteFactionTmp;
/*    */ import xtable.Gang;
/*    */ import xtable.Roam_crosscompete_faction;
/*    */ 
/*    */ class PCheckEndByOneFactionEmpty extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long factionid;
/*    */   
/*    */   PCheckEndByOneFactionEmpty(long factionid)
/*    */   {
/* 20 */     this.factionid = factionid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     int stage = ActivityInterface.getActivityStage(SCrossCompeteConsts.getInstance().Activityid);
/* 27 */     if (!CrossCompeteManager.isFightStage(stage)) {
/* 28 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 32 */     RoamCrossCompeteFaction xRoamFaction = CrossCompeteRoamManager.getXRoamCrossCompeteFaction(this.factionid, false);
/*    */     
/* 34 */     if (xRoamFaction == null) {
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     long winFactionid = xRoamFaction.getOpponent();
/*    */     
/*    */ 
/* 41 */     lock(Gang.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.factionid), Long.valueOf(winFactionid) }));
/*    */     
/*    */ 
/* 44 */     CrossCompete xCompete = CrossCompeteManager.getXCrossCompete(true);
/* 45 */     if (xCompete == null) {
/* 46 */       return false;
/*    */     }
/*    */     
/* 49 */     CrossCompeteAgainst xAgainst = CrossCompeteManager.getXAgainst(xCompete, this.factionid, winFactionid);
/*    */     
/* 51 */     if (xAgainst == null) {
/* 52 */       return false;
/*    */     }
/* 54 */     if (xAgainst.getWinner() > 0L) {
/* 55 */       return false;
/*    */     }
/*    */     
/* 58 */     RoamCrossCompeteFaction xWinFaction = Roam_crosscompete_faction.get(Long.valueOf(winFactionid));
/* 59 */     RoamCrossCompeteFaction xLoseFaction = Roam_crosscompete_faction.get(Long.valueOf(this.factionid));
/*    */     
/* 61 */     RoamCrossCompeteFactionTmp xWinFactionTmp = CrossCompeteRoamManager.getXRoamCrossCompeteFactionTmp(winFactionid, true);
/*    */     
/* 63 */     RoamCrossCompeteFactionTmp xLoseFactionTmp = CrossCompeteRoamManager.getXRoamCrossCompeteFactionTmp(this.factionid, true);
/*    */     
/* 65 */     long world = xWinFactionTmp.getWorld();
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 72 */     return CrossCompeteRoamManager.onOneFactionLeft(winFactionid, this.factionid, xWinFaction, xLoseFaction, xWinFactionTmp, xLoseFactionTmp, xAgainst, world);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\PCheckEndByOneFactionEmpty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */