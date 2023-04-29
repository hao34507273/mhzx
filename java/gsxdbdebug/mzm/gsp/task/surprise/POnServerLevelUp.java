/*     */ package mzm.gsp.task.surprise;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity3.confbean.STActivityId2serverId;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.server.event.ServerLevelArg;
/*     */ import mzm.gsp.task.SSyncSurpriseServerLevel;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.LevelStartTimeData;
/*     */ 
/*     */ public class POnServerLevelUp extends mzm.gsp.server.event.ServerLevelUpRunnable
/*     */ {
/*     */   public void process() throws Exception
/*     */   {
/*  16 */     new ChangeServerCache(((ServerLevelArg)this.arg).currentLevel, ((ServerLevelArg)this.arg).startTime).call();
/*  17 */     new OnServerLevelUp(((ServerLevelArg)this.arg).currentLevel, ((ServerLevelArg)this.arg).startTime).call();
/*  18 */     new CheckNewSurpriseGraph(null).call();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private class CheckNewSurpriseGraph
/*     */     extends LogicProcedure
/*     */   {
/*     */     private CheckNewSurpriseGraph() {}
/*     */     
/*     */ 
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  33 */       return SurpriseScheduleManager.onServerLevelChange();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private class ChangeServerCache
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final int curServerLevel;
/*     */     
/*     */ 
/*     */     private final long startTime;
/*     */     
/*     */ 
/*     */     public ChangeServerCache(int serverLevel, long startTime)
/*     */     {
/*  50 */       this.curServerLevel = serverLevel;
/*  51 */       this.startTime = startTime;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  58 */       LevelStartTimeData xLevelStartTime = xtable.Levelstarttime.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  59 */       if (xLevelStartTime == null)
/*     */       {
/*  61 */         return false;
/*     */       }
/*     */       
/*  64 */       xLevelStartTime.getServerlevel2starttime().put(Integer.valueOf(this.curServerLevel), Long.valueOf(this.startTime));
/*     */       
/*  66 */       ServerLevelCache.getInstance().updateStartTime(this.curServerLevel, this.startTime);
/*     */       
/*  68 */       SSyncSurpriseServerLevel p = new SSyncSurpriseServerLevel();
/*  69 */       p.level2starttime.putAll(ServerLevelCache.getInstance().getAllServerLevelInfos());
/*  70 */       OnlineManager.getInstance().sendAll(p);
/*     */       
/*  72 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private class OnServerLevelUp
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final int curServerLevel;
/*     */     
/*     */ 
/*     */     private final long startTime;
/*     */     
/*     */ 
/*     */ 
/*     */     public OnServerLevelUp(int serverLevel, long startTime)
/*     */     {
/*  90 */       this.curServerLevel = serverLevel;
/*  91 */       this.startTime = startTime;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  97 */       for (STActivityId2serverId activityCfg : STActivityId2serverId.getAll().values())
/*     */       {
/*  99 */         if (mzm.gsp.activity.main.ActivityInterface.isActivityOpen(activityCfg.activityId))
/*     */         {
/*     */ 
/*     */ 
/* 103 */           SurpriseTaskManager.checkAndInitSupriseTask(activityCfg, this.curServerLevel, this.startTime); }
/*     */       }
/* 105 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\surprise\POnServerLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */