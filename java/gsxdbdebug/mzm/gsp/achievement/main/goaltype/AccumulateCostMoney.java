/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.qingfu.main.QingfuInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AccumulateCostMoney
/*    */   extends AbstractConditionalDoneOneEventTimes
/*    */ {
/*    */   public int getType()
/*    */   {
/* 22 */     return 4701;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 30 */     if (((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter != 1)
/*    */     {
/* 32 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 36 */     String userId = RoleInterface.getUserId(roleId);
/* 37 */     if (null == userId)
/*    */     {
/* 39 */       return false;
/*    */     }
/* 41 */     long nowAmount = QingfuInterface.getTotalCost(userId, true) + QingfuInterface.getTotalCostBind(userId, true);
/*    */     
/*    */ 
/* 44 */     int oldAmount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 45 */     if (oldAmount == nowAmount)
/*    */     {
/* 47 */       return false;
/*    */     }
/* 49 */     int goalAmount = ((Integer)goalParameters.get(1)).intValue();
/* 50 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf((int)Math.min(goalAmount, nowAmount)));
/*    */     
/* 52 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\AccumulateCostMoney.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */