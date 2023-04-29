/*    */ package mzm.gsp.friendscircle.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnReportRoleRsp extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public POnReportRoleRsp(long roleId)
/*    */   {
/* 11 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     xbean.Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getFriendsCircleInfo(this.roleId, true);
/*    */     
/* 19 */     if (xRole2FriendsCircleInfo == null)
/*    */     {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     FriendsCircleManager.repeatNoResponseReqWhenLogin(this.roleId, xRole2FriendsCircleInfo);
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\POnReportRoleRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */