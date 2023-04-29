/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.achievement.confbean.GoalParameter;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.fashiondress.main.FashionDressInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ public class FashionOwn
/*    */   extends AbstractGoalType
/*    */ {
/*    */   public int getType()
/*    */   {
/* 16 */     return 5804;
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
/* 29 */     Set<Integer> fashionTypes = FashionDressInterface.getOwnFashionDressType(roleId, true);
/*    */     
/* 31 */     if (null == fashionTypes)
/*    */     {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     int nowCount = fashionTypes.size();
/* 37 */     int goalCount = ((GoalParameter)sAchievementGoalCfg.goalParameters.get(0)).parameter;
/*    */     
/* 39 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(nowCount, goalCount)));
/*    */     
/* 41 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 48 */     return updateState(roleId, xAchievementInfo, sAchievementGoalCfg, null);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\FashionOwn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */