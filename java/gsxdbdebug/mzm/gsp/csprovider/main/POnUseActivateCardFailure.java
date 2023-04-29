/*    */ package mzm.gsp.csprovider.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.SUseActivateCardFailed;
/*    */ import mzm.gsp.csprovider.event.UseActivateCardArg;
/*    */ import mzm.gsp.csprovider.event.UseActivateCardArg.ErrorCode;
/*    */ 
/*    */ public class POnUseActivateCardFailure extends mzm.gsp.csprovider.event.UseActivateCardFailureProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     if (((UseActivateCardArg)this.arg).errorCode == UseActivateCardArg.ErrorCode.ERROR_CARD_USED_BY_THE_USER)
/*    */     {
/* 14 */       CSProviderManager.activateUser(((UseActivateCardArg)this.arg).userId);
/*    */       
/* 16 */       GameServer.logger().info(String.format("POnUseActivateCardFailure@use activate card success|userid=%s|card_number=%s|card_type=%d|error_code=%d", new Object[] { ((UseActivateCardArg)this.arg).userId, ((UseActivateCardArg)this.arg).cardNumber, Integer.valueOf(((UseActivateCardArg)this.arg).cardType), Integer.valueOf(((UseActivateCardArg)this.arg).errorCode.code) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 21 */       return true;
/*    */     }
/*    */     
/*    */     try
/*    */     {
/* 26 */       GameServer.logger().info(String.format("POnUseActivateCardFailure@use activate card failure|userid=%s|card_number=%s|card_type=%d|error_code=%d", new Object[] { ((UseActivateCardArg)this.arg).userId, ((UseActivateCardArg)this.arg).cardNumber, Integer.valueOf(((UseActivateCardArg)this.arg).cardType), Integer.valueOf(((UseActivateCardArg)this.arg).errorCode.code) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 31 */       xio.Protocol context = UseActivateCardContextManager.getInstance().getProtocol(((UseActivateCardArg)this.arg).userId);
/* 32 */       if (context == null)
/*    */       {
/* 34 */         return true;
/*    */       }
/*    */       
/* 37 */       SUseActivateCardFailed res = new SUseActivateCardFailed();
/* 38 */       res.reason = ((UseActivateCardArg)this.arg).errorCode.code;
/* 39 */       gnet.link.Onlines.getInstance().sendResponse(context, res);
/*    */     }
/*    */     finally
/*    */     {
/* 43 */       UseActivateCardContextManager.getInstance().removeContext(((UseActivateCardArg)this.arg).userId);
/*    */     }
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\main\POnUseActivateCardFailure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */