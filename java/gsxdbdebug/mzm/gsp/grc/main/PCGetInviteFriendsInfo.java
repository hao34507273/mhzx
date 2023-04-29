/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCGetInviteFriendsInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCGetInviteFriendsInfo(long roleid)
/*    */   {
/* 13 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     String userid = RoleInterface.getUserId(this.roleid);
/* 20 */     if (userid == null)
/*    */     {
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     if (!InviteFriendsManager.isOpenInviteFriends(this.roleid))
/*    */     {
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     if (!GrcManager.canDoAction(this.roleid, 295))
/*    */     {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     if (!InviteFriendsManager.checkInviterRoleLevel(this.roleid))
/*    */     {
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     return InviteFriendsManager.sendGetInviteFriendsInfo(userid, this.roleid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\PCGetInviteFriendsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */