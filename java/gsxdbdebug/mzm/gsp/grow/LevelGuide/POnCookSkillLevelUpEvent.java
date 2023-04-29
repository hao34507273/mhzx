/*     */ package mzm.gsp.grow.LevelGuide;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.grow.confbean.GoalParameter;
/*     */ import mzm.gsp.grow.confbean.SLevelTargetCfg;
/*     */ import mzm.gsp.grow.hand.TargetHandle;
/*     */ import mzm.gsp.grow.hand.TargetRegManager;
/*     */ import mzm.gsp.lifeskill.event.LifeSkillLevelUpArg;
/*     */ import mzm.gsp.lifeskill.event.LifeSkillLevelUpEventProcedure;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnCookSkillLevelUpEvent extends LifeSkillLevelUpEventProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  22 */     if (((LifeSkillLevelUpArg)this.arg).lifeSkillType != 1)
/*     */     {
/*  24 */       return false;
/*     */     }
/*  26 */     int goalType = 1804;
/*  27 */     List<Integer> goals = LevelGuideManager.getGoalIdsByType(goalType);
/*  28 */     if ((goals == null) || (goals.size() == 0))
/*     */     {
/*  30 */       return false;
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
/*  68 */     for (Iterator i$ = goals.iterator(); i$.hasNext();) { int goalId = ((Integer)i$.next()).intValue();
/*     */       
/*  70 */       new PCookSkillLvUp(((LifeSkillLevelUpArg)this.arg).roleId, goalId).execute();
/*     */     }
/*     */     
/*  73 */     return true;
/*     */   }
/*     */   
/*     */   class PCookSkillLvUp extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int goalId;
/*     */     
/*     */     public PCookSkillLvUp(long roleId, int goalId)
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
/* 109 */       List<GoalParameter> goalParameters = cfg.goalParameters;
/* 110 */       int count = ((GoalParameter)goalParameters.get(0)).parameter;
/* 111 */       if (count < 0)
/*     */       {
/* 113 */         return false;
/*     */       }
/* 115 */       if (((LifeSkillLevelUpArg)POnCookSkillLevelUpEvent.this.arg).unlockItemNum >= count)
/*     */       {
/* 117 */         if (!handler.onCanFinishTarget(this.roleId, this.goalId))
/*     */         {
/* 119 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 123 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnCookSkillLevelUpEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */