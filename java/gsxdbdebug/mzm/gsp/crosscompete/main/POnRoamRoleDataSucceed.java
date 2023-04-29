/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.crossserver.event.CrossCompeteRoamRoleDataSucceedArg;
/*    */ import mzm.gsp.crossserver.event.RoamRoleDataSucceedProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoamRoleDataSucceed
/*    */   extends RoamRoleDataSucceedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 16 */     if (!(this.arg instanceof CrossCompeteRoamRoleDataSucceedArg)) {
/* 17 */       return false;
/*    */     }
/*    */     
/* 20 */     CrossCompeteRoamRoleDataSucceedArg succeedArg = (CrossCompeteRoamRoleDataSucceedArg)this.arg;
/*    */     
/* 22 */     List<Long> roles = succeedArg.context.getRoleidList();
/*    */     
/*    */ 
/*    */ 
/* 26 */     CrossCompeteManager.logInfo("POnRoamRoleDataSucceed.processImp@cross compete roam role data succeed|factionid=%d|roles=%s|roam_serverid=%d", new Object[] { Long.valueOf(succeedArg.context.factionid), roles, Integer.valueOf(succeedArg.getRoamZoneid()) });
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\POnRoamRoleDataSucceed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */