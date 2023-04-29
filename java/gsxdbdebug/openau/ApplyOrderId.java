/*    */ package openau;
/*    */ 
/*    */ import mzm.gsp.qingfu.main.QingfuInterface;
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
/*    */ public class ApplyOrderId
/*    */   extends __ApplyOrderId__
/*    */ {
/*    */   protected void onServer() {}
/*    */   
/*    */   protected void onClient()
/*    */   {
/* 21 */     QingfuInterface.onApplyOrderAck((ApplyOrderIdArg)getArgument(), (ApplyOrderIdRes)getResult());
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeout(int code)
/*    */   {
/* 27 */     QingfuInterface.onApplyOrderTimeout((ApplyOrderIdArg)getArgument());
/*    */   }
/*    */   
/*    */ 
/*    */   public int getType()
/*    */   {
/* 33 */     return 8904;
/*    */   }
/*    */   
/*    */   public ApplyOrderId() {
/* 37 */     super.setArgument(new ApplyOrderIdArg());
/* 38 */     super.setResult(new ApplyOrderIdRes());
/*    */   }
/*    */   
/*    */   public ApplyOrderId(ApplyOrderIdArg argument) {
/* 42 */     super.setArgument(argument);
/* 43 */     super.setResult(new ApplyOrderIdRes());
/*    */   }
/*    */   
/*    */   public int getTimeout() {
/* 47 */     return 20000;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\openau\ApplyOrderId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */