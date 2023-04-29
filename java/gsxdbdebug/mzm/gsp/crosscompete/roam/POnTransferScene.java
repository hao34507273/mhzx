/*     */ package mzm.gsp.crosscompete.roam;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*     */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*     */ import mzm.gsp.map.event.MapTransferArg;
/*     */ import xbean.CrossCompeteAgainst;
/*     */ import xbean.RoamCrossCompeteFaction;
/*     */ import xbean.RoamCrossCompeteFactionTmp;
/*     */ import xbean.RoamCrossCompeteRole;
/*     */ import xtable.Gang;
/*     */ 
/*     */ public class POnTransferScene extends mzm.gsp.map.event.PlayerTransferSceneProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  19 */     if (!GameServerInfoManager.isRoamServer()) {
/*  20 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  24 */     lock(xtable.Basic.getTable(), ((MapTransferArg)this.arg).roleList);
/*     */     
/*  26 */     Long selfFactionid = xtable.Roam_crosscompete_role.selectFactionid((Long)((MapTransferArg)this.arg).roleList.get(0));
/*  27 */     if (selfFactionid == null) {
/*  28 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  32 */     RoamCrossCompeteFaction xSelfFaction = CrossCompeteRoamManager.getXRoamCrossCompeteFaction(selfFactionid.longValue(), false);
/*     */     
/*     */ 
/*  35 */     if (xSelfFaction == null) {
/*  36 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  40 */     lock(Gang.getTable(), java.util.Arrays.asList(new Long[] { selfFactionid, Long.valueOf(xSelfFaction.getOpponent()) }));
/*     */     
/*     */ 
/*  43 */     xSelfFaction = CrossCompeteRoamManager.getXRoamCrossCompeteFaction(selfFactionid.longValue(), true);
/*     */     
/*     */ 
/*  46 */     RoamCrossCompeteFactionTmp xSelfFactionTmp = CrossCompeteRoamManager.getXRoamCrossCompeteFactionTmp(selfFactionid.longValue(), true);
/*     */     
/*  48 */     if (xSelfFactionTmp == null) {
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     long activityWorld = xSelfFactionTmp.getWorld();
/*  53 */     if (activityWorld < 0L) {
/*  54 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  58 */     xbean.CrossCompete xCompete = CrossCompeteManager.getXCrossCompete(true);
/*  59 */     CrossCompeteAgainst xAgainst = CrossCompeteManager.getXAgainst(xCompete, selfFactionid.longValue(), xSelfFaction.getOpponent());
/*     */     
/*     */ 
/*  62 */     if (xAgainst == null) {
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     if ((((MapTransferArg)this.arg).oldWorldId != activityWorld) && (((MapTransferArg)this.arg).newWorldId == activityWorld))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*  71 */       int stage = mzm.gsp.activity.main.ActivityInterface.getActivityStage(SCrossCompeteConsts.getInstance().Activityid);
/*     */       
/*  73 */       for (Iterator i$ = ((MapTransferArg)this.arg).roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*  74 */         RoamCrossCompeteRole xRoamRole = CrossCompeteRoamManager.getXRoamCrossCompeteRole(r, true);
/*     */         
/*     */ 
/*  77 */         CrossCompeteRoamManager.syncRoleCompete(r, xRoamRole, xSelfFaction, xAgainst.getCompete_index());
/*     */       }
/*     */       
/*     */ 
/*  81 */       if (CrossCompeteManager.isFightStage(stage))
/*     */       {
/*     */ 
/*  84 */         long oppoFactionid = xSelfFaction.getOpponent();
/*     */         
/*  86 */         CrossCompeteRoamManager.addFactionPlayer(selfFactionid.longValue(), xSelfFactionTmp, ((MapTransferArg)this.arg).roleList, xSelfFaction, true);
/*     */         
/*     */ 
/*     */ 
/*  90 */         RoamCrossCompeteFaction xOppoFaction = CrossCompeteRoamManager.getXRoamCrossCompeteFaction(oppoFactionid, true);
/*     */         
/*  92 */         RoamCrossCompeteFactionTmp xOppoFactionTmp = CrossCompeteRoamManager.getXRoamCrossCompeteFactionTmp(oppoFactionid, true);
/*     */         
/*     */ 
/*     */ 
/*  96 */         CrossCompeteRoamManager.syncAgainst(((MapTransferArg)this.arg).roleList, selfFactionid.longValue(), xSelfFaction, xSelfFactionTmp, oppoFactionid, xOppoFaction, xOppoFactionTmp);
/*     */         
/*     */ 
/*     */ 
/* 100 */         for (Iterator i$ = ((MapTransferArg)this.arg).roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 101 */           RoamCrossCompeteRole xRoamRole = CrossCompeteRoamManager.getXRoamCrossCompeteRole(r, true);
/*     */           
/* 103 */           CrossCompeteRoamManager.setFactionTitle(r, xRoamRole, xSelfFaction);
/*     */         }
/*     */         
/*     */ 
/* 107 */         CrossCompeteManager.logInfo("POnTransferScene.processImp@enter cross fight map|roles=%s|factionid=%d|oldworld=%d|oldmapid=%d|newworld=%d|newmapid=%d", new Object[] { ((MapTransferArg)this.arg).roleList.toString(), Long.valueOf(selfFactionid.longValue()), Long.valueOf(((MapTransferArg)this.arg).oldWorldId), Integer.valueOf(((MapTransferArg)this.arg).oldMapCfgId), Long.valueOf(((MapTransferArg)this.arg).newWorldId), Integer.valueOf(((MapTransferArg)this.arg).newMapCfgId) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 121 */         CrossCompeteRoamManager.addFactionPlayer(selfFactionid.longValue(), xSelfFactionTmp, ((MapTransferArg)this.arg).roleList, xSelfFaction, false);
/*     */         
/*     */ 
/*     */ 
/* 125 */         CrossCompeteManager.logInfo("POnTransferScene.processImp@enter cross prepare map|roles=%s|factionid=%d|oldworld=%d|oldmapid=%d|newworld=%d|newmapid=%d", new Object[] { ((MapTransferArg)this.arg).roleList.toString(), Long.valueOf(selfFactionid.longValue()), Long.valueOf(((MapTransferArg)this.arg).oldWorldId), Integer.valueOf(((MapTransferArg)this.arg).oldMapCfgId), Long.valueOf(((MapTransferArg)this.arg).newWorldId), Integer.valueOf(((MapTransferArg)this.arg).newMapCfgId) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     }
/* 137 */     else if ((((MapTransferArg)this.arg).oldWorldId == activityWorld) && (((MapTransferArg)this.arg).newWorldId != activityWorld))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 143 */       if (CrossCompeteManager.isPrepareStage())
/*     */       {
/* 145 */         CrossCompeteRoamManager.removeFactionPlayer(selfFactionid.longValue(), xSelfFactionTmp, ((MapTransferArg)this.arg).roleList, false);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 150 */         CrossCompeteRoamManager.removeFactionPlayer(selfFactionid.longValue(), xSelfFactionTmp, ((MapTransferArg)this.arg).roleList, true);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 155 */       CrossCompeteManager.logInfo("POnTransferScene.processImp@leave cross compete map|roles=%s|factionid=%d|oldworld=%d|oldmapid=%d|newworld=%d|newmapid=%d", new Object[] { ((MapTransferArg)this.arg).roleList.toString(), Long.valueOf(selfFactionid.longValue()), Long.valueOf(((MapTransferArg)this.arg).oldWorldId), Integer.valueOf(((MapTransferArg)this.arg).oldMapCfgId), Long.valueOf(((MapTransferArg)this.arg).newWorldId), Integer.valueOf(((MapTransferArg)this.arg).newMapCfgId) });
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 166 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\POnTransferScene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */