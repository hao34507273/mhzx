/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.baitan.main.BaiTanInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ExchangeBaiTanShangJiaItemNum
/*    */   extends AbstractDoneOneEventTimes
/*    */ {
/*    */   public int getType()
/*    */   {
/* 18 */     return 1507;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 26 */     int roleShangJiaCount = BaiTanInterface.getNowBaiTanShangJiaCount(roleId);
/*    */     
/* 28 */     int goalShangJiaCount = ((Integer)goalParameters.get(0)).intValue();
/* 29 */     int oldShangJiaCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 30 */     if (oldShangJiaCount == roleShangJiaCount)
/*    */     {
/* 32 */       return false;
/*    */     }
/* 34 */     if (oldShangJiaCount < roleShangJiaCount)
/*    */     {
/* 36 */       xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalShangJiaCount, roleShangJiaCount)));
/*    */     }
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\ExchangeBaiTanShangJiaItemNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */