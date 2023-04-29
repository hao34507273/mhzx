/*    */ package mzm.gsp.grow.LevelGuide;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import mzm.gsp.grow.confbean.GoalParameter;
/*    */ import mzm.gsp.grow.confbean.SLevelTargetCfg;
/*    */ import mzm.gsp.grow.hand.TargetHandle;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PActivityGoal extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int goalId;
/*    */   private final int activityId;
/*    */   private final int dieMonsterNum;
/*    */   
/*    */   public PActivityGoal(long roleId, int goalId, int activityId, int dieMonsterNum)
/*    */   {
/* 23 */     this.roleId = roleId;
/* 24 */     this.goalId = goalId;
/* 25 */     this.activityId = activityId;
/* 26 */     this.dieMonsterNum = dieMonsterNum;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 33 */     String userId = RoleInterface.getUserId(this.roleId);
/* 34 */     lock(Lockeys.get(User.getTable(), userId));
/* 35 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 36 */     SLevelTargetCfg cfg = LevelGuideManager.getGoalCfg(this.goalId);
/* 37 */     if (cfg == null)
/*    */     {
/* 39 */       return false;
/*    */     }
/* 41 */     int moduleType = cfg.moduleType;
/* 42 */     TargetHandle handler = mzm.gsp.grow.hand.TargetRegManager.getHanler(moduleType);
/* 43 */     if (handler == null)
/*    */     {
/* 45 */       return false;
/*    */     }
/* 47 */     if (!handler.isGoalValid(this.roleId, this.goalId))
/*    */     {
/* 49 */       return false;
/*    */     }
/* 51 */     int needAddNum = 1;
/* 52 */     if (this.dieMonsterNum > 0)
/*    */     {
/* 54 */       needAddNum = this.dieMonsterNum;
/*    */     }
/* 56 */     int xNum = handler.getParam(this.roleId, this.goalId);
/*    */     
/* 58 */     int realAdd = xNum + needAddNum;
/*    */     
/* 60 */     handler.setParam(this.roleId, this.goalId, realAdd);
/*    */     
/* 62 */     List<GoalParameter> goalParameters = cfg.goalParameters;
/* 63 */     int count = ((GoalParameter)goalParameters.get(1)).parameter;
/* 64 */     if (count < 0)
/*    */     {
/* 66 */       return false;
/*    */     }
/* 68 */     int killNum = ((GoalParameter)goalParameters.get(2)).parameter;
/* 69 */     if (killNum > 0)
/*    */     {
/* 71 */       count = killNum;
/*    */     }
/* 73 */     if (realAdd >= count)
/*    */     {
/* 75 */       if (!handler.onCanFinishTarget(this.roleId, this.goalId)) {
/* 76 */         return false;
/*    */       }
/*    */     }
/* 79 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\PActivityGoal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */