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
/*     */ import mzm.gsp.zhenfa.event.ZhenfaLevelUpArg;
/*     */ import mzm.gsp.zhenfa.event.ZhenfaLevelUpProcedure;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnZhenFaLvChange
/*     */   extends ZhenfaLevelUpProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  27 */     int goalType = 3302;
/*     */     
/*  29 */     List<Integer> goals = LevelGuideManager.getGoalIdsByType(goalType);
/*  30 */     if ((goals == null) || (goals.size() == 0))
/*     */     {
/*  32 */       return false;
/*     */     }
/*     */     
/*  35 */     for (Iterator i$ = goals.iterator(); i$.hasNext();) { int goalId = ((Integer)i$.next()).intValue();
/*     */       
/*  37 */       new PZhenfaLvUp(((ZhenfaLevelUpArg)this.arg).roleId, goalId).execute();
/*     */     }
/*     */     
/*  40 */     return true;
/*     */   }
/*     */   
/*     */   class PZhenfaLvUp
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int goalId;
/*     */     
/*     */     public PZhenfaLvUp(long roleId, int goalId)
/*     */     {
/*  51 */       this.roleId = roleId;
/*  52 */       this.goalId = goalId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  58 */       int addLv = ((ZhenfaLevelUpArg)POnZhenFaLvChange.this.arg).newLevel - ((ZhenfaLevelUpArg)POnZhenFaLvChange.this.arg).oldLevel;
/*  59 */       if (addLv <= 0)
/*     */       {
/*  61 */         return false;
/*     */       }
/*     */       
/*  64 */       String userId = RoleInterface.getUserId(this.roleId);
/*  65 */       lock(Lockeys.get(User.getTable(), userId));
/*  66 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  67 */       SLevelTargetCfg cfg = LevelGuideManager.getGoalCfg(this.goalId);
/*  68 */       if (cfg == null)
/*     */       {
/*  70 */         return false;
/*     */       }
/*  72 */       int moduleType = cfg.moduleType;
/*  73 */       TargetHandle handler = TargetRegManager.getHanler(moduleType);
/*  74 */       if (handler == null)
/*     */       {
/*  76 */         return false;
/*     */       }
/*  78 */       if (!handler.isGoalValid(this.roleId, this.goalId))
/*     */       {
/*  80 */         return false;
/*     */       }
/*  82 */       List<GoalParameter> goalParameters = cfg.goalParameters;
/*  83 */       if (goalParameters.size() < 2)
/*     */       {
/*  85 */         return false;
/*     */       }
/*  87 */       int cfgZhenFaId = ((GoalParameter)goalParameters.get(0)).parameter;
/*  88 */       if ((cfgZhenFaId > 0) && (cfgZhenFaId != ((ZhenfaLevelUpArg)POnZhenFaLvChange.this.arg).zhenfaId))
/*     */       {
/*  90 */         return false;
/*     */       }
/*  92 */       int cfgAddLv = ((GoalParameter)goalParameters.get(1)).parameter;
/*  93 */       if (cfgAddLv < 0)
/*     */       {
/*  95 */         return false;
/*     */       }
/*  97 */       int dbLv = handler.getParam(this.roleId, this.goalId);
/*  98 */       if (dbLv < 0)
/*     */       {
/* 100 */         return false;
/*     */       }
/* 102 */       handler.setParam(this.roleId, this.goalId, dbLv + addLv);
/* 103 */       if (dbLv + addLv >= cfgAddLv)
/*     */       {
/* 105 */         if (!handler.onCanFinishTarget(this.roleId, this.goalId))
/*     */         {
/* 107 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 111 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnZhenFaLvChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */