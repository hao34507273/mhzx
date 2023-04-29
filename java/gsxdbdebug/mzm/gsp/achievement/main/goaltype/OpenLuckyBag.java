/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OpenLuckyBag
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 18 */     return 5200;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 24 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object ctx)
/*    */   {
/* 32 */     Context context = (Context)ctx;
/* 33 */     int needType = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 34 */     if (needType != context.type)
/*    */     {
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     int oldTimes = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 40 */     int goalTimes = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 41 */     int newTimes = oldTimes + context.openNum;
/* 42 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalTimes, newTimes)));
/*    */     
/* 44 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public static class Context
/*    */   {
/*    */     public final int type;
/*    */     
/*    */     public final int openNum;
/*    */     
/*    */ 
/*    */     public Context(int type, int openNum)
/*    */     {
/* 57 */       this.type = type;
/* 58 */       this.openNum = openNum;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\OpenLuckyBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */