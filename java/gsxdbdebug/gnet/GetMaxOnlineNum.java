/*    */ package gnet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GetMaxOnlineNum
/*    */   extends __GetMaxOnlineNum__
/*    */ {
/*    */   protected void onServer() {}
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
/* 30 */     return 206;
/*    */   }
/*    */   
/*    */   public GetMaxOnlineNum() {
/* 34 */     super.setArgument(new GetMaxOnlineNumArg());
/* 35 */     super.setResult(new GetMaxOnlineNumRes());
/*    */   }
/*    */   
/*    */   public GetMaxOnlineNum(GetMaxOnlineNumArg argument) {
/* 39 */     super.setArgument(argument);
/* 40 */     super.setResult(new GetMaxOnlineNumRes());
/*    */   }
/*    */   
/*    */   public int getTimeout() {
/* 44 */     return 20000;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\GetMaxOnlineNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */