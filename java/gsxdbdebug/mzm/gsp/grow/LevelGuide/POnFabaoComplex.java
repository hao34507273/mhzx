/*     */ package mzm.gsp.grow.LevelGuide;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.fabao.event.FabaoComplexArg;
/*     */ import mzm.gsp.fabao.event.FabaoComplexProcedure;
/*     */ import mzm.gsp.grow.confbean.GoalParameter;
/*     */ import mzm.gsp.grow.confbean.SLevelTargetCfg;
/*     */ import mzm.gsp.grow.hand.TargetHandle;
/*     */ import mzm.gsp.grow.hand.TargetRegManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnFabaoComplex
/*     */   extends FabaoComplexProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  27 */     int goalType = 4200;
/*  28 */     List<Integer> goals = LevelGuideManager.getGoalIdsByType(goalType);
/*  29 */     if ((goals == null) || (goals.size() == 0))
/*     */     {
/*  31 */       return false;
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
/*  73 */     for (Iterator i$ = goals.iterator(); i$.hasNext();) { int goalId = ((Integer)i$.next()).intValue();
/*     */       
/*  75 */       new PFaBaoGet(((FabaoComplexArg)this.arg).getRoleId(), goalId).execute();
/*     */     }
/*     */     
/*  78 */     return true;
/*     */   }
/*     */   
/*     */   class PFaBaoGet
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int goalId;
/*     */     
/*     */     public PFaBaoGet(long roleId, int goalId)
/*     */     {
/*  89 */       this.roleId = roleId;
/*  90 */       this.goalId = goalId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  97 */       String userId = RoleInterface.getUserId(this.roleId);
/*  98 */       lock(Lockeys.get(User.getTable(), userId));
/*  99 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 100 */       SLevelTargetCfg cfg = LevelGuideManager.getGoalCfg(this.goalId);
/* 101 */       if (cfg == null)
/*     */       {
/* 103 */         return false;
/*     */       }
/* 105 */       int moduleType = cfg.moduleType;
/* 106 */       TargetHandle handler = TargetRegManager.getHanler(moduleType);
/* 107 */       if (handler == null)
/*     */       {
/* 109 */         return false;
/*     */       }
/* 111 */       if (!handler.isGoalValid(this.roleId, this.goalId))
/*     */       {
/* 113 */         return false;
/*     */       }
/* 115 */       int xNum = handler.getParam(this.roleId, this.goalId);
/* 116 */       if (xNum < 0)
/*     */       {
/* 118 */         return false;
/*     */       }
/* 120 */       handler.setParam(this.roleId, this.goalId, xNum + 1);
/* 121 */       List<GoalParameter> goalParameters = cfg.goalParameters;
/* 122 */       int count = ((GoalParameter)goalParameters.get(0)).parameter;
/* 123 */       if (count < 0)
/*     */       {
/* 125 */         return false;
/*     */       }
/* 127 */       if (xNum + 1 >= count)
/*     */       {
/* 129 */         if (!handler.onCanFinishTarget(this.roleId, this.goalId))
/*     */         {
/* 131 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 135 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnFabaoComplex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */