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
/*     */ public class POnLianYaoSkillLevelUpEvent extends LifeSkillLevelUpEventProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  22 */     if (((LifeSkillLevelUpArg)this.arg).lifeSkillType != 2)
/*     */     {
/*  24 */       return false;
/*     */     }
/*  26 */     int goalType = 1803;
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
/*  70 */       new PUnlockAllLianYao(((LifeSkillLevelUpArg)this.arg).roleId, goalId).execute();
/*     */     }
/*     */     
/*  73 */     return true;
/*     */   }
/*     */   
/*     */   class PUnlockAllLianYao
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int goalId;
/*     */     
/*     */     public PUnlockAllLianYao(long roleId, int goalId)
/*     */     {
/*  84 */       this.roleId = roleId;
/*  85 */       this.goalId = goalId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  92 */       String userId = RoleInterface.getUserId(this.roleId);
/*  93 */       lock(Lockeys.get(User.getTable(), userId));
/*  94 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  95 */       SLevelTargetCfg cfg = LevelGuideManager.getGoalCfg(this.goalId);
/*  96 */       if (cfg == null)
/*     */       {
/*  98 */         return false;
/*     */       }
/* 100 */       int moduleType = cfg.moduleType;
/* 101 */       TargetHandle handler = TargetRegManager.getHanler(moduleType);
/* 102 */       if (handler == null)
/*     */       {
/* 104 */         return false;
/*     */       }
/* 106 */       if (!handler.isGoalValid(this.roleId, this.goalId))
/*     */       {
/* 108 */         return false;
/*     */       }
/* 110 */       List<GoalParameter> goalParameters = cfg.goalParameters;
/* 111 */       int count = ((GoalParameter)goalParameters.get(0)).parameter;
/* 112 */       if (count < 0)
/*     */       {
/* 114 */         return false;
/*     */       }
/* 116 */       if (((LifeSkillLevelUpArg)POnLianYaoSkillLevelUpEvent.this.arg).unlockItemNum >= count)
/*     */       {
/* 118 */         if (!handler.onCanFinishTarget(this.roleId, this.goalId))
/*     */         {
/* 120 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 124 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnLianYaoSkillLevelUpEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */