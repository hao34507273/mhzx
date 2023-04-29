/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossserver.event.GenRoamTokenSucceedProcedure;
/*    */ import mzm.gsp.crossserver.event.LadderGenRoamTokenSucceedArg;
/*    */ import mzm.gsp.crossserver.main.RoleMatchMarkingInfo;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnGenRoamTokenSucceed extends GenRoamTokenSucceedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     if (!(this.arg instanceof LadderGenRoamTokenSucceedArg)) {
/* 16 */       return false;
/*    */     }
/*    */     
/* 19 */     LadderGenRoamTokenSucceedArg argument = (LadderGenRoamTokenSucceedArg)this.arg;
/*    */     
/* 21 */     LadderMatchContext ladderMatchContext = (LadderMatchContext)argument.getActivityContext();
/* 22 */     List<Long> allroles = new ArrayList();
/* 23 */     for (RoleMatchMarkingInfo roleMatchMarkingInfo : argument.getRoleMatchMarkingInfos()) {
/* 24 */       long roleid = roleMatchMarkingInfo.getRoleid();
/* 25 */       ladderMatchContext.putRoleProcess(roleid, 1);
/* 26 */       allroles.add(Long.valueOf(roleid));
/*    */     }
/* 28 */     GameServer.logger().info(String.format("[Ladder]POnGenRoamTokenSucceed.processImp@succeed|roleids=%s", new Object[] { allroles }));
/*    */     
/* 30 */     LadderManager.sendUpdateCrossMatchProcessInfo(argument.getRoleMatchMarkingInfos(), 1);
/*    */     
/*    */ 
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\POnGenRoamTokenSucceed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */