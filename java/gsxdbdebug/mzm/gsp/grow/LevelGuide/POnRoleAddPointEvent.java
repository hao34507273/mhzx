/*     */ package mzm.gsp.grow.LevelGuide;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.grow.confbean.GoalParameter;
/*     */ import mzm.gsp.grow.confbean.SLevelTargetCfg;
/*     */ import mzm.gsp.grow.hand.TargetHandle;
/*     */ import mzm.gsp.grow.hand.TargetRegManager;
/*     */ import mzm.gsp.role.event.RoleAddPointArg;
/*     */ import mzm.gsp.role.event.RoleAddPointEventProcedure;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnRoleAddPointEvent
/*     */   extends RoleAddPointEventProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  27 */     if (((RoleAddPointArg)this.arg).isAuto)
/*     */     {
/*  29 */       return false;
/*     */     }
/*  31 */     int goalType = 3300;
/*  32 */     List<Integer> goals = LevelGuideManager.getGoalIdsByType(goalType);
/*  33 */     if ((goals == null) || (goals.size() == 0))
/*     */     {
/*  35 */       return false;
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
/*  77 */     for (Iterator i$ = goals.iterator(); i$.hasNext();) { int goalId = ((Integer)i$.next()).intValue();
/*     */       
/*  79 */       new PRoleAddPoint(((RoleAddPointArg)this.arg).roleId, goalId).execute();
/*     */     }
/*     */     
/*  82 */     return true;
/*     */   }
/*     */   
/*     */   class PRoleAddPoint
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int goalId;
/*     */     
/*     */     public PRoleAddPoint(long roleId, int goalId)
/*     */     {
/*  93 */       this.roleId = roleId;
/*  94 */       this.goalId = goalId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 101 */       String userId = RoleInterface.getUserId(this.roleId);
/* 102 */       lock(Lockeys.get(User.getTable(), userId));
/* 103 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 104 */       SLevelTargetCfg cfg = LevelGuideManager.getGoalCfg(this.goalId);
/* 105 */       if (cfg == null)
/*     */       {
/* 107 */         return false;
/*     */       }
/* 109 */       int moduleType = cfg.moduleType;
/* 110 */       TargetHandle handler = TargetRegManager.getHanler(moduleType);
/* 111 */       if (handler == null)
/*     */       {
/* 113 */         return false;
/*     */       }
/* 115 */       if (!handler.isGoalValid(this.roleId, this.goalId))
/*     */       {
/* 117 */         return false;
/*     */       }
/* 119 */       int xNum = handler.getParam(this.roleId, this.goalId);
/* 120 */       if (xNum < 0)
/*     */       {
/* 122 */         return false;
/*     */       }
/* 124 */       handler.setParam(this.roleId, this.goalId, xNum + 1);
/* 125 */       List<GoalParameter> goalParameters = cfg.goalParameters;
/* 126 */       int count = ((GoalParameter)goalParameters.get(0)).parameter;
/* 127 */       if (count < 0)
/*     */       {
/* 129 */         return false;
/*     */       }
/* 131 */       if (xNum + 1 >= count)
/*     */       {
/* 133 */         if (!handler.onCanFinishTarget(this.roleId, this.goalId))
/*     */         {
/* 135 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 139 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnRoleAddPointEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */