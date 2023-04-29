/*     */ package mzm.gsp.competition.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.competition.confbean.SCompetitionConsts;
/*     */ import mzm.gsp.gang.main.Gang;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.map.event.MapTransferArg;
/*     */ import mzm.gsp.map.event.PlayerTransferSceneProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.FactionCompetition;
/*     */ import xbean.FactionCompetitionTmp;
/*     */ import xtable.Faction_competition;
/*     */ import xtable.Faction_competition_tmp;
/*     */ import xtable.Role_competition;
/*     */ 
/*     */ public class POnTransferScene extends PlayerTransferSceneProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  22 */     Gang selfFaction = GangInterface.getGangByRoleId(((Long)((MapTransferArg)this.arg).roleList.get(0)).longValue(), false);
/*  23 */     if (selfFaction == null) {
/*  24 */       return false;
/*     */     }
/*     */     
/*  27 */     long selfFactionid = selfFaction.getGangId();
/*     */     
/*     */ 
/*  30 */     FactionCompetitionTmp xSelfFCTmp = Faction_competition_tmp.select(Long.valueOf(selfFaction.getGangId()));
/*  31 */     if (xSelfFCTmp == null) {
/*  32 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  36 */     FactionCompetition xSelfFC = Faction_competition.select(Long.valueOf(selfFaction.getGangId()));
/*  37 */     if (xSelfFC == null) {
/*  38 */       return false;
/*     */     }
/*     */     
/*  41 */     long activityWorld = xSelfFCTmp.getWorld();
/*  42 */     if (activityWorld < 0L) {
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     if ((((MapTransferArg)this.arg).oldWorldId != activityWorld) && (((MapTransferArg)this.arg).newWorldId == activityWorld))
/*     */     {
/*     */ 
/*  49 */       lock(xtable.Basic.getTable(), ((MapTransferArg)this.arg).roleList);
/*     */       
/*     */ 
/*     */ 
/*  53 */       int stage = ActivityInterface.getActivityStage(SCompetitionConsts.getInstance().Activityid);
/*  54 */       CompetitionManager.broadcastStage(((MapTransferArg)this.arg).roleList);
/*     */       
/*  56 */       for (Iterator i$ = ((MapTransferArg)this.arg).roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*  57 */         xbean.RoleCompetition xRoleCompetition = Role_competition.get(Long.valueOf(r));
/*     */         
/*  59 */         CompetitionManager.syncRoleCompetition(r, xRoleCompetition);
/*     */       }
/*     */       Iterator i$;
/*  62 */       if (CompetitionManager.isCompeteStage(stage))
/*     */       {
/*     */ 
/*  65 */         long oppoFactionid = xSelfFC.getOpponent();
/*  66 */         lock(Faction_competition.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(selfFactionid), Long.valueOf(oppoFactionid) }));
/*  67 */         Gang oppoFaction = GangInterface.getGang(oppoFactionid, true);
/*  68 */         FactionCompetition xOppoFC = Faction_competition.get(Long.valueOf(oppoFactionid));
/*  69 */         FactionCompetitionTmp xOppoFCTmp = CompetitionManager.getXFactionCompetitionTmpIfNotExist(oppoFactionid);
/*     */         
/*     */ 
/*  72 */         CompetitionManager.syncAgainst(((MapTransferArg)this.arg).roleList, selfFaction, xSelfFC, xSelfFCTmp, oppoFaction, xOppoFC, xOppoFCTmp);
/*     */         
/*     */ 
/*  75 */         for (i$ = ((MapTransferArg)this.arg).roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*  76 */           CompetitionManager.setFactionTitle(r, selfFaction);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  84 */       CompetitionManager.logInfo("POnTransferScene.processImp@enter competition map|roles=%s|factionid=%d|faction_displayid=%d|oldworld=%d|oldmapid=%d|newworld=%d|newmapid=%d", new Object[] { ((MapTransferArg)this.arg).roleList.toString(), Long.valueOf(selfFaction.getGangId()), Long.valueOf(selfFaction.getDisplayid()), Long.valueOf(((MapTransferArg)this.arg).oldWorldId), Integer.valueOf(((MapTransferArg)this.arg).oldMapCfgId), Long.valueOf(((MapTransferArg)this.arg).newWorldId), Integer.valueOf(((MapTransferArg)this.arg).newMapCfgId) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     }
/*  95 */     else if ((((MapTransferArg)this.arg).oldWorldId == activityWorld) && (((MapTransferArg)this.arg).newWorldId != activityWorld))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 101 */       int stage = ActivityInterface.getActivityStage(SCompetitionConsts.getInstance().Activityid);
/* 102 */       if (stage >= 1)
/*     */       {
/* 104 */         NoneRealTimeTaskManager.getInstance().addTask(new PCheckEnd(selfFaction.getGangId(), xSelfFC.getOpponent()));
/*     */       }
/*     */       
/*     */ 
/* 108 */       CompetitionManager.logInfo("POnTransferScene.processImp@leave competition map|roles=%s|factionid=%d|faction_displayid=%d|oldworld=%d|oldmapid=%d|newworld=%d|newmapid=%d", new Object[] { ((MapTransferArg)this.arg).roleList.toString(), Long.valueOf(selfFaction.getGangId()), Long.valueOf(selfFaction.getDisplayid()), Long.valueOf(((MapTransferArg)this.arg).oldWorldId), Integer.valueOf(((MapTransferArg)this.arg).oldMapCfgId), Long.valueOf(((MapTransferArg)this.arg).newWorldId), Integer.valueOf(((MapTransferArg)this.arg).newMapCfgId) });
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
/*     */ 
/* 120 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\POnTransferScene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */