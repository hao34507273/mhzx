/*     */ package mzm.gsp.crosscompete.roam;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*     */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.CrossCompete;
/*     */ import xbean.CrossCompeteAgainst;
/*     */ import xbean.RoamCrossCompeteFaction;
/*     */ import xbean.RoamCrossCompeteFactionTmp;
/*     */ import xtable.Roam_crosscompete_faction;
/*     */ 
/*     */ public class PRoamDragAll2FightMap extends LogicProcedure
/*     */ {
/*     */   private final long factionid1;
/*     */   private final long factionid2;
/*     */   
/*     */   public PRoamDragAll2FightMap(long factionid1, long factionid2)
/*     */   {
/*  22 */     this.factionid1 = factionid1;
/*  23 */     this.factionid2 = factionid2;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  29 */     lock(Roam_crosscompete_faction.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.factionid1), Long.valueOf(this.factionid2) }));
/*     */     
/*     */ 
/*  32 */     RoamCrossCompeteFaction xFaction1 = CrossCompeteRoamManager.getXRoamCrossCompeteFaction(this.factionid1, true);
/*     */     
/*  34 */     RoamCrossCompeteFaction xFaction2 = CrossCompeteRoamManager.getXRoamCrossCompeteFaction(this.factionid2, true);
/*     */     
/*     */ 
/*  37 */     RoamCrossCompeteFactionTmp xFactionTmp1 = CrossCompeteRoamManager.createXRoamCrossCompeteFactionTmpIfNotExist(this.factionid1);
/*     */     
/*  39 */     RoamCrossCompeteFactionTmp xFactionTmp2 = CrossCompeteRoamManager.createXRoamCrossCompeteFactionTmpIfNotExist(this.factionid2);
/*     */     
/*     */ 
/*  42 */     long oldWorld1 = xFactionTmp1.getWorld();
/*  43 */     long oldWorld2 = xFactionTmp2.getWorld();
/*     */     
/*     */ 
/*  46 */     long newWorld = CrossCompeteRoamManager.createFightWorld();
/*     */     
/*  48 */     if (MapInterface.hasRole(oldWorld1))
/*     */     {
/*  50 */       MapInterface.dragAllRoleToTargetWorld(oldWorld1, newWorld, SCrossCompeteConsts.getInstance().FightMap, SCrossCompeteConsts.getInstance().Faction1EnterX, SCrossCompeteConsts.getInstance().Faction1EnterY);
/*     */     }
/*     */     
/*  53 */     if (MapInterface.hasRole(oldWorld2))
/*     */     {
/*  55 */       MapInterface.dragAllRoleToTargetWorld(oldWorld2, newWorld, SCrossCompeteConsts.getInstance().FightMap, SCrossCompeteConsts.getInstance().Faction2EnterX, SCrossCompeteConsts.getInstance().Faction2EnterY);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  60 */     CrossCompeteRoamManager.destroyPrepareWorld(oldWorld1);
/*  61 */     CrossCompeteRoamManager.destroyPrepareWorld(oldWorld2);
/*     */     
/*  63 */     xFactionTmp1.setWorld(newWorld);
/*  64 */     xFactionTmp1.setMapid(SCrossCompeteConsts.getInstance().FightMap);
/*  65 */     xFactionTmp2.setWorld(newWorld);
/*  66 */     xFactionTmp2.setMapid(SCrossCompeteConsts.getInstance().FightMap);
/*     */     
/*     */ 
/*  69 */     CrossCompete xCompete = CrossCompeteManager.getXCrossCompete(true);
/*  70 */     CrossCompeteAgainst xAgainst = CrossCompeteManager.getXAgainst(xCompete, this.factionid1, this.factionid2);
/*     */     
/*     */ 
/*     */ 
/*  74 */     RoamLoadManager.instance.syncFactionOnlineCountWithMax(this.factionid1, xFactionTmp1.getRoles().size());
/*     */     
/*  76 */     RoamLoadManager.instance.syncFactionOnlineCountWithMax(this.factionid2, xFactionTmp2.getRoles().size());
/*     */     
/*     */ 
/*     */ 
/*  80 */     CrossCompeteManager.logInfo("PDragAll2FightMap.processImp@drag all role to fight map|faction1=%d|faction2=%d|oldworld1=%d|oldworld2=%d|newworld=%d", new Object[] { Long.valueOf(this.factionid1), Long.valueOf(this.factionid2), Long.valueOf(oldWorld1), Long.valueOf(oldWorld2), Long.valueOf(newWorld) });
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  90 */     CrossCompeteManager.tlogParticipate(this.factionid1, xFactionTmp1.getRoles().size(), this.factionid2, xFactionTmp2.getRoles().size());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 106 */     boolean faction1HasRole = !xFactionTmp1.getRoles().isEmpty();
/* 107 */     boolean faction2HasRole = !xFactionTmp2.getRoles().isEmpty();
/*     */     
/* 109 */     if (faction1HasRole) {
/* 110 */       if (!faction2HasRole)
/*     */       {
/*     */ 
/*     */ 
/* 114 */         CrossCompeteRoamManager.onOneFactionLeft(this.factionid1, this.factionid2, xFaction1, xFaction2, xFactionTmp1, xFactionTmp2, xAgainst, newWorld);
/*     */ 
/*     */       }
/*     */       
/*     */ 
/*     */     }
/* 120 */     else if (faction2HasRole) {
/* 121 */       CrossCompeteRoamManager.onOneFactionLeft(this.factionid2, this.factionid1, xFaction2, xFaction1, xFactionTmp1, xFactionTmp2, xAgainst, newWorld);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 126 */       CrossCompeteRoamManager.onNoFactionLeft(this.factionid1, this.factionid2, xFaction1, xFaction2, xFactionTmp1, xFactionTmp2, xAgainst);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 132 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\PRoamDragAll2FightMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */