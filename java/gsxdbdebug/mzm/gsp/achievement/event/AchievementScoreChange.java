/*    */ package mzm.gsp.achievement.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class AchievementScoreChange extends mzm.event.BasicEvent<AchievementScoreChangeArg>
/*    */ {
/*  7 */   private static EventManager<AchievementScoreChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<AchievementScoreChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnAchievementScoreChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\event\AchievementScoreChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */