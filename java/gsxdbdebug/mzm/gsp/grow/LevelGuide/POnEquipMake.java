/*     */ package mzm.gsp.grow.LevelGuide;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.grow.confbean.GoalParameter;
/*     */ import mzm.gsp.grow.confbean.SLevelTargetCfg;
/*     */ import mzm.gsp.grow.hand.TargetHandle;
/*     */ import mzm.gsp.item.event.EquipMakeProcedure;
/*     */ import mzm.gsp.item.main.EquipMakeArg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnEquipMake extends EquipMakeProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  21 */     int goalType = 3000;
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
/*  63 */     for (Iterator i$ = goals.iterator(); i$.hasNext();) { int goalId = ((Integer)i$.next()).intValue();
/*     */       
/*  65 */       new PMakeEquip(((EquipMakeArg)this.arg).roleid, goalId).execute();
/*     */     }
/*     */     
/*  68 */     return true;
/*     */   }
/*     */   
/*     */   class PMakeEquip
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int goalId;
/*     */     
/*     */     public PMakeEquip(long roleId, int goalId)
/*     */     {
/*  79 */       this.roleId = roleId;
/*  80 */       this.goalId = goalId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  87 */       String userId = RoleInterface.getUserId(this.roleId);
/*  88 */       lock(Lockeys.get(User.getTable(), userId));
/*  89 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  90 */       SLevelTargetCfg cfg = LevelGuideManager.getGoalCfg(this.goalId);
/*  91 */       if (cfg == null)
/*     */       {
/*  93 */         return false;
/*     */       }
/*  95 */       int moduleType = cfg.moduleType;
/*  96 */       TargetHandle handler = mzm.gsp.grow.hand.TargetRegManager.getHanler(moduleType);
/*  97 */       if (handler == null)
/*     */       {
/*  99 */         return false;
/*     */       }
/* 101 */       if (!handler.isGoalValid(this.roleId, this.goalId))
/*     */       {
/* 103 */         return false;
/*     */       }
/* 105 */       int xNum = handler.getParam(this.roleId, this.goalId);
/* 106 */       if (xNum < 0)
/*     */       {
/* 108 */         return false;
/*     */       }
/* 110 */       handler.setParam(this.roleId, this.goalId, xNum + 1);
/* 111 */       List<GoalParameter> goalParameters = cfg.goalParameters;
/* 112 */       int count = ((GoalParameter)goalParameters.get(0)).parameter;
/* 113 */       if (count < 0)
/*     */       {
/* 115 */         return false;
/*     */       }
/* 117 */       if (xNum + 1 >= count)
/*     */       {
/* 119 */         if (!handler.onCanFinishTarget(this.roleId, this.goalId))
/*     */         {
/* 121 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 125 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnEquipMake.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */