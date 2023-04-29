/*    */ package mzm.gsp.gang.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class JoinGangTeam extends mzm.event.BasicEvent<JoinGangTeamArg>
/*    */ {
/*  7 */   private static EventManager<JoinGangTeamArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<JoinGangTeamArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.gang.main.POnJoinGangTeam());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\event\JoinGangTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */