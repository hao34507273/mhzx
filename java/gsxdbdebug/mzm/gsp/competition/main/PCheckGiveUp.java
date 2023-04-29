/*     */ package mzm.gsp.competition.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Competition;
/*     */ import xbean.CompetitionAgainst;
/*     */ import xbean.FactionCompetition;
/*     */ import xbean.FactionCompetitionTmp;
/*     */ import xtable.Faction_competition;
/*     */ import xtable.Faction_competition_tmp;
/*     */ 
/*     */ class PCheckGiveUp extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long factionid1;
/*     */   private final long factionid2;
/*     */   
/*     */   PCheckGiveUp(long faction1, long faction2)
/*     */   {
/*  23 */     this.factionid1 = faction1;
/*  24 */     this.factionid2 = faction2;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  29 */     long tlogRoleid = -1L;
/*     */     
/*     */ 
/*  32 */     mzm.gsp.gang.main.Gang faction1 = GangInterface.getGang(this.factionid1, false);
/*  33 */     mzm.gsp.gang.main.Gang faction2 = GangInterface.getGang(this.factionid2, false);
/*     */     
/*  35 */     if (faction1 != null) {
/*  36 */       tlogRoleid = faction1.getBangZhuId();
/*     */     }
/*  38 */     else if (faction2 != null) {
/*  39 */       tlogRoleid = faction2.getBangZhuId();
/*     */     }
/*     */     
/*     */ 
/*  43 */     String tlogUserid = mzm.gsp.role.main.RoleInterface.getUserId(tlogRoleid);
/*     */     
/*     */ 
/*  46 */     lock(xtable.Gang.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(this.factionid1), Long.valueOf(this.factionid2) }));
/*     */     
/*     */ 
/*  49 */     Competition xCompetition = CompetitionManager.getXCompetition(true);
/*  50 */     if (xCompetition == null) {
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     xbean.CompetitionMatch xCompetitionMatch = CompetitionManager.getXMatch(this.factionid1, this.factionid2);
/*  55 */     CompetitionAgainst xAgainst = (CompetitionAgainst)xCompetition.getAgainsts().get(xCompetitionMatch);
/*  56 */     if (xAgainst == null) {
/*  57 */       return false;
/*     */     }
/*  59 */     if (xAgainst.getFinished()) {
/*  60 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  64 */     FactionCompetitionTmp xFCTmp1 = Faction_competition_tmp.get(Long.valueOf(this.factionid1));
/*  65 */     FactionCompetitionTmp xFCTmp2 = Faction_competition_tmp.get(Long.valueOf(this.factionid2));
/*  66 */     if ((xFCTmp1 == null) || (xFCTmp2 == null)) {
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     if (xFCTmp1.getWorld() != xFCTmp2.getWorld()) {
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     List<Long> giveUpFactions = new ArrayList(2);
/*     */     
/*     */ 
/*  77 */     FactionCompetition xFC1 = Faction_competition.get(Long.valueOf(this.factionid1));
/*  78 */     FactionCompetition xFC2 = Faction_competition.get(Long.valueOf(this.factionid2));
/*     */     
/*  80 */     if ((xFC1 == null) || (!xFC1.getParticipated())) {
/*  81 */       giveUpFactions.add(Long.valueOf(this.factionid1));
/*     */     }
/*  83 */     if ((xFC2 == null) || (!xFC2.getParticipated())) {
/*  84 */       giveUpFactions.add(Long.valueOf(this.factionid2));
/*     */     }
/*     */     
/*  87 */     if (!giveUpFactions.isEmpty()) { Iterator i$;
/*  88 */       if (CompetitionManager.logger.isDebugEnabled()) {
/*  89 */         for (i$ = giveUpFactions.iterator(); i$.hasNext();) { long f = ((Long)i$.next()).longValue();
/*  90 */           CompetitionManager.logger.debug("[帮派竞赛]帮派" + f + "弃权！");
/*     */         }
/*     */       }
/*     */       
/*  94 */       if (giveUpFactions.size() > 1) {
/*  95 */         return CompetitionManager.onBothGiveUp(this.factionid1, this.factionid2, faction1, faction2, xFC1, xFC2, xAgainst, xFCTmp1.getWorld(), tlogUserid);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 100 */       long giveUpFactionid = ((Long)giveUpFactions.get(0)).longValue();
/* 101 */       long winFactionid = -1L;
/* 102 */       mzm.gsp.gang.main.Gang winFaction = null;
/* 103 */       mzm.gsp.gang.main.Gang giveUpFaction = null;
/* 104 */       FactionCompetition xWinFC = null;
/* 105 */       FactionCompetition xGiveUpFC = null;
/* 106 */       if (giveUpFactionid == this.factionid1) {
/* 107 */         winFactionid = this.factionid2;
/* 108 */         winFaction = faction2;
/* 109 */         giveUpFaction = faction1;
/* 110 */         xWinFC = xFC2;
/* 111 */         xGiveUpFC = xFC1;
/*     */       }
/*     */       else {
/* 114 */         winFactionid = this.factionid1;
/* 115 */         winFaction = faction1;
/* 116 */         giveUpFaction = faction2;
/* 117 */         xWinFC = xFC1;
/* 118 */         xGiveUpFC = xFC2;
/*     */       }
/*     */       
/* 121 */       return CompetitionManager.onOneFactionGiveUp(winFactionid, giveUpFactionid, winFaction, giveUpFaction, xWinFC, xGiveUpFC, xAgainst, xFCTmp1.getWorld(), tlogUserid);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 126 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\PCheckGiveUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */