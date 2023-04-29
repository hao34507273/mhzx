/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.mibao.main.MiBaoInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ public class MiBaoScoreGet
/*    */   extends AbstractDoneOneEventTimes
/*    */ {
/*    */   public int getType()
/*    */   {
/* 14 */     return 5203;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 21 */     int nowScore = MiBaoInterface.getMiBaoScore(roleId, true);
/* 22 */     int oldScore = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/*    */     
/* 24 */     if (nowScore <= oldScore)
/*    */     {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     int goalScore = ((Integer)goalParameters.get(0)).intValue();
/* 30 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(nowScore, goalScore)));
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\MiBaoScoreGet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */