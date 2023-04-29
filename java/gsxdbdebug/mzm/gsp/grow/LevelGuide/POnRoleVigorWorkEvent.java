/*     */ package mzm.gsp.grow.LevelGuide;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.grow.confbean.GoalParameter;
/*     */ import mzm.gsp.grow.confbean.SLevelTargetCfg;
/*     */ import mzm.gsp.grow.hand.TargetHandle;
/*     */ import mzm.gsp.grow.hand.TargetRegManager;
/*     */ import mzm.gsp.role.event.RoleVigorWorkEventProcedure;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnRoleVigorWorkEvent extends RoleVigorWorkEventProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  21 */     int goalType = 2100;
/*  22 */     List<Integer> goals = LevelGuideManager.getGoalIdsByType(goalType);
/*  23 */     if ((goals == null) || (goals.size() == 0))
/*     */     {
/*  25 */       return false;
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
/*     */ 
/*     */ 
/*     */ 
/*  67 */     for (Iterator i$ = goals.iterator(); i$.hasNext();) { int goalId = ((Integer)i$.next()).intValue();
/*     */       
/*  69 */       new PVigorWork(((Long)this.arg).longValue(), goalId).execute();
/*     */     }
/*     */     
/*  72 */     return true;
/*     */   }
/*     */   
/*     */   class PVigorWork
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int goalId;
/*     */     
/*     */     public PVigorWork(long roleId, int goalId)
/*     */     {
/*  83 */       this.roleId = roleId;
/*  84 */       this.goalId = goalId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  91 */       String userId = RoleInterface.getUserId(this.roleId);
/*  92 */       lock(Lockeys.get(User.getTable(), userId));
/*  93 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  94 */       SLevelTargetCfg cfg = LevelGuideManager.getGoalCfg(this.goalId);
/*  95 */       if (cfg == null)
/*     */       {
/*  97 */         return false;
/*     */       }
/*  99 */       int moduleType = cfg.moduleType;
/* 100 */       TargetHandle handler = TargetRegManager.getHanler(moduleType);
/* 101 */       if (handler == null)
/*     */       {
/* 103 */         return false;
/*     */       }
/* 105 */       if (!handler.isGoalValid(this.roleId, this.goalId))
/*     */       {
/* 107 */         return false;
/*     */       }
/* 109 */       int xNum = handler.getParam(this.roleId, this.goalId);
/* 110 */       if (xNum < 0)
/*     */       {
/* 112 */         return false;
/*     */       }
/* 114 */       handler.setParam(this.roleId, this.goalId, xNum + 1);
/* 115 */       List<GoalParameter> goalParameters = cfg.goalParameters;
/* 116 */       int count = ((GoalParameter)goalParameters.get(0)).parameter;
/* 117 */       if (count < 0)
/*     */       {
/* 119 */         return false;
/*     */       }
/* 121 */       if (xNum + 1 >= count)
/*     */       {
/* 123 */         if (!handler.onCanFinishTarget(this.roleId, this.goalId))
/*     */         {
/* 125 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 129 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnRoleVigorWorkEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */