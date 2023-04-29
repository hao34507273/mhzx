/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Executor;
/*    */ 
/*    */ public class CancelMatchObserver extends Observer
/*    */ {
/*    */   private final long worldid;
/*    */   
/*    */   public CancelMatchObserver(long intervalSeconds, long worldid)
/*    */   {
/* 18 */     super(intervalSeconds);
/* 19 */     this.worldid = worldid;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 25 */     Executor.getInstance().execute(new RCancelMatch(this.worldid));
/* 26 */     return false;
/*    */   }
/*    */   
/*    */   private static class RCancelMatch extends LogicRunnable
/*    */   {
/*    */     private final long worldid;
/*    */     
/*    */     public RCancelMatch(long worldid)
/*    */     {
/* 35 */       this.worldid = worldid;
/*    */     }
/*    */     
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 41 */       PointRaceZoneManager zoneManager = PointRaceManager.getInstance().getZoneManager(this.worldid);
/* 42 */       if (zoneManager == null)
/*    */       {
/* 44 */         GameServer.logger().error(String.format("[crossbattlepoint]RCancelMatch.process@zone manager is null|worldid=%d", new Object[] { Long.valueOf(this.worldid) }));
/*    */         
/* 46 */         return;
/*    */       }
/* 48 */       zoneManager.removeMatchObserver();
/*    */       
/* 50 */       List<Long> roleids = MapInterface.getRoleList(this.worldid);
/* 51 */       if ((roleids == null) || (roleids.isEmpty()))
/*    */       {
/* 53 */         return;
/*    */       }
/*    */       
/* 56 */       int zone = zoneManager.zone;
/* 57 */       int countDownMinutes = zoneManager.getUnMatchDurationInMinute();
/* 58 */       CrossBattlePointManager.syncPointRaceStage(roleids, zone, zoneManager.index, zoneManager.backup, 2, TimeUnit.MINUTES.toMillis(countDownMinutes));
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\CancelMatchObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */