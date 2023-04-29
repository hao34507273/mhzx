/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoleLevelUp
/*    */   extends AbstractValueChange
/*    */ {
/*    */   public int getType()
/*    */   {
/* 17 */     return 4500;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 25 */     int roleLevel = RoleInterface.getLevel(roleId);
/*    */     
/* 27 */     int goalLevel = ((Integer)goalParameters.get(0)).intValue();
/* 28 */     int oldLevel = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 29 */     if (oldLevel == roleLevel)
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     if (oldLevel < roleLevel)
/*    */     {
/* 35 */       xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalLevel, roleLevel)));
/*    */     }
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\RoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */