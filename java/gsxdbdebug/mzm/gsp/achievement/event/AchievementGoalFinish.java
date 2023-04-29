/*    */ package mzm.gsp.achievement.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class AchievementGoalFinish extends mzm.event.BasicEvent<AchievementGoalFinishArg>
/*    */ {
/*  7 */   private static EventManager<AchievementGoalFinishArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<AchievementGoalFinishArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.task.surprise.PAchievementGoalFinish());
/* 16 */     manager.register(new mzm.gsp.achievement.main.POnAchievementGoalFinish());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\event\AchievementGoalFinish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */