/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.online.event.PlayerCreateRunnable;
/*    */ 
/*    */ public class ROnPlayerCreate extends PlayerCreateRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 10 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 12 */       return;
/*    */     }
/*    */     
/* 15 */     new POnPlayerCreateForInvitee(((Long)this.arg).longValue()).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\ROnPlayerCreate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */