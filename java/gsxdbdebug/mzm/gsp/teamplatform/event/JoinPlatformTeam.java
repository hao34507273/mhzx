/*    */ package mzm.gsp.teamplatform.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class JoinPlatformTeam extends mzm.event.BasicEvent<JoinPlatformTeamArg>
/*    */ {
/*  7 */   private static EventManager<JoinPlatformTeamArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<JoinPlatformTeamArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\event\JoinPlatformTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */