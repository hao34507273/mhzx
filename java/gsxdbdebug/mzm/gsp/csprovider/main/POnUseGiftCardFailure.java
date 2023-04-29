/*    */ package mzm.gsp.csprovider.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.SUseGiftCardFailed;
/*    */ import mzm.gsp.csprovider.event.UseGiftCardArg;
/*    */ import mzm.gsp.csprovider.event.UseGiftCardArg.ErrorCode;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ 
/*    */ public class POnUseGiftCardFailure extends mzm.gsp.csprovider.event.UseGiftCardFailureProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     if (((UseGiftCardArg)this.arg).errorCode == UseGiftCardArg.ErrorCode.ERROR_CARD_USED_BY_THE_ROLE) {}
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
/*    */ 
/* 26 */     SUseGiftCardFailed res = new SUseGiftCardFailed();
/* 27 */     res.reason = ((UseGiftCardArg)this.arg).errorCode.code;
/* 28 */     OnlineManager.getInstance().send(((UseGiftCardArg)this.arg).roleId, res);
/*    */     
/* 30 */     GameServer.logger().info(String.format("POnUseGiftCardFailure@use gift card failure|roleid=%d|userid=%s|card_number=%s|card_type=%d|parent_type=%d|award_id=%d|error_code=%d", new Object[] { Long.valueOf(((UseGiftCardArg)this.arg).roleId), ((UseGiftCardArg)this.arg).userId, ((UseGiftCardArg)this.arg).cardNumber, Integer.valueOf(((UseGiftCardArg)this.arg).cardType), Integer.valueOf(((UseGiftCardArg)this.arg).parentType), Integer.valueOf(((UseGiftCardArg)this.arg).awardId), Integer.valueOf(((UseGiftCardArg)this.arg).errorCode.code) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\main\POnUseGiftCardFailure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */