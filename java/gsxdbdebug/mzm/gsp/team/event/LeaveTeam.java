/*    */ package mzm.gsp.team.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class LeaveTeam extends mzm.event.BasicEvent<LeaveTeamArg>
/*    */ {
/*  7 */   private static EventManager<LeaveTeamArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<LeaveTeamArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.confirm.main.POnLeaveTeam());
/* 16 */     manager.register(new mzm.gsp.buff.main.POnLeaveTeam());
/* 17 */     manager.register(new mzm.gsp.task.main.POnLeaveTeam());
/* 18 */     manager.register(new mzm.gsp.mounts.main.POnLeaveTeam());
/* 19 */     manager.register(new mzm.gsp.map.main.POnLeaveTeam());
/* 20 */     manager.register(new mzm.gsp.friend.main.POnLeaveTeam());
/* 21 */     manager.register(new mzm.gsp.marriage.main.POnLeaveTeam());
/* 22 */     manager.register(new mzm.gsp.qingyuan.main.POnLeaveTeam());
/* 23 */     manager.register(new mzm.gsp.instance.main.POnLeaveTeam());
/* 24 */     manager.register(new mzm.gsp.sworn.main.POnLeaveTeam());
/* 25 */     manager.register(new mzm.gsp.teamplatform.match.ROnLeaveTeam());
/* 26 */     manager.register(new mzm.gsp.task.enterFight.POnLeaveTeam());
/* 27 */     manager.register(new mzm.gsp.team.main.POnLeaveTeam());
/* 28 */     manager.register(new mzm.gsp.team.changeleader.POnLeaveTeam());
/* 29 */     manager.register(new mzm.gsp.arena.main.POnLeaveTeam());
/* 30 */     manager.register(new mzm.gsp.competition.main.POnLeaveTeam());
/* 31 */     manager.register(new mzm.gsp.hula.main.POnLeaveTeam());
/* 32 */     manager.register(new mzm.gsp.scochallenge.main.POnLeaveTeam());
/* 33 */     manager.register(new mzm.gsp.ladder.main.POnLeaveTeam());
/* 34 */     manager.register(new mzm.gsp.apollo.main.POnLeaveTeam());
/* 35 */     manager.register(new mzm.gsp.corps.main.POnLeaveTeam());
/* 36 */     manager.register(new mzm.gsp.crosscompete.roam.POnLeaveTeam());
/* 37 */     manager.register(new mzm.gsp.prison.main.POnLeaveTeam());
/* 38 */     manager.register(new mzm.gsp.gang.main.POnLeaveTeam());
/* 39 */     manager.register(new mzm.gsp.ballbattle.main.ROnLeaveTeam());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\event\LeaveTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */