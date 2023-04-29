/*     */ package mzm.gsp.competition.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.competition.confbean.SCompetitionConsts;
/*     */ import mzm.gsp.competition.confbean.SCompetitionMercenaryConsts;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.Competition;
/*     */ import xbean.CompetitionAgainst;
/*     */ import xbean.CompetitionMatch;
/*     */ import xbean.FactionCompetition;
/*     */ import xbean.FactionCompetitionTmp;
/*     */ import xtable.Faction_competition;
/*     */ import xtable.Faction_competition_tmp;
/*     */ 
/*     */ class MercenaryScoreObserver extends Observer
/*     */ {
/*     */   MercenaryScoreObserver()
/*     */   {
/*  23 */     super(SCompetitionMercenaryConsts.getInstance().MercenaryIntervalSeconds);
/*     */   }
/*     */   
/*     */   public boolean update()
/*     */   {
/*  28 */     NoneRealTimeTaskManager.getInstance().addTask(new RUpdateMercenaryScore(this));
/*     */     
/*  30 */     return true;
/*     */   }
/*     */   
/*     */   static class RUpdateMercenaryScore extends mzm.gsp.util.LogicRunnable
/*     */   {
/*     */     private final MercenaryScoreObserver observer;
/*     */     
/*     */     RUpdateMercenaryScore(MercenaryScoreObserver observer) {
/*  38 */       this.observer = observer;
/*     */     }
/*     */     
/*     */     public void process() throws Exception
/*     */     {
/*  43 */       int stage = ActivityInterface.getActivityStage(SCompetitionConsts.getInstance().Activityid);
/*  44 */       if ((stage < 1) || (stage >= 4))
/*     */       {
/*  46 */         this.observer.stopTimer();
/*  47 */         return;
/*     */       }
/*     */       
/*     */ 
/*  51 */       Competition xCompetition = CompetitionManager.getXCompetition(false);
/*  52 */       if (xCompetition == null) {
/*  53 */         return;
/*     */       }
/*     */       
/*     */ 
/*  57 */       for (Map.Entry<CompetitionMatch, CompetitionAgainst> entry : xCompetition.getAgainsts().entrySet()) {
/*  58 */         CompetitionMatch cMatch = (CompetitionMatch)entry.getKey();
/*  59 */         CompetitionAgainst xAgainst = (CompetitionAgainst)entry.getValue();
/*     */         
/*     */ 
/*  62 */         if ((!xAgainst.getFinished()) && (xAgainst.getMercenary_faction() > 0L))
/*     */         {
/*     */ 
/*     */ 
/*  66 */           new MercenaryScoreObserver.PAddMercenaryScore(cMatch, xAgainst.getMercenary_faction()).call();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static class PAddMercenaryScore
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private CompetitionMatch cMatch;
/*     */     private final long mercenaryFactionid;
/*     */     
/*     */     PAddMercenaryScore(CompetitionMatch cMatch, long mercenaryFactionid)
/*     */     {
/*  80 */       this.cMatch = cMatch;
/*  81 */       this.mercenaryFactionid = mercenaryFactionid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  87 */       FactionCompetition xFC = Faction_competition.get(Long.valueOf(this.mercenaryFactionid));
/*  88 */       if (xFC == null) {
/*  89 */         return false;
/*     */       }
/*     */       
/*  92 */       FactionCompetitionTmp xFCTmp = Faction_competition_tmp.get(Long.valueOf(this.mercenaryFactionid));
/*  93 */       if (xFCTmp == null) {
/*  94 */         return false;
/*     */       }
/*     */       
/*     */ 
/*  98 */       Competition xCompetition = CompetitionManager.getXCompetition(true);
/*  99 */       if (xCompetition == null) {
/* 100 */         return false;
/*     */       }
/*     */       
/* 103 */       CompetitionAgainst xAgainst = (CompetitionAgainst)xCompetition.getAgainsts().get(this.cMatch);
/* 104 */       if (xAgainst == null) {
/* 105 */         return false;
/*     */       }
/*     */       
/* 108 */       long world = xFCTmp.getWorld();
/* 109 */       int mercenaryCount = MapInterface.getMonsterNumInWorld(xFCTmp.getWorld());
/* 110 */       if (mercenaryCount <= 0) {
/* 111 */         return false;
/*     */       }
/*     */       
/* 114 */       int addScore = mercenaryCount * SCompetitionMercenaryConsts.getInstance().MercenaryScore;
/*     */       
/* 116 */       if (addScore > 0) {
/* 117 */         int score = xFC.getMercenary_score() + addScore;
/* 118 */         xFC.setMercenary_score(score);
/*     */         
/*     */ 
/* 121 */         CompetitionManager.broadcastMercenaryScore(this.mercenaryFactionid, score, world);
/*     */         
/*     */ 
/* 124 */         CompetitionManager.logInfo("PAddMercenaryScore.processImp@add mercenary score|factionid=%d|mercenary_count=%d|add_score=%d", new Object[] { Long.valueOf(this.mercenaryFactionid), Integer.valueOf(mercenaryCount), Integer.valueOf(addScore) });
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 129 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\MercenaryScoreObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */