/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.crossserver.event.PointRaceRoamRoleDataSucceedArg;
/*    */ import mzm.gsp.crossserver.event.RoamRoleDataSucceedProcedure;
/*    */ import mzm.gsp.online.main.LoginAssistManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoamRoleDataSucceed extends RoamRoleDataSucceedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     if (!(this.arg instanceof PointRaceRoamRoleDataSucceedArg))
/*    */     {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     PointRaceRoamRoleDataSucceedArg argument = (PointRaceRoamRoleDataSucceedArg)this.arg;
/*    */     
/* 26 */     Map<Long, String> roleid2Userid = new HashMap();
/* 27 */     List<Long> roleids = new ArrayList();
/* 28 */     for (RolePointRaceMarkingInfo rolePointRaceMarkingInfo : argument.getRolePointRaceMarkingInfos())
/*    */     {
/* 30 */       long roleid = rolePointRaceMarkingInfo.getRoleid();
/* 31 */       String userid = RoleInterface.getUserId(roleid);
/* 32 */       roleid2Userid.put(Long.valueOf(roleid), userid);
/* 33 */       roleids.add(Long.valueOf(roleid));
/*    */     }
/*    */     
/* 36 */     lock(User.getTable(), roleid2Userid.values());
/* 37 */     lock(xtable.Role2properties.getTable(), roleids);
/*    */     
/* 39 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */       
/* 41 */       xtable.Role2pointracecontextid.remove(Long.valueOf(roleid));
/*    */     }
/*    */     
/*    */ 
/* 45 */     long endTimeMills = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis() + TimeUnit.HOURS.toMillis(1L);
/* 46 */     for (String userid : roleid2Userid.values())
/*    */     {
/* 48 */       LoginAssistManager.getInstance().addProtectUser(userid, endTimeMills);
/*    */     }
/*    */     
/* 51 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\POnRoamRoleDataSucceed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */