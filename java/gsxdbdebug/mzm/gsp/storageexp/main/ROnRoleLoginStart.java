/*    */ package mzm.gsp.storageexp.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginRunnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ROnRoleLoginStart
/*    */   extends PlayerLoginRunnable
/*    */ {
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 15 */     new PStartLogin(((Long)this.arg).longValue()).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\storageexp\main\ROnRoleLoginStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */