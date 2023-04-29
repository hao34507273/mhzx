/*     */ package mzm.gsp.crosscompete.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import xbean.CrossCompete;
/*     */ import xbean.CrossCompeteSignUp;
/*     */ import xbean.FactionCrossCompete;
/*     */ 
/*     */ class RInit
/*     */   extends LogicRunnable
/*     */ {
/*     */   public void process()
/*     */     throws Exception
/*     */   {
/*  22 */     PInitGlobal pGlobal = new PInitGlobal();
/*  23 */     if (!pGlobal.call()) {
/*  24 */       CrossCompeteManager.logError("RInit.process@init global failed", new Object[0]);
/*     */     }
/*     */     
/*  27 */     boolean needClearMatchTimes = pGlobal.needClearMatchTimesAndMissTurnTimes;
/*     */     
/*  29 */     Set<Long> factions = GangInterface.getAllGangIdSet();
/*  30 */     for (Iterator i$ = factions.iterator(); i$.hasNext();) { long factionid = ((Long)i$.next()).longValue();
/*  31 */       new PInitFactionCrossCompete(factionid, needClearMatchTimes).call();
/*     */     }
/*     */   }
/*     */   
/*     */   static class PInitGlobal extends LogicProcedure
/*     */   {
/*  37 */     boolean needClearMatchTimesAndMissTurnTimes = false;
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  42 */       CrossCompete xCrossCompete = CrossCompeteManager.getXCrossCompete(true);
/*  43 */       if (xCrossCompete == null) {
/*  44 */         return false;
/*     */       }
/*     */       
/*     */ 
/*  48 */       long startTime = ActivityInterface.getActivityStartTime(SCrossCompeteConsts.getInstance().Activityid);
/*     */       
/*     */ 
/*  51 */       Iterator<Map.Entry<Long, CrossCompeteSignUp>> iter = xCrossCompete.getSignup_factions().entrySet().iterator();
/*     */       
/*     */ 
/*  54 */       while (iter.hasNext()) {
/*  55 */         Map.Entry<Long, CrossCompeteSignUp> entry = (Map.Entry)iter.next();
/*  56 */         CrossCompeteSignUp xSignUp = (CrossCompeteSignUp)entry.getValue();
/*  57 */         if (xSignUp.getTime() < startTime) {
/*  58 */           iter.remove();
/*     */         }
/*     */       }
/*     */       
/*  62 */       xCrossCompete.getAgainsts().clear();
/*     */       
/*  64 */       if (xCrossCompete.getMatchtimes() > SCrossCompeteConsts.getInstance().MatchTimes) {
/*  65 */         xCrossCompete.setMatchtimes(0);
/*  66 */         this.needClearMatchTimesAndMissTurnTimes = true;
/*     */       }
/*     */       
/*     */ 
/*  70 */       xCrossCompete.getMiss_turn_factions().clear();
/*     */       
/*  72 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   static class PInitFactionCrossCompete extends LogicProcedure
/*     */   {
/*     */     private final long factionid;
/*     */     private final boolean bClearMatchTimes;
/*     */     
/*     */     PInitFactionCrossCompete(long factionid, boolean bClearMatchTimes)
/*     */     {
/*  83 */       this.factionid = factionid;
/*  84 */       this.bClearMatchTimes = bClearMatchTimes;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  90 */       FactionCrossCompete xFactionCompete = CrossCompeteManager.getXFactionCrossCompete(this.factionid, true);
/*     */       
/*     */ 
/*  93 */       if (xFactionCompete == null) {
/*  94 */         return false;
/*     */       }
/*     */       
/*  97 */       CrossCompeteManager.initXFactionCrossCompete(xFactionCompete);
/*  98 */       if (this.bClearMatchTimes) {
/*  99 */         xFactionCompete.getFactionid2matchtimes().clear();
/* 100 */         xFactionCompete.setMiss_turn_times(0);
/*     */       }
/*     */       
/* 103 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\RInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */