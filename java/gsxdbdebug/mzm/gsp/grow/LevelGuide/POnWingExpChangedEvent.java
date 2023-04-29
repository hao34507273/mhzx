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
/*     */ import mzm.gsp.wing.event.WingExpChangedArg;
/*     */ import mzm.gsp.wing.event.WingExpChangedEventProcedure;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnWingExpChangedEvent
/*     */   extends WingExpChangedEventProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  27 */     if (!((WingExpChangedArg)this.arg).lvUp())
/*     */     {
/*  29 */       return false;
/*     */     }
/*     */     
/*  32 */     int goalType = 3901;
/*  33 */     List<Integer> goals = LevelGuideManager.getGoalIdsByType(goalType);
/*  34 */     if ((goals == null) || (goals.size() == 0))
/*     */     {
/*  36 */       return false;
/*     */     }
/*     */     
/*  39 */     for (Iterator i$ = goals.iterator(); i$.hasNext();) { int goalId = ((Integer)i$.next()).intValue();
/*     */       
/*  41 */       new PWingLvUp(((WingExpChangedArg)this.arg).getRoleId(), goalId).execute();
/*     */     }
/*     */     
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   class PWingLvUp
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int goalId;
/*     */     
/*     */     public PWingLvUp(long roleId, int goalId)
/*     */     {
/*  55 */       this.roleId = roleId;
/*  56 */       this.goalId = goalId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  63 */       String userId = RoleInterface.getUserId(this.roleId);
/*  64 */       lock(Lockeys.get(User.getTable(), userId));
/*  65 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  66 */       SLevelTargetCfg cfg = LevelGuideManager.getGoalCfg(this.goalId);
/*  67 */       if (cfg == null)
/*     */       {
/*  69 */         return false;
/*     */       }
/*  71 */       int moduleType = cfg.moduleType;
/*  72 */       TargetHandle handler = TargetRegManager.getHanler(moduleType);
/*  73 */       if (handler == null)
/*     */       {
/*  75 */         return false;
/*     */       }
/*  77 */       if (!handler.isGoalValid(this.roleId, this.goalId))
/*     */       {
/*  79 */         return false;
/*     */       }
/*  81 */       int xNum = handler.getParam(this.roleId, this.goalId);
/*  82 */       if (xNum < 0)
/*     */       {
/*  84 */         return false;
/*     */       }
/*  86 */       handler.setParam(this.roleId, this.goalId, xNum + 1);
/*  87 */       List<GoalParameter> goalParameters = cfg.goalParameters;
/*  88 */       int count = ((GoalParameter)goalParameters.get(0)).parameter;
/*  89 */       if (count < 0)
/*     */       {
/*  91 */         return false;
/*     */       }
/*  93 */       if (xNum + 1 >= count)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnWingExpChangedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */