/*     */ package mzm.gsp.grow.LevelGuide;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.gang.event.CreateGangProcedure;
/*     */ import mzm.gsp.gang.event.GangArg;
/*     */ import mzm.gsp.grow.confbean.GoalParameter;
/*     */ import mzm.gsp.grow.confbean.SLevelTargetCfg;
/*     */ import mzm.gsp.grow.hand.TargetHandle;
/*     */ import mzm.gsp.grow.hand.TargetRegManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.LevelGuideInfo;
/*     */ import xbean.RoleLevelGuidesInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2levelguide;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ public class POnJoinGang
/*     */   extends CreateGangProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  28 */     long roleId = ((GangArg)this.arg).roleId;
/*  29 */     int goalType = 900;
/*  30 */     List<Integer> goals = LevelGuideManager.getGoalIdsByType(goalType);
/*  31 */     if ((goals == null) || (goals.size() == 0))
/*     */     {
/*  33 */       return false;
/*     */     }
/*     */     
/*  36 */     for (Iterator i$ = goals.iterator(); i$.hasNext();) { int goalId = ((Integer)i$.next()).intValue();
/*     */       
/*  38 */       new PJoinFaction(roleId, goalId).execute();
/*     */     }
/*     */     
/*  41 */     return true;
/*     */   }
/*     */   
/*     */   class PJoinGang
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int goalId;
/*     */     
/*     */     public PJoinGang(long roleId, int goalId)
/*     */     {
/*  52 */       this.roleId = roleId;
/*  53 */       this.goalId = goalId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  59 */       RoleLevelGuidesInfo xGuidesInfo = Role2levelguide.get(Long.valueOf(this.roleId));
/*  60 */       if (xGuidesInfo == null)
/*     */       {
/*  62 */         return false;
/*     */       }
/*  64 */       LevelGuideInfo xInfo = LevelGuideManager.getXInfo(this.goalId, xGuidesInfo);
/*  65 */       if (xInfo.getTargetstate() != 1)
/*     */       {
/*  67 */         return false;
/*     */       }
/*  69 */       int needAddNum = 1;
/*  70 */       int xNum = xInfo.getTargetparam();
/*     */       
/*  72 */       xInfo.setTargetparam(xNum + needAddNum);
/*     */       
/*  74 */       int count = 1;
/*     */       
/*  76 */       if (xInfo.getTargetparam() >= count)
/*     */       {
/*  78 */         LogicProcedure p = new PFinishLevelGoal(this.roleId, this.goalId);
/*  79 */         if (!p.call())
/*     */         {
/*  81 */           return false;
/*     */         }
/*     */       }
/*  84 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   class PJoinFaction
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int goalId;
/*     */     
/*     */     public PJoinFaction(long roleId, int goalId)
/*     */     {
/*  97 */       this.roleId = roleId;
/*  98 */       this.goalId = goalId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 105 */       String userId = RoleInterface.getUserId(this.roleId);
/* 106 */       lock(Lockeys.get(User.getTable(), userId));
/* 107 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 108 */       SLevelTargetCfg cfg = LevelGuideManager.getGoalCfg(this.goalId);
/* 109 */       if (cfg == null)
/*     */       {
/* 111 */         return false;
/*     */       }
/* 113 */       int moduleType = cfg.moduleType;
/* 114 */       TargetHandle handler = TargetRegManager.getHanler(moduleType);
/* 115 */       if (handler == null)
/*     */       {
/* 117 */         return false;
/*     */       }
/* 119 */       if (!handler.isGoalValid(this.roleId, this.goalId))
/*     */       {
/* 121 */         return false;
/*     */       }
/* 123 */       int xNum = handler.getParam(this.roleId, this.goalId);
/* 124 */       if (xNum < 0)
/*     */       {
/* 126 */         return false;
/*     */       }
/* 128 */       handler.setParam(this.roleId, this.goalId, xNum + 1);
/* 129 */       List<GoalParameter> goalParameters = cfg.goalParameters;
/* 130 */       int count = ((GoalParameter)goalParameters.get(0)).parameter;
/* 131 */       if (count < 0)
/*     */       {
/* 133 */         return false;
/*     */       }
/* 135 */       if (xNum + 1 >= count)
/*     */       {
/* 137 */         if (!handler.onCanFinishTarget(this.roleId, this.goalId))
/*     */         {
/* 139 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 143 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnJoinGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */