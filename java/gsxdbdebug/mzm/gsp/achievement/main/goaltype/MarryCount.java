/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.marriage.main.MarriageInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MarryCount
/*    */   extends AbstractDoneOneEventTimes
/*    */ {
/*    */   public int getType()
/*    */   {
/* 19 */     return 303;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 25 */     if (!MarriageInterface.isMarried(roleId))
/*    */     {
/* 27 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 31 */     if (((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue() > 0)
/*    */     {
/* 33 */       return false;
/*    */     }
/* 35 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(1));
/*    */     
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\MarryCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */