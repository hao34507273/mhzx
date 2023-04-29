/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.crossserver.event.JoinPointRaceSuccessArg;
/*    */ import mzm.gsp.online.main.CrossTokenCheckObserver;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnJoinPointRaceSuccess extends mzm.gsp.crossserver.event.JoinPointRaceSuccessProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     Map<Long, String> role2Userids = new HashMap();
/* 19 */     List<Long> roleids = new ArrayList();
/* 20 */     for (RolePointRaceMarkingInfo rolePointRaceMarkingInfo : ((JoinPointRaceSuccessArg)this.arg).getRolePointRaceMarkingInfos())
/*    */     {
/* 22 */       long roleid = rolePointRaceMarkingInfo.getRoleid();
/* 23 */       String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/* 24 */       role2Userids.put(Long.valueOf(roleid), userid);
/* 25 */       roleids.add(Long.valueOf(roleid));
/*    */     }
/*    */     
/* 28 */     lock(User.getTable(), role2Userids.values());
/* 29 */     lock(Basic.getTable(), role2Userids.keySet());
/*    */     
/*    */ 
/* 32 */     RoleStatusInterface.unsetStatus(roleids, 1441);
/* 33 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */       
/* 35 */       xtable.Role2pointracecontextid.remove(Long.valueOf(roleid));
/*    */     }
/*    */     
/*    */ 
/* 39 */     RoleStatusInterface.setStatus(roleids, 41, false);
/*    */     
/* 41 */     CrossTokenCheckObserver.createCrossTokenCheckObserver(roleids);
/*    */     
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\POnJoinPointRaceSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */