/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.shimen.event.ShimenActivityArg;
/*    */ 
/*    */ public class POnShimenActivityFinish extends mzm.gsp.shimen.event.ShimenActivityFinishedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 13 */       return false;
/*    */     }
/*    */     
/* 16 */     long roleid = ((ShimenActivityArg)this.arg).getRoleid();
/* 17 */     String userid = RoleInterface.getUserId(roleid);
/* 18 */     if (userid == null)
/*    */     {
/* 20 */       return false;
/*    */     }
/*    */     
/* 23 */     xbean.User xUser = xtable.User.get(userid);
/* 24 */     if (xUser == null)
/*    */     {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     InviteFriendsManager.statisInviteeDoneShimenTotalTimes(userid, roleid, xUser);
/*    */     
/* 31 */     InviteFriendsManager.tryAddInviteFriendsGiftTimes(userid, roleid, xUser);
/*    */     
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\POnShimenActivityFinish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */