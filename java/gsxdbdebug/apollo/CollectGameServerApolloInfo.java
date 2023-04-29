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
/*    */ public class CollectGameServerApolloInfo
/*    */   extends __CollectGameServerApolloInfo__
/*    */ {
/*    */   protected void onServer()
/*    */   {
/* 16 */     ApolloInterface.onCollectGameServerApolloInfoReq((CollectGameServerApolloInfoArg)getArgument(), (CollectGameServerApolloInfoRes)getResult());
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
/* 32 */     return 12009;
/*    */   }
/*    */   
/*    */   public CollectGameServerApolloInfo() {
/* 36 */     super.setArgument(new CollectGameServerApolloInfoArg());
/* 37 */     super.setResult(new CollectGameServerApolloInfoRes());
/*    */   }
/*    */   
/*    */   public CollectGameServerApolloInfo(CollectGameServerApolloInfoArg argument) {
/* 41 */     super.setArgument(argument);
/* 42 */     super.setResult(new CollectGameServerApolloInfoRes());
/*    */   }
/*    */   
/*    */   public int getTimeout() {
/* 46 */     return 20000;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\CollectGameServerApolloInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */