/*    */ package openau;
/*    */ 
/*    */ import mzm.gsp.qingfu.main.PTransferOrder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TransferOrder
/*    */   extends __TransferOrder__
/*    */ {
/*    */   protected void onServer()
/*    */   {
/* 16 */     new PTransferOrder((TransferOrderArg)getArgument(), (TransferOrderRes)getResult()).call();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onClient() {}
/*    */   
/*    */ 
/*    */ 
/*    */   protected void onTimeout(int code) {}
/*    */   
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 8906;
/*    */   }
/*    */   
/*    */   public TransferOrder() {
/* 36 */     super.setArgument(new TransferOrderArg());
/* 37 */     super.setResult(new TransferOrderRes());
/*    */   }
/*    */   
/*    */   public TransferOrder(TransferOrderArg argument) {
/* 41 */     super.setArgument(argument);
/* 42 */     super.setResult(new TransferOrderRes());
/*    */   }
/*    */   
/*    */   public int getTimeout() {
/* 46 */     return 20000;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\openau\TransferOrder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */