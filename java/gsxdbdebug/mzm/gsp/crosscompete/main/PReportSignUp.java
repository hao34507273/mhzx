/*     */ package mzm.gsp.crosscompete.main;
/*     */ 
/*     */ import hub.CrossCompeteSignUpFaction;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.competition.main.CompetitionInterface;
/*     */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.gang.main.Gang;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.CrossCompete;
/*     */ import xbean.CrossCompeteSignUp;
/*     */ import xbean.FactionCrossCompete;
/*     */ 
/*     */ 
/*     */ class PReportSignUp
/*     */   extends LogicProcedure
/*     */ {
/*     */   private ReportSignUpObeserver observer;
/*     */   
/*     */   PReportSignUp(ReportSignUpObeserver observer)
/*     */   {
/*  28 */     this.observer = observer;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     int stage = ActivityInterface.getActivityStage(SCrossCompeteConsts.getInstance().Activityid);
/*     */     
/*  36 */     boolean bForce = false;
/*  37 */     if (stage != 1) {
/*  38 */       bForce = true;
/*     */     }
/*     */     
/*     */ 
/*  42 */     CrossCompete xCompete = CrossCompeteManager.getXCrossCompete(false);
/*  43 */     if (!CrossCompeteManager.needReportSignUp(xCompete)) {
/*  44 */       if (this.observer != null) {
/*  45 */         this.observer.stopTimer();
/*     */       }
/*  47 */       CrossCompeteManager.logInfo("PReportSignUp.processImp@no need to report sign up, remove timer|stage=%d", new Object[] { Integer.valueOf(stage) });
/*     */       
/*     */ 
/*  50 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  54 */     long startTime = ActivityInterface.getActivityStartTime(SCrossCompeteConsts.getInstance().Activityid);
/*     */     
/*     */ 
/*  57 */     List<CrossCompeteSignUpFaction> factionBeanList = new ArrayList();
/*     */     
/*     */ 
/*  60 */     for (Map.Entry<Long, CrossCompeteSignUp> entry : xCompete.getSignup_factions().entrySet()) {
/*  61 */       long factionid = ((Long)entry.getKey()).longValue();
/*  62 */       CrossCompeteSignUp xSignUp = (CrossCompeteSignUp)entry.getValue();
/*     */       
/*  64 */       if (xSignUp.getTime() >= startTime)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  69 */         Gang faction = GangInterface.getGang(factionid, false);
/*  70 */         if (faction != null)
/*     */         {
/*     */ 
/*  73 */           int activeNumber = CompetitionInterface.getFactionActiveNumber(factionid);
/*     */           
/*  75 */           FactionCrossCompete xFactionCompete = CrossCompeteManager.getXFactionCrossCompete(factionid, false);
/*  76 */           int winTimes = 0;
/*  77 */           int loseTimes = 0;
/*  78 */           if (xFactionCompete != null) {
/*  79 */             winTimes = xFactionCompete.getWin_times();
/*  80 */             loseTimes = xFactionCompete.getLose_times();
/*     */           }
/*     */           
/*  83 */           CrossCompeteSignUpFaction factionBean = new CrossCompeteSignUpFaction();
/*  84 */           factionBean.factionid = factionid;
/*  85 */           factionBean.faction_name = faction.getName();
/*  86 */           if (xFactionCompete != null) {
/*  87 */             factionBean.faction2matchtimes.putAll(xFactionCompete.getFactionid2matchtimes());
/*  88 */             factionBean.miss_turn_times = xFactionCompete.getMiss_turn_times();
/*     */           }
/*  90 */           factionBean.faction_level = faction.getLevel();
/*  91 */           factionBean.member_count = faction.getMemberSize();
/*     */           
/*  93 */           int participateCount = CompetitionInterface.getMaxFactionParticipateCount(factionid);
/*     */           
/*  95 */           factionBean.particapte_count = CrossCompeteManager.getEstimateParticipateCount(participateCount, activeNumber);
/*     */           
/*  97 */           factionBean.activeness = CompetitionInterface.getActiveness(factionBean.particapte_count, winTimes, loseTimes);
/*     */           
/*     */ 
/* 100 */           factionBeanList.add(factionBean);
/*     */         }
/*     */       } }
/* 103 */     if (factionBeanList.isEmpty()) {
/* 104 */       CrossCompeteManager.logError("PReportSignUp.processImp@faction bean list empty|start_time=%d", new Object[] { Long.valueOf(startTime) });
/*     */       
/*     */ 
/* 107 */       return false;
/*     */     }
/*     */     
/* 110 */     boolean ret = CrossServerInterface.reportCrossCompeteSignUp(startTime, factionBeanList, bForce);
/* 111 */     if (!ret) {
/* 112 */       CrossCompeteManager.logError("PReportSignUp.processImp@report sign up err|start_time=%d", new Object[] { Long.valueOf(startTime) });
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 117 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\PReportSignUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */