/*    */ package mzm.gsp.msdkprofile.main;
/*    */ 
/*    */ import mzm.gsp.gang.event.RoleChangeGangByCombineArg;
/*    */ import mzm.gsp.gang.event.RoleChangeGangByCombineProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class POnRoleChangeGangByCombine extends RoleChangeGangByCombineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     long roleid = ((RoleChangeGangByCombineArg)this.arg).roleid;
/* 12 */     long oldGangId = ((RoleChangeGangByCombineArg)this.arg).oldGangid;
/* 13 */     long newGangId = ((RoleChangeGangByCombineArg)this.arg).newGangid;
/* 14 */     String userid = RoleInterface.getUserId(roleid);
/* 15 */     if (MSDKProfileManager.reportGangMemberExit(userid, roleid, oldGangId))
/*    */     {
/* 17 */       if (((RoleChangeGangByCombineArg)this.arg).isOldLeader())
/*    */       {
/* 19 */         MSDKProfileManager.reportGangDestory(userid, roleid, oldGangId);
/*    */       }
/* 21 */       return MSDKProfileManager.reportGangMemberJoin(userid, roleid, newGangId);
/*    */     }
/*    */     
/*    */ 
/* 25 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\msdkprofile\main\POnRoleChangeGangByCombine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */