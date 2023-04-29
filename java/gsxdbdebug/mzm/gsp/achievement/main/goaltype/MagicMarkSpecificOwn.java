/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.magicmark.main.MagicMarkInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ public class MagicMarkSpecificOwn
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 15 */     return 5801;
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
/* 28 */     int changeMagicMarkTypeId = ((Integer)context).intValue();
/* 29 */     int goalMagicMarkTypeId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 30 */     if (changeMagicMarkTypeId != goalMagicMarkTypeId)
/*    */     {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     int newCount = MagicMarkInterface.isMagicMarkAvailable(changeMagicMarkTypeId, roleId, true) ? 1 : 0;
/* 36 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(newCount));
/*    */     
/* 38 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 45 */     int goalMagicMarkTypeId = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 46 */     int newCount = MagicMarkInterface.isMagicMarkAvailable(goalMagicMarkTypeId, roleId, true) ? 1 : 0;
/* 47 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(newCount));
/* 48 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\MagicMarkSpecificOwn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */