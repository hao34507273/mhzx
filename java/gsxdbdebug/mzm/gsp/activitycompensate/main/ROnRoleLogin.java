/*    */ package mzm.gsp.activitycompensate.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginRunnable;
/*    */ 
/*    */ 
/*    */ public class ROnRoleLogin
/*    */   extends PlayerLoginRunnable
/*    */ {
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 12 */     long roleid = ((Long)this.arg).longValue();
/*    */     
/*    */ 
/* 15 */     new RRefreshRoleCompensates(roleid).run();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitycompensate\main\ROnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */