/*    */ package mzm.gsp.friendscircle.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerUnForbidTalkProcedure;
/*    */ 
/*    */ public class POnPlayerUnForbidTalk
/*    */   extends PlayerUnForbidTalkProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 11 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/* 13 */     if (!FriendsCircleManager.isRoleLevelFriendsCircleOpen(roleId))
/*    */     {
/* 15 */       return false;
/*    */     }
/*    */     
/* 18 */     if (!FriendsCircleManager.isFriendsCircleSwitchOpen(roleId, 451, false))
/*    */     {
/* 20 */       return false;
/*    */     }
/*    */     
/* 23 */     FriendsCircleManager.reportRoleStatusInfo(roleId);
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\POnPlayerUnForbidTalk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */