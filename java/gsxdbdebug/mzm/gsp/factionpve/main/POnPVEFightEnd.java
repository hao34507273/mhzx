/*     */ package mzm.gsp.factionpve.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.factionpve.confbean.SFactionPVEConsts;
/*     */ import mzm.gsp.factionpve.confbean.SKillBossAwardCfg;
/*     */ import mzm.gsp.fight.event.PVEFightEndArg;
/*     */ import mzm.gsp.fight.event.PVEFightEndProcedure;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.gang.main.Gang;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.map.main.MapVisibleMonsterFightContext;
/*     */ import mzm.gsp.relatedboss.main.RelatedBossInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.FactionPVETmp;
/*     */ import xbean.RoleFactionPVE;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnPVEFightEnd extends PVEFightEndProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  33 */     if (((PVEFightEndArg)this.arg).fightReason != FightReason.FACTION_PVE.value) {
/*  34 */       return false;
/*     */     }
/*     */     
/*  37 */     List<Long> awardRoles = ((PVEFightEndArg)this.arg).notEscapeRoles();
/*     */     
/*  39 */     List<Long> allRoles = new ArrayList();
/*  40 */     allRoles.addAll(awardRoles);
/*  41 */     allRoles.addAll(((PVEFightEndArg)this.arg).escapedRoles);
/*     */     
/*  43 */     List<String> awardUsers = new ArrayList();
/*  44 */     for (Iterator i$ = awardRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/*  46 */       String userid = RoleInterface.getUserId(roleid);
/*  47 */       awardUsers.add(userid);
/*     */     }
/*     */     
/*     */ 
/*  51 */     lock(User.getTable(), awardUsers);
/*     */     
/*  53 */     lock(Basic.getTable(), allRoles);
/*     */     
/*     */ 
/*  56 */     Gang faction = GangInterface.getGangByRoleId(((Long)((PVEFightEndArg)this.arg).roleList.get(0)).longValue(), true);
/*  57 */     if (faction == null) {
/*  58 */       FactionPVEManager.logError("POnPVEFightEnd.processImp@no faction|roles=%s|fightcfgid=%d|fightid=%d|fightreason=%d", new Object[] { ((PVEFightEndArg)this.arg).roleList, Integer.valueOf(((PVEFightEndArg)this.arg).fightCfgID), Long.valueOf(((PVEFightEndArg)this.arg).fightid), Integer.valueOf(((PVEFightEndArg)this.arg).fightReason) });
/*     */       
/*     */ 
/*  61 */       return false;
/*     */     }
/*  63 */     long factionid = GangInterface.getGangId(((Long)((PVEFightEndArg)this.arg).roleList.get(0)).longValue());
/*     */     
/*     */ 
/*  66 */     FactionPVETmp xFactionPVETmp = FactionPVEManager.getXFactionPVETmpIfNotExist(factionid);
/*     */     
/*     */     Iterator i$;
/*  69 */     if ((!((PVEFightEndArg)this.arg).isForceEnd) && (((PVEFightEndArg)this.arg).isPlayerWin))
/*     */     {
/*  71 */       for (Iterator i$ = awardRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*  72 */         RoleFactionPVE xRolePVE = FactionPVEManager.getXRoleFactionPVEIfNotExist(r);
/*  73 */         boolean bAddSuccess = false;
/*  74 */         for (Iterator i$ = ((PVEFightEndArg)this.arg).diedMonsters.iterator(); i$.hasNext();) { int monsterid = ((Integer)i$.next()).intValue();
/*  75 */           boolean ret = FactionPVEManager.addMonsterCountOfRole(xRolePVE, monsterid, 1);
/*  76 */           if ((!bAddSuccess) && 
/*  77 */             (ret)) {
/*  78 */             bAddSuccess = true;
/*     */           }
/*     */         }
/*     */         
/*     */ 
/*  83 */         if (bAddSuccess)
/*     */         {
/*  85 */           if (FactionPVEManager.checkAndHandleRoleGoal(xRolePVE))
/*     */           {
/*     */ 
/*  88 */             String userid = RoleInterface.getUserId(r);
/*  89 */             AwardReason awardReason = new AwardReason(LogReason.FACTION_PVE_SELF_GOAL, xRolePVE.getGoal_times());
/*     */             
/*  91 */             AwardModel awardModel = AwardInterface.awardFixAward(SFactionPVEConsts.getInstance().PersonGoalAward, userid, r, false, false, awardReason);
/*     */             
/*     */ 
/*     */ 
/*  95 */             FactionPVEManager.sendSelfGoalAward(r, xRolePVE.getGoal_times(), awardModel);
/*     */           }
/*     */           
/*  98 */           FactionPVEManager.syncSelfKillMonster(r, xRolePVE);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 103 */       boolean bFactionAdd = false;
/* 104 */       for (Iterator i$ = ((PVEFightEndArg)this.arg).diedMonsters.iterator(); i$.hasNext();) { int monsterid = ((Integer)i$.next()).intValue();
/* 105 */         boolean ret = FactionPVEManager.addMonsterCountOfFaction(xFactionPVETmp, monsterid, 1);
/* 106 */         if ((!bFactionAdd) && 
/* 107 */           (ret)) {
/* 108 */           bFactionAdd = true;
/*     */         }
/*     */       }
/*     */       MapVisibleMonsterFightContext monsterContext;
/*     */       String leaderName;
/*     */       Iterator i$;
/* 114 */       if (xFactionPVETmp.getStage() == 2) {
/* 115 */         if (bFactionAdd) {
/* 116 */           FactionPVEManager.broadcastFactionKillMonster(xFactionPVETmp);
/*     */           
/* 118 */           if (FactionPVEManager.checkMonsterGoalOfFaction(xFactionPVETmp))
/*     */           {
/* 120 */             BossCountDownSession session = new BossCountDownSession(factionid, TimeUnit.SECONDS.toMillis(SFactionPVEConsts.getInstance().BossCountDownSeconds));
/*     */             
/*     */ 
/* 123 */             FactionPVEManager.setStageAndBroadcast(factionid, faction, xFactionPVETmp, 3, session);
/*     */             
/*     */ 
/* 126 */             NoneRealTimeTaskManager.getInstance().addTask(new RAwardFactionGoal(xFactionPVETmp.getWorld()));
/*     */           }
/*     */           
/*     */         }
/*     */       }
/* 131 */       else if ((xFactionPVETmp.getStage() == 4) && 
/* 132 */         ((((PVEFightEndArg)this.arg).context instanceof MapVisibleMonsterFightContext))) {
/* 133 */         monsterContext = (MapVisibleMonsterFightContext)((PVEFightEndArg)this.arg).context;
/* 134 */         if (FactionPVEConfigManager.isBoss(monsterContext.monsterCfgId)) {
/* 135 */           SKillBossAwardCfg awardCfg = SKillBossAwardCfg.get(monsterContext.monsterCfgId);
/* 136 */           if (awardCfg != null)
/*     */           {
/* 138 */             NoneRealTimeTaskManager.getInstance().addTask(new RAwardKillBoss(monsterContext.worldId, awardCfg));
/*     */           }
/*     */           else
/*     */           {
/* 142 */             FactionPVEManager.logError("POnPVEFightEnd.processImp@is boss but no award|roles=%s|world=%d|bossid=%d", new Object[] { ((PVEFightEndArg)this.arg).roleList, Long.valueOf(monsterContext.worldId), Integer.valueOf(monsterContext.monsterCfgId) });
/*     */           }
/*     */           
/*     */ 
/*     */ 
/* 147 */           List<String> roleNames = new ArrayList();
/* 148 */           for (Iterator i$ = ((PVEFightEndArg)this.arg).roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 149 */             String name = RoleInterface.getName(r);
/* 150 */             if (name != null) {
/* 151 */               roleNames.add(name);
/*     */             }
/*     */           }
/* 154 */           FactionPVEManager.broadcastKillBoss(xFactionPVETmp.getWorld(), roleNames, monsterContext.monsterCfgId);
/*     */           
/*     */ 
/*     */ 
/* 158 */           FactionPVEManager.addKilledBoss(xFactionPVETmp, monsterContext.monsterCfgId);
/*     */           
/* 160 */           FactionPVEManager.broadcastKillBossCount(xFactionPVETmp);
/*     */           
/* 162 */           if (FactionPVEManager.isAllBossKilled(xFactionPVETmp)) {
/* 163 */             FactionPVEManager.broadcastKillBossSucceed(monsterContext.worldId);
/*     */             
/* 165 */             WaitLeaveSesson leaveSession = new WaitLeaveSesson(factionid, 1, TimeUnit.SECONDS.toMillis(SFactionPVEConsts.getInstance().WaitLeaveSeconds));
/*     */             
/*     */ 
/*     */ 
/* 169 */             FactionPVEManager.setStageAndBroadcast(factionid, faction, xFactionPVETmp, 5, leaveSession);
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 174 */         if (RelatedBossInterface.isRelatedMapMonster(monsterContext.monsterCfgId)) {
/* 175 */           List<Integer> bossList = RelatedBossInterface.getBossList(monsterContext.monsterCfgId);
/* 176 */           if (bossList != null) {
/* 177 */             leaderName = RoleInterface.getName(((Long)((PVEFightEndArg)this.arg).roleList.get(0)).longValue());
/* 178 */             for (i$ = bossList.iterator(); i$.hasNext();) { int bossid = ((Integer)i$.next()).intValue();
/* 179 */               FactionPVEManager.broadcastKillRelatedMonster(xFactionPVETmp.getWorld(), leaderName, monsterContext.monsterCfgId, bossid);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 189 */       for (Iterator i$ = awardRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 190 */         ActivityInterface.logActivity(r, SFactionPVEConsts.getInstance().Activityid, ActivityLogStatus.FINISH);
/*     */       }
/*     */       
/*     */ 
/* 194 */       for (i$ = awardRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 195 */         ActivityInterface.tlogActivity(r, SFactionPVEConsts.getInstance().Activityid, ActivityLogStatus.FINISH);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 203 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\POnPVEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */