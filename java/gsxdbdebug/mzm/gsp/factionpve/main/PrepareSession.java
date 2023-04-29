/*     */ package mzm.gsp.factionpve.main;
/*     */ 
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.factionpve.confbean.SFactionPVEConsts;
/*     */ import mzm.gsp.gang.main.Gang;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.MilliSession;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.FactionPVE;
/*     */ import xbean.FactionPVETmp;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PrepareSession
/*     */   extends MilliSession
/*     */ {
/*     */   PrepareSession(long factionid, long millis)
/*     */   {
/*  25 */     super(millis, factionid);
/*     */   }
/*     */   
/*     */   protected void onTimeOut()
/*     */   {
/*  30 */     NoneRealTimeTaskManager.getInstance().addTask(new PDragAll2FightMap(getOwerId(), getSessionId(), getTimeoutTimestamp()));
/*     */   }
/*     */   
/*     */   static class PDragAll2FightMap extends LogicProcedure
/*     */   {
/*     */     private final long factionid;
/*     */     private final long sessionid;
/*     */     private final long prepareEndMillis;
/*     */     
/*     */     PDragAll2FightMap(long factionid, long sessionid, long prepareEndMillis)
/*     */     {
/*  41 */       this.factionid = factionid;
/*  42 */       this.sessionid = sessionid;
/*  43 */       this.prepareEndMillis = prepareEndMillis;
/*     */     }
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  48 */       String leaderUserid = null;
/*     */       
/*     */ 
/*  51 */       Gang faction = GangInterface.getGang(this.factionid, false);
/*  52 */       if (faction != null)
/*     */       {
/*  54 */         leaderUserid = RoleInterface.getUserId(faction.getBangZhuId());
/*     */       }
/*     */       
/*     */ 
/*  58 */       FactionPVETmp xTmp = FactionPVEManager.getXFactionPVETmpIfNotExist(this.factionid);
/*     */       
/*  60 */       if ((xTmp.getStage() != 1) || (xTmp.getSessionid() != this.sessionid))
/*     */       {
/*  62 */         FactionPVEManager.logError("PDragAll2FightMap.processImp@stage not prepare|factionid=%d|stage=%d", new Object[] { Long.valueOf(this.factionid), Integer.valueOf(xTmp.getStage()) });
/*     */         
/*     */ 
/*  65 */         return false;
/*     */       }
/*     */       
/*     */ 
/*  69 */       FactionPVE xFactionPVE = FactionPVEManager.getXFactionPVEIfNotExist(this.factionid);
/*     */       
/*  71 */       long activityStartTime = ActivityInterface.getActivityStartTime(SFactionPVEConsts.getInstance().Activityid);
/*     */       
/*     */ 
/*  74 */       if (this.prepareEndMillis < activityStartTime) {
/*  75 */         FactionPVEManager.logError("PDragAll2FightMap.processImp@timeout less than period start time|factionid=%d|stage=%d", new Object[] { Long.valueOf(this.factionid), Integer.valueOf(xTmp.getStage()) });
/*     */         
/*     */ 
/*  78 */         return false;
/*     */       }
/*     */       
/*     */ 
/*  82 */       if (this.prepareEndMillis < xFactionPVE.getStart_timestamp()) {
/*  83 */         FactionPVEManager.logError("PDragAll2FightMap.processImp@timeout less than pve start time|factionid=%d|stage=%d", new Object[] { Long.valueOf(this.factionid), Integer.valueOf(xTmp.getStage()) });
/*     */         
/*     */ 
/*  86 */         return false;
/*     */       }
/*     */       
/*  89 */       long endTime = xFactionPVE.getStart_timestamp() + TimeUnit.MINUTES.toMillis(SFactionPVEConsts.getInstance().ActivityMinutes);
/*     */       
/*     */ 
/*  92 */       long now = DateTimeUtils.getCurrTimeInMillis();
/*     */       
/*  94 */       long delta = endTime - now;
/*     */       
/*  96 */       if (delta < 0L) {
/*  97 */         FactionPVEManager.logError("PDragAll2FightMap.processImp@wrong time|factionid=%d|stage=%d|end_time=%d", new Object[] { Long.valueOf(this.factionid), Integer.valueOf(xTmp.getStage()), Long.valueOf(endTime) });
/*     */         
/*     */ 
/* 100 */         return false;
/*     */       }
/*     */       
/* 103 */       long prepareWorld = xTmp.getWorld();
/*     */       
/* 105 */       int participateCount = MapInterface.getRoleNumInWorld(prepareWorld);
/*     */       
/*     */ 
/* 108 */       long fightWorld = FactionPVEManager.createFightWorld();
/*     */       
/*     */ 
/* 111 */       MapInterface.dragAllRoleToTargetWorld(prepareWorld, fightWorld, SFactionPVEConsts.getInstance().FightMap);
/*     */       
/*     */ 
/*     */ 
/* 115 */       FactionPVEManager.destroyFightWorld(prepareWorld);
/* 116 */       xTmp.setWorld(fightWorld);
/*     */       
/*     */ 
/* 119 */       FactionPVEManager.setStageAndBroadcast(this.factionid, faction, xTmp, 2, null);
/*     */       
/*     */ 
/*     */ 
/* 123 */       new RefreshMonsterObserver(this.factionid, SFactionPVEConsts.getInstance().MonsterRefreshSeconds);
/*     */       
/*     */ 
/*     */ 
/* 127 */       if ((faction != null) && (leaderUserid != null)) {
/* 128 */         FactionPVEManager.tlogParticipate(leaderUserid, this.factionid, faction.getDisplayid(), participateCount, faction.getOnlineCount());
/*     */       }
/*     */       
/*     */ 
/* 132 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\PrepareSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */