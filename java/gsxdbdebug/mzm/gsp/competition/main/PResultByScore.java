/*     */ package mzm.gsp.competition.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.Competition;
/*     */ import xbean.CompetitionAgainst;
/*     */ import xbean.FactionCompetition;
/*     */ import xbean.FactionCompetitionTmp;
/*     */ import xtable.Faction_competition;
/*     */ import xtable.Faction_competition_tmp;
/*     */ 
/*     */ 
/*     */ 
/*     */ class PResultByScore
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long factionid1;
/*     */   private final long factionid2;
/*     */   
/*     */   PResultByScore(long factionid1, long factionid2)
/*     */   {
/*  29 */     this.factionid1 = factionid1;
/*  30 */     this.factionid2 = factionid2;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  35 */     long tlogRoleid = -1L;
/*     */     
/*     */ 
/*  38 */     mzm.gsp.gang.main.Gang faction1 = GangInterface.getGang(this.factionid1, false);
/*  39 */     mzm.gsp.gang.main.Gang faction2 = GangInterface.getGang(this.factionid2, false);
/*     */     
/*  41 */     if (faction1 != null) {
/*  42 */       tlogRoleid = faction1.getBangZhuId();
/*     */     }
/*  44 */     else if (faction2 != null) {
/*  45 */       tlogRoleid = faction2.getBangZhuId();
/*     */     }
/*     */     
/*     */ 
/*  49 */     String tlogUserid = RoleInterface.getUserId(tlogRoleid);
/*     */     
/*     */ 
/*  52 */     lock(xtable.Gang.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.factionid1), Long.valueOf(this.factionid2) }));
/*     */     
/*     */ 
/*  55 */     Competition xCompetition = CompetitionManager.getXCompetition(true);
/*  56 */     if (xCompetition == null) {
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     CompetitionAgainst xAgainst = CompetitionManager.getXAgainst(xCompetition, this.factionid1, this.factionid2);
/*  61 */     if ((xAgainst == null) || (xAgainst.getFinished())) {
/*  62 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  66 */     FactionCompetitionTmp xFCTmp1 = Faction_competition_tmp.get(Long.valueOf(this.factionid1));
/*  67 */     FactionCompetitionTmp xFCTmp2 = Faction_competition_tmp.get(Long.valueOf(this.factionid2));
/*  68 */     if ((xFCTmp1 == null) || (xFCTmp2 == null)) {
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     if (xFCTmp1.getWorld() != xFCTmp2.getWorld()) {
/*  73 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  77 */     FactionCompetition xFC1 = Faction_competition.get(Long.valueOf(this.factionid1));
/*  78 */     FactionCompetition xFC2 = Faction_competition.get(Long.valueOf(this.factionid2));
/*     */     
/*  80 */     if ((xFC1 == null) || (xFC2 == null)) {
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     Collection<Long> roles = MapInterface.getRoleList(xFCTmp1.getWorld());
/*  85 */     Iterator<Long> iter = roles.iterator();
/*  86 */     List<Long> winnerRoles = new ArrayList();
/*  87 */     List<Long> loserRoles = new ArrayList();
/*  88 */     long winnerFactionid = -1L;
/*  89 */     long loserFactionid = -1L;
/*  90 */     mzm.gsp.gang.main.Gang winnerFaction = null;
/*  91 */     mzm.gsp.gang.main.Gang loserFaction = null;
/*  92 */     FactionCompetition xWinnerFC = null;
/*  93 */     FactionCompetition xLoserFC = null;
/*  94 */     long winnerDisplayid = -1L;
/*  95 */     long loserDisplayid = -1L;
/*     */     
/*  97 */     if (CompetitionManager.isFrontWin(this.factionid1, xFC1, this.factionid2, xFC2)) {
/*  98 */       winnerFactionid = this.factionid1;
/*  99 */       loserFactionid = this.factionid2;
/* 100 */       winnerFaction = faction1;
/* 101 */       loserFaction = faction2;
/* 102 */       xWinnerFC = xFC1;
/* 103 */       xLoserFC = xFC2;
/* 104 */       if (winnerFaction != null) {
/* 105 */         winnerDisplayid = winnerFaction.getDisplayid();
/*     */       }
/*     */     }
/*     */     else {
/* 109 */       winnerFactionid = this.factionid2;
/* 110 */       loserFactionid = this.factionid1;
/* 111 */       winnerFaction = faction2;
/* 112 */       loserFaction = faction1;
/* 113 */       xWinnerFC = xFC2;
/* 114 */       xLoserFC = xFC1;
/* 115 */       if (loserFaction != null) {
/* 116 */         loserDisplayid = loserFaction.getDisplayid();
/*     */       }
/*     */     }
/*     */     
/* 120 */     if (winnerFaction == null) {
/* 121 */       return false;
/*     */     }
/*     */     
/* 124 */     while (iter.hasNext()) {
/* 125 */       long r = ((Long)iter.next()).longValue();
/*     */       
/* 127 */       if (winnerFaction.isInGang(r)) {
/* 128 */         winnerRoles.add(Long.valueOf(r));
/*     */       }
/*     */       else {
/* 131 */         loserRoles.add(Long.valueOf(r));
/*     */       }
/* 133 */       iter.remove();
/*     */     }
/*     */     
/*     */ 
/* 137 */     xCompetition = CompetitionManager.getXCompetition(true);
/* 138 */     if ((xAgainst == null) || (xAgainst.getFinished())) {
/* 139 */       return false;
/*     */     }
/*     */     
/* 142 */     xAgainst.setFinished(true);
/*     */     
/*     */ 
/* 145 */     for (Iterator i$ = loserRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*     */       
/* 147 */       CompetitionManager.leaveNoneRealTime(r, loserFactionid);
/*     */     }
/*     */     
/*     */ 
/* 151 */     CompetitionManager.asyncTriggerMapItems(xFCTmp1.getWorld(), winnerRoles.size(), winnerFactionid, winnerFaction.getDisplayid());
/*     */     
/*     */ 
/*     */ 
/* 155 */     CompetitionManager.addWinTimes(xWinnerFC);
/* 156 */     CompetitionManager.addLoseTimes(xLoserFC);
/*     */     
/*     */ 
/* 159 */     CompetitionManager.asyncSettleFaction(winnerFactionid, true);
/* 160 */     CompetitionManager.asyncSettleFaction(loserFactionid, false);
/*     */     
/*     */ 
/* 163 */     if (winnerFactionid < loserFactionid) {
/* 164 */       CompetitionManager.tlogResult(winnerFactionid, loserFactionid, xWinnerFC, xLoserFC, 4, tlogUserid, winnerDisplayid, loserDisplayid);
/*     */       
/* 166 */       CompetitionManager.triggerResultEvent(winnerFactionid, xWinnerFC, loserFactionid, xLoserFC, 4);
/*     */     }
/*     */     else
/*     */     {
/* 170 */       CompetitionManager.tlogResult(loserFactionid, winnerFactionid, xLoserFC, xWinnerFC, 5, tlogUserid, winnerDisplayid, loserDisplayid);
/*     */       
/* 172 */       CompetitionManager.triggerResultEvent(loserFactionid, xLoserFC, winnerFactionid, xWinnerFC, 5);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 177 */     CompetitionManager.broadcastWinLose(winnerFactionid, loserFactionid, winnerFaction, loserFaction, 3);
/*     */     
/* 179 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\PResultByScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */