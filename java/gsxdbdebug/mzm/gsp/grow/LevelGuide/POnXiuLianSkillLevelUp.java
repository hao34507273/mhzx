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
/*     */ import mzm.gsp.xiulian.event.XiuLianSkillArg;
/*     */ import mzm.gsp.xiulian.event.XiuLianSkillLevelUpProcedure;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnXiuLianSkillLevelUp
/*     */   extends XiuLianSkillLevelUpProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  27 */     int goalType = 1805;
/*     */     
/*  29 */     List<Integer> goals = LevelGuideManager.getGoalIdsByType(goalType);
/*  30 */     if ((goals == null) || (goals.size() == 0))
/*     */     {
/*  32 */       return false;
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
/*     */ 
/*     */ 
/*     */ 
/*  82 */     for (Iterator i$ = goals.iterator(); i$.hasNext();) { int goalId = ((Integer)i$.next()).intValue();
/*     */       
/*  84 */       new PXiulianLvUp(((XiuLianSkillArg)this.arg).roleId, goalId).execute();
/*     */     }
/*     */     
/*  87 */     return true;
/*     */   }
/*     */   
/*     */   private boolean needAdd(int levelCfg, int oldLevel, int newLevel)
/*     */   {
/*  92 */     if (newLevel < levelCfg)
/*     */     {
/*  94 */       return false;
/*     */     }
/*  96 */     if (oldLevel >= levelCfg)
/*     */     {
/*  98 */       return false;
/*     */     }
/* 100 */     return true;
/*     */   }
/*     */   
/*     */   class PXiulianLvUp
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int goalId;
/*     */     
/*     */     public PXiulianLvUp(long roleId, int goalId)
/*     */     {
/* 111 */       this.roleId = roleId;
/* 112 */       this.goalId = goalId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 119 */       String userId = RoleInterface.getUserId(this.roleId);
/* 120 */       lock(Lockeys.get(User.getTable(), userId));
/* 121 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 122 */       SLevelTargetCfg cfg = LevelGuideManager.getGoalCfg(this.goalId);
/* 123 */       if (cfg == null)
/*     */       {
/* 125 */         return false;
/*     */       }
/* 127 */       int moduleType = cfg.moduleType;
/* 128 */       TargetHandle handler = TargetRegManager.getHanler(moduleType);
/* 129 */       if (handler == null)
/*     */       {
/* 131 */         return false;
/*     */       }
/* 133 */       if (!handler.isGoalValid(this.roleId, this.goalId))
/*     */       {
/* 135 */         return false;
/*     */       }
/* 137 */       List<GoalParameter> goalParameters = cfg.goalParameters;
/* 138 */       int count = ((GoalParameter)goalParameters.get(0)).parameter;
/* 139 */       if (count < 0)
/*     */       {
/* 141 */         return false;
/*     */       }
/* 143 */       int level = ((GoalParameter)goalParameters.get(1)).parameter;
/* 144 */       if (level < 0)
/*     */       {
/* 146 */         return false;
/*     */       }
/* 148 */       if (!POnXiuLianSkillLevelUp.this.needAdd(level, ((XiuLianSkillArg)POnXiuLianSkillLevelUp.this.arg).oldLevel, ((XiuLianSkillArg)POnXiuLianSkillLevelUp.this.arg).newLevel))
/*     */       {
/* 150 */         return false;
/*     */       }
/* 152 */       int xNum = handler.getParam(this.roleId, this.goalId);
/* 153 */       if (xNum < 0)
/*     */       {
/* 155 */         return false;
/*     */       }
/* 157 */       handler.setParam(this.roleId, this.goalId, xNum + 1);
/* 158 */       if (xNum + 1 >= count)
/*     */       {
/* 160 */         if (!handler.onCanFinishTarget(this.roleId, this.goalId))
/*     */         {
/* 162 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 166 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnXiuLianSkillLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */