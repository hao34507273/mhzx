/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.wing.main2.RoleWingCheckData;
/*    */ import mzm.gsp.wing.main2.WingInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WingShengji
/*    */   extends AbstractValueChange
/*    */ {
/*    */   public int getType()
/*    */   {
/* 20 */     return 3901;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 28 */     RoleWingCheckData roleWingCheckData = WingInterface.getRoleWingData(roleId, true);
/* 29 */     if (roleWingCheckData == null)
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     int roleWingLevel = roleWingCheckData.getCurLv();
/*    */     
/* 35 */     int goalWingLevel = ((Integer)goalParameters.get(0)).intValue();
/* 36 */     int oldWingLevel = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 37 */     if (oldWingLevel == roleWingLevel)
/*    */     {
/* 39 */       return false;
/*    */     }
/* 41 */     if (oldWingLevel < roleWingLevel)
/*    */     {
/* 43 */       xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(goalWingLevel, roleWingLevel)));
/*    */     }
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\WingShengji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */