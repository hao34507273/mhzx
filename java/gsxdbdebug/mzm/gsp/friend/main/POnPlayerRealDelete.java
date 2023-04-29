/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerRealDeleteProcedure;
/*    */ 
/*    */ public class POnPlayerRealDelete extends PlayerRealDeleteProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception {
/*  8 */     RoleFriend roleFriend = RoleFriendManager.getRoleFriend(((Long)this.arg).longValue(), false);
/*    */     
/* 10 */     RoleFriendManager.onPlayerTrueDelete(roleFriend);
/* 11 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\POnPlayerRealDelete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */