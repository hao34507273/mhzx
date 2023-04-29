/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.marriage.main.MarriageInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MarryTime
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 22 */     return 301;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 28 */     return updateState(roleId, xAchievementInfo, sAchievementGoalCfg, null);
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 34 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 42 */     long curTimeMilliSec = DateTimeUtils.getCurrTimeInMillis();
/* 43 */     long marryTimeMilliSec = MarriageInterface.getMarriedTime(roleId, false);
/* 44 */     if (marryTimeMilliSec < 0L)
/*    */     {
/* 46 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 50 */     int marryDay = (int)((curTimeMilliSec - marryTimeMilliSec) / 86400000L);
/* 51 */     int oldMarryDay = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 52 */     if (marryDay <= oldMarryDay)
/*    */     {
/* 54 */       return false;
/*    */     }
/* 56 */     int goalDay = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 57 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalDay, marryDay)));
/*    */     
/* 59 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\MarryTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */