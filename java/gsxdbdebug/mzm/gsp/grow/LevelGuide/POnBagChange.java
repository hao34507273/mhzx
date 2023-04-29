/*     */ package mzm.gsp.grow.LevelGuide;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.grow.confbean.GoalParameter;
/*     */ import mzm.gsp.grow.confbean.SLevelTargetCfg;
/*     */ import mzm.gsp.grow.hand.TargetHandle;
/*     */ import mzm.gsp.grow.hand.TargetRegManager;
/*     */ import mzm.gsp.item.event.PlayerBagChangeProcedure;
/*     */ import mzm.gsp.item.main.ItemEventArg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnBagChange
/*     */   extends PlayerBagChangeProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  28 */     int goalType = 4200;
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
/*  77 */     for (Iterator i$ = goals.iterator(); i$.hasNext();) { int goalId = ((Integer)i$.next()).intValue();
/*  78 */       new PFabaoOwn(((ItemEventArg)this.arg).roleid, goalId).execute();
/*     */     }
/*     */     
/*  81 */     return true;
/*     */   }
/*     */   
/*     */   class PFabaoOwn
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int goalId;
/*     */     
/*     */     public PFabaoOwn(long roleId, int goalId)
/*     */     {
/*  92 */       this.roleId = roleId;
/*  93 */       this.goalId = goalId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 100 */       String userId = RoleInterface.getUserId(this.roleId);
/* 101 */       lock(Lockeys.get(User.getTable(), userId));
/* 102 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 103 */       SLevelTargetCfg cfg = LevelGuideManager.getGoalCfg(this.goalId);
/* 104 */       if (cfg == null)
/*     */       {
/* 106 */         return false;
/*     */       }
/* 108 */       int moduleType = cfg.moduleType;
/* 109 */       TargetHandle handler = TargetRegManager.getHanler(moduleType);
/* 110 */       if (handler == null)
/*     */       {
/* 112 */         return false;
/*     */       }
/* 114 */       if (!handler.isGoalValid(this.roleId, this.goalId))
/*     */       {
/* 116 */         return false;
/*     */       }
/* 118 */       List<GoalParameter> goalParameters = cfg.goalParameters;
/* 119 */       int count = ((GoalParameter)goalParameters.get(0)).parameter;
/* 120 */       if (count < 0)
/*     */       {
/* 122 */         return false;
/*     */       }
/* 124 */       int fabaoId = ((GoalParameter)goalParameters.get(1)).parameter;
/* 125 */       if (fabaoId < 0)
/*     */       {
/* 127 */         return false;
/*     */       }
/* 129 */       int fabaoItemType = ItemInterface.getItemTypeById(fabaoId);
/* 130 */       int faBaoOwnNum = ItemInterface.getItemNumberByType(((ItemEventArg)POnBagChange.this.arg).roleid, ((ItemEventArg)POnBagChange.this.arg).bagid, fabaoItemType, false);
/* 131 */       if (faBaoOwnNum >= count)
/*     */       {
/* 133 */         if (!handler.onCanFinishTarget(this.roleId, this.goalId)) {
/* 134 */           return false;
/*     */         }
/*     */       }
/* 137 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnBagChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */