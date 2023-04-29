/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ class PTryAddInviteFriendsRebateBindYuanbao extends LogicProcedure
/*    */ {
/*    */   private final String userid;
/*    */   private final long roleid;
/*    */   
/*    */   PTryAddInviteFriendsRebateBindYuanbao(String userid, long roleid)
/*    */   {
/* 12 */     this.userid = userid;
/* 13 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     xbean.User xUser = xtable.User.get(this.userid);
/* 20 */     if (xUser == null)
/*    */     {
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     return InviteFriendsManager.tryAddInviteFriendsRebateBindYuanbao(this.userid, this.roleid, xUser);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\PTryAddInviteFriendsRebateBindYuanbao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */