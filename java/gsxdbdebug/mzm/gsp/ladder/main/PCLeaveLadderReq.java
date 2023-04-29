/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.ladder.SLeaveLadderErrorRes;
/*    */ import mzm.gsp.ladder.SLeaveLadderRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xbean.LadderActivity;
/*    */ import xtable.Ladderactivity;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCLeaveLadderReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCLeaveLadderReq(long roleid)
/*    */   {
/* 26 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 31 */     List<Long> leaveRoles = new ArrayList();
/* 32 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleid);
/* 33 */     if (teamInfo == null) {
/* 34 */       leaveRoles.add(Long.valueOf(this.roleid));
/*    */     }
/* 36 */     else if (teamInfo.getLeaderId() == this.roleid) {
/* 37 */       leaveRoles.addAll(teamInfo.getTeamMemberList());
/*    */     } else {
/* 39 */       sendErrorRes(1);
/* 40 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 44 */     Map<Long, String> role2UserMap = new HashMap();
/* 45 */     for (Iterator i$ = leaveRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 46 */       String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/* 47 */       role2UserMap.put(Long.valueOf(roleid), userid);
/*    */     }
/* 49 */     lock(User.getTable(), role2UserMap.values());
/* 50 */     lock(xtable.Role2properties.getTable(), leaveRoles);
/* 51 */     TeamInfo tempTeamInfo = TeamInterface.getTeamInfoByRoleId(this.roleid);
/* 52 */     if (tempTeamInfo != null) {
/* 53 */       List<Long> memberList = tempTeamInfo.getTeamMemberList();
/* 54 */       if ((memberList.size() != leaveRoles.size()) || (!memberList.containsAll(leaveRoles))) {
/* 55 */         sendErrorRes(2);
/* 56 */         return false;
/*    */       }
/*    */     }
/* 59 */     else if (teamInfo != null) {
/* 60 */       sendErrorRes(2);
/* 61 */       return false;
/*    */     }
/*    */     
/* 64 */     long leader = ((Long)leaveRoles.get(0)).longValue();
/* 65 */     if (RoleStatusInterface.containsStatus(leader, 42)) {
/* 66 */       sendErrorRes(4);
/* 67 */       return false;
/*    */     }
/* 69 */     if (mzm.gsp.online.main.LoginManager.isInCrossServer((String)role2UserMap.get(Long.valueOf(leader)))) {
/* 70 */       sendErrorRes(5);
/* 71 */       return false;
/*    */     }
/* 73 */     RoleStatusInterface.unsetStatus(leaveRoles, 43);
/* 74 */     long localid = mzm.gsp.GameServerInfoManager.getLocalId();
/* 75 */     LadderActivity xLadderActivity = Ladderactivity.get(Long.valueOf(localid));
/* 76 */     if (xLadderActivity != null) {
/* 77 */       xLadderActivity.getRoleids().removeAll(leaveRoles);
/*    */     }
/* 79 */     SLeaveLadderRes leaveLadderRes = new SLeaveLadderRes();
/* 80 */     OnlineManager.getInstance().sendMulti(leaveLadderRes, leaveRoles);
/* 81 */     GameServer.logger().info(String.format("[Ladder]PCLeaveLadderReq.processImp@excute leave ladder success|roleid=%d|roleids=%s", new Object[] { Long.valueOf(this.roleid), leaveRoles }));
/*    */     
/*    */ 
/* 84 */     return true;
/*    */   }
/*    */   
/*    */   private void sendErrorRes(int errorcode) {
/* 88 */     SLeaveLadderErrorRes sLeaveLadderErrorRes = new SLeaveLadderErrorRes();
/* 89 */     sLeaveLadderErrorRes.ret = errorcode;
/* 90 */     OnlineManager.getInstance().sendAtOnce(this.roleid, sLeaveLadderErrorRes);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\PCLeaveLadderReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */