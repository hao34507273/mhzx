/*     */ package mzm.gsp.competition.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.competition.confbean.SCompetitionConsts;
/*     */ import mzm.gsp.competition.confbean.SCompetitionMercenaryConsts;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import xbean.Competition;
/*     */ import xbean.CompetitionAgainst;
/*     */ import xbean.CompetitionMatch;
/*     */ import xbean.FactionCompetitionTmp;
/*     */ import xtable.Faction_competition_tmp;
/*     */ 
/*     */ class RUpdateMercenary extends LogicRunnable
/*     */ {
/*     */   private final MercenaryObserver observer;
/*     */   
/*     */   RUpdateMercenary(MercenaryObserver observer)
/*     */   {
/*  29 */     this.observer = observer;
/*     */   }
/*     */   
/*     */   RUpdateMercenary() {
/*  33 */     this(null);
/*     */   }
/*     */   
/*     */   public void process()
/*     */     throws Exception
/*     */   {
/*  39 */     int stage = ActivityInterface.getActivityStage(SCompetitionConsts.getInstance().Activityid);
/*  40 */     if ((stage < 1) || (stage >= 4))
/*     */     {
/*  42 */       if (this.observer != null) {
/*  43 */         this.observer.stopTimer();
/*     */       }
/*  45 */       return;
/*     */     }
/*     */     
/*     */ 
/*  49 */     if (!OpenInterface.getOpenStatus(219))
/*     */     {
/*  51 */       return;
/*     */     }
/*     */     
/*     */ 
/*  55 */     Competition xCompetition = CompetitionManager.getXCompetition(false);
/*     */     
/*  57 */     if (xCompetition == null) {
/*  58 */       return;
/*     */     }
/*     */     
/*  61 */     Iterator<Map.Entry<CompetitionMatch, CompetitionAgainst>> iter = xCompetition.getAgainsts().entrySet().iterator();
/*     */     
/*     */ 
/*  64 */     while (iter.hasNext()) {
/*  65 */       Map.Entry<CompetitionMatch, CompetitionAgainst> entry = (Map.Entry)iter.next();
/*  66 */       CompetitionMatch cMatch = (CompetitionMatch)entry.getKey();
/*  67 */       CompetitionAgainst xAgainst = (CompetitionAgainst)entry.getValue();
/*     */       
/*  69 */       if (!xAgainst.getFinished())
/*     */       {
/*     */ 
/*     */ 
/*  73 */         new PRecallMercenary(cMatch).call();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static class PRecallMercenary extends LogicProcedure
/*     */   {
/*     */     private final CompetitionMatch cMatch;
/*     */     
/*     */     public PRecallMercenary(CompetitionMatch cMatch) {
/*  83 */       this.cMatch = cMatch;
/*     */     }
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  88 */       long tlogRoleid = -1L;
/*     */       
/*  90 */       long factionid1 = this.cMatch.getFrontfaction();
/*  91 */       long factionid2 = this.cMatch.getBehindfaction();
/*     */       
/*     */ 
/*  94 */       mzm.gsp.gang.main.Gang faction1 = GangInterface.getGang(factionid1, false);
/*  95 */       mzm.gsp.gang.main.Gang faction2 = GangInterface.getGang(factionid2, false);
/*     */       
/*  97 */       long factionDisplayid1 = -1L;
/*  98 */       long factionDisplayid2 = -1L;
/*     */       
/* 100 */       if (faction1 != null) {
/* 101 */         tlogRoleid = faction1.getBangZhuId();
/* 102 */         factionDisplayid1 = faction1.getDisplayid();
/*     */       }
/* 104 */       else if (faction2 != null) {
/* 105 */         tlogRoleid = faction2.getBangZhuId();
/* 106 */         factionDisplayid2 = faction2.getDisplayid();
/*     */       }
/*     */       
/*     */ 
/* 110 */       String tlogUserid = RoleInterface.getUserId(tlogRoleid);
/*     */       
/*     */ 
/* 113 */       lock(xtable.Gang.getTable(), Arrays.asList(new Long[] { Long.valueOf(factionid1), Long.valueOf(factionid2) }));
/*     */       
/* 115 */       FactionCompetitionTmp xFCTmp1 = Faction_competition_tmp.get(Long.valueOf(factionid1));
/* 116 */       FactionCompetitionTmp xFCTmp2 = Faction_competition_tmp.get(Long.valueOf(factionid2));
/*     */       
/* 118 */       if ((xFCTmp1 == null) || (xFCTmp2 == null)) {
/* 119 */         return false;
/*     */       }
/*     */       
/* 122 */       long world = xFCTmp1.getWorld();
/*     */       
/*     */ 
/* 125 */       ControllerInterface.collectWorldController(world, SCompetitionMercenaryConsts.getInstance().MercenaryController);
/*     */       
/*     */ 
/*     */ 
/* 129 */       Competition xCompetition = CompetitionManager.getXCompetition(true);
/* 130 */       CompetitionAgainst xAgainst = (CompetitionAgainst)xCompetition.getAgainsts().get(this.cMatch);
/* 131 */       if (xAgainst == null) {
/* 132 */         return false;
/*     */       }
/*     */       
/* 135 */       CompetitionManager.checkRecallMercenary(xAgainst, xFCTmp1, xFCTmp2, factionid1, factionDisplayid1, factionid2, factionDisplayid2, tlogUserid);
/*     */       
/*     */ 
/* 138 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\RUpdateMercenary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */