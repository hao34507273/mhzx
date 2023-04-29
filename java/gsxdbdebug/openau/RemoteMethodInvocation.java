/*    */ package openau;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RemoteMethodInvocation
/*    */   extends __RemoteMethodInvocation__
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
/* 32 */     return 8908;
/*    */   }
/*    */   
/*    */   public RemoteMethodInvocation() {
/* 36 */     super.setArgument(new RemoteMethodInvocationArg());
/* 37 */     super.setResult(new RemoteMethodInvocationRes());
/*    */   }
/*    */   
/*    */   public RemoteMethodInvocation(RemoteMethodInvocationArg argument) {
/* 41 */     super.setArgument(argument);
/* 42 */     super.setResult(new RemoteMethodInvocationRes());
/*    */   }
/*    */   
/*    */   public int getTimeout() {
/* 46 */     return 20000;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\openau\RemoteMethodInvocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */