/*    */ package apollo;
/*    */ 
/*    */ import mzm.gsp.apollo.main.ApolloInterface;
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
/*    */ public class GetApolloInfo
/*    */   extends __GetApolloInfo__
/*    */ {
/*    */   protected void onServer() {}
/*    */   
/*    */   protected void onClient()
/*    */   {
/* 21 */     ApolloInterface.onGetApolloInfoRsp(this);
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeout(int code)
/*    */   {
/* 27 */     ApolloInterface.onGetApolloInfoTimeout(this);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getType()
/*    */   {
/* 33 */     return 12003;
/*    */   }
/*    */   
/*    */   public GetApolloInfo() {
/* 37 */     super.setArgument(new GetApolloInfoArg());
/* 38 */     super.setResult(new GetApolloInfoRes());
/*    */   }
/*    */   
/*    */   public GetApolloInfo(GetApolloInfoArg argument) {
/* 42 */     super.setArgument(argument);
/* 43 */     super.setResult(new GetApolloInfoRes());
/*    */   }
/*    */   
/*    */   public int getTimeout() {
/* 47 */     return 20000;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\GetApolloInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */