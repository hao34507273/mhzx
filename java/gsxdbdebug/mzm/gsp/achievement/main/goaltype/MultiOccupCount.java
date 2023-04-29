/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.multioccupation.main.MultiOccupInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MultiOccupCount
/*    */   extends AbstractDoneOneEventTimes
/*    */ {
/*    */   public int getType()
/*    */   {
/* 17 */     return 3304;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 24 */     int nowCount = MultiOccupInterface.getOccupCount(roleId, true);
/* 25 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 26 */     if (nowCount == oldCount)
/*    */     {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     int goalCount = ((Integer)goalParameters.get(0)).intValue();
/* 32 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalCount, nowCount)));
/*    */     
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\MultiOccupCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */