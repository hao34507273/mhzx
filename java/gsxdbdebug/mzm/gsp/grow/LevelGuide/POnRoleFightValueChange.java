/*     */ package mzm.gsp.grow.LevelGuide;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.grow.confbean.GoalParameter;
/*     */ import mzm.gsp.grow.confbean.SLevelTargetCfg;
/*     */ import mzm.gsp.grow.hand.TargetHandle;
/*     */ import mzm.gsp.grow.hand.TargetRegManager;
/*     */ import mzm.gsp.role.event.FightValueChangeProcedure;
/*     */ import mzm.gsp.role.event.RoleXFightValueChangeArg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnRoleFightValueChange
/*     */   extends FightValueChangeProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  27 */     int goalType = 3303;
/*  28 */     List<Integer> goals = LevelGuideManager.getGoalIdsByType(goalType);
/*  29 */     if ((goals == null) || (goals.size() == 0))
/*     */     {
/*  31 */       return false;
/*     */     }
/*  33 */     for (Iterator i$ = goals.iterator(); i$.hasNext();) { int goalId = ((Integer)i$.next()).intValue();
/*     */       
/*  35 */       new PRoleFVChange(((RoleXFightValueChangeArg)this.arg).getRoleId(), goalId).execute();
/*     */     }
/*     */     
/*  38 */     return true;
/*     */   }
/*     */   
/*     */   class PRoleFVChange
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int goalId;
/*     */     
/*     */     public PRoleFVChange(long roleId, int goalId)
/*     */     {
/*  49 */       this.roleId = roleId;
/*  50 */       this.goalId = goalId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  57 */       String userId = RoleInterface.getUserId(this.roleId);
/*  58 */       lock(Lockeys.get(User.getTable(), userId));
/*  59 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  60 */       SLevelTargetCfg cfg = LevelGuideManager.getGoalCfg(this.goalId);
/*  61 */       if (cfg == null)
/*     */       {
/*  63 */         return false;
/*     */       }
/*  65 */       int moduleType = cfg.moduleType;
/*  66 */       TargetHandle handler = TargetRegManager.getHanler(moduleType);
/*  67 */       if (handler == null)
/*     */       {
/*  69 */         return false;
/*     */       }
/*  71 */       if (!handler.isGoalValid(this.roleId, this.goalId))
/*     */       {
/*  73 */         return false;
/*     */       }
/*  75 */       int xValue = handler.getParam(this.roleId, this.goalId);
/*  76 */       if (xValue < 0)
/*     */       {
/*  78 */         return false;
/*     */       }
/*  80 */       int lastValue = getLastChangeValue(xValue, ((RoleXFightValueChangeArg)POnRoleFightValueChange.this.arg).getNewFightValue(), ((RoleXFightValueChangeArg)POnRoleFightValueChange.this.arg).getOldFightValue());
/*  81 */       handler.setParam(this.roleId, this.goalId, lastValue);
/*  82 */       List<GoalParameter> goalParameters = cfg.goalParameters;
/*  83 */       int fightValueAdd = ((GoalParameter)goalParameters.get(0)).parameter;
/*  84 */       if (fightValueAdd < 0)
/*     */       {
/*  86 */         return false;
/*     */       }
/*  88 */       if (lastValue >= fightValueAdd)
/*     */       {
/*  90 */         if (!handler.onCanFinishTarget(this.roleId, this.goalId))
/*     */         {
/*  92 */           return false;
/*     */         }
/*     */       }
/*     */       
/*  96 */       return true;
/*     */     }
/*     */     
/*     */     int getLastChangeValue(int dbValue, int newFight, int oldFight)
/*     */     {
/* 101 */       return dbValue + getChangeValue(newFight, oldFight);
/*     */     }
/*     */     
/*     */     int getChangeValue(int newFight, int oldFight)
/*     */     {
/* 106 */       return newFight - oldFight;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnRoleFightValueChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */