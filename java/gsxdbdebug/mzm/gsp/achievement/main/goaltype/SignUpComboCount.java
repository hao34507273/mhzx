/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SignUpComboCount
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 20 */     return 2407;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 26 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 33 */     long nowTime = DateTimeUtils.getCurrTimeInMillis();
/*    */     
/*    */ 
/* 36 */     Map<Long, String> xGoalParamsExtra = xAchievementInfo.getGoal_parameters_extra();
/* 37 */     String lastSignTimeStr = (String)xGoalParamsExtra.get(Long.valueOf(0L));
/*    */     long lastSignTime;
/* 39 */     long lastSignTime; if (null == lastSignTimeStr)
/*    */     {
/* 41 */       lastSignTime = 0L;
/*    */     }
/*    */     else
/*    */     {
/* 45 */       lastSignTime = Long.parseLong(lastSignTimeStr);
/*    */     }
/*    */     
/*    */ 
/* 49 */     if (nowTime < lastSignTime)
/*    */     {
/* 51 */       return false;
/*    */     }
/*    */     int nowComboCount;
/*    */     int nowComboCount;
/* 55 */     if (DateTimeUtils.diffDays(nowTime, lastSignTime) > 1)
/*    */     {
/* 57 */       nowComboCount = 1;
/*    */     }
/*    */     else
/*    */     {
/* 61 */       int oldComboCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 62 */       nowComboCount = oldComboCount + 1;
/*    */     }
/*    */     
/* 65 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(nowComboCount));
/* 66 */     xGoalParamsExtra.put(Long.valueOf(0L), String.valueOf(nowTime));
/*    */     
/* 68 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\SignUpComboCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */