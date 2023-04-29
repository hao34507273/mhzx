/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GangJoin
/*    */   extends AbstractDoneOneEventTimes
/*    */ {
/*    */   public int getType()
/*    */   {
/* 17 */     return 900;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 25 */     if (GangInterface.getGangId(roleId) > 0L)
/*    */     {
/* 27 */       xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(1));
/* 28 */       return true;
/*    */     }
/* 30 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\GangJoin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */