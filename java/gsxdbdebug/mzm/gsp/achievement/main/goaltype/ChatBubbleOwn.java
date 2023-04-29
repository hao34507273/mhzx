/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.chatbubble.main.ChatBubbleInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ public class ChatBubbleOwn extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 15 */     return 5808;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 21 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 28 */     int goalCount = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 29 */     int newCount = ChatBubbleInterface.getRoleAllChatBubbleCfgIds(roleId).size();
/* 30 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 31 */     if (newCount == oldCount)
/*    */     {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalCount, newCount)));
/*    */     
/* 38 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 45 */     return updateState(roleId, xAchievementInfo, sAchievementGoalCfg, null);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\ChatBubbleOwn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */