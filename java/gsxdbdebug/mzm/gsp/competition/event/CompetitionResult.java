/*    */ package mzm.gsp.competition.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class CompetitionResult extends mzm.event.BasicEvent<CompetitionResultArg>
/*    */ {
/*  7 */   private static EventManager<CompetitionResultArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<CompetitionResultArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.ROnCompetitionResult());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\event\CompetitionResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */