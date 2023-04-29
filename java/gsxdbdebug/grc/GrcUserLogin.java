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
/*    */ public class GrcUserLogin
/*    */   extends __GrcUserLogin__
/*    */ {
/*    */   protected void onServer() {}
/*    */   
/*    */   protected void onClient()
/*    */   {
/* 21 */     GrcInterface.onGrcUserLoginResponse((GrcUserLoginArg)getArgument(), (GrcUserLoginRes)getResult());
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeout(int code)
/*    */   {
/* 27 */     GrcInterface.onGrcUserLoginTimeout((GrcUserLoginArg)getArgument(), (GrcUserLoginRes)getResult());
/*    */   }
/*    */   
/*    */ 
/*    */   public int getType()
/*    */   {
/* 33 */     return 10002;
/*    */   }
/*    */   
/*    */   public GrcUserLogin() {
/* 37 */     super.setArgument(new GrcUserLoginArg());
/* 38 */     super.setResult(new GrcUserLoginRes());
/*    */   }
/*    */   
/*    */   public GrcUserLogin(GrcUserLoginArg argument) {
/* 42 */     super.setArgument(argument);
/* 43 */     super.setResult(new GrcUserLoginRes());
/*    */   }
/*    */   
/*    */   public int getTimeout() {
/* 47 */     return 30000;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcUserLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */