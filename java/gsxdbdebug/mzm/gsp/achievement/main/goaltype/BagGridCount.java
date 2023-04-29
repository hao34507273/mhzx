/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BagGridCount
/*    */   extends AbstractValueChange
/*    */ {
/*    */   public int getType()
/*    */   {
/* 15 */     return 4801;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 22 */     int nowCount = ItemInterface.getCapacity(roleId, 340600000, true);
/* 23 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 24 */     if (nowCount == oldCount)
/*    */     {
/* 26 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 30 */     int goalCount = ((Integer)goalParameters.get(0)).intValue();
/* 31 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalCount, nowCount)));
/*    */     
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\BagGridCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */