/*    */ package mzm.gsp.team.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class TeamCreate extends mzm.event.BasicEvent<TeamCreateArg>
/*    */ {
/*  7 */   private static EventManager<TeamCreateArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<TeamCreateArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.task.main.POnTeamCreate());
/* 16 */     manager.register(new mzm.gsp.mounts.main.POnTeamCreate());
/* 17 */     manager.register(new mzm.gsp.map.main.POnTeamCreate());
/* 18 */     manager.register(new mzm.gsp.friend.main.POnTeamCreate());
/* 19 */     manager.register(new mzm.gsp.marriage.main.POnTeamCreate());
/* 20 */     manager.register(new mzm.gsp.qingyuan.main.POnTeamCreate());
/* 21 */     manager.register(new mzm.gsp.teamplatform.match.ROnTeamCreate());
/* 22 */     manager.register(new mzm.gsp.team.changeleader.POnTeamCreate());
/* 23 */     manager.register(new mzm.gsp.grow.main.POnTeamCreate());
/* 24 */     manager.register(new mzm.gsp.ballbattle.main.ROnTeamCreate());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\event\TeamCreate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */