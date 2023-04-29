/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerOfflineRunnable;
/*    */ 
/*    */ public class ROnRoleRealOffline extends PlayerOfflineRunnable
/*    */ {
/*    */   public void process() throws Exception {
/*  8 */     long roleid = ((Long)this.arg).longValue();
/*  9 */     new PRoleLogOff(roleid).execute();
/* 10 */     new POnRoleRealOfflineForChatRoom(roleid).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\ROnRoleRealOffline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */