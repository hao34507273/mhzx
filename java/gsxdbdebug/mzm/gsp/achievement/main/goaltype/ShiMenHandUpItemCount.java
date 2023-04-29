/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.task.main.TaskEventArg.TaskItemConditionInfo;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ShiMenHandUpItemCount
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 22 */     return 2410;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 28 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object ctx)
/*    */   {
/* 35 */     Context context = (Context)ctx;
/* 36 */     int limitRound = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 37 */     if (context.round > limitRound)
/*    */     {
/* 39 */       return false;
/*    */     }
/* 41 */     int oldCount = context.round == 1 ? 0 : ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 42 */     int goalItemId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/* 43 */     int addCount = 0;
/* 44 */     for (TaskEventArg.TaskItemConditionInfo info : context.itemConditionInfos)
/*    */     {
/*    */ 
/* 47 */       if ((info.getItemType() == 2) && (info.getItemCfgId() == goalItemId))
/*    */       {
/* 49 */         addCount += info.getNum();
/*    */       }
/*    */     }
/*    */     
/* 53 */     int newCount = oldCount + addCount;
/* 54 */     int goalCount = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(2)).parameter;
/* 55 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(newCount, goalCount)));
/*    */     
/* 57 */     return true;
/*    */   }
/*    */   
/*    */   public static class Context
/*    */   {
/*    */     final int round;
/*    */     final Collection<TaskEventArg.TaskItemConditionInfo> itemConditionInfos;
/*    */     
/*    */     public Context(int round, Collection<TaskEventArg.TaskItemConditionInfo> itemConditionInfos)
/*    */     {
/* 67 */       this.round = round;
/* 68 */       this.itemConditionInfos = itemConditionInfos;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\ShiMenHandUpItemCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */