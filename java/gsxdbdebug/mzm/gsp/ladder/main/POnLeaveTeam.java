/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.event.LeaveTeamArg;
/*    */ import mzm.gsp.team.event.LeaveTeamProcedure;
/*    */ import xbean.LadderActivity;
/*    */ import xtable.Ladderactivity;
/*    */ 
/*    */ public class POnLeaveTeam extends LeaveTeamProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     LadderActivity xselectLadderActivity = Ladderactivity.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 21 */     if (xselectLadderActivity == null) {
/* 22 */       return false;
/*    */     }
/* 24 */     if (RoleStatusInterface.containsStatus(((LeaveTeamArg)this.arg).roleid, 42)) {
/* 25 */       GameServer.logger().error(String.format("[Ladder]POnLeaveTeam.processImp@match stage can not leave team|roleid=%d|teamid=%d", new Object[] { Long.valueOf(((LeaveTeamArg)this.arg).roleid), Long.valueOf(((LeaveTeamArg)this.arg).teamid) }));
/*    */       
/*    */ 
/* 28 */       List<Long> memberList = mzm.gsp.team.main.TeamInterface.getTeamMemberList(((LeaveTeamArg)this.arg).teamid, false);
/* 29 */       memberList.add(Long.valueOf(((LeaveTeamArg)this.arg).roleid));
/* 30 */       Map<Long, String> role2UserMap = new HashMap();
/* 31 */       for (Iterator i$ = memberList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 32 */         String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/* 33 */         role2UserMap.put(Long.valueOf(roleid), userid);
/*    */       }
/* 35 */       lock(xtable.User.getTable(), role2UserMap.values());
/* 36 */       lock(xtable.Role2properties.getTable(), memberList);
/* 37 */       if (LadderManager.isInCancelMatch(memberList)) {
/* 38 */         return false;
/*    */       }
/* 40 */       if (mzm.gsp.online.main.LoginManager.isInCrossServer((String)role2UserMap.get(Long.valueOf(((LeaveTeamArg)this.arg).roleid)))) {
/* 41 */         return false;
/*    */       }
/* 43 */       int cancelid = LadderManager.getNextId();
/* 44 */       CancelMatchContext cancelMatchContext = new CancelMatchContext(((LeaveTeamArg)this.arg).teamid, cancelid, Arrays.asList(new Long[] { Long.valueOf(((LeaveTeamArg)this.arg).roleid) }));
/*    */       
/* 46 */       LadderManager.tryDoUnMatch(role2UserMap, memberList, cancelMatchContext);
/*    */     }
/* 48 */     else if (RoleStatusInterface.containsStatus(((LeaveTeamArg)this.arg).roleid, 43)) {
/* 49 */       LadderManager.doCancelReady(((LeaveTeamArg)this.arg).roleid, Arrays.asList(new Long[] { Long.valueOf(((LeaveTeamArg)this.arg).roleid) }));
/*    */     }
/*    */     
/* 52 */     LadderActivity xLadderActivity = Ladderactivity.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 53 */     xLadderActivity.getRoleids().remove(Long.valueOf(((LeaveTeamArg)this.arg).roleid));
/* 54 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\POnLeaveTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */