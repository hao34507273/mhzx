/*     */ package mzm.gsp.task.surprise;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.achievement.main.AchievementInterface;
/*     */ import mzm.gsp.activity3.confbean.SSurpriseAchievementCfg;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.task.SSyncSurpriseServerLevel;
/*     */ import mzm.gsp.task.SynSurpriseGraphFinishInfo;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xdb.Procedure;
/*     */ 
/*     */ public class POnRoleLogin
/*     */   extends PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  21 */     SSyncSurpriseServerLevel p = new SSyncSurpriseServerLevel();
/*  22 */     p.level2starttime.putAll(ServerLevelCache.getInstance().getAllServerLevelInfos());
/*  23 */     OnlineManager.getInstance().send(((Long)this.arg).longValue(), p);
/*     */     
/*  25 */     synSurpriseTaskFinishInfo(((Long)this.arg).longValue());
/*     */     
/*  27 */     checkMissAchievement(((Long)this.arg).longValue());
/*     */     
/*  29 */     asynCheckRoleSurpriseSchedule(((Long)this.arg).longValue());
/*  30 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void asynCheckRoleSurpriseSchedule(final long roleId)
/*     */   {
/*  40 */     Procedure.execute(new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*  46 */         return RoleCheckSurpriseGraph.checkRoleSurpriseSchedule(roleId);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   private void synSurpriseTaskFinishInfo(final long roleId)
/*     */   {
/*  53 */     Procedure.execute(new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*  59 */         Map<Integer, Integer> graphId2finishCount = TaskInterface.getGraphFinishCount(roleId, SurpriseTaskManager.getSurpriseGraphInfo().keySet());
/*     */         
/*  61 */         if ((graphId2finishCount == null) || (graphId2finishCount.size() == 0))
/*     */         {
/*  63 */           return false;
/*     */         }
/*  65 */         SynSurpriseGraphFinishInfo syn = new SynSurpriseGraphFinishInfo();
/*  66 */         syn.finishgraphinfo.putAll(graphId2finishCount);
/*  67 */         OnlineManager.getInstance().send(roleId, syn);
/*  68 */         return true;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   private void checkMissAchievement(final long roleId)
/*     */   {
/*  75 */     Procedure.execute(new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*  81 */         POnRoleLogin.this.reCheckAchievement(roleId);
/*  82 */         return true;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   private final void reCheckAchievement(final long roleId)
/*     */   {
/*  89 */     for (SSurpriseAchievementCfg cfg : SSurpriseAchievementCfg.getAll().values())
/*     */     {
/*  91 */       if ((AchievementInterface.getAchievementGoalState(roleId, cfg.activityId, cfg.achievementId, false) == 2) && 
/*     */       
/*     */ 
/*     */ 
/*  95 */         (neverAcceptGraph(roleId, cfg.graphId, cfg.graphFinishCount)))
/*     */       {
/*     */ 
/*     */ 
/*  99 */         Procedure.execute(new LogicProcedure()
/*     */         {
/*     */ 
/*     */           protected boolean processImp()
/*     */             throws Exception
/*     */           {
/* 105 */             SurpriseTaskManager.loggerInfo("POnRoleLogin.reCheckAchievement@ miss achievement!|roleId=%d|achievementId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(this.val$cfg.achievementId) });
/*     */             
/*     */ 
/* 108 */             return SurpriseTaskManager.handAchievementGraph(roleId, this.val$cfg.achievementId, this.val$cfg.activityId);
/*     */           }
/*     */         });
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   boolean neverAcceptGraph(long roleId, int graphId, int finishCount)
/*     */   {
/* 117 */     if (!TaskInterface.isHaveGraphId(graphId))
/*     */     {
/* 119 */       return false;
/*     */     }
/*     */     
/* 122 */     if (TaskInterface.isHaveGraphId(roleId, graphId))
/*     */     {
/* 124 */       return false;
/*     */     }
/*     */     
/* 127 */     int alreadyFinishCount = TaskInterface.getRoleGraphFinishCount(roleId, graphId);
/* 128 */     if (alreadyFinishCount >= finishCount)
/*     */     {
/* 130 */       return false;
/*     */     }
/* 132 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\surprise\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */