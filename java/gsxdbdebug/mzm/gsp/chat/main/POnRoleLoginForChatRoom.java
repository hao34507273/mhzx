/*   */ package mzm.gsp.chat.main;
/*   */ 
/*   */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*   */ 
/*   */ public class POnRoleLoginForChatRoom extends PlayerLoginProcedure {
/*   */   protected boolean processImp() throws Exception {
/* 7 */     return BetacatChatRoomManager.onRoleLogin(((Long)this.arg).longValue());
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\POnRoleLoginForChatRoom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */