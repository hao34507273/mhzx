/*    */ package mzm.gsp.team.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class TeamStableStateChanged extends mzm.event.BasicEvent<mzm.gsp.team.main.TeamStableStateChangeArg>
/*    */ {
/*  7 */   private static EventManager<mzm.gsp.team.main.TeamStableStateChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<mzm.gsp.team.main.TeamStableStateChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.team.main.POnTeamStableStateChanged());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\event\TeamStableStateChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */