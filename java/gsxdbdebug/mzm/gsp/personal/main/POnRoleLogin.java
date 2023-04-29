/*    */ package mzm.gsp.personal.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.online.event.PlayerLoginRunnable;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 10 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 12 */       return;
/*    */     }
/*    */     
/* 15 */     ActiveRoleIdLRU.getInstance().add(((Long)this.arg).longValue());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */