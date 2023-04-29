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
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.wing.event.WingPhaseUpArg;
/*     */ import mzm.gsp.wing.event.WingPhaseUpEventProcedure;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnWingPhaseUpEvent
/*     */   extends WingPhaseUpEventProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  27 */     int goalType = 3902;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  78 */     for (Iterator i$ = goals.iterator(); i$.hasNext();) { int goalId = ((Integer)i$.next()).intValue();
/*     */       
/*  80 */       new PWingPhaseUp(((WingPhaseUpArg)this.arg).getRoleid(), goalId).execute();
/*     */     }
/*     */     
/*  83 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean canChangeParam(int oldRank, int newRank, int wingRankCfg)
/*     */   {
/*  96 */     if (wingRankCfg <= 0)
/*     */     {
/*  98 */       return true;
/*     */     }
/* 100 */     if ((oldRank < wingRankCfg) && (newRank >= wingRankCfg))
/*     */     {
/* 102 */       return true;
/*     */     }
/* 104 */     return false;
/*     */   }
/*     */   
/*     */   class PWingPhaseUp
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int goalId;
/*     */     
/*     */     public PWingPhaseUp(long roleId, int goalId)
/*     */     {
/* 115 */       this.roleId = roleId;
/* 116 */       this.goalId = goalId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 123 */       String userId = RoleInterface.getUserId(this.roleId);
/* 124 */       lock(Lockeys.get(User.getTable(), userId));
/* 125 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 126 */       SLevelTargetCfg cfg = LevelGuideManager.getGoalCfg(this.goalId);
/* 127 */       if (cfg == null)
/*     */       {
/* 129 */         return false;
/*     */       }
/* 131 */       int moduleType = cfg.moduleType;
/* 132 */       TargetHandle handler = TargetRegManager.getHanler(moduleType);
/* 133 */       if (handler == null)
/*     */       {
/* 135 */         return false;
/*     */       }
/* 137 */       if (!handler.isGoalValid(this.roleId, this.goalId))
/*     */       {
/* 139 */         return false;
/*     */       }
/* 141 */       if (!POnWingPhaseUpEvent.this.canChangeParam(((WingPhaseUpArg)POnWingPhaseUpEvent.this.arg).getOldphase(), ((WingPhaseUpArg)POnWingPhaseUpEvent.this.arg).getNewphase(), 0))
/*     */       {
/* 143 */         return false;
/*     */       }
/* 145 */       int xNum = handler.getParam(this.roleId, this.goalId);
/* 146 */       if (xNum < 0)
/*     */       {
/* 148 */         return false;
/*     */       }
/* 150 */       handler.setParam(this.roleId, this.goalId, xNum + 1);
/* 151 */       List<GoalParameter> goalParameters = cfg.goalParameters;
/* 152 */       int count = ((GoalParameter)goalParameters.get(0)).parameter;
/* 153 */       if (count < 0)
/*     */       {
/* 155 */         return false;
/*     */       }
/* 157 */       if (xNum + 1 >= count)
/*     */       {
/* 159 */         if (!handler.onCanFinishTarget(this.roleId, this.goalId))
/*     */         {
/* 161 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 165 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnWingPhaseUpEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */