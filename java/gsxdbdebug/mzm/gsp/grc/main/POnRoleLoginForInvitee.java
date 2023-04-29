/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ class POnRoleLoginForInvitee extends LogicProcedure
/*    */ {
/*    */   private final String userid;
/*    */   private final long roleid;
/*    */   
/*    */   public POnRoleLoginForInvitee(String userid, long roleid)
/*    */   {
/* 12 */     this.userid = userid;
/* 13 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     return InviteFriendsManager.tryUseInviteCode(this.userid, this.roleid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\POnRoleLoginForInvitee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */