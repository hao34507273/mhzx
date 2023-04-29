/*    */ package mzm.gsp.buff.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.team.event.JoinTeamArg;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xbean.RoleBuffList;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class POnJoinTeam extends mzm.gsp.team.event.JoinTeamProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(((JoinTeamArg)this.arg).teamid, false);
/* 15 */     if (teamInfo == null) {
/* 16 */       return false;
/*    */     }
/*    */     
/* 19 */     lock(Basic.getTable(), teamInfo.getTeamMemberList());
/* 20 */     Map<Long, java.util.List<RoleBuffList>> roleBuffListMap = BuffManager.getRoleBuffListMap(teamInfo.getTeamMemberList());
/* 21 */     if ((roleBuffListMap == null) || (roleBuffListMap.size() == 0)) {
/* 22 */       return false;
/*    */     }
/* 24 */     BuffManager.addStateBuffWithTeamInfo(roleBuffListMap, teamInfo, null);
/*    */     
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\main\POnJoinTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */