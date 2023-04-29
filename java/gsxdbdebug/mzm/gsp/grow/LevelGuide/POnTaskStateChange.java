/*     */ package mzm.gsp.grow.LevelGuide;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.grow.confbean.GoalParameter;
/*     */ import mzm.gsp.grow.confbean.SLevelTargetCfg;
/*     */ import mzm.gsp.grow.hand.TargetHandle;
/*     */ import mzm.gsp.grow.hand.TargetRegManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.event.TaskStateChangeProcedure;
/*     */ import mzm.gsp.task.main.TaskEventArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnTaskStateChange
/*     */   extends TaskStateChangeProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  28 */     if (((TaskEventArg)this.arg).taskState != 3)
/*     */     {
/*  30 */       return false;
/*     */     }
/*  32 */     int goalType = 1;
/*  33 */     List<Integer> goals = LevelGuideManager.getGoalIdsByType(goalType);
/*  34 */     if ((goals == null) || (goals.size() == 0))
/*     */     {
/*  36 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  75 */     for (Iterator i$ = goals.iterator(); i$.hasNext();) { int goalId = ((Integer)i$.next()).intValue();
/*     */       
/*  77 */       new PTaskFinish(((TaskEventArg)this.arg).roleId, goalId).execute();
/*     */     }
/*     */     
/*  80 */     return true;
/*     */   }
/*     */   
/*     */   class PTaskFinish
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int goalId;
/*     */     
/*     */     public PTaskFinish(long roleId, int goalId)
/*     */     {
/*  91 */       this.roleId = roleId;
/*  92 */       this.goalId = goalId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  99 */       String userId = RoleInterface.getUserId(this.roleId);
/* 100 */       lock(Lockeys.get(User.getTable(), userId));
/* 101 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 102 */       SLevelTargetCfg cfg = LevelGuideManager.getGoalCfg(this.goalId);
/* 103 */       if (cfg == null)
/*     */       {
/* 105 */         return false;
/*     */       }
/* 107 */       int moduleType = cfg.moduleType;
/* 108 */       TargetHandle handler = TargetRegManager.getHanler(moduleType);
/* 109 */       if (handler == null)
/*     */       {
/* 111 */         return false;
/*     */       }
/* 113 */       if (!handler.isGoalValid(this.roleId, this.goalId))
/*     */       {
/* 115 */         return false;
/*     */       }
/* 117 */       List<GoalParameter> goalParameters = cfg.goalParameters;
/* 118 */       int taskId = ((GoalParameter)goalParameters.get(0)).parameter;
/* 119 */       if (taskId < 0)
/*     */       {
/* 121 */         return false;
/*     */       }
/* 123 */       if (((TaskEventArg)POnTaskStateChange.this.arg).taskId == taskId)
/*     */       {
/* 125 */         if (!handler.onCanFinishTarget(this.roleId, this.goalId))
/*     */         {
/* 127 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 131 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnTaskStateChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */