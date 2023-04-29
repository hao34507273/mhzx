/*    */ package mzm.gsp.gang.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ContributionChanged extends mzm.event.BasicEvent<ContributionChangedArg>
/*    */ {
/*  7 */   private static EventManager<ContributionChangedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ContributionChangedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnContributionChanged());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\event\ContributionChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */