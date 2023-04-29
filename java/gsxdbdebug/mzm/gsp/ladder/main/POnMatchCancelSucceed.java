/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossserver.event.MatchCancelSucceedArg;
/*    */ import mzm.gsp.crossserver.event.MatchCancelSucceedProcedure;
/*    */ import mzm.gsp.crossserver.main.RoleMatchMarkingInfo;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnMatchCancelSucceed extends MatchCancelSucceedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     if (!(((MatchCancelSucceedArg)this.arg).getActivityContext() instanceof LadderMatchContext)) {
/* 20 */       return false;
/*    */     }
/* 22 */     Map<Long, String> role2Userids = new HashMap();
/* 23 */     List<Long> allRoles = new ArrayList();
/* 24 */     for (RoleMatchMarkingInfo roleMatchMarkingInfo : ((MatchCancelSucceedArg)this.arg).getRoleMatchMarkingInfos()) {
/* 25 */       long roleid = roleMatchMarkingInfo.getRoleid();
/* 26 */       String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/* 27 */       role2Userids.put(Long.valueOf(roleid), userid);
/* 28 */       allRoles.add(Long.valueOf(roleid));
/*    */     }
/* 30 */     GameServer.logger().info(String.format("[Ladder]POnMatchCancelSucceed.processImp@excuted|roleids=%s", new Object[] { allRoles }));
/*    */     
/* 32 */     lock(User.getTable(), role2Userids.values());
/* 33 */     lock(xtable.Role2properties.getTable(), role2Userids.keySet());
/*    */     
/* 35 */     LadderMatchContext ladderMatchContext = (LadderMatchContext)((MatchCancelSucceedArg)this.arg).getActivityContext();
/* 36 */     CancelMatchContext cancelMatchContext = ladderMatchContext.getCancelMatchContext();
/* 37 */     long cancelRoleid = 0L;
/* 38 */     Iterator i$; if (cancelMatchContext != null) {
/* 39 */       for (i$ = cancelMatchContext.cancelReadyRoleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 40 */         if ((roleid != ((Long)allRoles.get(0)).longValue()) && 
/* 41 */           (mzm.gsp.status.main.RoleStatusInterface.containsStatus(roleid, 43))) {
/* 42 */           LadderManager.doCancelReady(roleid, allRoles);
/*    */         }
/*    */         
/* 45 */         cancelRoleid = roleid;
/*    */       }
/*    */     }
/* 48 */     LadderManager.doUnMatch(role2Userids, allRoles, cancelRoleid, true);
/* 49 */     ladderMatchContext.setCancelMatchContext(null);
/* 50 */     LadderManager.removeCancelMatchId(allRoles);
/* 51 */     LadderManager.logMatch(allRoles, role2Userids, mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis() - ladderMatchContext.getStartTime(), 3, ((MatchCancelSucceedArg)this.arg).getContextid(), 0);
/*    */     
/*    */ 
/* 54 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\POnMatchCancelSucceed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */