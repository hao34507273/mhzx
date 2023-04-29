/*    */ package mzm.gsp.msdkprofile.main;
/*    */ 
/*    */ import mzm.gsp.gang.event.GangArg;
/*    */ import mzm.gsp.gang.event.JoinGangProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class POnJoinGang
/*    */   extends JoinGangProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     long roleid = ((GangArg)this.arg).roleId;
/* 13 */     long gangId = ((GangArg)this.arg).gangId;
/* 14 */     String userid = RoleInterface.getUserId(roleid);
/* 15 */     return MSDKProfileManager.reportGangMemberJoin(userid, roleid, gangId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\msdkprofile\main\POnJoinGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */