/*    */ package mzm.gsp.team.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class TeamDissolve extends mzm.event.BasicEvent<TeamDissolveArg>
/*    */ {
/*  7 */   private static EventManager<TeamDissolveArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<TeamDissolveArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.confirm.main.POnTeamDissolve());
/* 16 */     manager.register(new mzm.gsp.buff.main.POnTeamDissolve());
/* 17 */     manager.register(new mzm.gsp.task.main.POnTeamDissolve());
/* 18 */     manager.register(new mzm.gsp.friend.main.POnTeamDissolve());
/* 19 */     manager.register(new mzm.gsp.marriage.main.POnTeamDissolve());
/* 20 */     manager.register(new mzm.gsp.qingyuan.main.POnTeamDissolve());
/* 21 */     manager.register(new mzm.gsp.teamplatform.match.ROnTeamDissolve());
/* 22 */     manager.register(new mzm.gsp.instance.main.POnTeamDissolve());
/* 23 */     manager.register(new mzm.gsp.sworn.main.POnTeamDissolve());
/* 24 */     manager.register(new mzm.gsp.task.enterFight.POnTeamDissolve());
/* 25 */     manager.register(new mzm.gsp.team.changeleader.POnTeamDissolve());
/* 26 */     manager.register(new mzm.gsp.competition.main.POnTeamDissolve());
/* 27 */     manager.register(new mzm.gsp.arena.main.ROnTeamDissolve());
/* 28 */     manager.register(new mzm.gsp.ladder.main.POnTeamDissolve());
/* 29 */     manager.register(new mzm.gsp.apollo.main.POnTeamDissolve());
/* 30 */     manager.register(new mzm.gsp.corps.main.POnTeamDissolve());
/* 31 */     manager.register(new mzm.gsp.lonngboatrace.main.POnTeamDissolve());
/* 32 */     manager.register(new mzm.gsp.crosscompete.roam.POnTeamDissolve());
/* 33 */     manager.register(new mzm.gsp.mounts.main.POnTeamDissolve());
/* 34 */     manager.register(new mzm.gsp.prison.main.POnTeamDissolve());
/* 35 */     manager.register(new mzm.gsp.gang.main.POnTeamDissolve());
/* 36 */     manager.register(new mzm.gsp.ballbattle.main.ROnTeamDissolve());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\event\TeamDissolve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */