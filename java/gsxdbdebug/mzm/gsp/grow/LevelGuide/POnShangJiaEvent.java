/*     */ package mzm.gsp.grow.LevelGuide;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.baitan.event.ShangJiaArg;
/*     */ import mzm.gsp.baitan.event.ShangJiaEventProcedure;
/*     */ import mzm.gsp.grow.confbean.GoalParameter;
/*     */ import mzm.gsp.grow.confbean.SLevelTargetCfg;
/*     */ import mzm.gsp.grow.hand.TargetHandle;
/*     */ import mzm.gsp.grow.hand.TargetRegManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnShangJiaEvent
/*     */   extends ShangJiaEventProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  27 */     shangJiaCount();
/*     */     
/*  29 */     shangJiaItemCount();
/*     */     
/*  31 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void shangJiaCount()
/*     */   {
/*  39 */     int goalType = 1500;
/*  40 */     List<Integer> goals = LevelGuideManager.getGoalIdsByType(goalType);
/*  41 */     if ((goals == null) || (goals.size() == 0))
/*     */     {
/*  43 */       return;
/*     */     }
/*     */     
/*  46 */     for (Iterator i$ = goals.iterator(); i$.hasNext();) { int goalId = ((Integer)i$.next()).intValue();
/*     */       
/*  48 */       new PShangJiaCount(((ShangJiaArg)this.arg).roleId, goalId).execute();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void shangJiaItemCount()
/*     */   {
/*  57 */     int goalType = 1507;
/*  58 */     List<Integer> goals = LevelGuideManager.getGoalIdsByType(goalType);
/*  59 */     if ((goals == null) || (goals.size() == 0))
/*     */     {
/*  61 */       return;
/*     */     }
/*     */     
/*  64 */     for (Iterator i$ = goals.iterator(); i$.hasNext();) { int goalId = ((Integer)i$.next()).intValue();
/*     */       
/*  66 */       new PShangJiaItemNum(((ShangJiaArg)this.arg).roleId, goalId).execute();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   class PShangJiaCount
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     
/*     */ 
/*     */     private final int goalId;
/*     */     
/*     */ 
/*     */ 
/*     */     public PShangJiaCount(long roleId, int goalId)
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
/* 110 */       int xNum = handler.getParam(this.roleId, this.goalId);
/* 111 */       if (xNum < 0)
/*     */       {
/* 113 */         return false;
/*     */       }
/* 115 */       int needAddCount = getNeedAddNum();
/* 116 */       handler.setParam(this.roleId, this.goalId, xNum + needAddCount);
/* 117 */       List<GoalParameter> goalParameters = cfg.goalParameters;
/* 118 */       int count = getCfgNeedCount(goalParameters);
/* 119 */       if (count < 0)
/*     */       {
/* 121 */         return false;
/*     */       }
/* 123 */       if (xNum + needAddCount >= count)
/*     */       {
/* 125 */         if (!handler.onCanFinishTarget(this.roleId, this.goalId))
/*     */         {
/* 127 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 131 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     int getNeedAddNum()
/*     */     {
/* 141 */       return 1;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     int getCfgNeedCount(List<GoalParameter> goalParameters)
/*     */     {
/* 152 */       return ((GoalParameter)goalParameters.get(0)).parameter;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   class PShangJiaItemNum
/*     */     extends POnShangJiaEvent.PShangJiaCount
/*     */   {
/*     */     public PShangJiaItemNum(long roleId, int goalId)
/*     */     {
/* 168 */       super(roleId, goalId);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     int getNeedAddNum()
/*     */     {
/* 179 */       return ((ShangJiaArg)POnShangJiaEvent.this.arg).num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     int getCfgNeedCount(List<GoalParameter> goalParameters)
/*     */     {
/* 191 */       return ((GoalParameter)goalParameters.get(0)).parameter;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnShangJiaEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */