/*     */ package mzm.gsp.factionpve.main;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.factionpve.confbean.SFactionPVEConsts;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.gang.main.Gang;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.MilliSession;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import xbean.FactionPVE;
/*     */ import xbean.FactionPVETmp;
/*     */ 
/*     */ 
/*     */ 
/*     */ class RFactionPVEEnd
/*     */   extends LogicRunnable
/*     */ {
/*     */   private final long factionid;
/*     */   private final int result;
/*     */   
/*     */   RFactionPVEEnd(long factionid, int result)
/*     */   {
/*  31 */     this.factionid = factionid;
/*  32 */     this.result = result;
/*     */   }
/*     */   
/*     */   public void process()
/*     */     throws Exception
/*     */   {
/*  38 */     PSetFinished pSetFinished = new PSetFinished(this.factionid, this.result);
/*  39 */     if (!pSetFinished.call()) {
/*  40 */       FactionPVEManager.logError("RFactionPVEEnd.process|set finished failed|factionid=%d", new Object[] { Long.valueOf(this.factionid) });
/*     */       
/*  42 */       return;
/*     */     }
/*     */     
/*  45 */     Set<Long> fights = pSetFinished.getFights();
/*  46 */     long world = pSetFinished.getWorld();
/*     */     
/*     */ 
/*  49 */     for (Iterator i$ = fights.iterator(); i$.hasNext();) { long fightid = ((Long)i$.next()).longValue();
/*     */       
/*  51 */       FightInterface.syncEndFight(fightid);
/*     */     }
/*     */     
/*     */ 
/*  55 */     List<Long> roles = MapInterface.getRoleList(world);
/*  56 */     for (Iterator i$ = roles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*  57 */       new PLeave(r).call();
/*     */     }
/*     */     
/*     */ 
/*  61 */     FactionPVEManager.destroyFightWorld(world);
/*     */     
/*     */ 
/*  64 */     FactionPVEManager.logInfo("RFactionPVEEnd.process|pve end|factionid=%d", new Object[] { Long.valueOf(this.factionid) });
/*     */   }
/*     */   
/*     */ 
/*     */   static class PSetFinished
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long factionid;
/*     */     private final int result;
/*  73 */     private Set<Long> fights = new HashSet();
/*  74 */     private long world = -1L;
/*     */     
/*     */     PSetFinished(long factionid, int result) {
/*  77 */       this.factionid = factionid;
/*  78 */       this.result = result;
/*     */     }
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  83 */       String leaderUserid = null;
/*     */       
/*  85 */       Gang faction = GangInterface.getGang(this.factionid, false);
/*  86 */       if (faction != null)
/*     */       {
/*  88 */         leaderUserid = RoleInterface.getUserId(faction.getBangZhuId());
/*     */       }
/*     */       
/*     */ 
/*  92 */       FactionPVE xFactionPVE = FactionPVEManager.getXFactionPVEIfNotExist(this.factionid);
/*  93 */       FactionPVETmp xFactionPVETmp = FactionPVEManager.getXFactionPVETmpIfNotExist(this.factionid);
/*     */       
/*  95 */       FactionPVEManager.setStageAndBroadcast(this.factionid, faction, xFactionPVETmp, 6, null);
/*     */       
/*     */ 
/*     */ 
/*  99 */       if ((faction != null) && (leaderUserid != null)) {
/* 100 */         int participateCount = MapInterface.getRoleNumInWorld(this.world);
/* 101 */         int onlineCount = faction.getOnlineCount();
/* 102 */         long nowMillis = DateTimeUtils.getCurrTimeInMillis();
/* 103 */         int durationMillis = (int)(nowMillis - xFactionPVE.getStart_timestamp());
/* 104 */         FactionPVEManager.tlogEnd(leaderUserid, this.factionid, faction.getDisplayid(), participateCount, onlineCount, this.result, durationMillis, xFactionPVETmp);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 109 */       MilliSession.removeSession(xFactionPVETmp.getSessionid(), this.factionid);
/* 110 */       MilliSession.removeSession(xFactionPVETmp.getEnd_sessionid(), this.factionid);
/*     */       
/* 112 */       xFactionPVETmp.setSessionid(-1L);
/* 113 */       xFactionPVETmp.setEnd_sessionid(-1L);
/*     */       
/*     */ 
/* 116 */       this.fights.addAll(xFactionPVETmp.getFights());
/* 117 */       this.world = xFactionPVETmp.getWorld();
/*     */       
/*     */ 
/* 120 */       long factionWorld = GangInterface.getGangWorldId(this.factionid);
/*     */       
/* 122 */       ControllerInterface.collectWorldController(factionWorld, SFactionPVEConsts.getInstance().ControllerIn);
/*     */       
/*     */ 
/*     */ 
/* 126 */       FactionPVEManager.clearXFactionPVEAndXFactionPVETmp(xFactionPVE, xFactionPVETmp);
/*     */       
/* 128 */       return true;
/*     */     }
/*     */     
/*     */     Set<Long> getFights() {
/* 132 */       return this.fights;
/*     */     }
/*     */     
/*     */     long getWorld() {
/* 136 */       return this.world;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\RFactionPVEEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */