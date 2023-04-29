/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.chatbubble.main.ChatBubbleInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ public class ChatBubbleSpecificOwn
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 16 */     return 5809;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 22 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 29 */     int goalCount = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 30 */     int newCount = 0;
/* 31 */     Collection<Integer> ownBubbleIds = ChatBubbleInterface.getRoleAllChatBubbleCfgIds(roleId);
/* 32 */     for (int i = 1; i < sAchievementGoalCfg.goalParameters.size(); i++)
/*    */     {
/* 34 */       int goalBubbleId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(i)).parameter;
/* 35 */       if (ownBubbleIds.contains(Integer.valueOf(goalBubbleId)))
/*    */       {
/* 37 */         newCount++;
/*    */       }
/*    */     }
/*    */     
/* 41 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 42 */     if (newCount == oldCount)
/*    */     {
/* 44 */       return false;
/*    */     }
/*    */     
/* 47 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalCount, newCount)));
/*    */     
/* 49 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 56 */     return updateState(roleId, xAchievementInfo, sAchievementGoalCfg, null);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\ChatBubbleSpecificOwn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */