/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossserver.event.MatchCancelFailArg;
/*    */ import mzm.gsp.crossserver.main.RoleMatchMarkingInfo;
/*    */ import mzm.gsp.ladder.SLadderCancelReadyErrorRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ 
/*    */ public class POnMatchCancelFail extends mzm.gsp.crossserver.event.MatchCancelFailProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     if (!(((MatchCancelFailArg)this.arg).getActivityContext() instanceof LadderMatchContext)) {
/* 16 */       return false;
/*    */     }
/* 18 */     LadderMatchContext ladderMatchContext = (LadderMatchContext)((MatchCancelFailArg)this.arg).getActivityContext();
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 24 */     ladderMatchContext.setCancelMatchContext(null);
/* 25 */     List<Long> allRoles = new ArrayList();
/* 26 */     for (RoleMatchMarkingInfo roleMatchMarkingInfo : ((MatchCancelFailArg)this.arg).getRoleMatchMarkingInfos()) {
/* 27 */       allRoles.add(Long.valueOf(roleMatchMarkingInfo.getRoleid()));
/*    */     }
/* 29 */     GameServer.logger().info(String.format("[Ladder]POnMatchCancelFail.processImp@excuted|roleids=%s", new Object[] { allRoles }));
/* 30 */     SLadderCancelReadyErrorRes ladderCancelReadyErrorRes = new SLadderCancelReadyErrorRes();
/* 31 */     ladderCancelReadyErrorRes.error = 1;
/* 32 */     OnlineManager.getInstance().sendMulti(ladderCancelReadyErrorRes, allRoles);
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\POnMatchCancelFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */