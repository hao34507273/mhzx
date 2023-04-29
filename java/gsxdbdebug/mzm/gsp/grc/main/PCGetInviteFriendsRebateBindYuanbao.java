/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCGetInviteFriendsRebateBindYuanbao
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCGetInviteFriendsRebateBindYuanbao(long roleid)
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
/* 25 */     xbean.User xUser = xtable.User.get(userid);
/* 26 */     if (xUser == null)
/*    */     {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     if (!GrcManager.canDoAction(this.roleid, 296))
/*    */     {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     if (!InviteFriendsManager.checkInviterStatus(userid, this.roleid, xUser))
/*    */     {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     return InviteFriendsManager.sendGetInviteFriendsRebateBindYuanbao(userid, this.roleid, xUser);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\PCGetInviteFriendsRebateBindYuanbao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */