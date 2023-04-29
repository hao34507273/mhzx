/*    */ package mzm.gsp.friendscircle.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProtectProcedure;
/*    */ 
/*    */ public class POnRoleProtectLogin extends PlayerLoginProtectProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/* 11 */     xbean.Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getFriendsCircleInfo(roleId, true);
/*    */     
/* 13 */     FriendsCircleManager.sSyncRoleFriendsCircleInfo(roleId, xRole2FriendsCircleInfo);
/*    */     
/* 15 */     FriendsCircleManager.repeatNoResponseReqWhenLogin(roleId, xRole2FriendsCircleInfo);
/*    */     
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\POnRoleProtectLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */