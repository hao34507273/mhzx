/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.ladder.SLadderCancelReadyErrorRes;
/*    */ import mzm.gsp.ladder.SLadderUnMatchErrorRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCLadderCancelReadyReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCLadderCancelReadyReq(long roleid)
/*    */   {
/* 24 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 29 */     Long teamid = TeamInterface.getTeamidByRoleid(this.roleid, false);
/* 30 */     if (teamid == null) {
/* 31 */       GameServer.logger().info(String.format("[Ladder]PCLadderCancelReadyReq.PCLadderCancelReadyReq@not in team|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/*    */ 
/* 34 */       return false;
/*    */     }
/* 36 */     List<Long> memberList = TeamInterface.getTeamMemberList(teamid.longValue(), false);
/* 37 */     if (memberList.size() <= 0) {
/* 38 */       GameServer.logger().info(String.format("[Ladder]PCLadderCancelReadyReq.PCLadderCancelReadyReq@not in team|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/*    */ 
/* 41 */       return false;
/*    */     }
/* 43 */     if (!memberList.contains(Long.valueOf(this.roleid))) {
/* 44 */       GameServer.logger().info(String.format("[Ladder]PCLadderCancelReadyReq.PCLadderCancelReadyReq@not in team|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/*    */ 
/* 47 */       return false;
/*    */     }
/* 49 */     Map<Long, String> role2UserMap = new HashMap();
/* 50 */     for (Iterator i$ = memberList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 51 */       String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/* 52 */       role2UserMap.put(Long.valueOf(roleid), userid);
/*    */     }
/* 54 */     lock(User.getTable(), role2UserMap.values());
/* 55 */     lock(xtable.Role2properties.getTable(), memberList);
/* 56 */     Set<Integer> statuses = RoleStatusInterface.getStatusSet(this.roleid);
/* 57 */     if (!statuses.contains(Integer.valueOf(43))) {
/* 58 */       GameServer.logger().info(String.format("[Ladder]PCLadderCancelReadyReq.processImp@now is not in ready stage|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/*    */ 
/* 61 */       return false;
/*    */     }
/* 63 */     if (RoleStatusInterface.containsStatus(this.roleid, 42)) {
/* 64 */       if (LadderManager.isInCancelMatch(memberList)) {
/* 65 */         sendErrorRes(2);
/* 66 */         return false;
/*    */       }
/* 68 */       if (RoleStatusInterface.containsStatus(this.roleid, 41)) {
/* 69 */         SLadderUnMatchErrorRes ladderUnMatchErrorRes = new SLadderUnMatchErrorRes();
/* 70 */         ladderUnMatchErrorRes.ret = 1;
/* 71 */         OnlineManager.getInstance().sendAtOnce(this.roleid, ladderUnMatchErrorRes);
/* 72 */         return false;
/*    */       }
/* 74 */       int cancelid = LadderManager.getNextId();
/* 75 */       CancelMatchContext cancelMatchContext = new CancelMatchContext(teamid.longValue(), cancelid, Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/* 76 */       boolean result = LadderManager.tryDoUnMatch(role2UserMap, memberList, cancelMatchContext);
/* 77 */       if (!result) {
/* 78 */         sendErrorRes(1);
/* 79 */         return false;
/*    */       }
/*    */     } else {
/* 82 */       LadderManager.doCancelReady(this.roleid, memberList);
/*    */     }
/* 84 */     GameServer.logger().info(String.format("[Ladder]PCLadderCancelReadyReq.processImp@excute cancel success|roleid=%d|roleids=%s", new Object[] { Long.valueOf(this.roleid), memberList }));
/*    */     
/*    */ 
/* 87 */     return true;
/*    */   }
/*    */   
/*    */   private void sendErrorRes(int errorcode) {
/* 91 */     SLadderCancelReadyErrorRes ladderCancelReadyErrorRes = new SLadderCancelReadyErrorRes();
/* 92 */     ladderCancelReadyErrorRes.error = errorcode;
/* 93 */     OnlineManager.getInstance().sendAtOnce(this.roleid, ladderCancelReadyErrorRes);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\PCLadderCancelReadyReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */