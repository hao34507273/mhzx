/*     */ package mzm.gsp.grow.LevelGuide;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.grow.confbean.GoalParameter;
/*     */ import mzm.gsp.grow.confbean.SLevelTargetCfg;
/*     */ import mzm.gsp.grow.hand.TargetHandle;
/*     */ import mzm.gsp.pet.event.PetEventArg;
/*     */ import mzm.gsp.pet.event.PetHuaShengProcedure;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnPetHuaSheng extends PetHuaShengProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  21 */     int goalType = 4;
/*  22 */     List<Integer> goals = LevelGuideManager.getGoalIdsByType(goalType);
/*  23 */     if ((goals == null) || (goals.size() == 0))
/*     */     {
/*  25 */       return false;
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
/*  64 */     for (Iterator i$ = goals.iterator(); i$.hasNext();) { int goalId = ((Integer)i$.next()).intValue();
/*     */       
/*  66 */       new PPetHuaSheng(((PetEventArg)this.arg).roleId, goalId).execute();
/*     */     }
/*     */     
/*  69 */     return true;
/*     */   }
/*     */   
/*     */   class PPetHuaSheng
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int goalId;
/*     */     
/*     */     public PPetHuaSheng(long roleId, int goalId)
/*     */     {
/*  80 */       this.roleId = roleId;
/*  81 */       this.goalId = goalId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  88 */       String userId = RoleInterface.getUserId(this.roleId);
/*  89 */       lock(Lockeys.get(User.getTable(), userId));
/*  90 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  91 */       SLevelTargetCfg cfg = LevelGuideManager.getGoalCfg(this.goalId);
/*  92 */       if (cfg == null)
/*     */       {
/*  94 */         return false;
/*     */       }
/*  96 */       int moduleType = cfg.moduleType;
/*  97 */       TargetHandle handler = mzm.gsp.grow.hand.TargetRegManager.getHanler(moduleType);
/*  98 */       if (handler == null)
/*     */       {
/* 100 */         return false;
/*     */       }
/* 102 */       if (!handler.isGoalValid(this.roleId, this.goalId))
/*     */       {
/* 104 */         return false;
/*     */       }
/* 106 */       int xNum = handler.getParam(this.roleId, this.goalId);
/* 107 */       if (xNum < 0)
/*     */       {
/* 109 */         return false;
/*     */       }
/* 111 */       handler.setParam(this.roleId, this.goalId, xNum + 1);
/* 112 */       List<GoalParameter> goalParameters = cfg.goalParameters;
/* 113 */       int count = ((GoalParameter)goalParameters.get(0)).parameter;
/* 114 */       if (count < 0)
/*     */       {
/* 116 */         return false;
/*     */       }
/* 118 */       if (xNum + 1 >= count)
/*     */       {
/* 120 */         if (!handler.onCanFinishTarget(this.roleId, this.goalId))
/*     */         {
/* 122 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 126 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnPetHuaSheng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */