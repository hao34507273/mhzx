/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.crossserver.event.JoinPointRaceFailArg;
/*    */ import mzm.gsp.crossserver.event.JoinPointRaceFailProcedure;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnJoinPointRaceFail extends JoinPointRaceFailProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     Map<Long, String> role2Userids = new HashMap();
/* 17 */     List<Long> roleids = new ArrayList();
/* 18 */     for (RolePointRaceMarkingInfo rolePointRaceMarkingInfo : ((JoinPointRaceFailArg)this.arg).getRolePointRaceMarkingInfos())
/*    */     {
/* 20 */       long roleid = rolePointRaceMarkingInfo.getRoleid();
/* 21 */       String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/* 22 */       role2Userids.put(Long.valueOf(roleid), userid);
/* 23 */       roleids.add(Long.valueOf(roleid));
/*    */     }
/* 25 */     lock(User.getTable(), role2Userids.values());
/* 26 */     lock(Basic.getTable(), role2Userids.keySet());
/*    */     
/* 28 */     int activityCfgid = ((JoinPointRaceFailArg)this.arg).getActivityCfgid();
/*    */     
/* 30 */     CrossBattlePointManager.onCrossServerFail(roleids, -7, activityCfgid);
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\POnJoinPointRaceFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */