/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.crossserver.event.CrossCompeteGenRoamTokenFailArg;
/*    */ import mzm.gsp.crossserver.event.GenRoamTokenFailProcedure;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnGenRoamTokenFail
/*    */   extends GenRoamTokenFailProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     if (!(this.arg instanceof CrossCompeteGenRoamTokenFailArg)) {
/* 19 */       return false;
/*    */     }
/*    */     
/* 22 */     CrossCompeteGenRoamTokenFailArg failArg = (CrossCompeteGenRoamTokenFailArg)this.arg;
/*    */     
/* 24 */     List<String> users = new ArrayList();
/* 25 */     List<Long> roles = new ArrayList();
/*    */     
/* 27 */     for (EnterRole roamRole : failArg.context.roamRoles) {
/* 28 */       users.add(roamRole.getUserid());
/* 29 */       roles.add(Long.valueOf(roamRole.getRoleid()));
/*    */     }
/*    */     
/*    */ 
/* 33 */     lock(User.getTable(), users);
/* 34 */     lock(Basic.getTable(), roles);
/*    */     
/* 36 */     CrossCompeteManager.crossRoamServerFail(roles, 11);
/*    */     
/* 38 */     CrossCompeteManager.logError("POnGenRoamTokenFail.processImp@gen roam token failed|factionid=%d|roles=%s|roam_serverid=%d", new Object[] { Long.valueOf(failArg.context.factionid), roles, Integer.valueOf(failArg.context.roamServerid) });
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\POnGenRoamTokenFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */