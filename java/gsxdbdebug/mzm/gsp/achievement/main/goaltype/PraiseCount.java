/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.personal.main.PersonalInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PraiseCount
/*    */   extends AbstractValueChange
/*    */ {
/*    */   public int getType()
/*    */   {
/* 20 */     return 305;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 27 */     int praiseCount = PersonalInterface.getPraisedNum(roleId, true);
/* 28 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 29 */     if (praiseCount == oldCount)
/*    */     {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     int goalCount = ((Integer)goalParameters.get(0)).intValue();
/* 35 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(praiseCount, goalCount)));
/*    */     
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\PraiseCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */