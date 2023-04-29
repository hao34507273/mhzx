/*    */ package mzm.gsp.grow.LevelGuide;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.grow.SSynLevelGuideSchedule;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.LevelGuideInfo;
/*    */ import xbean.Pod;
/*    */ import xbean.RoleLevelGuidesInfo;
/*    */ import xtable.Role2levelguide;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PFinishLevelGoal
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int goalId;
/*    */   
/*    */   public PFinishLevelGoal(long roleId, int goalId)
/*    */   {
/* 23 */     this.roleId = roleId;
/* 24 */     this.goalId = goalId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     if (!LevelGuideManager.isGoalCfgExist(this.goalId))
/*    */     {
/* 32 */       return false;
/*    */     }
/* 34 */     RoleLevelGuidesInfo xGuidesInfo = Role2levelguide.select(Long.valueOf(this.roleId));
/* 35 */     if (!LevelGuideManager.isNeedRoleFinishGoal(xGuidesInfo, this.goalId))
/*    */     {
/* 37 */       return false;
/*    */     }
/* 39 */     xGuidesInfo = Role2levelguide.get(Long.valueOf(this.roleId));
/* 40 */     if (xGuidesInfo == null)
/*    */     {
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     LevelGuideInfo xInfo = (LevelGuideInfo)xGuidesInfo.getTargets().get(Integer.valueOf(this.goalId));
/* 46 */     if (xInfo == null)
/*    */     {
/* 48 */       xInfo = Pod.newLevelGuideInfo();
/* 49 */       xGuidesInfo.getTargets().put(Integer.valueOf(this.goalId), xInfo);
/*    */     }
/* 51 */     xInfo.setTargetstate(2);
/*    */     
/* 53 */     SSynLevelGuideSchedule pro = new SSynLevelGuideSchedule();
/* 54 */     pro.targetid = this.goalId;
/* 55 */     pro.targetstate = 2;
/* 56 */     OnlineManager.getInstance().send(this.roleId, pro);
/*    */     
/* 58 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\PFinishLevelGoal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */