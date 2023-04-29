/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GiveFlowerPoint
/*    */   extends AbstractValueChange
/*    */ {
/*    */   public int getType()
/*    */   {
/* 15 */     return 307;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 22 */     int newPoint = ItemInterface.getTotalGiveFlowerPoint(roleId, true);
/* 23 */     int oldPoint = ((Integer)xAchievementInfo.getGoal_parameters().get(0)).intValue();
/* 24 */     if (newPoint == oldPoint)
/*    */     {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     int goalPoint = ((Integer)goalParameters.get(0)).intValue();
/* 30 */     xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(Math.min(newPoint, goalPoint)));
/*    */     
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\GiveFlowerPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */