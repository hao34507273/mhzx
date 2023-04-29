/*    */ package openau;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DelFailureOrder
/*    */   extends __DelFailureOrder__
/*    */ {
/*    */   protected void onServer() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onClient() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onTimeout(int code) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 8905;
/*    */   }
/*    */   
/*    */   public DelFailureOrder() {
/* 36 */     super.setArgument(new DelFailureOrderArg());
/* 37 */     super.setResult(new DelFailureOrderRes());
/*    */   }
/*    */   
/*    */   public DelFailureOrder(DelFailureOrderArg argument) {
/* 41 */     super.setArgument(argument);
/* 42 */     super.setResult(new DelFailureOrderRes());
/*    */   }
/*    */   
/*    */   public int getTimeout() {
/* 46 */     return 20000;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\openau\DelFailureOrder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */