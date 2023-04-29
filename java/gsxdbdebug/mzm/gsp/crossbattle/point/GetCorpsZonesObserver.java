/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.CrossbattleDrawLots;
/*    */ import xbean.DrawLotsZoneInfo;
/*    */ 
/*    */ public class GetCorpsZonesObserver extends Observer
/*    */ {
/*    */   private final int activityCfgid;
/*    */   
/*    */   public GetCorpsZonesObserver(long intervalSeconds, int activityCfgid)
/*    */   {
/* 18 */     super(intervalSeconds);
/* 19 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 25 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityCfgid), new PGetDrawLotsData(this.activityCfgid));
/*    */     
/* 27 */     return false;
/*    */   }
/*    */   
/*    */   private static class PGetDrawLotsData extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     private final int activityCfgid;
/*    */     
/*    */     public PGetDrawLotsData(int activityCfgid)
/*    */     {
/* 36 */       this.activityCfgid = activityCfgid;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 42 */       List<Long> corpsids = mzm.gsp.crossbattle.own.CrossBattleOwnInterface.getAllCrossBattleOwnPromotionCorpsids(this.activityCfgid, true);
/* 43 */       if (corpsids.isEmpty())
/*    */       {
/* 45 */         GameServer.logger().error(String.format("[crossbattlepoint]PGetDrawLotsData.processImp@local corps is empty|activity_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*    */         
/*    */ 
/* 48 */         return false;
/*    */       }
/*    */       
/* 51 */       boolean send = false;
/* 52 */       CrossbattleDrawLots xCrossbattleDrawLots = CrossBattlePointManager.getAndInitCrossbattleDrawLots(this.activityCfgid);
/* 53 */       if (xCrossbattleDrawLots.getCorps().size() < corpsids.size())
/*    */       {
/*    */ 
/* 56 */         send = true;
/*    */       }
/*    */       else
/*    */       {
/* 60 */         for (DrawLotsZoneInfo xDrawLotsZoneInfo : xCrossbattleDrawLots.getCorps().values())
/*    */         {
/* 62 */           if (xDrawLotsZoneInfo.getZone() <= 0)
/*    */           {
/*    */ 
/* 65 */             send = true;
/* 66 */             break;
/*    */           }
/*    */         }
/*    */       }
/*    */       
/* 71 */       if (!send)
/*    */       {
/* 73 */         return true;
/*    */       }
/*    */       
/* 76 */       long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 77 */       long endTime = CrossBattlePointManager.getDrawLotsEndTime(this.activityCfgid);
/* 78 */       long delay = endTime - now;
/* 79 */       long roleid = 0L;
/* 80 */       if (delay <= 0L)
/*    */       {
/* 82 */         roleid = -1L;
/*    */       }
/*    */       
/* 85 */       if (!CrossBattlePointManager.getCorpsZones(roleid, 0L, this.activityCfgid, corpsids))
/*    */       {
/* 87 */         GameServer.logger().error(String.format("[crossbattlepoint]PGetDrawLotsData.processImp@grc send msg failed|activity_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*    */         
/*    */ 
/* 90 */         return false;
/*    */       }
/*    */       
/* 93 */       GameServer.logger().info(String.format("[crossbattlepoint]PGetDrawLotsData.processImp@get local corps|activity_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*    */       
/*    */ 
/* 96 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\GetCorpsZonesObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */