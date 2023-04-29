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
/*     */ import mzm.gsp.skill.event.MakeFuMoFuProcedure;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnMakeFuMoFu
/*     */   extends MakeFuMoFuProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  27 */     int goalType = 1801;
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
/*  72 */     for (Iterator i$ = goals.iterator(); i$.hasNext();) { int goalId = ((Integer)i$.next()).intValue();
/*     */       
/*  74 */       new PMakeFuMoFu(((Long)this.arg).longValue(), goalId).execute();
/*     */     }
/*     */     
/*  77 */     return true;
/*     */   }
/*     */   
/*     */   class PMakeFuMoFu
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int goalId;
/*     */     
/*     */     public PMakeFuMoFu(long roleId, int goalId)
/*     */     {
/*  88 */       this.roleId = roleId;
/*  89 */       this.goalId = goalId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  96 */       String userId = RoleInterface.getUserId(this.roleId);
/*  97 */       lock(Lockeys.get(User.getTable(), userId));
/*  98 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  99 */       SLevelTargetCfg cfg = LevelGuideManager.getGoalCfg(this.goalId);
/* 100 */       if (cfg == null)
/*     */       {
/* 102 */         return false;
/*     */       }
/* 104 */       int moduleType = cfg.moduleType;
/* 105 */       TargetHandle handler = TargetRegManager.getHanler(moduleType);
/* 106 */       if (handler == null)
/*     */       {
/* 108 */         return false;
/*     */       }
/* 110 */       if (!handler.isGoalValid(this.roleId, this.goalId))
/*     */       {
/* 112 */         return false;
/*     */       }
/* 114 */       int xNum = handler.getParam(this.roleId, this.goalId);
/* 115 */       if (xNum < 0)
/*     */       {
/* 117 */         return false;
/*     */       }
/* 119 */       handler.setParam(this.roleId, this.goalId, xNum + 1);
/* 120 */       List<GoalParameter> goalParameters = cfg.goalParameters;
/* 121 */       int count = ((GoalParameter)goalParameters.get(0)).parameter;
/* 122 */       if (count < 0)
/*     */       {
/* 124 */         return false;
/*     */       }
/* 126 */       if (xNum + 1 >= count)
/*     */       {
/* 128 */         if (!handler.onCanFinishTarget(this.roleId, this.goalId))
/*     */         {
/* 130 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 134 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnMakeFuMoFu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */