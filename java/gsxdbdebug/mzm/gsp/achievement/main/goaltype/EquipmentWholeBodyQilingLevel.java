/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EquipmentWholeBodyQilingLevel
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 21 */     return 3018;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 27 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 34 */     int nowLevel = Math.max(0, ItemInterface.getWholeBodyMinQilinLevel(ItemInterface.getRoleEquipBag(roleId)));
/* 35 */     int oldLevel = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 36 */     if (nowLevel == oldLevel)
/*    */     {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     int goalLevel = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/* 42 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalLevel, nowLevel)));
/*    */     
/* 44 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 51 */     return updateState(roleId, xAchievementInfo, sAchievementGoalCfg, null);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\EquipmentWholeBodyQilingLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */