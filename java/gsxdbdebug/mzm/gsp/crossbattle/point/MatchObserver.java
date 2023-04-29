/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ public class MatchObserver
/*    */   extends Observer
/*    */ {
/*    */   private final long worldid;
/*    */   private final int matchIntervalSecond;
/* 15 */   private boolean first = true;
/*    */   
/*    */   public MatchObserver(long intervalSeconds, long worldid, int matchIntervalSecond)
/*    */   {
/* 19 */     super(intervalSeconds);
/* 20 */     this.worldid = worldid;
/* 21 */     this.matchIntervalSecond = matchIntervalSecond;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 27 */     RoamPointRaceOneByOneManager.getInstance().addLogicProcedure(Long.valueOf(this.worldid), new PMatch(this.worldid, this.first));
/* 28 */     setIntervalSeconds(this.matchIntervalSecond);
/* 29 */     this.first = false;
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   private static class PMatch extends LogicProcedure
/*    */   {
/*    */     private final long worldid;
/*    */     private final boolean first;
/*    */     
/*    */     public PMatch(long worldid, boolean first)
/*    */     {
/* 40 */       this.worldid = worldid;
/* 41 */       this.first = first;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 47 */       PointRaceZoneManager zoneManager = PointRaceManager.getInstance().getZoneManager(this.worldid);
/* 48 */       if (zoneManager == null)
/*    */       {
/* 50 */         return false;
/*    */       }
/*    */       
/* 53 */       if (this.first)
/*    */       {
/* 55 */         List<Long> roleids = MapInterface.getRoleList(this.worldid);
/* 56 */         if ((roleids != null) && (!roleids.isEmpty()))
/*    */         {
/* 58 */           int zone = zoneManager.zone;
/* 59 */           int matchDurationInMinute = zoneManager.getMatchDurationInMinute();
/* 60 */           CrossBattlePointManager.syncPointRaceStage(roleids, zone, zoneManager.index, zoneManager.backup, 1, TimeUnit.MINUTES.toMillis(matchDurationInMinute));
/*    */         }
/*    */       }
/*    */       
/* 64 */       CrossBattlePointManager.match(this.worldid);
/* 65 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\MatchObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */