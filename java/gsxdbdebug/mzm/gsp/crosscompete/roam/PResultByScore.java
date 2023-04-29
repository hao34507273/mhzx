/*     */ package mzm.gsp.crosscompete.roam;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.CrossCompete;
/*     */ import xbean.CrossCompeteAgainst;
/*     */ import xbean.RoamCrossCompeteFaction;
/*     */ import xbean.RoamCrossCompeteFactionTmp;
/*     */ import xtable.Gang;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PResultByScore
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long factionid1;
/*     */   private final long factionid2;
/*  23 */   private long winFactionid = -1L;
/*  24 */   private long loseFactionid = -1L;
/*  25 */   private List<Long> winnerRoles = new ArrayList();
/*  26 */   private List<Long> loserRoles = new ArrayList();
/*  27 */   private long world = -1L;
/*     */   
/*     */   PResultByScore(long factionid1, long factionid2)
/*     */   {
/*  31 */     this.factionid1 = factionid1;
/*  32 */     this.factionid2 = factionid2;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     lock(Gang.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.factionid1), Long.valueOf(this.factionid2) }));
/*     */     
/*     */ 
/*  41 */     CrossCompete xCompete = CrossCompeteManager.getXCrossCompete(true);
/*  42 */     if (xCompete == null) {
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     CrossCompeteAgainst xAgainst = CrossCompeteManager.getXAgainst(xCompete, this.factionid1, this.factionid2);
/*     */     
/*  48 */     if ((xAgainst == null) || (xAgainst.getWinner() > 0L)) {
/*  49 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  53 */     RoamCrossCompeteFactionTmp xFactionTmp1 = CrossCompeteRoamManager.getXRoamCrossCompeteFactionTmp(this.factionid1, true);
/*     */     
/*  55 */     RoamCrossCompeteFactionTmp xFactionTmp2 = CrossCompeteRoamManager.getXRoamCrossCompeteFactionTmp(this.factionid2, true);
/*     */     
/*  57 */     if ((xFactionTmp1 == null) || (xFactionTmp2 == null)) {
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     if (xFactionTmp1.getWorld() != xFactionTmp2.getWorld()) {
/*  62 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  66 */     RoamCrossCompeteFaction xFaction1 = CrossCompeteRoamManager.getXRoamCrossCompeteFaction(this.factionid1, true);
/*     */     
/*  68 */     RoamCrossCompeteFaction xFaction2 = CrossCompeteRoamManager.getXRoamCrossCompeteFaction(this.factionid2, true);
/*     */     
/*     */ 
/*  71 */     if ((xFaction1 == null) || (xFaction2 == null)) {
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     RoamCrossCompeteFaction xWinFaction = null;
/*  76 */     RoamCrossCompeteFaction xLoseFaction = null;
/*  77 */     RoamCrossCompeteFactionTmp xWinFactionTmp = null;
/*  78 */     RoamCrossCompeteFactionTmp xLoseFactionTmp = null;
/*     */     
/*  80 */     if (CrossCompeteRoamManager.isFrontWin(this.factionid1, xFaction1, this.factionid2, xFaction2)) {
/*  81 */       this.winFactionid = this.factionid1;
/*  82 */       this.loseFactionid = this.factionid2;
/*  83 */       xWinFaction = xFaction1;
/*  84 */       xLoseFaction = xFaction2;
/*  85 */       xWinFactionTmp = xFactionTmp1;
/*  86 */       xLoseFactionTmp = xFactionTmp2;
/*     */     }
/*     */     else {
/*  89 */       this.winFactionid = this.factionid2;
/*  90 */       this.loseFactionid = this.factionid1;
/*  91 */       xWinFaction = xFaction2;
/*  92 */       xLoseFaction = xFaction1;
/*  93 */       xWinFactionTmp = xFactionTmp2;
/*  94 */       xLoseFactionTmp = xFactionTmp1;
/*     */     }
/*     */     
/*     */ 
/*  98 */     xAgainst.setWinner(this.winFactionid);
/*     */     
/*     */ 
/* 101 */     CrossCompeteRoamManager.broadcastWinLose(this.winFactionid, this.loseFactionid, xWinFaction, xLoseFaction, xWinFactionTmp, xLoseFactionTmp, 3);
/*     */     
/*     */ 
/*     */ 
/* 105 */     this.winnerRoles.addAll(xWinFactionTmp.getRoles());
/* 106 */     this.loserRoles.addAll(xLoseFactionTmp.getRoles());
/* 107 */     this.world = xWinFactionTmp.getWorld();
/*     */     
/* 109 */     CrossCompeteManager.logInfo("PResultByScore.processImp@result|factionid1=%d|factionid2=%d|winner=%d|world=%d", new Object[] { Long.valueOf(this.factionid1), Long.valueOf(this.factionid2), Long.valueOf(this.winFactionid), Long.valueOf(this.world) });
/*     */     
/*     */ 
/*     */ 
/* 113 */     return true;
/*     */   }
/*     */   
/*     */   long getWinFactionid() {
/* 117 */     return this.winFactionid;
/*     */   }
/*     */   
/*     */   long getLoseFactionid() {
/* 121 */     return this.loseFactionid;
/*     */   }
/*     */   
/*     */   List<Long> getWinnerRoles() {
/* 125 */     return this.winnerRoles;
/*     */   }
/*     */   
/*     */   List<Long> getLoserRoles() {
/* 129 */     return this.loserRoles;
/*     */   }
/*     */   
/*     */   long getWorld() {
/* 133 */     return this.world;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\PResultByScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */