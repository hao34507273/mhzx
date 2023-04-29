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
/*    */ public class GrcReceiveAllGift
/*    */   extends __GrcReceiveAllGift__
/*    */ {
/*    */   protected void onServer() {}
/*    */   
/*    */   protected void onClient()
/*    */   {
/* 22 */     GrcInterface.onReceiveAllGiftResponse((GrcReceiveAllGiftArg)getArgument(), (GrcReceiveAllGiftRes)getResult());
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeout(int code)
/*    */   {
/* 28 */     GrcInterface.onReceiveAllGiftTimeout((GrcReceiveAllGiftArg)getArgument(), (GrcReceiveAllGiftRes)getResult());
/*    */   }
/*    */   
/*    */ 
/*    */   public int getType()
/*    */   {
/* 34 */     return 10043;
/*    */   }
/*    */   
/*    */   public GrcReceiveAllGift() {
/* 38 */     super.setArgument(new GrcReceiveAllGiftArg());
/* 39 */     super.setResult(new GrcReceiveAllGiftRes());
/*    */   }
/*    */   
/*    */   public GrcReceiveAllGift(GrcReceiveAllGiftArg argument) {
/* 43 */     super.setArgument(argument);
/* 44 */     super.setResult(new GrcReceiveAllGiftRes());
/*    */   }
/*    */   
/*    */   public int getTimeout() {
/* 48 */     return 30000;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcReceiveAllGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */