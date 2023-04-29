/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.homeland.main.HomelandInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ public class HomeLevel
/*    */   extends AbstractValueChange
/*    */ {
/*    */   public int getType()
/*    */   {
/* 14 */     return 5602;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 22 */     int nowLevel = Math.max(0, HomelandInterface.getCurrentHomeLevel(roleId));
/* 23 */     int oldLevel = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 24 */     if (nowLevel == oldLevel)
/*    */     {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     int goalLevel = ((Integer)goalParameters.get(0)).intValue();
/* 30 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalLevel, nowLevel)));
/*    */     
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\HomeLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */