/*    */ package mzm.gsp.msdkprofile.main;
/*    */ 
/*    */ import mzm.gsp.gang.event.GangBingingQQArg;
/*    */ import mzm.gsp.gang.event.GangBingingQQProcedure;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class POnGangBingingQQ extends GangBingingQQProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     long roleId = ((GangBingingQQArg)this.arg).bingingRoleId;
/* 13 */     long bangZhuRoleId = GangInterface.getBangZhuId(roleId);
/* 14 */     String userid = RoleInterface.getUserId(bangZhuRoleId);
/*    */     
/* 16 */     long gangId = ((GangBingingQQArg)this.arg).gangId;
/* 17 */     String qq = ((GangBingingQQArg)this.arg).QQGroup;
/*    */     
/* 19 */     return MSDKProfileManager.reportGangBindQQ(userid, bangZhuRoleId, gangId, qq);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\msdkprofile\main\POnGangBingingQQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */