/*    */ package mzm.gsp.factionpve.main;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.factionpve.confbean.SFactionPVEConsts;
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.timer.main.MilliSession;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.FactionPVE;
/*    */ import xbean.FactionPVETmp;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class KillBossSession
/*    */   extends MilliSession
/*    */ {
/*    */   KillBossSession(long factionid, long millis)
/*    */   {
/* 22 */     super(millis, factionid);
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 27 */     NoneRealTimeTaskManager.getInstance().addTask(new POnKillBossTimeout(getOwerId(), getSessionId(), getTimeoutTimestamp()));
/*    */   }
/*    */   
/*    */   static class POnKillBossTimeout extends LogicProcedure
/*    */   {
/*    */     private final long factionid;
/*    */     private final long sessionid;
/*    */     private final long timeout;
/*    */     
/*    */     POnKillBossTimeout(long factionid, long sessionid, long timeout)
/*    */     {
/* 38 */       this.factionid = factionid;
/* 39 */       this.sessionid = sessionid;
/* 40 */       this.timeout = timeout;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 46 */       FactionPVE xFactionPVE = FactionPVEManager.getXFactionPVEIfNotExist(this.factionid);
/* 47 */       FactionPVETmp xFactionPVETmp = FactionPVEManager.getXFactionPVETmpIfNotExist(this.factionid);
/*    */       
/*    */ 
/* 50 */       if (xFactionPVETmp.getStage() != 4) {
/* 51 */         FactionPVEManager.logError("POnKillBossTimeout.processImp@stage err|factionid=%d|stage=%d", new Object[] { Long.valueOf(this.factionid), Integer.valueOf(xFactionPVETmp.getStage()) });
/*    */         
/*    */ 
/* 54 */         return false;
/*    */       }
/*    */       
/* 57 */       if (xFactionPVETmp.getSessionid() != this.sessionid) {
/* 58 */         FactionPVEManager.logError("POnKillBossTimeout.processImp@sessionid err|factionid=%d|faction_sessionid=%d|cur_sessionid=%d", new Object[] { Long.valueOf(this.factionid), Long.valueOf(xFactionPVETmp.getSessionid()), Long.valueOf(this.sessionid) });
/*    */         
/*    */ 
/* 61 */         return false;
/*    */       }
/*    */       
/* 64 */       long activityStartTime = ActivityInterface.getActivityStartTime(SFactionPVEConsts.getInstance().Activityid);
/*    */       
/*    */ 
/* 67 */       if (this.timeout < activityStartTime) {
/* 68 */         FactionPVEManager.logError("POnKillBossTimeout.processImp@timeout err|factionid=%d|sessionid=%d|timeout=%d", new Object[] { Long.valueOf(this.factionid), Long.valueOf(this.sessionid), Long.valueOf(this.timeout) });
/*    */         
/*    */ 
/* 71 */         return false;
/*    */       }
/*    */       
/*    */ 
/* 75 */       if (this.timeout < xFactionPVE.getStart_timestamp()) {
/* 76 */         FactionPVEManager.logError("POnKillBossTimeout.processImp@timeout less than start timestamp|factionid=%d|sessionid=%d|timeout=%d|start_timestamp=%d", new Object[] { Long.valueOf(this.factionid), Long.valueOf(this.sessionid), Long.valueOf(this.timeout), Long.valueOf(xFactionPVE.getStart_timestamp()) });
/*    */         
/*    */ 
/* 79 */         return false;
/*    */       }
/*    */       
/*    */ 
/* 83 */       FactionPVEManager.broadcastKillBossTimeout(xFactionPVETmp.getWorld());
/*    */       
/* 85 */       WaitLeaveSesson leaveSession = new WaitLeaveSesson(this.factionid, 2, TimeUnit.SECONDS.toMillis(SFactionPVEConsts.getInstance().WaitLeaveSeconds));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 90 */       Gang faction = GangInterface.getGang(this.factionid, true);
/*    */       
/*    */ 
/* 93 */       FactionPVEManager.setStageAndBroadcast(this.factionid, faction, xFactionPVETmp, 5, leaveSession);
/*    */       
/*    */ 
/* 96 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\KillBossSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */