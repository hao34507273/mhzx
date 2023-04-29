/*    */ package mzm.gsp.gang.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GangTeamCreated extends mzm.event.BasicEvent<GangTeamCreatedArg>
/*    */ {
/*  7 */   private static EventManager<GangTeamCreatedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GangTeamCreatedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\event\GangTeamCreated.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */