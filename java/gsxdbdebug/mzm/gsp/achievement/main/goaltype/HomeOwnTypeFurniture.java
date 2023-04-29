/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.homeland.main.HomelandInterface;
/*    */ import mzm.gsp.item.confbean.SFurnitureItem;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HomeOwnTypeFurniture
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 24 */     return 5605;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 30 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean updateState(long roleId, AchievementInfo xAchievementInfo, SAchievementGoalCfg sAchievementGoalCfg, Object context)
/*    */   {
/* 37 */     Integer furnitureCfgId = (Integer)context;
/* 38 */     int goalStype = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/*    */     
/*    */ 
/* 41 */     if (null != furnitureCfgId)
/*    */     {
/* 43 */       SFurnitureItem sFurnitureItem = SFurnitureItem.get(furnitureCfgId.intValue());
/* 44 */       int style = sFurnitureItem.styleId;
/* 45 */       if (goalStype != style)
/*    */       {
/* 47 */         return false;
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 52 */     int nowNum = HomelandInterface.getOwnStyleFurnitureNum(roleId, Collections.singletonList(Integer.valueOf(goalStype)), true);
/* 53 */     int goalNum = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(1)).parameter;
/*    */     
/* 55 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalNum, nowNum)));
/*    */     
/* 57 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 65 */     return updateState(roleId, xAchievementInfo, sAchievementGoalCfg, null);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\HomeOwnTypeFurniture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */