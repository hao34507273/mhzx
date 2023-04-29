/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.personal.main.PersonalInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BePraisedCount
/*    */   extends AbstractValueChange
/*    */ {
/*    */   public int getType()
/*    */   {
/* 15 */     return 306;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 22 */     int bePraisedCount = PersonalInterface.getBePraisedNum(roleId, true);
/* 23 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 24 */     if (bePraisedCount == oldCount)
/*    */     {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     int goalCount = ((Integer)goalParameters.get(0)).intValue();
/* 30 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(bePraisedCount, goalCount)));
/*    */     
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\BePraisedCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */