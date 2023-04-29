/*    */ package grc;
/*    */ 
/*    */ import mzm.gsp.grc.main.GrcInterface;
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
/*    */ public class GrcSendGift
/*    */   extends __GrcSendGift__
/*    */ {
/*    */   protected void onServer() {}
/*    */   
/*    */   protected void onClient()
/*    */   {
/* 22 */     GrcInterface.onSendGiftResponse((GrcSendGiftArg)getArgument(), (GrcSendGiftRes)getResult());
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeout(int code)
/*    */   {
/* 28 */     GrcInterface.onSendGiftTimeout((GrcSendGiftArg)getArgument(), (GrcSendGiftRes)getResult());
/*    */   }
/*    */   
/*    */ 
/*    */   public int getType()
/*    */   {
/* 34 */     return 10005;
/*    */   }
/*    */   
/*    */   public GrcSendGift() {
/* 38 */     super.setArgument(new GrcSendGiftArg());
/* 39 */     super.setResult(new GrcSendGiftRes());
/*    */   }
/*    */   
/*    */   public GrcSendGift(GrcSendGiftArg argument) {
/* 43 */     super.setArgument(argument);
/* 44 */     super.setResult(new GrcSendGiftRes());
/*    */   }
/*    */   
/*    */   public int getTimeout() {
/* 48 */     return 30000;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcSendGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */