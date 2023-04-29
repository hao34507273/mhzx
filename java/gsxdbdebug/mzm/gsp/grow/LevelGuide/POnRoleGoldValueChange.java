/*     */ package mzm.gsp.grow.LevelGuide;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.grow.confbean.GoalParameter;
/*     */ import mzm.gsp.grow.confbean.SLevelTargetCfg;
/*     */ import mzm.gsp.grow.hand.TargetHandle;
/*     */ import mzm.gsp.role.event.GoldValueChangeProcedure;
/*     */ import mzm.gsp.role.event.MoneyChangeArg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnRoleGoldValueChange extends GoldValueChangeProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  21 */     long roleId = ((MoneyChangeArg)this.arg).getRoleId();
/*  22 */     int cutValue = (int)(((MoneyChangeArg)this.arg).getOldValue() - ((MoneyChangeArg)this.arg).getNewValue());
/*  23 */     if (cutValue <= 0)
/*     */     {
/*  25 */       return false;
/*     */     }
/*  27 */     int goalType = 4700;
/*  28 */     List<Integer> goals = LevelGuideManager.getGoalIdsByType(goalType);
/*  29 */     if ((goals == null) || (goals.size() == 0))
/*     */     {
/*  31 */       return false;
/*     */     }
/*     */     
/*  34 */     for (Iterator i$ = goals.iterator(); i$.hasNext();) { int goalId = ((Integer)i$.next()).intValue();
/*     */       
/*  36 */       new PCostGold(roleId, cutValue, goalId).execute();
/*     */     }
/*     */     
/*  39 */     return true;
/*     */   }
/*     */   
/*     */   class PCostGold extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int cutValue;
/*     */     private final int goalId;
/*     */     
/*     */     public PCostGold(long roleId, int cutValue, int goalId)
/*     */     {
/*  50 */       this.roleId = roleId;
/*  51 */       this.cutValue = cutValue;
/*  52 */       this.goalId = goalId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  59 */       String userId = RoleInterface.getUserId(this.roleId);
/*  60 */       lock(Lockeys.get(User.getTable(), userId));
/*  61 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  62 */       SLevelTargetCfg cfg = LevelGuideManager.getGoalCfg(this.goalId);
/*  63 */       if (cfg == null)
/*     */       {
/*  65 */         return false;
/*     */       }
/*  67 */       int moduleType = cfg.moduleType;
/*  68 */       TargetHandle handler = mzm.gsp.grow.hand.TargetRegManager.getHanler(moduleType);
/*  69 */       if (handler == null)
/*     */       {
/*  71 */         return false;
/*     */       }
/*  73 */       if (!handler.isGoalValid(this.roleId, this.goalId))
/*     */       {
/*  75 */         return false;
/*     */       }
/*  77 */       int xCutValue = handler.getParam(this.roleId, this.goalId);
/*  78 */       if (xCutValue < 0)
/*     */       {
/*  80 */         return false;
/*     */       }
/*  82 */       handler.setParam(this.roleId, this.goalId, xCutValue + this.cutValue);
/*  83 */       List<GoalParameter> goalParameters = cfg.goalParameters;
/*  84 */       if (goalParameters.size() < 1)
/*     */       {
/*  86 */         return false;
/*     */       }
/*  88 */       int needCutValue = ((GoalParameter)goalParameters.get(0)).parameter;
/*  89 */       if (needCutValue < 0)
/*     */       {
/*  91 */         return false;
/*     */       }
/*  93 */       if (xCutValue + this.cutValue >= needCutValue)
/*     */       {
/*  95 */         if (!handler.onCanFinishTarget(this.roleId, this.goalId))
/*     */         {
/*  97 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 101 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnRoleGoldValueChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */