/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.crossserver.event.GenRoamTokenFailProcedure;
/*    */ import mzm.gsp.crossserver.event.PointRaceGenRoamTokenFailArg;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnGenRoamTokenFail extends GenRoamTokenFailProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     if (!(this.arg instanceof PointRaceGenRoamTokenFailArg))
/*    */     {
/* 19 */       return false;
/*    */     }
/*    */     
/* 22 */     PointRaceGenRoamTokenFailArg argument = (PointRaceGenRoamTokenFailArg)this.arg;
/*    */     
/* 24 */     List<Long> roleids = new ArrayList();
/* 25 */     Map<Long, String> roleid2Useid = new HashMap();
/* 26 */     for (RolePointRaceMarkingInfo rolePointRaceMarkingInfo : argument.getRolePointRaceMarkingInfos())
/*    */     {
/* 28 */       long roleid = rolePointRaceMarkingInfo.getRoleid();
/* 29 */       String userid = RoleInterface.getUserId(roleid);
/* 30 */       roleid2Useid.put(Long.valueOf(roleid), userid);
/* 31 */       roleids.add(Long.valueOf(roleid));
/*    */     }
/*    */     
/* 34 */     lock(User.getTable(), roleid2Useid.values());
/* 35 */     lock(Basic.getTable(), roleid2Useid.keySet());
/*    */     
/* 37 */     int activityCfgid = argument.getActivityCfgid();
/*    */     
/* 39 */     CrossBattlePointManager.onCrossServerFail(roleids, -8, activityCfgid);
/*    */     
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\POnGenRoamTokenFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */