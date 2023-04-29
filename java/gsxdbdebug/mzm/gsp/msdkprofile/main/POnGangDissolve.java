/*    */ package mzm.gsp.msdkprofile.main;
/*    */ 
/*    */ import mzm.gsp.gang.event.GangArg;
/*    */ import mzm.gsp.gang.event.GangDissolveProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class POnGangDissolve
/*    */   extends GangDissolveProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 13 */     long roleid = ((GangArg)this.arg).roleId;
/* 14 */     long gangId = ((GangArg)this.arg).gangId;
/* 15 */     String userid = RoleInterface.getUserId(roleid);
/* 16 */     return MSDKProfileManager.reportGangDestory(userid, roleid, gangId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\msdkprofile\main\POnGangDissolve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */