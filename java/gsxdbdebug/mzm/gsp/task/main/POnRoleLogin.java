/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     if (this.arg == null)
/*    */     {
/* 11 */       return false;
/*    */     }
/* 13 */     new TaskInitProcedure(((Long)this.arg).longValue()).execute();
/* 14 */     new mzm.gsp.task.ban.POnRoleLogin(((Long)this.arg).longValue()).execute();
/*    */     
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */