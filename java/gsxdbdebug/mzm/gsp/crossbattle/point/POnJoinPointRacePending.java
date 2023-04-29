/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.crossbattle.SPointRaceReadyFail;
/*    */ import mzm.gsp.crossserver.event.JoinPointRacePendingArg;
/*    */ import mzm.gsp.crossserver.event.JoinPointRacePendingProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class POnJoinPointRacePending extends JoinPointRacePendingProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     Map<Long, String> role2Userids = new HashMap();
/* 18 */     List<Long> roleids = new ArrayList();
/* 19 */     for (RolePointRaceMarkingInfo rolePointRaceMarkingInfo : ((JoinPointRacePendingArg)this.arg).getRolePointRaceMarkingInfos())
/*    */     {
/* 21 */       long roleid = rolePointRaceMarkingInfo.getRoleid();
/* 22 */       String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/* 23 */       role2Userids.put(Long.valueOf(roleid), userid);
/* 24 */       roleids.add(Long.valueOf(roleid));
/*    */     }
/* 26 */     lock(xtable.User.getTable(), role2Userids.values());
/* 27 */     lock(Basic.getTable(), role2Userids.keySet());
/*    */     
/* 29 */     int activityCfgid = ((JoinPointRacePendingArg)this.arg).getActivityCfgid();
/* 30 */     SPointRaceReadyFail resp = new SPointRaceReadyFail();
/* 31 */     resp.retcode = -10;
/* 32 */     resp.activity_cfgid = activityCfgid;
/* 33 */     OnlineManager.getInstance().sendMulti(resp, roleids);
/*    */     
/* 35 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\POnJoinPointRacePending.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */