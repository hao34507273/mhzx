/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.zhenfa.main.ZhenfaInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class StudyZhenFa
/*    */   extends AbstractDoneOneEventTimes
/*    */ {
/*    */   public int getType()
/*    */   {
/* 18 */     return 4900;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 26 */     int roleStudyNum = ZhenfaInterface.getZhenFaCount(roleId);
/*    */     
/* 28 */     int goalStudyNum = ((Integer)goalParameters.get(0)).intValue();
/* 29 */     int oldStudyNum = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 30 */     if (oldStudyNum == roleStudyNum)
/*    */     {
/* 32 */       return false;
/*    */     }
/* 34 */     if (oldStudyNum < roleStudyNum)
/*    */     {
/* 36 */       xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalStudyNum, roleStudyNum)));
/*    */     }
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\StudyZhenFa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */