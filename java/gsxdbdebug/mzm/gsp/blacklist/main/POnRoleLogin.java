/*    */ package mzm.gsp.blacklist.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ 
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 12 */     return new PBlackListReq(((Long)this.arg).longValue()).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\blacklist\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */