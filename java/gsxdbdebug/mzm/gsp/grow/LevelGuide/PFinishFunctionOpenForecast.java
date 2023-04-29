/*    */ package mzm.gsp.grow.LevelGuide;
/*    */ 
/*    */ import mzm.gsp.grow.SSynFunctionOpenSchedule;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.LevelGuideInfo;
/*    */ import xbean.RoleLevelGuidesInfo;
/*    */ import xtable.Role2levelguide;
/*    */ 
/*    */ class PFinishFunctionOpenForecast extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int goalId;
/*    */   
/*    */   public PFinishFunctionOpenForecast(long roleId, int goalId)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.goalId = goalId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     if (!LevelGuideManager.isGoalCfgExist(this.goalId))
/*    */     {
/* 25 */       return false;
/*    */     }
/* 27 */     RoleLevelGuidesInfo xGuidesInfo = Role2levelguide.select(Long.valueOf(this.roleId));
/* 28 */     if (!LevelGuideManager.isNeedRoleFinishGoal(xGuidesInfo, this.goalId))
/*    */     {
/* 30 */       return false;
/*    */     }
/* 32 */     xGuidesInfo = Role2levelguide.get(Long.valueOf(this.roleId));
/* 33 */     if (xGuidesInfo == null)
/*    */     {
/* 35 */       return false;
/*    */     }
/* 37 */     ((LevelGuideInfo)xGuidesInfo.getTargets().get(Integer.valueOf(this.goalId))).setTargetstate(2);
/*    */     
/* 39 */     SSynFunctionOpenSchedule pro = new SSynFunctionOpenSchedule();
/* 40 */     pro.targetid = this.goalId;
/* 41 */     pro.targetstate = 2;
/* 42 */     OnlineManager.getInstance().send(this.roleId, pro);
/*    */     
/* 44 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\PFinishFunctionOpenForecast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */