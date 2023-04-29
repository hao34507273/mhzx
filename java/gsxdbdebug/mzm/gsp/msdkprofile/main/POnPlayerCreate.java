/*    */ package mzm.gsp.msdkprofile.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerCreateProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class POnPlayerCreate
/*    */   extends PlayerCreateProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     long roleid = ((Long)this.arg).longValue();
/* 12 */     String userid = RoleInterface.getUserId(roleid);
/* 13 */     return MSDKProfileManager.reportRoleCreate(userid, roleid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\msdkprofile\main\POnPlayerCreate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */