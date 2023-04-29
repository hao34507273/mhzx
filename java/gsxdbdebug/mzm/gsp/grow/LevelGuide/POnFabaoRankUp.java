/*     */ package mzm.gsp.grow.LevelGuide;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.fabao.event.FabaoRankUpArg;
/*     */ import mzm.gsp.fabao.event.FabaoRankUpProcedure;
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
/*     */ public class POnFabaoRankUp
/*     */   extends FabaoRankUpProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  27 */     int goalType = 4202;
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
/*  71 */     for (Iterator i$ = goals.iterator(); i$.hasNext();) { int goalId = ((Integer)i$.next()).intValue();
/*     */       
/*  73 */       new PFaRankUp(((FabaoRankUpArg)this.arg).getRoleId(), goalId).execute();
/*     */     }
/*  75 */     return true;
/*     */   }
/*     */   
/*     */   class PFaRankUp
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int goalId;
/*     */     
/*     */     public PFaRankUp(long roleId, int goalId)
/*     */     {
/*  86 */       this.roleId = roleId;
/*  87 */       this.goalId = goalId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  94 */       String userId = RoleInterface.getUserId(this.roleId);
/*  95 */       lock(Lockeys.get(User.getTable(), userId));
/*  96 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  97 */       SLevelTargetCfg cfg = LevelGuideManager.getGoalCfg(this.goalId);
/*  98 */       if (cfg == null)
/*     */       {
/* 100 */         return false;
/*     */       }
/* 102 */       int moduleType = cfg.moduleType;
/* 103 */       TargetHandle handler = TargetRegManager.getHanler(moduleType);
/* 104 */       if (handler == null)
/*     */       {
/* 106 */         return false;
/*     */       }
/* 108 */       if (!handler.isGoalValid(this.roleId, this.goalId))
/*     */       {
/* 110 */         return false;
/*     */       }
/* 112 */       List<GoalParameter> goalParameters = cfg.goalParameters;
/* 113 */       int rank = ((GoalParameter)goalParameters.get(0)).parameter;
/* 114 */       if (rank < 0)
/*     */       {
/* 116 */         return false;
/*     */       }
/* 118 */       int realRank = ((FabaoRankUpArg)POnFabaoRankUp.this.arg).getCurRank() + 1;
/* 119 */       if (realRank >= rank)
/*     */       {
/* 121 */         if (!handler.onCanFinishTarget(this.roleId, this.goalId))
/*     */         {
/* 123 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 127 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnFabaoRankUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */