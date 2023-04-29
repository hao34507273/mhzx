/*     */ package mzm.gsp.crossbattle.point;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.common.confbean.STimePointCommonCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattlePointCfg;
/*     */ import mzm.gsp.crossbattle.confbean.TimePointInfo;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ import mzm.gsp.crossbattle.own.CrossBattleOwnInterface;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PointRaceObserver
/*     */   extends Observer
/*     */ {
/*     */   private final int activityCfgid;
/*     */   private final int timePointCfgid;
/*     */   
/*     */   public PointRaceObserver(long intervalSeconds, int activityCfgid, int timePointCfgid)
/*     */   {
/*  25 */     super(intervalSeconds);
/*  26 */     this.activityCfgid = activityCfgid;
/*  27 */     this.timePointCfgid = timePointCfgid;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  33 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityCfgid), new PPointRaceStart(this.activityCfgid, this.timePointCfgid));
/*     */     
/*  35 */     return false;
/*     */   }
/*     */   
/*     */   private static class PPointRaceStart extends LogicProcedure
/*     */   {
/*     */     private final int activityCfgid;
/*     */     private final int timePointCfgid;
/*     */     
/*     */     public PPointRaceStart(int activityCfgid, int timePointCfgid)
/*     */     {
/*  45 */       this.activityCfgid = activityCfgid;
/*  46 */       this.timePointCfgid = timePointCfgid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  52 */       SCrossBattlePointCfg cfg = SCrossBattlePointCfg.get(this.activityCfgid);
/*  53 */       if (cfg == null)
/*     */       {
/*  55 */         GameServer.logger().error(String.format("[crossbattlepoint]PPointRaceStart.processImp@cfg is null|activity_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */         
/*     */ 
/*  58 */         return false;
/*     */       }
/*     */       
/*  61 */       STimePointCommonCfg timePointCommonCfg = STimePointCommonCfg.get(this.timePointCfgid);
/*  62 */       if (timePointCommonCfg == null)
/*     */       {
/*  64 */         GameServer.logger().error(String.format("[crossbattlepoint]PPointRaceStart.processImp@time point cfg is null|activity_cfgid=%d|time_point_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(this.timePointCfgid) }));
/*     */         
/*     */ 
/*     */ 
/*  68 */         return false;
/*     */       }
/*     */       
/*  71 */       int index = 0;
/*  72 */       for (TimePointInfo timePoints : cfg.timePoints)
/*     */       {
/*  74 */         index++;
/*  75 */         if (timePoints.timePoint == this.timePointCfgid) {
/*     */           break;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*  81 */       long prepareTime = TimeUnit.MINUTES.toMillis(cfg.prepareDurationInMinute);
/*  82 */       Map<Long, Integer> corps2Zone = CrossBattlePointManager.getCorpsZone(this.activityCfgid);
/*  83 */       for (Map.Entry<Long, Integer> entry : corps2Zone.entrySet())
/*     */       {
/*  85 */         List<Long> roleids = CrossBattleOwnInterface.getCrossBattleRegisterRoleList(((Long)entry.getKey()).longValue(), this.activityCfgid, true);
/*     */         
/*  87 */         if ((roleids != null) && (!roleids.isEmpty()))
/*     */         {
/*     */ 
/*     */ 
/*  91 */           CrossBattlePointManager.syncPointRaceStage(roleids, ((Integer)entry.getValue()).intValue(), index, (byte)0, 0, prepareTime);
/*     */         }
/*     */       }
/*     */       
/*  95 */       CrossBattlePointManager.initCrossBattlePointRaceInfo(this.activityCfgid, this.timePointCfgid);
/*     */       
/*     */ 
/*  98 */       new PointRaceEndLocalObserver(TimeUnit.MINUTES.toSeconds(cfg.durationInMinute) + 1L, this.activityCfgid, this.timePointCfgid);
/*     */       
/*     */ 
/* 101 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PointRaceObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */