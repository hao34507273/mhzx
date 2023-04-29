/*    */ package mzm.gsp.csprovider.main;
/*    */ 
/*    */ import mzm.gsp.csprovider.event.UseGiftCardArg;
/*    */ import mzm.gsp.csprovider.event.UseGiftCardSuccessProcedure;
/*    */ 
/*    */ public class POnUseGiftCardSuccess extends UseGiftCardSuccessProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     boolean ret = CSProviderManager.awardGiftCard((UseGiftCardArg)this.arg);
/*    */     
/* 12 */     mzm.gsp.GameServer.logger().info(String.format("POnUseGiftCardSuccess@use gift card success|roleid=%d|userid=%s|card_number=%s|card_type=%d|parent_type=%d|award_id=%d|error_code=%d", new Object[] { Long.valueOf(((UseGiftCardArg)this.arg).roleId), ((UseGiftCardArg)this.arg).userId, ((UseGiftCardArg)this.arg).cardNumber, Integer.valueOf(((UseGiftCardArg)this.arg).cardType), Integer.valueOf(((UseGiftCardArg)this.arg).parentType), Integer.valueOf(((UseGiftCardArg)this.arg).awardId), Integer.valueOf(((UseGiftCardArg)this.arg).errorCode.code) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 18 */     return ret;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\main\POnUseGiftCardSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */