/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ class POnPlayerCreateForInvitee extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   POnPlayerCreateForInvitee(long roleid)
/*    */   {
/* 13 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     String userid = RoleInterface.getUserId(this.roleid);
/* 25 */     if (userid == null)
/*    */     {
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     return InviteFriendsManager.tryUseInviteCode(userid, this.roleid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\POnPlayerCreateForInvitee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */