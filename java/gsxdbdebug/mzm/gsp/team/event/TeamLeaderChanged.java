/*    */ package mzm.gsp.team.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class TeamLeaderChanged extends mzm.event.BasicEvent<TeamLeaderChangedArg>
/*    */ {
/*  7 */   private static EventManager<TeamLeaderChangedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<TeamLeaderChangedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.confirm.main.POnTeamLeaderChanged());
/* 16 */     manager.register(new mzm.gsp.mounts.main.POnTeamLeaderChanged());
/* 17 */     manager.register(new mzm.gsp.map.main.POnTeamLeaderChanged());
/* 18 */     manager.register(new mzm.gsp.task.main.POnTeamLeaderChanged());
/* 19 */     manager.register(new mzm.gsp.scochallenge.main.POnTeamLeaderChanged());
/* 20 */     manager.register(new mzm.gsp.ladder.main.POnTeamLeaderChanged());
/* 21 */     manager.register(new mzm.gsp.teamplatform.match.ROnTeamLeaderChanged());
/* 22 */     manager.register(new mzm.gsp.team.main.POnTeamLeaderChanged());
/* 23 */     manager.register(new mzm.gsp.task.enterFight.POnTeamLeaderChanged());
/* 24 */     manager.register(new mzm.gsp.team.changeleader.POnTeamLeaderChanged());
/* 25 */     manager.register(new mzm.gsp.corps.main.POnTeamLeaderChanged());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\event\TeamLeaderChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */