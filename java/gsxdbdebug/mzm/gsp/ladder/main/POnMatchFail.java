/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossserver.event.MatchFailArg;
/*    */ import mzm.gsp.crossserver.event.MatchFailProcedure;
/*    */ import mzm.gsp.crossserver.main.RoleMatchMarkingInfo;
/*    */ import mzm.gsp.ladder.SLadderCrossMatchFailRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ 
/*    */ public class POnMatchFail extends MatchFailProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     if (!(((MatchFailArg)this.arg).getActivityContext() instanceof LadderMatchContext)) {
/* 19 */       return false;
/*    */     }
/* 21 */     Map<Long, String> role2Userid = new HashMap();
/* 22 */     List<Long> roleids = new ArrayList();
/* 23 */     for (RoleMatchMarkingInfo roleMatchMarkingInfo : ((MatchFailArg)this.arg).getRoleMatchMarkingInfos()) {
/* 24 */       long roleid = roleMatchMarkingInfo.getRoleid();
/* 25 */       role2Userid.put(Long.valueOf(roleid), roleMatchMarkingInfo.getUserid());
/* 26 */       roleids.add(Long.valueOf(roleid));
/*    */     }
/* 28 */     GameServer.logger().info(String.format("[Ladder]POnMatchFail.processImp@excuted|roleids=%s", new Object[] { roleids }));
/* 29 */     lock(xtable.User.getTable(), role2Userid.values());
/* 30 */     lock(xtable.Role2properties.getTable(), roleids);
/* 31 */     LadderManager.doUnMatch(role2Userid, roleids);
/* 32 */     LadderManager.removeCancelMatchId(roleids);
/*    */     
/* 34 */     SLadderCrossMatchFailRes ladderCrossMatchFailRes = new SLadderCrossMatchFailRes();
/* 35 */     ladderCrossMatchFailRes.ret = 0;
/* 36 */     OnlineManager.getInstance().sendMulti(ladderCrossMatchFailRes, roleids);
/* 37 */     LadderManager.logMatch(roleids, role2Userid, mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis() - ((MatchFailArg)this.arg).getMatchStartTime(), 1, ((MatchFailArg)this.arg).getContextid(), 2);
/*    */     
/*    */ 
/* 40 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\POnMatchFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */