/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import mzm.gsp.SSynServerNotTipSignRes;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ 
/*    */ public class PNotifyNotTipSign extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     SSynServerNotTipSignRes synServerNotTipSignRes = new SSynServerNotTipSignRes();
/* 12 */     if (RoleStatusInterface.containsStatus(((Long)this.arg).longValue(), 411)) {
/* 13 */       synServerNotTipSignRes.istip = 0;
/*    */     } else {
/* 15 */       synServerNotTipSignRes.istip = 1;
/*    */     }
/* 17 */     OnlineManager.getInstance().send(((Long)this.arg).longValue(), synServerNotTipSignRes);
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\PNotifyNotTipSign.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */