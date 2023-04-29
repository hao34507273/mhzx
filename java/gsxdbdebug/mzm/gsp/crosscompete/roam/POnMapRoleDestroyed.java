/*    */ package mzm.gsp.crosscompete.roam;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*    */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*    */ import mzm.gsp.map.event.MapRoleDestroyedArg;
/*    */ import mzm.gsp.map.event.MapRoleDestroyedEventProcedure;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xbean.RoamCrossCompeteFaction;
/*    */ import xbean.RoamCrossCompeteFactionTmp;
/*    */ import xbean.RoamCrossCompeteRole;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.Team;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnMapRoleDestroyed extends MapRoleDestroyedEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 25 */     if (!GameServerInfoManager.isRoamServer()) {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     long roleid = ((MapRoleDestroyedArg)this.arg).roleid;
/*    */     
/*    */ 
/* 32 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/* 33 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/*    */ 
/* 36 */     TeamInfo team = TeamInterface.getTeamInfoByRoleId(roleid);
/*    */     
/* 38 */     List<Long> lockRoles = new ArrayList();
/* 39 */     if (team != null) {
/* 40 */       lockRoles.addAll(team.getTeamMemberList());
/*    */     }
/*    */     else {
/* 43 */       lockRoles.add(Long.valueOf(roleid));
/*    */     }
/*    */     
/*    */ 
/* 47 */     lock(Basic.getTable(), lockRoles);
/*    */     
/*    */ 
/* 50 */     if (team != null) {
/* 51 */       lock(Team.getTable(), Arrays.asList(new Long[] { Long.valueOf(team.getTeamId()) }));
/*    */     }
/*    */     
/*    */ 
/* 55 */     RoamCrossCompeteRole xRole = CrossCompeteRoamManager.getXRoamCrossCompeteRole(roleid, true);
/*    */     
/*    */ 
/* 58 */     if (xRole == null) {
/* 59 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 63 */     RoamCrossCompeteFaction xFaction = CrossCompeteRoamManager.getXRoamCrossCompeteFaction(xRole.getFactionid(), true);
/*    */     
/*    */ 
/* 66 */     if (xFaction == null) {
/* 67 */       return false;
/*    */     }
/*    */     
/* 70 */     RoamCrossCompeteFactionTmp xFactionTmp = CrossCompeteRoamManager.getXRoamCrossCompeteFactionTmp(xRole.getFactionid(), true);
/*    */     
/* 72 */     if (xFactionTmp == null) {
/* 73 */       return false;
/*    */     }
/*    */     
/* 76 */     if (((MapRoleDestroyedArg)this.arg).worldid != xFactionTmp.getWorld()) {
/* 77 */       return false;
/*    */     }
/*    */     
/* 80 */     if (team != null)
/*    */     {
/*    */ 
/* 83 */       TeamInterface.leaveTeam(roleid);
/*    */     }
/*    */     
/*    */ 
/* 87 */     CrossCompeteRoamManager.leave(userid, roleid, xRole, 2);
/*    */     
/*    */ 
/* 90 */     int stage = mzm.gsp.activity.main.ActivityInterface.getActivityStage(SCrossCompeteConsts.getInstance().Activityid);
/*    */     
/*    */ 
/* 93 */     boolean syncLoadMax = !CrossCompeteManager.isPrepareStage(stage);
/* 94 */     CrossCompeteRoamManager.removeFactionPlayer(xRole.getFactionid(), xFactionTmp, Arrays.asList(new Long[] { Long.valueOf(roleid) }), syncLoadMax);
/*    */     
/*    */ 
/* 97 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\POnMapRoleDestroyed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */