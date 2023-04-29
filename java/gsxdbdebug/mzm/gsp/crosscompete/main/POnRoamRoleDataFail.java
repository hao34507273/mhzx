/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.crossserver.event.CrossCompeteRoamRoleDataFailArg;
/*    */ import mzm.gsp.crossserver.event.RoamRoleDataFailProcedure;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoamRoleDataFail
/*    */   extends RoamRoleDataFailProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     if (!(this.arg instanceof CrossCompeteRoamRoleDataFailArg)) {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     CrossCompeteRoamRoleDataFailArg failArg = (CrossCompeteRoamRoleDataFailArg)this.arg;
/*    */     
/* 26 */     List<String> users = new ArrayList();
/* 27 */     List<Long> roles = new ArrayList();
/*    */     
/* 29 */     for (EnterRole roamRole : failArg.context.roamRoles) {
/* 30 */       users.add(roamRole.getUserid());
/* 31 */       roles.add(Long.valueOf(roamRole.getRoleid()));
/*    */     }
/*    */     
/*    */ 
/* 35 */     lock(User.getTable(), users);
/* 36 */     lock(Basic.getTable(), roles);
/*    */     
/*    */ 
/* 39 */     RoleStatusInterface.unsetStatus(roles, 1501);
/*    */     
/* 41 */     CrossCompeteManager.crossRoamServerFail(roles, 12);
/*    */     
/* 43 */     CrossCompeteManager.logError("POnRoamRoleDataFail.processImp@roam role data failed|factionid=%d|roles=%s|roam_serverid=%d", new Object[] { Long.valueOf(failArg.context.factionid), roles, Integer.valueOf(failArg.context.roamServerid) });
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 50 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\POnRoamRoleDataFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */