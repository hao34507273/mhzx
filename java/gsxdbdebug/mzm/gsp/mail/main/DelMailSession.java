/*    */ package mzm.gsp.mail.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DelMailSession
/*    */   extends Session
/*    */ {
/*    */   private DelMailSession(long interval, long roleId, int mailIndex)
/*    */   {
/* 20 */     super(interval, roleId);
/*    */   }
/*    */   
/*    */   protected void onTimeOut() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mail\main\DelMailSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */