/*    */ package mzm.gsp.makeup.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProtectProcedure;
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProtectProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     MakeUpManager.synAllMakeupInfo(((Long)this.arg).longValue());
/*    */     
/* 12 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\makeup\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */