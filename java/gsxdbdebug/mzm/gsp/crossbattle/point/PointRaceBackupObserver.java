/*     */ package mzm.gsp.crossbattle.point;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattlePointCfg;
/*     */ import mzm.gsp.crossbattle.confbean.TimePointInfo;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ import mzm.gsp.crossbattle.own.CrossBattleOwnInterface;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ public class PointRaceBackupObserver
/*     */   extends Observer
/*     */ {
/*     */   private final int activityCfgid;
/*     */   private final int zone;
/*     */   private final int timePointCfgid;
/*     */   private final int backUpPointCfgid;
/*     */   
/*     */   public PointRaceBackupObserver(long intervalSeconds, int activityCfgid, int zone, int timePointCfgid, int backupPointCfgid)
/*     */   {
/*  27 */     super(intervalSeconds);
/*  28 */     this.activityCfgid = activityCfgid;
/*  29 */     this.zone = zone;
/*  30 */     this.timePointCfgid = timePointCfgid;
/*  31 */     this.backUpPointCfgid = backupPointCfgid;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  37 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityCfgid), new PPointRaceStart(this.activityCfgid, this.zone, this.timePointCfgid, this.backUpPointCfgid));
/*     */     
/*  39 */     return false;
/*     */   }
/*     */   
/*     */   private static class PPointRaceStart extends LogicProcedure
/*     */   {
/*     */     private final int activityCfgid;
/*     */     private final int zone;
/*     */     private final int timePointCfgid;
/*     */     private final int backupPointCfgid;
/*     */     
/*     */     public PPointRaceStart(int activityCfgid, int zone, int timePointCfgid, int backupPointCfgid)
/*     */     {
/*  51 */       this.activityCfgid = activityCfgid;
/*  52 */       this.zone = zone;
/*  53 */       this.timePointCfgid = timePointCfgid;
/*  54 */       this.backupPointCfgid = backupPointCfgid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  60 */       SCrossBattlePointCfg cfg = SCrossBattlePointCfg.get(this.activityCfgid);
/*  61 */       if (cfg == null)
/*     */       {
/*  63 */         GameServer.logger().error(String.format("[crossbattlepoint]PPointRaceStart.processImp@cfg is null|activity_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */         
/*     */ 
/*  66 */         return false;
/*     */       }
/*     */       
/*  69 */       int index = 0;
/*  70 */       for (TimePointInfo timePointInfo : cfg.timePoints)
/*     */       {
/*  72 */         index++;
/*  73 */         if (timePointInfo.timePoint == this.timePointCfgid) {
/*     */           break;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*  79 */       long prepareTime = TimeUnit.MINUTES.toMillis(cfg.prepareDurationInMinute);
/*  80 */       Map<Long, Integer> corps2Zone = CrossBattlePointManager.getCorpsZone(this.activityCfgid);
/*  81 */       for (Map.Entry<Long, Integer> entry : corps2Zone.entrySet())
/*     */       {
/*  83 */         if (((Integer)entry.getValue()).intValue() == this.zone)
/*     */         {
/*     */ 
/*     */ 
/*  87 */           List<Long> roleids = CrossBattleOwnInterface.getCrossBattleRegisterRoleList(((Long)entry.getKey()).longValue(), this.activityCfgid, true);
/*     */           
/*  89 */           if ((roleids != null) && (!roleids.isEmpty()))
/*     */           {
/*     */ 
/*     */ 
/*  93 */             CrossBattlePointManager.syncPointRaceStage(roleids, this.zone, index, (byte)1, 0, prepareTime);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*  98 */       new PointRaceEndLocalObserver(TimeUnit.MINUTES.toSeconds(cfg.durationInMinute) + 1L, this.activityCfgid, this.timePointCfgid);
/*     */       
/*     */ 
/* 101 */       GameServer.logger().info(String.format("[crossbattlepoint]PPointRaceStart.processImp@backup start|activity_cfgid=%d|zone=%d|time_point_cfgid=%d|backup_time_point_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(this.zone), Integer.valueOf(this.timePointCfgid), Integer.valueOf(this.backupPointCfgid) }));
/*     */       
/*     */ 
/*     */ 
/* 105 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PointRaceBackupObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */