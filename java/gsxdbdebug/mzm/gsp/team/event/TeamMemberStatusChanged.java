/*    */ package mzm.gsp.team.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class TeamMemberStatusChanged extends mzm.event.BasicEvent<TeamMemberStatusChangedArg>
/*    */ {
/*  7 */   private static EventManager<TeamMemberStatusChangedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<TeamMemberStatusChangedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.confirm.main.POnTeamMemberStatusChanged());
/* 16 */     manager.register(new mzm.gsp.buff.main.POnTeamMemberStatusChanged());
/* 17 */     manager.register(new mzm.gsp.team.main.POnTeamMemberStatusChanged());
/* 18 */     manager.register(new mzm.gsp.instance.main.POnTeamMemberStatusChanged());
/* 19 */     manager.register(new mzm.gsp.marriage.main.POnTeamMemberStatusChanged());
/* 20 */     manager.register(new mzm.gsp.qingyuan.main.POnTeamMemberStatusChanged());
/* 21 */     manager.register(new mzm.gsp.sworn.main.POnTeamMemberStatusChanged());
/* 22 */     manager.register(new mzm.gsp.task.main.POnTeamMemberStatusChanged());
/* 23 */     manager.register(new mzm.gsp.mounts.main.POnTeamMemberStatusChanged());
/* 24 */     manager.register(new mzm.gsp.map.main.POnTeamMemberStatusChanged());
/* 25 */     manager.register(new mzm.gsp.task.enterFight.POnTeamMemberStatusChanged());
/* 26 */     manager.register(new mzm.gsp.team.changeleader.POnTeamMemberStatusChanged());
/* 27 */     manager.register(new mzm.gsp.team.changeleader.POnTeamMemberStatusChanged());
/* 28 */     manager.register(new mzm.gsp.teamplatform.match.ROnTeamMemberStatusChanged());
/* 29 */     manager.register(new mzm.gsp.scochallenge.main.POnTeamMemberStatusChanged());
/* 30 */     manager.register(new mzm.gsp.corps.main.POnTeamMemberStatusChanged());
/* 31 */     manager.register(new mzm.gsp.gang.main.POnTeamMemberStatusChanged());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\event\TeamMemberStatusChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */