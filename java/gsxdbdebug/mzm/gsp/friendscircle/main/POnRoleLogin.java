/*    */ package mzm.gsp.friendscircle.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import xbean.Role2FriendsCircleInfo;
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/* 13 */     Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getFriendsCircleInfo(roleId, true);
/*    */     
/* 15 */     FriendsCircleManager.sSyncRoleFriendsCircleInfo(roleId, xRole2FriendsCircleInfo);
/*    */     
/*    */ 
/* 18 */     FriendsCircleManager.repairTreadRoleData(roleId, 1);
/*    */     
/* 20 */     FriendsCircleManager.repeatNoResponseReqWhenLogin(roleId, xRole2FriendsCircleInfo);
/*    */     
/* 22 */     if ((FriendsCircleManager.isFriendsCircleSwitchOpen(roleId, 451, false)) && (FriendsCircleManager.isRoleLevelFriendsCircleOpen(roleId)))
/*    */     {
/*    */ 
/*    */ 
/* 26 */       FriendsCircleManager.reportRoleInfo(roleId, null);
/*    */     }
/*    */     
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */