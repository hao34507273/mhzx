/*    */ package mzm.gsp.gang.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class LeaveGangTeam extends mzm.event.BasicEvent<LeaveGangTeamArg>
/*    */ {
/*  7 */   private static EventManager<LeaveGangTeamArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<LeaveGangTeamArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.gang.main.POnLeaveGangTeam());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\event\LeaveGangTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */