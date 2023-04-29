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
/*    */ 
/*    */ public class AuctionSpecificItemSuccess
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 19 */     return 1510;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 25 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 32 */     int itemCfgId = ((Integer)context).intValue();
/* 33 */     boolean isGoalItem = false;
/* 34 */     for (int i = 1; i < sAchievementGoalCfg.goalParameters.size(); i++)
/*    */     {
/* 36 */       if (((GoalParameter)sAchievementGoalCfg.goalParameters.get(i)).parameter == itemCfgId)
/*    */       {
/* 38 */         isGoalItem = true;
/*    */       }
/*    */     }
/*    */     
/* 42 */     if (!isGoalItem)
/*    */     {
/* 44 */       return false;
/*    */     }
/*    */     
/* 47 */     int oldCount = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 48 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(oldCount + 1));
/*    */     
/* 50 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\AuctionSpecificItemSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */