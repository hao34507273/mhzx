/*     */ package mzm.gsp.crosscompete.roam;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*     */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*     */ import xbean.CrossCompete;
/*     */ import xbean.CrossCompeteAgainst;
/*     */ import xbean.RoamCrossCompeteFaction;
/*     */ import xbean.RoamCrossCompeteFactionTmp;
/*     */ import xtable.Gang;
/*     */ 
/*     */ class PCheckEnd extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long factionid1;
/*     */   private final long factionid2;
/*     */   
/*     */   public PCheckEnd(long faction1, long faction2)
/*     */   {
/*  21 */     this.factionid1 = faction1;
/*  22 */     this.factionid2 = faction2;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  29 */     lock(Gang.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.factionid1), Long.valueOf(this.factionid2) }));
/*     */     
/*     */ 
/*  32 */     CrossCompete xCompete = CrossCompeteManager.getXCrossCompete(true);
/*  33 */     if (xCompete == null) {
/*  34 */       return false;
/*     */     }
/*     */     
/*  37 */     CrossCompeteAgainst xAgainst = CrossCompeteManager.getXAgainst(xCompete, this.factionid1, this.factionid2);
/*     */     
/*  39 */     if (xAgainst == null) {
/*  40 */       return false;
/*     */     }
/*  42 */     if (xAgainst.getWinner() > 0L) {
/*  43 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  47 */     int stage = ActivityInterface.getActivityStage(SCrossCompeteConsts.getInstance().Activityid);
/*     */     
/*  49 */     if (CrossCompeteManager.isPrepareStage(stage)) {
/*  50 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  54 */     RoamCrossCompeteFactionTmp xFactionTmp1 = CrossCompeteRoamManager.getXRoamCrossCompeteFactionTmp(this.factionid1, true);
/*     */     
/*  56 */     RoamCrossCompeteFactionTmp xFactionTmp2 = CrossCompeteRoamManager.getXRoamCrossCompeteFactionTmp(this.factionid2, true);
/*     */     
/*  58 */     if ((xFactionTmp1 == null) || (xFactionTmp2 == null)) {
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     if (xFactionTmp1.getWorld() != xFactionTmp2.getWorld()) {
/*  63 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  67 */     RoamCrossCompeteFaction xFaction1 = CrossCompeteRoamManager.getXRoamCrossCompeteFaction(this.factionid1, true);
/*     */     
/*  69 */     RoamCrossCompeteFaction xFaction2 = CrossCompeteRoamManager.getXRoamCrossCompeteFaction(this.factionid2, true);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  77 */     boolean faction1HasRole = !xFactionTmp1.getRoles().isEmpty();
/*  78 */     boolean faction2HasRole = !xFactionTmp2.getRoles().isEmpty();
/*     */     
/*  80 */     if (faction1HasRole) {
/*  81 */       if (!faction2HasRole)
/*     */       {
/*     */ 
/*     */ 
/*  85 */         return CrossCompeteRoamManager.onOneFactionLeft(this.factionid1, this.factionid2, xFaction1, xFaction2, xFactionTmp1, xFactionTmp2, xAgainst, xFactionTmp1.getWorld());
/*     */       }
/*     */       
/*     */     }
/*     */     else
/*     */     {
/*  91 */       if (faction2HasRole) {
/*  92 */         return CrossCompeteRoamManager.onOneFactionLeft(this.factionid2, this.factionid1, xFaction2, xFaction1, xFactionTmp1, xFactionTmp2, xAgainst, xFactionTmp1.getWorld());
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*  97 */       return CrossCompeteRoamManager.onNoFactionLeft(this.factionid1, this.factionid2, xFaction1, xFaction2, xFactionTmp1, xFactionTmp2, xAgainst);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 102 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\PCheckEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */