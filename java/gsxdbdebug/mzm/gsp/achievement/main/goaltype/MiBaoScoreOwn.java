/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.mibao.main.MiBaoInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ public class MiBaoScoreOwn
/*    */   extends AbstractValueChange
/*    */ {
/*    */   public int getType()
/*    */   {
/* 14 */     return 5202;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 21 */     int nowScore = MiBaoInterface.getMiBaoScore(roleId, true);
/* 22 */     int oldScore = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 23 */     if (nowScore == oldScore)
/*    */     {
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     int goalScore = ((Integer)goalParameters.get(0)).intValue();
/* 29 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(nowScore, goalScore)));
/* 30 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\MiBaoScoreOwn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */