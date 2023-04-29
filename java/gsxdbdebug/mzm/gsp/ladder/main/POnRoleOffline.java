/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.ladder.confbean.SLadderConsts;
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xbean.LadderActivity;
/*    */ import xdb.Procedure;
/*    */ import xtable.Ladderactivity;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleOffline extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 23 */     Procedure.execute(new POffLineReport(((Long)this.arg).longValue()));
/* 24 */     if (!ActivityInterface.isActivityOpen(SLadderConsts.getInstance().activityid)) {
/* 25 */       return false;
/*    */     }
/* 27 */     LadderActivity xselectLadderActivity = Ladderactivity.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 28 */     if (xselectLadderActivity == null) {
/* 29 */       return false;
/*    */     }
/* 31 */     Long teamId = TeamInterface.getTeamidByRoleid(((Long)this.arg).longValue(), false);
/* 32 */     if (teamId == null) {
/* 33 */       return false;
/*    */     }
/* 35 */     List<Long> memberList = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/* 36 */     if (RoleStatusInterface.containsStatus(((Long)this.arg).longValue(), 42)) {
/* 37 */       Map<Long, String> role2UserMap = new HashMap();
/* 38 */       for (Iterator i$ = memberList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 39 */         String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/* 40 */         role2UserMap.put(Long.valueOf(roleid), userid);
/*    */       }
/* 42 */       lock(User.getTable(), role2UserMap.values());
/* 43 */       lock(xtable.Role2properties.getTable(), memberList);
/* 44 */       if (LadderManager.isInCancelMatch(memberList)) {
/* 45 */         return false;
/*    */       }
/* 47 */       if (mzm.gsp.online.main.LoginManager.isInCrossServer((String)role2UserMap.get(this.arg))) {
/* 48 */         return false;
/*    */       }
/* 50 */       int cancelid = LadderManager.getNextId();
/* 51 */       CancelMatchContext cancelMatchContext = new CancelMatchContext(teamId.longValue(), cancelid, Arrays.asList(new Long[] { (Long)this.arg }));
/* 52 */       LadderManager.tryDoUnMatch(role2UserMap, memberList, cancelMatchContext);
/*    */     }
/* 54 */     else if (RoleStatusInterface.containsStatus(((Long)this.arg).longValue(), 43)) {
/* 55 */       LadderManager.doCancelReady(((Long)this.arg).longValue(), memberList);
/*    */     }
/*    */     
/* 58 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\POnRoleOffline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */