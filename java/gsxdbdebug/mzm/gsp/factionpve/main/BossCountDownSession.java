/*    */ package mzm.gsp.factionpve.main;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.factionpve.confbean.SFactionPVEConsts;
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.timer.main.MilliSession;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.FactionPVE;
/*    */ import xbean.FactionPVETmp;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class BossCountDownSession
/*    */   extends MilliSession
/*    */ {
/*    */   BossCountDownSession(long factionid, long millis)
/*    */   {
/* 24 */     super(millis, factionid);
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 29 */     NoneRealTimeTaskManager.getInstance().addTask(new PBossAppear(getOwerId(), getSessionId(), getTimeoutTimestamp()));
/*    */   }
/*    */   
/*    */   static class PBossAppear extends LogicProcedure
/*    */   {
/*    */     private final long factionid;
/*    */     private final long sessionid;
/*    */     private final long timeout;
/*    */     
/*    */     PBossAppear(long factionid, long sessionid, long timeout)
/*    */     {
/* 40 */       this.factionid = factionid;
/* 41 */       this.sessionid = sessionid;
/* 42 */       this.timeout = timeout;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 48 */       FactionPVE xFactionPVE = FactionPVEManager.getXFactionPVEIfNotExist(this.factionid);
/* 49 */       FactionPVETmp xFactionPVETmp = FactionPVEManager.getXFactionPVETmpIfNotExist(this.factionid);
/*    */       
/*    */ 
/* 52 */       if ((xFactionPVETmp.getStage() != 3) || (xFactionPVETmp.getSessionid() != this.sessionid))
/*    */       {
/* 54 */         return false;
/*    */       }
/*    */       
/* 57 */       long activityStartTime = ActivityInterface.getActivityStartTime(SFactionPVEConsts.getInstance().Activityid);
/*    */       
/*    */ 
/* 60 */       if (this.timeout < activityStartTime) {
/* 61 */         return false;
/*    */       }
/*    */       
/*    */ 
/* 65 */       if (this.timeout < xFactionPVE.getStart_timestamp()) {
/* 66 */         return false;
/*    */       }
/*    */       
/* 69 */       long now = DateTimeUtils.getCurrTimeInMillis();
/* 70 */       long countDownMillis = TimeUnit.SECONDS.toMillis(SFactionPVEConsts.getInstance().BossExistSeconds);
/* 71 */       long endTime = FactionPVEManager.getFactionPVEEndTime(xFactionPVE);
/* 72 */       if (endTime < 0L) {
/* 73 */         return false;
/*    */       }
/* 75 */       long leftMillis = endTime - now;
/* 76 */       if (leftMillis <= 0L) {
/* 77 */         return false;
/*    */       }
/*    */       
/* 80 */       KillBossSession session = new KillBossSession(this.factionid, Math.min(countDownMillis, leftMillis));
/*    */       
/*    */ 
/* 83 */       Gang faction = GangInterface.getGang(this.factionid, true);
/*    */       
/*    */ 
/* 86 */       FactionPVEManager.setStageAndBroadcast(this.factionid, faction, xFactionPVETmp, 4, session);
/*    */       
/*    */ 
/*    */ 
/* 90 */       ControllerInterface.triggerWorldController(xFactionPVETmp.getWorld(), SFactionPVEConsts.getInstance().BossController);
/*    */       
/*    */ 
/*    */ 
/* 94 */       if (xFactionPVETmp.getEnd_sessionid() > 0L) {
/* 95 */         MilliSession.removeSession(xFactionPVETmp.getEnd_sessionid());
/* 96 */         xFactionPVETmp.setEnd_sessionid(-1L);
/*    */       }
/*    */       
/* 99 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\BossCountDownSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */