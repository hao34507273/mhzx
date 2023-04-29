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
/*    */ public class FightValueImprove
/*    */   extends AbstractValueChange
/*    */ {
/*    */   public int getType()
/*    */   {
/* 17 */     return 3303;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 25 */     int roleFightValue = RoleInterface.getFightValue(roleId);
/*    */     
/* 27 */     int goalFightValue = ((Integer)goalParameters.get(0)).intValue();
/* 28 */     int oldFightValue = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 29 */     if (oldFightValue == roleFightValue)
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     if (oldFightValue < roleFightValue)
/*    */     {
/* 35 */       xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalFightValue, roleFightValue)));
/*    */     }
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\FightValueImprove.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */