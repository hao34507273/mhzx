/*    */ package mzm.gsp.team.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class JoinTeam extends mzm.event.BasicEvent<JoinTeamArg>
/*    */ {
/*  7 */   private static EventManager<JoinTeamArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<JoinTeamArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.confirm.main.POnJoinTeam());
/* 16 */     manager.register(new mzm.gsp.buff.main.POnJoinTeam());
/* 17 */     manager.register(new mzm.gsp.task.main.POnJoinTeam());
/* 18 */     manager.register(new mzm.gsp.friend.main.POnJoinTeam());
/* 19 */     manager.register(new mzm.gsp.marriage.main.POnJoinTeam());
/* 20 */     manager.register(new mzm.gsp.qingyuan.main.POnJoinTeam());
/* 21 */     manager.register(new mzm.gsp.mounts.main.POnJoinTeam());
/* 22 */     manager.register(new mzm.gsp.map.main.POnJoinTeam());
/* 23 */     manager.register(new mzm.gsp.instance.main.POnJoinTeam());
/* 24 */     manager.register(new mzm.gsp.teamplatform.match.ROnJoinTeam());
/* 25 */     manager.register(new mzm.gsp.team.main.POnJoinTeam());
/* 26 */     manager.register(new mzm.gsp.task.enterFight.POnJoinTeam());
/* 27 */     manager.register(new mzm.gsp.grow.main.POnJoinTeam());
/* 28 */     manager.register(new mzm.gsp.sworn.main.POnJoinTeam());
/* 29 */     manager.register(new mzm.gsp.ladder.main.POnJoinTeam());
/* 30 */     manager.register(new mzm.gsp.team.heart.POnJoinTeam());
/* 31 */     manager.register(new mzm.gsp.apollo.main.POnJoinTeam());
/* 32 */     manager.register(new mzm.gsp.corps.main.POnJoinTeam());
/* 33 */     manager.register(new mzm.gsp.gang.main.POnJoinTeam());
/* 34 */     manager.register(new mzm.gsp.ballbattle.main.ROnJoinTeam());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\event\JoinTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */