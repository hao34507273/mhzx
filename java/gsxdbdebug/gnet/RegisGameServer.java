/*    */ package gnet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RegisGameServer
/*    */   extends __RegisGameServer__
/*    */ {
/*    */   protected void onServer() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onClient()
/*    */   {
/* 19 */     GdeliveryHelper.onRegisGameServerRsp((RegisGameServerArg)getArgument(), (RegisGameServerRes)getResult());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void onTimeout(int code) {}
/*    */   
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 30 */     return 207;
/*    */   }
/*    */   
/*    */   public RegisGameServer() {
/* 34 */     super.setArgument(new RegisGameServerArg());
/* 35 */     super.setResult(new RegisGameServerRes());
/*    */   }
/*    */   
/*    */   public RegisGameServer(RegisGameServerArg argument) {
/* 39 */     super.setArgument(argument);
/* 40 */     super.setResult(new RegisGameServerRes());
/*    */   }
/*    */   
/*    */   public int getTimeout() {
/* 44 */     return 20000;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\RegisGameServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */