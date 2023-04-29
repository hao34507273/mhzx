/*     */ package mzm.gsp.competition.main;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.competition.confbean.SCompetitionConsts;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import xbean.Competition;
/*     */ import xbean.CompetitionAgainst;
/*     */ import xbean.CompetitionMatch;
/*     */ import xbean.CompetitionTmp;
/*     */ import xbean.FactionCompetition;
/*     */ import xbean.FactionCompetitionTmp;
/*     */ import xbean.MercenaryFights;
/*     */ import xtable.Faction_competition_tmp;
/*     */ 
/*     */ class PCheckEnd extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long factionid1;
/*     */   private final long factionid2;
/*     */   
/*     */   public PCheckEnd(long faction1, long faction2)
/*     */   {
/*  25 */     this.factionid1 = faction1;
/*  26 */     this.factionid2 = faction2;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     long tlogRoleid = -1L;
/*     */     
/*     */ 
/*  35 */     mzm.gsp.gang.main.Gang faction1 = GangInterface.getGang(this.factionid1, false);
/*  36 */     mzm.gsp.gang.main.Gang faction2 = GangInterface.getGang(this.factionid2, false);
/*     */     
/*  38 */     if (faction1 != null) {
/*  39 */       tlogRoleid = faction1.getBangZhuId();
/*     */     }
/*  41 */     else if (faction2 != null) {
/*  42 */       tlogRoleid = faction2.getBangZhuId();
/*     */     }
/*     */     
/*     */ 
/*  46 */     String tlogUserid = mzm.gsp.role.main.RoleInterface.getUserId(tlogRoleid);
/*     */     
/*     */ 
/*  49 */     lock(xtable.Gang.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(this.factionid1), Long.valueOf(this.factionid2) }));
/*     */     
/*     */ 
/*  52 */     Competition xCompetition = CompetitionManager.getXCompetition(true);
/*  53 */     if (xCompetition == null) {
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     CompetitionMatch xCompetitionMatch = CompetitionManager.getXMatch(this.factionid1, this.factionid2);
/*  58 */     CompetitionAgainst xAgainst = (CompetitionAgainst)xCompetition.getAgainsts().get(xCompetitionMatch);
/*  59 */     if (xAgainst == null) {
/*  60 */       return false;
/*     */     }
/*  62 */     if (xAgainst.getFinished()) {
/*  63 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  67 */     int stage = ActivityInterface.getActivityStage(SCompetitionConsts.getInstance().Activityid);
/*  68 */     if (stage <= 2) {
/*  69 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  73 */     FactionCompetitionTmp xFCTmp1 = Faction_competition_tmp.get(Long.valueOf(this.factionid1));
/*  74 */     FactionCompetitionTmp xFCTmp2 = Faction_competition_tmp.get(Long.valueOf(this.factionid2));
/*  75 */     if ((xFCTmp1 == null) || (xFCTmp2 == null)) {
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     if (xFCTmp1.getWorld() != xFCTmp2.getWorld()) {
/*  80 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  84 */     FactionCompetition xFC1 = CompetitionManager.getXFactionCompetitionIfNotExist(this.factionid1);
/*  85 */     FactionCompetition xFC2 = CompetitionManager.getXFactionCompetitionIfNotExist(this.factionid2);
/*     */     
/*     */ 
/*  88 */     CompetitionTmp xCompetitionTmp = CompetitionManager.getXCompetitionTmpIfNotExist();
/*  89 */     MercenaryFights xFights = CompetitionManager.getXMercenaryFights(xCompetitionTmp, this.factionid1, this.factionid2);
/*     */     
/*     */ 
/*  92 */     Collection<Long> allRoles = MapInterface.getRoleList(xFCTmp1.getWorld());
/*     */     
/*  94 */     boolean faction1HasRole = false;
/*  95 */     boolean faction2HasRole = false;
/*     */     Iterator i$;
/*  97 */     if (!allRoles.isEmpty()) {
/*  98 */       if (faction1 == null) {
/*  99 */         faction1HasRole = false;
/* 100 */         faction2HasRole = true;
/*     */       }
/*     */       else {
/* 103 */         for (i$ = allRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 104 */           if (faction1.isInGang(r)) {
/* 105 */             faction1HasRole = true;
/*     */           }
/*     */           else {
/* 108 */             faction2HasRole = true;
/*     */           }
/*     */           
/* 111 */           if ((faction1HasRole) && (faction2HasRole)) {
/*     */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 118 */     if (faction1HasRole) {
/* 119 */       if (!faction2HasRole)
/*     */       {
/*     */ 
/*     */ 
/* 123 */         return CompetitionManager.onOneFactionLeft(this.factionid1, this.factionid2, faction1, faction2, xFC1, xFC2, xAgainst, xFights, xFCTmp1.getWorld(), tlogUserid);
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 128 */       if (faction2HasRole) {
/* 129 */         return CompetitionManager.onOneFactionLeft(this.factionid2, this.factionid1, faction2, faction1, xFC2, xFC1, xAgainst, xFights, xFCTmp1.getWorld(), tlogUserid);
/*     */       }
/*     */       
/*     */ 
/* 133 */       return CompetitionManager.onNoFactionLeft(this.factionid1, this.factionid2, faction1, faction2, xFC1, xFC2, xAgainst, tlogUserid);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 138 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\PCheckEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */