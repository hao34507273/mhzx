/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.ladder.SLadderUnMatchErrorRes;
/*    */ import mzm.gsp.online.main.LoginManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCLadderUnMatchReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCLadderUnMatchReq(long roleid)
/*    */   {
/* 22 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 27 */     Long teamid = TeamInterface.getTeamidByRoleid(this.roleid, false);
/* 28 */     if (teamid == null) {
/* 29 */       GameServer.logger().info(String.format("[Ladder]PCLadderUnMatchReq@not in team|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/* 30 */       return false;
/*    */     }
/* 32 */     List<Long> memberList = TeamInterface.getTeamMemberList(teamid.longValue(), false);
/* 33 */     if (memberList.size() <= 0) {
/* 34 */       GameServer.logger().info(String.format("[Ladder]PCLadderUnMatchReq@not in team|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/* 35 */       return false;
/*    */     }
/* 37 */     if (!memberList.contains(Long.valueOf(this.roleid))) {
/* 38 */       GameServer.logger().info(String.format("[Ladder]PCLadderUnMatchReq@not in team|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/* 39 */       return false;
/*    */     }
/* 41 */     Map<Long, String> role2UserMap = new HashMap();
/* 42 */     for (Iterator i$ = memberList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 43 */       String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/* 44 */       role2UserMap.put(Long.valueOf(roleid), userid);
/*    */     }
/* 46 */     lock(User.getTable(), role2UserMap.values());
/* 47 */     lock(xtable.Role2properties.getTable(), memberList);
/* 48 */     List<Long> trulyMemberList = TeamInterface.getTeamMemberList(teamid.longValue(), true);
/* 49 */     if ((trulyMemberList.size() != memberList.size()) || (!memberList.containsAll(trulyMemberList))) {
/* 50 */       GameServer.logger().info(String.format("[Ladder]PCLadderUnMatchReq@not in team|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/* 51 */       return false;
/*    */     }
/* 53 */     List<Long> normalList = TeamInterface.getNormalRoleList(this.roleid);
/*    */     
/* 55 */     if (normalList.size() != trulyMemberList.size()) {
/* 56 */       GameServer.logger().info(String.format("[Ladder]PCLadderUnMatchReq@team role changed|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/* 57 */       return false;
/*    */     }
/* 59 */     if (LadderManager.isInCancelMatch(normalList)) {
/* 60 */       sendErrorRes(3);
/* 61 */       return false;
/*    */     }
/* 63 */     if (LoginManager.isInCrossServer((String)role2UserMap.get(Long.valueOf(this.roleid)))) {
/* 64 */       sendErrorRes(1);
/* 65 */       return false;
/*    */     }
/* 67 */     int cancelid = LadderManager.getNextId();
/* 68 */     CancelMatchContext cancelMatchContext = new CancelMatchContext(teamid.longValue(), cancelid, Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/* 69 */     boolean result = LadderManager.tryDoUnMatch(role2UserMap, memberList, cancelMatchContext);
/* 70 */     if (!result) {
/* 71 */       sendErrorRes(1);
/* 72 */       return false;
/*    */     }
/* 74 */     GameServer.logger().info(String.format("[Ladder]PCLadderUnMatchReq.processImp@excute unmatch success|roleid=%d|roleids=%s", new Object[] { Long.valueOf(this.roleid), memberList }));
/*    */     
/*    */ 
/* 77 */     return true;
/*    */   }
/*    */   
/*    */   private void sendErrorRes(int error) {
/* 81 */     SLadderUnMatchErrorRes ladderUnMatchErrorRes = new SLadderUnMatchErrorRes();
/* 82 */     ladderUnMatchErrorRes.ret = error;
/* 83 */     OnlineManager.getInstance().sendAtOnce(this.roleid, ladderUnMatchErrorRes);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\PCLadderUnMatchReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */