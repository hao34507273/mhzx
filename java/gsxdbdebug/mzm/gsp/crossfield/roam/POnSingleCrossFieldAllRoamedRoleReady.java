/*    */ package mzm.gsp.crossfield.roam;
/*    */ 
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldAllRoamedRoleReadyArg;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldAllRoamedRoleReadyProcedure;
/*    */ import mzm.gsp.crossserver.main.SingleCrossFieldRoamedContext;
/*    */ 
/*    */ 
/*    */ public class POnSingleCrossFieldAllRoamedRoleReady
/*    */   extends SingleCrossFieldAllRoamedRoleReadyProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 14 */     SingleCrossFieldRoamedContextManager.getInstance().putKeys(((SingleCrossFieldAllRoamedRoleReadyArg)this.arg).context.getRoleids(), ((SingleCrossFieldAllRoamedRoleReadyArg)this.arg).context);
/* 15 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\roam\POnSingleCrossFieldAllRoamedRoleReady.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */