/*    */ package mzm.gsp.csprovider.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.event.UseActivateCardArg;
/*    */ import mzm.gsp.csprovider.event.UseActivateCardArg.ErrorCode;
/*    */ 
/*    */ public class POnUseActivateCardSuccess extends mzm.gsp.csprovider.event.UseActivateCardSuccessProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     CSProviderManager.activateUser(((UseActivateCardArg)this.arg).userId);
/*    */     
/* 13 */     GameServer.logger().info(String.format("POnUseActivateCardSuccess@use activate card success|userid=%s|card_number=%s|card_type=%d|error_code=%d", new Object[] { ((UseActivateCardArg)this.arg).userId, ((UseActivateCardArg)this.arg).cardNumber, Integer.valueOf(((UseActivateCardArg)this.arg).cardType), Integer.valueOf(((UseActivateCardArg)this.arg).errorCode.code) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\main\POnUseActivateCardSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */