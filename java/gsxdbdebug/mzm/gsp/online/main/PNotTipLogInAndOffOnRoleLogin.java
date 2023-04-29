/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import mzm.gsp.SSynServerNotTipSignRes;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ 
/*    */ public class PNotTipLogInAndOffOnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     RoleStatusInterface.unsetStatus(((Long)this.arg).longValue(), 411);
/* 12 */     SSynServerNotTipSignRes synServerNotTipSignRes = new SSynServerNotTipSignRes();
/* 13 */     synServerNotTipSignRes.istip = 1;
/* 14 */     OnlineManager.getInstance().send(((Long)this.arg).longValue(), synServerNotTipSignRes);
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\PNotTipLogInAndOffOnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */