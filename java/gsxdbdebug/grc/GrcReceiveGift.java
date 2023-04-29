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
/*    */ public class GrcReceiveGift
/*    */   extends __GrcReceiveGift__
/*    */ {
/*    */   protected void onServer() {}
/*    */   
/*    */   protected void onClient()
/*    */   {
/* 22 */     GrcInterface.onReceiveGiftResponse((GrcReceiveGiftArg)getArgument(), (GrcReceiveGiftRes)getResult());
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeout(int code)
/*    */   {
/* 28 */     GrcInterface.onReceiveGiftTimeout((GrcReceiveGiftArg)getArgument(), (GrcReceiveGiftRes)getResult());
/*    */   }
/*    */   
/*    */ 
/*    */   public int getType()
/*    */   {
/* 34 */     return 10006;
/*    */   }
/*    */   
/*    */   public GrcReceiveGift() {
/* 38 */     super.setArgument(new GrcReceiveGiftArg());
/* 39 */     super.setResult(new GrcReceiveGiftRes());
/*    */   }
/*    */   
/*    */   public GrcReceiveGift(GrcReceiveGiftArg argument) {
/* 43 */     super.setArgument(argument);
/* 44 */     super.setResult(new GrcReceiveGiftRes());
/*    */   }
/*    */   
/*    */   public int getTimeout() {
/* 48 */     return 30000;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcReceiveGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */