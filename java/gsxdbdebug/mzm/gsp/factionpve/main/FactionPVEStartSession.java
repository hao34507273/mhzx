/*     */ package mzm.gsp.factionpve.main;
/*     */ 
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.factionpve.confbean.SFactionPVEConsts;
/*     */ import mzm.gsp.gang.main.Gang;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.map.main.ControllerInterface;
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
/*     */ 
/*     */ class FactionPVEStartSession
/*     */   extends MilliSession
/*     */ {
/*     */   FactionPVEStartSession(long factionid, long millis)
/*     */   {
/*  25 */     super(millis, factionid);
/*     */   }
/*     */   
/*     */   protected void onTimeOut()
/*     */   {
/*  30 */     NoneRealTimeTaskManager.getInstance().addTask(new POnActivityStart(getOwerId(), getSessionId(), getTimeoutTimestamp()));
/*     */   }
/*     */   
/*     */   static class POnActivityStart extends LogicProcedure
/*     */   {
/*     */     private final long factionid;
/*     */     private final long sessionid;
/*     */     private final long timeout;
/*     */     
/*     */     public POnActivityStart(long factionid, long sessionid, long timeout)
/*     */     {
/*  41 */       this.factionid = factionid;
/*  42 */       this.sessionid = sessionid;
/*  43 */       this.timeout = timeout;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  49 */       FactionPVE xFactionPVE = FactionPVEManager.getXFactionPVEIfNotExist(this.factionid);
/*  50 */       FactionPVETmp xFactionPVETmp = FactionPVEManager.getXFactionPVETmpIfNotExist(this.factionid);
/*  51 */       Gang faction = GangInterface.getGang(this.factionid, true);
/*     */       
/*     */ 
/*  54 */       if ((xFactionPVETmp.getStage() != 0) || (xFactionPVETmp.getSessionid() != this.sessionid))
/*     */       {
/*  56 */         return false;
/*     */       }
/*     */       
/*  59 */       long activityStartTime = ActivityInterface.getActivityStartTime(SFactionPVEConsts.getInstance().Activityid);
/*     */       
/*     */ 
/*  62 */       if (this.timeout < activityStartTime) {
/*  63 */         return false;
/*     */       }
/*     */       
/*     */ 
/*  67 */       if (this.timeout < xFactionPVE.getStart_timestamp()) {
/*  68 */         return false;
/*     */       }
/*     */       
/*  71 */       long endTime = FactionPVEManager.getPVEEndTime(xFactionPVE);
/*  72 */       long now = DateTimeUtils.getCurrTimeInMillis();
/*  73 */       long leftMillis = endTime - now;
/*     */       
/*     */ 
/*  76 */       if (leftMillis < 0L) {
/*  77 */         FactionPVEManager.logError("POnActivityStart.processImp@activity end|factionid=%d|stage=%d|end_time=%d", new Object[] { Long.valueOf(this.factionid), Integer.valueOf(xFactionPVETmp.getStage()), Long.valueOf(endTime) });
/*     */         
/*     */ 
/*  80 */         FactionPVEManager.setStageAndBroadcast(this.factionid, faction, xFactionPVETmp, 6, null);
/*     */         
/*  82 */         return true;
/*     */       }
/*     */       
/*     */ 
/*  86 */       FactionPVEManager.clearXFactionPVEAndXFactionPVETmp(xFactionPVE, xFactionPVETmp);
/*     */       
/*  88 */       FactionPVEManager.addActivateTimesAndBroadcast(faction, xFactionPVE);
/*     */       
/*     */ 
/*  91 */       long world = FactionPVEManager.createPrepareWorld();
/*  92 */       xFactionPVETmp.setWorld(world);
/*     */       
/*     */ 
/*     */ 
/*  96 */       long factionWorld = GangInterface.getGangWorldId(this.factionid);
/*  97 */       ControllerInterface.triggerWorldController(factionWorld, SFactionPVEConsts.getInstance().ControllerIn);
/*     */       
/*     */ 
/* 100 */       PrepareSession prepareSession = new PrepareSession(this.factionid, TimeUnit.MINUTES.toMillis(SFactionPVEConsts.getInstance().PrepareMinutes));
/*     */       
/*     */ 
/*     */ 
/* 104 */       FactionPVEManager.setStageAndBroadcast(this.factionid, faction, xFactionPVETmp, 1, prepareSession);
/*     */       
/*     */ 
/*     */ 
/* 108 */       FactionPVEEndSession endSession = new FactionPVEEndSession(this.factionid, leftMillis);
/* 109 */       xFactionPVETmp.setEnd_sessionid(endSession.getSessionId());
/*     */       
/* 111 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\FactionPVEStartSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */