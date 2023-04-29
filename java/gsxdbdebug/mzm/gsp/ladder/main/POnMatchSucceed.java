/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossserver.event.MatchSucceedArg;
/*    */ import mzm.gsp.crossserver.main.RoleMatchMarkingInfo;
/*    */ import mzm.gsp.ladder.RoleLadderCrossMatchInfo;
/*    */ import mzm.gsp.ladder.SLadderCrossMatchRoleInfo;
/*    */ import mzm.gsp.online.main.CrossTokenCheckObserver;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.LadderActivity;
/*    */ import xtable.Ladderactivity;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnMatchSucceed extends mzm.gsp.crossserver.event.MatchSucceedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 23 */     if (!(((MatchSucceedArg)this.arg).getActivityContext() instanceof LadderMatchContext)) {
/* 24 */       return false;
/*    */     }
/*    */     
/* 27 */     Map<Long, String> roleid2Userid = new HashMap();
/* 28 */     List<Long> roleids = new ArrayList();
/* 29 */     for (RoleMatchMarkingInfo roleMatchMarkingInfo : ((MatchSucceedArg)this.arg).getRoleMatchMarkingInfos()) {
/* 30 */       long roleid = roleMatchMarkingInfo.getRoleid();
/* 31 */       String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/* 32 */       roleid2Userid.put(Long.valueOf(roleid), userid);
/* 33 */       roleids.add(Long.valueOf(roleid));
/*    */     }
/* 35 */     GameServer.logger().info(String.format("[Ladder]POnMatchSucceed.processImp@excuted|roleids=%s", new Object[] { roleids }));
/* 36 */     lock(User.getTable(), roleid2Userid.values());
/* 37 */     lock(xtable.Role2properties.getTable(), roleid2Userid.keySet());
/*    */     
/* 39 */     mzm.gsp.status.main.RoleStatusInterface.setStatus(roleids, 41, false);
/* 40 */     CrossTokenCheckObserver.createCrossTokenCheckObserver(roleids);
/*    */     
/* 42 */     LadderManager.doUnMatch(roleid2Userid, roleids, 0L, false);
/* 43 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 44 */       LadderManager.doCancelReady(roleid);
/*    */     }
/* 46 */     long localid = mzm.gsp.GameServerInfoManager.getLocalId();
/* 47 */     LadderActivity xLadderActivity = Ladderactivity.get(Long.valueOf(localid));
/* 48 */     if (xLadderActivity != null) {
/* 49 */       xLadderActivity.getRoleids().removeAll(roleids);
/*    */     }
/* 51 */     LadderMatchContext ladderMatchContext = (LadderMatchContext)((MatchSucceedArg)this.arg).getActivityContext();
/* 52 */     SLadderCrossMatchRoleInfo ladderCrossMatchRoleInfo = new SLadderCrossMatchRoleInfo();
/* 53 */     for (RoleMatchMarkingInfo roleMatchMarkingInfo : ((MatchSucceedArg)this.arg).getRoleMatchMarkingInfos()) {
/* 54 */       RoleLadderCrossMatchInfo roleLadderCrossMatchInfo = new RoleLadderCrossMatchInfo();
/* 55 */       LadderInterface.fillLadderCrossMatchInfo(roleLadderCrossMatchInfo, roleMatchMarkingInfo, 0);
/*    */       
/* 57 */       ladderCrossMatchRoleInfo.matchteamainfos.add(roleLadderCrossMatchInfo);
/* 58 */       ladderMatchContext.putRoleProcess(roleMatchMarkingInfo.getRoleid(), 0);
/*    */     }
/*    */     
/* 61 */     for (RoleMatchMarkingInfo roleMatchMarkingInfo : ((MatchSucceedArg)this.arg).getOpponentRoleMatchMarkingInfos()) {
/* 62 */       RoleLadderCrossMatchInfo roleLadderCrossMatchInfo = new RoleLadderCrossMatchInfo();
/* 63 */       LadderInterface.fillLadderCrossMatchInfo(roleLadderCrossMatchInfo, roleMatchMarkingInfo, 0);
/*    */       
/* 65 */       ladderCrossMatchRoleInfo.matchteambinfos.add(roleLadderCrossMatchInfo);
/* 66 */       ladderMatchContext.putRoleProcess(roleMatchMarkingInfo.getRoleid(), 0);
/*    */     }
/* 68 */     OnlineManager.getInstance().sendMulti(ladderCrossMatchRoleInfo, roleids);
/* 69 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\POnMatchSucceed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */