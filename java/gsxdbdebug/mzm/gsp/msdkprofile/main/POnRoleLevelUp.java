/*    */ package mzm.gsp.msdkprofile.main;
/*    */ 
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import mzm.gsp.role.event.RoleLevelUpProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class POnRoleLevelUp extends RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     long roleid = ((RoleLevelUpArg)this.arg).roleId;
/* 12 */     String userid = RoleInterface.getUserId(roleid);
/* 13 */     int newLevel = ((RoleLevelUpArg)this.arg).newLevel;
/* 14 */     return MSDKProfileManager.reportRoleLevel(userid, roleid, newLevel);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\msdkprofile\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */