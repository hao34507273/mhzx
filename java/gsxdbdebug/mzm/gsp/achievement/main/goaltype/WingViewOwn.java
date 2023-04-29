/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.wing.main2.RoleWingCheckData;
/*    */ import mzm.gsp.wing.main2.WingInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ public class WingViewOwn
/*    */   extends AbstractConditionalValueChange
/*    */ {
/*    */   public int getType()
/*    */   {
/* 16 */     return 3903;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 22 */     RoleWingCheckData wingCheckData = WingInterface.getRoleWingData(roleId, true);
/*    */     
/* 24 */     if (null == wingCheckData)
/*    */     {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     int goalWingId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 30 */     int newCount = wingCheckData.ownWing(goalWingId) ? 1 : 0;
/* 31 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(newCount));
/*    */     
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\WingViewOwn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */