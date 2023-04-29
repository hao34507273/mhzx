/*    */ package grc;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GrcGetUserPlatVIPInfo
/*    */   extends __GrcGetUserPlatVIPInfo__
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
/* 32 */     return 10019;
/*    */   }
/*    */   
/*    */   public GrcGetUserPlatVIPInfo() {
/* 36 */     super.setArgument(new GrcGetUserPlatVIPInfoArg());
/* 37 */     super.setResult(new GrcGetUserPlatVIPInfoRes());
/*    */   }
/*    */   
/*    */   public GrcGetUserPlatVIPInfo(GrcGetUserPlatVIPInfoArg argument) {
/* 41 */     super.setArgument(argument);
/* 42 */     super.setResult(new GrcGetUserPlatVIPInfoRes());
/*    */   }
/*    */   
/*    */   public int getTimeout() {
/* 46 */     return 20000;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcGetUserPlatVIPInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */