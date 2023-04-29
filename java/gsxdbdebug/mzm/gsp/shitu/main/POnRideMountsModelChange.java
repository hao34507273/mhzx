/*    */ package mzm.gsp.shitu.main;
/*    */ 
/*    */ import mzm.gsp.mounts.event.RideMountsModelChangeArg;
/*    */ 
/*    */ public class POnRideMountsModelChange extends mzm.gsp.mounts.event.RideMountsModelChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     ShiTuManager.synShiTuRoleInfoChange(((RideMountsModelChangeArg)this.arg).getRoleId());
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\POnRideMountsModelChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */