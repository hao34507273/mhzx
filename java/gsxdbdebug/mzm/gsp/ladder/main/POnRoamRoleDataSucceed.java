/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossserver.event.LadderRoamRoleDataSucceedArg;
/*    */ import mzm.gsp.crossserver.event.RoamRoleDataSucceedProcedure;
/*    */ import mzm.gsp.crossserver.main.RoleMatchMarkingInfo;
/*    */ import mzm.gsp.ladder.confbean.SLadderConsts;
/*    */ import mzm.gsp.online.main.LoginAssistManager;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoamRoleDataSucceed extends RoamRoleDataSucceedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 21 */     if (!(this.arg instanceof LadderRoamRoleDataSucceedArg)) {
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     LadderRoamRoleDataSucceedArg argument = (LadderRoamRoleDataSucceedArg)this.arg;
/*    */     
/* 27 */     Map<Long, String> roleid2Userid = new HashMap();
/* 28 */     List<Long> roleids = new ArrayList();
/* 29 */     for (RoleMatchMarkingInfo roleMatchMarkingInfo : argument.getRoleMatchMarkingInfos()) {
/* 30 */       long roleid = roleMatchMarkingInfo.getRoleid();
/* 31 */       String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/* 32 */       roleid2Userid.put(Long.valueOf(roleid), userid);
/* 33 */       roleids.add(Long.valueOf(roleid));
/*    */     }
/* 35 */     GameServer.logger().info(String.format("[Ladder]POnRoamRoleDataSucceed.processImp@excuted|roleids=%s", new Object[] { roleids }));
/*    */     
/* 37 */     lock(User.getTable(), roleid2Userid.values());
/* 38 */     lock(xtable.Role2properties.getTable(), roleids);
/* 39 */     LadderMatchContext ladderMatchContext = (LadderMatchContext)argument.getActivityContext();
/* 40 */     for (RoleMatchMarkingInfo roleMatchMarkingInfo : argument.getRoleMatchMarkingInfos()) {
/* 41 */       ladderMatchContext.putRoleProcess(roleMatchMarkingInfo.getRoleid(), 2);
/*    */     }
/*    */     
/* 44 */     LadderManager.sendUpdateCrossMatchProcessInfo(argument.getRoleMatchMarkingInfos(), 2);
/*    */     
/* 46 */     LadderManager.removeCancelMatchId(roleids);
/* 47 */     LadderManager.logMatch(roleids, roleid2Userid, DateTimeUtils.getCurrTimeInMillis() - argument.getMatchStartTime(), 0, argument.getRoamContextid(), 0);
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 52 */     long endTimeMills = DateTimeUtils.getCurrTimeInMillis() + SLadderConsts.getInstance().protectSec * 1000;
/* 53 */     for (String userid : roleid2Userid.values()) {
/* 54 */       LoginAssistManager.getInstance().addProtectUser(userid, endTimeMills);
/*    */     }
/* 56 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\POnRoamRoleDataSucceed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */